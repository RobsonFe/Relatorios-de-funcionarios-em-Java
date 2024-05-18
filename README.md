# Teste Técnico Programação Orientada a Objetos 
- Teste Tecnico para a empresa SINERJI - Gestão e Sistemas Ltda.
- Java e Orientação a Objetos.
- Autor: Robson Ferreira da Silva

## Descrição

**Objetivo:**
O objetivo deste projeto é desenvolver uma aplicação em Java capaz de gerar relatórios financeiros detalhados baseados nas vendas de uma empresa, além de fornecer informações abrangentes sobre a gestão de recursos humanos, incluindo salários, datas de admissão e benefícios dos funcionários.

**Escopo:**
1. **Relatórios Financeiros:**
    - **Geração de Relatórios de Vendas:** A aplicação consolidará dados de vendas para produzir relatórios financeiros que permitem análise detalhada do desempenho da empresa.
    - **Análise de Desempenho:** Ferramentas para a análise de tendências de vendas, identificação de produtos mais vendidos e períodos de maior movimentação.

2. **Gestão de Recursos Humanos:**
    - **Informações de Funcionários:** Armazenamento e gerenciamento de dados dos funcionários, incluindo datas de admissão, salários e benefícios.
    - **Cálculo de Salários e Benefícios:** Ferramentas para cálculo automático de salários, considerando impostos, descontos e benefícios.
    - **Relatórios de RH:** Geração de relatórios personalizados sobre os funcionários, permitindo a visualização de histórico de salários, evolução de carreira e distribuição de benefícios.

# Orientações sobre o teste

## Baixe as orientações

- [Link para baixar as instruções no PDF](https://drive.google.com/file/d/1wKZbusMJMei-iBX-AWJ4KHXjY9vPnI66/view?usp=drive_link)

# Tecnologias do Projeto

- Java SE (Standard Edition)
- JDK 21.0.3 
- Intellij IDEA Community

# Documentação

- [Java SE](https://docs.oracle.com/en/java/)
- [Intellij IDEA](https://www.jetbrains.com/idea/)
- [JDK 21](https://docs.oracle.com/en/java/javase/21/)

## Padrão de Projeto
- Programação Orientada a Objetos
- Arquitetura baseada no Domain-Driven Design(DDD)

# Funcionalidades

Ex:

O sistema oferece os seguintes métodos para calcular:

- O valor total pago (salário e benefício) a todos os funcionários no mês.
- O valor total pago somente em salários no mês.
- O valor total pago em benefícios no mês.
- O funcionário que recebeu o valor mais alto no mês.
- O funcionário que recebeu o valor mais alto em benefícios no mês.
- O vendedor que mais vendeu no mês.

## Como Executar

1. Clone o repositório:
    ```sh
    git clone https://github.com/seu-usuario/Relatorios-de-funcionarios-em-Java.git
    ```

2. Navegue até o diretório do projeto:
    ```sh
    cd Relatorios-de-funcionarios-em-Java
    ```

3. Compile o projeto:
    ```sh
    javac -d bin src/*.java
    ```

4. Execute o projeto:
    ```sh
    java -cp bin Main
    ```

## Conceitos

A orientação a objetos (OO) é um paradigma de programação que organiza o software em torno de "objetos", que podem ser vistos como modelos de entidades do mundo real ou conceitos abstratos. Aqui estão os princípios fundamentais da orientação a objetos:

1. Abstração
A abstração envolve simplificar a complexidade ao modelar classes com atributos e métodos apropriados, enquanto oculta detalhes de implementação. Isso permite focar nos aspectos importantes do objeto, tornando o desenvolvimento mais gerenciável.

2. Encapsulamento
O encapsulamento é o princípio de esconder os detalhes internos de um objeto e expor apenas o que é necessário através de uma interface pública. Isso protege o estado interno do objeto contra mudanças indesejadas e fornece um controle centralizado sobre como os dados são acessados e modificados.

3. Herança
A herança permite que uma classe (subclasse) herde atributos e métodos de outra classe (superclasse). Isso promove a reutilização de código e a criação de uma hierarquia de classes que pode ser especializada conforme necessário.

4. Polimorfismo
O polimorfismo permite que objetos de diferentes classes sejam tratados como objetos de uma classe comum. Mais especificamente, um método pode ser implementado de diferentes maneiras em diferentes classes, mas pode ser chamado da mesma forma para objetos dessas classes, facilitando a extensibilidade e a manutenção do código.

### Benefícios

- Reutilização de Código: Herança e polimorfismo permitem criar estruturas reutilizáveis.
- Facilidade de Manutenção: Encapsulamento facilita a manutenção e atualização de código, pois alterações internas não afetam outras partes do sistema.
- Organização e Clareza: Abstração ajuda a estruturar o software de forma que reflita melhor o problema que está sendo resolvido, tornando o código mais claro e organizado.

## Exemplo de Uso

Ao executar o programa, você verá a saída com os cálculos realizados para o mês e ano especificados no código.

```plaintext
Total pago no mês: 107750.0
Total pago em salários no mês: 99000.0
Total pago em benefícios no mês: 8750.0
Funcionário com maior pagamento no mês: Bento Albino
Funcionário com maior benefício no mês: Jorge Carvalho
Vendedor que mais vendeu no mês: Ana Silva
```

## Estrutura do Código

### Classe `Funcionarios`

- Abstração

A Classe Funcionarios foi usada como classe principal abstrata que serviu como um contrato para todas as outras classes, já que todas hedarão delas os seus métodos abstratos, como `calcularSalario()` e `calcularBeneficio()`, sendo esses um dos principios da orientação a objetos, que é o reaproveitamento de código e herança dos métodos da super classe.

```java
public abstract class Funcionarios {

    private UUID id;
    private String nome;
    private LocalDate dataContratacao;
    private double salarioBase;
}
```

- Herança

Todos os funcionários da empresa receberão um identificador único, nome, data de contratação e salário base que será passado para as outroas classes. Considerando que será uma informação que será replicada para o restante do código, a herança toma força em implementações como essas, onde a informação não precisa ser reescrita, mas herdada. 

- Encapsulamento

Outro principio que pode ser observado no código é o encapsulamento, onde está sendo usando na classe "Private" e "Public" que são modificadores de acesso aquela classe. 

Uma classe pública, compartilha a sua implementação em todo o código, já os modificadores privados são acessados através dos métodos publicos. 

- Polimorfismo

É quando um método já implementado é reescrito, isso pode ser visto durante o código quando utilizamos os métodos de Calcular Beneficio e Salário sendo implementado de formas diferentes, gerando uma sobescrita do método.  


### Subclasses de `Funcionario`

#### `Secretario`

```java
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
```
### Pontos Importantes
- Constantes foram criadas, já que os valores do salário, beneficio e porcentagem do beneficio, não alteram. 
- Um identificador único (ID) foi colocado para simular uma busca no banco de dados, já que cada funcionário é unico e precisa ter a sua própria identificação por segurança de não haver alterações de dados no funcionário que possuir o mesmo nome. 
- Por segurança é importante coloca validações no código, já que cada implementação deve ser tratada para evitar erros no sistema. 
- Outra validação importante é a data de contratação que não pode ser menor do que o ano de serviço.

#### `Vendedor`

```java
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
```

A classe `Vendedor` estende a classe `Funcionarios` e representa um vendedor em um contexto empresarial. Abaixo está um resumo das implementações e funcionalidades da classe:

#### Atributos

- **SALARIO_BASE**: Um valor constante de `12000` que representa o salário base do vendedor.
- **BENEFICIO_POR_ANO**: Um valor constante de `1800` que representa o benefício anual do vendedor.
- **PORCENTAGEM_VENDAS**: Um valor constante de `0.3` que representa a porcentagem das vendas que o vendedor recebe como benefício.
- **vendas**: Um array de `double` que armazena os valores das vendas mensais do vendedor.

#### Construtor

- **Vendedor(String nome, LocalDate dataContratacao, double[] vendas)**:
  - Gera um ID único usando `UUID.randomUUID()`.
  - Inicializa os atributos `nome`, `dataContratacao` e `vendas` com base nos parâmetros fornecidos.
  - Valida os parâmetros fornecidos:
    - `nome` não pode ser nulo ou vazio.
    - `dataContratacao` não pode ser nula ou estar no futuro.
    - `vendas` não pode ser nulo ou vazio.

#### Métodos

- **calcularSalario(int mes, int ano)**:
  - Calcula o salário do vendedor com base no salário base e no benefício por ano de serviço.
  - O benefício é multiplicado pelo número de anos de serviço (diferença entre o ano atual e o ano de contratação).

- **calcularBeneficio(int mes, int ano)**:
  - Calcula o benefício do vendedor com base no valor das vendas para o mês e ano fornecidos.
  - Usa a porcentagem das vendas (`PORCENTAGEM_VENDAS`) para calcular o benefício.
  - Valida o índice das vendas para garantir que está dentro dos limites do array de vendas.

- **getVendas(int mes, int ano)**:
  - Retorna o valor das vendas para o mês e ano fornecidos.
  - Valida o índice das vendas para garantir que está dentro dos limites do array de vendas.

- **calcularIndiceVendas(int mes, int ano)**:
  - Calcula o índice no array de vendas baseado no mês e ano fornecidos.
  - Considera que o array de vendas começa em dezembro de 2021.

### Resumo dos Principais Pontos

- A classe `Vendedor` herda de `Funcionarios`.
- Possui um construtor que inicializa e valida os atributos.
- Inclui métodos para calcular o salário e o benefício do vendedor com base em suas vendas e anos de serviço.
- O método `calcularIndiceVendas` converte um mês e ano em um índice apropriado para o array de vendas, assumindo que o array começa em dezembro de 2021.

#### `Gerente`

```java
public class Gerente extends Funcionarios {
    
     private static final double SALARIO_BASE = 20000;
    private static final double BENEFICIO_POR_ANO = 3000;

    public Gerente(String nome, LocalDate dataContratacao) {
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
        // Validação no método calcular salario
        if (ano < getDataContratacao().getYear()) {
            throw new IllegalArgumentException("Ano não pode ser anterior ao ano de contratação.");
        }

        int anosDeServico = ano - getDataContratacao().getYear();
        return getSalarioBase() + (BENEFICIO_POR_ANO * anosDeServico);
    }

    @Override
    public double calcularBeneficio(int mes, int ano) {
        return 0;
    }
}
```

A classe `Gerente` estende a classe `Funcionarios` e representa um gerente em um contexto empresarial. Abaixo está um resumo das implementações e funcionalidades da classe:

#### Atributos

- **SALARIO_BASE**: Um valor constante de `20000` que representa o salário base do gerente.
- **BENEFICIO_POR_ANO**: Um valor constante de `3000` que representa o benefício anual do gerente.

#### Construtor

- **Gerente(String nome, LocalDate dataContratacao)**:
  - Gera um ID único usando `UUID.randomUUID()`.
  - Inicializa os atributos `nome` e `dataContratacao` com base nos parâmetros fornecidos e define o salário base como `SALARIO_BASE`.
  - Valida os parâmetros fornecidos:
    - `nome` não pode ser nulo ou vazio.
    - `dataContratacao` não pode ser nula ou estar no futuro.

#### Métodos

- **calcularSalario(int mes, int ano)**:
  - Calcula o salário do gerente com base no salário base e no benefício por ano de serviço.
  - Valida que o ano fornecido não é anterior ao ano de contratação.
  - O benefício é multiplicado pelo número de anos de serviço (diferença entre o ano atual e o ano de contratação).

- **calcularBeneficio(int mes, int ano)**:
  - Retorna `0`, indicando que a classe `Gerente` não possui um cálculo específico de benefícios adicionais baseado em vendas ou outros critérios.

### Resumo dos Principais Pontos

- A classe `Gerente` herda de `Funcionarios`.
- Possui um construtor que inicializa e valida os atributos `nome` e `dataContratacao`.
- Inclui métodos para calcular o salário do gerente com base nos anos de serviço, garantindo que o ano fornecido não é anterior ao ano de contratação.
- O método `calcularBeneficio` sempre retorna `0`, indicando que gerentes não têm benefícios adicionais calculados desta forma.

# Implementações das Classes e Relatório

### Classe `Empresa`

```java
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
```
A classe `Empresa` é responsável por gerenciar uma lista de funcionários e realizar diversas operações relacionadas a esses funcionários. Abaixo está um resumo das implementações e funcionalidades da classe:

#### Atributos

- **funcionarios**: Uma lista de objetos da classe `Funcionarios` que armazena todos os funcionários da empresa.

#### Construtor

- **Empresa()**:
  - Inicializa a lista `funcionarios` como uma nova instância de `ArrayList`.

#### Métodos

- **listaFuncionarios()**:
  - Itera sobre a lista de funcionários e imprime informações básicas de cada funcionário (ID, nome e salário base).

- **listaFuncionariosBeneficios()**:
  - Itera sobre a lista de funcionários e imprime o nome dos funcionários que são instâncias de `Secretario` ou `Vendedor`, indicando que recebem benefícios.

- **adicionarFuncionario(Funcionarios funcionario)**:
  - Adiciona um novo funcionário à lista `funcionarios`.

- **calcularTotalPago(int mes, int ano)**:
  - Calcula o total pago a todos os funcionários, somando salários e benefícios para um dado mês e ano.

- **calcularTotalSalarios(int mes, int ano)**:
  - Calcula o total de salários pagos a todos os funcionários para um dado mês e ano, excluindo benefícios.

- **calcularTotalBeneficios(int mes, int ano)**:
  - Calcula o total de benefícios pagos a funcionários que são instâncias de `Secretario` ou `Vendedor` para um dado mês e ano.

- **getFuncionarioComMaiorPagamento(int mes, int ano)**:
  - Encontra e retorna o funcionário que recebeu o maior pagamento total (salário + benefícios) para um dado mês e ano.

- **getFuncionarioComMaiorBeneficio(int mes, int ano)**:
  - Encontra e retorna o funcionário que recebeu o maior benefício para um dado mês e ano.

- **getVendedorQueMaisVendeu(int mes, int ano)**:
  - Encontra e retorna o vendedor que realizou o maior valor de vendas para um dado mês e ano.

### Resumo dos Principais Pontos

- A classe `Empresa` gerencia uma coleção de funcionários (`funcionarios`).
- Oferece métodos para listar informações dos funcionários, adicionar novos funcionários, e calcular valores financeiros (total de salários, total de benefícios, total pago).
- Implementa métodos para encontrar o funcionário com o maior pagamento total, maior benefício e o vendedor com o maior valor de vendas.
- Utiliza instâncias das subclasses `Secretario` e `Vendedor` para operações específicas, como cálculo de benefícios e vendas.

### Classe `Main`

```java
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
```
A classe `Main` serve como ponto de entrada para a execução do programa e realiza as seguintes tarefas principais:

1. **Criação de uma Empresa**: Instancia a classe `Empresa` e adiciona diversos funcionários (secretários, vendedores e gerentes).
2. **Geração de Relatórios**: Gera relatórios mensais detalhados sobre a empresa, incluindo informações sobre pagamentos e benefícios dos funcionários.

#### Principais Métodos e Funcionalidades

- **main(String[] args)**:
  - Ponto de entrada do programa.
  - Cria uma instância da `Empresa` chamando o método `criarEmpresa()`.
  - Gera relatórios para diversos meses e anos específicos, chamando o método `relatorio()`.

- **relatorio(Empresa empresa, int mes, int ano)**:
  - Gera e exibe um relatório detalhado para a empresa no mês e ano especificados.
  - Inclui as seguintes informações:
    - Lista de funcionários com ID, nome e salário base.
    - Total pago no mês, incluindo salários e benefícios.
    - Funcionários que recebem benefícios.
    - Total pago em benefícios no mês.
    - Funcionário com maior pagamento total no mês.
    - Funcionário com maior benefício no mês.
    - Vendedor com maior valor de vendas no mês.

- **criarEmpresa()**:
  - Instancia uma nova `Empresa`.
  - Cria e adiciona vários funcionários (secretários, vendedores e gerentes) à empresa.
  - Retorna a instância da empresa criada.

- **criarSecretario(String nome, LocalDate dataContratacao)**:
  - Cria e retorna uma nova instância de `Secretario` com o nome e data de contratação fornecidos.

- **criarVendedor(String nome, LocalDate dataContratacao, double[] vendas)**:
  - Cria e retorna uma nova instância de `Vendedor` com o nome, data de contratação e array de vendas fornecidos.

- **criarGerente(String nome, LocalDate dataContratacao)**:
  - Cria e retorna uma nova instância de `Gerente` com o nome e data de contratação fornecidos.

### Resumo dos Principais Pontos

- A classe `Main` cria uma empresa com uma lista inicial de funcionários, incluindo secretários, vendedores e gerentes.
- Gera relatórios mensais detalhados sobre a empresa, incluindo informações sobre salários, benefícios, e desempenho de vendas.
- Utiliza métodos auxiliares para criar instâncias específicas de `Secretario`, `Vendedor` e `Gerente`.
- Centraliza a lógica de criação e relatório de funcionários, tornando o código modular e organizado.

## Classes Estáticas 

As classes estáticas em Java não necessariamente "quebram" o paradigma da Programação Orientada a Objetos (POO), mas elas introduzem uma forma de programação que não é totalmente alinhada com os princípios fundamentais da POO. Aqui está uma análise mais detalhada:

### Usos e Benefícios de Classes Estáticas

Apesar das limitações em relação aos princípios da POO, as classes estáticas têm seus usos e benefícios:

1. **Funções Utilitárias**: São ideais para métodos que não dependem do estado de uma instância, como métodos matemáticos (`Math.sqrt()`) ou funções de manipulação de strings.

2. **Singleton**: O padrão de projeto Singleton pode ser implementado usando uma classe estática para garantir que uma classe tenha uma única instância globalmente acessível.

3. **Performance**: Métodos estáticos podem ser ligeiramente mais rápidos do que métodos de instância porque não há necessidade de alocação de memória para instâncias de objetos.

### Conclusão

Embora classes estáticas não sejam ideais para todos os casos e possam não se alinhar completamente com os princípios da POO, se usadas apropriadamente. Elas devem ser utilizadas principalmente para funções utilitárias ou quando se deseja garantir uma única instância global (como no padrão Singleton). É importante equilibrar o uso de classes estáticas com o uso de objetos para manter os benefícios da POO, como encapsulamento, abstração, herança e polimorfismo.

## Licença

Este projeto está licenciado sob a licença MIT. Consulte o arquivo `LICENSE` para obter mais informações.