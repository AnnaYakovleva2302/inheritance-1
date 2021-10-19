package ru.netology.manager;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

public class ProductManager {
    private ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public void add(Product product) {
        this.repository.save(product);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product: repository.getAll()) {
            if (this.matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        // search books
        if (product instanceof Book) {
            Book book = (Book) product;
            if (book.getAuthor().contains(search)) {
                return true;
            }
            if (book.getName().contains(search)) {
                return true;
            }
            return false;
        }
        // search smartphones
        if (product instanceof Smartphone) {
            Smartphone phone = (Smartphone) product;
            if (phone.getVendor().contains(search)) {
                return true;
            }
            if (phone.getName().contains(search)) {
                return true;
            }
            return false;
        }
        // search products
        if (product.getName().contains(search)) {
            return true;
        }
        return false;
    }
}
