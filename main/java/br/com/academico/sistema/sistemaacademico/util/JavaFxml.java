package br.com.academico.sistema.sistemaacademico.util;

import br.com.academico.sistema.sistemaacademico.HelloApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class JavaFxml {

    //Metodo que pega uma tela .fxml
    public static void start(Stage stage, String endereco) throws IOException {
        String absoluto = "/br/com/academico/sistema/sistemaacademico/";
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(absoluto+endereco+".fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

}
