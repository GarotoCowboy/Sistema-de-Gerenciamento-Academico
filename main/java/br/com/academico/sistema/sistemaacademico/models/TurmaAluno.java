package br.com.academico.sistema.sistemaacademico.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "turma_aluno")
public class TurmaAluno implements Serializable {

    @EmbeddedId
    private TurmaAlunoId id;

    @ManyToOne
    @MapsId("idTurma")
    @JoinColumn(name = "id_turma")
    private Turma turma;

    @ManyToOne
    @MapsId("matriculaAluno")
    @JoinColumn(name = "matricula_aluno")
    private Aluno aluno;

    private String dataAlocacao;

    public TurmaAluno() {
    }

    public TurmaAluno(Turma turma, Aluno aluno, String dataAlocacao) {
        this.turma = turma;
        this.aluno = aluno;
        this.dataAlocacao = dataAlocacao;
    }

    public TurmaAlunoId getId() {
        return id;
    }

    public void setId(TurmaAlunoId id) {
        this.id = id;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public String getDataAlocacao() {
        return dataAlocacao;
    }

    public void setDataAlocacao(String dataAlocacao) {
        this.dataAlocacao = dataAlocacao;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        TurmaAluno that = (TurmaAluno) object;
        return Objects.equals(id, that.id) && Objects.equals(turma, that.turma) && Objects.equals(aluno, that.aluno) && Objects.equals(dataAlocacao, that.dataAlocacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, turma, aluno, dataAlocacao);
    }
}
