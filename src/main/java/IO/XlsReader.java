
package IO;
import enums.StudyProfile;
import java.io.*;
import java.util.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.models.Students;
import org.models.University;



public class XlsReader {

    private XlsReader() {
    }

    public static List<Students> StudentReader(String filePath) throws IOException {
        List<Students> students = new ArrayList<>();
        FileInputStream inputStream = new FileInputStream(filePath);
        XSSFWorkbook wb = new XSSFWorkbook(inputStream);
        XSSFSheet StudentSheet = wb.getSheetAt(0);

        Iterator<Row> studentRowIterator = StudentSheet.iterator();
        studentRowIterator.next();
        while (studentRowIterator.hasNext()) {
            Row currentRow = studentRowIterator.next();
            Students student = new Students();
            students.add(student);
            student.setUniversityId(currentRow.getCell(0).getStringCellValue());
            student.setFullName(currentRow.getCell(1).getStringCellValue());
            student.setCurrentCourseNumber((int)currentRow.getCell(2).getNumericCellValue());
            student.setAvgExamScore((float)currentRow.getCell(3).getNumericCellValue());
        }
        return students;
    }



    public static List<University> UniversityReader(String filePath) throws IOException {
        List<University> universities = new ArrayList<>();
        FileInputStream inputStream = new FileInputStream(filePath);
        XSSFWorkbook wb = new XSSFWorkbook(inputStream);
        XSSFSheet UniversitySheet = wb.getSheetAt(1);
        Iterator<Row> universityRowIterator = UniversitySheet.iterator();
        universityRowIterator.next();
        while (universityRowIterator.hasNext()) {
            Row currentRow = universityRowIterator.next();
            University university = new University();
            universities.add(university);
            university.setId(currentRow.getCell(0).getStringCellValue());
            university.setFullName(currentRow.getCell(1).getStringCellValue());
            university.setShortName(currentRow.getCell(2).getStringCellValue());
            university.setYearOfFoundation((int)currentRow.getCell(3).getNumericCellValue());
            university.setMainProfile(StudyProfile.valueOf(StudyProfile.class, currentRow.getCell(4).getStringCellValue()));

            }
        return universities;
    }
}

