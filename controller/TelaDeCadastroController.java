package controller; // Define o pacote onde a classe está localizada, neste caso 'controller'
import view.*; // Importa todas as classes do pacote 'view', permitindo o uso delas aqui.
import model.*; // Importa todas as classes do pacote 'model', permitindo o uso delas aqui.
import static java.nio.file.StandardCopyOption.*; // Importa opções de cópia de arquivos, como 'REPLACE_EXISTING', para usá-las em operações de cópia de arquivos.
import java.nio.file.*; // Importa classes de manipulação de arquivos e caminhos, como Path e Files.
import javax.swing.*; // Importa classes para criar interfaces gráficas, como JFileChooser, ImageIcon, etc.
import java.awt.*; // Importa classes para manipulação de imagens e elementos gráficos.

public class TelaDeCadastroController extends TelaDeCadastroView { // Define a classe 'TelaDeCadastroController', que herda de 'TelaDeCadastroView'.
    public static void cadastrarController() { // Método estático responsável por chamar o modelo para cadastrar os dados inseridos na interface gráfica.
        TelaDeCadastroModel.cadastrarModel(txtNome.getText(), txtEmail.getText(), String.valueOf(txtSenha.getPassword()), nomeArquivoFoto); // Chama o método 'cadastrarModel' de 'TelaDeCadastroModel' e envia os dados inseridos.
    }

    public static void carregarFoto() { // Método estático que permite ao usuário carregar uma foto e copiá-la para um diretório.
        try { // Tenta executar o código dentro do bloco 'try', tratando possíveis exceções.
            JFileChooser chooser = new JFileChooser(); // Cria um novo objeto JFileChooser para permitir ao usuário escolher um arquivo de imagem.
            chooser.setDialogTitle("Selecione o arquivo que deseja copiar"); // Define o título da caixa de diálogo do JFileChooser.
            chooser.setApproveButtonText("Copiar arquivo"); // Define o texto do botão de aprovação da caixa de diálogo para "Copiar arquivo".
            int returnVal = chooser.showOpenDialog(null); // Exibe a caixa de diálogo para o usuário escolher um arquivo e armazena a resposta.
            String fileFullPath = ""; // Variável para armazenar o caminho completo do arquivo selecionado.
            String fileName = ""; // Variável para armazenar o nome do arquivo selecionado.
            if(returnVal == JFileChooser.APPROVE_OPTION) { // Se o usuário clicou em "OK" para selecionar um arquivo.
                fileFullPath = chooser.getSelectedFile().getAbsolutePath(); // Obtém o caminho completo do arquivo selecionado.
                fileName = "file-" + Math.random() + "-" + chooser.getSelectedFile().getName(); // Gera um novo nome para o arquivo, adicionando um identificador aleatório.
            } else { // Se o usuário clicou em "Cancelar", imprime uma mensagem informando que o arquivo não foi selecionado.
                System.out.println("Usuário não selecionou o arquivo para copiar...");
            }

            Path pathOrigin = Paths.get(fileFullPath); // Cria um objeto Path representando o caminho do arquivo de origem.
            Path pathDestination = Paths.get(InterfaceView.localViewImgFolder + "\\" + fileName); // Cria um objeto Path representando o caminho de destino onde a foto será salva.
            if (fileFullPath.length() > 0) { // Verifica se o caminho do arquivo não está vazio.
                Files.copy(pathOrigin, pathDestination, REPLACE_EXISTING); // Copia o arquivo da origem para o destino, substituindo arquivos existentes no destino.
                System.out.println("Arquivo " + chooser.getSelectedFile().getName() + " copiado/colado com sucesso."); // Informa que o arquivo foi copiado com sucesso.
            } else { // Se o caminho do arquivo estiver vazio, imprime uma mensagem de erro.
                System.out.println("Ops! Não foi possível copiar o arquivo. Por favor, verifique e tente novamente mais tarde.");
            }

            nomeArquivoFoto = fileName; // Atualiza a variável 'nomeArquivoFoto' com o nome do arquivo copiado.
            lblFoto.setIcon(new ImageIcon(new ImageIcon(InterfaceView.localViewImgFolder + "\\" + nomeArquivoFoto).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT))); // Atualiza o ícone da label 'lblFoto' com a foto carregada e redimensionada.
        } catch (Exception e) { // Se ocorrer uma exceção (erro) durante o processo de carregar a foto, imprime uma mensagem de erro.
            System.out.println("Não foi possível copiar o arquivo.");
        }
    }

    public static void removerFoto() { // Método estático que remove a foto carregada e define uma imagem padrão.
        lblFoto.setIcon(new ImageIcon(new ImageIcon(InterfaceView.localViewFolder + "\\imagem-padrao.jpg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT))); // Define o ícone da label 'lblFoto' com a imagem padrão.
        nomeArquivoFoto = ""; // Limpa a variável 'nomeArquivoFoto', indicando que não há foto carregada.
    }
}
