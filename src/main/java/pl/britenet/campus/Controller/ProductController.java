package pl.britenet.campus.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.britenet.campus.object.Product;
import pl.britenet.campus.service.ProductService;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping ("/api/v1/product")

public class ProductController {
        private final ProductService productService;

        @Autowired
        public ProductController(ProductService productService) {
            this.productService = productService;
        }

        @GetMapping ("/{id}")
        public Optional<Product> getProduct(@PathVariable int id) {
            return this.productService.getProduct(id);
        }

        @GetMapping ("products")
        public List<Product> getProducts() {
            return this.productService.getProducts();
        }

        @PostMapping
       public void AddProduct(@RequestBody Product product) {
            this.productService.AddProduct(product);
        }

        @PutMapping
        public void updateProduct(@RequestBody Product product) {
             this.productService.updateProduct(product);
        }

        @DeleteMapping("/{id}")
        public void deleteProduct(@PathVariable int id) {
             this.productService.deleteProduct(id);
        }
    }

