package io.github.gabrieldarezzo.domain.entity;

import io.github.gabrieldarezzo.domain.enums.StatusOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "customer_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "date_order")
    private LocalDate dateOrder;

    @Column(name = "total", precision = 20, scale = 2, columnDefinition = "DECIMAL(10,2)")
    private BigDecimal total;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusOrder statusOrder;


    @OneToMany(mappedBy = "order")
    private List<ItemOrder> itens;


}
