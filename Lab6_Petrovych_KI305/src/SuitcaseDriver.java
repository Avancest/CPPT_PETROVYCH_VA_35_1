/**
 * Програмний драйвер для тестування класу Suitcase з різними типами елементів.
 */
public class SuitcaseDriver {
    public static void main(String[] args) {
        // Створення валізи для предметів одягу
        Suitcase<Clothing> clothingSuitcase = new Suitcase<>();
        clothingSuitcase.placeItem(new Clothing("Сорочка", 38));
        clothingSuitcase.placeItem(new Clothing("Куртка", 42));
        clothingSuitcase.placeItem(new Clothing("Штани", 40));

        // Виведення предметів одягу і пошук найменшого предмета (за розміром)
        System.out.println("Валіза для одягу:");
        clothingSuitcase.displayItems();
        System.out.println("Найменший предмет одягу: " + clothingSuitcase.findMinimumItem());

        // Створення валізи для книжок
        Suitcase<Book> bookSuitcase = new Suitcase<>();
        bookSuitcase.placeItem(new Book("Програмування на Java", 500));
        bookSuitcase.placeItem(new Book("Гаррі Потер", 300));
        bookSuitcase.placeItem(new Book("Біблія", 450));

        // Виведення книжок і пошук найменшої книжки (за кількістю сторінок)
        System.out.println("\nВаліза для книжок:");
        bookSuitcase.displayItems();
        System.out.println("Найменша книжка: " + bookSuitcase.findMinimumItem());
    }
}
