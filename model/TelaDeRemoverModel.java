package model; // Define o pacote onde a classe está localizada, neste caso 'model'.
import controller.*; // Importa todas as classes do pacote 'controller'.
import view.InterfaceView; // Importa a classe 'InterfaceView' do pacote 'view'.

import java.sql.*; // Importa classes necessárias para trabalhar com banco de dados SQL, como 'Connection', 'Statement', 'ResultSet', etc.

public class TelaDeRemoverModel { // Define a classe 'TelaDeRemoverModel', que contém métodos relacionados à remoção de dados.

    public static void removerModel(String id) { // Método estático que remove um registro baseado no 'id' fornecido.
        try { // Inicia o bloco 'try' para capturar exceções durante a execução.
            Connection conexao = MySQLConnector.conectar(); // Estabelece a conexão com o banco de dados.
            String strSqlRemoverId = "delete from `db_senac`.`tbl_senac` where `id` = " + id + ";"; // Cria a consulta SQL para remover o registro com o 'id' especificado.
            Statement stmSqlRemoverId = conexao.createStatement(); // Cria um 'Statement' para executar a consulta SQL.
            stmSqlRemoverId.addBatch(strSqlRemoverId); // Adiciona a consulta ao lote de operações.
            stmSqlRemoverId.executeBatch(); // Executa o lote de operações, removendo o registro.
            InterfaceView.notificarUsuario("O id " + id + " foi removido com sucesso.", TelaDeRemoverController.lblNotificacoes); // Notifica o usuário sobre a remoção do registro.
        } catch (Exception e) { // Captura qualquer exceção que possa ocorrer durante o processo.
            InterfaceView.notificarUsuario("Ops! Problema no servidor, tente novamente mais tarde.", TelaDeRemoverController.lblNotificacoes); // Notifica o usuário sobre o erro.
            System.err.println("Erro: " + e); // Exibe o erro no console para depuração.
        }
    }

    public static void popularCbxIdModel() { // Método estático que preenche o ComboBox com os 'id's de registros existentes.
        try { // Inicia o bloco 'try' para capturar exceções durante a execução.
            Connection conexao = MySQLConnector.conectar(); // Estabelece a conexão com o banco de dados.
            String strSqlPopularCbxId = "select * from `db_senac`.`tbl_senac` order by `id` asc;"; // Cria a consulta SQL para buscar todos os 'id's na tabela.
            Statement stmSqlPopularCbxId = conexao.createStatement(); // Cria um 'Statement' para executar a consulta SQL.
            ResultSet rstSqlPopularCbxId = stmSqlPopularCbxId.executeQuery(strSqlPopularCbxId); // Executa a consulta SQL.
            while (rstSqlPopularCbxId.next()) { // Itera pelos resultados da consulta.
                TelaDeRemoverController.adicionarItemCbxId(rstSqlPopularCbxId.getString("id")); // Adiciona o 'id' ao ComboBox.
            }
            stmSqlPopularCbxId.close(); // Fecha o 'Statement' após a execução da consulta.
        } catch (Exception e) { // Captura qualquer exceção que possa ocorrer durante o processo.
            InterfaceView.notificarUsuario("Ops! Ocorreu um problema no servidor e não será possível carregar os ids neste momento. Por favor, retorne novamente mais tarde.", TelaDeRemoverController.lblNotificacoes); // Notifica o usuário sobre o erro.
            System.err.println("Erro: " + e); // Exibe o erro no console para depuração.
        }
    }

    public static void atualizarCamposModel(String strId) { // Método estático que atualiza os campos da tela com os dados do registro com o 'id' fornecido.
        try { // Inicia o bloco 'try' para capturar exceções durante o processo.
            Connection conexao = MySQLConnector.conectar(); // Estabelece a conexão com o banco de dados.
            String strSqlAtualizarCampos = "select * from `db_senac`.`tbl_senac` where id = " + strId + ";"; // Cria a consulta SQL para buscar o registro com o 'id' fornecido.
            Statement stmSqlAtualizarCampos = conexao.createStatement(); // Cria um 'Statement' para executar a consulta SQL.
            ResultSet rstSqlAtualizarCampos = stmSqlAtualizarCampos.executeQuery(strSqlAtualizarCampos); // Executa a consulta SQL.
            if (rstSqlAtualizarCampos.next()) { // Se encontrar o registro com o 'id' especificado.
                TelaDeRemoverController.preencherCampos(rstSqlAtualizarCampos.getString("nome"), rstSqlAtualizarCampos.getString("email"), rstSqlAtualizarCampos.getString("img")); // Preenche os campos da tela com os dados do registro.
            } else { // Se não encontrar o registro.
                InterfaceView.notificarUsuario("Id não encontrado.", TelaDeRemoverController.lblNotificacoes); // Notifica o usuário que o 'id' não foi encontrado.
            }
        } catch (Exception e) { // Captura qualquer exceção que possa ocorrer durante o processo.
            InterfaceView.notificarUsuario("Ops! Problema no servidor. Tente novamente mais tarde.", TelaDeRemoverController.lblNotificacoes); // Notifica o usuário sobre o erro.
            System.err.println("Erro: " + e); // Exibe o erro no console para depuração.
        }
    }
}
