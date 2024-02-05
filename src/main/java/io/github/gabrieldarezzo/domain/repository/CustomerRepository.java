package io.github.gabrieldarezzo.domain.repository;
import io.github.gabrieldarezzo.domain.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findByNameStartsWith(String nome);

    @Query(value = "select * from customer c where c.name like '%:name%'", nativeQuery = true)
    List<Customer> customFindByName(@Param("name") String name);

}
