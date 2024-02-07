package io.github.gabrieldarezzo.domain.repository;
import io.github.gabrieldarezzo.domain.entity.ItemOrder;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ItemOrderRepository extends JpaRepository<ItemOrder, Integer> {
}
