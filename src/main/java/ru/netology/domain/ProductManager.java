package ru.netology.domain;

import ru.netology.repository.ProductRepository;

public class ProductManager {
    private ProductRepository repository = new ProductRepository();

    public ProductManager() {
    }
    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public ProductRepository getRepository() {
        return repository;
    }

    public void setRepository(ProductRepository repository) {
        this.repository = repository;
    }

    public void add(Product product) {
        repository.add(product);
    }

    public Product[] findAll (){
        return repository.findAll();
    }

    public void removedByID(int id) {
        repository.removeById(id);
    }

    public Product[] searchBy(String text){
        Product[] result = new Product[0];
        for (Product product: repository.findAll()){
            if (matches(product, text)){
                Product[] tmp = new Product[result.length +1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }
    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)){
            return true;
        }
        else {return false;
        }
    }

}