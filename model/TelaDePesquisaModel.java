package model; // Define o pacote onde a classe está localizada, neste caso 'model'.
import controller.*; // Importa todas as classes do pacote 'controller'.
import view.InterfaceView; // Importa a classe 'InterfaceView' do pacote 'view'.
import java.sql.*; // Importa classes necessárias para trabalhar com banco de dados SQL, como 'Connection', 'Statement', 'ResultSet', etc.

public class TelaDePesquisaModel { // Define a classe 'TelaDePesquisaModel', que contém os métodos para registrar e manipular pesquisas.

    public static void registrarPesquisaModel(String pesquisa) { // Método estático que registra uma pesquisa no banco de dados e configura as cláusulas de pesquisa.
        TelaDePesquisaController.registroDePesquisa = pesquisa; // Armazena o valor da pesquisa na variável 'registroDePesquisa' da classe 'TelaDePesquisaController'.
        
        // Se a pesquisa não for vazia, monta as cláusulas SQL para filtrar os resultados por 'nome' ou 'email'.
        if (TelaDePesquisaController.registroDePesquisa.length() > 0) { 
            TelaDePesquisaController.clausulasDePesquisaComWhere = " where `nome` like '%" + TelaDePesquisaController.registroDePesquisa + "%' or `email` like '%" + TelaDePesquisaController.registroDePesquisa + "%'"; 
            TelaDePesquisaController.clausulasDePesquisaSemWhere = " and (`nome` like '%" + TelaDePesquisaController.registroDePesquisa + "%' or `email` like '%" + TelaDePesquisaController.registroDePesquisa + "%')"; 
        }

        try { // Inicia o bloco 'try' para capturar exceções durante a execução.
            // Cria a consulta SQL para registrar a pesquisa na tabela 'tbl_historico'.
            String strSqlRegistrarHistorico = "insert into `db_senac`.`tbl_historico` (`id_login`, `txt_historico`) values (" + InterfaceView.idLoginAtual + ", '" + pesquisa + "')"; 
            Connection conexao = MySQLConnector.conectar(); // Estabelece a conexão com o banco de dados.
            Statement stmSqlRegistrarHistorico = conexao.createStatement(); // Cria um 'Statement' para executar a consulta SQL.
            stmSqlRegistrarHistorico.addBatch(strSqlRegistrarHistorico); // Adiciona a consulta ao lote de operações.
            stmSqlRegistrarHistorico.executeBatch(); // Executa o lote de operações (neste caso, registra a pesquisa).
        } catch (Exception e) { // Captura qualquer exceção que possa ocorrer durante o processo.
            System.err.println("Erro: " + e); // Exibe o erro no console para depuração.
        }

        TelaDePesquisaController.vaParaPrimeiroRegistro(); // Chama o método para posicionar a pesquisa no primeiro registro.
    }

    public static void inicializacaoDeRegistrosModel() { // Método para inicializar os registros, posicionando o primeiro registro da pesquisa.
        TelaDePesquisaController.vaParaPrimeiroRegistro(); // Chama o método da 'TelaDePesquisaController' para ir para o primeiro registro.
    }

    public static void vaParaPrimeiroRegistroModel() { // Método para ir para o primeiro registro da pesquisa no banco de dados.
        try { // Inicia o bloco 'try' para capturar exceções durante a execução.
            // Cria a consulta SQL para buscar o primeiro registro baseado nas cláusulas de pesquisa.
            String strSqlInicializacao = "select * from `db_senac`.`tbl_senac` " + TelaDePesquisaController.clausulasDePesquisaComWhere + " order by `id` asc;"; 
            Connection conexao = MySQLConnector.conectar(); // Estabelece a conexão com o banco de dados.
            Statement stmSqlInicializacao = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); // Cria um 'Statement' para consulta com suporte à navegação.
            ResultSet rstSqlInicializacao = stmSqlInicializacao.executeQuery(strSqlInicializacao); // Executa a consulta SQL.

            int qtdResultados = 0; // Variável para contar o número de resultados encontrados.
            while (rstSqlInicializacao.next()) { // Itera pelos resultados da consulta.
                qtdResultados++; // Incrementa o contador de resultados.
            }

            if (rstSqlInicializacao.first()) { // Se houver resultados, posiciona o 'ResultSet' no primeiro registro.
                // Atualiza os campos da tela com os dados do primeiro registro.
                TelaDePesquisaController.atualizarCampos(rstSqlInicializacao.getString("id"), rstSqlInicializacao.getString("nome"), rstSqlInicializacao.getString("email"), rstSqlInicializacao.getString("img"));
                // Notifica o usuário sobre o número de registros encontrados e o sucesso na posição do primeiro registro.
                InterfaceView.notificarUsuario("Foram encontrados \"" + qtdResultados + "\" registros. Primeiro registro posicionado com sucesso!", TelaDePesquisaController.lblNotificacoes); 
                TelaDePesquisaController.habilitarAvancar(); // Habilita a navegação para o próximo registro.
            } else { // Se não houver resultados na consulta.
                TelaDePesquisaController.limparCampos(); // Limpa os campos da tela.
                TelaDePesquisaController.desabilitarTodos(); // Desabilita todas as opções de navegação.
                InterfaceView.notificarUsuario("Não foram encontrados registros.", TelaDePesquisaController.lblNotificacoes); // Notifica o usuário de que não há registros.
            }
            stmSqlInicializacao.close(); // Fecha o 'Statement' após a execução da consulta.
        } catch (Exception e) { // Captura qualquer exceção que possa ocorrer durante o processo.
            InterfaceView.notificarUsuario("Ops! Houve um problema no servidor e não será possível inicializar os registros no momento. Por favor, retorne novamente mais tarde.", TelaDePesquisaController.lblNotificacoes); // Notifica o usuário sobre o erro.
            System.err.println("Erro: " + e); // Exibe o erro no console para depuração.
        }
    }

    public static void vaParaProximoRegistroModel(String id) { // Método para ir para o próximo registro, dado um 'id' de registro atual.
        try { // Inicia o bloco 'try' para capturar exceções durante a execução.
            // Cria a consulta SQL para buscar o próximo registro baseado no 'id' atual e nas cláusulas de pesquisa.
            String strSqlProximoRegistro = "select * from `db_senac`.`tbl_senac` where `id` > " + id + TelaDePesquisaController.clausulasDePesquisaSemWhere + " order by `id` asc;"; 
            Connection conexao = MySQLConnector.conectar(); // Estabelece a conexão com o banco de dados.
            Statement stmSqlProximoRegistro = conexao.createStatement(); // Cria um 'Statement' para executar a consulta SQL.
            ResultSet rstSqlProximoRegistro = stmSqlProximoRegistro.executeQuery(strSqlProximoRegistro); // Executa a consulta SQL.
            if (rstSqlProximoRegistro.next()) { // Se encontrar um próximo registro.
                // Atualiza os campos da tela com os dados do próximo registro.
                TelaDePesquisaController.atualizarCampos(rstSqlProximoRegistro.getString("id"), rstSqlProximoRegistro.getString("nome"), rstSqlProximoRegistro.getString("email"), rstSqlProximoRegistro.getString("img"));
                InterfaceView.notificarUsuario("Próximo registro posicionado com sucesso!", TelaDePesquisaController.lblNotificacoes); // Notifica o usuário do sucesso na navegação.
                TelaDePesquisaController.habilitarTodos(); // Habilita todas as opções de navegação.
            } else { // Se não encontrar mais registros adiante.
                TelaDePesquisaController.habilitarVoltar(); // Habilita a navegação para o registro anterior.
                InterfaceView.notificarUsuario("Não foram encontrados registros adiante.", TelaDePesquisaController.lblNotificacoes); // Notifica o usuário que não há mais registros.
            }
            stmSqlProximoRegistro.close(); // Fecha o 'Statement' após a execução da consulta.
        } catch (Exception e) { // Captura qualquer exceção que possa ocorrer durante o processo.
            InterfaceView.notificarUsuario("Ops! Houve um problema no servidor e não será possível inicializar os registros no momento. Por favor, retorne novamente mais tarde.", TelaDePesquisaController.lblNotificacoes); // Notifica o usuário sobre o erro.
            System.err.println("Erro: " + e); // Exibe o erro no console para depuração.
        }
    }

    public static void vaParaUltimoRegistroModel() { // Método para ir para o último registro da pesquisa.
        try { // Inicia o bloco 'try' para capturar exceções durante a execução.
            // Cria a consulta SQL para buscar o último registro, ordenado de forma decrescente.
            String strSqlUltimoRegistro = "select * from `db_senac`.`tbl_senac` " + TelaDePesquisaController.clausulasDePesquisaComWhere + " order by `id` desc;"; 
            Connection conexao = MySQLConnector.conectar(); // Estabelece a conexão com o banco de dados.
            Statement stmSqlUltimoRegistro = conexao.createStatement(); // Cria um 'Statement' para executar a consulta SQL.
            ResultSet rstSqlUltimoRegistro = stmSqlUltimoRegistro.executeQuery(strSqlUltimoRegistro); // Executa a consulta SQL.
            if (rstSqlUltimoRegistro.next()) { // Se encontrar o último registro.
                // Atualiza os campos da tela com os dados do último registro.
                TelaDePesquisaController.atualizarCampos(rstSqlUltimoRegistro.getString("id"), rstSqlUltimoRegistro.getString("nome"), rstSqlUltimoRegistro.getString("email"), rstSqlUltimoRegistro.getString("img"));
                InterfaceView.notificarUsuario("Último registro posicionado com sucesso!", TelaDePesquisaController.lblNotificacoes); // Notifica o usuário do sucesso na navegação.
                TelaDePesquisaController.habilitarVoltar(); // Habilita a navegação para o registro anterior.
            } else { // Se não houver resultados.
                InterfaceView.notificarUsuario("Não foram encontrados registros.", TelaDePesquisaController.lblNotificacoes); // Notifica o usuário que não há registros.
            }
            stmSqlUltimoRegistro.close(); // Fecha o 'Statement' após a execução da consulta.
        } catch (Exception e) { // Captura qualquer exceção que possa ocorrer durante o processo.
            InterfaceView.notificarUsuario("Ops! Houve um problema no servidor e não será possível inicializar os registros no momento. Por favor, retorne novamente mais tarde.", TelaDePesquisaController.lblNotificacoes); // Notifica o usuário sobre o erro.
            System.err.println("Erro: " + e); // Exibe o erro no console para depuração.
        }
    }

    public static void vaParaRegistroAnteriorModel(String id) { // Método para ir para o registro anterior, dado um 'id' de registro atual.
        try { // Inicia o bloco 'try' para capturar exceções durante a execução.
            // Cria a consulta SQL para buscar o registro anterior baseado no 'id' atual e nas cláusulas de pesquisa.
            String strSqlRegistroAnterior = "select * from `db_senac`.`tbl_senac` where `id` < " + id + TelaDePesquisaController.clausulasDePesquisaSemWhere + " order by `id` desc;"; 
            Connection conexao = MySQLConnector.conectar(); // Estabelece a conexão com o banco de dados.
            Statement stmSqlRegistroAnterior = conexao.createStatement(); // Cria um 'Statement' para executar a consulta SQL.
            ResultSet rstSqlRegistroAnterior = stmSqlRegistroAnterior.executeQuery(strSqlRegistroAnterior); // Executa a consulta SQL.
            if (rstSqlRegistroAnterior.next()) { // Se encontrar um registro anterior.
                // Atualiza os campos da tela com os dados do registro anterior.
                TelaDePesquisaController.atualizarCampos(rstSqlRegistroAnterior.getString("id"), rstSqlRegistroAnterior.getString("nome"), rstSqlRegistroAnterior.getString("email"), rstSqlRegistroAnterior.getString("img"));
                InterfaceView.notificarUsuario("Registro anterior posicionado com sucesso!", TelaDePesquisaController.lblNotificacoes); // Notifica o usuário do sucesso na navegação.
                TelaDePesquisaController.habilitarTodos(); // Habilita todas as opções de navegação.
            } else { // Se não encontrar um registro anterior.
                TelaDePesquisaController.habilitarAvancar(); // Habilita a navegação para o próximo registro.
                InterfaceView.notificarUsuario("Não foram encontrados registros anteriores.", TelaDePesquisaController.lblNotificacoes); // Notifica o usuário que não há registros anteriores.
            }
            stmSqlRegistroAnterior.close(); // Fecha o 'Statement' após a execução da consulta.
        } catch (Exception e) { // Captura qualquer exceção que possa ocorrer durante o processo.
            InterfaceView.notificarUsuario("Ops! Houve um problema no servidor e não será possível inicializar os registros no momento. Por favor, retorne novamente mais tarde.", TelaDePesquisaController.lblNotificacoes); // Notifica o usuário sobre o erro.
            System.err.println("Erro: " + e); // Exibe o erro no console para depuração.
        }
    }
}
