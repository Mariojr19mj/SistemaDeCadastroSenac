package model; // Define o pacote onde a classe está localizada, neste caso 'model'.
import controller.*; // Importa todas as classes do pacote 'controller'.
import view.InterfaceView; // Importa a classe 'InterfaceView' do pacote 'view'.
import java.sql.*; // Importa classes necessárias para trabalhar com banco de dados SQL, como 'Connection', 'Statement', 'ResultSet', etc.

public class TelaDeCadastroModel { // Define a classe 'TelaDeCadastroModel', que contém o método de cadastro no banco de dados.

    public static void cadastrarModel(String nome, String email, String senha, String img) { // Método estático que realiza o cadastro de um novo usuário no banco de dados, recebendo 'nome', 'email', 'senha' e 'img' como parâmetros.
        try { // Inicia um bloco 'try' para capturar exceções durante a execução do código.
            String strSqlCadastrar = "insert into `db_senac`.`tbl_senac` (`nome`, `email`, `senha`, `img`) values ('" + nome + "','" + email + "','" + senha + "','" + img + "');"; // Define a consulta SQL para inserir um novo registro na tabela 'tbl_senac' com os valores passados como parâmetros.
            Connection conexao = MySQLConnector.conectar(); // Obtém a conexão com o banco de dados usando o método 'conectar' da classe 'MySQLConnector'.
            Statement stmSqlCadastrar = conexao.createStatement(); // Cria uma declaração SQL para executar a consulta de inserção.
            stmSqlCadastrar.addBatch(strSqlCadastrar); // Adiciona a consulta ao lote de comandos SQL.
            stmSqlCadastrar.executeBatch(); // Executa o lote de comandos SQL, inserindo os dados no banco de dados.
            InterfaceView.notificarUsuario("Cadastro realizado com sucesso!", TelaDeAtualizacaoController.lblNotificacoes); // Notifica o usuário de que o cadastro foi realizado com sucesso.
        } catch (Exception e) { // Captura qualquer exceção durante a execução.
            InterfaceView.notificarUsuario("Ops! Ocorreu um problema e não será possível cadastrar nesse momento. Por favor, tente novamente mais tarde.", TelaDeAtualizacaoController.lblNotificacoes); // Notifica o usuário sobre um erro ao tentar cadastrar, caso ocorra uma exceção.
            System.err.println("Erro: " + e); // Exibe o erro no console para depuração.
        }
    }
}
