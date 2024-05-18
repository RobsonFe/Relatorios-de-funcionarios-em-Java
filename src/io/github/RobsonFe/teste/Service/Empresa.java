package io.github.RobsonFe.teste.Service;

import io.github.RobsonFe.teste.Domain.Funcionarios;
import io.github.RobsonFe.teste.Domain.Secretario;
import io.github.RobsonFe.teste.Domain.Vendedor;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private List<Funcionarios> funcionarios;

    public Empresa() {
        funcionarios = new ArrayList<>();
    }

    public void listaFuncionarios() {
        for (Funcionarios f : funcionarios) {
            System.out.println(
                    "ID: " + f.getId()
                            + "\nNome: " + f.getNome()
                            + "\nSalario: " + f.getSalarioBase()
                            + "\n"
            );
        }
    }

    public void listaFuncionariosBeneficios() {
        for (Funcionarios f : funcionarios) {
            if (f instanceof Secretario || f instanceof Vendedor) {
                System.out.println("Recebem Beneficios: " + f.getNome());
            }
        }
    }

    public void adicionarFuncionario(Funcionarios funcionario) {
        funcionarios.add(funcionario);
    }

    public double calcularTotalPago(int mes, int ano) {
        double total = 0;
        for (Funcionarios f : funcionarios) {
            total += f.calcularSalario(mes, ano) + f.calcularBeneficio(mes, ano);
        }
        return total;
    }

    public double calcularTotalSalarios(int mes, int ano) {
        double total = 0;
        for (Funcionarios f : funcionarios) {
            total += f.calcularSalario(mes, ano);
        }
        return total;
    }

    public double calcularTotalBeneficios(int mes, int ano) {
        double total = 0;
        for (Funcionarios f : funcionarios) {
            if (f instanceof Secretario || f instanceof Vendedor) {
                total += f.calcularBeneficio(mes, ano);
            }
        }
        return total;
    }

    public Funcionarios getFuncionarioComMaiorPagamento(int mes, int ano) {
        Funcionarios maior = null;
        double max = 0;
        for (Funcionarios f : funcionarios) {
            double total = f.calcularSalario(mes, ano) + f.calcularBeneficio(mes, ano);
            if (total > max) {
                max = total;
                maior = f;
            }
        }
        return maior;
    }

    public Funcionarios getFuncionarioComMaiorBeneficio(int mes, int ano) {
        Funcionarios maior = null;
        double max = 0;
        for (Funcionarios f : funcionarios) {
            double beneficio = f.calcularBeneficio(mes, ano);
            if (beneficio > max) {
                max = beneficio;
                maior = f;
            }
        }
        return maior;
    }

    public Vendedor getVendedorQueMaisVendeu(int mes, int ano) {
        Vendedor maior = null;
        double max = 0;
        for (Funcionarios f : funcionarios) {
            if (f instanceof Vendedor) {
                Vendedor v = (Vendedor) f;
                double vendas = v.getVendas(mes, ano);
                if (vendas > max) {
                    max = vendas;
                    maior = v;
                }
            }
        }
        return maior;
    }

}