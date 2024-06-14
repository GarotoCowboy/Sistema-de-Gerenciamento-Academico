package br.com.academico.sistema.sistemaacademico.models.repository;

import br.com.academico.sistema.sistemaacademico.models.Aluno;
import br.com.academico.sistema.sistemaacademico.models.Secretaria;

import java.util.List;
import java.util.Optional;

public interface SecretariaRepository {

    void insert(Secretaria secretaria);

    Optional<Secretaria> findByMatricula(String matricula);

    List<Secretaria> findAll();

    void delete(Secretaria secretaria, String matricula);

    List<Secretaria> findByCpf(String cpf);

    List<Secretaria> findByEmail(String email);

    void update(Secretaria secretaria,String matricula, Long cpf, String sexo, String idade,
                String senha, String linkFoto, String nome, String dataCriacao,
                String dataTermino, String email);
}
