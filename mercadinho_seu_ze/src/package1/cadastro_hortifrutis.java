package package1;
import package1.Conn;
import package1.cadastro_itens;
import package1.Horti;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Locale;
import java.util.Scanner;


public class cadastro_hortifrutis {

     private Connection conn;
     
    public cadastro_hortifrutis(Connection conn){
        this.conn = conn;
    }
    
    public void cadastrar_horti() {
        
        Scanner entrada_usu = new Scanner(System.in).useLocale(Locale.US);
        
        try {
            System.out.println("*Cadastro de Hortifrutis Mercado seu Zé!*");

            System.out.println ("Insira nome do produto: ");
            String nome_hort = entrada_usu.nextLine();

            System.out.println("Insira tipo do produto: legumes ou folhas? ");
            String tipo_hort = entrada_usu.nextLine();
            
            System.out.println("Digite o preco por kg: ");
            Double preco_kg = entrada_usu.nextDouble();
            
            Horti entrada = new Horti();

            entrada.nome_produto = nome_hort;
            entrada.tipo = tipo_hort;
            entrada.preco_kg = preco_kg;

            System.out.println("Nome Produto: " + nome_hort + 
                               " Tipo Hortifruti "+ tipo_hort + 
                               " Preco_Kg: " + preco_kg);

            if (conn != null){
                String sql = "INSERT INTO hortifrutis (nome_produto, tipo, preco_kg) VALUES ('" + entrada.get_nome_produto() + "', '" + entrada.get_tipo() + 
                                                                                             "', '" + entrada.get_preco_kg() + "')";
                Statement statement = conn.createStatement();
                int rows = statement.executeUpdate(sql);

            if(rows > 0){
                System.out.println("Um novo cadastro foi inserido com sucesso");
            }            
            }else{
                System.out.println("Erro: Nome_produto, tipo ou preço_Kg não podem estar vazios");
            }
            conn.close();

        } catch (Exception e) {
            System.out.println("Falha na conexão Banco de Dados!" + e.getMessage());
            e.printStackTrace();
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
