package comparator.students;

import org.models.Students;

import java.util.Comparator;

public class AvgExamScore implements InterfaceForStudents {
    @Override
    public int compare(Students o1, Students o2) {
        return Float.compare(o1.getAvgExamScore(), o2.getAvgExamScore());
    }

    @Override
    public Comparator<Students> reversed() {
        return InterfaceForStudents.super.reversed();
    }
}
