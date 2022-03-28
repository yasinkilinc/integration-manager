package tr.com.atez.integration.manager.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@Slf4j
public abstract class ExcelUtils {

    public static ArrayList<Map<Integer, Object>> convert(InputStream file, Integer poRefNumberIndex) throws IOException {

        ArrayList<Map<Integer, Object>> listRow = new ArrayList<>();
        XSSFWorkbook wb = new XSSFWorkbook(file);

        XSSFSheet sheet = wb.getSheetAt(0);
        XSSFRow row;
        XSSFCell cell;

        Iterator rows = sheet.rowIterator();

        boolean firstline = true;
        while (rows.hasNext()) {
            row = (XSSFRow) rows.next();
            if(firstline){
                firstline = false;
                continue;
            }

            Iterator cells = row.cellIterator();
            Map<Integer, Object> columns = new HashMap<>();
            while (cells.hasNext()) {
                cell = (XSSFCell) cells.next();
                int colName = cell.getColumnIndex();

                switch (cell.getCellType()){
                    case STRING:
                        columns.put(colName, cell.getStringCellValue());
                        break;
                    case NUMERIC:
                        if (DateUtil.isCellDateFormatted(cell)){
                            columns.put(colName, cell.getDateCellValue());
                        }
                        else{
                            // cell.setCellType(CellType.STRING);
                            columns.put(colName, cell.getNumericCellValue());
                        }
                        break;
                    case FORMULA:
                        columns.put(colName, cell.getCellFormula());
                        break;
                    default:
                        columns.put(colName, cell.getRawValue());
                        break;
                }
            }
            if(!columns.isEmpty()){
                listRow.add(columns);

                Collections.sort(listRow, new CustomComparator(poRefNumberIndex));
            }
        }
        // inputStream.reset();
        return listRow;
    }

    public static class CustomComparator implements Comparator<Map<Integer, Object>> {

        private Integer poRefNumberIndex;

        public CustomComparator(Integer poRefNumberIndex) {
            this.poRefNumberIndex = poRefNumberIndex;
        }

        @Override
        public int compare(Map<Integer, Object> o1, Map<Integer, Object> o2) {
            String po1 = (String)o1.get(poRefNumberIndex);
            String po2 = (String)o2.get(poRefNumberIndex);

            return po1.compareTo(po2);
        }
    }

}
