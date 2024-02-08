package io.github.gabrieldarezzo.domain.services;


import io.github.gabrieldarezzo.domain.entity.Order;
import io.github.gabrieldarezzo.domain.enums.StatusOrder;
import io.github.gabrieldarezzo.rest.dto.OrderDTO;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface OrderService {
    Order save(OrderDTO dto);
    Optional<Order> getFullOrder(Integer orderId);

    void updateStatus(Integer orderId, StatusOrder statusOrder);
}
