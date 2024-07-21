package com.nucleus.utility;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Component
public class ExcelHandler {
    @Autowired
    Logger logger;
    public Sheet readExcel(MultipartFile file) throws IOException {
        Sheet sheet = null;
        try (Workbook workbook = new XSSFWorkbook(file.getInputStream())) {
            sheet = workbook.getSheetAt(0);
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("Exception occured in reading excel " + e);
            throw new IOException("IO Exception At Excel Handler !");
        }
        return sheet;
    }

    public boolean checkEmptyEntries(Row currentRow,int maxIdx) {
        int i = 0;
        for (Cell cell : currentRow) {
            if(i >= maxIdx) break;
            if (isCellEmpty(cell)) {
                return true;
            }i++;
        }
        return false;
    }

    private boolean isCellEmpty(Cell cell) {
        if (cell == null || cell.getCellType() == CellType.BLANK) {
            return true;
        }
        if (cell.getCellType() == CellType.STRING && cell.getStringCellValue().trim().isEmpty()) {
            return true;
        }
        return false;
    }

}
