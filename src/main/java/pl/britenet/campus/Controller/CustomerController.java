package pl.britenet.campus.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.britenet.campus.object.Customer;
import pl.britenet.campus.service.CustomerService;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping ("/{id}")
    public Optional<Customer> getCustomer(@PathVariable int id) {
        return this.customerService.getCustomer(id);
    }

    @GetMapping
    public List<Customer> getCustomer() {
        return this.customerService.getCustomer();
    }

    @PostMapping
    public void AddCustomer(@RequestBody Customer customer) {
        this.customerService.addCustomer(customer);
    }

    @PutMapping
    public void updateCustomer(@RequestBody Customer customer) {
        this.customerService.updateCustomer(customer);
    }

    @DeleteMapping ("/{id}")
    public void deleteCustomer(@PathVariable int id) {
        this.customerService.deleteCustomer(id);
    }


}
