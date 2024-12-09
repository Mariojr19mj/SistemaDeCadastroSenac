package model; // Define o pacote model, onde a classe TelaDeCadastroModel está localizada
import controller.*; // Importa todas as classes do pacote controller
import view.InterfaceView; // Importa a classe InterfaceView do pacote view

import java.sql.*; // Importa as classes necessárias para o trabalho com SQL (conexões, consultas, etc)

public class TelaDeCadastroModel { // Definindo a classe TelaDeCadastroModel que contém a lógica do modelo de cadastro
    public static void cadastrarModel(String nome, String email, String senha, String img) { // Método estático que recebe dados para cadastrar um novo usuário
        try {
            // Criação da string SQL para inserir um novo registro no banco de dados
            String strSqlCadastrar = "insert into `db_senac`.`tbl_senac` (`nome`, `email`, `senha`, `img`) values ('" + nome + "','" + email + "','" + senha + "','" + img + "');";
            // Estabelece uma conexão com o banco de dados utilizando o MySQLConnector
            Connection conexao = MySQLConnector.conectar();
            // Cria um Statement para executar a consulta SQL no banco de dados
            Statement stmSqlCadastrar = conexao.createStatement();
            // Adiciona a consulta SQL ao batch de comandos do Statement
            stmSqlCadastrar.addBatch(strSqlCadastrar);
            // Executa o batch de comandos SQL
            stmSqlCadastrar.executeBatch();
            // Notifica o usuário que o cadastro foi realizado com sucesso utilizando a interface gráfica
            InterfaceView.notificarUsuario("Cadastro realizado com sucesso!", TelaDeCadastroController.lblNotificacoes);
        } catch (Exception e) { // Caso ocorra um erro, entra no bloco catch
            // Notifica o usuário que ocorreu um erro e que o cadastro não foi realizado
            InterfaceView.notificarUsuario("Ops! Ocorrou um problema e não será possível cadastrar nesse momento. Por favor, tente novamente mais tarde.", TelaDeCadastroController.lblNotificacoes);
            // Imprime o erro no console para análise
            System.err.println("Erro: " + e);
        }
    }
}
