package io.github.gabrieldarezzo;


import io.github.gabrieldarezzo.domain.entity.Cliente;
import io.github.gabrieldarezzo.domain.repositorio.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@SpringBootApplication
@RestController
public class SellingApplication {
    @Value("${application.name}")
    private String applicationName;


    @Bean
    public CommandLineRunner init(@Autowired Clientes clientes){
        return args -> {
            System.out.println("Salvando Clientes");
            clientes.save(new Cliente("Darezzo"));
            clientes.save(new Cliente("Roberto"));


//            System.out.println("Exibindo todos os Clientes\n####");
//            List<Cliente> todosClientes = clientes.findAll();
//            todosClientes.forEach(System.out::println);
//
//
//            System.out.println("Atualizando Clientes");
//            todosClientes.forEach(c -> {
//                c.setNome(c.getNome() + " Atualizado");
//                clientes.save(c);
//            });
//            System.out.println("Atualizado com sucesso");

            System.out.println("Buscando Cliente");
            clientes.findByNomeStartsWith("Dar").forEach(System.out::println);

//            System.out.println("Obter todos os Clientes\n####");
//            clientes.findAll().forEach(c -> {
//                clientes.delete(c);
//            });
//
//
//            System.out.println("Exibindo todos os Clientes\n####");
//            todosClientes = clientes.findAll();
//            todosClientes.forEach(System.out::println);


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
