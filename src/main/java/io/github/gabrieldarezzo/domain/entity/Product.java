package io.github.gabrieldarezzo.domain.entity;

import lombok.*;

import javax.persistence.*;
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
    @Column(name = "description", length = 100)
    private String description;

    @Column(name = "unit_price", precision = 20, scale = 2, columnDefinition = "DECIMAL(10,2)")
    private BigDecimal UnitPrice;
}
