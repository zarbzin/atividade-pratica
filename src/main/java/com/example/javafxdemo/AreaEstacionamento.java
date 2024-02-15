package com.example.javafxdemo;

import java.util.ArrayList;
import java.util.List;

public class AreaEstacionamento extends Entidade {
    private String nome;
    private int capacidadeMaxima;
    private double taxa;
    private List<Veiculo> veiculosEstacionados;

    public AreaEstacionamento(String nome, int capacidadeMaxima, double taxa) {
        this.nome = nome;
        this.capacidadeMaxima = capacidadeMaxima;
        this.taxa = taxa;
        this.veiculosEstacionados = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public double getTaxa() {
        return taxa;
    }

    public List<Veiculo> getVeiculosEstacionados() {
        return veiculosEstacionados;
    }

    public double calcularTaxa(int duracao) {
        return taxa * duracao;
    }

    public double calcularTaxaCurtaDuracao(int duracao) {
        return taxa * 2 * duracao;
    }

    public double calcularTaxaLongaDuracao(int duracao) {
        return taxa * 3 * duracao;
    }

    public double calcularTaxaFuncionarios(int duracao) {
        return taxa * 1.2 * duracao;
    }

    public void adicionarVeiculo(Veiculo veiculo) {
        if (veiculosEstacionados.size() < capacidadeMaxima) {
            veiculosEstacionados.add(veiculo);
        } else {
            System.out.println("Não há vagas disponível");
        }
    }

    public void removerVeiculo(Veiculo veiculo) {
        veiculosEstacionados.remove(veiculo);
    }
}

