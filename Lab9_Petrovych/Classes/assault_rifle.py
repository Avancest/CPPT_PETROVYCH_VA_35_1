# classes/assault_rifle.py

# Імпортуємо базовий клас "Weapon" (зброя)
from .weapon import Weapon

class AssaultRifle(Weapon):
    """
    Похідний клас, що описує штурмову гвинтівку.
    """

    def __init__(self, model, caliber, range_effective, firing_mode):
        """
        Ініціалізація штурмової гвинтівки з додатковим параметром режиму стрільби.

        :param model: модель гвинтівки (str)
        :param caliber: калібр (float)
        :param range_effective: ефективна дальність (int, у метрах)
        :param firing_mode: режим стрільби (str) (наприклад, "автоматичний", "одиночний")
        """
        # Викликаємо конструктор базового класу для ініціалізації основних параметрів
        super().__init__(model, caliber, range_effective)
        # Ініціалізуємо додатковий параметр режиму стрільби
        self.firing_mode = firing_mode

    def change_mode(self, new_mode):
        """
        Зміна режиму стрільби.

        :param new_mode: новий режим стрільби (str)
        :return: Повідомлення про успішну зміну режиму.
        """
        # Змінюємо режим стрільби на новий
        self.firing_mode = new_mode
        # Повертаємо повідомлення про зміну режиму
        return f"Режим стрільби змінено на {self.firing_mode}"

    def __str__(self):
        """
        Повертає інформацію про штурмову гвинтівку.
        """
        # Отримуємо інформацію з базового класу
        base_info = super().__str__()
        # Додаємо інформацію про режим стрільби
        return f"{base_info}, Режим стрільби: {self.firing_mode}"
