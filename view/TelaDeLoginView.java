package view; // Declaração do pacote view.

import controller.*; // Importa todos os controladores.

import java.awt.*; // Importa classes relacionadas à interface gráfica.
import java.awt.event.*; // Importa classes de eventos da interface gráfica.
import javax.swing.*; // Importa classes para componentes gráficos.

public class TelaDeLoginView extends JFrame { // Declaração da classe TelaDeLoginView que extende JFrame para criar uma janela gráfica.
    public static JLabel lblLogin; // Declaração de um rótulo para o campo de login.
    public static JTextField txtLogin; // Declaração de um campo de texto para o login.
    public static JLabel lblSenha; // Declaração de um rótulo para o campo de senha.
    public static JPasswordField txtSenha; // Declaração de um campo de senha (JPasswordField).
    public static JButton btnLogar; // Declaração de um botão para fazer login.
    public static JLabel lblNotificacoes; // Declaração de um rótulo para exibir notificações.

    public static GridBagLayout gbLayout; // Declaração de um GridBagLayout para o layout da tela.
    public static GridBagConstraints gbConstraints; // Declaração de um GridBagConstraints para as restrições do layout.

    public TelaDeLoginView() { // Construtor da classe TelaDeLoginView.
        super("Tela de Login"); // Chama o construtor da classe JFrame com o título "Tela de Login".
        gbLayout = new GridBagLayout(); // Cria um novo GridBagLayout.
        setLayout(gbLayout); // Define o layout da tela como GridBagLayout.
        gbConstraints = new GridBagConstraints(); // Cria um novo GridBagConstraints.

        lblLogin = new JLabel("Login:"); // Cria um novo rótulo com o texto "Login:".
        InterfaceView.addComponent(lblLogin, 0, 0, 1, 1, gbLayout, gbConstraints, this); // Adiciona o rótulo de login à tela.

        txtLogin = new JTextField(10); // Cria um novo campo de texto para o login com 10 colunas.
        InterfaceView.addComponent(txtLogin, 0, 1, 1, 1, gbLayout, gbConstraints, this); // Adiciona o campo de texto de login à tela.

        lblSenha = new JLabel("Senha:"); // Cria um novo rótulo com o texto "Senha:".
        InterfaceView.addComponent(lblSenha, 1, 0, 1, 1, gbLayout, gbConstraints, this); // Adiciona o rótulo de senha à tela.

        txtSenha = new JPasswordField(10); // Cria um novo campo de senha com 10 colunas.
        InterfaceView.addComponent(txtSenha, 1, 1, 1, 1, gbLayout, gbConstraints, this); // Adiciona o campo de senha à tela.

        btnLogar = new JButton("Logar"); // Cria um novo botão com o texto "Logar".
        InterfaceView.addComponent(btnLogar, 2, 0, 2, 1, gbLayout, gbConstraints, this); // Adiciona o botão "Logar" à tela.

        lblNotificacoes = new JLabel("Notificações", SwingConstants.CENTER); // Cria um novo rótulo de notificações, centralizado.
        // lblNotificacoes.setSize(getContentPane().getWidth(), 40); // (Comentado) Define o tamanho do rótulo de notificações com base na largura da tela.
        InterfaceView.addComponent(lblNotificacoes, 3, 0, 2, 1, gbLayout, gbConstraints, this); // Adiciona o rótulo de notificações à tela.

        ButtonHandler buttonHandler = new ButtonHandler(); // Cria uma instância do handler de botão.
        btnLogar.addActionListener(buttonHandler); // Adiciona um listener para o botão "Logar" que usa o ButtonHandler.

        txtSenha.addKeyListener( // Adiciona um listener para o campo de senha para detectar a liberação de teclas.
            new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent e) { // Método chamado quando uma tecla é liberada.
                    if (String.valueOf(txtSenha.getPassword()).trim().length() > 0) { // Se a senha não estiver vazia.
                        if (e.getKeyCode() == 10) { // Se a tecla liberada for a tecla "Enter" (código 10).
                            TelaDeLoginController.logarController(); // Chama o controlador para realizar o login.
                        }
                    }
                }
            }
        );

        setSize(170,140); // Define o tamanho da janela como 170x140 pixels.
        setVisible(true); // Torna a janela visível.
    }

    private class ButtonHandler implements ActionListener { // Declaração da classe interna ButtonHandler que implementa ActionListener.
        @Override
        public void actionPerformed(ActionEvent event) { // Método chamado quando o botão "Logar" é pressionado.
            TelaDeLoginController.logarController(); // Chama o controlador para realizar o login.
        }
    }

    public static TelaDeLoginView appTelaDeLoginView; // Declaração de uma instância estática da tela de login.
    public static void main(String[] args) { // Método principal para iniciar a aplicação.
        appTelaDeLoginView = new TelaDeLoginView(); // Cria uma nova tela de login.
        appTelaDeLoginView.setDefaultCloseOperation(EXIT_ON_CLOSE); // Define o comportamento ao fechar a tela de login.
        // InterfaceView.verificarLarguraEAltura(appTelaDeAtualizacaoView,lblNotificacoes); // (Comentado) Verifica a largura e altura da tela de atualização e do rótulo de notificações.
    }
}
