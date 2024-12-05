package model; // Define o pacote onde a classe está localizada, neste caso 'model'.
import controller.*; // Importa todas as classes do pacote 'controller'.
import view.InterfaceView; // Importa a classe 'InterfaceView' do pacote 'view'.
import java.sql.*; // Importa classes necessárias para trabalhar com banco de dados SQL, como 'Connection', 'Statement', 'ResultSet', etc.
import java.util.*; // Importa classes de coleções, como 'ArrayList'.

public class TelaDeLoginModel { // Define a classe 'TelaDeLoginModel', que contém o método de login.
    public static ArrayList<String> logarModel(String login, String senha) { // Método estático que tenta realizar o login usando o email e a senha fornecidos.
        ArrayList<String> resultados = new ArrayList<String>(); // Cria uma lista para armazenar resultados do login (aqui apenas um marcador de resultado).
        resultados.add("resultado1"); // Adiciona um item de marcador na lista 'resultados' (não está sendo utilizado para verificação real).

        try { // Inicia o bloco 'try' para capturar exceções que possam ocorrer durante a execução.
            Connection conexao = MySQLConnector.conectar(); // Obtém a conexão com o banco de dados chamando o método 'conectar' da classe 'MySQLConnector'.
            // Cria a consulta SQL que busca um registro na tabela 'tbl_senac' onde o email e a senha correspondem aos dados fornecidos.
            String strSqlLogin = "select * from `db_senac`.`tbl_senac` where email = '" + login + "' and senha = '" + senha + "';"; 
            Statement stmSqlLogin = conexao.createStatement(); // Cria um 'Statement' para executar a consulta SQL.
            ResultSet rstSqlLogin = stmSqlLogin.executeQuery(strSqlLogin); // Executa a consulta SQL e armazena o resultado no 'ResultSet'.

            if (rstSqlLogin.next()) { // Verifica se o 'ResultSet' contém algum registro (ou seja, se o login foi bem-sucedido).
                // Notifica o usuário que o login foi realizado com sucesso, usando o 'email' retornado pelo banco.
                InterfaceView.notificarUsuario("Login " + rstSqlLogin.getString("email") + " realizado com sucesso.", TelaDeLoginController.lblNotificacoes); 
                TelaDeLoginController.abrirTelaDeMenu(); // Abre a tela de menu após login bem-sucedido.
                InterfaceView.idLoginAtual = rstSqlLogin.getString("id"); // Armazena o 'id' do usuário logado em uma variável global na classe 'InterfaceView'.
            } else { // Se não encontrar o login e senha no banco de dados.
                InterfaceView.notificarUsuario("Não foi possível encontrar o login e/ou senha digitados. Por favor, verifique e tente novamente.", TelaDeLoginController.lblNotificacoes); // Notifica o usuário sobre erro no login.
            }
            stmSqlLogin.close(); // Fecha o 'Statement' após a execução da consulta.
        } catch (Exception e) { // Captura qualquer exceção que possa ocorrer durante o processo de login.
            // Notifica o usuário de que houve um problema ao tentar fazer login.
            InterfaceView.notificarUsuario("Houve um problema e não será possível realizar o login neste momento. Por favor, tente novamente mais tarde.", TelaDeLoginController.lblNotificacoes); 
            System.err.println("Ops! Deu ruim, se liga no erro: " + e); // Exibe o erro no console para depuração.
        }

        return resultados; // Retorna a lista 'resultados', que contém um marcador (não utilizado na lógica do login).
    }
}
