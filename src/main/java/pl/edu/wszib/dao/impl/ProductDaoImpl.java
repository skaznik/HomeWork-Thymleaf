package pl.edu.wszib.dao.impl;

import org.springframework.stereotype.Repository;
import pl.edu.wszib.dao.ProductDao;
import pl.edu.wszib.domain.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductDaoImpl implements ProductDao {

    private Map<Long, Product> productMap;
    private static Long id = 1L;


    public ProductDaoImpl() {
        this.productMap = new HashMap<>();
        prepareProductsList();
    }

    @Override
    public Product getById(Long id) {
        return productMap.get(id);
    }

    @Override
    public void removeProduct(Long id) {
        productMap.remove(id);
    }

    @Override
    public void saveProduct(Product product) {
        if(product.getId()<1){
            product.setId(id);
            id++;
        }
        productMap.put(product.getId(),product);
    }

    @Override
    public List<Product> getProducts() {
        return new ArrayList<>(productMap.values());
    }

    private void prepareProductsList() {
        Product product1 = new Product();
        product1.setName("Produkt");
        product1.setPrice(10);
        product1.setQuantity(100);
        product1.setAvailable(true);
        saveProduct(product1);

        Product product2 = new Product();
        product2.setName("Produkt 1");
        product2.setPrice(20);
        product2.setQuantity(200);
        product2.setAvailable(false);
        saveProduct(product2);

        Product product3 = new Product();
        product3.setName("Produkt 2");
        product3.setPrice(30);
        product3.setQuantity(300);
        product3.setAvailable(false);
        saveProduct(product3);
    }

}

