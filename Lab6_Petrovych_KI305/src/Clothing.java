/**
 * Клас, що представляє предмети одягу, які можна помістити у валізу.
 */
public class Clothing implements Comparable<Clothing> {
    private String name;
    private int size;

    /**
     * Конструктор, що ініціалізує предмет одягу із заданими назвою та розміром.
     * @param name назва предмета одягу.
     * @param size розмір предмета одягу.
     */
    public Clothing(String name, int size) {
        this.name = name;
        this.size = size;
    }

    /**
     * Метод для порівняння предметів одягу за їх розміром.
     * @param other інший предмет одягу для порівняння.
     * @return від'ємне число, нуль або додатне число, якщо розмір цього предмета
     * менший, рівний або більший за розмір іншого предмета відповідно.
     */
    @Override
    public int compareTo(Clothing other) {
        return Integer.compare(this.size, other.size);
    }

    /**
     * Повертає рядкове представлення предмета одягу.
     * @return рядок із назвою та розміром предмета одягу.
     */
    @Override
    public String toString() {
        return "Clothing{" + "name='" + name + "', size=" + size + '}';
    }
}
