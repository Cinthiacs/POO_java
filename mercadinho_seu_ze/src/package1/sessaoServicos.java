package package1;
import package1.Servico;
import package1.Conn;
import package1.Item;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Locale;
import package1.Conn;
import java.sql.SQLException;
import java.sql.ResultSet;

public class sessaoServicos {
    private Connection conn;

    public void cadastrar_servico(Connection conn) throws SQLException {
        this.conn = conn;

        Scanner entrada_usu = new Scanner(System.in).useLocale(Locale.US);

        System.out.println("*Cadastro de Produtos Mercado seu Zé!*");
        while (true) {

            System.out.println("Escolha uma sessão: ");
            System.out.println(" 0 - Para sair do programa");
            System.out.println(" 1 - Para Cadastrar Servicos");
            System.out.println(" 2 - Para Imprimir Servicos");
            System.out.println(" 3 - Para Atualizar Servicos");
            System.out.println(" 4 - Para Deletar Servicos");

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
                    System.out.println("Insira nome do Servico: ");
                    String nome = entrada_usu.nextLine();
                    System.out.println("Insira a descrição do Serviço: ");
                    String descricao = entrada_usu.nextLine();

                    System.out.println("Digite o preço do Serviço: ");
                    Double preco = entrada_usu.nextDouble();

                    System.out.println("Insira o código do Serviço: ");
                    entrada_usu.nextLine(); // Consumindo a quebra de linha pendente
                    String codigo = entrada_usu.nextLine();

                    System.out.println("Insira a categoria do Serviço: ");
                    String categoria = entrada_usu.nextLine();

                    System.out.println("O Serviço está disponível? (s/n)");
                    String disponivelStr = entrada_usu.nextLine();
                    boolean disponivel = disponivelStr.equalsIgnoreCase("s");

                    System.out.println("Digite a duração em horas do Serviço: ");
                    double duracao_horas = entrada_usu.nextDouble();

                    System.out.println("O Serviço requer agendamento? (s/n)");
                    entrada_usu.nextLine(); 
                    String requer_agendamento = entrada_usu.nextLine();
                    while (!requer_agendamento.equalsIgnoreCase("s") && !requer_agendamento.equalsIgnoreCase("n")) {
                        System.out.println("Opcao invalida");
                        requer_agendamento = entrada_usu.nextLine();
                    }

                    if (conn != null) {
                        String sql = "INSERT INTO servicos (nome_servico, descricao_servico, preco_servico, codigo_servico, categoria_servico, disponibilidade_servico, duracao_horas, requer_agendamento) VALUES ('" 
                                    + nome + "', '" + descricao + "', " + preco + ", '" + codigo + "', '" + categoria + "', " + disponivel + ", " + duracao_horas + ", '" + requer_agendamento + "')";

                        Statement statement = conn.createStatement();
                        int rows = statement.executeUpdate(sql);

                        if (rows > 0) {
                            System.out.println("Um novo cadastro foi inserido com sucesso");
                        }
                    } else {
                        System.out.println("Erro: Nome do Serviço, tipo ou preço não podem estar vazios");
                    }
                    break;

                case 2:
                    if (conn != null) {
                        String sql = "SELECT * FROM servicos";
                        Statement statement = conn.createStatement();
                        ResultSet resultSet = statement.executeQuery(sql);

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
                    } else {
                        System.out.println("Erro ao conectar com o banco de dados");
                    }
                    break;

                case 3:
                    System.out.println("Digite o código do serviço a ser atualizado: ");
                    String codigoAtualizar = entrada_usu.nextLine();

                    System.out.println("Insira novo nome do serviço: ");
                    String novoNome = entrada_usu.nextLine();

                    System.out.println("Insira nova descrição do serviço: ");
                    String novaDescricao = entrada_usu.nextLine();

                    System.out.println("Digite novo preço do serviço: ");
                    Double novoPreco = entrada_usu.nextDouble();

                    System.out.println("Insira nova categoria do serviço: ");
                    entrada_usu.nextLine(); // Consumindo a quebra de linha pendente
                    String novaCategoria = entrada_usu.nextLine();

                    System.out.println("O serviço está disponível? (s/n)");
                    String novaDisponibilidadeStr = entrada_usu.nextLine();
                    boolean novaDisponibilidade = novaDisponibilidadeStr.equalsIgnoreCase("s");

                    System.out.println("Digite a nova duração em horas do serviço: ");
                    double novaDuracaoHoras = entrada_usu.nextDouble();

                    System.out.println("O serviço requer agendamento? (s/n)");
                    entrada_usu.nextLine(); // Consumindo a quebra de linha pendente
                    String novoRequerAgendamentoStr = entrada_usu.nextLine();
                    boolean novoRequerAgendamento = novoRequerAgendamentoStr.equalsIgnoreCase("s");

                    if (conn != null) {
                        String sql = "UPDATE servicos SET nome_servico = '" + novoNome + "', descricao_servico = '" + novaDescricao 
                                    + "', preco_servico = " + novoPreco + ", categoria_servico = '" + novaCategoria 
                                    + "', disponibilidade_servico = " + novaDisponibilidade + ", duracao_horas = " + novaDuracaoHoras 
                                    + ", requer_agendamento = " + novoRequerAgendamento + " WHERE codigo_servico = '" + codigoAtualizar + "'";

                        Statement statement = conn.createStatement();
                        int rows = statement.executeUpdate(sql);

                        if (rows > 0) {
                            System.out.println("Serviço atualizado com sucesso");
                        } else {
                            System.out.println("Erro: Nenhum serviço encontrado com o código fornecido");
                        }
                    } else {
                        System.out.println("Erro ao conectar com o banco de dados");
                    }
                    break;

                case 4:
                    // Implementação para deletar serviços
                    System.out.println("Digite o código do serviço a ser deletado: ");
                    String codigoDeletar = entrada_usu.nextLine();

                    if (conn != null) {
                        String sql = "DELETE FROM servicos WHERE codigo_servico = '" + codigoDeletar + "'";

                        Statement statement = conn.createStatement();
                        int rows = statement.executeUpdate(sql);

                        if (rows > 0) {
                            System.out.println("Serviço deletado com sucesso");
                        } else {
                            System.out.println("Erro: Nenhum serviço encontrado com o código fornecido");
                        }
                    } else {
                        System.out.println("Erro ao conectar com o banco de dados");
                    }
                    break;
            }
        }
    }
}
