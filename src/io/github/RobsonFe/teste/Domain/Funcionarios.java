package io.github.RobsonFe.teste.Domain;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public abstract class Funcionarios {
    private UUID id;
    private String nome;
    private LocalDate dataContratacao;
    private double salarioBase;

    // Validação para cada funcionário ter um identificador unico.
    public Funcionarios() {
        this.id = UUID.randomUUID();
    }

    public Funcionarios(UUID id, String nome, LocalDate dataContratacao, double salarioBase) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.dataContratacao = dataContratacao;
        this.salarioBase = salarioBase;
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(LocalDate dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Funcionarios that = (Funcionarios) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public abstract double calcularSalario(int mes, int ano);

    public abstract double calcularBeneficio(int mes, int ano);
}
