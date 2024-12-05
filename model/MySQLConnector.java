package model; // Define o pacote onde a classe está localizada, neste caso 'model'.
import java.sql.*; // Importa as classes necessárias para trabalhar com banco de dados SQL, como 'Connection', 'DriverManager', etc.
public class MySQLConnector { // Define a classe 'MySQLConnector' responsável por gerenciar a conexão com o banco de dados MySQL.

    public static Connection conectar() { // Método estático que retorna uma conexão com o banco de dados MySQL.
        String mysqlHost = "127.0.0.1"; // Define o endereço IP do servidor MySQL (localhost, neste caso).
        String mysqlDb = "db_senac"; // Define o nome do banco de dados a ser utilizado.
        String mysqlUser = "root"; // Define o nome de usuário para a conexão com o banco de dados.
        String mysqlPassword = "senac@02"; // Define a senha para a conexão com o banco de dados.
        String mysqlPort = "3306"; // Define a porta de conexão do MySQL (padrão 3306).
        String mysqlUrl = "jdbc:mysql://" + mysqlHost + ":" + mysqlPort + "/" + mysqlDb + "?user=" + mysqlUser + "&password=" + mysqlPassword; // Cria a URL de conexão usando os parâmetros fornecidos.
        Connection conn = null; // Declara a variável 'conn' que armazenará a conexão com o banco de dados, inicialmente definida como nula.
        
        try { // Inicia um bloco 'try' para capturar exceções durante a execução do código.
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance(); // Carrega o driver JDBC do MySQL dinamicamente.
            conn = DriverManager.getConnection(mysqlUrl); // Estabelece a conexão com o banco de dados usando a URL criada e a classe 'DriverManager'.
            // System.out.println("Conexão realizada com sucesso!"); // Comentado: imprime uma mensagem caso a conexão seja bem-sucedida.
        } catch (Exception e) { // Captura qualquer exceção que ocorrer durante a tentativa de conexão.
            System.err.println("Ops! Algo de errado não está certo com a conexão com o banco de dados MySQL! Mensagem do servidor: " + e); // Exibe a mensagem de erro caso a conexão falhe.
        }
        
        return conn; // Retorna a conexão estabelecida, ou null caso ocorra algum erro durante a tentativa de conexão.
    }
}

