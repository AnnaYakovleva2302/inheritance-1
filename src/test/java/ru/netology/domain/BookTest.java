package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class BookTest {
    private Book book = new Book(1, "Дюна", 300, "Фрэнк Герберт");

    @Test
    public void shouldMatchBookByName() {
        boolean actual = book.matches("Дюна");
        assertTrue(actual);
    }

    @Test
    public void shouldNotMatchBookByName() {
        boolean actual = book.matches("Хлеб");
        assertFalse(actual);
    }

    @Test
    public void shouldMatchBookByAuthor() {
        boolean actual = book.matches("Герберт");
        assertTrue(actual);
    }

    @Test
    public void shouldNotMatchBookByAuthor() {
        boolean actual = book.matches("Франц");
        assertFalse(actual);
    }
}