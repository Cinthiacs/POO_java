package package1;
import package1.Produto;
import package1.Item;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Locale;
import package1.Conn;
import java.sql.SQLException;
import java.sql.ResultSet;

public class SessaoProdutos {

    private Connection conn;

    public void cadastrar_produto(Connection conn) throws SQLException {
        this.conn = conn;

        Scanner entrada_usu = new Scanner(System.in).useLocale(Locale.US);

        System.out.println("*Cadastro de Produtos Mercado seu Zé!*");
        while (true) {

            System.out.println("Escolha uma sessão: ");
            System.out.println(" 0 - Para sair do programa");
            System.out.println(" 1 - Para Cadastrar Produtos");
            System.out.println(" 2 - Para Imprimir produtos");
            System.out.println(" 3 - Para Atualizar produtos");
            System.out.println(" 4 - Para Deletar produtos");
            System.out.println(" 5 - Para Escolher Produtos");
            System.out.println(" 6 - Para Mostrar Carrinho de Compras");

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
                    break;

            case 2:                
                if (conn != null) {
                    String sql = "SELECT * FROM produtos";
                    Statement statement = conn.createStatement();
                    ResultSet resultSet = statement.executeQuery(sql);

                    while (resultSet.next()) {
                        System.out.println("Nome: " + resultSet.getString("nome_produto"));
                        System.out.println("Descrição: " + resultSet.getString("descricao_produto"));
                        System.out.println("Preço: " + resultSet.getDouble("preco_produto"));
                        System.out.println("Código: " + resultSet.getString("codigo_produto"));
                        System.out.println("Categoria: " + resultSet.getString("categoria_produto"));
                        System.out.println("Quantidade: " + resultSet.getInt("quantidade_estoque"));
                        System.out.println("Disponibilidade: " + resultSet.getBoolean("disponibilidade_produto"));
                        System.out.println("Data de Validade: " + resultSet.getString("data_validade_produto"));
                        System.out.println("---------------");
                    }
                } else {
                    System.out.println("Erro ao conectar com o banco de dados");
                }
                break;

                case 3:
                    // Código para atualizar produtos
                    System.out.println("Digite o código do produto a ser atualizado: ");
                    int codigoAtualizar = entrada_usu.nextInt();

                    System.out.println("Insira novo nome do produto: ");
                    String novoNome = entrada_usu.nextLine();

                    System.out.println("Insira nova descricao do produto: ");
                    String novaDescricao = entrada_usu.nextLine();

                    System.out.println("Digite novo preco do produto: ");
                    Double novoPreco = entrada_usu.nextDouble();

                    System.out.println("Insira nova categoria do produto: ");
                    entrada_usu.nextLine(); // Consumindo a quebra de linha pendente
                    String novaCategoria = entrada_usu.nextLine();

                    System.out.println("Insira nova quantidade do produto: ");
                    int novaQuantidade = entrada_usu.nextInt();

                    System.out.println("O produto está disponivel? (s/n)");
                    entrada_usu.nextLine(); // Consumindo a quebra de linha pendente
                    String novaDisponibilidade = entrada_usu.nextLine();
                    boolean novoDisponivel = novaDisponibilidade.equalsIgnoreCase("s");

                    System.out.println("Digite nova data de Validade do Produto: ");
                    String novaDataValidade = entrada_usu.nextLine();

                    if (conn != null) {
                        String sql = "UPDATE produtos SET nome_produto = '" + novoNome + "', descricao_produto = '" + novaDescricao + "', preco_produto = " + novoPreco 
                                    + ", categoria_produto = '" + novaCategoria + "', quantidade_estoque = " + novaQuantidade + ", disponibilidade_produto = " + novoDisponivel 
                                    + ", data_validade_produto = '" + novaDataValidade + "' WHERE codigo_produto = '" + codigoAtualizar + "'";

                        Statement statement = conn.createStatement();
                        int rows = statement.executeUpdate(sql);

                        if (rows > 0) {
                            System.out.println("Produto atualizado com sucesso");
                        } else {
                            System.out.println("Erro: Nenhum produto encontrado com o código fornecido");
                        }
                    } else {
                        System.out.println("Erro ao conectar com o banco de dados");
                    }
                    break;

                case 4:
                    // Código para deletar produtos                    
                    System.out.println("Digite o código do produto a ser deletado: ");
                    int codigoDeletar = entrada_usu.nextInt();

                    if (conn != null) {
                        String sql = "DELETE FROM produtos WHERE codigo_produto = '" + codigoDeletar + "'";

                        Statement statement = conn.createStatement();
                        int rows = statement.executeUpdate(sql);

                        if (rows > 0) {
                            System.out.println("Produto deletado com sucesso");
                        } else {
                            System.out.println("Erro: Nenhum produto encontrado com o código fornecido");
                        }
                    } else {
                        System.out.println("Erro ao conectar com o banco de dados");
                    }
                    break;

                case 5:
                    System.out.println("Escolher Serviços...");
                
                    // Lógica para escolher serviços
                    if (conn != null) {
                        Scanner scanner = new Scanner(System.in);
                
                        System.out.println("Digite o código do serviço que deseja escolher (ou digite 'sair' para finalizar): ");
                        String codigoServico = scanner.nextLine();
                
                        // Verifica se o usuário deseja sair da opção de escolha de serviços
                        if (codigoServico.equalsIgnoreCase("sair")) {
                            break;
                        }
                
                        try {
                            // Consulta SQL para verificar se o serviço com o código fornecido existe no banco de dados
                            String sql = "SELECT * FROM servicos WHERE codigo_servico = ?";
                            PreparedStatement statement = conn.prepareStatement(sql);
                            statement.setString(1, codigoServico);
                            ResultSet resultSet = statement.executeQuery();
                
                            // Se o serviço existe, exibe seus detalhes
                            if (resultSet.next()) {
                                System.out.println("Detalhes do Serviço:");
                                System.out.println("Nome: " + resultSet.getString("nome_servico"));
                                System.out.println("Descrição: " + resultSet.getString("descricao_servico"));
                                System.out.println("Preço: " + resultSet.getDouble("preco_servico"));
                                System.out.println("Código: " + resultSet.getString("codigo_servico"));
                                System.out.println("Categoria: " + resultSet.getString("categoria_servico"));
                                System.out.println("Disponibilidade: " + resultSet.getBoolean("disponibilidade_servico"));
                                System.out.println("Duração em Horas: " + resultSet.getDouble("duracao_horas"));
                                System.out.println("Requer Agendamento: " + resultSet.getBoolean("requer_agendamento"));
                            } else {
                                System.out.println("Erro: Nenhum serviço encontrado com o código fornecido.");
                            }
                        } catch (SQLException e) {
                            System.out.println("Erro ao executar a consulta SQL: " + e.getMessage());
                        }
                    } else {
                        System.out.println("Erro ao conectar com o banco de dados");
                    }
                    break;
                
                case 6:
                    System.out.println("Mostrando serviços escolhidos...");
                    if (conn != null) {
                        // Consulta SQL para selecionar os serviços escolhidos pelo usuário
                        String sql = "SELECT * FROM servicos WHERE escolhido = true";
                        try {
                            Statement statement = conn.createStatement();
                            ResultSet resultSet = statement.executeQuery(sql);
                
                            // Exibindo os serviços escolhidos
                            while (resultSet.next()) {
                                System.out.println("Nome: " + resultSet.getString("nome_servico"));
                                System.out.println("Descrição: " + resultSet.getString("descricao_servico"));
                                System.out.println("Preço: " + resultSet.getDouble("preco_servico"));
                                System.out.println("Código: " + resultSet.getString("codigo_servico"));
                                System.out.println("Categoria: " + resultSet.getString("categoria_servico"));
                                System.out.println("Disponibilidade: " + resultSet.getBoolean("disponibilidade_servico"));
                                System.out.println("Duração em Horas: " + resultSet.getDouble("duracao_horas"));
                                System.out.println("Requer Agendamento: " + resultSet.getBoolean("requer_agendamento"));
                                System.out.println("---------------");
                            }
                        } catch (SQLException e) {
                            System.out.println("Erro ao executar a consulta SQL: " + e.getMessage());
                        }
                    } else {
                        System.out.println("Erro ao conectar com o banco de dados");
                    }
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");           
                 
            }
            
        }
    } 
}  

