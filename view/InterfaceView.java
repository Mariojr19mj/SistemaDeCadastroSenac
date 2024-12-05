package view; // Define o pacote onde a classe está localizada, neste caso 'view'.
import controller.*; // Importa todas as classes do pacote 'controller'.
import java.awt.*; // Importa classes necessárias para criar componentes gráficos (por exemplo, 'Component', 'GridBagLayout').
import java.awt.event.*; // Importa classes para lidar com eventos gráficos (por exemplo, 'ComponentAdapter', 'ComponentEvent').
import javax.swing.*; // Importa componentes gráficos da biblioteca Swing (como 'JFrame', 'JLabel').

public class InterfaceView { // Define a classe 'InterfaceView', responsável pela interface gráfica.

    public static String idLoginAtual = ""; // Declara uma variável estática para armazenar o 'id' do login atual.

    public static final String localViewImgFolder = System.getProperty("user.dir") 
        + "\\" 
        + "src" 
        + "\\" 
        + "view" 
        + "\\" 
        + "img"; // Define um caminho de diretório para armazenar imagens, concatenando o diretório atual com as pastas 'view' e 'img'.

    public static final String localViewFolder = System.getProperty("user.dir") 
        + "\\" 
        + "src" 
        + "\\" 
        + "view"; // Define um caminho de diretório para a pasta 'view' dentro do diretório do projeto.

    public static void addComponent(Component component, int row, int column, int width, int height, GridBagLayout gbLayout, GridBagConstraints gbConstraints, JFrame frame) { 
        // Método para adicionar um componente à interface gráfica usando o layout GridBag.
        if (height > 1 && width > 1) { // Se a altura e largura forem maiores que 1, o componente ocupa o espaço completo.
            gbConstraints.fill = GridBagConstraints.BOTH; // Preenche o espaço tanto na vertical quanto na horizontal.
        } else if (height > 1) { // Se apenas a altura for maior que 1.
            gbConstraints.fill = GridBagConstraints.VERTICAL; // Preenche apenas verticalmente.
        } else { // Caso contrário, preenche horizontalmente.
            gbConstraints.fill = GridBagConstraints.HORIZONTAL; // Preenche apenas horizontalmente.
        }
        gbConstraints.gridy = row; // Define a linha do componente no layout.
        gbConstraints.gridx = column; // Define a coluna do componente no layout.
        gbConstraints.gridwidth = width; // Define a largura do componente.
        gbConstraints.gridheight = height; // Define a altura do componente.
        gbLayout.setConstraints(component, gbConstraints); // Aplica as configurações ao componente no layout.
        frame.add(component); // Adiciona o componente ao frame (janela).
    }

    public static void verificarLarguraEAltura(JFrame frame, JLabel label) { // Método para verificar a largura e altura do frame e exibir a informação em um JLabel.
        frame.getRootPane().addComponentListener( // Adiciona um ouvinte de eventos de componentes ao frame.
            new ComponentAdapter() { // Cria uma classe anônima que adapta o comportamento do componente.
                public void componentResized(ComponentEvent e) { // Evento acionado quando o componente é redimensionado.
                    int larguraTela = frame.getWidth(); // Obtém a largura do frame.
                    int alturaTela = frame.getHeight(); // Obtém a altura do frame.
                    notificarUsuario(String.format("Largura: %s, Altura: %s", larguraTela, alturaTela), label); // Notifica o usuário sobre a largura e altura.
                }
            }
        );
    }

    public static void notificarUsuario(String str, JLabel label) { // Método para notificar o usuário, exibindo uma mensagem em um JLabel.
        label.setText(setHtmlFormat(str)); // Define o texto do JLabel com o conteúdo formatado em HTML.
    }

    public static String setHtmlFormat(String str) { // Método que retorna a string formatada em HTML.
        return "<html><body>" + str + "</body></html>"; // Converte o texto para o formato HTML.
    }

    public static void removerImagensInuteis() { // Método para remover imagens que não são mais necessárias.
        InterfaceController.verificarApagarImagensInuteis(); // Chama o método de 'InterfaceController' para verificar e apagar imagens inúteis.
    }
}
