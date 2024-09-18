import java.io.*;
import java.util.*;

/**
 * Клас Lab1 реалізує приклад програми до лабораторної роботи №1
 */
public class Lab1 {
    /**
     * Статичний метод main є точкою входу в програму
     *
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        int nRows;
        char[][] arr;
        String filler;
        Scanner in = new Scanner(System.in);
        File dataFile = new File("MyFile.txt");
        PrintWriter fout = new PrintWriter(dataFile);
        System.out.print("Введіть розмір квадратної матриці: ");
        nRows = in.nextInt();
        in.nextLine();
        arr = new char[nRows][nRows]; // Створення квадратної матриці
        System.out.print("\nВведіть символ-заповнювач: ");
        filler = in.nextLine();

        if (filler.length() != 1) {
            System.out.print("\nПомилка: потрібно ввести один символ.");
            return;
        }

        char fillChar = filler.charAt(0);

        // Заповнення першого квадрата у верхньому лівому куті
        for (int i = 0; i < nRows / 2; i++) {
            for (int j = 0; j < nRows / 2; j++) {
                arr[i][j] = fillChar;
            }
        }

        // Заповнення другого квадрата у нижньому правому куті
        for (int i = nRows / 2; i < nRows; i++) {
            for (int j = nRows / 2; j < nRows; j++) {
                arr[i][j] = fillChar;
            }
        }

        // Виведення матриці
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nRows; j++) {
                if (arr[i][j] == fillChar) {
                    System.out.print(arr[i][j] + " ");
                    fout.print(arr[i][j] + " ");
                } else {
                    System.out.print("  ");  // Порожнє місце, якщо символ не був заповнений
                    fout.print("  ");
                }
            }
            System.out.print("\n");
            fout.print("\n");
        }

        fout.flush();
        fout.close();
    }
}
