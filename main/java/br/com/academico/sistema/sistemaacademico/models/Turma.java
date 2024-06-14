package br.com.academico.sistema.sistemaacademico.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "turma")
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_turma")
    private Long idTurma;

    @ManyToOne
    @JoinColumn(name = "fk_id_curso")
    private Curso fkIdCurso;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private int periodo;

    @Column (name = "qntd_aluno")
    private int qntdAluno;

//    @ManyToMany(cascade = CascadeType.ALL)
//            @JoinTable(
//                    name = "turma_aluno",
//                    joinColumns = @JoinColumn(name = "fk_id_turma"),
//                    inverseJoinColumns = @JoinColumn(name = "fk_matricula_aluno")
//            )
//    private Set<Aluno> alunos = new HashSet<>();

    @OneToMany(mappedBy = "turma")
    private Set<TurmaAluno> turmaAlunos = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
            @JoinTable(
                    name = "turma_disciplina",
                    joinColumns = @JoinColumn(name = "fk_id_turma"),
                    inverseJoinColumns = @JoinColumn(name = "fk_id_presenca")
            )
    private Set<Presenca> presencas = new HashSet<>();

    public Turma(Long idTurma, Curso fkIdCurso, String nome, int periodo, int qntdAluno) {
        this.idTurma = idTurma;
        this.fkIdCurso = fkIdCurso;
        this.nome = nome;
        this.periodo = periodo;
        this.qntdAluno = qntdAluno;
    }

    public Turma() {
    }

    public Set<Presenca> getPresencas() {
        return presencas;
    }

    public void setPresencas(Set<Presenca> presencas) {
        this.presencas = presencas;
    }

    public Long getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(Long idTurma) {
        this.idTurma = idTurma;
    }

    public Curso getFkIdCurso() {
        return fkIdCurso;
    }

    public void setFkIdCurso(Curso fkIdCurso) {
        this.fkIdCurso = fkIdCurso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public int getQntdAluno() {
        return qntdAluno;
    }

    public void setQntdAluno(int qntdAluno) {
        this.qntdAluno = qntdAluno;
    }

//    public Set<Aluno> getAlunos() {
//        return alunos;
//    }
//
//    public void setAlunos(Set<Aluno> alunos) {
//        this.alunos = alunos;
//    }


    public Set<TurmaAluno> getTurmaAlunos() {
        return turmaAlunos;
    }

    public void setTurmaAlunos(Set<TurmaAluno> turmaAlunos) {
        this.turmaAlunos = turmaAlunos;
    }
}
