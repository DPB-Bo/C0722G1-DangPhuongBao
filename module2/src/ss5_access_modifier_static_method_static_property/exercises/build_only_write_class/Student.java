package ss5_access_modifier_static_method_static_property.exercises.build_only_write_class;

public class Student {
    private String name;
    private String classes;

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }
}
