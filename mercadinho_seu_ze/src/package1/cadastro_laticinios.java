package package1;
import package1.Laticinios;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Locale;
import java.util.Scanner;

public class cadastro_laticinios {
    private Connection conn;
     
    public cadastro_laticinios(Connection conn){
        this.conn = conn;
    }
    
    public void cadastrar_laticinios() {
        
        Scanner entrada_usu = new Scanner(System.in).useLocale(Locale.US);
        
        try {
            System.out.println("*Cadastro de Laticinios Mercado seu Zé!*");

            System.out.println ("Insira nome do produto: ");
            String nome_laticinio = entrada_usu.nextLine();

            System.out.println("Insira tipo do produto: ");
            String tipo_laticinio = entrada_usu.nextLine();

            
            System.out.println("Digite o preco por unidade: ");
            Double preco_unidade_laticinio = entrada_usu.nextDouble();
            
            System.out.println("Digite o preco por kg: ");
            Double preco_kg_laticinio = entrada_usu.nextDouble();
            
            Laticinios entrada = new Laticinios();

            entrada.nome_produto = nome_laticinio;
            entrada.tipo = tipo_laticinio;
            entrada.preco_kg = preco_kg_laticinio;
            entrada.preco_unidade = preco_unidade_laticinio;

            System.out.println("Nome Produto: " + nome_laticinio + 
                               " Tipo Hortifruti "+ tipo_laticinio + 
                               " Preco_Kg: " + preco_kg_laticinio +
                               " Preco_unidade: " + preco_unidade_laticinio);

            if (conn != null){
                String sql = "INSERT INTO laticinios (nome_produto, tipo, preco_unidade, preco_kg) VALUES ('" + entrada.get_nome_produto() + "', '" + entrada.get_tipo() + 
                                                                                             "', '" + entrada.get_preco_unidade() +  "', '" + entrada.get_preco_kg() + "')"; 
                Statement statement = conn.createStatement();
                int rows = statement.executeUpdate(sql);

            if(rows > 0){
                System.out.println("Um novo cadastro foi inserido com sucesso");
            }            
            }else{
                System.out.println("Erro: Nome_produto, tipo, preço_Kg ou preco unidade não podem estar vazios");
            }
            conn.close();

        } catch (Exception e) {
            System.out.println("Falha na conexão Banco de Dados!" + e.getMessage());
            e.printStackTrace();
        } 
    }
}   

