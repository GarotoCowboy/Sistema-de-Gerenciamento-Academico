package br.com.academico.sistema.sistemaacademico.models;


import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "secretaria")
@PrimaryKeyJoinColumn(name = "matricula")
public class Secretaria extends  Pessoa  {

    public Secretaria(Long matricula, Long cpf, String nome, int idade, String sexo, String linkFoto, String senha, String email, String dataCriacao, String dataTermino) {
        super(matricula, cpf, nome, idade, sexo, linkFoto, senha, email, dataCriacao, dataTermino);
        setTipo("Secretaria");
    }
}
