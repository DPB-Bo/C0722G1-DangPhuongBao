package algorithm;

public class test {
    public static void main(String[] args) {
        int result = 0;
        int s = 6;
        int y = 1;
        int x = 2;
        while (s > 0) {
            if (s - y >= x) {
                s -= y;
                result += x;
            } else {
                result += s;
                break;
            }
        }
        System.out.println(result);
    }
}
