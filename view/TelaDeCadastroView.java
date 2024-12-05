package view; // Declaração do pacote view.
import controller.*; // Importa todos os controladores.

import java.awt.*; // Importa classes relacionadas à interface gráfica.
import java.awt.event.*; // Importa classes de eventos da interface gráfica.
import javax.swing.*; // Importa classes para componentes gráficos.

public class TelaDeCadastroView extends JFrame { // Declaração da classe TelaDeCadastroView, que extende JFrame para criar uma tela gráfica.
    public static JLabel lblFoto; // Declaração de um JLabel para mostrar a foto.
    public static JButton btnCarregarFoto; // Declaração de um JButton para carregar a foto.
    public static JButton btnRemoverFoto; // Declaração de um JButton para remover a foto.
    public static String nomeArquivoFoto = ""; // Variável para armazenar o nome do arquivo da foto.

    public static JLabel lblNome; // Declaração de um JLabel para o campo Nome.
    public static JTextField txtNome; // Declaração de um JTextField para o campo Nome.

    public static JLabel lblEmail; // Declaração de um JLabel para o campo Email.
    public static JTextField txtEmail; // Declaração de um JTextField para o campo Email.

    public static JLabel lblSenha; // Declaração de um JLabel para o campo Senha.
    public static JPasswordField txtSenha; // Declaração de um JPasswordField para o campo Senha.

    public static JButton btnCadastrar; // Declaração de um JButton para cadastrar.
    public static JButton btnCancelar; // Declaração de um JButton para cancelar a operação.

    public static JLabel lblNotificacoes; // Declaração de um JLabel para exibir notificações.

    public static GridBagLayout gbLayout; // Declaração de um GridBagLayout para o layout da tela.
    public static GridBagConstraints gbConstraints; // Declaração de um GridBagConstraints para as restrições do layout.

    public TelaDeCadastroView() { // Construtor da classe TelaDeCadastroView.
        super("Tela de Cadastro"); // Chama o construtor da classe JFrame com o título "Tela de Cadastro".

        gbLayout = new GridBagLayout(); // Cria um novo GridBagLayout.
        setLayout(gbLayout); // Define o layout da tela como GridBagLayout.
        gbConstraints = new GridBagConstraints(); // Cria um novo GridBagConstraints.

        lblFoto = new JLabel("", SwingConstants.CENTER); // Cria um JLabel para exibir a foto com alinhamento centralizado.
        lblFoto.setIcon(new ImageIcon(new ImageIcon(InterfaceView.localViewFolder + "\\imagem-padrao.jpg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT))); // Define o ícone da foto com uma imagem padrão redimensionada.
        InterfaceView.addComponent(lblFoto, 0, 0, 2, 2, gbLayout, gbConstraints, this); // Adiciona o JLabel com a foto na tela.

        btnCarregarFoto = new JButton("Carregar foto"); // Cria um botão "Carregar foto".
        InterfaceView.addComponent(btnCarregarFoto, 2, 0, 1, 1, gbLayout, gbConstraints, this); // Adiciona o botão "Carregar foto" na tela.

        btnRemoverFoto = new JButton("Remover foto"); // Cria um botão "Remover foto".
        InterfaceView.addComponent(btnRemoverFoto, 2, 1, 1, 1, gbLayout, gbConstraints, this); // Adiciona o botão "Remover foto" na tela.

        lblNome = new JLabel("Nome:", SwingConstants.RIGHT); // Cria um JLabel para o campo "Nome" com alinhamento à direita.
        InterfaceView.addComponent(lblNome, 3, 0, 1, 1, gbLayout, gbConstraints, this); // Adiciona o JLabel "Nome" na tela.

        txtNome = new JTextField(10); // Cria um JTextField para o campo "Nome" com 10 caracteres de largura.
        InterfaceView.addComponent(txtNome, 3, 1, 1, 1, gbLayout, gbConstraints, this); // Adiciona o JTextField "Nome" na tela.

        lblEmail = new JLabel("Email:", SwingConstants.RIGHT); // Cria um JLabel para o campo "Email" com alinhamento à direita.
        InterfaceView.addComponent(lblEmail, 4, 0, 1, 1, gbLayout, gbConstraints, this); // Adiciona o JLabel "Email" na tela.

        txtEmail = new JTextField(10); // Cria um JTextField para o campo "Email" com 10 caracteres de largura.
        InterfaceView.addComponent(txtEmail, 4, 1, 1, 1, gbLayout, gbConstraints, this); // Adiciona o JTextField "Email" na tela.

        lblSenha = new JLabel("Senha:", SwingConstants.RIGHT); // Cria um JLabel para o campo "Senha" com alinhamento à direita.
        InterfaceView.addComponent(lblSenha, 5, 0, 1, 1, gbLayout, gbConstraints, this); // Adiciona o JLabel "Senha" na tela.

        txtSenha = new JPasswordField(10); // Cria um JPasswordField para o campo "Senha" com 10 caracteres de largura.
        InterfaceView.addComponent(txtSenha, 5, 1, 1, 1, gbLayout, gbConstraints, this); // Adiciona o JPasswordField "Senha" na tela.

        btnCadastrar = new JButton("Cadastrar"); // Cria um botão "Cadastrar".
        InterfaceView.addComponent(btnCadastrar, 6, 0, 1, 1, gbLayout, gbConstraints, this); // Adiciona o botão "Cadastrar" na tela.

        btnCancelar = new JButton("Cancelar"); // Cria um botão "Cancelar".
        InterfaceView.addComponent(btnCancelar, 6, 1, 1, 1, gbLayout, gbConstraints, this); // Adiciona o botão "Cancelar" na tela.

        lblNotificacoes = new JLabel("Notificações", SwingConstants.CENTER); // Cria um JLabel para exibir notificações com alinhamento centralizado.
        InterfaceView.addComponent(lblNotificacoes, 7, 0, 2, 1, gbLayout, gbConstraints, this); // Adiciona o JLabel de notificações na tela.

        btnCadastrar.addActionListener( // Adiciona um listener para o botão "Cadastrar".
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) { // Método chamado quando o botão "Cadastrar" é pressionado.
                    if (txtNome.getText().trim().length() == 0) { // Verifica se o campo "Nome" está vazio.
                        lblNotificacoes.setText("É necessário digitar alguma coisa no campo Nome. Por favor, digite um caracter válido no campo Nome para prosseguir."); // Exibe uma mensagem de erro se o campo "Nome" estiver vazio.
                        txtNome.requestFocus(); // Foca no campo "Nome".
                        return; // Retorna para evitar a execução do código abaixo.
                    }

                    if (txtEmail.getText().trim().length() == 0) { // Verifica se o campo "Email" está vazio.
                        lblNotificacoes.setText("É necessário digitar alguma coisa no campo Email. Por favor, digite um caracter válido no campo Email para prosseguir."); // Exibe uma mensagem de erro se o campo "Email" estiver vazio.
                        txtEmail.requestFocus(); // Foca no campo "Email".
                        return; // Retorna para evitar a execução do código abaixo.
                    }

                    if (String.valueOf(txtSenha.getPassword()).trim().length() == 0) { // Verifica se o campo "Senha" está vazio.
                        lblNotificacoes.setText("É necessário digitar alguma coisa no campo Senha. Por favor, digite um caracter válido no campo Senha para prosseguir."); // Exibe uma mensagem de erro se o campo "Senha" estiver vazio.
                        txtSenha.requestFocus(); // Foca no campo "Senha".
                        return; // Retorna para evitar a execução do código abaixo.
                    }

                    TelaDeCadastroController.cadastrarController(); // Chama o método do controlador para realizar o cadastro.
                }
            }
        );

        btnCancelar.addActionListener( // Adiciona um listener para o botão "Cancelar".
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) { // Método chamado quando o botão "Cancelar" é pressionado.
                    TelaDeMenuView.appTelaDeMenuView.setVisible(true); // Torna a tela de menu visível.
                    dispose(); // Fecha a tela de cadastro.
                }
            }
        );

        btnCarregarFoto.addActionListener( // Adiciona um listener para o botão "Carregar foto".
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) { // Método chamado quando o botão "Carregar foto" é pressionado.
                    TelaDeCadastroController.carregarFoto(); // Chama o método do controlador para carregar a foto.
                }
            }
        );

        btnRemoverFoto.addActionListener( // Adiciona um listener para o botão "Remover foto".
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) { // Método chamado quando o botão "Remover foto" é pressionado.
                    TelaDeCadastroController.removerFoto(); // Chama o método do controlador para remover a foto.
                }
            }
        );

        setSize(280,280); // Define o tamanho da tela de 280x280 pixels.
        setVisible(true); // Torna a tela visível.
    }

    public static TelaDeCadastroView appTelaDeCadastroView; // Declaração de uma instância estática da tela de cadastro.
    public static void main(String[] args) { // Método principal para iniciar a aplicação.
        if (InterfaceView.idLoginAtual.equals("")) { // Se o id do usuário logado estiver vazio.
            TelaDeLoginView.appTelaDeLoginView = new TelaDeLoginView(); // Cria uma nova tela de login.
            TelaDeLoginView.appTelaDeLoginView.setDefaultCloseOperation(EXIT_ON_CLOSE); // Define o comportamento ao fechar a tela de login.
        } else {
            appTelaDeCadastroView = new TelaDeCadastroView(); // Cria uma nova tela de cadastro.
            appTelaDeCadastroView.setDefaultCloseOperation(EXIT_ON_CLOSE); // Define o comportamento ao fechar a tela de cadastro.
        }
    }
}
