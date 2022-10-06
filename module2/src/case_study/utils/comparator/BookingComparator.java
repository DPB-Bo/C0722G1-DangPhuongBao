package case_study.utils.comparator;

import case_study.model.booking.Booking;

import java.util.Comparator;

public class BookingComparator implements Comparator<Booking> {

    @Override
    public int compare(Booking o1, Booking o2) {
        int compareStartDay = o1.getStartDate().compareTo(o2.getStartDate());
        if (compareStartDay == 0) {
            return o1.getEndDate().compareTo(o2.getEndDate());
        }
        return compareStartDay;
    }
}
