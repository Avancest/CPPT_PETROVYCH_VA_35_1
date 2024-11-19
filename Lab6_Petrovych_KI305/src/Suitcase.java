import java.util.ArrayList;
import java.util.List;

/**
 * Узагальнений клас, який представляє валізу, що може зберігати різні типи елементів.
 * @param <T> тип елементів, що будуть зберігатися у валізі.
 */
public class Suitcase<T extends Comparable<T>> {
    private List<T> items;

    /**
     * Конструктор, який ініціалізує порожню валізу.
     */
    public Suitcase() {
        items = new ArrayList<>();
    }

    /**
     * Додає елемент до валізи.
     * @param item елемент, який потрібно додати.
     */
    public void placeItem(T item) {
        items.add(item);
    }

    /**
     * Видаляє елемент з валізи.
     * @param item елемент, який потрібно видалити.
     * @return true, якщо елемент був видалений, false, якщо його не знайдено.
     */
    public boolean removeItem(T item) {
        return items.remove(item);
    }

    /**
     * Повертає мінімальний елемент у валізі.
     * @return мінімальний елемент або null, якщо валіза порожня.
     */
    public T findMinimumItem() {
        return items.isEmpty() ? null : items.stream().min(T::compareTo).orElse(null);
    }


    /**
     * Виводить усі елементи у валізі.
     */
    public void displayItems() {
        if (items.isEmpty()) {
            System.out.println("Валіза порожня.");
        } else {
            System.out.println("Елементи у валізі:");
            for (T item : items) {
                System.out.println(item);
            }
        }
    }
}
