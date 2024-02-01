package io.github.gabrieldarezzo.domain.repositorio;

import io.github.gabrieldarezzo.domain.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ClientesJdbcTemplate {
    private static String INSERT = "INSERT INTO cliente (nome) values (?) ";
    private static String UPDATE = "UPDATE cliente SET nome = ? WHERE id = ? ";

    private static String DELETE = "DELETE FROM cliente WHERE id = ? ";
    private static String SELECT_ALL = "SELECT * FROM cliente ";

    private static String SELECT_NAME = "SELECT * FROM cliente where nome like ? ";


    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Cliente atualizar(Cliente cliente){
        jdbcTemplate.update(UPDATE,
                new Object[]{cliente.getNome(),cliente.getId()});
        return cliente;
    }

    public Cliente salvar(Cliente cliente){
        jdbcTemplate.update(INSERT, new Object[]{cliente.getNome()});
        return cliente;
    }

    public void deletar(Integer id){
        jdbcTemplate.update(DELETE, new Object[]{id});
    }
    public List<Cliente> obeterTodos(){
        return jdbcTemplate.query(SELECT_ALL, obterMapperCliente());
    }

    public List<Cliente> buscaPorNome(String nome){
        return jdbcTemplate.query(
                SELECT_NAME,
                new Object[]{"%" +  nome + "%"},
                obterMapperCliente());
    }

    private static RowMapper<Cliente> obterMapperCliente() {
        return new RowMapper<Cliente>() {
            @Override
            public Cliente mapRow(ResultSet resultSet, int i) throws SQLException {
                Integer id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");

                return new Cliente(id, nome);
            }
        };
    }

}
