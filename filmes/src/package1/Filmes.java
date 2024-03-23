package package1;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

// Protected só é visivel nos pacotes dentro da classe
public class Filmes {
        protected String titulo;
        protected double duracao;
        protected String genero;

        public static void cadastro(String[]args)throws Exception{
            Filmes f1 = new Filmes();
            f1.titulo = "O brilho eterno de uma mente sem lembrancas";
            f1.duracao = 1.48;
            f1.genero = "Romance";

            Filmes f2 = new Filmes();
            f2.titulo = "O menino que descobriu o vento";
            f2.duracao = 1.53;
            f2.genero = "Drama";

            Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
            Scanner input_user = new Scanner(System.in);

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            System.out.println(dtf.format(LocalDateTime.now()));            

            System.out.println("Filme 1: " + f1.titulo + " Duracao: "+ f1.duracao + " Genero: " + f1.genero);
            System.out.println("Filme 2: " + f2.titulo + " Duracao: " + f2.duracao + " Genero: " + f2.genero);           

            System.out.println("Bem vindo ao cadastro de filmes");

            System.out.println(" Digite o Titulo: ");
            String nome = input_user.nextLine();

            System.out.println(" Digite Duracao: ");
            int tempo = input_user.nextInt();
            input_user.nextLine();

            System.out.println(" Digite genero: ");
            String tipo = input_user.nextLine();

            Filmes input = new Filmes();
            input.titulo = nome;
            input.duracao = tempo;
            input.genero = tipo;

            System.out.println("Filme 1: " + nome + " Duracao: "+ tempo + " Genero: " + tipo);
    }

    public void setFilmes(String nome) throws Exception{
        if(nome.isEmpty() || nome == null){
            throw new Exception("Insira o nome:");
        }
        this.titulo = nome;                
    }
}

