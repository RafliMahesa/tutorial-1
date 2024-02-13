package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;
    private static final String PRODUCTLISTSTRING = "redirect:list";

    @GetMapping("/create")
    public String createProductPage(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "createProduct";
    }

    @PostMapping("/create")
    public String createProductPost(@ModelAttribute Product product, Model model) {
        service.create(product);
        return PRODUCTLISTSTRING;
    }

    @GetMapping("/edit")
    public String editProductPage(@RequestParam(name = "id") String id, Model model){
        Product oldProduct = service.search(id);
        Product editedProduct = new Product();
        editedProduct.setProductId(id);
        editedProduct.setProductName(oldProduct.getProductName());
        editedProduct.setProductQuantity(oldProduct.getProductQuantity());
        model.addAttribute("product", editedProduct);
        return "editProduct";
    }

    @PostMapping("/edit")
    public String editProductPost(@ModelAttribute Product product, Model model) {
        service.edit(product);
        return PRODUCTLISTSTRING;
    }

    @GetMapping("/delete")
    public String deleteProductGet(@RequestParam(name = "id") String id, Model model) {
        Product searched = service.search(id);
        service.delete(searched);
        return PRODUCTLISTSTRING;
    }

    @GetMapping("/list")
    public String productListPage(Model model) {
        List<Product> allProducts = service.findAll();
        model.addAttribute("products", allProducts);
        return "productList";
    }
}
