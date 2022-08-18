package pl.britenet.campus.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.britenet.campus.database.DatabaseService;
import pl.britenet.campus.service.*;

@Configuration
public class ServiceConfig {

    private final DatabaseService databaseService;
    @Autowired

    public ServiceConfig(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }
    @Bean

    public ProductService getProductService() {
        return new ProductService(this.databaseService);
    }
    @Bean

    public CartService getCartService() {
        return new CartService(this.databaseService);
    }
    @Bean

    public OrderService getOrderService() {
        return new OrderService(this.databaseService);
    }
    @Bean

    public CartProductService getCartProductService () {
        return new CartProductService(this.databaseService);
    }
    @Bean

    public CustomerService getCustomerService() {return new CustomerService(this.databaseService);}

    @Bean
    public OrderProductService getOrderProductService() {
        return new OrderProductService(this.databaseService);
    }

    @Bean
    public ImgService getImgService(){return new ImgService(this.databaseService);}





}
