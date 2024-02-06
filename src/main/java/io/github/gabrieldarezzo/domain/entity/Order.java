package io.github.gabrieldarezzo.domain.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "customer_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "date_order")
    private LocalDate dateOrder;

    @Column(name = "total", precision = 20, scale = 2, columnDefinition = "DECIMAL(10,2)")
    private BigDecimal total;

    @OneToMany(mappedBy = "order")
    private List<ItemOrder> itens;


}
