package io.github.gabrieldarezzo;


import io.github.gabrieldarezzo.domain.entity.Customer;
import io.github.gabrieldarezzo.domain.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class SellingApplication {
    @Value("${application.name}")
    private String applicationName;


     @Bean
    public CommandLineRunner init(@Autowired CustomerRepository customerRepository){
        return args -> {
            System.out.println("Salvando Clientes");
            customerRepository.save(new Customer(null, "Darezzo"));
            customerRepository.save(new Customer(null, "Sousa"));
        };

    }

    @GetMapping("/hello")
    public String helloWorld() {
        return applicationName;
    }

    public static void main(String[] args) {
        SpringApplication.run(SellingApplication.class, args);
    }
}
