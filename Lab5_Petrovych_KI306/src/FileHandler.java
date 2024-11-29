import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Клас для обробки файлів (текстових та бінарних).
 */
class FileHandler {
    // Метод для запису результату в текстовий файл
    public void writeResultToTextFile(double result) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter("result.txt", true))) {
            writer.println(result);
        }
    }

    // Метод для запису результату в бінарний файл
    public void writeResultToBinaryFile(double result) throws IOException {
        try (DataOutputStream dataOutput = new DataOutputStream(new FileOutputStream("result.bin", true))) {
            dataOutput.writeDouble(result);
        }
    }

    // Метод для читання результату з текстового файлу
    public String readResultFromTextFile() throws IOException {
        String results = ""; 
        
        try (Scanner scanner = new Scanner(new FileReader("result.txt"))) {
            while (scanner.hasNextLine()) {
                results += scanner.nextLine() + "\n"; 
            }
        }
        
        return results;  // Повертаємо результуючий рядок
    }
    // Метод для читання всіх результатів з бінарного файлу
    public List<Double> readResultsFromBinaryFile() throws IOException {
        List<Double> results = new ArrayList<>();
        try (DataInputStream dataInput = new DataInputStream(new FileInputStream("result.bin"))) {
            while (true) { // Використовуємо нескінченний цикл для читання
                try {
                    double value = dataInput.readDouble(); // Читаємо double
                    results.add(value);
                } catch (EOFException e) { // Перервемо, якщо досягнемо кінця файлу
                    break;
                }
            }
        }
        return results;
    }
}
