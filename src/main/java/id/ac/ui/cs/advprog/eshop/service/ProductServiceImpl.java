package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product create(Product product) {
        productRepository.create(product);
        return product;
    }

    @Override
    public Product search(String id) throws NoSuchElementException {
        Iterator<Product> productIterator = productRepository.findAll();

        while (productIterator.hasNext()) {
            Product product = productIterator.next();
            if(product.getProductId().equals(id)){
                return product;
            }
        }

        throw new NoSuchElementException("Tidak ditemukan id" + id);
    }

    @Override
    public Product edit(Product product){
        Product oldProduct = search(product.getProductId());
        return productRepository.edit(oldProduct, product);
    }

    @Override
    public Product delete(Product product){
        productRepository.delete(product);
        return product;
    }

    @Override
    public List<Product> findAll() {
        Iterator<Product> productIterator = productRepository.findAll();
        List<Product> allProduct = new ArrayList<>();
        productIterator.forEachRemaining(allProduct::add);
        return allProduct;
    }
}