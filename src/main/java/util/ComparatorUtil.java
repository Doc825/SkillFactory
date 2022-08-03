package util;
import comparator.students.*;

import comparator.students.FullName;
import comparator.university.*;
import enums.StudentsComparatorType;
import enums.UniversityComparatorType;

public class ComparatorUtil {
    private ComparatorUtil(){

    }

    public static ForStudents getStudentsComparator(StudentsComparatorType studentsComparatorType) {
        return switch (studentsComparatorType) {
            case UNIVERSITYID -> new UniversityID();
            case FULLNAME -> new FullName();
            case CURRENTCOURSENUMBER -> new CurrentCourseNumber();
            case AVGEXAMSCORE -> new AvgExamScore();
            default -> new FullName();
        };
    }

    public static ForUniversity getUniversityComparator(UniversityComparatorType universityComparatorType){
        return switch (universityComparatorType) {
            case FULLNAME -> new comparator.university.FullName();
            case ID -> new ID();
            case MAINPROFILE -> new MainProfile();
            case SHORTNAME -> new ShortName();
            case YEAROFFOUNDATION -> new YearOfFoundation();
            default -> new comparator.university.FullName();
        };
    }

}
