package gabriel.unipar.exercicio_03;

import java.util.Scanner;
import java.util.Stack;

class Livro {
    private String titulo;
    private String autor;

    public Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Título: " + titulo + ", Autor: " + autor;
    }
}

public class Exercicio_03 {

    public static class Biblioteca {
        private Stack<Livro> pilhaDeLivros;

        public Biblioteca() {
            this.pilhaDeLivros = new Stack<>();
        }

        public void adicionarLivro(String titulo, String autor) {
            Livro livro = new Livro(titulo, autor);
            pilhaDeLivros.push(livro);
            System.out.println("Livro adicionado à pilha: " + livro);
        }

        public void listarLivros() {
            if (pilhaDeLivros.isEmpty()) {
                System.out.println("A pilha de livros está vazia.");
            } else {
                System.out.println("Livros na pilha:");
                for (Livro livro : pilhaDeLivros) {
                    System.out.println(livro);
                }
            }
        }

        public void retirarLivro() {
            if (pilhaDeLivros.isEmpty()) {
                System.out.println("A pilha de livros está vazia. Não há livros para remover.");
            } else {
                Livro livroRemovido = pilhaDeLivros.pop();
                System.out.println("Livro removido da pilha: " + livroRemovido);
            }
        }

        public void mostrarMenu() {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("\nMenu:");
                System.out.println("1 - Adicionar livro");
                System.out.println("2 - Listar livros");
                System.out.println("3 - Retirar livro");
                System.out.println("4 - Sair");
                System.out.print("Escolha uma opção: ");

                int opcao = scanner.nextInt();
                scanner.nextLine();  // Consumir a nova linha

                switch (opcao) {
                    case 1:
                        System.out.print("Informe o título do livro: ");
                        String titulo = scanner.nextLine();
                        System.out.print("Informe o autor do livro: ");
                        String autor = scanner.nextLine();
                        adicionarLivro(titulo, autor);
                        break;
                    case 2:
                        listarLivros();
                        break;
                    case 3:
                        retirarLivro();
                        break;
                    case 4:
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
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.mostrarMenu();
    }
}
