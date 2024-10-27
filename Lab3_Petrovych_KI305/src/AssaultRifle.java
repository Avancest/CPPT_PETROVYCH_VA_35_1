import java.io.IOException;

/**
 * Клас, що представляє штурмову гвинтівку, успадковується від Weapon і реалізує інтерфейс Fireable.
 */
public class AssaultRifle extends Weapon implements Fireable {

    // Конструктор для створення штурмової гвинтівки
    public AssaultRifle() throws IOException {
        // Виклик конструктора батьківського класу з передачею типу зброї, боєприпасів і виробника
        super(new WeaponType("Assault Rifle", 35), new Ammunition("5.56mm", 30), new Manufacturer("AR Manufacturer"));
        // Логування створення штурмової гвинтівки
        logAction("Assault rifle created");
    }

    // Метод для здійснення пострілу
    public void shoot() {
        try {
            // Перевірка наявності боєприпасів
            if (getAmmunition().getQuantity() > 0) {
                // Зменшення кількості боєприпасів
                getAmmunition().decreaseQuantity();
                // Логування пострілу
                logAction("Assault rifle fired.");
                // Виведення кількості залишкових боєприпасів
                System.out.println("Bang! Ammo left: " + getAmmunition().getQuantity());
            } else {
                // Логування відсутності боєприпасів
                logAction("Out of ammo.");
                // Повідомлення про відсутність боєприпасів
                System.out.println("Click! Out of ammo.");
            }
        } catch (IOException e) {
            // Виведення повідомлення про помилку під час пострілу
            System.err.println("Error during shooting: " + e.getMessage());
        }
    }

    // Метод для перезарядки зброї
    public void reload(int newAmmo) {
        try {
            // Перевірка, чи кількість нових боєприпасів більше нуля
            if (newAmmo > 0) {
                // Встановлення нової кількості боєприпасів
                getAmmunition().setQuantity(newAmmo);
                // Логування перезарядки
                logAction("Reloaded assault rifle with " + newAmmo + " rounds.");
                // Повідомлення про успішну перезарядку
                System.out.println("Reloaded with " + newAmmo + " rounds.");
            } else {
                // Логування спроби перезарядки з недійсною кількістю боєприпасів
                logAction("Attempted to reload with invalid ammo count.");
                // Повідомлення про недійсну кількість боєприпасів
                System.out.println("Invalid ammo count. Cannot reload.");
            }
        } catch (IOException e) {
            // Виведення повідомлення про помилку під час перезарядки
            System.err.println("Error during reloading: " + e.getMessage());
        }
    }

    // Метод для перевірки кількості боєприпасів
    public void checkAmmo() {
        // Виведення кількості наявних боєприпасів
        System.out.println("Current ammo: " + getAmmunition().getQuantity());
    }

    // Головний метод програми
    public static void main(String[] args) throws IOException {
        // Створення об'єкта штурмової гвинтівки
        AssaultRifle rifle = new AssaultRifle();
        
        // Виведення інформації про зброю
        System.out.println(rifle.getWeaponInfo());
        // Перевірка кількості боєприпасів
        rifle.checkAmmo();
        

        
        // Виконання пострілу
        rifle.shoot();
        // Перезарядка зброї
        rifle.reload(30);
        // Виконання пострілу після перезарядки
        rifle.shoot();

        
        // Повторна перевірка кількості боєприпасів
        rifle.checkAmmo();
        // Закриття журналу логів
        rifle.closeLog();
    }
}
