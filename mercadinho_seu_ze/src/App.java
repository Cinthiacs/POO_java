import package1.Conn;
import package1.cadastro_hortifrutis;
import package1.cadastro_itens;
import package1.Horti;
import java.sql.Connection;
import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception{

        Scanner entrada_usu = new Scanner(System.in).useLocale(Locale.US);

        Conn connHandler = null;
        Connection conn = null;

        while (conn == null) {
            connHandler = new Conn();
            conn = connHandler.getConnection();

            if (conn == null) {
                System.out.println("Deseja tentar conectar novamente? s/n");
                String resposta = entrada_usu.nextLine().trim().toLowerCase();
                if (resposta.equals("n")) {
                    System.out.println("Saindo do programa...");
                }
            }
        }
        cadastro_itens cadastroItens = new cadastro_itens(conn);
        cadastroItens.cadastrar_item(); 

        if (conn != null && !conn.isClosed()) {
            conn.close();
            System.out.println("Conexão fechada com sucesso.");
        }
    }
}