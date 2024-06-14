package br.com.academico.sistema.sistemaacademico.models.repository;

import br.com.academico.sistema.sistemaacademico.models.Aluno;
import br.com.academico.sistema.sistemaacademico.models.Curso;

import java.util.List;
import java.util.Optional;

public interface CursoRepository {

    void insert(Curso curso);

    Optional<Curso> findById(String idCurso);

    List<Curso> findAll();

    void delete(Curso curso,String idCurso);

    void update(Curso curso, String idCurso, String cargaHoraria, String descricao,
                String horario ,String nome, String salaDAula);


}
