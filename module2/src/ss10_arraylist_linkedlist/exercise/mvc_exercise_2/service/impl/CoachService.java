package ss10_arraylist_linkedlist.exercise.mvc_exercise_2.service.impl;

import ss10_arraylist_linkedlist.exercise.mvc_exercise_2.exception.coach_exception.AmountSeatException;
import ss10_arraylist_linkedlist.exercise.mvc_exercise_2.exception.coach_exception.TypeCarException;
import ss10_arraylist_linkedlist.exercise.mvc_exercise_2.model.Coach;
import ss10_arraylist_linkedlist.exercise.mvc_exercise_2.service.ICoachService;

import static com.sun.org.apache.xml.internal.security.keys.keyresolver.KeyResolver.length;

public class CoachService implements ICoachService {
    private CarList<Coach> coachCarList = new CarList<>();

    @Override
    public Object inputInformation() {
        Coach coach = new Coach();
        coachCarList.inputInformation(coach);

        coach.setTypeCar(checkTypeCarOfCoach());


        coach.setAmountSeat(checkAmountSeatOfCoach());

        return coach;
    }

    private String checkTypeCarOfCoach() {
        String typeCar;

        while (true) {
            try {
                System.out.print("\nNhập vào kiểu xe: ");
                typeCar = scanner.nextLine();
                boolean isNotValidTypeCar = typeCar.length() < 6;
                if (isNotValidTypeCar) {
                    throw new TypeCarException("Kiểu xe không phù hợp lệ(6 kí tự). Vui lòng nhập lại!");
                }
                break;
            } catch (TypeCarException e) {
                System.out.println(e.getMessage());
            }
        }

        return typeCar;
    }

    private int checkAmountSeatOfCoach() {
        int amountSeat;

        while (true) {
            try {
                System.out.print("\nNhập vào số lượng chỗ ngồi: ");
                amountSeat = Integer.parseInt(scanner.nextLine());
                if (amountSeat < 0) {
                    throw new AmountSeatException("Số lượng chỗ ngồi không hợp lệ.Vui lòng nhập lại!");
                }
                break;
            } catch (AmountSeatException | NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }

        return amountSeat;
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
