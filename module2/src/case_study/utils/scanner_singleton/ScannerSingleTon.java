package case_study.utils.scanner_singleton;

import java.util.Scanner;

public class ScannerSingleTon {
    private static final Scanner SCANNER = new Scanner(System.in);

    public Scanner getScanner() {
        return SCANNER;
    }
}
