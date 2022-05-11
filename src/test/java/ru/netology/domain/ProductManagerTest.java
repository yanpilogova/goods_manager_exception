package ru.netology.domain;

import org.junit.jupiter.api.Test;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    @Test
    void addProducts() {
        Product bookOne = new Book(1, "Cake book", 1010, "Ivanov A.V.");
        Product smartphoneOne = new Smartphone(3,"Nokia",11200, "Nokia Lmt");

        Product[] expected = new Product[]{bookOne, smartphoneOne};
        ProductManager manager = new ProductManager();
        manager.add(bookOne);
        manager.add(smartphoneOne);

        assertArrayEquals(expected, manager.findAll());
    }

    @Test
    void removedByID() {
        Product bookOne = new Book(1, "Cake book", 1010, "Ivanov A.V.");

        Product[] expected = new Product[0];
        ProductManager manager = new ProductManager();
        manager.add(bookOne);
        manager.removedByID(1);

        assertArrayEquals(expected, manager.findAll());
    }

    @Test
    void searchByName() {
        Product bookOne = new Book(1, "Cake book", 1010, "Ivanov A.V.");
        Product smartphoneOne = new Smartphone(3,"Nokia",11200, "Nokia Lmt");

        Product[] expected = new Product[]{bookOne};
        ProductManager manager = new ProductManager();
        manager.add(bookOne);
        manager.add(smartphoneOne);

        Product[] actual = manager.searchBy("Cake");

        assertArrayEquals(expected, actual);
    }
    @Test
    void removeIdTrue() {
        Product bookOne = new Book(1, "Cake book", 1010, "Ivanov A.V.");
        Product smartphoneOne = new Smartphone(3,"Nokia",11200, "Nokia Lmt");

        Product[] expected = new Product[]{bookOne};
        ProductRepository repository = new ProductRepository();
        repository.add(bookOne);
        repository.add(smartphoneOne);

        repository.removeById(3);

        assertArrayEquals(expected, repository.findAll());
    }
    @Test
    void removeIdFail() {
        Product bookOne = new Book(1, "Cake book", 1010, "Ivanov A.V.");
        Product smartphoneOne = new Smartphone(3,"Nokia",11200, "Nokia Lmt");

        ProductRepository repository = new ProductRepository();
        repository.add(bookOne);
        repository.add(smartphoneOne);

        assertThrows(NotFoundException.class, () -> {
            repository.removeById(2);
        });
    }

}