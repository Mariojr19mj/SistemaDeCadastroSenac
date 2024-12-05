package model; // Define o pacote onde a classe está localizada, neste caso 'model'.
import controller.*; // Importa todas as classes do pacote 'controller', permitindo o uso delas aqui.
import java.nio.file.*; // Importa classes da biblioteca 'java.nio.file' para manipulação de arquivos, como 'Paths' e 'Files'.
import java.sql.*; // Importa classes da biblioteca 'java.sql' para conexão e manipulação de banco de dados.
import java.util.*; // Importa classes da biblioteca 'java.util', como 'ArrayList', para trabalhar com coleções.

public class InterfaceModel { // Define a classe 'InterfaceModel', onde serão implementados os métodos relacionados a operações com imagens.

    public static void validarImagens(ArrayList<String> strImagens) { // Método estático para validar se as imagens existem no banco de dados e deletar as que não existirem.
        for (int i = 0; i < strImagens.size(); i++) { // Inicia um laço que percorre cada imagem na lista 'strImagens'.
            try { // Inicia um bloco try-catch para tratar possíveis exceções durante a execução.
                String imgAtual = strImagens.get(i); // Obtém o nome da imagem atual da lista 'strImagens'.
                String strSqlValidarImagem = "select * from `db_senac`.`tbl_senac` where `img` = '" + imgAtual + "';"; // Cria uma consulta SQL para verificar se a imagem existe no banco de dados.
                Connection conexao = MySQLConnector.conectar(); // Estabelece uma conexão com o banco de dados usando o método 'conectar' da classe 'MySQLConnector'.
                Statement stmSqlValidarImagem = conexao.createStatement(); // Cria um objeto 'Statement' para executar a consulta SQL.
                ResultSet rstSqlValidarImagem = stmSqlValidarImagem.executeQuery(strSqlValidarImagem); // Executa a consulta SQL e armazena o resultado no 'ResultSet'.
                if (!rstSqlValidarImagem.next()) { // Verifica se não há nenhum resultado retornado pela consulta (a imagem não existe no banco).
                    Path pathOrigin = Paths.get(InterfaceController.localViewImgFolder + "\\" + imgAtual); // Cria um objeto 'Path' que representa o caminho do arquivo da imagem a ser deletada.
                    Files.delete(pathOrigin); // Deleta o arquivo da imagem usando o caminho especificado.
                    System.out.println("Arquivo " + imgAtual + " apagado com sucesso!"); // Imprime uma mensagem indicando que a imagem foi deletada com sucesso.
                }
            } catch (Exception e) { // Captura qualquer exceção que ocorra no bloco try.
                System.err.println("Erro: " + e); // Imprime uma mensagem de erro caso ocorra uma exceção.
            }
        }
    }
}
