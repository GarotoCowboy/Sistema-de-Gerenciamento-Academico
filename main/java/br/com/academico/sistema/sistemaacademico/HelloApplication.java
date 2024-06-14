package br.com.academico.sistema.sistemaacademico;

import br.com.academico.sistema.sistemaacademico.models.Pessoa;
import br.com.academico.sistema.sistemaacademico.view.LoginView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
        Optional<Pessoa> pessoa2 = LoginView.pessoa;
        //System.out.println(pessoa2.get().getNome());
       // System.out.println(HelloApplication.class.getResource("Login.fxml"));

    }
}