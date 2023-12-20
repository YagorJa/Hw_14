import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new FileReader("Romeo and Juliet.txt"))) {
                int max = 0;
                String current = "";
            while (scanner.hasNextLine()) {
                String[] words = scanner.nextLine().split("[^\\p{L}'-]+");

                for (String word : words) {
                    if (word.length() > max) {
                        max = word.length();
                        current = word;
                    }
                }
            }
            System.out.println("Самое длинное слово: " + current + " (" +max +")");
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден.");
        }
    }
}
