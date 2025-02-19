package com.softcomfortable.com.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;


public class XlsxReader {
    public static List<Integer> readFromXlsxFile(String filePath) {
        List<Integer> numbers = new ArrayList<>();

        try (
                FileInputStream fis = new FileInputStream(new File(filePath));
        ) {
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                Cell cell = row.getCell(0);
                if (cell != null && cell.getCellType() == CellType.NUMERIC) {
                    numbers.add((int) cell.getNumericCellValue());
                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return numbers;
    }
}
