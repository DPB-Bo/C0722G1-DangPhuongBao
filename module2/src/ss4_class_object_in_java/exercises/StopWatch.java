package ss4_class_object_in_java.exercises;

import java.util.Scanner;

public class StopWatch {
    static Scanner scanner = new Scanner(System.in);

    public double getStartTime() {
        return startTime;
    }

    public void setStartTime(double startTime) {
        this.startTime = startTime;
    }

    public double getEndTime() {
        return endTime;
    }

    public void setEndTime(double endTime) {
        this.endTime = endTime;
    }

    private double startTime;
    private double endTime;

    private Boolean status = false;

    public StopWatch() {
    }

    public void activeStopWatch() {
        if (this.getStatus()) {
            System.out.println("\nStopWatch đã được bật trước đó!\n");
            return;
        }
        status = true;
        startTime = System.currentTimeMillis();
        System.out.println("\n*****Đã bật StopWatch*****" +
                "\n Thời gian đang đếm\n");
    }

    public void endStopWatch() {
        if (!(this.getStatus())) {
            System.out.println("\nChưa bật StopWatch!\n");
            return;
        }
        System.out.println("\nStopWatch đã dừng\n");
        status = false;
        endTime = System.currentTimeMillis();
        displayElapsedTime();
    }

    private void displayElapsedTime() {
        while (true) {
            System.out.print("\n*****STOP WATCH*****\n" +
                    "1. Xem thời gian đã bật StopWatch\n" +
                    "2. Trờ lại\n" +
                    "3. Thoát\n" + "" +
                    "Nhập lựa chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.printf("\nStopWatch đã bật được %.2f giây\n", getElapsedTime());
                case 2:
                    return;
                case 3:
                    System.out.println("\nDừng chương trình!\n");
                    System.exit(0);
                    break;
                default:
                    System.out.println("\nKhông có lựa chọn này!\n");
                    break;
            }
        }
    }

    public double getElapsedTime() {
        return (endTime - startTime) / 1000;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        while (true) {
            System.out.print("\n*****STOP WATCH*****\n" +
                    "1. Bật stop watch\n" +
                    "2. Tắt stop watch\n" +
                    "3. Thoát\n" +
                    "Nhập lựa chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    stopWatch.activeStopWatch();
                    break;
                case 2:
                    stopWatch.endStopWatch();
                    break;
                case 3:
                    System.out.println("Dừng chương trình!");
                    System.exit(0);
                default:
                    System.out.println("Không có lựa chọn này! ");
                    break;
            }
        }
    }
}
