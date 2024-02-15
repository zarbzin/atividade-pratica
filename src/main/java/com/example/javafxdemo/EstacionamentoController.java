package com.example.javafxdemo;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class EstacionamentoController {
    
    private LogicaNegocio logicaNegocio;

    public EstacionamentoController() {
        this.logicaNegocio = new LogicaNegocio();
    }
    @FXML
    private Button btnAdicionar;

    @FXML
    private TextField txtCapacidade;

    @FXML
    private TextField txtDuracao;

    @FXML
    private TextField txtLocal;

    @FXML
    private TextField txtTarifa;

    @FXML
    private void adicionarAreaEstacionamento() throws IOException {
        try {
            String nome = txtLocal.getText();
            int capacidadeMaxima = Integer.parseInt(txtCapacidade.getText());
            double taxa = Double.parseDouble(txtTarifa.getText());
  
            logicaNegocio.adicionarAreaEstacionamento(nome, capacidadeMaxima, taxa);

            FXMLLoader loader = new FXMLLoader(getClass().getResource("gerenVeiculos.fxml"));
            
            Parent root = loader.load();
            Scene scene = btnAdicionar.getScene();
            scene.setRoot(root);
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText(null);
            alert.setContentText("Preencha corretamente as informações");
            alert.showAndWait();
        }
    }
}   
    