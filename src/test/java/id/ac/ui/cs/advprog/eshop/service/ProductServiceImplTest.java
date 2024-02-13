package id.ac.ui.cs.advprog.eshop.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {
    
    @InjectMocks
    private ProductServiceImpl productService;

    @Mock
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreate() {
        Product product = new Product(); 
        product.setProductName("Sampo Cap BudiGimang");
        product.setProductQuantity(2);
        product.setProductId("2000");

        when(productRepository.create(product)).thenReturn(product);

        Product resultProduct = productService.create(product);

        assertEquals(product, resultProduct);
        verify(productRepository, times(1)).create(product);
    }

    @Test
    void testFindAll() {
        Product product = new Product(); 
        product.setProductName("Sampo Cap Budi");
        product.setProductQuantity(3);
        product.setProductId("1");

        Product product2 = new Product(); 
        product2.setProductName("Sampo Cap Hilmy");
        product2.setProductQuantity(3);
        product2.setProductId("2");

        Product product3 = new Product(); 
        product3.setProductName("Sampo Cap Irfan");
        product3.setProductQuantity(3);
        product3.setProductId("3");

        List<Product> productList = Arrays.asList(product, product2,product3);
        when(productRepository.findAll()).thenReturn(productList.iterator());
    
        List<Product> productListService = productService.findAll();
        
        assertTrue(productListService.contains(product) && productListService.contains(product3));
        assertEquals(productListService.get(0).getProductId(), product.getProductId());
        assertEquals(3, productListService.size());
    }


    @Test
    void testSearch() {
        Product product = new Product(); 
        product.setProductName("Sampo Cap Budi");
        product.setProductQuantity(3);
        product.setProductId("1");

        Product product2 = new Product(); 
        product2.setProductName("Sampo Cap Hilmy");
        product2.setProductQuantity(3);
        product2.setProductId("2");

        List<Product> productList = Arrays.asList(product, product2);
        when(productRepository.findAll()).thenReturn(productList.iterator());

        Product searchedProduct = productService.search("2");
        assertEquals(searchedProduct.getProductId(), product2.getProductId());
        assertThrows(NoSuchElementException.class, () -> productService.search("404"));
    }

    @Test
    void testEdit() {
        Product originalProduct = new Product();
        originalProduct.setProductName("Sampo Cap Budi");
        originalProduct.setProductQuantity(3);
        originalProduct.setProductId("1");

        Product editedProduct = new Product();
        editedProduct.setProductName("Sampo Cap Irfan");
        editedProduct.setProductQuantity(6);
        editedProduct.setProductId("1");

        when(productRepository.findAll()).thenReturn(Arrays.asList(originalProduct).iterator());
        when(productRepository.edit(originalProduct, editedProduct)).thenReturn(editedProduct);

        Product updatedProduct = productService.edit(editedProduct);

        verify(productRepository, times(1)).findAll();
        verify(productRepository, times(1)).edit(originalProduct, editedProduct);

        // Memeriksa bahwa hasil edit sesuai dengan yang diharapkan
        assertEquals("Sampo Cap Irfan", updatedProduct.getProductName());
        assertEquals(6, updatedProduct.getProductQuantity());
        assertEquals("1", updatedProduct.getProductId());
    }

    @Test
    void testDelete() {
        Product productToDelete = new Product();
        productToDelete.setProductName("Sampo Cap Budi");
        productToDelete.setProductQuantity(3);
        productToDelete.setProductId("1");

        when(productRepository.delete(productToDelete)).thenReturn(productToDelete);
        Product deletedProduct = productService.delete(productToDelete);
        verify(productRepository, times(1)).delete(productToDelete);

        // Memeriksa bahwa produk yang dihapus sesuai dengan yang diharapkan
        assertEquals("Sampo Cap Budi", deletedProduct.getProductName());
        assertEquals(3, deletedProduct.getProductQuantity());
        assertEquals("1", deletedProduct.getProductId());
    }
}
