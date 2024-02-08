package io.github.gabrieldarezzo.rest.controller;
import io.github.gabrieldarezzo.domain.entity.ItemOrder;
import io.github.gabrieldarezzo.domain.entity.Order;
import io.github.gabrieldarezzo.domain.enums.StatusOrder;
import io.github.gabrieldarezzo.domain.services.OrderService;
import io.github.gabrieldarezzo.rest.dto.DetailOrderDTO;
import io.github.gabrieldarezzo.rest.dto.DetailtemsOrderDTO;
import io.github.gabrieldarezzo.rest.dto.OrderDTO;
import io.github.gabrieldarezzo.rest.dto.UpdateStatusOrderDTO;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


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
         Order order = orderService.save(dto);
         return order.getId();
     }

    @GetMapping("{id}")
    public DetailOrderDTO getById(@PathVariable Integer id) {
         return orderService
            .getFullOrder(id)
             .map(order -> converterOrder(order))
             .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found:" + id));

    }

    @PatchMapping("status/{orderId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateStatus(@PathVariable Integer orderId, @RequestBody UpdateStatusOrderDTO newStatusOrderDTO) {
        String newStatusOrder = newStatusOrderDTO.getNewStatusOrder();
        orderService.updateStatus(orderId, StatusOrder.valueOf(newStatusOrder));
    }


    private DetailOrderDTO converterOrder(Order order) {
        return DetailOrderDTO
                .builder()
                .orderId(order.getId())
                .dateOrder(order.getDateOrder().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                .cpf(order.getCustomer().getCpf())
                .customerName(order.getCustomer().getName())
                .total(order.getTotal())
                .status(order.getStatusOrder().name())
                .itemsOrder(converterItemsOrder(order.getItens()))
                .build();
    }

    private List<DetailtemsOrderDTO> converterItemsOrder(List<ItemOrder> items) {

         if(CollectionUtils.isEmpty(items)) {
             return Collections.emptyList();
         }

         return items.stream().map(
                 item -> DetailtemsOrderDTO
                         .builder()
                         .descriptionProduct(item.getProduct().getDescription())
                         .unitPrice(item.getProduct().getUnitPrice())
                         .amout(item.getAmount())
                         .build()
         ).collect(Collectors.toList());
    }
}
