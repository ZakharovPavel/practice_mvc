package practice.dao;

import practice.model.Product;

import java.util.List;

public interface ProductDAO {

    List<Product> allProducts();
    void add(Product product);
    void delete(Product product);
    void edit(Product product);
    Product getById(int id);

}
