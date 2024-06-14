package br.com.academico.sistema.sistemaacademico.models.repository;

import br.com.academico.sistema.sistemaacademico.models.Curso;
import br.com.academico.sistema.sistemaacademico.models.Secretaria;
import br.com.academico.sistema.sistemaacademico.models.Turma;

import java.util.List;
import java.util.Optional;

public interface TurmaRepository {

    void insert(Turma turma);

    Optional<Turma> findById(String idTurma);

    List<Turma> FindAll();

    void delete(Turma turma, String idTurma);

    void update(Turma turma, String idTurma, String nome, String periodo,
                String qntdAluno, Curso fkIdCurso);
}
