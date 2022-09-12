package test_sth.test_java_work.inheritance_java;

public class Teacher extends People {
    private String teachClassess;
    private int teachLesson;

    public Teacher(String teacherClassess, int teachLesson) {
        this.teachClassess = teacherClassess;
        this.teachLesson = teachLesson;
    }

    public String getTeachClassess() {
        return teachClassess;
    }

    public void setTeachClassess(String teachClassess) {
        this.teachClassess = teachClassess;
    }

    public int getTeachLesson() {
        return teachLesson;
    }

    public void setTeachLesson(int teachLesson) {
        this.teachLesson = teachLesson;
    }
}
