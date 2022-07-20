package pl.britenet.campus.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.britenet.campus.Service.AuthenticationService;
import pl.britenet.campus.model.CustomerCredentials;
import pl.britenet.campus.model.CustomerLoginData;
@RestController
@RequestMapping("/api/v1/authentication")

public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping
    public CustomerLoginData login(@RequestBody CustomerCredentials customerCredentials) {
        return this.authenticationService.login(customerCredentials);
    }

    @GetMapping("/{customerToken}")
    public boolean login(@PathVariable String customerToken) {
        return this.authenticationService.isLogged(customerToken);
    }
}

