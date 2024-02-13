package id.ac.ui.cs.advprog.eshop.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.List;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.ProductService;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {
    MockMvc mockMvc;

    @Mock
    ProductService productService;

    @InjectMocks
    ProductController productController;

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
    }

    @Test
    void testCreateProductPage() throws Exception {
        mockMvc.perform(get("/product/create"))
            .andExpect(view().name("createProduct"))
            .andExpect(status().isOk())
            .andExpect(model().attributeExists("product"));
    }

    @Test
    void testCreateProductPost() throws Exception {
        Product product = new Product();
        doReturn(product).when(productService).create(any(Product.class));
        
        mockMvc.perform(post("/product/create")
                .param("productName", "Sampo Cap Bambang")
                .param("productQuantity", "90"))
                .andExpect(redirectedUrl("list"))
                .andExpect(status().is3xxRedirection());
    }

    @Test
    void testEditProductPage() throws Exception {
        Product product = new Product();
        product.setProductName("Sampo Cap Malang");
        product.setProductQuantity(20);
        product.setProductId("1");
        doReturn(product).when(productService).search(product.getProductId());

        mockMvc.perform(get("/product/edit").param("id", product.getProductId()))
            .andExpect(view().name("editProduct"))
            .andExpect(status().isOk())
            .andExpect(model().attributeExists("product"));
    }

    @Test
    void testEditProductPost() throws Exception {
        mockMvc.perform(post("/product/edit")
                .param("productName", "Sampo Cap Bambang")
                .param("productQuantity", "90")
                .param("productId", "20"))
                .andExpect(redirectedUrl("list"))
                .andExpect(status().is3xxRedirection());
    }

    @Test
    void testDeleteProductGet() throws Exception {
        Product product = new Product();
        product.setProductName("Sampo Cap Malang");
        product.setProductQuantity(20);
        product.setProductId("1");
        doReturn(product).when(productService).search(product.getProductId());

        mockMvc.perform(get("/product/delete").param("id", product.getProductId()))
            .andExpect(status().is3xxRedirection())
            .andExpect(redirectedUrl("list"));
    }

    @Test 
    void testProductListPage() throws Exception {
        List<Product> productsList = Arrays.asList(new Product(), new Product());
        doReturn(productsList).when(productService).findAll();

        mockMvc.perform(get("/product/list"))
            .andExpect(status().isOk())
            .andExpect(view().name("productList"))
            .andExpect(model().attribute("products", productsList));
    }

}
