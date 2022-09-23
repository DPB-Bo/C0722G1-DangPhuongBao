package ss10_arraylist_linkedlist.exercise.mvc_exercise_1.model;

public class Teacher extends Person implements Comparable<Teacher> {
    private String specialize;

    public Teacher(String code, String name, String birthday, Boolean isMale, String specialize) {
        super(code, name, birthday, isMale);
        this.specialize = specialize;
    }

    public Teacher(String code, String name, String birthday, Boolean isMale) {
        super(code, name, birthday, isMale);
    }

    public Teacher() {
    }

    public String getSpecialize() {
        return specialize;
    }

    public void setSpecialize(String specialize) {
        this.specialize = specialize;
    }

    @Override
    public String toString() {
        return "\nGiáo viên: " + getName() + "{" +
                super.toString() +
                ", Chuyên môn: " + specialize +
                '}';
    }

    @Override
    public int compareTo(Teacher o) {
        int compareName = this.getName().compareTo(o.getName());
        if (compareName > 0) {
            return 1;
        }
        if (compareName == 0) {
            return this.getCode().compareTo(o.getCode());
        }
        return -1;
    }
}
