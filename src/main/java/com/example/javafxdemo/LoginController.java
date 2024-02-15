package com.example.javafxdemo;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;

public class LoginController extends Entidade {

    @FXML
    private Button btnLogin;

    @FXML
    private TextField TXTEmail;

    @FXML
    private TextField TXTSenha;

    @FXML
    void realizarLogin(ActionEvent event) {
        String usuario =  TXTEmail.getText();
        String senha =    TXTSenha.getText();
    
        if(usuario.equals("Robert") && senha.equals("1234")) {
            System.out.println("Login bem-sucedido");
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("gerenEstacionamento.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Senha incorreta");
        }
    }
}
