import java.io.FileWriter;  // Імпортуємо клас FileWriter для запису у файл
import java.io.IOException;  // Імпортуємо клас IOException для обробки помилок вводу/виводу
import java.io.PrintWriter;  // Імпортуємо клас PrintWriter для зручного запису тексту у файл
import java.util.InputMismatchException;  // Імпортуємо клас InputMismatchException для обробки неправильного введення
import java.util.Scanner;  // Імпортуємо клас Scanner для зчитування введення з консолі


public class ExpressionCalculator {

    /**
     * Обчислює значення виразу y = tg(4x) / x.
     *
     * @param x значення змінної x
     * @return результат обчислення
     * @throws IllegalArgumentException якщо x дорівнює нулю
     */
    public double calculateExpression(double x) throws IllegalArgumentException 
    {
        if (x == 0) 
        { 
            throw new IllegalArgumentException("Значення x не може бути нульовим.");  
        }
        return Math.tan(4 * x) / x; 
    }

    /**
     * Записує результат у файл.
     *
     * @param result результат обчислення
     * @throws IOException якщо виникає помилка під час запису у файл
     */
    public void writeResultToFile(double result) throws IOException 
    {
        try (PrintWriter writer = new PrintWriter(new FileWriter("result.txt", true))) //try-with-resources
        {  
            writer.println("Результат: " + result); 
        }  //Файл автоматично закрився
    } 

    /**
     * Програма-драйвер для класу ExpressionCalculator.
     * Запитує у користувача значення x, обчислює результат і записує його у файл.
     *
     * @param args аргументи командного рядка
     */
    public static void main(String[] args) 
    {
        try (Scanner scanner = new Scanner(System.in)) 
        {
			ExpressionCalculator calculator = new ExpressionCalculator();  
			boolean validInput = false;  
			double x = 0;  

			
			while (!validInput) 
			{  
			    try 
			    {
			        System.out.print("Введіть значення x: ");  
			        x = scanner.nextDouble();  
			        
			        calculator.calculateExpression(x);  
			        validInput = true;  
			    } 
			    catch (IllegalArgumentException e) 
			    {  
			        System.err.println("Помилка: " + e.getMessage());  
			        System.out.println("Будь ласка, спробуйте знову.");  
			    } 
			    catch (InputMismatchException e) 
			    {  
			        System.err.println("Помилка: Ви повинні ввести число.");
			        System.out.println("Будь ласка, спробуйте знову.");  
			        scanner.next(); 
			    } 
			    catch (Exception e) 
			    {  
			        System.err.println("Невідома помилка: " + e.getMessage()); 
			        System.out.println("Будь ласка, спробуйте знову.");  
			        scanner.next();
			    }
			}

			
			try {
			    double result = calculator.calculateExpression(x);  
			    System.out.println("Результат обчислення: " + result);  
			    calculator.writeResultToFile(result);  
			    System.out.println("Результат записано у файл."); 
			} 
			catch (IOException e) 
			{ 
			    System.err.println("Помилка запису у файл: " + e.getMessage()); 
			}
		}
    }
}
