package com.nucleus.service.bulkuploadservices;

import com.nucleus.dao.bulkuploaddao.CriteriaBulkUploadDao;
import com.nucleus.dto.CriteriaDTO;
import com.nucleus.utility.ExcelHandler;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CriteriaBulkUploadService {

    private final CriteriaBulkUploadDao criteriaBulkUploadDao;
    private final ExcelHandler excelHandler;
    private final Logger logger;

    @Autowired
    public CriteriaBulkUploadService(CriteriaBulkUploadDao criteriaBulkUploadDao, ExcelHandler excelHandler, Logger logger) {
        this.criteriaBulkUploadDao = criteriaBulkUploadDao;
        this.excelHandler = excelHandler;
        this.logger = logger;
    }

    // Function to Read Criteria from Excel Sheet Object
    public List<CriteriaDTO> readCriteria(Sheet sheet) throws IllegalStateException,IllegalArgumentException {
        List<CriteriaDTO> criteriaList = new ArrayList<>();
        try {
            for (Row currentRow : sheet) {
                if (currentRow.getRowNum() == 0) {
                    continue;
                }
                CriteriaDTO criteria = new CriteriaDTO();
                criteria.setCriteriaName(currentRow.getCell(0).getStringCellValue());
                criteria.setDescription(currentRow.getCell(1).getStringCellValue());
                criteria.setStatus(currentRow.getCell(2).getStringCellValue());
                criteria.setCategory(currentRow.getCell(3).getStringCellValue());

                criteriaList.add(criteria);
            }
        } catch(IllegalStateException is){
            logger.error("Error Occurred While Reading the Excel Sheet Data " + is);
            throw new IllegalStateException("Some Occurred in Parsing the Excel Sheet " + is);
        }catch (IllegalArgumentException ia){
            logger.error("Error Occurred in the Excel Sheet Parameters ! " + ia);
            throw new IllegalArgumentException("Some Wrong Parameters Present in the Excel ");
        }
        return criteriaList;
    }

    // Service Function to Read the Excel Sheet and use it to insert the data into the db
    public boolean insertCriteriaFromExcel(MultipartFile multipartFile) throws IOException,IllegalArgumentException, IllegalStateException, SQLException {
        // Read Excel File and return a sheet
        Sheet sheet = excelHandler.readExcel(multipartFile);
        List<CriteriaDTO> criteriaDTOs = readCriteria(sheet);
        return criteriaBulkUploadDao.insertBulkCriteria(criteriaDTOs);
    }
}
