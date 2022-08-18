package pl.britenet.campus.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.britenet.campus.Service.AuthenticationService;
import pl.britenet.campus.object.Cart;
import pl.britenet.campus.service.CartService;

import java.util.List;
import java.util.Optional;
@CrossOrigin
@RestController

@RequestMapping("/api/v1/cart")


public class CartController {
    private final AuthenticationService authenticationService;
    private final CartService cartService;

    @Autowired
    public CartController(AuthenticationService authenticationService, CartService cartService) {
        this.authenticationService = authenticationService;
        this.cartService = cartService;}

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


    @PostMapping
    public void createCart(@RequestBody Cart cart, @RequestHeader("Authorization") String customerToken) {
        int customerId = authenticationService.getCustomerId(customerToken);
        cart.setCustomerId(customerId);
        this.cartService.AddCart(cart);
    }}