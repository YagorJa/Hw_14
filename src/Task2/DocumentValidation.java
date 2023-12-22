package Task2;

import java.io.*;
import java.util.Scanner;


public class DocumentValidation {
    public static void main(String[] args) {
        try {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите путь к входному файлу:");
            String ishodnik = scanner.nextLine();


            System.out.println("Введите путь к файлу-отчету для валидных номеров:");
            String vyvodNormesov = scanner.nextLine();


            System.out.println("Введите путь к файлу-отчету для невалидных номеров:");
            String vyvodOshibochnyh = scanner.nextLine();

            // Проверка и запись номеров документов
            validation(ishodnik, vyvodNormesov, vyvodOshibochnyh);

            System.out.println("Программа завершена.");
        } catch (IOException e) {
            System.out.println("Ошибка при выполнении программы: " + e.getMessage());
        }
    }

    public static void validation(String inS, String outValid, String outInvalid) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(inS));
             BufferedWriter bw1 = new BufferedWriter(new FileWriter(outValid));
             BufferedWriter bw2 = new BufferedWriter(new FileWriter(outInvalid))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.matches("^(docnum|contract)[a-zA-Z0-9]{13}$")) {
                    bw1.write(line);
                    bw1.newLine();
                } else
                    bw2.write(line + "Имя не проходит валидации");
                    bw2.newLine();

            }
        }
    }

}




