package io.github.gabrieldarezzo.domain.repository;
import io.github.gabrieldarezzo.domain.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface OrderRepository extends JpaRepository<Order, Integer> {

    // @Query("select o from customer_order o left join fetch o.itens where o.id = :orderId")
    // Optional<Order> findByIdFetchItens(@Param("id") Integer orderId);

    @Query("SELECT o FROM Order o LEFT JOIN FETCH o.itens WHERE o.id = :orderId")
    Optional<Order> findByIdFetchItens(@Param("orderId") Integer orderId);

}
