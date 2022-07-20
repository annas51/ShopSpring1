package pl.britenet.campus.model;

import pl.britenet.campus.service.CustomerService;

public class CustomerCredentials {

    private final String customerName;
    private final String password;

    public CustomerCredentials(String customerName, String password) {
        this.customerName = customerName;
        this.password = password;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getPassword() {
        return password;
    }
}
