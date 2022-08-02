package comparator.students;

import org.apache.commons.lang3.StringUtils;
import org.models.Students;

public class UniversityID implements ForStudents{
    @Override
    public int compare(Students o1, Students o2) {
        return StringUtils.compare(o1.getUniversityId(), o2.getUniversityId());
    }
}