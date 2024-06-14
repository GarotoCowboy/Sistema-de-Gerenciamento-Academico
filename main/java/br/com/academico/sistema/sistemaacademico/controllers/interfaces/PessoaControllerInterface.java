package br.com.academico.sistema.sistemaacademico.controllers.interfaces;

import br.com.academico.sistema.sistemaacademico.models.Pessoa;

import java.time.LocalDate;
import java.util.Optional;

public interface PessoaControllerInterface {

    public Boolean validarLogin(String login, String senha);

    public void trocarSenha(Pessoa pessoa);

    public Pessoa visualizarPerfil(Pessoa pessoa);

    public LocalDate gerarDataCriacao(LocalDate localDate);

    public LocalDate gerarDataFim(LocalDate localDate);

    public String gerarMatriculaAluno(String matricula);

    public String gerarMatriculaFuncionario(String matricula);
}
