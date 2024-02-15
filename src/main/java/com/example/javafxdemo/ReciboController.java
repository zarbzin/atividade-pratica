package com.example.javafxdemo;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class ReciboController {

    private LogicaNegocio logicaNegocio;

    public ReciboController() {
        this.logicaNegocio = new LogicaNegocio();
    }

    @FXML
    private void gerarRecibo() {
        String placa = "PLACA DO VEÍCULO"; 
        String duracao = "DURAÇÃO"; 
        String dataHora = "DATA/HORA";
        String area = "ÁREA"; 

        logicaNegocio.emitirRecibo(placa, area, duracao, dataHora);

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Recibo de Estacionamento");
        alert.setHeaderText(null);
        alert.setContentText("Recibo gerado com sucesso.");

        ButtonType imprimirButton = new ButtonType("Imprimir");
        ButtonType enviarEmailButton = new ButtonType("Enviar por E-mail");
        ButtonType cancelarButton = new ButtonType("Cancelar");
        alert.getButtonTypes().setAll(imprimirButton, enviarEmailButton, cancelarButton);
        };
    }


