package io.github.gabrieldarezzo.domain.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;



@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name = "id")
    private Integer id;

    @NotEmpty(message = "field 'description' is required.")
    @Column(name = "description", length = 100)
    private String description;

    @NotNull(message = "field 'unit_price' is required.")
    @Column(name = "unit_price", precision = 20, scale = 2, columnDefinition = "DECIMAL(10,2)")
    private BigDecimal UnitPrice;
}
