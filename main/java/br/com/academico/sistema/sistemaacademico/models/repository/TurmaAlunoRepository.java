package br.com.academico.sistema.sistemaacademico.models.repository;

import br.com.academico.sistema.sistemaacademico.models.Turma;
import br.com.academico.sistema.sistemaacademico.models.TurmaAluno;

import java.util.List;
import java.util.Optional;

public interface TurmaAlunoRepository {

    void insert(TurmaAluno turma);

    Optional<TurmaAluno> findByMatriculaAluno(String matricula);

    Optional<TurmaAluno> findByTurmaId(String id);

    List<TurmaAluno> FindAll();

    void delete(TurmaAluno turmaAluno);

    void update(TurmaAluno turmaAluno);
}
