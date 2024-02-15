package com.example.javafxdemo;

import java.time.LocalDateTime;

public class Veiculo extends Entidade {
    private String placa;
    private LocalDateTime horaEntrada;
    private String localEstacionamento;

    public Veiculo(String placa, LocalDateTime horaEntrada, String localEstacionamento) {
        this.placa = placa;
        this.horaEntrada = horaEntrada;
        this.localEstacionamento = localEstacionamento;
    }
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public LocalDateTime getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(LocalDateTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public String getLocalEstacionamento() {
        return localEstacionamento;
    }

    public void setLocalEstacionamento(String localEstacionamento) {
        this.localEstacionamento = localEstacionamento;
    }
}
