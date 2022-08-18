package pl.britenet.campus.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.britenet.campus.Service.AuthenticationService;
import pl.britenet.campus.model.CustomerCredentials;
import pl.britenet.campus.model.CustomerLoginData;
import pl.britenet.campus.object.Customer;


@CrossOrigin
@RestController
@RequestMapping("/api/v1/authentication")

public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping ("/login")
    public CustomerLoginData login(@RequestBody CustomerCredentials customerCredentials) {
        return this.authenticationService.
                login(customerCredentials);
    }

    @GetMapping("/{customerToken}")
    public boolean login(@PathVariable String customerToken, String email) {
        return this.authenticationService.isLogged(customerToken);

    }

    @PostMapping ("register")
    public void register(@RequestBody Customer customer) {
        this.authenticationService.register(customer);
    }


    }


