package controller; // Pacote para organizar as classes dentro da estrutura do projeto
import view.*; // Importação de todas as classes do pacote view
import model.*; // Importação de todas as classes do pacote model

import static java.nio.file.StandardCopyOption.*; // Importação para usar as opções de cópia de arquivos de java.nio
import java.nio.file.*; // Importação de classes relacionadas a manipulação de caminhos e arquivos

import javax.imageio.*; // Importação para trabalhar com leitura e escrita de imagens
import javax.swing.*; // Importação de componentes gráficos Swing (como JButton, JLabel, etc)
import java.awt.*; // Importação das classes gráficas gerais (como Color, Graphics, etc)
import java.awt.image.*; // Importação de classes para manipulação de imagens
import java.io.*; // Importação de classes de entrada e saída de arquivos
// import javax.imageio.*; // Comentado: Importação repetida
// import java.awt.*; // Comentado: Importação repetida
// import java.awt.image.*; // Comentado: Importação repetida
import java.util.*; // Importação de classes para manipulação de coleções e utilitários

public class TelaDeCadastroController extends TelaDeCadastroView { // A classe controla a tela de cadastro e estende a classe da interface gráfica
    public static void cadastrarController() { // Método para registrar o usuário
        // Chama o modelo para cadastrar um usuário com os dados da interface gráfica
        TelaDeCadastroModel.cadastrarModel(txtNome.getText(), txtEmail.getText(), String.valueOf(txtSenha.getPassword()), nomeArquivoFoto);
    }

    public static void carregarFoto() { // Método para carregar uma foto do usuário
        try {
            JFileChooser chooser = new JFileChooser(); // Cria um seletor de arquivos para escolher a imagem

            chooser.setDialogTitle("Selecione o arquivo que deseja copiar"); // Define o título do diálogo
            chooser.setApproveButtonText("Copiar arquivo"); // Define o texto do botão de aprovação
            int returnVal = chooser.showOpenDialog(null); // Exibe o diálogo de seleção de arquivo
            String fileFullPath = ""; // Variável para armazenar o caminho completo do arquivo selecionado
            String fileName = ""; // Variável para armazenar o nome do arquivo selecionado
            if(returnVal == JFileChooser.APPROVE_OPTION) { // Verifica se o usuário selecionou um arquivo
                fileFullPath = chooser.getSelectedFile().getAbsolutePath(); // Obtém o caminho completo do arquivo
                fileName = "file-" + Math.random() + "-" + chooser.getSelectedFile().getName(); // Cria um nome único para o arquivo
            } else {
                System.out.println("Usuário não selecionou o arquivo para copiar..."); // Exibe mensagem de erro caso o usuário não escolha um arquivo
            }

            Path pathOrigin = Paths.get(fileFullPath); // Cria um objeto Path para o caminho original do arquivo
            String fullPathDestination = InterfaceView.localViewImgFolder + "\\" + fileName; // Define o caminho de destino para a imagem
            Path pathDestination = Paths.get(fullPathDestination); // Cria um objeto Path para o caminho de destino
            if (fileFullPath.length() > 0) { // Verifica se o caminho do arquivo não está vazio
                Files.copy(pathOrigin, pathDestination, REPLACE_EXISTING); // Copia o arquivo para o destino
                System.out.println("Arquivo " + chooser.getSelectedFile().getName() + " copiado/colado com sucesso."); // Exibe mensagem de sucesso
            } else {
                System.out.println("Ops! Não foi possível copiar o arquivo. Por favor, verifique e tente novamente mais tarde."); // Exibe mensagem de erro se o arquivo não foi copiado
            }

            nomeArquivoFoto = fileName; // Armazena o nome do arquivo copiado

            // Exibe a foto carregada no JLabel 'lblFoto', redimensionando a imagem para 100x100 pixels
            lblFoto.setIcon(new ImageIcon(new ImageIcon(InterfaceView.localViewImgFolder + "\\" + nomeArquivoFoto).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));

            try {
                redimensionarImagem(fileName); // Tenta redimensionar a imagem após carregá-la
            } catch (Exception e) {
                System.out.println("Erro: " + e); // Exibe mensagem de erro se falhar ao redimensionar
            }
        } catch (Exception e) {
            System.out.println("Não foi possível copiar o arquivo."); // Exibe mensagem de erro se ocorrer um erro no processo de carregamento da foto
        }
    }

    public static void removerFoto() { // Método para remover a foto do usuário
        // Define a imagem padrão no JLabel 'lblFoto' caso o usuário remova a foto
        lblFoto.setIcon(new ImageIcon(new ImageIcon(InterfaceView.localViewFolder + "\\imagem-padrao.jpg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
        nomeArquivoFoto = ""; // Limpa o nome do arquivo da foto
    }

    public static void redimensionarImagem(String img) throws IOException { // Método para redimensionar a imagem
        String fullFileName = img; // Recebe o nome do arquivo de imagem
        String fileName = getFileName(fullFileName); // Extrai o nome do arquivo sem a extensão

        // String fileExtension = getFileExtension(fullFileName); // Comentado: método para extrair a extensão do arquivo
        String fullPathImageOrigin = InterfaceView.localViewImgFolder + "\\" + fullFileName; // Caminho completo da imagem original
        BufferedImage bfImg = ImageIO.read(new File(fullPathImageOrigin)); // Lê a imagem original para um objeto BufferedImage

        String newFileExtension = "png"; // Define a extensão do novo arquivo como "png"
        String newFullPathImageOrigin = InterfaceView.localViewImgFolder + "\\" + "novo-" + fileName + "." + newFileExtension; // Caminho para o novo arquivo de imagem

        // BufferedImage jpgImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, BufferedImage.TYPE_INT_ARGB); // Comentado: criação de uma imagem com tamanho fixo
        File file = new File(newFullPathImageOrigin); // Cria o arquivo para salvar a imagem redimensionada
        ImageIO.write(bfImg, newFileExtension, file); // Escreve a imagem no arquivo

        Path source = Paths.get(fullPathImageOrigin); // Cria um Path para a imagem original
        String newFileName = fileName + "-redimensionado.png"; // Define o nome da nova imagem redimensionada
        Path target = Paths.get(InterfaceView.localViewImgFolder + "\\" + newFileName); // Define o caminho de destino para a nova imagem

        try (InputStream is = new FileInputStream(source.toFile())) { // Abre um fluxo de entrada para o arquivo original
            resize(is, target, InterfaceView.IMG_WIDTH, InterfaceView.IMG_HEIGHT, img); // Redimensiona a imagem e salva no destino
        }

        nomeArquivoFoto = newFileName; // Atualiza o nome do arquivo da foto com o novo nome
        Path newFullPathImage = Paths.get(newFullPathImageOrigin); // Cria um Path para o arquivo temporário
        Files.delete(newFullPathImage); // Deleta o arquivo temporário após o redimensionamento
    }

    public static String getFileExtension(String filename) { // Método para obter a extensão do arquivo
        if (filename == null) {
            return null; // Retorna null se o nome do arquivo for nulo
        }
        int dotIndex = filename.lastIndexOf("."); // Encontra o índice do ponto final na string
        if (dotIndex >= 0) {
            return filename.substring(dotIndex + 1); // Retorna a extensão do arquivo
        }
        return ""; // Retorna uma string vazia se não houver extensão
    }

    public static String getFileName(String filename) { // Método para obter o nome do arquivo sem a extensão
        if (filename == null) {
            return null; // Retorna null se o nome do arquivo for nulo
        }
        int dotIndex = filename.lastIndexOf("."); // Encontra o índice do ponto final na string
        if (dotIndex >= 0) {
            return filename.substring(0, dotIndex); // Retorna o nome do arquivo sem a extensão
        }
        return ""; // Retorna uma string vazia se não houver extensão
    }

    private static void resize(InputStream input, Path target,
    int width, int height, String img) throws IOException { // Método para redimensionar a imagem com as dimensões fornecidas

        // Lê uma imagem para BufferedImage para processamento
        BufferedImage originalImage = ImageIO.read(input);

        // Cria uma nova BufferedImage com as dimensões desejadas
        BufferedImage newResizedImage
        = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = newResizedImage.createGraphics();

        //g.setBackground(Color.WHITE); // Comentado: definir cor de fundo branca
        //g.setPaint(Color.WHITE); // Comentado: pintar fundo de branco

        // Define o fundo transparente
        g.setComposite(AlphaComposite.Src);
        g.fillRect(0, 0, width, height); // Preenche o fundo com a cor transparente

        // Adiciona sugestões de renderização (comentadas as específicas para qualidade)
        Map<RenderingHints.Key,Object> hints = new HashMap<>();
        hints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        hints.put(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        hints.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.addRenderingHints(hints);

        // Coloca a imagem original na nova BufferedImage redimensionada
        g.drawImage(originalImage, 0, 0, InterfaceView.IMG_WIDTH, InterfaceView.IMG_HEIGHT, null);
        g.dispose(); // Finaliza o desenho

        // Obtém a extensão do arquivo de destino
        String s = target.getFileName().toString();
        String fileExtension = s.substring(s.lastIndexOf(".") + 1);

        // Grava a imagem redimensionada no formato desejado
        ImageIO.write(newResizedImage, fileExtension, target.toFile());
        // System.out.println(target.toFile().toString()); // Comentado: exibe caminho do arquivo de destino
        // System.out.println(InterfaceView.localViewImgFolder + "\\" + target.toFile().toString()); // Comentado: exibe caminho do arquivo de destino
    }
}
