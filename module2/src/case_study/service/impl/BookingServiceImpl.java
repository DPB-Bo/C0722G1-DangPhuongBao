package case_study.service.impl;

import case_study.model.booking.Booking;
import case_study.model.facility.Facility;
import case_study.model.person.Customer;
import case_study.service.BookingService;
import case_study.utils.comparator.BookingComparator;
import case_study.utils.file.ReadFileUtils;
import case_study.utils.file.WriteFileUtils;
import case_study.utils.generic_list.PersonList;
import case_study.utils.validate.BookingValidate;

import java.util.*;

public class BookingServiceImpl implements BookingService {
    private ArrayList<Booking> bookingList = new ArrayList<>();

    private BookingValidate bookingValidate = new BookingValidate();

    private FacilityServiceImpl facility = new FacilityServiceImpl();

    private CustomerServiceImpl customer = new CustomerServiceImpl();

    private LinkedHashMap<Facility, Integer> facilityList = facility.getFacilityList();

    private final String PATH_FACILITY = facility.getPATH();

    private final String PATH = "src/case_study/data/booking.csv";

    public ArrayList<Booking> getBookingList() {
        bookingList.sort(new BookingComparator());
        return bookingList;
    }

    @Override
    public void add() {
        if (checkAvailable(getServiceCodeList())) {
            ReadFileUtils.readFileBooking(PATH, bookingList);
            Booking booking = createBooking();
            bookingList.add(booking);
            increaseUseTime(booking.getServiceCode());
            WriteFileUtils.writeFacilityFile(PATH_FACILITY, facilityList);
            WriteFileUtils.writeBookingFile(PATH, bookingList);
            System.out.println("Thêm mới thành công");
        } else {
            System.out.println("Không còn dịch vụ trống, vui lòng thêm mới dịch vụ");
        }
    }


    private boolean checkAvailable(ArrayList<String> serviceCodeList) {
        return serviceCodeList.size() > 0;
    }

    @Override
    public void display() {
        ReadFileUtils.readFileBooking(PATH, bookingList);
        bookingList.sort(new BookingComparator());
        for (Booking booking : bookingList) {
            System.out.println(booking);
        }
    }

    private void increaseUseTime(String serviceCode) {
        Set<Facility> facilitySetKey = facilityList.keySet();

        for (Facility facility : facilitySetKey) {
            if (facility.getServiceCode().equals(serviceCode)) {
                facilityList.put(facility, facilityList.get(facility) + 1);
            }
        }
    }

    private Booking createBooking() {

        String booking = bookingValidate.validateBookingCode();

        String serviceCode = bookingValidate.validateServiceCode(getServiceCodeList());

        String customerCode = bookingValidate.validateCustomerCode(getCustomerCode());

        Date startDate = getStartDate();

        Date endDate = getEndDate(startDate);

        String serviceType = bookingValidate.validateServiceType(serviceCode);

        return new Booking(booking, serviceType, customerCode, startDate, endDate, serviceType);
    }

    private Date getStartDate() {
        Date startDate;
        while (true) {
            startDate = bookingValidate.validateStartDate();
            ArrayList<Date> endDates = getEndDay();
            if (endDates.size() < 1) {
                break;
            }
            boolean flag = false;
            for (Date date : endDates) {
                if (startDate.compareTo(date) <= 0) {
                    flag = true;
                    startDate = date;
                }
            }
            if (flag) {
                System.out.println("Dịch vụ đã được book với ngày kết thúc là:  " + startDate.toString());
            } else {
                break;
            }
        }
        return startDate;
    }

    private Date getEndDate(Date startDate) {
        Date endDate;
        while (true) {
            endDate = bookingValidate.validateEndDate();
            if (endDate.compareTo(startDate) < 0) {
                System.out.println("Ngày kết thúc phải sau ngày bắt đầu");
            }
            break;
        }
        return endDate;
    }

    private ArrayList<String> getServiceCodeList() {
        ArrayList<String> serviceCodeList = new ArrayList<>();
        for (Map.Entry<Facility, Integer> entry : facilityList.entrySet()) {
            if (entry.getValue() < 5) {
                serviceCodeList.add(entry.getKey().getServiceCode());
            }
        }
        return serviceCodeList;
    }

    private ArrayList<String> getCustomerCode() {
        ArrayList<String> customerCodeList = new ArrayList<>();
        PersonList<Customer> customers = customer.getCustomerPersonList();
        List<Customer> customerList = customers.getPeople();
        for (Customer customer : customerList) {
            customerCodeList.add(customer.getCode());
        }
        return customerCodeList;
    }

    private ArrayList<Date> getEndDay() {
        ArrayList<Date> endDates = new ArrayList<>();
        for (Booking booking : bookingList) {
            endDates.add(booking.getEndDate());
        }
        return endDates;
    }

}
