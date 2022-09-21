package test_sth.test_java_work.tree_map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TestMap {

    public static void main(String[] args) {
        Map<String, String> mapTest = new HashMap<String, String>();
        mapTest.put("1", "a");
        mapTest.put("2", "a");
        mapTest.put("3", "a");
        Set<String> setID = mapTest.keySet();
        System.out.println(setID);
        mapTest.put("4", "a");
        System.out.println(setID);
    }
}
