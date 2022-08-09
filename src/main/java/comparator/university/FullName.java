package comparator.university;

import org.apache.commons.lang3.StringUtils;
import org.models.University;

public class FullName implements InterfaceForUniversity {
    @Override
    public int compare(University o1, University o2) {
        return StringUtils.compare(o1.getFullName(), o2.getFullName());
    }
}
