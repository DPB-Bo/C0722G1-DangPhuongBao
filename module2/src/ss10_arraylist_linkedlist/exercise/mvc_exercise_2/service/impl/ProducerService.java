package ss10_arraylist_linkedlist.exercise.mvc_exercise_2.service.impl;

import ss10_arraylist_linkedlist.exercise.mvc_exercise_2.model.Producer;

import java.util.ArrayList;
import java.util.List;

public class ProducerService {
    private static List<Producer> producers = new ArrayList<Producer>();


    public static void addProducer() {
        producers.add(new Producer("VF", "VINFAST", "VIETNAM"));
        producers.add(new Producer("MA", "MAZDA", "NHATBAN"));
        producers.add(new Producer("TA", "TOYOTA", "NHATBAN"));
        producers.add(new Producer("MB", "MERCEDES-BENZ", "DUC"));
        producers.add(new Producer("LS", "LEXUS", "NHATBAN"));
        producers.add(new Producer("FD", "FORD", "HOAKY"));
        producers.add(new Producer("HI", "HYUNDAI", "HANQUOC"));
        producers.add(new Producer("PE", "PORSCHE", "DUC"));
        producers.add(new Producer("HA", "HONDA", "NHATBAN"));
    }

    public static List<Producer> getProducers() {
        return producers;
    }
}
