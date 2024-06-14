package br.com.academico.sistema.sistemaacademico.models;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "disciplina")
public class Disciplina   {

    @Id
    @Column(name = "id_disciplina")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDisciplina;

    @ManyToOne()
    @JoinColumn(name = "fk_id_professor",nullable = true)
    private Professor fk_id_professor;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String descricao;

    @Column(name = "carga_horaria",
            nullable = false)
    private int cargaHoraria;

    //private double notas;

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "aluno_disciplina",
//                joinColumns = @JoinColumn (name = "fk_id_disciplina"),
//                 inverseJoinColumns = @JoinColumn(name = "fk_matricula_aluno")
//    )
//    private Set<Aluno> alunos = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "curso_disciplina",
                joinColumns = @JoinColumn(name = "fk_id_disciplina"),
                 inverseJoinColumns = @JoinColumn(name = "fk_id_curso")
    )
    private  Set<Curso> cursos = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
        @JoinTable(
                name = "professor_disciplina",
                joinColumns = @JoinColumn(name = "fk_id_disciplina"),
                inverseJoinColumns = @JoinColumn(name = "fk_matricula_professor")
        )
    private Set<Professor> professores = new HashSet<>();

//    @ManyToMany(cascade =  CascadeType.ALL)
//        @JoinTable(
//                name = "aluno_disciplina",
//                joinColumns = @JoinColumn(name = "fk_id_disciplina"),
//                inverseJoinColumns = @JoinColumn(name = "fk_id_matricula_aluno")
//        )
//    private Set<Aluno> alunos = new HashSet<>();

    @OneToMany(mappedBy = "disciplina")
    Set<AlunoDisciplina> alunoDisciplinas = new HashSet<>();

    public Disciplina() {

    }

    public Disciplina(Long idDisciplina, Professor fk_id_professor, String nome, String descricao, int cargaHoraria/*, double notas*/) {
        this.idDisciplina = idDisciplina;
        this.fk_id_professor = fk_id_professor;
        this.nome = nome;
        this.descricao = descricao;
        this.cargaHoraria = cargaHoraria;
        //this.notas = notas;
    }



    public Set<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(Set<Professor> professores) {
        this.professores = professores;
    }

    public Set<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(Set<Curso> cursos) {
        this.cursos = cursos;
    }

//    public double getNotas() {
//        return notas;
//    }
//
//    public void setNotas(double notas) {
//        this.notas = notas;
//    }

    public Set<AlunoDisciplina> getAlunoDisciplinas() {
        return alunoDisciplinas;
    }

    public void setAlunoDisciplinas(Set<AlunoDisciplina> alunoDisciplinas) {
        this.alunoDisciplinas = alunoDisciplinas;
    }

    public Long getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(Long idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public Professor getFk_id_professor() {
        return fk_id_professor;
    }

    public void setFk_id_professor(Professor fk_id_professor) {
        this.fk_id_professor = fk_id_professor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }


}
