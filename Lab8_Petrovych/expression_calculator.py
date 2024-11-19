import math

class ExpressionCalculator:
    """Клас для обчислення виразу y = tg(4x) / x та обробки помилок."""
    
    def calculate_expression(self, x):
        """
        Обчислює значення виразу y = tg(4x) / x.
        :param x: Вхідне значення для обчислення.
        :return: Результат обчислення виразу.
        :raises ValueError: Якщо x дорівнює нулю.
        """
        if x == 0:  # Перевіряємо, чи дорівнює x нулю
            raise ValueError("Значення x не може бути нульовим.")  # Генеруємо помилку, якщо x = 0
        return math.tan(4 * x) / x  # Обчислюємо значення виразу
