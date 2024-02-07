package io.github.gabrieldarezzo.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemOrderDTO {
    private Integer product;
    private Integer amount;

}
