package model; // Define o pacote onde a classe está localizada, neste caso 'model'.
import controller.*; // Importa todas as classes do pacote 'controller'.
import view.InterfaceView; // Importa a classe 'InterfaceView' do pacote 'view'.
import java.sql.*; // Importa classes necessárias para trabalhar com banco de dados SQL, como 'Connection', 'Statement', 'ResultSet', etc.
import java.util.*; // Importa a classe 'ArrayList' e outras utilitárias da biblioteca 'java.util'.

public class TelaDeAtualizacaoModel { // Define a classe 'TelaDeAtualizacaoModel', que contém métodos para manipular dados na tela de atualização.

    public static ArrayList<String> popularCbxIdModel() { // Método estático que retorna uma lista de IDs para popular o combobox na tela de atualização.
        ArrayList<String> ids = new ArrayList<String>(); // Cria uma nova lista de strings para armazenar os IDs.
        try { // Inicia um bloco 'try' para capturar exceções durante a execução do código.
            Connection conexao = MySQLConnector.conectar(); // Obtém a conexão com o banco de dados usando o método 'conectar' da classe 'MySQLConnector'.
            String strSqlPopularCbxId = "select * from `db_senac`.`tbl_senac` order by `id` asc;"; // Define a consulta SQL para selecionar todos os registros da tabela 'tbl_senac' ordenados pelo ID.
            Statement stmSqlPopularCbxId = conexao.createStatement(); // Cria uma declaração SQL para executar a consulta.
            ResultSet rstSqlPopularCbxId = stmSqlPopularCbxId.executeQuery(strSqlPopularCbxId); // Executa a consulta e armazena o resultado.
            while (rstSqlPopularCbxId.next()) { // Itera sobre os resultados da consulta.
                ids.add(rstSqlPopularCbxId.getString("id")); // Adiciona o ID encontrado no resultado à lista de IDs.
            }
            stmSqlPopularCbxId.close(); // Fecha a declaração SQL após a execução.
        } catch (Exception e) { // Captura qualquer exceção durante a execução.
            InterfaceView.notificarUsuario("Ops! Ocorreu um problema no servidor e não será possível carregar os ids neste momento. Por favor, retorne novamente mais tarde.", TelaDeAtualizacaoController.lblNotificacoes); // Notifica o usuário sobre o erro.
            System.err.println("Erro: " + e); // Exibe o erro no console.
        }
        return ids; // Retorna a lista de IDs.
    }

    public static ArrayList<String> atualizarCamposModel(String strId) { // Método estático que retorna os dados de um registro com base no ID fornecido.
        ArrayList<String> dados = new ArrayList<String>(); // Cria uma nova lista de strings para armazenar os dados do registro.
        try { // Inicia um bloco 'try' para capturar exceções durante a execução do código.
            Connection conexao = MySQLConnector.conectar(); // Obtém a conexão com o banco de dados.
            String strSqlAtualizarCampos = "select * from `db_senac`.`tbl_senac` where id = " + strId + ";"; // Define a consulta SQL para selecionar os dados de um registro específico pelo ID.
            Statement stmSqlAtualizarCampos = conexao.createStatement(); // Cria uma declaração SQL para executar a consulta.
            ResultSet rstSqlAtualizarCampos = stmSqlAtualizarCampos.executeQuery(strSqlAtualizarCampos); // Executa a consulta e armazena o resultado.
            if (rstSqlAtualizarCampos.next()) { // Se um registro for encontrado com o ID fornecido.
                dados.add(rstSqlAtualizarCampos.getString("nome")); // Adiciona o nome do registro à lista de dados.
                TelaDeAtualizacaoController.txtNomeCarregado = rstSqlAtualizarCampos.getString("nome"); // Armazena o nome do registro no controlador.
                dados.add(rstSqlAtualizarCampos.getString("email")); // Adiciona o email do registro à lista de dados.
                dados.add(rstSqlAtualizarCampos.getString("img")); // Adiciona o nome da imagem do registro à lista de dados.
                TelaDeAtualizacaoController.txtEmailCarregado = rstSqlAtualizarCampos.getString("email"); // Armazena o email do registro no controlador.
                // txtSenha.setText(""); // Comentado: código para limpar o campo de senha, se necessário.
            } else { // Se o registro não for encontrado.
                InterfaceView.notificarUsuario("Id não encontrado.", TelaDeAtualizacaoController.lblNotificacoes); // Notifica o usuário que o ID não foi encontrado.
            }
        } catch (Exception e) { // Captura qualquer exceção durante a execução.
            InterfaceView.notificarUsuario("Ops! Problema no servidor. Tente novamente mais tarde.", TelaDeAtualizacaoController.lblNotificacoes); // Notifica o usuário sobre o erro no servidor.
            System.err.println("Erro: " + e); // Exibe o erro no console.
        }
        return dados; // Retorna a lista de dados.
    }

    public static boolean atualizarModel(String id, String nome, String email, String senha, String img) { // Método estático que atualiza os dados de um registro no banco de dados.
        boolean atualizou = false; // Inicializa a variável 'atualizou' como falso, indicando que a atualização não foi realizada.
        try { // Inicia um bloco 'try' para capturar exceções durante a execução do código.
            Connection conexao = MySQLConnector.conectar(); // Obtém a conexão com o banco de dados.
            String atualizarSenha = ""; // Inicializa a variável 'atualizarSenha' como uma string vazia.
            if (senha.length() > 0) { // Se a senha não for vazia.
                atualizarSenha = ", `senha` = '" + senha + "'"; // Adiciona a cláusula para atualizar a senha no SQL.
            }
            String strSqlAtualizarId = "update `db_senac`.`tbl_senac` set `nome` = '" + nome + "', `email` = '" + email + "'" + atualizarSenha + ", `img` = '" + img + "' where `id` = " + id + ";"; // Define a consulta SQL para atualizar os dados do registro com o ID fornecido.
            Statement stmSqlAtualizarId = conexao.createStatement(); // Cria uma declaração SQL para executar a consulta de atualização.
            stmSqlAtualizarId.addBatch(strSqlAtualizarId); // Adiciona a consulta ao lote de comandos a serem executados.
            stmSqlAtualizarId.executeBatch(); // Executa o lote de comandos.
            atualizou = true; // Define a variável 'atualizou' como verdadeiro, indicando que a atualização foi bem-sucedida.
            InterfaceView.notificarUsuario("O id " + id + " foi atualizado com sucesso.", TelaDeAtualizacaoController.lblNotificacoes); // Notifica o usuário que o registro foi atualizado com sucesso.
        } catch (Exception e) { // Captura qualquer exceção durante a execução.
            InterfaceView.notificarUsuario("Ops! Problema no servidor, tente novamente mais tarde.", TelaDeAtualizacaoController.lblNotificacoes); // Notifica o usuário sobre o erro no servidor.
            System.err.println("Erro: " + e); // Exibe o erro no console.
        }
        return atualizou; // Retorna verdadeiro se a atualização foi realizada, ou falso caso contrário.
    }
}
