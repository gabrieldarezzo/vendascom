package io.github.gabrieldarezzo.rest.controller;
import io.github.gabrieldarezzo.domain.entity.Order;
import io.github.gabrieldarezzo.domain.entity.Product;
import io.github.gabrieldarezzo.domain.repository.OrderRepository;
import io.github.gabrieldarezzo.domain.services.OrderService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderRepository orderRepository;
    private OrderService orderService;

     public OrderController(OrderService orderService, OrderRepository orderRepository) {
         this.orderService = orderService;
         this.orderRepository = orderRepository;
     }


    @GetMapping("")
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

}
