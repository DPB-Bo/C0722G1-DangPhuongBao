package ss10_arraylist_linkedlist.exercise.mvc_exercise_1.model;

public class Student extends Person implements Comparable<Student> {
    private String classes;
    private Integer score;

    public Student(String code, String name, String birthday, Boolean isMale, String classes, Integer score) {
        super(code, name, birthday, isMale);
        this.classes = classes;
        this.score = score;
    }

    public Student() {
    }

    public Student(String codeStudent, String nameStudent, String birthdayStudent, Boolean gender) {
        super(codeStudent, nameStudent, birthdayStudent, gender);
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }


    @Override
    public String toString() {
        return "\nSinh viên: " + getName() + "{" +
                super.toString() +
                ", Lớp: " + classes +
                ", Điểm: " + score +
                "}\n";
    }

    @Override
    public int compareTo(Student o) {
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
