package test_sth.test_java_work.tree_map;

import java.util.Objects;

public class Studen {
    private String id;
    private String name;
    private String address;

    public Studen(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Studen studen = (Studen) o;
//        return Objects.equals(id, studen.id) && Objects.equals(name, studen.name);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, name, address);
//    }
}
