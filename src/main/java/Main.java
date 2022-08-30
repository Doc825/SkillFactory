import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import IO.JsonWriter;
import IO.XlsReader;
import IO.XlsWriter;
import IO.XmlWriter;
import comparator.students.InterfaceForStudents;
import comparator.university.InterfaceForUniversity;
import enums.StudentsComparatorType;
import enums.UniversityComparatorType;
import org.models.FullInfo;
import org.models.Statistics;
import org.models.Students;
import org.models.University;
import util.ComparatorUtil;
import util.StatisticsUtil;

import static java.util.logging.Level.INFO;


public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());
    public static void main(String[] args){

        try {
            LogManager.getLogManager().readConfiguration(
                    Main.class.getResourceAsStream("logging.properties"));
        }catch (IOException e){
            System.err.println("Could not setup logger configuration: " + e.toString());
        }



        logger.log(INFO, "Application started, logger configured");
        
        List<Students> listOfStudents =
                XlsReader.StudentReader("C:\\Users\\User\\IdeaProjects\\SkillFactory\\src\\main\\resources\\universityInfo.xlsx");
        InterfaceForStudents forStudents =
                ComparatorUtil.getStudentsComparator(StudentsComparatorType.AVGEXAMSCORE);
        listOfStudents.sort(forStudents);


        List<University> listOfUniversities =
                XlsReader.UniversityReader
                        ("C:\\Users\\User\\IdeaProjects\\SkillFactory\\src\\main\\resources\\universityInfo.xlsx");
        InterfaceForUniversity interfaceForUniversity =
                ComparatorUtil.getUniversityComparator(UniversityComparatorType.ID);
        listOfUniversities.sort(interfaceForUniversity);


        List<Statistics> listOfStatistics = StatisticsUtil.gettingStatistics(listOfStudents, listOfUniversities);
        XlsWriter.StatisticsWriter
                (listOfStatistics, "src\\main\\resources\\statisticsWriter.xlsx");

        FullInfo fullInfo = new FullInfo()
                .setStudentList(listOfStudents)
                .setUniversityList(listOfUniversities)
                .setStatistics(listOfStatistics)
                .setProcessDate(new Date());
        XmlWriter.generateXmlReq(fullInfo);
        JsonWriter.writeJsonReq(fullInfo);


        logger.info("Main thread finished");
    }
}