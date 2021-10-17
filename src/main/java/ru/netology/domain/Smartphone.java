package ru.netology.domain;

import lombok.Data;

@Data
public class Smartphone extends Product {
    private String vendor;

    public Smartphone(int id, String name, int price, String vendor) {
        super(id, name, price);
        this.setVendor(vendor);
    }
}
