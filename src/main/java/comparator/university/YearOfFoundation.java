package comparator.university;

import org.models.University;

public class YearOfFoundation implements ForUniversity {
    @Override
    public int compare(University o1, University o2) {
        return Integer.compare(o1.getYearOfFoundation(), o2.getYearOfFoundation());
    }
}
