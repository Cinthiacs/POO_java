package package1;
import package1.cadastro_funcionarios;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Locale;
import java.util.Scanner;

public class cadastro_funcionarios {
    private Connection conn;
     
    public cadastro_funcionarios(Connection conn){
        this.conn = conn;
    }
    
    public void cadastrar_funcionarios() {
        
        Scanner entrada_usu = new Scanner(System.in).useLocale(Locale.US);
        
        try {
            System.out.println("*Cadastro de Funcionarios Mercado seu Zé!*");

            System.out.println ("Insira o Nome Completo: ");
            String nome_funcionario = entrada_usu.nextLine();

            System.out.println("Insira o CPF: ");
            String cpf = entrada_usu.nextLine();
            
            System.out.println("Digite a data de Admissão ");
            String data_admissao = entrada_usu.nextLine();
            
            funcionarios entrada = new funcionarios();

            entrada.nome_funcionario = nome_funcionario;
            entrada.cpf = cpf;
            entrada.data_admissao = data_admissao;

            System.out.println("Nome Produto: " + nome_funcionario + 
                               " Tipo Hortifruti "+ cpf + 
                               " Data admissao: " + data_admissao);

            if (conn != null){
                String sql = "INSERT INTO funcionarios (nome_funcionario, cpf, data_admissao) VALUES ('" + entrada.get_nome_funcionario() + "', '" + entrada.get_cpf() + 
                                                                                             "', '" + entrada.get_data_admissao() + "')";
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
