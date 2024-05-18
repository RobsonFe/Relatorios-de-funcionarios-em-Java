package io.github.RobsonFe.teste.Domain;

import java.time.LocalDate;
import java.util.UUID;

public class Vendedor extends Funcionarios {

    private static final double SALARIO_BASE = 12000;
    private static final double BENEFICIO_POR_ANO = 1800;
    private static final double PORCENTAGEM_VENDAS = 0.3;
    private double[] vendas;

    public Vendedor(String nome, LocalDate dataContratacao, double[] vendas) {
        super(UUID.randomUUID(), nome, dataContratacao, SALARIO_BASE);

        // Validações no construtor.
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio.");
        }

        if (dataContratacao == null || dataContratacao.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Data de contratação inválida.");
        }

        if (vendas == null || vendas.length == 0) {
            throw new IllegalArgumentException("O numero de vendas não pode ser nulo ou vazio.");
        }

        this.vendas = vendas;
    }

    @Override
    public double calcularSalario(int mes, int ano) {
        int anosDeServico = ano - getDataContratacao().getYear();
        return getSalarioBase() + (BENEFICIO_POR_ANO * anosDeServico);
    }

    @Override
    public double calcularBeneficio(int mes, int ano) {
        int i = calcularIndiceVendas(mes, ano);

        if (i < 0 || i >= vendas.length) {
            throw new IllegalArgumentException("Índice de vendas inválido para o mês e ano fornecidos.");
        }

        return vendas[i] * PORCENTAGEM_VENDAS;
    }

    public double getVendas(int mes, int ano) {
        int i = calcularIndiceVendas(mes, ano);

        if (i < 0 || i >= vendas.length) {
            throw new IllegalArgumentException("Índice de vendas inválido para o mês e ano fornecidos.");
        }

        return vendas[i];
    }

    private int calcularIndiceVendas(int mes, int ano) {
        return (ano - 2021) * 12 + (mes - 12);
    }
}
