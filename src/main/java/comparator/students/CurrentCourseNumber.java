package comparator.students;

import org.models.Students;

public class CurrentCourseNumber implements ForStudents{
    @Override
    public int compare(Students o1, Students o2) {
        return Integer.compare(o1.getCurrentCourseNumber(), o2.getCurrentCourseNumber());
    }
}
