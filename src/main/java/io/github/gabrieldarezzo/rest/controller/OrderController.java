package io.github.gabrieldarezzo.rest.controller;
import io.github.gabrieldarezzo.domain.entity.Order;
import io.github.gabrieldarezzo.domain.entity.Product;
import io.github.gabrieldarezzo.domain.repository.OrderRepository;
import io.github.gabrieldarezzo.domain.services.OrderService;
import io.github.gabrieldarezzo.rest.dto.OrderDTO;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/orders")
public class OrderController {

    private OrderService orderService;

     public OrderController(OrderService orderService) {
         this.orderService = orderService;
     }

     @PostMapping
     @ResponseStatus(HttpStatus.CREATED)
     public Integer save(@RequestBody OrderDTO dto) {
         // System.out.println(dto.toString());
         // return 1;
         Order order = orderService.save(dto);
         return order.getId();
     }




}
