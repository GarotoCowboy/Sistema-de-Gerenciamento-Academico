package br.com.academico.sistema.sistemaacademico.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "aluno_disciplina")
public class AlunoDisciplina {

    @EmbeddedId
    private AlunoDisciplinaId id;

    @ManyToOne
    @MapsId("idDisciplina")
    @JoinColumn(name = "id_disciplina")
    private Disciplina disciplina;

    @ManyToOne
    @MapsId("matriculaAluno")
    @JoinColumn(name = "matricula_aluno")
    private Aluno aluno;

    private boolean aprovado;

    private Double nota;

    public AlunoDisciplina() {
    }

    public AlunoDisciplina(Disciplina disciplina, Aluno aluno, boolean status, Double nota) {
        this.disciplina = disciplina;
        this.aluno = aluno;
        this.aprovado = status;
        this.nota = nota;
    }

    public AlunoDisciplinaId getId() {
        return id;
    }

    public void setId(AlunoDisciplinaId id) {
        this.id = id;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public boolean isAprovado() {
        return aprovado;
    }

    public void setAprovado(boolean aprovado) {
        this.aprovado = aprovado;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        AlunoDisciplina that = (AlunoDisciplina) object;
        return aprovado == that.aprovado && Objects.equals(id, that.id) && Objects.equals(disciplina, that.disciplina) && Objects.equals(aluno, that.aluno) && Objects.equals(nota, that.nota);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, disciplina, aluno, aprovado, nota);
    }
}
