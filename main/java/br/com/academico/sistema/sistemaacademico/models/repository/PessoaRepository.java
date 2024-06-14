package br.com.academico.sistema.sistemaacademico.models.repository;

import br.com.academico.sistema.sistemaacademico.models.Pessoa;

import java.util.List;
import java.util.Optional;

public interface PessoaRepository {

    void insert(Pessoa pessoa);

    Optional<Pessoa> findByMatricula(String matricula);

    List<Pessoa> findAll();

    void delete(Pessoa pessoa,String matricula);

    Optional<Pessoa> findByCpf(String cpf);

    Optional<Pessoa> findByEmail(String email);

    void update(Pessoa pessoa, String matricula, Long cpf, String sexo, String idade,
                       String senha, String linkFoto, String nome, String dataCriacao,
                       String dataTermino, String email);
}
