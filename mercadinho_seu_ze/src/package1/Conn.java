package package1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class Conn {
    private String url;
    private String usuario;
    private String senha;
    private String banco_dados;
    private Connection conn;    

    public Conn(){

        try{

            Scanner in = new Scanner(System.in);
            System.out.println("Mercadinho do Seu Zé");

            System.out.println("Digite o nome do Banco de Dados abaixo:\n");
            String entrada_nome_db = in.nextLine();

            System.out.println("Digite o usuario: ");
            String entrada_usuario = in.nextLine(); 

            System.out.println("Digite a Senha: ");
            String entrada_senha = in.nextLine();

            this.banco_dados = entrada_nome_db;
            this.url = "jdbc:postgresql://localhost:5432/"+ this.banco_dados;
            this.usuario = entrada_usuario;
            this.senha = entrada_senha;

            System.out.println("Conectando ao banco de dados...");

            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, usuario,senha);
            System.out.println("Conexao bem Sucedida!");

        } catch (Exception e){
        System.out.println("***A Conexao falhou***");
        e.printStackTrace();
        conn = null;
        }
    }

    public Connection getConnection(){
        return conn;
    }
}


    //     url = "jdbc:postgresql://localhost:5432/armazem";
    //     user = "postgres";
    //     pass = "1234";

    //     try{
    //         Class.forName("org.postgresql.Driver");
    //         conn = DriverManager.getConnection(url,user, pass);
    //         System.out.println("Conexao realizada com sucesso!");
    //     } catch (Exception e) {
    //         System.out.println("Conexao Falhou");
    //         e.printStackTrace();
    //     }
    // }

