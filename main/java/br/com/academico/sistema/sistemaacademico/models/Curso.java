package br.com.academico.sistema.sistemaacademico.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "curso")
public class Curso  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso")
    private Long idCurso;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String descricao;

    @Column(name = "carga_horaria",
            nullable = false)
    private int cargaHoraria;

    @Column(name = "sala_d_aula",
            nullable = false)
    private String salaDAula;

    @Column(nullable = false)
    private String horario;

    @ManyToMany(mappedBy = "cursos")
    private Set<Disciplina> disciplinas = new HashSet<>();


    public Curso() {
    }

    public Curso(Long idCurso, String nome, String descricao, int cargaHoraria, String salaDAula, String horario) {
        this.idCurso = idCurso;
        this.nome = nome;
        this.descricao = descricao;
        this.cargaHoraria = cargaHoraria;
        this.salaDAula = salaDAula;
        this.horario = horario;
    }

    public Set<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(Set<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public Long getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Long idCurso) {
        this.idCurso = idCurso;
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

    public String getSalaDAula() {
        return salaDAula;
    }

    public void setSalaDAula(String salaDAula) {
        this.salaDAula = salaDAula;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }


    @Override
    public String toString() {
        return "Curso{" +
                "idCurso=" + idCurso +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", cargaHoraria=" + cargaHoraria +
                ", salaDAula='" + salaDAula + '\'' +
                ", horario='" + horario + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Curso curso = (Curso) o;
        return cargaHoraria == curso.cargaHoraria && Objects.equals(idCurso, curso.idCurso) && Objects.equals(nome, curso.nome) && Objects.equals(descricao, curso.descricao) && Objects.equals(salaDAula, curso.salaDAula) && Objects.equals(horario, curso.horario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCurso, nome, descricao, cargaHoraria, salaDAula, horario);
    }
}
