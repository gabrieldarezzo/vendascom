package io.github.gabrieldarezzo.domain.services;


import io.github.gabrieldarezzo.domain.entity.Order;
import io.github.gabrieldarezzo.rest.dto.OrderDTO;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {
    Order save(OrderDTO dto);

}
