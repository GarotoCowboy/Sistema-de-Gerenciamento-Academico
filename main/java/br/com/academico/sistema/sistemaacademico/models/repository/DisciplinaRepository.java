package br.com.academico.sistema.sistemaacademico.models.repository;

import br.com.academico.sistema.sistemaacademico.models.Aluno;
import br.com.academico.sistema.sistemaacademico.models.Curso;
import br.com.academico.sistema.sistemaacademico.models.Disciplina;
import br.com.academico.sistema.sistemaacademico.models.Professor;

import java.util.List;
import java.util.Optional;

public interface DisciplinaRepository {

    void insert(Disciplina disciplina);

    Optional<Disciplina> findById(String idDisciplina);

    List<Disciplina> FindAll();

    void delete(Disciplina disciplina, String idDisciplina);

    void update(Disciplina disciplina, String idDisciplina, String cargaHoraria, String descricao,
                String nome, Professor fkMatriculaProf);








}
