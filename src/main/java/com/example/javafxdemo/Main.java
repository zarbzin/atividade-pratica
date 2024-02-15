package com.example.javafxdemo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loginLoader = new FXMLLoader(getClass().getResource("telaLogin.fxml"));
        AnchorPane loginPane = loginLoader.load();
        Scene loginScene = new Scene(loginPane);
        
        primaryStage.setTitle("Sistema de Gerenciamento de Estacionamento");
        primaryStage.setScene(loginScene);
        primaryStage.show();
    }
}