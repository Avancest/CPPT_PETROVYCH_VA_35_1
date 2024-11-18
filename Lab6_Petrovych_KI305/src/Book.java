/**
 * Клас, що представляє книги, які можна помістити у валізу.
 */
public class Book implements Comparable<Book> {
    private String title;
    private int pageCount;

    /**
     * Конструктор, що ініціалізує книгу із заданими назвою та кількістю сторінок.
     * @param title назва книги.
     * @param pageCount кількість сторінок у книзі.
     */
    public Book(String title, int pageCount) {
        this.title = title;
        this.pageCount = pageCount;
    }

    /**
     * Метод для порівняння книг за кількістю сторінок.
     * @param other інша книга для порівняння.
     * @return від'ємне число, нуль або додатне число, якщо кількість сторінок
     * у цій книзі менша, рівна або більша за кількість сторінок в іншій книзі відповідно.
     */
    
    public int compareTo(Book other) {
        return Integer.compare(this.pageCount, other.pageCount);
    }

    /**
     * Повертає рядкове представлення книги.
     * @return рядок із назвою та кількістю сторінок книги.
     */
    
    public String toString() {
        return "Book{" + "title='" + title + "', pageCount=" + pageCount + '}';
    }
}
