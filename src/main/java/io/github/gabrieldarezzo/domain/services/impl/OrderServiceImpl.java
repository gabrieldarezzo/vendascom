package io.github.gabrieldarezzo.domain.services.impl;


import io.github.gabrieldarezzo.domain.entity.Customer;
import io.github.gabrieldarezzo.domain.entity.ItemOrder;
import io.github.gabrieldarezzo.domain.entity.Order;
import io.github.gabrieldarezzo.domain.entity.Product;
import io.github.gabrieldarezzo.domain.repository.CustomerRepository;
import io.github.gabrieldarezzo.domain.repository.ItemOrderRepository;
import io.github.gabrieldarezzo.domain.repository.OrderRepository;
import io.github.gabrieldarezzo.domain.repository.ProductRepository;
import io.github.gabrieldarezzo.domain.services.OrderService;
import io.github.gabrieldarezzo.exception.NotFoundCustomerException;
import io.github.gabrieldarezzo.exception.NotFoundProductException;
import io.github.gabrieldarezzo.rest.dto.ItemOrderDTO;
import io.github.gabrieldarezzo.rest.dto.OrderDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;
    private final ItemOrderRepository itemOrderRepository;

    @Override
    @Transactional
    public Order save(OrderDTO dto) {
        Integer customerId = dto.getCustomer();

        Customer customer = customerRepository
                .findById(customerId)
                .orElseThrow(() -> new NotFoundCustomerException("customerId not found"));

        System.out.println("DTO" + dto.toString());

        Order order = new Order();
        order.setTotal(dto.getTotal());
        order.setDateOrder(LocalDate.now());
        order.setCustomer(customer);

        System.out.println("customer" + customer.toString());

        List<ItemOrder> itemsOrder = convertItens(order, dto.getItems());
        orderRepository.save(order);
        itemOrderRepository.saveAll(itemsOrder);
        order.setItens(itemsOrder);
        return order;
    }


    private List<ItemOrder> convertItens(Order order, List<ItemOrderDTO> itemsDto){
        if(itemsDto.isEmpty()){
            new NotFoundCustomerException("itens is empty");
        }

        return itemsDto
                .stream()
                .map( dto -> {
                    Integer productId = dto.getProduct();
                    System.out.println("#### productId:" + productId);
                    Product product = productRepository
                            .findById(productId)
                            .orElseThrow(
                                    () -> new NotFoundProductException("productId not found: " + productId)
                            );

                    ItemOrder itemOrder = new ItemOrder();
                    itemOrder.setAmount(dto.getAmount());
                    itemOrder.setOrder(order);
                    itemOrder.setProduct(product);

                    return itemOrder;
                }).collect(Collectors.toList());
    }
}
