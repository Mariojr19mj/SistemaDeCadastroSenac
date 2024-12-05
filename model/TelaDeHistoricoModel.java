package model; // Define o pacote onde a classe está localizada, neste caso 'model'.
import view.InterfaceView; // Importa a classe 'InterfaceView' do pacote 'view'.
import java.util.*; // Importa classes da coleção 'java.util', como 'ArrayList'.
import java.sql.*; // Importa classes necessárias para trabalhar com banco de dados SQL, como 'Connection', 'Statement', 'ResultSet', etc.

public class TelaDeHistoricoModel { // Define a classe 'TelaDeHistoricoModel', que contém o método para capturar histórico do banco de dados.
    public static String[] capturarHistorico() { // Método estático que captura o histórico de um usuário com base no 'id_login' atual.
        ArrayList<String> strHistoricos = new ArrayList<String>(); // Cria uma lista dinâmica (ArrayList) para armazenar os históricos recuperados do banco de dados.
        try { // Inicia um bloco 'try' para capturar exceções durante a execução do código.
            // Define a consulta SQL que seleciona os históricos da tabela 'tbl_historico' onde 'id_login' é igual ao valor de 'idLoginAtual' da classe 'InterfaceView'.
            String strSqlCapturarHistorico = "select * from `db_senac`.`tbl_historico` where `id_login` = " + InterfaceView.idLoginAtual + ";"; 
            
            Connection conexao = MySQLConnector.conectar(); // Obtém a conexão com o banco de dados usando o método 'conectar' da classe 'MySQLConnector'.
            Statement stmCapturarHistorico = conexao.createStatement(); // Cria uma declaração SQL para executar a consulta de captura de históricos.
            ResultSet rstCapturarHistorico = stmCapturarHistorico.executeQuery(strSqlCapturarHistorico); // Executa a consulta SQL e armazena o resultado no 'ResultSet'.

            while (rstCapturarHistorico.next()) { // Enquanto houver registros no 'ResultSet', executa o código dentro do laço.
                strHistoricos.add(rstCapturarHistorico.getString("txt_historico")); // Adiciona o valor do campo 'txt_historico' à lista 'strHistoricos'.
            }
        } catch (Exception e) { // Captura qualquer exceção durante a execução.
            System.err.println("Erro: " + e); // Exibe o erro no console para depuração.
        }
        return strHistoricos.toArray(new String[0]); // Converte a lista 'strHistoricos' para um array de Strings e retorna.
    }
}
