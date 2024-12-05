package view; // Declaração do pacote view.
import controller.*; // Importa todos os controladores.
import java.awt.*; // Importa classes relacionadas à interface gráfica.
import java.awt.event.*; // Importa classes de eventos da interface gráfica.
import javax.swing.*; // Importa as classes necessárias para componentes gráficos.

public class TelaDeAtualizacaoView extends JFrame { // Declaração da classe TelaDeAtualizacaoView, que extende JFrame para criar uma tela gráfica.
    public static JLabel lblFoto; // Declaração de um JLabel para mostrar a foto.
    public static JButton btnCarregarFoto; // Declaração de um JButton para carregar a foto.
    public static JButton btnRemoverFoto; // Declaração de um JButton para remover a foto.
    public static String nomeArquivoFoto = ""; // Variável para armazenar o nome do arquivo da foto.

    public static JLabel lblId; // Declaração de um JLabel para o campo Id.
    public static JComboBox<String> cbxId; // Declaração de um JComboBox para selecionar o id.

    public static JLabel lblNome; // Declaração de um JLabel para o campo Nome.
    public static JTextField txtNome; // Declaração de um JTextField para o campo Nome.
    public static String txtNomeCarregado; // Variável para armazenar o nome carregado.

    public static JLabel lblEmail; // Declaração de um JLabel para o campo Email.
    public static JTextField txtEmail; // Declaração de um JTextField para o campo Email.
    public static String txtEmailCarregado; // Variável para armazenar o email carregado.

    public static JLabel lblSenha; // Declaração de um JLabel para o campo Senha.
    public static JPasswordField txtSenha; // Declaração de um JPasswordField para o campo Senha.

    public static JButton btnAtualizar; // Declaração de um JButton para atualizar os dados.
    public static JButton btnCancelar; // Declaração de um JButton para cancelar a operação.

    public static JLabel lblNotificacoes; // Declaração de um JLabel para exibir notificações.

    public static GridBagLayout gbLayout; // Declaração de um GridBagLayout para o layout da tela.
    public static GridBagConstraints gbConstraints; // Declaração de um GridBagConstraints para as restrições do layout.

    public TelaDeAtualizacaoView() { // Construtor da classe TelaDeAtualizacaoView.
        super("Tela de Atualização"); // Chama o construtor da classe JFrame com o título "Tela de Atualização".

        gbLayout = new GridBagLayout(); // Cria um novo GridBagLayout.
        setLayout(gbLayout); // Define o layout da tela.
        gbConstraints = new GridBagConstraints(); // Cria um novo GridBagConstraints.

        lblFoto = new JLabel("", SwingConstants.CENTER); // Cria um JLabel para exibir a foto, com alinhamento centralizado.
        lblFoto.setIcon(new ImageIcon(new ImageIcon(InterfaceView.localViewFolder + "\\imagem-padrao.jpg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT))); // Define um ícone (foto padrão) para o JLabel.
        InterfaceView.addComponent(lblFoto, 0, 0, 2, 2, gbLayout, gbConstraints, this); // Adiciona o JLabel na tela com as restrições definidas.

        btnCarregarFoto = new JButton("Carregar foto"); // Cria um JButton com o texto "Carregar foto".
        InterfaceView.addComponent(btnCarregarFoto, 2, 0, 1, 1, gbLayout, gbConstraints, this); // Adiciona o botão na tela.

        btnRemoverFoto = new JButton("Remover foto"); // Cria um JButton com o texto "Remover foto".
        InterfaceView.addComponent(btnRemoverFoto, 2, 1, 1, 1, gbLayout, gbConstraints, this); // Adiciona o botão na tela.

        lblId = new JLabel("Id:", SwingConstants.RIGHT); // Cria um JLabel para o campo Id com alinhamento à direita.
        InterfaceView.addComponent(lblId, 3, 0, 1, 1, gbLayout, gbConstraints, this); // Adiciona o JLabel na tela.

        cbxId = new JComboBox<String>(); // Cria um JComboBox para seleção de id.
        TelaDeAtualizacaoController.popularCbxIdController(); // Chama o método do controlador para popular o JComboBox com os ids.
        InterfaceView.addComponent(cbxId, 3, 1, 1, 1, gbLayout, gbConstraints, this); // Adiciona o JComboBox na tela.

        lblNome = new JLabel("Nome:", SwingConstants.RIGHT); // Cria um JLabel para o campo Nome com alinhamento à direita.
        InterfaceView.addComponent(lblNome, 4, 0, 1, 1, gbLayout, gbConstraints, this); // Adiciona o JLabel na tela.

        txtNome = new JTextField(10); // Cria um JTextField para o campo Nome com 10 caracteres de largura.
        InterfaceView.addComponent(txtNome, 4, 1, 1, 1, gbLayout, gbConstraints, this); // Adiciona o JTextField na tela.

        lblEmail = new JLabel("Email:", SwingConstants.RIGHT); // Cria um JLabel para o campo Email com alinhamento à direita.
        InterfaceView.addComponent(lblEmail, 5, 0, 1, 1, gbLayout, gbConstraints, this); // Adiciona o JLabel na tela.

        txtEmail = new JTextField(10); // Cria um JTextField para o campo Email com 10 caracteres de largura.
        InterfaceView.addComponent(txtEmail, 5, 1, 1, 1, gbLayout, gbConstraints, this); // Adiciona o JTextField na tela.

        TelaDeAtualizacaoController.atualizarCamposController(); // Chama o controlador para atualizar os campos com os dados.

        lblSenha = new JLabel("Senha:", SwingConstants.RIGHT); // Cria um JLabel para o campo Senha com alinhamento à direita.
        InterfaceView.addComponent(lblSenha, 6, 0, 1, 1, gbLayout, gbConstraints, this); // Adiciona o JLabel na tela.

        txtSenha = new JPasswordField(10); // Cria um JPasswordField para o campo Senha com 10 caracteres de largura.
        InterfaceView.addComponent(txtSenha, 6, 1, 1, 1, gbLayout, gbConstraints, this); // Adiciona o JPasswordField na tela.

        btnAtualizar = new JButton("Atualizar"); // Cria um JButton com o texto "Atualizar".
        btnAtualizar.setEnabled(false); // Define que o botão "Atualizar" está inicialmente desabilitado.
        InterfaceView.addComponent(btnAtualizar, 7, 0, 1, 1, gbLayout, gbConstraints, this); // Adiciona o botão na tela.

        btnCancelar = new JButton("Cancelar"); // Cria um JButton com o texto "Cancelar".
        InterfaceView.addComponent(btnCancelar, 7, 1, 1, 1, gbLayout, gbConstraints, this); // Adiciona o botão na tela.

        lblNotificacoes = new JLabel("Notificações", SwingConstants.CENTER); // Cria um JLabel para exibir notificações, com alinhamento centralizado.
        InterfaceView.addComponent(lblNotificacoes, 8, 0, 2, 1, gbLayout, gbConstraints, this); // Adiciona o JLabel na tela.

        cbxId.addItemListener( // Adiciona um listener para o JComboBox que ouve a mudança de item selecionado.
            new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent event) { // Método que é chamado quando o estado do item no JComboBox muda.
                    if (event.getStateChange() == ItemEvent.SELECTED) { // Se o item foi selecionado.
                        TelaDeAtualizacaoController.atualizarCamposController(); // Chama o controlador para atualizar os campos.
                    }
                }
            }
        );

        btnAtualizar.addActionListener( // Adiciona um listener para o botão "Atualizar" para executar a ação quando clicado.
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) { // Método que é chamado quando o botão "Atualizar" é pressionado.
                    TelaDeAtualizacaoController.atualizarController(); // Chama o controlador para atualizar os dados.
                }
            }
        );

        txtNome.addKeyListener( // Adiciona um listener para o campo "Nome" para verificar a alteração enquanto digita.
            new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent event) { // Método que é chamado quando uma tecla é solta.
                    if (txtNomeCarregado.trim().equals(txtNome.getText().trim())) { // Se o nome não foi alterado.
                        btnAtualizar.setEnabled(false); // Desabilita o botão "Atualizar".
                    } else {
                        btnAtualizar.setEnabled(true); // Habilita o botão "Atualizar".
                    }
                }
            }
        );

        txtEmail.addKeyListener( // Adiciona um listener para o campo "Email" para verificar a alteração enquanto digita.
            new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent event) { // Método que é chamado quando uma tecla é solta.
                    if (txtEmailCarregado.trim().equals(txtEmail.getText().trim())) { // Se o email não foi alterado.
                        btnAtualizar.setEnabled(false); // Desabilita o botão "Atualizar".
                    } else {
                        btnAtualizar.setEnabled(true); // Habilita o botão "Atualizar".
                    }
                }
            }
        );

        txtSenha.addKeyListener( // Adiciona um listener para o campo "Senha" para verificar a alteração enquanto digita.
            new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent event) { // Método que é chamado quando uma tecla é solta.
                    if (String.valueOf(txtSenha.getPassword()).trim().length() == 0) { // Se o campo Senha estiver vazio.
                        btnAtualizar.setEnabled(false); // Desabilita o botão "Atualizar".
                    } else {
                        btnAtualizar.setEnabled(true); // Habilita o botão "Atualizar".
                    }
                }
            }
        );

        btnCancelar.addActionListener( // Adiciona um listener para o botão "Cancelar" para cancelar a operação.
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) { // Método que é chamado quando o botão "Cancelar" é pressionado.
                    TelaDeMenuView.appTelaDeMenuView.setVisible(true); // Torna a tela de menu visível.
                    dispose(); // Fecha a tela de atualização.
                }
            }
        );

        btnCarregarFoto.addActionListener( // Adiciona um listener para o botão "Carregar foto".
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) { // Método chamado quando o botão é pressionado.
                    TelaDeAtualizacaoController.carregarFoto(); // Chama o controlador para carregar a foto.
                }
            }
        );

        btnRemoverFoto.addActionListener( // Adiciona um listener para o botão "Remover foto".
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) { // Método chamado quando o botão é pressionado.
                    TelaDeAtualizacaoController.removerFoto(); // Chama o controlador para remover a foto.
                }
            }
        );

        setSize(350,350); // Define o tamanho da tela de 350x350 pixels.
        setVisible(true); // Torna a tela visível.
    }

    public static TelaDeAtualizacaoView appTelaDeAtualizacaoView; // Declaração de uma instância estática da tela de atualização.
    public static void main(String[] args) { // Método principal para iniciar a aplicação.
        if (InterfaceView.idLoginAtual.equals("")) { // Se o id do usuário logado estiver vazio.
            TelaDeLoginView.appTelaDeLoginView = new TelaDeLoginView(); // Cria uma nova tela de login.
            TelaDeLoginView.appTelaDeLoginView.setDefaultCloseOperation(EXIT_ON_CLOSE); // Define o comportamento ao fechar a tela de login.
        } else {
            appTelaDeAtualizacaoView = new TelaDeAtualizacaoView(); // Cria uma nova tela de atualização.
            appTelaDeAtualizacaoView.setDefaultCloseOperation(EXIT_ON_CLOSE); // Define o comportamento ao fechar a tela de atualização.
        }
    }
}
