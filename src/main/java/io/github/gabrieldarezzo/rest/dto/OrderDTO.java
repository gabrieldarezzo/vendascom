package io.github.gabrieldarezzo.rest.dto;

import io.github.gabrieldarezzo.validation.NotEmptyList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDTO {

    @NotNull(message = "The field 'customerId' is required")
    private Integer customer;
    @NotNull(message = "The field 'total' is required")
    private BigDecimal total;
    @NotEmptyList(message = "array 'items' is required!")
    private List<ItemOrderDTO> items;

}
