package ss10_arraylist_linkedlist.exercise.mvc_exercise_1.model;

public abstract class Person {
    private String code;
    private String name;
    private String birthday;
    private Boolean isMale;

    public Person(String code, String name, String birthday, Boolean isMale) {
        this.code = code;
        this.name = name;
        this.birthday = birthday;
        this.isMale = isMale;
    }

    public Person() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Boolean getMale() {
        return isMale;
    }

    public void setMale(Boolean male) {
        isMale = male;
    }

    @Override
    public String toString() {
        String genderToString;
        if (isMale == null) {
            genderToString = "Giới tính thứ 3";
        } else {
            genderToString = isMale ? "Trai" : "Gái";
        }

        return "Mã: " + code +
                ", Họ và tên: " + name +
                ", Ngày sinh: " + birthday +
                ", Giới tính: " + genderToString;
    }
}
