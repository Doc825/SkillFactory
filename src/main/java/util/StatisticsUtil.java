package util;

import org.apache.commons.lang3.StringUtils;
import org.models.*;
import enums.StudyProfile;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class StatisticsUtil {

    private static final Logger logger = Logger.getLogger(StatisticsUtil.class.getName());

    private StatisticsUtil(){}

    public static List<Statistics> gettingStatistics(List<Students> listOfStudents, List<University> listOfUniversities){
        List<Statistics> listOfStatistics = new ArrayList<>();

        logger.log(Level.INFO, "Statistics module started");

        Set<StudyProfile> profileSet = listOfUniversities.stream()
                .map(University::getMainProfile)
                .collect(Collectors.toSet());
        profileSet.forEach(mainProfile -> {
            Statistics statistics = new Statistics();
            listOfStatistics.add(statistics);
            statistics.setStudyProfile(mainProfile);

            List<String> profileUniversityIds = listOfUniversities.stream()
                    .filter(university -> university.getMainProfile().equals(mainProfile))
                    .map(University::getId)
                    .toList();
            statistics.setUniversityAmountByProfile(profileUniversityIds.size());
            statistics.setUniversityName(StringUtils.EMPTY);
            listOfUniversities.stream()
                    .filter(university -> profileUniversityIds.contains(university.getId()))
                    .map(University::getFullName)
                    .forEach(fullName -> statistics.setUniversityName(statistics.getUniversityName()
                     + fullName + ";"));
            List<Students> profileStudents = listOfStudents.stream()
                    .filter(students -> profileUniversityIds.contains(students.getUniversityId()))
                    .toList();
            statistics.setStudentsAmountByProfile(profileStudents.size());
            OptionalDouble avgScore = profileStudents.stream()
                    .mapToDouble(Students::getAvgExamScore)
                    .average();
            statistics.setAvgScore(0);
            avgScore.ifPresent(value -> statistics.setAvgScore(
                    (float) BigDecimal.valueOf(value).setScale(2, RoundingMode.HALF_UP).doubleValue()));
        });

        logger.log(Level.INFO,
                String.format("Statistics module finished with %s statistical objects", listOfStatistics.size()));

        return listOfStatistics;
    }

}
