package br.com.academico.sistema.sistemaacademico.models.repository;

import br.com.academico.sistema.sistemaacademico.models.Aluno;
import br.com.academico.sistema.sistemaacademico.models.Pessoa;

import java.util.List;
import java.util.Optional;

public interface AlunoRepository{

    void insert(Aluno aluno);

     Optional<Aluno> findByMatricula(String matricula);

    List<Aluno> FindAll();

    void delete(Aluno aluno, String matricula);

    List<Aluno> findByCpf(String cpf);

    List<Aluno> findByEmail(String email);

    void update(Aluno aluno,String matricula,Long cpf,String sexo, String idade,
                String senha, String linkFoto, String nome, String dataCriacao,
                String dataTermino, String email);

}
