package com.example.javafxdemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.time.LocalDateTime;

    public class LogicaNegocio {
        private List<AreaEstacionamento> areas;
    
        public LogicaNegocio() {
            areas = new ArrayList<>();
            adicionarAreaEstacionamento("Curta Duração", 50, 10.0);
            adicionarAreaEstacionamento("Longa Duração", 100, 20.0);
            adicionarAreaEstacionamento("Funcionários", 30, 5.0);
        }
    
        public void adicionarAreaEstacionamento(String nome, int capacidadeMaxima, double taxa) {
            areas.add(new AreaEstacionamento(nome, capacidadeMaxima, taxa));
        }
    
        public boolean realizarLogin(String usuario, String senha) {
            return usuario.equals("Robert") && senha.equals("1234");
        }
    
        public void cadastrarVeiculo(String placa, LocalDateTime horaEntrada, String localEstacionamento) {
            boolean areaEncontrada = false;
            for (AreaEstacionamento area : areas) {
                if (area.getNome().equals(localEstacionamento)) {
                    areaEncontrada = true;
                    if (area.getVeiculosEstacionados().size() < area.getCapacidadeMaxima()) {
                        Veiculo veiculo = new Veiculo(placa, horaEntrada, localEstacionamento);
                        area.adicionarVeiculo(veiculo);
                        System.out.println("Veículo cadastrado");
                    } else {
                        System.out.println("Não há vagas disponíveis");
                    }
                    break;
                }
            }
            if (!areaEncontrada) {
                System.out.println("Área de estacionamento não encontrada");
            }
        }
        
        public List<AreaEstacionamento> getAreas() {
            return areas;
        }
    
        public String calcularTaxa(String nomeArea, int duracao) {
            for (AreaEstacionamento area : areas) {
                if (area.getNome().equals(nomeArea)) {
                    if (nomeArea.equals("Curta Duração")) {
                        return String.format("%.2f", area.calcularTaxaCurtaDuracao(duracao));
                    } else if (nomeArea.equals("Longa Duração")) {
                        return String.format("%.2f", area.calcularTaxaLongaDuracao(duracao));
                    } else if (nomeArea.equals("Funcionários")) {
                        return String.format("%.2f", area.calcularTaxaFuncionarios(duracao));
                    } else {
                        return "Área de estacionamento inválida";
                    }
                }
            }
            return "Área de estacionamento não encontrada";
        }
    
        public void emitirRecibo(String placa, String area, String duracao, String dataHora) {
            System.out.println("Recibo de Estacionamento");
            System.out.println("Placa do Veículo: " + placa);
            System.out.println("Área de Estacionamento: " + area);
            System.out.println("Duração: " + duracao + " horas");
            System.out.println("Data/Hora: " + dataHora);
            String taxa = calcularTaxa(area, duracao); 
            System.out.println("Taxa: R$" + taxa);
        }
    }
    