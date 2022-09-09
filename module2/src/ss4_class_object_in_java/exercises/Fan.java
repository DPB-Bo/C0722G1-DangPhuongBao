package ss4_class_object_in_java.exercises;

public class Fan {
    private final int slow = 1;
    private final int medium = 2;
    private final int fast = 3;
    private int speed;
    private boolean status = false;
    private int fanRadius = 5;
    private String fanColor = "Blue";

    public Fan() {
    }

    public Fan(int speed, boolean status, int fanRadius, String fanColor) {
        this.speed = speed;
        this.status = status;
        this.fanRadius = fanRadius;
        this.fanColor = fanColor;
    }


    public int getSpeed() {
        return this.speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getFanRadius() {
        return fanRadius;
    }

    public void setFanRadius(int fanRadius) {
        this.fanRadius = fanRadius;
    }

    public String getFanColor() {
        return fanColor;
    }

    public void setFanColor(String fanColor) {
        this.fanColor = fanColor;
    }

    @Override
    public String toString() {
        String status = this.isStatus() ? "Bật" : "Tắt";
        return "Quạt{" +
                "Tốc độ quạt : " + this.getSpeed() +
                ", Trạng thái : đang " + status +
                ", Bán kính quat=" + this.getFanRadius() +
                ", Mau='" + this.getFanColor() + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Fan fan2 = new Fan(1, false, 5, "red");
        System.out.println(fan2);
    }
}
