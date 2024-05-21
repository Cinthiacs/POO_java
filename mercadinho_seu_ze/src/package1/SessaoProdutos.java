package package1;
import package1.Produto;
import package1.Item;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Locale;
import package1.Conn;
import java.sql.SQLException;

public class SessaoProdutos {

    private Connection conn;

    public void cadastrar_produto(Connection conn) throws SQLException {
        this.conn = conn;

        Scanner entrada_usu = new Scanner(System.in).useLocale(Locale.US);

        System.out.println("*Cadastro de Produtos Mercado seu Zé!*");

        System.out.println("Insira nome do produto: ");
        String nome = entrada_usu.nextLine();

        System.out.println("Insira a descricao do produto: ");
        String descricao = entrada_usu.nextLine();

        System.out.println("Digite o preco do produto: ");
        Double preco = entrada_usu.nextDouble();

        System.out.println("Insira a codigo do produto: ");
        entrada_usu.nextLine(); // Consumindo a quebra de linha pendente
        String codigo = entrada_usu.nextLine();

        System.out.println("Insira a categoria do produto: ");
        String categoria = entrada_usu.nextLine();

        System.out.println("Insira a quantidade do produto: ");
        int quantidade = entrada_usu.nextInt();

        System.out.println("O produto está disponivel? (s/n)");

        entrada_usu.nextLine(); // Consumindo a quebra de linha pendente
        String username = entrada_usu.nextLine();
        while (!username.equalsIgnoreCase("s") && !username.equalsIgnoreCase("n")) {
            System.out.println("Opcao invalida");
            username = entrada_usu.nextLine();
        }

        boolean disponibilidade = username.equalsIgnoreCase("s");

        System.out.println("Digite a data de Validade do Produto: ");
        String data_validade = entrada_usu.nextLine();

        entrada_usu.close();

        Produto produto = new Produto(nome, descricao, preco, codigo, categoria, quantidade, disponibilidade, data_validade);

        if (conn != null) {
            String sql = "INSERT INTO produtos (nome_produto, descricao_produto, preco_produto, codigo_produto, categoria_produto, quantidade_estoque, disponibilidade_produto, data_validade_produto) VALUES ('" + produto.get_nome() + "',\n"
                    + "'" + produto.get_descricao() + "',\n"
                    + produto.get_preco() + ",\n"
                    + "'" + produto.get_codigo() + "',\n"
                    + "'" + produto.get_categoria() + "',\n"
                    + produto.get_quantidade() + ",\n"
                    + produto.get_disponivel() + ",\n"
                    + "'" + produto.get_data_validade() + "')";

            Statement statement = conn.createStatement();
            int rows = statement.executeUpdate(sql);

            if (rows > 0) {
                System.out.println("Um novo cadastro foi inserido com sucesso");
            }
        } else {
            System.out.println("Erro: Nome_produto, tipo ou preço_Kg não podem estar vazios");
        }
        conn.close();
    }
}

     // produto.Read();

        // produto.Update();

        // produto.Detalhes();


       