package io.github.gabrieldarezzo.domain.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Pedido {
    private Integer id;
    private Cliente Cliente;
    private LocalDate dataPedido;
    private BigDecimal total;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public io.github.gabrieldarezzo.domain.entity.Cliente getCliente() {
        return Cliente;
    }

    public void setCliente(io.github.gabrieldarezzo.domain.entity.Cliente cliente) {
        Cliente = cliente;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
