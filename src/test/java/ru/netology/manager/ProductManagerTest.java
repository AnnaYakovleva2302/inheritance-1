package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductManagerTest {
    @Test
    public void shouldSearchBooksByAuthor() {
        Book book1 = new Book(1, "Дюна", 300, "Фрэнк Герберт");
        Book book2 = new Book(2, "Тревожные люди", 300, "Фредрик Бакман");
        Book book3 = new Book(3, "Машина бытия", 300, "Фрэнк Герберт");
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Book[] expected = { book1, book3 };
        Product[] actual = manager.searchBy("Фрэнк Герберт");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBooksByName() {
        Book book1 = new Book(1, "Еретики Дюны", 300, "Фрэнк Герберт");
        Book book2 = new Book(2, "Тревожные люди", 300, "Фредрик Бакман");
        Book book3 = new Book(3, "Дети Дюны", 300, "Фрэнк Герберт");
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Book[] expected = { book1, book3 };
        Product[] actual = manager.searchBy("Дюны");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSmartphonesByVendor() {
        Smartphone phone1 = new Smartphone(1, "iPhone 11", 50000, "Apple");
        Smartphone phone2 = new Smartphone(2, "iPhone 12", 70000, "Apple");
        Smartphone phone3 = new Smartphone(3, "MI 11", 50000, "Xiaomi");
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        manager.add(phone1);
        manager.add(phone2);
        manager.add(phone3);

        Smartphone[] expected = { phone1, phone2 };
        Product[] actual = manager.searchBy("Apple");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSmartphonesByName() {
        Smartphone phone1 = new Smartphone(1, "iPhone 11", 50000, "Apple");
        Smartphone phone2 = new Smartphone(2, "iPhone 12", 70000, "Apple");
        Smartphone phone3 = new Smartphone(3, "MI 11", 50000, "Xiaomi");
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        manager.add(phone1);
        manager.add(phone2);
        manager.add(phone3);

        Smartphone[] expected = { phone1, phone2 };
        Product[] actual = manager.searchBy("iPhone");
        assertArrayEquals(expected, actual);
    }
}
