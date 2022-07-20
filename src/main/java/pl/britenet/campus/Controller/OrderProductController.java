package pl.britenet.campus.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.britenet.campus.object.CartProduct;
import pl.britenet.campus.object.OrderProduct;
import pl.britenet.campus.service.CartProductService;
import pl.britenet.campus.service.OrderProductService;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/v1/orderproduct")

public class OrderProductController {
    private final OrderProductService orderProductService;

    @Autowired
    public OrderProductController(OrderProductService orderProductService) {this.orderProductService = orderProductService;}

    @GetMapping ("/{id}")
    public Optional<OrderProduct> getOrderProduct(@PathVariable int id) {return this.orderProductService.getOrderProduct(id);}

    @GetMapping
    public List<OrderProduct> getOrderProduct() {
        return this.orderProductService.getOrderProduct();
    }
}
