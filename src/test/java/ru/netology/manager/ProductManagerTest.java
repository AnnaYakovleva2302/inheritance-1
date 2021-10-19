package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductManagerTest {
    private Book book1 = new Book(1, "Еретики Дюны", 300, "Фрэнк Герберт");
    private Book book2 = new Book(2, "Тревожные люди", 300, "Фредрик Бакман");
    private Book book3 = new Book(3, "Дети Дюны", 300, "Фрэнк Герберт");
    private Smartphone phone1 = new Smartphone(4, "iPhone 11", 50000, "Apple");
    private Smartphone phone2 = new Smartphone(5, "iPhone 12", 70000, "Apple");
    private Smartphone phone3 = new Smartphone(6, "MI 11", 50000, "Xiaomi");
    private Product product1 = new Product(7, "Масло", 110);
    private Product product2 = new Product(8, "Хлеб", 70);
    private Product product3 = new Product(9, "Колбаса", 300);
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);

    @BeforeEach
    public void fillRepository() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(phone1);
        manager.add(phone2);
        manager.add(phone3);
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
    }

    @Test
    public void shouldSearchBooksByAuthor() {
        Book[] expected = { book1, book3 };
        Product[] actual = manager.searchBy("Фрэнк Герберт");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBooksByName() {
        Book[] expected = { book1, book3 };
        Product[] actual = manager.searchBy("Дюны");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSmartphonesByVendor() {
        Smartphone[] expected = { phone1, phone2 };
        Product[] actual = manager.searchBy("Apple");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSmartphonesByName() {
        Smartphone[] expected = { phone1, phone2 };
        Product[] actual = manager.searchBy("iPhone");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchProductsByName() {
        Product[] expected = { product2 };
        Product[] actual = manager.searchBy("Хлеб");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnEmptyArrayIfNoProductFound() {
        Product[] expected = {};
        Product[] actual = manager.searchBy("Икра черная");
        assertArrayEquals(expected, actual);
    }
}
