package package1;
import java.sql.Connection;
import java.sql.DriverManager;


public class Conn {
    private String url;
    private String usuario;
    private String senha;
    private Connection conn;

    public Conn(){
        url =  "jdbc:postgresql://localhost:5432/armazem";
        usuario = "postgres";
        senha = "1234";

        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url,usuario, senha);
            System.out.println("Conexao realizada com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Connection getConnection(){
        return conn;
    }
    
}

   