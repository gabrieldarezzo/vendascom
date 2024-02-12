package io.github.gabrieldarezzo.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @NotEmpty(message = "Field name is required.")
    @Column(name = "name", length = 100)
    private String name;

    @NotEmpty(message = "Field cpf is required.")
    @CPF(message =  "Field cpf must be valid.")
    @Column(name = "cpf", length = 11)
    private String cpf;

}
