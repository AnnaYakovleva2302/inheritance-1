package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ProductTest {
    private Product product = new Product(1, "Масло", 110);

    @Test
    public void shouldMatchProduct() {
        boolean actual = product.matches("Масло");
        assertTrue(actual);
    }

    @Test
    public void shouldNotMatchProduct() {
        boolean actual = product.matches("Хлеб");
        assertFalse(actual);
    }
}
