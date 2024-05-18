# Teste Técnico Programação Orientada a Objetos 
- Teste Tecnico para a empresa SINERJI - Gestão e Sistemas Ltda.
- Java e Orientação a Objetos.
- Autor: Robson Ferreira da Silva

## Descrição

**Objetivo:**
O objetivo deste projeto é desenvolver uma aplicação em Java capaz de gerar relatórios financeiros detalhados baseados nas vendas de uma empresa, além de fornecer informações abrangentes sobre a gestão de recursos humanos, incluindo salários, datas de admissão e benefícios dos funcionários.

- Este projeto implementa um sistema de gestão de pagamentos de funcionários utilizando conceitos de Programação Orientada a Objetos (POO) em Java. A aplicação calcula o salário e benefícios de diferentes tipos de funcionários de uma empresa, incluindo secretários, vendedores e gerentes.
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

```java
public abstract class Funcionarios {
    // Atributos e métodos comuns a todos os funcionários
}
```

### Subclasses de `Funcionario`

#### `Secretario`

```java
public class Secretario extends Funcionarios {
    // Implementação específica para secretários
}
```

#### `Vendedor`

```java
public class Vendedor extends Funcionarios {
    // Implementação específica para vendedores
}
```

#### `Gerente`

```java
public class Gerente extends Funcionarios {
    // Implementação específica para gerentes
}
```

### Classe `Empresa`

```java
public class Empresa {
    // Métodos para calcular salários e benefícios
}
```

### Classe `Main`

```java
public class Main {
    // Código para testar a lógica do sistema
}
```


## Licença

Este projeto está licenciado sob a licença MIT. Consulte o arquivo `LICENSE` para obter mais informações.