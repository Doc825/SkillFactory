package comparator.university;

import org.apache.commons.lang3.StringUtils;
import org.models.University;

public class MainProfile implements ForUniversity{
    @Override
    public int compare(University o1, University o2) {
        if (null == o1.getMainProfile()) {
            return 1;
        } else if (null == o2.getMainProfile()) {
            return -1;
        }
        return StringUtils.compare(o1.getMainProfile().name(), o2.getMainProfile().name());

    }
}
