import package1.Conn;
import package1.cadastro_itens;
import java.sql.Connection;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception{
        Connection conn = null;

        cadastro_itens cadastro = new cadastro_itens(conn);
        cadastro.cadastrar_item();
    }
}


    //     while (conn == null){
    //         Conn conn_verifica = new Conn();
    //         conn = conn_verifica.getConnection();
            
    //         if(conn == null){
    //             System.out.println("Deseja se conectar novamente? s/n");
    //             String verificacao = scanner.nextLine().trim().toLowerCase();
                
    //             if(verificacao.equals("n")){
    //                 System.out.println("Saindo do programa...");
    //                 return;
    //             }
    //         }
    //     }
    //     cadastro_itens cadastro = new cadastro_itens(conn);
    //     cadastro.cadastrar_item();
    // }

