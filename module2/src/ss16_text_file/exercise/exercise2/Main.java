package ss16_text_file.exercise.exercise2;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        File sourceFile = new File("src/ss16_text_file/exercise/exercise2/data/nation.csv");

        List<String[]> lines = new ArrayList<>();
        String line;

        try {
            FileReader sourceFileReader = new FileReader(sourceFile);
            BufferedReader sourceFileReaderBuffer = new BufferedReader(sourceFileReader);

            while ((line = sourceFileReaderBuffer.readLine()) != null) {
                line = line.replaceAll("\"", "");
                lines.add(line.split(","));
            }

            for (String[] strLine : lines) {
                System.out.printf("\nID: %s , Nước: %s, Tên viết tắt: %s", strLine[0], strLine[1], strLine[2]);
            }

            sourceFileReaderBuffer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
