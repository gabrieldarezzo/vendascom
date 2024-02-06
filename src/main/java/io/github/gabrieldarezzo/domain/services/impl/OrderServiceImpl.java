package io.github.gabrieldarezzo.domain.services.impl;


import io.github.gabrieldarezzo.domain.repository.OrderRepository;
import io.github.gabrieldarezzo.domain.services.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
}
