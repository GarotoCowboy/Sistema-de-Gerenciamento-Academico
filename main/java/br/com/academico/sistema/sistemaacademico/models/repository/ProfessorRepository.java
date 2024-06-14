package br.com.academico.sistema.sistemaacademico.models.repository;

import br.com.academico.sistema.sistemaacademico.models.Aluno;
import br.com.academico.sistema.sistemaacademico.models.Professor;

import java.util.List;
import java.util.Optional;

public interface ProfessorRepository {

    void insert(Professor professor);

    Optional<Professor> findByMatricula(String matricula);

    List<Professor> FindAll();

    void delete(Professor professor,String matricula);

    List<Professor> findByCpf(String cpf);

    List<Professor> findByEmail(String email);

    void update(Professor professor, String matricula, Long cpf, String sexo, String idade,
                String senha, String linkFoto, String nome, String dataCriacao,
                String dataTermino, String email);
}
