package practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import practice.dao.ProductDAO;
import practice.dao.ProductDAOImpl;
import practice.model.Product;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductDAO productDAO;

    @Autowired
    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public List<Product> allProducts() {
        return productDAO.allProducts();
    }

    @Override
    public void add(Product product) {
        productDAO.add(product);
    }

    @Override
    public void delete(Product product) {
        productDAO.delete(product);
    }

    @Override
    public void edit(Product product) {
        productDAO.edit(product);
    }

    @Override
    public Product getById(int id) {
        return productDAO.getById(id);
    }
}
