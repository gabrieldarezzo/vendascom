package io.github.gabrieldarezzo.rest.dto;

import java.math.BigDecimal;
import java.util.List;

public class OrderDTO {

    private Integer cliente;
    private BigDecimal total;
    private List<ItemOrderDTO> items;

}
