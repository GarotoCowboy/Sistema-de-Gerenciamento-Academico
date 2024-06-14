package br.com.academico.sistema.sistemaacademico.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AlunoDisciplinaId  implements Serializable {

    @Column(name = "id_disciplina")
    private Long idDisciplina;

    @Column(name = "matricula_aluno")
    private Long matriculaAluno;

    public AlunoDisciplinaId() {
    }

    public AlunoDisciplinaId(Long idDisciplina, Long matriculaAluno) {
        this.idDisciplina = idDisciplina;
        this.matriculaAluno = matriculaAluno;
    }

    public Long getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(Long idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public Long getMatriculaAluno() {
        return matriculaAluno;
    }

    public void setMatriculaAluno(Long matriculaAluno) {
        this.matriculaAluno = matriculaAluno;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        AlunoDisciplinaId that = (AlunoDisciplinaId) object;
        return Objects.equals(idDisciplina, that.idDisciplina) && Objects.equals(matriculaAluno, that.matriculaAluno);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDisciplina, matriculaAluno);
    }
}
