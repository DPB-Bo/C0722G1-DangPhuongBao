package ss10_arraylist_linkedlist.exercise.mvc_exercise_2.service.impl;

import ss10_arraylist_linkedlist.exercise.mvc_exercise_2.model.Coach;
import ss10_arraylist_linkedlist.exercise.mvc_exercise_2.service.ICoachService;

public class CoachService implements ICoachService {
    private CarList<Coach> coachCarList = new CarList<>();

    @Override
    public Object inputInformation() {
        Coach coach = new Coach();
        coachCarList.inputInformation(coach);

        System.out.print("\nNhập vào kiểu xe: ");
        String typeCar = scanner.nextLine();
        coach.setTypeCar(typeCar);

        System.out.print("\nNhập vào số chỗ ngồi: ");
        Integer amountSeat = Integer.parseInt(scanner.nextLine());
        coach.setAmountSeat(amountSeat);

        return coach;
    }

    @Override
    public void add() {
        Coach coach = (Coach) inputInformation();
        coachCarList.add(coach);
    }

    @Override
    public void display() {
        coachCarList.display();
    }

    @Override
    public boolean remove(String code) {
        return coachCarList.remove(code);
    }

    @Override
    public boolean search(String code) {
        return coachCarList.search(code);
    }
}
