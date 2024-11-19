# Імпортуємо клас ExpressionCalculator для обчислення виразу
from expression_calculator import ExpressionCalculator
# Імпортуємо клас FileHandler для роботи з файлами
from file_handler import FileHandler

# Перевіряємо, чи модуль запускається як основний
if __name__ == "__main__":
    # Створюємо об'єкт для роботи з файлами
    file_handler = FileHandler()
    # Створюємо об'єкт для обчислення виразів
    calculator = ExpressionCalculator()

    # Вічний цикл для введення коректного значення змінної x
    while True:
        try:
            # Запитуємо у користувача значення змінної x
            x = float(input("Введіть значення x: "))
            # Обчислюємо значення виразу для введеного x
            result = calculator.calculate_expression(x)
            # Виходимо з циклу, якщо обчислення пройшло успішно
            break
        except ValueError as e:
            # Обробляємо помилку введення некоректного значення
            print(f"Помилка: {e}")
        except Exception as e:
            # Обробляємо будь-які інші помилки
            print(f"Невідома помилка: {e}")

    try:
        # Виводимо результат обчислення у консоль
        print(f"Результат обчислення: {result}")
        
        # Записуємо результат у текстовий файл
        file_handler.write_result_to_text_file(result)
        # Записуємо результат у бінарний файл
        file_handler.write_result_to_binary_file(result)
        # Повідомляємо користувача про успішний запис
        print("Результат записано у файли.")
        
        # Читаємо результати з текстового файлу
        text_results = file_handler.read_result_from_text_file()
        # Читаємо результати з бінарного файлу
        binary_results = file_handler.read_results_from_binary_file()
        
        # Виводимо результати, отримані з текстового файлу
        print("Результати з текстового файлу:\n", text_results)
        
        # Виводимо результати, отримані з бінарного файлу
        print("Результати з бінарного файлу:")
        for value in binary_results:
            print(value)
            
    # Обробляємо помилки запису/читання файлів
    except IOError as e:
        print(f"Помилка запису/читання файлів: {e}")
