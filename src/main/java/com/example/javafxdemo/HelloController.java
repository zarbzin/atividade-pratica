package com.example.javafxdemo;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    private ObservableList<Conta> contas;

    @FXML
    private TableView<Conta> tbContas;
    @FXML
    private TableColumn<Conta, String> colCliente;
    @FXML
    private TableColumn<Conta, Double> colSaldo;
    @FXML
    private TextField txCliente;
    @FXML
    private TextField txSaldo;
    @FXML
    private TextField txValor;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colCliente.setCellValueFactory(data-> new SimpleStringProperty(data.getValue().cliente));
        colSaldo.setCellValueFactory(data-> new SimpleObjectProperty(data.getValue().saldo));
        contas = FXCollections.observableArrayList();
        tbContas.setItems(contas);
    }


    @FXML
    protected void novaConta() {
        var novaConta  = new Conta();
        novaConta.cliente = txCliente.getText();
        if(!txSaldo.getText().isEmpty()){
            novaConta.saldo = Double.valueOf(txSaldo.getText());
        }
        contas.add(novaConta);

    }
    @FXML
    protected void sacar() {
        contaOperacao().ifPresent(conta -> conta.saldo-= valorOperacao().orElse(0d));
        tbContas.refresh();
    }
    @FXML
    protected void depositar() {
        contaOperacao().ifPresent(conta -> conta.saldo+= valorOperacao().orElse(0d));
        tbContas.refresh();
    }

    private Optional<Double> valorOperacao(){
        Double valor  = null;
        if(!txValor.getText().isEmpty()){
            valor  = Double.valueOf(txValor.getText());
        }
        return Optional.ofNullable(valor);
    }
    private Optional<Conta> contaOperacao(){
        Conta conta  = null;
        if(tbContas.getSelectionModel().getSelectedItems().size() == 1){
            conta = contas.get(tbContas.getSelectionModel().getSelectedIndex());
        }
        return Optional.ofNullable(conta);
    }
}