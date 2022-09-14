package test_sth.test_java_work.clean_code_java;


public class Worker {

    private int totalWorkHours;
    private final boolean bonus;

    public Worker(int totalWorkHours) {
        this.totalWorkHours = totalWorkHours;
        int WORK_BONUS = 8;
        this.bonus = totalWorkHours > WORK_BONUS;
    }

    public int getTotalWorkHours() {
        return totalWorkHours;
    }

    public void setTotalWorkHours(int totalWorkHours) {
        this.totalWorkHours = totalWorkHours;
    }

    public String isBonus() {
        return this.bonus ? "Có" : "Không";
    }

    public static void main(String[] args) {
        Worker worker = new Worker(7);
        System.out.println(worker.isBonus());
    }
}
