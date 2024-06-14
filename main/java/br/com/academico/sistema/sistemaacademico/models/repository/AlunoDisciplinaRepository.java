package br.com.academico.sistema.sistemaacademico.models.repository;

import br.com.academico.sistema.sistemaacademico.models.AlunoDisciplina;
import br.com.academico.sistema.sistemaacademico.models.Disciplina;

import java.util.List;
import java.util.Optional;

public interface AlunoDisciplinaRepository {

    void insert(AlunoDisciplina Alunodisciplina);

    Optional<Disciplina> findByMatriculaALuno(String matricula);

    Optional<Disciplina> findByIdCurso(String idCurso);


    List<Disciplina> FindAll();

    void delete(AlunoDisciplina alunoDisciplina);

    void update(AlunoDisciplina alunoDisciplina);
}
