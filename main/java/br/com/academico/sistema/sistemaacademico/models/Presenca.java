package br.com.academico.sistema.sistemaacademico.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "presenca")
public class Presenca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_presenca", nullable = false)
    private Long idPresenca;

    @ManyToOne()
    @JoinColumn(name = "fk_id_disciplina")
    private Disciplina fkIdDisciplina;

    @Column(nullable = false)
    private String justificativa;

    @Column(nullable = false)
    private String data;

    @Column(nullable = false)
    private boolean ausente;

    @ManyToMany(mappedBy = "presencas")
    private Set<Turma> turmas = new HashSet<>();

    public Presenca() {
    }

    public Presenca(Long idPresenca, Disciplina fkIdDisciplina, String justificativa, String data, boolean ausente) {
        this.idPresenca = idPresenca;
        this.fkIdDisciplina = fkIdDisciplina;
        this.justificativa = justificativa;
        this.data = data;
        this.ausente = ausente;
    }

    public Set<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(Set<Turma> turmas) {
        this.turmas = turmas;
    }

    public Long getIdPresenca() {
        return idPresenca;
    }

    public void setIdPresenca(Long idPresenca) {
        this.idPresenca = idPresenca;
    }

    public Disciplina getFkIdDisciplina() {
        return fkIdDisciplina;
    }

    public void setFkIdDisciplina(Disciplina fkIdDisciplina) {
        this.fkIdDisciplina = fkIdDisciplina;
    }

    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public boolean isAusente() {
        return ausente;
    }

    public void setAusente(boolean ausente) {
        this.ausente = ausente;
    }
}
