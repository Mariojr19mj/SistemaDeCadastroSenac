package view; // Define o pacote view, onde a classe TelaDeCadastroView está localizada
import controller.*; // Importa todas as classes do pacote controller

import java.awt.*; // Importa classes relacionadas à interface gráfica (como Layout, Componentes, etc.)
import java.awt.event.*; // Importa classes para lidar com eventos gráficos (como ActionListener)
import javax.swing.*; // Importa classes para componentes gráficos Swing (como JFrame, JLabel, JButton, etc.)

public class TelaDeCadastroView extends JFrame { // Define a classe TelaDeCadastroView que herda de JFrame (janela gráfica)
    public static JLabel lblFoto; // Declara um JLabel estático para exibir a foto do usuário
    public static JButton btnCarregarFoto; // Declara um JButton estático para carregar uma foto
    public static JButton btnRemoverFoto; // Declara um JButton estático para remover a foto
    public static String nomeArquivoFoto = ""; // Declara uma variável estática para armazenar o nome do arquivo da foto

    public static JLabel lblNome; // Declara um JLabel estático para o campo "Nome"
    public static JTextField txtNome; // Declara um JTextField estático para o campo de entrada do nome

    public static JLabel lblEmail; // Declara um JLabel estático para o campo "Email"
    public static JTextField txtEmail; // Declara um JTextField estático para o campo de entrada do email

    public static JLabel lblSenha; // Declara um JLabel estático para o campo "Senha"
    public static JPasswordField txtSenha; // Declara um JPasswordField estático para o campo de entrada de senha

    public static JButton btnCadastrar; // Declara um JButton estático para o botão de cadastro
    public static JButton btnCancelar; // Declara um JButton estático para o botão de cancelar

    public static JLabel lblNotificacoes; // Declara um JLabel estático para exibir notificações

    public static GridBagLayout gbLayout; // Declara um GridBagLayout para organizar os componentes na tela
    public static GridBagConstraints gbConstraints; // Declara um GridBagConstraints para definir as restrições de layout

    public TelaDeCadastroView() { // Construtor da classe TelaDeCadastroView
        super("Tela de Cadastro"); // Chama o construtor da classe JFrame com o título da janela

        gbLayout = new GridBagLayout(); // Inicializa o GridBagLayout
        setLayout(gbLayout); // Define o layout da tela como GridBagLayout
        gbConstraints = new GridBagConstraints(); // Inicializa o GridBagConstraints

        lblFoto = new JLabel("", SwingConstants.CENTER); // Cria um JLabel para a foto com alinhamento centralizado
        lblFoto.setIcon(new ImageIcon(new ImageIcon(InterfaceView.localViewFolder + "\\imagem-padrao.jpg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT))); // Define a imagem padrão para o JLabel
        InterfaceView.addComponent(lblFoto, 0, 0, 2, 2, gbLayout, gbConstraints, this); // Adiciona o JLabel à tela com as restrições definidas

        btnCarregarFoto = new JButton("Carregar foto"); // Cria um botão "Carregar foto"
        InterfaceView.addComponent(btnCarregarFoto, 2, 0, 1, 1, gbLayout, gbConstraints, this); // Adiciona o botão à tela

        btnRemoverFoto = new JButton("Remover foto"); // Cria um botão "Remover foto"
        InterfaceView.addComponent(btnRemoverFoto, 2, 1, 1, 1, gbLayout, gbConstraints, this); // Adiciona o botão à tela

        lblNome = new JLabel("Nome:", SwingConstants.RIGHT); // Cria um JLabel para o campo "Nome" com alinhamento à direita
        InterfaceView.addComponent(lblNome, 3, 0, 1, 1, gbLayout, gbConstraints, this); // Adiciona o JLabel à tela

        txtNome = new JTextField(10); // Cria um JTextField para o campo de entrada de nome com largura de 10 caracteres
        InterfaceView.addComponent(txtNome, 3, 1, 1, 1, gbLayout, gbConstraints, this); // Adiciona o JTextField à tela

        lblEmail = new JLabel("Email:", SwingConstants.RIGHT); // Cria um JLabel para o campo "Email" com alinhamento à direita
        InterfaceView.addComponent(lblEmail, 4, 0, 1, 1, gbLayout, gbConstraints, this); // Adiciona o JLabel à tela

        txtEmail = new JTextField(10); // Cria um JTextField para o campo de entrada de email com largura de 10 caracteres
        InterfaceView.addComponent(txtEmail, 4, 1, 1, 1, gbLayout, gbConstraints, this); // Adiciona o JTextField à tela

        lblSenha = new JLabel("Senha:", SwingConstants.RIGHT); // Cria um JLabel para o campo "Senha" com alinhamento à direita
        InterfaceView.addComponent(lblSenha, 5, 0, 1, 1, gbLayout, gbConstraints, this); // Adiciona o JLabel à tela

        txtSenha = new JPasswordField(10); // Cria um JPasswordField para o campo de entrada de senha com largura de 10 caracteres
        InterfaceView.addComponent(txtSenha, 5, 1, 1, 1, gbLayout, gbConstraints, this); // Adiciona o JPasswordField à tela

        btnCadastrar = new JButton("Cadastrar"); // Cria um botão "Cadastrar"
        InterfaceView.addComponent(btnCadastrar, 6, 0, 1, 1, gbLayout, gbConstraints, this); // Adiciona o botão à tela

        btnCancelar = new JButton("Cancelar"); // Cria um botão "Cancelar"
        InterfaceView.addComponent(btnCancelar, 6, 1, 1, 1, gbLayout, gbConstraints, this); // Adiciona o botão à tela

        lblNotificacoes = new JLabel("Notificações", SwingConstants.CENTER); // Cria um JLabel para exibir notificações com alinhamento centralizado
        InterfaceView.addComponent(lblNotificacoes, 7, 0, 2, 1, gbLayout, gbConstraints, this); // Adiciona o JLabel à tela

        btnCadastrar.addActionListener( // Adiciona um ActionListener ao botão "Cadastrar"
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) { // Método que é chamado quando o botão é clicado
                    // Validações dos campos de entrada (Nome, Email, Senha) com mensagens de erro
                    if (txtNome.getText().trim().length() == 0) { // Verifica se o campo Nome está vazio
                        lblNotificacoes.setText("É necessário digitar alguma coisa no campo Nome. Por favor, digite um caracter válido no campo Nome para prosseguir.");
                        txtNome.requestFocus(); // Foca no campo Nome
                        return; // Interrompe a execução se o campo Nome estiver vazio
                    }

                    if (txtEmail.getText().trim().length() == 0) { // Verifica se o campo Email está vazio
                        lblNotificacoes.setText("É necessário digitar alguma coisa no campo Email. Por favor, digite um caracter válido no campo Email para prosseguir.");
                        txtEmail.requestFocus(); // Foca no campo Email
                        return; // Interrompe a execução se o campo Email estiver vazio
                    }

                    if (txtEmail.getText().trim().indexOf('@') < 0) { // Verifica se o campo Email contém '@'
                        lblNotificacoes.setText("É necessário digitar um @ no campo Email. Por favor, digite um @ no campo Email para prosseguir.");
                        txtEmail.requestFocus(); // Foca no campo Email
                        return; // Interrompe a execução se não houver '@' no campo Email
                    }

                    if (txtEmail.getText().trim().indexOf('.') < 0) { // Verifica se o campo Email contém '.'
                        lblNotificacoes.setText("É necessário digitar um . no campo Email. Por favor, digite um . no campo Email para prosseguir.");
                        txtEmail.requestFocus(); // Foca no campo Email
                        return; // Interrompe a execução se não houver '.' no campo Email
                    }

                    if (txtEmail.getText().trim().length() < 10) { // Verifica se o campo Email tem pelo menos 10 caracteres
                        lblNotificacoes.setText("É necessário digitar no mínimo dez caracteres no campo Email. Por favor, digite no mínimo dez caracteres no campo Email para prosseguir.");
                        txtEmail.requestFocus(); // Foca no campo Email
                        return; // Interrompe a execução se o campo Email for muito curto
                    }

                    // Outras validações detalhadas do campo Email (ex: comprimento antes e depois do '@' e '.')
                    int antesDoArroba = txtEmail.getText().trim().lastIndexOf('@'); // Localiza a posição do '@' no email
                    String strAntesDoArroba = txtEmail.getText().trim().substring(0, antesDoArroba); // Obtém a parte do email antes do '@'

                    if (strAntesDoArroba.length() < 3) { // Verifica se há pelo menos 3 caracteres antes do '@'
                        lblNotificacoes.setText("É necessário digitar no mínimo três caracteres antes do @ no campo Email. Por favor, digite um caracter válido.");
                        txtEmail.requestFocus(); // Foca no campo Email
                        return; // Interrompe a execução se houver menos de 3 caracteres antes do '@'
                    }

                    int antesDoPonto = txtEmail.getText().trim().lastIndexOf('.'); // Localiza a posição do '.' no email

                    if ((antesDoPonto - antesDoArroba) < 4) { // Verifica se há pelo menos 3 caracteres entre '@' e '.'
                        lblNotificacoes.setText("É necessário digitar no mínimo três caracteres depois do @ e antes do . no campo Email.");
                        txtEmail.requestFocus(); // Foca no campo Email
                        return; // Interrompe a execução se não houver caracteres suficientes entre '@' e '.'
                    }

                    String strDepoisDoPonto = txtEmail.getText().trim().substring(antesDoPonto + 1); // Obtém a parte do email depois do '.'

                    if (strDepoisDoPonto.length() < 2) { // Verifica se há pelo menos 2 caracteres depois do '.'
                        lblNotificacoes.setText("É necessário digitar no mínimo dois caracteres depois do . no campo Email.");
                        txtEmail.requestFocus(); // Foca no campo Email
                        return; // Interrompe a execução se houver menos de 2 caracteres depois do '.'
                    }

                    if (String.valueOf(txtSenha.getPassword()).trim().length() == 0) { // Verifica se o campo Senha está vazio
                        lblNotificacoes.setText("É necessário digitar alguma coisa no campo Senha. Por favor, digite um caracter válido no campo Senha.");
                        txtSenha.requestFocus(); // Foca no campo Senha
                        return; // Interrompe a execução se o campo Senha estiver vazio
                    }

                    TelaDeCadastroController.cadastrarController(); // Chama o método cadastrarController da classe TelaDeCadastroController
                }
            }
        );

        btnCancelar.addActionListener( // Adiciona um ActionListener ao botão "Cancelar"
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) { // Método chamado quando o botão é clicado
                    TelaDeMenuView.appTelaDeMenuView.setVisible(true); // Exibe a tela de menu
                    dispose(); // Fecha a tela de cadastro
                }
            }
        );

        btnCarregarFoto.addActionListener( // Adiciona um ActionListener ao botão "Carregar foto"
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) { // Método chamado quando o botão é clicado
                    TelaDeCadastroController.carregarFoto(); // Chama o método carregarFoto da classe TelaDeCadastroController
                }
            }
        );

        btnRemoverFoto.addActionListener( // Adiciona um ActionListener ao botão "Remover foto"
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) { // Método chamado quando o botão é clicado
                    TelaDeCadastroController.removerFoto(); // Chama o método removerFoto da classe TelaDeCadastroController
                }
            }
        );

        setSize(280,280); // Define o tamanho da janela para 280x280 pixels
        setVisible(true); // Torna a janela visível
    }

    public static TelaDeCadastroView appTelaDeCadastroView; // Declara uma instância estática da classe TelaDeCadastroView
    public static void main(String[] args) { // Método main que executa o programa
        // InterfaceView.idLoginAtual = "16";
        if (InterfaceView.idLoginAtual.equals("")) { // Verifica se o idLoginAtual está vazio
            TelaDeLoginView.appTelaDeLoginView = new TelaDeLoginView(); // Cria uma nova instância da tela de login
            TelaDeLoginView.appTelaDeLoginView.setDefaultCloseOperation(EXIT_ON_CLOSE); // Define o comportamento de fechamento da tela de login
        } else {
            appTelaDeCadastroView = new TelaDeCadastroView(); // Cria uma nova instância da tela de cadastro
            appTelaDeCadastroView.setDefaultCloseOperation(EXIT_ON_CLOSE); // Define o comportamento de fechamento da tela de cadastro
            // InterfaceView.verificarLarguraEAltura(appTelaDeAtualizacaoView,lblNotificacoes);
        }
    }
}
