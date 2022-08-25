package IO;
import com.sun.tools.javac.Main;
import enums.StudyProfile;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.models.Students;
import org.models.University;



public class XlsReader {

    private static final Logger logger = Logger.getLogger(XlsReader.class.getName());

    private XlsReader(){
    }

    public static List<Students> StudentReader(String filePath) {
        logger.log(Level.INFO, "Student reader started");
        List<Students> students = new ArrayList<>();
        try {
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
                student.setCurrentCourseNumber((int) currentRow.getCell(2).getNumericCellValue());
                student.setAvgExamScore((float) currentRow.getCell(3).getNumericCellValue());
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Student reading failure" + e);
        }
        return students;
    }


        public static List<University> UniversityReader (String filePath){
            logger.log(Level.INFO, "University reader started");
            List<University> universities = new ArrayList<>();
            try {
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
                    university.setYearOfFoundation((int) currentRow.getCell(3).getNumericCellValue());
                    university.setMainProfile(StudyProfile.valueOf(StudyProfile.class, currentRow.getCell(4).getStringCellValue()));
                }
            } catch (IOException e) {
                logger.log(Level.SEVERE, "University reading failure" + e);
            }
            return universities;
        }
    }





