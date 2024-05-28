package gabriel.unipar.exercicio_02;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Cliente {
    int senha;
    String nome;
    int anoNascimento;

    public Cliente(int senha, String nome, int anoNascimento) {
        this.senha = senha;
        this.nome = nome;
        this.anoNascimento = anoNascimento;
    }

    @Override
    public String toString() {
        return "Senha: " + senha + ", Nome: " + nome + ", Ano de Nascimento: " + anoNascimento;
    }
}

public class Exercicio_02 {

    public static class Banco {
        private Queue<Cliente> filaPrioritaria;
        private Queue<Cliente> filaNormal;
        private int contadorPrioritario;

        public Banco() {
            this.filaPrioritaria = new LinkedList<>();
            this.filaNormal = new LinkedList<>();
            this.contadorPrioritario = 0;
        }

        public void adicionarCliente(int senha, String nome, int anoNascimento) {
            Cliente cliente = new Cliente(senha, nome, anoNascimento);
            int idade = 2024 - anoNascimento;

            if (idade >= 65) {
                filaPrioritaria.add(cliente);
                System.out.println("Cliente adicionado à fila prioritária: " + cliente);
            } else {
                filaNormal.add(cliente);
                System.out.println("Cliente adicionado à fila normal: " + cliente);
            }
        }

        public void chamarProximoCliente() {
            if (!filaPrioritaria.isEmpty() && (contadorPrioritario < 2 || filaNormal.isEmpty())) {
                Cliente cliente = filaPrioritaria.poll();
                System.out.println("Atendendo cliente prioritário: " + cliente);
                contadorPrioritario++;
            } else if (!filaNormal.isEmpty()) {
                Cliente cliente = filaNormal.poll();
                System.out.println("Atendendo cliente normal: " + cliente);
                contadorPrioritario = 0;
            } else if (!filaPrioritaria.isEmpty()) {
                Cliente cliente = filaPrioritaria.poll();
                System.out.println("Atendendo cliente prioritário: " + cliente);
                contadorPrioritario++;
            } else {
                System.out.println("Não há clientes na fila.");
            }
        }

        public void mostrarMenu() {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("\nMenu:");
                System.out.println("1 - Adicionar cliente");
                System.out.println("2 - Chamar próximo cliente");
                System.out.println("3 - Sair");
                System.out.print("Escolha uma opção: ");

                int opcao = scanner.nextInt();
                scanner.nextLine();  // Consumir a nova linha

                switch (opcao) {
                    case 1:
                        System.out.print("Informe a senha do cliente: ");
                        int senha = scanner.nextInt();
                        scanner.nextLine();  // Consumir a nova linha
                        System.out.print("Informe o nome do cliente: ");
                        String nome = scanner.nextLine();
                        System.out.print("Informe o ano de nascimento do cliente: ");
                        int anoNascimento = scanner.nextInt();
                        adicionarCliente(senha, nome, anoNascimento);
                        break;
                    case 2:
                        chamarProximoCliente();
                        break;
                    case 3:
                        System.out.println("Saindo do sistema.");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            }
        }
    }

    public static void main(String[] args) {
        Banco banco = new Banco();
        banco.mostrarMenu();
    }
}
