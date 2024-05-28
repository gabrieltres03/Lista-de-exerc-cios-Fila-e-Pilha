package gabriel.unipar.exercicio_05;


import java.util.*;

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

public class Exercicio_05 {
    private static final int NUM_PILHAS = 5;
    private static final int MAX_CAIXAS = 10;
    private Stack<Produto>[] pilhasProdutos;

    @SuppressWarnings("unchecked")
    public Exercicio_05() {
        this.pilhasProdutos = new Stack[NUM_PILHAS];
        for (int i = 0; i < NUM_PILHAS; i++) {
            pilhasProdutos[i] = new Stack<>();
        }
    }

    public void adicionarProduto(int pilha, Produto produto) {
        if (pilha < 1 || pilha > NUM_PILHAS) {
            System.out.println("Número de pilha inválido.");
            return;
        }

        Stack<Produto> pilhaSelecionada = pilhasProdutos[pilha - 1];
        if (pilhaSelecionada.size() < MAX_CAIXAS) {
            pilhaSelecionada.push(produto);
            System.out.println("Produto adicionado à pilha " + pilha + ".");
        } else {
            System.out.println("A pilha " + pilha + " está cheia. Não é possível adicionar mais produtos.");
        }
        exibirPilhasProdutos();
    }

    public void despacharProduto(int pilha) {
        if (pilha < 1 || pilha > NUM_PILHAS) {
            System.out.println("Número de pilha inválido.");
            return;
        }

        Stack<Produto> pilhaSelecionada = pilhasProdutos[pilha - 1];
        if (!pilhaSelecionada.isEmpty()) {
            Produto produtoDespachado = pilhaSelecionada.pop();
            System.out.println("Produto despachado da pilha " + pilha + ":\n" + produtoDespachado);
        } else {
            System.out.println("A pilha " + pilha + " está vazia. Não há produtos para despachar.");
        }
        exibirPilhasProdutos();
    }

    public void exibirPilhasProdutos() {
        System.out.println("\nPilhas de Produtos:");
        for (int i = 0; i < NUM_PILHAS; i++) {
            System.out.println("Pilha " + (i + 1) + ":");
            Stack<Produto> pilha = pilhasProdutos[i];
            if (pilha.isEmpty()) {
                System.out.println("A pilha está vazia.");
            } else {
                for (Produto produto : pilha) {
                    System.out.println(produto);
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Exercicio_05 empresa = new Exercicio_05();
        Scanner scanner = new Scanner(System.in);

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
                    System.out.print("Informe o número da pilha (1-" + NUM_PILHAS + "): ");
                    int pilhaAdd = scanner.nextInt();
                    scanner.nextLine(); // Consumir a nova linha
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
                    Date dataEntrada = new Date();
                    // Aqui seria necessário fazer a conversão de String para Date

                    Produto produto = new Produto(codProduto, descricao, dataEntrada, ufOrigem, ufDestino);
                    empresa.adicionarProduto(pilhaAdd, produto);
                    break;
                case 2:
                    System.out.print("Informe o número da pilha (1-" + NUM_PILHAS + "): ");
                    int pilhaDesp = scanner.nextInt();
                    empresa.despacharProduto(pilhaDesp);
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

