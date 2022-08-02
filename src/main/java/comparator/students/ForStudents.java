package comparator.students;

import org.models.Students;

import java.util.Comparator;

public interface ForStudents extends Comparator<Students> {
    @Override
    default Comparator<Students> reversed() {
        return Comparator.super.reversed();
    }
}
