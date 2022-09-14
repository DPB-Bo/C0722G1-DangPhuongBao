package ss7_interface_abstract_class.pratice.pratice1;

public class Chicken extends Animal implements Edibe {
    @Override
    public String makeSound() {
        return "Cục tác cục tác";
    }

    @Override
    public String howToEat() {
        return "could be fried";
    }
}
