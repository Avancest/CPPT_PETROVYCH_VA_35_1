import struct

class FileHandler:
    """Клас для обробки файлів (текстових та бінарних)."""

    def write_result_to_text_file(self, result):
        """
        Записує результат у текстовий файл.
        :param result: Значення, яке потрібно записати.
        """
        with open("result.txt", "a") as file:  # Відкриваємо файл у режимі дописування
            file.write(f"{result}\n")  # Записуємо результат з нового рядка

    def write_result_to_binary_file(self, result):
        """
        Записує результат у бінарний файл.
        :param result: Значення, яке потрібно записати.
        """
        with open("result.bin", "ab") as file:  # Відкриваємо файл у режимі додавання бінарних даних
            file.write(struct.pack("d", result))  # Пакуємо значення у формат 'double' та записуємо

    def read_result_from_text_file(self):
        """
        Читає всі результати з текстового файлу.
        :return: Строка з усіма результатами.
        """
        with open("result.txt", "r") as file:  # Відкриваємо файл у режимі читання
            return file.read()  # Читаємо весь вміст файлу

    def read_results_from_binary_file(self):
        """
        Читає всі результати з бінарного файлу.
        :return: Список значень, зчитаних з файлу.
        """
        results = []  # Ініціалізуємо список для зберігання результатів
        with open("result.bin", "rb") as file:  # Відкриваємо файл у режимі читання бінарних даних
            while True:
                data = file.read(8)  # Читаємо 8 байтів (розмір одного значення типу 'double')
                if not data:  # Якщо дані закінчились, завершуємо цикл
                    break
                results.append(struct.unpack("d", data)[0])  # Розпаковуємо дані у формат 'double' і додаємо до списку
        return results  # Повертаємо список результатів
