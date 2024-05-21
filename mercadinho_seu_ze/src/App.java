import package1.Conn;
import package1.Produto;
import package1.Servico;
import package1.SessaoProdutos;
import package1.Item;
import java.sql.Connection;
import java.util.Locale;
import java.util.Scanner;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class App {
    public static void main(String[] args) throws Exception{
        Conn conn = new Conn();

        Scanner entrada_usu = new Scanner(System.in).useLocale(Locale.US);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        System.out.println(dtf.format(LocalDateTime.now()));     

        System.out.println("Bem vindo ao cadastro de Produtos e Servicos!");      
        
        
        while (true) {

            System.out.println("Escolha uma sessão: ");
            System.out.println(" 0 - Para sair do programa");
            System.out.println(" 1 - Produtos");
            System.out.println(" 2 - Servicos");

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
                    SessaoProdutos sessaoProdutos = new SessaoProdutos();
                    sessaoProdutos.cadastrar_produto(conn.getConnection());                    
                    break;

                case 2:                
                // Cadastro Servicos

                    break;       
                
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                 
            }
            
        }
        
    }

        // Produto produto = new Produto(  "Arroz", 
        //                                 "Arroz Branco Tipo 1", 
        //                                 20.00, 
        //                                 "P001", 
        //                                 "Alimentos", 
        //                                 50, 
        //                                 "Fornecedor A", 
        //                                 true, 
        //                                 "2025-01-01", 
        //                                 "Marca X");
        //                                 produto.Detalhes();
        //                                 produto.Create();

        // System.out.println("OOOPPAAAA");

        // Servico servico = new Servico(  "Lavagem de Carro", 
        //                                 "Lavagem completa do carro",
        //                                 100.00, 
        //                                 "S001", 
        //                                 "Servicos Automotivos", 
        //                                 true,
        //                                 12,
        //                                 true);
        // servico.Detalhes();
        // servico.Create();
    }


