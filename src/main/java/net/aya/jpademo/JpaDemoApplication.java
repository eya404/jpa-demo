package net.aya.jpademo;

import net.aya.jpademo.Entities.Product;
import net.aya.jpademo.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {
    @Autowired
    private ProductRepository productRepository;
    public static void main(String[] args) {
        SpringApplication.run(JpaDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception{
        productRepository.save(new Product(null,"Laptop",1000.0,10));
        productRepository.save(new Product(null,"Mobile",500.0,15));
        productRepository.save(new Product(null,"Tablet",300.0,5));

        List<Product> products = productRepository.findByNameContainsIgnoreCase("m");
        // findByNameContains("m");
        products.forEach(p->{
            System.out.println(p.getName());
            System.out.println(p.getPrice());
            System.out.println(p.getQuantity());
        });
    }

}
