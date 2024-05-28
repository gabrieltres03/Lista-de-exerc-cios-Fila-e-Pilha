package gabriel.unipar.exercicio_01;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Exercicio_01 {

    public static class Clinica {
        private Queue<String> fila;
        private final int capacidadeMaxima;

        public Clinica(int capacidade) {
            this.fila = new LinkedList<>();
            this.capacidadeMaxima = capacidade;
        }

        public void adicionarPaciente(String nome) {
            if (fila.size() < capacidadeMaxima) {
                fila.add(nome);
                System.out.println("Paciente " + nome + " adicionado à fila.");
            } else {
                System.out.println("A fila já está cheia. Não é possível adicionar mais pacientes hoje.");
            }
        }

        public void chamarProximoPaciente() {
            if (!fila.isEmpty()) {
                String proximoPaciente = fila.poll();
                System.out.println("Próximo paciente: " + proximoPaciente);
            } else {
                System.out.println("Não há pacientes na fila.");
            }
        }

        public void mostrarMenu() {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("\nMenu:");
                System.out.println("1 - Adicionar paciente");
                System.out.println("2 - Chamar próximo paciente");
                System.out.println("3 - Sair");
                System.out.print("Escolha uma opção: ");

                int opcao = scanner.nextInt();
                scanner.nextLine();  // Consumir a nova linha

                switch (opcao) {
                    case 1:
                        System.out.print("Informe o nome do paciente: ");
                        String nome = scanner.nextLine();
                        adicionarPaciente(nome);
                        break;
                    case 2:
                        chamarProximoPaciente();
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
        Clinica clinica = new Clinica(20);
        clinica.mostrarMenu();
    }
}
