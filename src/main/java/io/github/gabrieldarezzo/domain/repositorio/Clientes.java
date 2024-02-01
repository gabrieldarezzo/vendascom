package io.github.gabrieldarezzo.domain.repositorio;
import io.github.gabrieldarezzo.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface Clientes extends JpaRepository<Cliente, Integer> {
    List<Cliente> findByNomeStartsWith(String nome);

    @Query(value = "select * from Cliente c where c.nome like '%:nome%'", nativeQuery = true)
    List<Cliente> customFindByNome(@Param("nome") String nome);

}
