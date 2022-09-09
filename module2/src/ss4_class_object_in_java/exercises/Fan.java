package ss4_class_object_in_java.exercises;

public class Fan {
    //    private final int slow = 1;
//    private final int medium = 2;
//    private final int fast = 3;
    private int speed;
    private String speedToString = "SLOW";
    private boolean status = false;
    private String statusToString = "Tắt";
    private int fanRadius = 5;
    private String fanColor = "Blue";

    public Fan() {
    }

    public Fan(int speed, boolean status, int fanRadius, String fanColor) {
        this.speed = speed;
        this.status = status;
        this.fanRadius = fanRadius;
        this.fanColor = fanColor;
        if (this.speed == 1) this.speedToString = "SLOW";
        if (this.speed == 2) this.speedToString = "MEDIUM";
        if (this.speed == 3) this.speedToString = "FAST";
        this.statusToString = this.status ? "Bật" : "Tắt";
    }

    public Fan(String speedToString, String statusToString, int fanRadius, String fanColor) {
        this.speedToString = speedToString;
        this.statusToString = statusToString;
        this.fanRadius = fanRadius;
        this.fanColor = fanColor;
        if (this.speedToString.equals("SLOW")) this.speed = 1;
        if (this.speedToString.equals("MEDIUM")) this.speed = 2;
        if (this.speedToString.equals("FAST")) this.speed = 3;
        if (this.statusToString.equals("Bật")) this.status = true;
        if (this.statusToString.equals("Tắt")) this.status = false;
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

    public String getSpeedToString() {
        return this.speedToString;
    }


    public String getStatusToString() {
        return this.statusToString;
    }

    @Override
    public String toString() {
        return "Quạt{" +
                "Tốc độ quạt : " + this.getSpeedToString() + " - " + this.getSpeed() +
                ", Trạng thái : đang " + this.getStatusToString() + " - " + this.isStatus() +
                ", fanRadius=" + this.getFanRadius() +
                ", fanColor='" + this.getFanColor() + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Fan fan1 = new Fan("FAST", "Bật", 5, "red");
        Fan fan2 = new Fan(1, false, 5, "red");
        System.out.println(fan1);
        System.out.println(fan2);
    }
}
