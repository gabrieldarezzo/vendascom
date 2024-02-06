package io.github.gabrieldarezzo.domain.repository;
import io.github.gabrieldarezzo.domain.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;



public interface OrderRepository extends JpaRepository<Order, Integer> {
}
