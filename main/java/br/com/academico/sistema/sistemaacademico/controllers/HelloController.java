package br.com.academico.sistema.sistemaacademico.controllers;

import br.com.academico.sistema.sistemaacademico.HelloApplication;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController extends Application {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() throws Exception {
        welcomeText.setText("Welcome to JavaFX Application!");
        System.out.println(HelloController.class.getResource("/br/com/academico/sistema/sistemaacademico/Login.fxml"));


//        Stage primaryStage = new Stage();
//
//    start(primaryStage);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloController.class.getResource("Login.fxml"));

        Scene scene = new Scene(fxmlLoader.load());
        //scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

        primaryStage.setTitle("JavaFX and Gradle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}