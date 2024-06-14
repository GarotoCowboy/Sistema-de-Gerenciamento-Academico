package br.com.academico.sistema.sistemaacademico.models.repository;

import br.com.academico.sistema.sistemaacademico.models.Disciplina;
import br.com.academico.sistema.sistemaacademico.models.Presenca;

import java.util.List;
import java.util.Optional;

public interface PresencaRepository {

    void insert(Presenca presenca);

    Optional<Presenca> findById(String id);

    List<Presenca> FindAll();

    void delete(Presenca presenca,String idPresenca);

    void update(Presenca presenca, String idPresenca, Boolean ausente, String data,
                String justificativa, Disciplina fkIdDisciplina);
}
