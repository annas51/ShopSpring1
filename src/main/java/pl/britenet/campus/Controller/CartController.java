package pl.britenet.campus.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.britenet.campus.object.Cart;
import pl.britenet.campus.service.CartService;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/v1/cart")

public class CartController {
    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {this.cartService = cartService;}

    @GetMapping ("/{id}")
    public Optional<Cart> getCart(@PathVariable int id) {
        return this.cartService.getCart(id);
    }

    @GetMapping
    public List<Cart> getCart() {
        return this.cartService.getCart();
    }

    @PostMapping
    public void AddCart(@RequestBody Cart cart) {this.cartService.AddCart(cart);}

    @PutMapping
    public void updateCart(@RequestBody Cart cart) {
        this.cartService.updateCart(cart);
    }

    @DeleteMapping ("/{id}")
    public void deleteCart(@PathVariable int id) {
        this.cartService.deleteCart(id);
    }
}
