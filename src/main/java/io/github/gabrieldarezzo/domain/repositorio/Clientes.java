package io.github.gabrieldarezzo.domain.repositorio;
import io.github.gabrieldarezzo.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface Clientes extends JpaRepository<Cliente, Integer> {
    List<Cliente> findByNomeStartsWith(String nome);
}
