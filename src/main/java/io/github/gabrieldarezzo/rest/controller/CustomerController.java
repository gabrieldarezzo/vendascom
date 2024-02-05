package io.github.gabrieldarezzo.rest.controller;

// import org.springframework.http.ResponseEntity;
import io.github.gabrieldarezzo.domain.entity.Customer;
import io.github.gabrieldarezzo.domain.repository.CustomerRepository;
import net.bytebuddy.asm.Advice;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    private CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @GetMapping("")
    @ResponseBody
    public ResponseEntity findByFields(Customer filterCustomer) {

        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example example = Example.of(filterCustomer, matcher);
        List<Customer> customerList = customerRepository.findAll(example);

        return ResponseEntity.ok(customerList);

    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity getCustomerById(@PathVariable Integer id) {
        Optional<Customer> customer = customerRepository.findById(id);

        if(customer.isPresent()) {
            return ResponseEntity.ok(customer.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping("")
    @ResponseBody
    public ResponseEntity save(@RequestBody Customer customer) {
        Customer customerSaved = customerRepository.save(customer);
        return ResponseEntity.ok(customerSaved);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity delete(@PathVariable Integer id) {
        Optional<Customer> customer = customerRepository.findById(id);

        if(customer.isPresent()) {
            customerRepository.delete(customer.get());
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }


    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity update(@PathVariable Integer id, @RequestBody Customer customer) {
        return customerRepository.findById(id).map(customerFound -> {
            customer.setId(customerFound.getId());
            customerRepository.save(customer);
            return ResponseEntity.noContent().build();
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
