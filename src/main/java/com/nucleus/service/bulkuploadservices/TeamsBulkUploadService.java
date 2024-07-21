package com.nucleus.service.bulkuploadservices;

import com.nucleus.dao.bulkuploaddao.TeamsBulkUploadDao;
import com.nucleus.dto.EventDTO;
import com.nucleus.dto.teambulkuploaddto.TeamBulkDTO;
import com.nucleus.utility.ExcelHandler;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TeamsBulkUploadService {
    TeamsBulkUploadDao teamsBulkUploadDao;
    ExcelHandler excelHandler;
    Logger logger;
    @Autowired
    public TeamsBulkUploadService(TeamsBulkUploadDao teamsBulkUploadDao, ExcelHandler excelHandler, Logger logger) {
        this.teamsBulkUploadDao = teamsBulkUploadDao;
        this.excelHandler = excelHandler;
        this.logger = logger;
    }
    // Function to read Teams from Excel Sheet Object
    public List<TeamBulkDTO> readTeams(Sheet sheet) throws IllegalStateException {
        List<TeamBulkDTO> teamList = new ArrayList<>();
        try {
            for (Row currentRow : sheet) {
                if (currentRow.getRowNum() == 0) {
                    continue;
                }
                TeamBulkDTO teamDto = new TeamBulkDTO();
                // Team Name : 0
                teamDto.setTeamName(currentRow.getCell(0).getStringCellValue());
                // Team Size : 1
                teamDto.setTeamSize((int)currentRow.getCell(1).getNumericCellValue());
                // Event : 2
//                long eventID = (long) currentRow.getCell(2).getNumericCellValue();
//                EventDTO eventDTO = teamsBulkUploadDao.getEventDTO(eventID);
//                teamDto.setEventDTO(eventDTO);
                teamDto.setEventID((long) currentRow.getCell(2).getNumericCellValue());
                // Status : 3
                teamDto.setStatus(currentRow.getCell(3).getStringCellValue());
                // Status : 4
                teamDto.setCodeRepositoryLink(currentRow.getCell(4).getStringCellValue());
                teamList.add(teamDto);
            }
        } catch (IllegalStateException is) {
            is.printStackTrace();
            logger.error("Error Occurred While Reading the Excel Sheet Data " + is);
            throw new IllegalStateException("Error Occurred in Parsing the Excel Sheet " + is);
        }
        return teamList;
    }

    // Service Function to read the Excel Sheet and use it to insert data into the DB
    @Transactional
    public boolean insertTeamsFromExcel(MultipartFile multipartFile) throws IOException, IllegalStateException {
        // Read Excel File and return a sheet
        Sheet sheet = excelHandler.readExcel(multipartFile);
        List<TeamBulkDTO> teamDTOs = readTeams(sheet);
        return teamsBulkUploadDao.insertBulkTeams(teamDTOs);
    }
}
