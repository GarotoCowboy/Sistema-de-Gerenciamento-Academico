package br.com.academico.sistema.sistemaacademico.controllers;

import br.com.academico.sistema.sistemaacademico.models.Pessoa;
import br.com.academico.sistema.sistemaacademico.models.dao.PessoaDao;
import br.com.academico.sistema.sistemaacademico.util.Conversor;
import br.com.academico.sistema.sistemaacademico.view.LoginView;

import java.util.Optional;

public class LoginController {



    public static Pessoa fazLogin(String usuario, String senha){
        PessoaDao pessoaDao = new PessoaDao();
        Optional<Pessoa> pessoa = pessoaDao.findByMatricula(usuario);

        if(pessoa.get().getMatricula() == Conversor.convertToLong(usuario) && pessoa.get().getSenha().equals(senha)){
           Pessoa pessoaLogin = new Pessoa(pessoa.get().getMatricula(),pessoa.get().getCpf(),pessoa.get().getNome(),pessoa.get().getIdade(),
                                        pessoa.get().getSexo(),pessoa.get().getLinkFoto(),pessoa.get().getSenha(),pessoa.get().getEmail(),
                                        pessoa.get().getDataCriacao(),pessoa.get().getDataTermino());
            return pessoaLogin;
        }else {
            System.out.println("Não foi possivel Logar");
            return null;
    }
    }
}
