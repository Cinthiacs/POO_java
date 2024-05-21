package package1;
import package1.Conn;
import package1.cadastro_hortifrutis;
import package1.Horti;
import package1.Laticinios;
import package1.cadastro_laticinios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class cadastro_itens {
    private Connection conn;

    public cadastro_itens(Connection conn){
        this.conn = conn;
    }
    public void cadastrar_item(){

        
        Scanner entrada_usu = new Scanner(System.in).useLocale(Locale.US);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        System.out.println(dtf.format(LocalDateTime.now()));     

        System.out.println("Bem vindo ao cadastro de mercadorias!");      

        
        
        while (true) {

            System.out.println("Escolha a opcao para cadastro: ");
            System.out.println(" 0 - Para sair do programa");
            System.out.println(" 1 - Cadastro Funcionarios");
            System.out.println(" 2 - Cadastro Hortifrutis");
            System.out.println(" 3 - Cadastro Laticinios");

            int opcao;

            try {
                opcao = entrada_usu.nextInt();                
                
            } catch (Exception e) {
                System.out.println("Opcao invalida! Tente Novamente.");
                entrada_usu.nextInt();
                continue;
            }

            switch(opcao){
                case 0:
                    System.out.println("Saindo do programa...");
                    return;

                case 1:
                    cadastro_funcionarios cadastroFuncionarios = new cadastro_funcionarios(conn);
                    cadastroFuncionarios.cadastrar_funcionarios();
                
                case 2:
                    cadastro_hortifrutis cadastroHortifrutis = new cadastro_hortifrutis(conn);
                    cadastroHortifrutis.cadastrar_horti();
    
                    break;

                case 3:
                    cadastro_laticinios cadastroLaticinios = new cadastro_laticinios(conn);
                    cadastroLaticinios.cadastrar_laticinios();    
                    break;
                
                
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                 
            }
            
        }
        
    }
}    