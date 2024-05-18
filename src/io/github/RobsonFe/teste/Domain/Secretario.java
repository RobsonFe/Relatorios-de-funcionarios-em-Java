package io.github.RobsonFe.teste.Domain;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class Secretario extends Funcionarios {
    // Valores das constantes.
    private static final double SALARIO_BASE = 7000;
    private static final double BENEFICIO_POR_ANO = 1000;
    private static final double PORCENTAGEM_BENEFICIO = 0.2;

    public Secretario(String nome, LocalDate dataContratacao) {
        super(UUID.randomUUID(), nome, dataContratacao, SALARIO_BASE);

        // Validações no construtor.
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio.");
        }

        if (dataContratacao == null || dataContratacao.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Data de contratação inválida.");
        }
    }

    @Override
    public double calcularSalario(int mes, int ano) {
        // Validação no método de calcular salario.
        if (ano < getDataContratacao().getYear()) {
            throw new IllegalArgumentException("Ano não pode ser anterior ao ano de contratação.");
        }

        int anosDeServico = ano - getDataContratacao().getYear();
        return getSalarioBase() + (BENEFICIO_POR_ANO * anosDeServico);
    }

    @Override
    public double calcularBeneficio(int mes, int ano) {
        // Validação no método calculo do benefício.
        if (ano < getDataContratacao().getYear()) {
            throw new IllegalArgumentException("Ano não pode ser anterior ao ano de contratação.");
        }

        return calcularSalario(mes, ano) * PORCENTAGEM_BENEFICIO;
    }
}
