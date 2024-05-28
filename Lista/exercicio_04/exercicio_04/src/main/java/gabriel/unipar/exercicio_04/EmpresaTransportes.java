package gabriel.unipar.exercicio_04;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Stack;

class Produto {
    int codProduto;
    String descricao;
    Date dataEntrada;
    String ufOrigem;
    String ufDestino;

    public Produto(int codProduto, String descricao, Date dataEntrada, String ufOrigem, String ufDestino) {
        this.codProduto = codProduto;
        this.descricao = descricao;
        this.dataEntrada = dataEntrada;
        this.ufOrigem = ufOrigem;
        this.ufDestino = ufDestino;
    }

    @Override
    public String toString() {
        return "Código do Produto: " + codProduto +
                "\nDescrição: " + descricao +
                "\nData de Entrada: " + dataEntrada +
                "\nOrigem: " + ufOrigem +
                "\nDestino: " + ufDestino;
    }
}

public class EmpresaTransportes {
    private static final int MAX_CAIXAS = 10;
    private Stack<Produto> pilhaProdutos;

    public EmpresaTransportes() {
        this.pilhaProdutos = new Stack<>();
    }

    public void adicionarProduto(Produto produto) {
        if (pilhaProdutos.size() < MAX_CAIXAS) {
            pilhaProdutos.push(produto);
            System.out.println("Produto adicionado à pilha.");
        } else {
            System.out.println("A pilha de produtos está cheia. Não é possível adicionar mais produtos.");
        }
        exibirPilhaProdutos();
    }

    public void despacharProduto() {
        if (!pilhaProdutos.isEmpty()) {
            Produto produtoDespachado = pilhaProdutos.pop();
            System.out.println("Produto despachado:\n" + produtoDespachado);
        } else {
            System.out.println("A pilha de produtos está vazia. Não há produtos para despachar.");
        }
        exibirPilhaProdutos();
    }

    public void exibirPilhaProdutos() {
        System.out.println("\nPilha de Produtos:");
        for (Produto produto : pilhaProdutos) {
            System.out.println(produto);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        EmpresaTransportes empresa = new EmpresaTransportes();
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1 - Adicionar Produto");
            System.out.println("2 - Despachar Produto");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Informe o código do produto: ");
                    int codProduto = scanner.nextInt();
                    scanner.nextLine(); // Consumir a nova linha
                    System.out.print("Informe a descrição do produto: ");
                    String descricao = scanner.nextLine();
                    System.out.print("Informe a data de entrada do produto (dd/mm/aaaa): ");
                    String dataStr = scanner.nextLine();
                    System.out.print("Informe a UF de origem do produto: ");
                    String ufOrigem = scanner.nextLine();
                    System.out.print("Informe a UF de destino do produto: ");
                    String ufDestino = scanner.nextLine();

                    // Converter a string de data para o tipo Date
                    Date dataEntrada;
                    try {
                        dataEntrada = sdf.parse(dataStr);
                    } catch (ParseException e) {
                        System.out.println("Formato de data inválido. Utilize o formato dd/mm/aaaa.");
                        continue;
                    }

                    Produto produto = new Produto(codProduto, descricao, dataEntrada, ufOrigem, ufDestino);
                    empresa.adicionarProduto(produto);
                    break;
                case 2:
                    empresa.despacharProduto();
                    break;
                case 3:
                    System.out.println("Encerrando o programa.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
