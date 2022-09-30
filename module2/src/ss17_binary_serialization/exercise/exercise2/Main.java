package ss17_binary_serialization.exercise.exercise2;

import java.io.*;

public class Main {
    public static void main(String[] args) {

        try {
            FileInputStream fileInputStream = new FileInputStream("src/ss17_binary_serialization/exercise/exercise2/data/source_file.dat");
            FileOutputStream fileOutputStream = new FileOutputStream("src/ss17_binary_serialization/exercise/exercise2/data/target_file.dat");

            ObjectInputStream ois = new ObjectInputStream(fileInputStream);
            ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);

            oos.writeObject(ois.readObject());

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
