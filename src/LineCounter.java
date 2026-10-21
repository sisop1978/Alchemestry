import java.io.*;
import java.util.Scanner;

public class LineCounter {
    int variantNumber;

    static int countLines(String filePath) {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            while (reader.readLine() != null) {
                count++;
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
        return count;
    }

    static String readLine(String filePath, int index) {
        // В реальном коде здесь может быть логика для разных форматов
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            for (int i = 0; i <= index; i++) {
                if (reader.readLine() == null) {
                    return null; // Строки закончились раньше index
                }
                System.out.println("смотрим внутри функции readln " + reader.readLine());
                return reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}