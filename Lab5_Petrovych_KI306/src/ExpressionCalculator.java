import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Клас для обчислення виразу y = tg(4x) / x
 * та запису результату у файл.
 */
public class ExpressionCalculator {

    // Метод для обчислення значення виразу y = tg(4x) / x.
    public double calculateExpression(double x) throws IllegalArgumentException {
        if (x == 0) {
            throw new IllegalArgumentException("Значення x не може бути нульовим.");
        }
        return Math.tan(4 * x) / x;
    }

    // Програма-драйвер для класу ExpressionCalculator.
    public static void main(String[] args) {
        FileHandler fileHandler = new FileHandler();  // Створюємо об'єкт класу FileHandler

        try (Scanner scanner = new Scanner(System.in)) {
            ExpressionCalculator calculator = new ExpressionCalculator();
            boolean validInput = false;
            double x = 0;

            while (!validInput) {
                try {
                    System.out.print("Введіть значення x: ");
                    x = scanner.nextDouble();
                    calculator.calculateExpression(x);
                    validInput = true;
                } catch (IllegalArgumentException e) {
                    System.err.println("Помилка: " + e.getMessage());
                    System.out.println("Будь ласка, спробуйте знову.");
                } catch (InputMismatchException e) {
                    System.err.println("Помилка: Ви повинні ввести число.");
                    scanner.next(); // Очищаємо некоректне введення
                } catch (Exception e) {
                    System.err.println("Невідома помилка: " + e.getMessage());
                }
            }

            try {
                double result = calculator.calculateExpression(x);
                System.out.println("Результат обчислення: " + result);
                
                fileHandler.writeResultToTextFile(result);  // Записуємо результат у текстовий файл
                fileHandler.writeResultToBinaryFile(result); // Записуємо результат у бінарний файл
                System.out.println("Результат записано у файли."); // Повідомляємо про успішний запис
                System.out.println("");
                
                // Читання з файлів
                String textResults = fileHandler.readResultFromTextFile();
                List<Double> binaryResults = fileHandler.readResultsFromBinaryFile();
                System.out.println("Результати з бінарного файлу:");
                for (double value : binaryResults) {
                    System.out.println(value); 
                }
                
                // Виводимо результати з файлів
                System.out.println("Результати з текстового файлу:\n" + textResults);
                
            } catch (IOException e) {
                System.err.println("Помилка запису/читання файлів: " + e.getMessage());
            }
        }
    }
}