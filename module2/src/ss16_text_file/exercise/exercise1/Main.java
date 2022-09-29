package ss16_text_file.exercise.exercise1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        File sourceFile = new File("src/ss16_text_file/exercise/exercise1/data/sourcefile.txt");
        File copyFile = new File("src/ss16_text_file/exercise/exercise1/data/copyfile.txt");

        List<String> lines = new ArrayList<>();
        String line;

        try {
            FileReader sourceFileReader = new FileReader(sourceFile);
            BufferedReader sourceFileReaderBuffer = new BufferedReader(sourceFileReader);

            FileWriter copyFileWriter = new FileWriter(copyFile);
            BufferedWriter copyFileWriterBuffer = new BufferedWriter(copyFileWriter);

            while ((line = sourceFileReaderBuffer.readLine()) != null) {
                lines.add(line);
            }

            for (String strLine : lines) {
                copyFileWriterBuffer.write(strLine);
                copyFileWriterBuffer.newLine();
            }

            System.out.println("Copy Success!");

            sourceFileReaderBuffer.close();
            copyFileWriterBuffer.close();
        } catch (IOException e) {
            System.out.println("Đường dẫn file không hợp lệ.Vui lòng kiểm tra!");
        }

    }
}
