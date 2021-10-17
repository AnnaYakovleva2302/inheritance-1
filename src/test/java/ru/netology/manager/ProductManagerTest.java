package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test
    public void shouldSearchProductsByName() {
        Product product1 = new Product(1, "Масло", 110);
        Product product2 = new Product(2, "Хлеб", 70);
        Product product3 = new Product(3, "Колбаса", 300);
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);

        Product[] expected = { product2 };
        Product[] actual = manager.searchBy("Хлеб");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldMatchProduct() {
        Product product = new Product(1, "Масло", 110);
        boolean expected = true;
        boolean actual = product.matches("Масло");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldNotMatchProduct() {
        Product product = new Product(1, "Масло", 110);
        boolean expected = false;
        boolean actual = product.matches("Хлеб");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchBookByName() {
        Book book = new Book(1, "Дюна", 300, "Фрэнк Герберт");
        boolean expected = true;
        boolean actual = book.matches("Дюна");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldNotMatchBookByName() {
        Book book = new Book(1, "Дюна", 300, "Фрэнк Герберт");
        boolean expected = false;
        boolean actual = book.matches("Хлеб");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchBookByAuthor() {
        Book book = new Book(1, "Дюна", 300, "Фрэнк Герберт");
        boolean expected = true;
        boolean actual = book.matches("Герберт");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldNotMatchBookByAuthor() {
        Book book = new Book(1, "Дюна", 300, "Фрэнк Герберт");
        boolean expected = false;
        boolean actual = book.matches("Франц");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchSmartphoneByName() {
        Smartphone phone = new Smartphone(1, "iPhone 11", 50000, "Apple");
        boolean expected = true;
        boolean actual = phone.matches("iPhone");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldNotMatchSmartphoneByName() {
        Smartphone phone = new Smartphone(1, "iPhone 11", 50000, "Apple");
        boolean expected = false;
        boolean actual = phone.matches("MI");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchSmartphoneByVendor() {
        Smartphone phone = new Smartphone(1, "iPhone 11", 50000, "Apple");
        boolean expected = true;
        boolean actual = phone.matches("Apple");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldNotMatchSmartphoneByVendor() {
        Smartphone phone = new Smartphone(1, "iPhone 11", 50000, "Apple");
        boolean expected = false;
        boolean actual = phone.matches("Xiaomi");
        assertEquals(expected, actual);
    }
}
