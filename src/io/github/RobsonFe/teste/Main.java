package io.github.RobsonFe.teste;

import io.github.RobsonFe.teste.Domain.Gerente;
import io.github.RobsonFe.teste.Domain.Secretario;
import io.github.RobsonFe.teste.Domain.Vendedor;
import io.github.RobsonFe.teste.Service.Empresa;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Empresa empresa = criarEmpresa();

        relatorio(empresa, 12, 2021);

        relatorio(empresa, 1, 2022);

        relatorio(empresa, 2, 2022);

        relatorio(empresa, 3, 2022);

        relatorio(empresa, 4, 2022);
    }

    public static void relatorio(Empresa empresa, int mes, int ano) {
        System.out.println("-----------------------------------------------------");
        System.out.println("Relatório referente ao mês " + mes + " do ano " + ano);
        System.out.println("\n");
        empresa.listaFuncionarios();
        System.out.println("Total pago no mês: " + empresa.calcularTotalPago(mes, ano));
        System.out.println("Total pago em salários no mês: " + empresa.calcularTotalSalarios(mes, ano));
        System.out.println("\n");
        System.out.println("Funcionários que Recebem Beneficios");
        empresa.listaFuncionariosBeneficios();
        System.out.println("Total pago em benefícios no mês: " + empresa.calcularTotalBeneficios(mes, ano));
        System.out.println("\n");
        System.out.println("Funcionário com maior pagamento no mês: " + empresa.getFuncionarioComMaiorPagamento(mes, ano).getNome());
        System.out.println("Funcionário com maior benefício no mês: " + empresa.getFuncionarioComMaiorBeneficio(mes, ano).getNome());
        System.out.println("Vendedor que mais vendeu no mês: " + empresa.getVendedorQueMaisVendeu(mes, ano).getNome());
    }

    private static Empresa criarEmpresa() {
        Empresa empresa = new Empresa();

        // Criando funcionários
        Secretario secretario1 = criarSecretario("Jorge Carvalho", LocalDate.of(2018, 1, 1));
        Secretario secretario2 = criarSecretario("Maria Souza", LocalDate.of(2015, 12, 1));

        double[] vendasAna = {5200, 4000, 4200, 5850, 7000};
        Vendedor vendedor1 = criarVendedor("Ana Silva", LocalDate.of(2021, 12, 1), vendasAna);

        double[] vendasJoao = {3400, 7700, 5000, 5900, 6500};
        Vendedor vendedor2 = criarVendedor("João Mendes", LocalDate.of(2021, 12, 1), vendasJoao);

        Gerente gerente1 = criarGerente("Juliana Alves", LocalDate.of(2017, 7, 1));
        Gerente gerente2 = criarGerente("Bento Albino", LocalDate.of(2014, 3, 1));

        // Adicionando funcionários à empresa
        empresa.adicionarFuncionario(secretario1);
        empresa.adicionarFuncionario(secretario2);
        empresa.adicionarFuncionario(vendedor1);
        empresa.adicionarFuncionario(vendedor2);
        empresa.adicionarFuncionario(gerente1);
        empresa.adicionarFuncionario(gerente2);

        return empresa;
    }

    private static Secretario criarSecretario(String nome, LocalDate dataContratacao) {
        return new Secretario(nome, dataContratacao);
    }

    private static Vendedor criarVendedor(String nome, LocalDate dataContratacao, double[] vendas) {
        return new Vendedor(nome, dataContratacao, vendas);
    }

    private static Gerente criarGerente(String nome, LocalDate dataContratacao) {
        return new Gerente(nome, dataContratacao);
    }
}
