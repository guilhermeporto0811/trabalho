import java.util.List;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        DatasetReader r1 = new DatasetReader();
        List<Book> livros = r1.readDataset("src/data.csv");  // Lê os dados do CSV
        Scanner lei = new Scanner(System.in);
        Set<String> autores = new HashSet<>();  // Para armazenar autores únicos

        // Adiciona todos os autores ao conjunto
        for (Book k : livros) {
            autores.add(k.getAuthor());
        }

        System.out.println("Autores encontrados:");
        for (String author : autores) {
            System.out.println(author);
        }

        // Tarefa I: Número total de livros por autor
        System.out.println("Digite o nome do autor para contar livros:");
        String authorInput = lei.nextLine();
        int numeroLivros = numberOfBooksByAuthor(livros, authorInput);
        System.out.println("A quantidade de livros de " + authorInput + ": " + numeroLivros);

        // Tarefa III: Nomes de todos os livros de um autor
        System.out.println("Digite o nome do autor para listar livros:");
        String authorInput1 = lei.nextLine();
        Set<String> livrosDoAutor = getBooksByAuthor(livros, authorInput1);
        System.out.println("Livros de " + authorInput1 + ":");
        for (String titulo : livrosDoAutor) {
            System.out.println(titulo);
        }

        // Tarefa IV: Classificar por avaliação dos usuários
        System.out.println("Digite a nota do livro:");
        double notaInput = lei.nextDouble();
        Set<String> livrosNota = getBooksByRating(livros, notaInput);
        System.out.println("Livros com nota " + notaInput + ":");
        for (String notas : livrosNota) {
            System.out.println(notas);
        }

        // Tarefa V: Preço de todos os livros de um autor
        lei.nextLine();  // Consumir a nova linha
        System.out.println("Digite o nome do autor para listar preços dos livros:");
        String authorInput2 = lei.nextLine();
        Set<String> livrosDoAutor1 = getBooksAndPricesByAuthor(livros, authorInput2);
        System.out.println("Livros de " + authorInput2 + ":");
        for (String preco : livrosDoAutor1) {
            System.out.println(preco);
        }

        lei.close();
    }

    private static int numberOfBooksByAuthor(List<Book> livros, String author) {
        int count = 0;
        for (Book book : livros) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                count++;
            }
        }
        return count;
    }

    private static Set<String> getBooksByAuthor(List<Book> livros, String author) {
        Set<String> livrosDoAutor = new HashSet<>();
        for (Book book : livros) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                livrosDoAutor.add(book.getTitle());
            }
        }
        return livrosDoAutor;
    }

    private static Set<String> getBooksByRating(List<Book> livros, double Userating) {
        Set<String> livrosNota = new HashSet<>();
        for (Book book : livros) {
            if (Book.getUserRating() == rating) {
                livrosNota.add(book.getTitle() + " de " + book.getAuthor());
            }
        }
        return livrosNota;
    }

    private static Set<String> getBooksAndPricesByAuthor(List<Book> livros, String author) {
        Set<String> livrosDoAutor1 = new HashSet<>();
        for (Book book : livros) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                livrosDoAutor1.add(book.getTitle() + " - " + book.getPrice());
            }
        }
        return livrosDoAutor1;
    }
}