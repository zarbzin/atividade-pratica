package com.example.javafxdemo;

public class Conta {
    private Cliente cliente = new Cliente();
    private double saldo = 0d;

    public void sacar(double valor) {
        if (saldo >= valor) {
            this.saldo -= valor;
        }
    }

    public void depositar(double valor) {
        this.saldo += valor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getSaldo() {
        return saldo;
    }
}

