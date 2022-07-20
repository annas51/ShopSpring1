package pl.britenet.campus.model;

public class CustomerLoginData {
    private final int customerId;
    private final String customerToken;

    public CustomerLoginData(int customerId, String customerToken) {
        this.customerId = customerId;
        this.customerToken = customerToken;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getCustomerToken() {
        return customerToken;
    }
}
