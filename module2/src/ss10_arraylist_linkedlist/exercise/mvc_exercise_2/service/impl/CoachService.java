package ss10_arraylist_linkedlist.exercise.mvc_exercise_2.service.impl;

import ss10_arraylist_linkedlist.exercise.mvc_exercise_2.model.Producer;
import ss10_arraylist_linkedlist.exercise.mvc_exercise_2.utils.exception.coach_exception.AmountSeatException;
import ss10_arraylist_linkedlist.exercise.mvc_exercise_2.utils.exception.coach_exception.TypeCarException;
import ss10_arraylist_linkedlist.exercise.mvc_exercise_2.model.Coach;
import ss10_arraylist_linkedlist.exercise.mvc_exercise_2.service.ICoachService;
import ss10_arraylist_linkedlist.exercise.mvc_exercise_2.utils.generic_list.CarList;

import java.util.List;

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
                boolean isNotValidTypeCar = typeCar.length() < 3;
                if (isNotValidTypeCar) {
                    throw new TypeCarException("Kiểu xe không phù hợp lệ(>3 kí tự). Vui lòng nhập lại!");
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
        coachCarList.writeFile(coach);
    }

    @Override
    public void readDataFile() {
        Coach coach = new Coach();
        List<String[]> lists = coachCarList.readFile(coach);
        for (String[] list : lists) {
            coach = new Coach();
            coach.setCode(list[0]);
            coach.setProducer(new Producer(list[1], list[2], list[3]));
            coach.setYear(Integer.parseInt(list[4]));
            coach.setOwner(list[5]);
            coach.setTypeCar(list[6]);
            coach.setAmountSeat(Integer.parseInt(list[7]));
            coachCarList.add(coach);
        }
    }

    @Override
    public void display() {
        coachCarList.display();
    }

    @Override
    public boolean remove(String code) {
        return coachCarList.remove(code, coachCarList);
    }

    @Override
    public boolean search(String code) {
        return coachCarList.search(code);
    }
}
