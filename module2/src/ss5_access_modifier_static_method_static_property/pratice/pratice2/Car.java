package ss5_access_modifier_static_method_static_property.pratice.pratice2;

public class Car {
    private String name;

    private String engine;


    public static int numberOfCars;


    public Car(String name, String engine) {

        this.name = name;

        this.engine = engine;

        numberOfCars++;

    }


    // getters and setters
}
