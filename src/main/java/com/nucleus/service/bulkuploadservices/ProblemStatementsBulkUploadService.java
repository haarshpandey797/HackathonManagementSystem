package com.nucleus.service.bulkuploadservices;

import com.nucleus.dao.bulkuploaddao.JudgesBulkUploadDao;
import com.nucleus.dao.bulkuploaddao.ProblemMasterBulkUploadDao;
import com.nucleus.dto.JudgeDTO;
import com.nucleus.dto.ProblemStatementMasterDto;
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
public class ProblemStatementsBulkUploadService {
    private ProblemMasterBulkUploadDao problemMasterBulkUploadDao;
    private JudgesBulkUploadDao judgesBulkUploadDao;
    private ExcelHandler excelHandler;
    private Logger logger;
    @Autowired
    public ProblemStatementsBulkUploadService(ProblemMasterBulkUploadDao problemMasterBulkUploadDao,JudgesBulkUploadDao judgesBulkUploadDao,ExcelHandler excelHandler,Logger logger){
        this.excelHandler = excelHandler;
        this.judgesBulkUploadDao = judgesBulkUploadDao;
        this.problemMasterBulkUploadDao = problemMasterBulkUploadDao;
        this.logger = logger;
    }

    // Function to Read Judges from Excel Sheet Object
    public List<ProblemStatementMasterDto> readProblemStatements(Sheet sheet) throws IllegalStateException,IllegalArgumentException, NullPointerException{
        List<ProblemStatementMasterDto> problemStatementMasterDtos = new ArrayList<>();
        try {
            for (Row currentRow : sheet) {
                // Exclude the Column names and Empty Entries
                if (currentRow.getRowNum() == 0) {
                    continue;
                }
                ProblemStatementMasterDto problemStatementMasterDto = new ProblemStatementMasterDto();
                problemStatementMasterDto.setProblemName(currentRow.getCell(0).getStringCellValue());
                problemStatementMasterDto.setProblemDescription(currentRow.getCell(1).getStringCellValue());
                problemStatementMasterDto.setProblemLink(currentRow.getCell(2).getStringCellValue());
                problemStatementMasterDto.setStatus(currentRow.getCell(3).getStringCellValue());
                problemStatementMasterDto.setAdoptionStatus(currentRow.getCell(4).getStringCellValue());
                // Fetching the judge from ID and setting its Dto into the problem Dto
                int ownerID = (int) currentRow.getCell(5).getNumericCellValue();
                JudgeDTO judgesMasterDto = judgesBulkUploadDao.getJudgeMasterDto(ownerID);
                problemStatementMasterDto.setOwner(judgesMasterDto);
                if (judgesMasterDto.getJudgeName() == null) continue;
                problemStatementMasterDtos.add(problemStatementMasterDto);
            }
        }catch(IllegalStateException is){
            logger.error("Error Occurred While Reading the Excel Sheet Data " + is);
            throw new IllegalStateException("Some Occurred in Parsing the Excel Sheet " + is);
        }catch (IllegalArgumentException ia){
            logger.error("Error Occurred in the Excel Sheet Parameters ! " + ia);
            throw new IllegalArgumentException("Some Wrong Parameters Present in the Excel ");
        }catch (NullPointerException np){
            logger.error("Null Values from Excel File !" + np);
            throw new NullPointerException("Null Pointer From Excel");
        }
        return problemStatementMasterDtos;
    }

    // Service Function to Read take the excel Sheet and use it to insert the data into the db
    public boolean insertProblemsFromExcel(MultipartFile multipartFile) throws IllegalArgumentException,IllegalArgumentException,IOException, SQLException ,NullPointerException{
        // Read Excel File and return a sheet
        Sheet sheet = excelHandler.readExcel(multipartFile);
        List<ProblemStatementMasterDto> problemStatementMasterDtos = readProblemStatements(sheet);
        return problemMasterBulkUploadDao.insertBulkProblems(problemStatementMasterDtos);
    }
}