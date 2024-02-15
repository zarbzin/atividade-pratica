package com.example.javafxdemo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDateTime;

public class VeiculoController {

    private LogicaNegocio logicaNegocio;

    public VeiculoController() {
        this.logicaNegocio = new LogicaNegocio();
    }

    @FXML
    private TextField txtPlaca;

    @FXML
    private TextField txtHoraEntrada;

    @FXML
    private TextField txtLocalEstacionamento;

    @FXML
    private TextField txtHoraDeSaida;

    @FXML
    private Button btnCadastrar;

    @FXML
    private void cadastrarVeiculo() {
    String placa = txtPlaca.getText();
    LocalDateTime horaEntrada = LocalDateTime.now(); 
    String localEstacionamento = txtLocalEstacionamento.getText();

    logicaNegocio.cadastrarVeiculo(placa, horaEntrada, localEstacionamento);
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("emiBoleto.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
