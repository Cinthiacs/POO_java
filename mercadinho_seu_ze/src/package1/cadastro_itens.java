package package1;
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
        Scanner in = new Scanner(System.in,"UTF-8");    

        System.out.println("");
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        Scanner input_user = new Scanner(System.in);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        System.out.println(dtf.format(LocalDateTime.now()));     

        System.out.println("Bem vindo ao cadastro de mercadorias!");      

        
        
        while (true) {

            System.out.println("Escolha a opcao para cadastro: ");
            System.out.println(" 0 - Para sair do programa");
            System.out.println(" 1 - Cadastro Hortifrutis");
            System.out.println(" 2 - Cadastro Carnes");

            int opcao;

            try {
                opcao = scanner.nextInt();                
                
            } catch (Exception e) {
                System.out.println("Opcao invalida! Tente Novamente.");
                scanner.next();
                continue;
            }

            switch(opcao){
                case 0:
                    System.out.println("Saindo do programa...");
                    return;

                case 1:
                 
                    break;
    
                case 2:
    
                    break;
                
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    
                }
            
        }
        
    }
}


   

    // private void cadastro_horti(Scanner in){

    //     System.out.println ("Insira nome do produto: ");
    //     String nome_hort = in.nextLine();

    //     System.out.println ("Insira tipo do produto: legumes ou folhas? ");
    //     String tipo_hort = in.nextLine();

    //     System.out.println("Digite o preco por kg: ");
    //     double preco = in.nextDouble();

    //     if(!nome_hort.isEmpty()){
    //         String sql_nome_hort = "INSERT INTO mercearia (nome_produto) VALUES ('" + nome_hort + "')";
    //     }       

    //     if (!tipo_hort.isEmpty() && (tipo_hort.equalsIgnoreCase("legumes") || tipo_hort.equalsIgnoreCase("folhas"))){
    //         String sql_nome_hort = "INSERT INTO mercearia (tipo_) VALUES ('" + tipo_hort + "')";
    //     }        
    
    // }
