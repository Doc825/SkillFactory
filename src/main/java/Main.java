import java.io.IOException;
import java.util.List;

import IO.XlsReader;
import IO.XlsWriter;
import comparator.students.InterfaceForStudents;
import comparator.university.InterfaceForUniversity;
import enums.StudentsComparatorType;
import enums.UniversityComparatorType;
import org.models.Statistics;
import org.models.Students;
import org.models.University;
import util.ComparatorUtil;
import util.JsonUtil;
import util.StatisticsUtil;


public class Main {
    public static void main(String[] args) throws IOException {
        
        List<Students> listOfStudents =
                XlsReader.StudentReader("C:\\Users\\User\\IdeaProjects\\SkillFactory\\src\\main\\resources\\universityInfo.xlsx");
        InterfaceForStudents forStudents =
                ComparatorUtil.getStudentsComparator(StudentsComparatorType.AVGEXAMSCORE);
        listOfStudents.stream()
                .sorted(forStudents)
                .forEach(System.out::println);


        String studentsInJsons = JsonUtil.ListStudentToJSON(listOfStudents);
        System.out.println(studentsInJsons);

        List<Students> studentsFromJSON = JsonUtil.jsonToStudentList(studentsInJsons);
        System.out.println(listOfStudents.size() == studentsFromJSON.size());
        listOfStudents.forEach(students -> {
            String studentsJson = JsonUtil.studentsToJSON(students);
            System.out.println(studentsJson);
            Students studentFromJson = JsonUtil.jsonToStudent(studentsJson);
            System.out.println(studentFromJson);
        });



        List<University> listOfUniversities =
                XlsReader.UniversityReader
                        ("C:\\Users\\User\\IdeaProjects\\SkillFactory\\src\\main\\resources\\universityInfo.xlsx");
        InterfaceForUniversity interfaceForUniversity =
                ComparatorUtil.getUniversityComparator(UniversityComparatorType.ID);
        listOfUniversities.stream()
                .sorted(interfaceForUniversity)
                .forEach(System.out::println);

        String universitiesInJsons = JsonUtil.ListUniversityToJSON(listOfUniversities);
        System.out.println(universitiesInJsons);

        List<University> universitiesFromJSON = JsonUtil.jsonToUniversityList(universitiesInJsons);
        System.out.println(listOfUniversities.size() == universitiesFromJSON.size());
        listOfUniversities.forEach(university -> {
            String universityJson = JsonUtil.universityToJSON(university);
            System.out.println(universityJson);
            University universityFromJson = JsonUtil.jsonToUniversity(universityJson);
            System.out.println(universityFromJson);
        });

        List<Statistics> listOfStatistics = StatisticsUtil.gettingStatistics(listOfStudents, listOfUniversities);
        XlsWriter.StatisticsWriter
                (listOfStatistics, "src\\main\\resources\\statisticsWriter.xlsx");
    }
}