package br.com.academico.sistema.sistemaacademico.controllers;

import br.com.academico.sistema.sistemaacademico.controllers.interfaces.PessoaControllerInterface;
import br.com.academico.sistema.sistemaacademico.models.Pessoa;
import br.com.academico.sistema.sistemaacademico.models.dao.PessoaDao;
import br.com.academico.sistema.sistemaacademico.util.Conversor;
import javafx.scene.control.Alert;

import java.time.LocalDate;
import java.util.Optional;

public class PessoaController implements PessoaControllerInterface {

    //Metodo de validação de login
    @Override
    public Boolean validarLogin(String login, String senha) {
        PessoaDao pessoaDao = new PessoaDao();
        Optional<Pessoa> pessoaFind = pessoaDao.findByMatricula(login);

        if(pessoaFind.get().getMatricula().equals(Conversor.convertToLong(login)) && pessoaFind.get().getSenha().equals(senha)){
            return true;
        }
        return false;
    }
    //Otimizar esse metodo depois, para tentar puxar o perfil com apenas um metodo ao invés de 2
    public Optional<Pessoa> puxarPerfil(String usuario, String senha){
        try {
            if (validarLogin(usuario, senha)) {
                PessoaDao dao = new PessoaDao();
                Optional<Pessoa> pessoa = dao.findByMatricula(usuario);

                return pessoa;
            }
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR,"Usuario ou senha invalidos");
            alert.showAndWait();

        }
        return null;
    }

    //Metodo que faz a troca de senha
    @Override
    public void trocarSenha(Pessoa pessoa) {

    }

    //Metodo para visualizar Perfil
    @Override
    public Pessoa visualizarPerfil(Pessoa pessoa) {
        return null;
    }
    //Metodo que gera a data em que a conta foi criada
    @Override
    public LocalDate gerarDataCriacao(LocalDate localDate) {
        return null;
    }

    //REMOVER ESSE DPS
    @Override
    public LocalDate gerarDataFim(LocalDate localDate) {
        return null;
    }

    //Metodo que gera uma matricula para o aluno
    @Override
    public String gerarMatriculaAluno(String matricula) {
        return "";
    }
    //Metodo que gera uma matricula para um funcionario
    @Override
    public String gerarMatriculaFuncionario(String matricula) {
        return "";
    }


}
