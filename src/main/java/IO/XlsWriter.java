package IO;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.models.Statistics;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class XlsWriter {
    private static final Logger logger = Logger.getLogger(XlsWriter.class.getName());
    private XlsWriter() {
    }

    public static void StatisticsWriter(List<Statistics> listOfStatistics, String filepath) {
        logger.log(Level.INFO, "Writing started");

        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet statisticsSheet = workbook.createSheet("Статистика");

            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            headerFont.setFontHeightInPoints((short) 14);
            CellStyle headerStyle = workbook.createCellStyle();
            headerStyle.setFont(headerFont);

            int rowNumber = 0;
            Row headerRow = statisticsSheet.createRow(rowNumber++);
            Cell profileCellHeader = headerRow.createCell(0);
            profileCellHeader.setCellValue("Профиль обучения");
            profileCellHeader.setCellStyle(headerStyle);
            Cell avgScoreCellHeader = headerRow.createCell(1);
            avgScoreCellHeader.setCellValue("Cредний балл за экзамены по профилю");
            avgScoreCellHeader.setCellStyle(headerStyle);
            Cell numberOfStudentsCellHeader = headerRow.createCell(2);
            numberOfStudentsCellHeader.setCellValue("Количество студентов по профилю");
            numberOfStudentsCellHeader.setCellStyle(headerStyle);
            Cell numberOfUniversitiesCellHeader = headerRow.createCell(3);
            numberOfUniversitiesCellHeader.setCellValue("Количество университетов по профилю");
            numberOfUniversitiesCellHeader.setCellStyle(headerStyle);
            Cell universitiesCellHeader = headerRow.createCell(4);
            universitiesCellHeader.setCellValue("Университеты");
            universitiesCellHeader.setCellStyle(headerStyle);

            for (Statistics statistics : listOfStatistics) {

                BigDecimal bigDecimal = BigDecimal.valueOf(statistics.getAvgScore());

                Row dataRow = statisticsSheet.createRow(rowNumber++);
                Cell profileCell = dataRow.createCell(0);
                profileCell.setCellValue(statistics.getStudyProfile().getProfileName());
                Cell avgScoreCell = dataRow.createCell(1);
                avgScoreCell.setCellValue(String.valueOf(bigDecimal.setScale(0, RoundingMode.UP)));
                Cell numberOfStudentsCell = dataRow.createCell(2);
                numberOfStudentsCell.setCellValue(statistics.getStudentsAmountByProfile());
                Cell numberOfUniversitiesCell = dataRow.createCell(3);
                numberOfUniversitiesCell.setCellValue(statistics.getUniversityAmountByProfile());
                Cell universitiesCell = dataRow.createCell(4);
                universitiesCell.setCellValue(statistics.getUniversityName());




            }
            try (FileOutputStream outputStream = new FileOutputStream(filepath)) {
                workbook.write(outputStream);
            }
        }catch (IOException e){
            logger.log(Level.SEVERE, "Writing failed, file did not create" + e);
        }
        logger.log(Level.INFO, "Writing complete, file created");
    }
}
