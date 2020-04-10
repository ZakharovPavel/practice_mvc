package practice.dao;

import org.springframework.stereotype.Repository;
import practice.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class ProductDAOImpl implements ProductDAO {

    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);
    private static Map<Integer, Product> products = new HashMap<>();

    static {
        Product product1 = new Product("ball", 10.0);
        product1.setId(AUTO_ID.getAndIncrement());
        products.put(product1.getId(), product1);

        Product product2 = new Product("bread", 0.7);
        product2.setId(AUTO_ID.getAndIncrement());
        products.put(product2.getId(), product2);

        Product product3 = new Product("juice", 2.0);
        product3.setId(AUTO_ID.getAndIncrement());
        products.put(product3.getId(), product3);

        Product product4 = new Product("pen", 0.3);
        product4.setId(AUTO_ID.getAndIncrement());
        products.put(product4.getId(), product4);

        Product product5 = new Product("chicken", 3.0);
        product5.setId(AUTO_ID.getAndIncrement());
        products.put(product5.getId(), product5);
    }

    @Override
    public List<Product> allProducts() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void add(Product product) {
        product.setId(AUTO_ID.getAndIncrement());
        products.put(product.getId(), product);
    }

    @Override
    public void delete(Product product) {
        products.remove(product.getId());
    }

    @Override
    public void edit(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product getById(int id) {
        return products.get(id);
    }
}
