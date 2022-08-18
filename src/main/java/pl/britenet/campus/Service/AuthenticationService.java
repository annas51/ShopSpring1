package pl.britenet.campus.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.britenet.campus.model.CustomerCredentials;
import pl.britenet.campus.model.CustomerLoginData;
import pl.britenet.campus.object.Customer;
import pl.britenet.campus.service.CustomerService;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthenticationService {

    private final Map<String, Integer> activeTokens;
    private final CustomerService customerService;

    @Autowired
    public AuthenticationService(CustomerService customerService) {
        this.activeTokens = new HashMap<>();
        this.customerService = customerService;
    }

   public CustomerLoginData login(CustomerCredentials customerCredentials) {
       String passwordToHash = customerCredentials.getPassword();
       String generatedPassword = null;

       try
       {
           MessageDigest md = MessageDigest.getInstance("MD5");

           md.update(passwordToHash.getBytes());

           byte[] bytes = md.digest();

           StringBuilder sb = new StringBuilder();
           for (int i = 0; i < bytes.length; i++) {
               sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
           }

           generatedPassword = sb.toString();
       } catch (NoSuchAlgorithmException e) {
           e.printStackTrace();
       }
       Optional<Customer> oCustomer = this.customerService.getCustomerPass(customerCredentials.getEmail(),
               generatedPassword);
        if (oCustomer.isPresent()) {
            int customerId = oCustomer.get().getCustomerId();
            String customerToken = UUID.randomUUID().toString();
            this.activeTokens.put(customerToken, customerId);
            return new CustomerLoginData(customerId, customerToken);
        }
        else {
            throw new IllegalStateException("Invalid credentials.");
        }
    }

    public boolean isLogged(String customerToken) {
        return this.activeTokens.containsKey(customerToken);
    }



    public int getCustomerId(String token) {
        return this.activeTokens.get(token);
    }
    public void register(Customer customer) {
        String passwordToHash = customer.getPassword();
        String generatedPassword = null;

        try
        {
            MessageDigest md = MessageDigest.getInstance("MD5");

            md.update(passwordToHash.getBytes());

            byte[] bytes = md.digest();

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        System.out.println(generatedPassword);


        customer.setPassword(generatedPassword);
        this.customerService.addCustomer(customer);

        String customerToken = UUID.randomUUID().toString();
        this.activeTokens.put(customerToken, customer.getCustomerId());
        CustomerLoginData customerLoginData = new CustomerLoginData(customer.getCustomerId(), customerToken);
        System.out.println(customerLoginData);


    }

    }
