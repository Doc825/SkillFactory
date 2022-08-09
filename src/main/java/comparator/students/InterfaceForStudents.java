package comparator.students;

import org.models.Students;

import java.util.Comparator;

public interface InterfaceForStudents extends Comparator<Students> {
    @Override
    default Comparator<Students> reversed() {
        return Comparator.super.reversed();
    }
}
