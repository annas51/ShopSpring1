package pl.britenet.campus.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.britenet.campus.object.CartProduct;
import pl.britenet.campus.service.CartProductService;
import pl.britenet.campus.service.CartService;

import java.util.List;
import java.util.Optional;
@CrossOrigin
@RestController
@RequestMapping("/api/v1/cartproduct")

public class CartProductController {
    private final CartProductService cartProductService;

    @Autowired
    public CartProductController( CartProductService cartProductService) {
        this.cartProductService = cartProductService;}

    @GetMapping ("/{id}")
    public Optional<CartProduct> getCartProduct(@PathVariable int id) {return this.cartProductService.getCartProduct(id);}

    @GetMapping
    public List<CartProduct> getCartProduct() {
        return this.cartProductService.getCartProduct();
    }

    @PostMapping
    public void createCartProduct(@RequestBody CartProduct cartProduct) {
        this.cartProductService.addCartProduct(cartProduct);
    }
   /* @PutMapping
    public void updateCartProduct(@RequestBody CartProduct cartProduct) {
        this.cartProductService.updateCartProduct(cartProduct);
    }*/
}
