package br.com.academico.sistema.sistemaacademico.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class TurmaAlunoId {

    @Column(name = "fk_matricula_aluno")
    private Long matriculaAluno;

    @Column(name = "id_turma")
    private Long idTurma;

    public TurmaAlunoId() {
    }

    public TurmaAlunoId(Long matriculaAluno, Long idTurma) {
        this.matriculaAluno = matriculaAluno;
        this.idTurma = idTurma;
    }

    public Long getMatriculaAluno() {
        return matriculaAluno;
    }

    public void setMatriculaAluno(Long matriculaAluno) {
        this.matriculaAluno = matriculaAluno;
    }

    public Long getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(Long idTurma) {
        this.idTurma = idTurma;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        TurmaAlunoId that = (TurmaAlunoId) object;
        return Objects.equals(matriculaAluno, that.matriculaAluno) && Objects.equals(idTurma, that.idTurma);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matriculaAluno, idTurma);
    }
}
