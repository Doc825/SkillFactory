import java.io.IOException;
import java.util.List;

import XLSXReader.Reader;
import comparator.students.ForStudents;
import comparator.university.ForUniversity;
import enums.StudentsComparatorType;
import enums.UniversityComparatorType;
import org.models.Students;
import org.models.University;
import util.ComparatorUtil;


public class Main {
    public static void main(String[] args) throws IOException {
        
        List<Students> students =
                Reader.StudentReader("C:\\Users\\User\\IdeaProjects\\SkillFactory\\src\\main\\resources\\universityInfo.xlsx");
        ForStudents forStudents =
                ComparatorUtil.getStudentsComparator(StudentsComparatorType.AVGEXAMSCORE);
        students.stream()
                .sorted(forStudents)
                .forEach(System.out::println);



        List<University> universities =
                Reader.UniversityReader("C:\\Users\\User\\IdeaProjects\\SkillFactory\\src\\main\\resources\\universityInfo.xlsx");
        ForUniversity forUniversity =
                ComparatorUtil.getUniversityComparator(UniversityComparatorType.ID);
        universities.stream()
                .sorted(forUniversity)
                .forEach(System.out::println);

    }
}