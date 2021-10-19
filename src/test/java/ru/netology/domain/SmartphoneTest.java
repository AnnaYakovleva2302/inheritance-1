package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class SmartphoneTest {
    private Smartphone phone = new Smartphone(1, "iPhone 11", 50000, "Apple");

    @Test
    public void shouldMatchSmartphoneByName() {
        boolean actual = phone.matches("iPhone");
        assertTrue(actual);
    }

    @Test
    public void shouldNotMatchSmartphoneByName() {
        boolean actual = phone.matches("MI");
        assertFalse(actual);
    }

    @Test
    public void shouldMatchSmartphoneByVendor() {
        boolean actual = phone.matches("Apple");
        assertTrue(actual);
    }

    @Test
    public void shouldNotMatchSmartphoneByVendor() {
        boolean actual = phone.matches("Xiaomi");
        assertFalse(actual);
    }
}