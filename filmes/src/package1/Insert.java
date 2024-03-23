package package1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Insert {

    private String url;
    private String usuario;
    private String senha;
    private Connection insert;    


    public Insert(){
        url =  "jdbc:postgresql://localhost:5432/locadora";
        usuario = "postgres";
        senha = "1234";

        try {
            Class.forName("org.postgresql.Driver");
            insert = DriverManager.getConnection(url,usuario, senha);
            System.out.println("Conexao realizada com sucesso!");

            Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
            Scanner input_user = new Scanner(System.in);

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            System.out.println(dtf.format(LocalDateTime.now()));     

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
    
            if(!nome.isEmpty() && tempo > 0 && !tipo.isEmpty()){
                String sql = "INSERT INTO filmes (titulo, duracao, genero) VALUES ('" + nome + "', " + tempo + ", '" + tipo + "')";

                Statement statement = insert.createStatement();
                int rows = statement.executeUpdate(sql);
                if(rows > 0){
                    System.out.println("Um novo cadastro foi inserido com sucesso");
            }            
            }else{
                System.out.println("Erro: Nome, tempo ou tipo não podem estar vazios");
            }

            insert.close();

        } catch (Exception e) {
            System.err.println("Erro de conexao POstgresql");
            e.printStackTrace();            
        }
    }
}
