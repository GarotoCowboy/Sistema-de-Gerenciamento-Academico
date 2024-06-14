package br.com.academico.sistema.sistemaacademico.models;


import jakarta.persistence.*;

import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "aluno")
@PrimaryKeyJoinColumn(name = "aluno_matricula")
public class Aluno extends Pessoa {


//    @ManyToMany(mappedBy = "alunos")
//    private Set<Turma> turmas = new HashSet<>();

//    @ManyToMany(mappedBy = "alunos")
//    private Set<Disciplina> disciplinas = new HashSet<>();

    @OneToMany(mappedBy = "aluno")
    Set<TurmaAluno> turmaAlunos = new HashSet<>();

    @OneToMany(mappedBy = "aluno")
    Set<AlunoDisciplina> alunoDisciplinas = new HashSet<>();

    public Aluno() {
    }

    public Aluno(Long matricula, Long cpf, String nome, int idade, String sexo, String linkFoto, String senha, String email, String dataCriacao, String dataTermino) {
        super(matricula, cpf, nome, idade, sexo, linkFoto, senha, email, dataCriacao, dataTermino);
        setTipo("Aluno");
    }


//    public Set<Disciplina> getDisciplinas() {
//        return disciplinas;
//    }
//
//    public void setDisciplinas(Set<Disciplina> disciplinas) {
//        this.disciplinas = disciplinas;
//    }

//    public Set<Turma> getTurmas() {
//        return turmas;
//    }
//
//    public void setTurmas(Set<Turma> turmas) {
//        this.turmas = turmas;
//    }


    public Set<TurmaAluno> getTurmaAlunos() {
        return turmaAlunos;
    }

    public void setTurmaAlunos(Set<TurmaAluno> turmaAlunos) {
        this.turmaAlunos = turmaAlunos;
    }

    public Set<AlunoDisciplina> getAlunoDisciplinas() {
        return alunoDisciplinas;
    }

    public void setAlunoDisciplinas(Set<AlunoDisciplina> alunoDisciplinas) {
        this.alunoDisciplinas = alunoDisciplinas;
    }
}
