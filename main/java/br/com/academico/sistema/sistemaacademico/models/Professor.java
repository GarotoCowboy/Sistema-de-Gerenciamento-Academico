package br.com.academico.sistema.sistemaacademico.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "professor")
@PrimaryKeyJoinColumn(name = "prof_matricula")
public class Professor extends Pessoa  {

    @ManyToMany(mappedBy = "professores")
    private Set<Disciplina> disciplinas = new HashSet<>();

    public Professor() {
    }

    public Professor(Long matricula, Long cpf, String nome, int idade, String sexo, String linkFoto, String senha, String email, String dataCriacao, String dataTermino) {
        super(matricula, cpf, nome, idade, sexo, linkFoto, senha, email, dataCriacao, dataTermino);
        setTipo("Professor");
    }

    public Set<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(Set<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }
}
