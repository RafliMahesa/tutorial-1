package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Repository
public class ProductRepository {
    private List<Product> productData = new ArrayList<>();

    public Product create(Product product) {
        product.setProductId(UUID.randomUUID().toString());
        productData.add(product);
        return product;
    }

    public Product edit(Product oldProduct, Product editedProduct) {
        oldProduct.setProductName(editedProduct.getProductName());
        oldProduct.setProductQuantity(editedProduct.getProductQuantity());
        return oldProduct;
    }

    public Product delete(Product product){
        productData.remove(product);
        return product;
    }

    public Iterator<Product> findAll() {
        return productData.iterator();
    }
}