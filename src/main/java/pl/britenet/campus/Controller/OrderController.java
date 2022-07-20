package pl.britenet.campus.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.britenet.campus.object.Cart;
import pl.britenet.campus.object.Orderx;
import pl.britenet.campus.service.OrderService;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/v1/order")

public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {this.orderService = orderService;}

    @GetMapping ("/{id}")
    public Optional<Orderx> getOrder(@PathVariable int id) {return this.orderService.getOrder(id);}

    @GetMapping
    public List<Orderx> getOrder() {
        return this.orderService.getOrder();
    }

    @PostMapping
    public void AddOrderx(@RequestBody Orderx orderx) {this.orderService.AddOrderx(orderx);}

    @PutMapping
    public void updateOrder(@RequestBody Orderx orderx) {
        this.orderService.updateOrder(orderx);
    }

    @DeleteMapping ("/{id}")
    public void deleteOrder(@PathVariable int id) {
        this.orderService.deleteOrder(id);
    }
}
