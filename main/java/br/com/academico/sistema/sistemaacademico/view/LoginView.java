package br.com.academico.sistema.sistemaacademico.view;


import br.com.academico.sistema.sistemaacademico.controllers.PessoaController;
import br.com.academico.sistema.sistemaacademico.models.Pessoa;
import br.com.academico.sistema.sistemaacademico.util.JavaFxml;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.EventListener;
import java.util.Optional;

public class LoginView {

    @FXML
    private Button btnLogin;

    @FXML
    private PasswordField pfPassword;

    @FXML
    private TextField tfUsername;

    @FXML
    private AnchorPane anchorPaneLogin;

   public static Optional<Pessoa> pessoa;
    //Ação do botão login
    @FXML
    void logar(ActionEvent event) throws Exception {

        PessoaController pessoaController = new PessoaController();
       pessoa = pessoaController.puxarPerfil(tfUsername.getText(),pfPassword.getText());
        JavaFxml javaFxml = new JavaFxml();
        Stage stage = new Stage();
        Stage stageScreen = (Stage) btnLogin.getScene().getWindow();



       if(pessoa.get().getTipo().equals("Aluno")){
           System.out.println(pessoa.get().getTipo());
            stageScreen.close();
           JavaFxml.start(stage,"TelaAluno");

       } else if (pessoa.get().getTipo().equals("Professor")) {
        stageScreen.close();
        JavaFxml.start(stage,"TelaProfessor");
       }else {
        stageScreen.close();
        JavaFxml.start(stage,"TelaSecretaria");
       }

        System.out.println(pessoa.get().getNome());



    }

    @FXML
    void botaoPressionado(KeyEvent event) {

        if(event.getCode() == KeyCode.ENTER){
            btnLogin.getText();
        }

    }
}

