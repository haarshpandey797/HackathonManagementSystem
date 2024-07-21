package com.nucleus.service.bulkuploadservices;

import com.nucleus.dao.bulkuploaddao.JudgesBulkUploadDao;
import com.nucleus.dto.JudgeDTO;
import com.nucleus.utility.ExcelHandler;
import com.nucleus.utility.enums.BusinessUnit;
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
public class JudgesBulkUploadService {
    JudgesBulkUploadDao judgesBulkUploadDao;
    ExcelHandler excelHandler;
    Logger logger;
    @Autowired
    public JudgesBulkUploadService(JudgesBulkUploadDao judgesBulkUploadDao,ExcelHandler excelHandler,Logger logger){
        this.judgesBulkUploadDao = judgesBulkUploadDao;
        this.excelHandler = excelHandler;
        this.logger = logger;
    }

    // Function to Read Judges from Excel Sheet Object
    public List<JudgeDTO> readJudge(Sheet sheet) throws IllegalStateException,IllegalArgumentException {
        List<JudgeDTO> judgeList = new ArrayList<>();
        try {
            for (Row currentRow : sheet) {
                if (currentRow.getRowNum() == 0) {
                    continue;
                }
                JudgeDTO judgesMaster = new JudgeDTO();
                judgesMaster.setJudgeName(currentRow.getCell(0).getStringCellValue());
                judgesMaster.setJudgeBU(BusinessUnit.valueOf(currentRow.getCell(1).getStringCellValue()));
                judgesMaster.setJudgeContactNo((long) currentRow.getCell(2).getNumericCellValue());
                judgesMaster.setJudgeEmail(currentRow.getCell(3).getStringCellValue());
                judgesMaster.setJudgeDesignation(currentRow.getCell(4).getStringCellValue());
                judgesMaster.setJudgeEmployeeId((long) currentRow.getCell(5).getNumericCellValue());

                judgeList.add(judgesMaster);
            }
        }catch(IllegalStateException is){
            logger.error("Error Occurred While Reading the Excel Sheet Data " + is);
            throw new IllegalStateException("Some Occurred in Parsing the Excel Sheet " + is);
        }catch (IllegalArgumentException ia){
            logger.error("Error Occurred in the Excel Sheet Parameters ! " + ia);
            throw new IllegalArgumentException("Some Wrong Parameters Present in the Excel ");
        }
        return judgeList;
    }

    // Service Function to Read take the excel Sheet and use it to insert the data into the db
    public boolean insertJudgesFromExcel(MultipartFile multipartFile) throws IOException,IllegalStateException, IllegalArgumentException,SQLException {
        // Read Excel File and return a sheet
        Sheet sheet = excelHandler.readExcel(multipartFile);
        List<JudgeDTO> judgesMasterDtos = readJudge(sheet);
        return judgesBulkUploadDao.insertBulkJudges(judgesMasterDtos);
    }
}
