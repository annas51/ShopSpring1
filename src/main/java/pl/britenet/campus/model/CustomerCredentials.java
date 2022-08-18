package pl.britenet.campus.model;

import pl.britenet.campus.service.CustomerService;

public class CustomerCredentials {

    private final String Email;
    private final String password;

    public CustomerCredentials(String email, String password) {
        this.Email = email;
        this.password = password;
    }

    public String getEmail() {
        return Email;
    }

    public String getPassword() {
        return password;
    }


}
