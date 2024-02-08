package io.github.gabrieldarezzo.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetailOrderDTO {
    private Integer orderId;
    private String customerName;
    private String cpf;
    private BigDecimal total;
    private String dateOrder;
    private String status;
    private List<DetailtemsOrderDTO> itemsOrder;
}
