package view; // Define o pacote da classe.
import controller.*; // Importa classes do pacote controller.
import java.awt.*; // Importa classes do pacote de interface gráfica (AWT).
import java.awt.event.*; // Importa classes de eventos de AWT.
import javax.swing.*; // Importa classes do pacote Swing para criar interfaces gráficas.

public class TelaDePesquisaView extends JFrame { // Define a classe TelaDePesquisaView, que estende JFrame (uma janela).
    public static JLabel lblFoto; // Declara um JLabel estático chamado lblFoto.
    public static final JTextField txtPesquisa = new JTextField(20); // Declara um campo de texto estático chamado txtPesquisa com 20 colunas.
    public final JButton btnPesquisar; // Declara um botão final para pesquisa.
    public final JButton btnReiniciarPesquisa; // Declara um botão final para reiniciar pesquisa.
    public final JButton btnHistoricoPesquisa; // Declara um botão final para histórico de pesquisa.

    public final JLabel lblId; // Declara um JLabel final para Id.
    public static final JTextField txtId = new JTextField(10); // Declara um campo de texto estático para Id com 10 colunas.

    public final JLabel lblNome; // Declara um JLabel final para Nome.
    public static final JTextField txtNome = new JTextField(10); // Declara um campo de texto estático para Nome com 10 colunas.

    public final JLabel lblEmail; // Declara um JLabel final para Email.
    public static final JTextField txtEmail = new JTextField(10); // Declara um campo de texto estático para Email com 10 colunas.

    public static final JButton btnPrimeiro = new JButton("<<"); // Declara um botão estático para o primeiro registro.
    public static final JButton btnAnterior = new JButton("<"); // Declara um botão estático para o registro anterior.
    public static final JButton btnProximo = new JButton(">"); // Declara um botão estático para o próximo registro.
    public static final JButton btnUltimo = new JButton(">>"); // Declara um botão estático para o último registro.

    public static final JLabel lblNotificacoes = new JLabel("Notificações", SwingConstants.CENTER); // Declara um JLabel estático para notificações.

    public static GridBagLayout gbLayout; // Declara um layout de gridBag.
    public static GridBagConstraints gbConstraints; // Declara as restrições do layout.

    public TelaDePesquisaView() { // Construtor da classe TelaDePesquisaView.
        super("Tela de Pesquisa"); // Chama o construtor da superclasse JFrame com o título "Tela de Pesquisa".
        gbLayout = new GridBagLayout(); // Inicializa o layout de GridBag.
        setLayout(gbLayout); // Define o layout da janela como GridBagLayout.
        gbConstraints = new GridBagConstraints(); // Inicializa as restrições do GridBag.

        lblFoto = new JLabel("", SwingConstants.CENTER); // Cria o JLabel lblFoto, com alinhamento centralizado.
        lblFoto.setIcon(new ImageIcon(new ImageIcon(InterfaceView.localViewFolder + "\\imagem-padrao.jpg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT))); // Define o ícone da lblFoto com uma imagem redimensionada.
        InterfaceView.addComponent(lblFoto, 0, 0, 4, 2, gbLayout, gbConstraints, this); // Adiciona lblFoto à interface gráfica.

        InterfaceView.addComponent(txtPesquisa, 2, 0, 4, 1, gbLayout, gbConstraints, this); // Adiciona o campo de pesquisa à interface.

        btnPesquisar = new JButton("Pesquisar"); // Cria o botão btnPesquisar com o texto "Pesquisar".
        btnPesquisar.setEnabled(false); // Define o botão como desabilitado.
        InterfaceView.addComponent(btnPesquisar, 3, 0, 1, 1, gbLayout, gbConstraints, this); // Adiciona o botão à interface.

        btnReiniciarPesquisa = new JButton("Reiniciar"); // Cria o botão btnReiniciarPesquisa com o texto "Reiniciar".
        InterfaceView.addComponent(btnReiniciarPesquisa, 3, 1, 2, 1, gbLayout, gbConstraints, this); // Adiciona o botão à interface.

        btnHistoricoPesquisa = new JButton("Histórico"); // Cria o botão btnHistoricoPesquisa com o texto "Histórico".
        InterfaceView.addComponent(btnHistoricoPesquisa, 3, 3, 1, 1, gbLayout, gbConstraints, this); // Adiciona o botão à interface.

        lblId = new JLabel("Id:", SwingConstants.RIGHT); // Cria o JLabel lblId com o texto "Id" e alinhamento à direita.
        InterfaceView.addComponent(lblId, 4, 0, 2, 1, gbLayout, gbConstraints, this); // Adiciona lblId à interface.

        txtId.setEditable(false); // Define o campo txtId como não editável.
        InterfaceView.addComponent(txtId, 4, 2, 2, 1, gbLayout, gbConstraints, this); // Adiciona txtId à interface.

        lblNome = new JLabel("Nome:", SwingConstants.RIGHT); // Cria o JLabel lblNome com o texto "Nome" e alinhamento à direita.
        InterfaceView.addComponent(lblNome, 5, 0, 2, 1, gbLayout, gbConstraints, this); // Adiciona lblNome à interface.

        txtNome.setEditable(false); // Define o campo txtNome como não editável.
        InterfaceView.addComponent(txtNome, 5, 2, 2, 1, gbLayout, gbConstraints, this); // Adiciona txtNome à interface.

        lblEmail = new JLabel("Email:", SwingConstants.RIGHT); // Cria o JLabel lblEmail com o texto "Email" e alinhamento à direita.
        InterfaceView.addComponent(lblEmail, 6, 0, 2, 1, gbLayout, gbConstraints, this); // Adiciona lblEmail à interface.

        txtEmail.setEditable(false); // Define o campo txtEmail como não editável.
        InterfaceView.addComponent(txtEmail, 6, 2, 2, 1, gbLayout, gbConstraints, this); // Adiciona txtEmail à interface.

        InterfaceView.addComponent(btnPrimeiro, 7, 0, 1, 1, gbLayout, gbConstraints, this); // Adiciona o botão btnPrimeiro à interface.
        InterfaceView.addComponent(btnAnterior, 7, 1, 1, 1, gbLayout, gbConstraints, this); // Adiciona o botão btnAnterior à interface.
        InterfaceView.addComponent(btnProximo, 7, 2, 1, 1, gbLayout, gbConstraints, this); // Adiciona o botão btnProximo à interface.
        InterfaceView.addComponent(btnUltimo, 7, 3, 1, 1, gbLayout, gbConstraints, this); // Adiciona o botão btnUltimo à interface.

        InterfaceView.addComponent(lblNotificacoes, 8, 0, 4, 1, gbLayout, gbConstraints, this); // Adiciona lblNotificacoes à interface.

        btnPrimeiro.addActionListener( // Adiciona o listener para o botão btnPrimeiro.
            new ActionListener() { // Cria o listener para o botão.
                @Override
                public void actionPerformed(ActionEvent event) { // Método chamado quando o botão é pressionado.
                    TelaDePesquisaController.vaParaPrimeiroRegistro(); // Chama o método para ir para o primeiro registro.
                }
            }
        );

        btnAnterior.addActionListener( // Adiciona o listener para o botão btnAnterior.
            new ActionListener() { // Cria o listener para o botão.
                @Override
                public void actionPerformed(ActionEvent event) { // Método chamado quando o botão é pressionado.
                    TelaDePesquisaController.vaParaRegistroAnterior(); // Chama o método para ir para o registro anterior.
                }
            }
        );

        btnProximo.addActionListener( // Adiciona o listener para o botão btnProximo.
            new ActionListener() { // Cria o listener para o botão.
                @Override
                public void actionPerformed(ActionEvent event) { // Método chamado quando o botão é pressionado.
                    TelaDePesquisaController.vaParaProximoRegistro(); // Chama o método para ir para o próximo registro.
                }
            }
        );

        btnUltimo.addActionListener( // Adiciona o listener para o botão btnUltimo.
            new ActionListener() { // Cria o listener para o botão.
                @Override
                public void actionPerformed(ActionEvent event) { // Método chamado quando o botão é pressionado.
                    TelaDePesquisaController.vaParaUltimoRegistro(); // Chama o método para ir para o último registro.
                }
            }
        );

        btnPesquisar.addActionListener( // Adiciona o listener para o botão btnPesquisar.
            new ActionListener() { // Cria o listener para o botão.
                @Override
                public void actionPerformed(ActionEvent event) { // Método chamado quando o botão é pressionado.
                    TelaDePesquisaController.registrarPesquisa(); // Registra a pesquisa.
                    txtPesquisa.setText(txtPesquisa.getText().trim()); // Limpa espaços extras no campo txtPesquisa.
                }
            }
        );

        txtPesquisa.addKeyListener( // Adiciona um KeyListener ao campo de pesquisa.
            new KeyAdapter() { // Cria o KeyAdapter para interceptar a digitação.
                @Override
                public void keyReleased(KeyEvent e) { // Método chamado quando uma tecla é liberada.
                    btnPesquisar.setEnabled(detectarPesquisa()); // Habilita ou desabilita o botão de pesquisa.
                    if (e.getKeyCode() == 10 && txtPesquisa.getText().trim().length() > 0) { // Verifica se a tecla Enter foi pressionada.
                        TelaDePesquisaController.registrarPesquisa(); // Registra a pesquisa.
                        txtPesquisa.setText(txtPesquisa.getText().trim()); // Limpa espaços extras no campo txtPesquisa.
                    }
                }
            }
        );

        btnReiniciarPesquisa.addActionListener( // Adiciona o listener para o botão btnReiniciarPesquisa.
            new ActionListener() { // Cria o listener para o botão.
                @Override
                public void actionPerformed(ActionEvent e) { // Método chamado quando o botão é pressionado.
                    txtPesquisa.setText(""); // Limpa o campo txtPesquisa.
                    TelaDePesquisaController.registroDePesquisa = ""; // Limpa o registro de pesquisa.
                    TelaDePesquisaController.clausulasDePesquisaComWhere = ""; // Limpa as cláusulas de pesquisa com WHERE.
                    TelaDePesquisaController.clausulasDePesquisaSemWhere = ""; // Limpa as cláusulas de pesquisa sem WHERE.
                    TelaDePesquisaController.vaParaPrimeiroRegistro(); // Vai para o primeiro registro.
                    btnPesquisar.setEnabled(false); // Desabilita o botão de pesquisa.
                    txtPesquisa.requestFocus(); // Foca novamente no campo txtPesquisa.
                }
            }
        );

        btnHistoricoPesquisa.addActionListener( // Adiciona o listener para o botão btnHistoricoPesquisa.
            new ActionListener() { // Cria o listener para o botão.
                @Override
                public void actionPerformed(ActionEvent e) { // Método chamado quando o botão é pressionado.
                    TelaDeHistoricoView.appTelaDeHistoricoView = new TelaDeHistoricoView(); // Cria a tela de histórico de pesquisa.
                    TelaDeHistoricoView.appTelaDeHistoricoView.setDefaultCloseOperation(DISPOSE_ON_CLOSE); // Define o fechamento da tela de histórico.
                    TelaDeHistoricoView.appTelaDeHistoricoView.addWindowListener( // Adiciona um listener para o fechamento da janela.
                        new WindowAdapter() { // Cria o WindowAdapter.
                            public void windowClosing(WindowEvent e) { // Método chamado quando a janela de histórico é fechada.
                                TelaDePesquisaView.appTelaDePesquisaView.setVisible(true); // Torna a tela de pesquisa visível.
                            }
                        }
                    );

                    setVisible(false); // Torna a tela de pesquisa invisível.
                }
            }
        );

        setSize(300,340); // Define o tamanho da janela.
        setVisible(true); // Torna a janela visível.

        TelaDePesquisaController.inicializacaoDeRegistros(); // Inicializa os registros para exibição.
    }

    public static void habilitarVoltar() { // Habilita os botões de navegação para voltar.
        btnPrimeiro.setEnabled(true); // Habilita o botão para ir ao primeiro registro.
        btnAnterior.setEnabled(true); // Habilita o botão para ir ao registro anterior.
        btnProximo.setEnabled(false); // Desabilita o botão para ir ao próximo registro.
        btnUltimo.setEnabled(false); // Desabilita o botão para ir ao último registro.
    }

    public static void habilitarAvancar() { // Habilita os botões de navegação para avançar.
        btnPrimeiro.setEnabled(false); // Desabilita o botão para ir ao primeiro registro.
        btnAnterior.setEnabled(false); // Desabilita o botão para ir ao registro anterior.
        btnProximo.setEnabled(true); // Habilita o botão para ir ao próximo registro.
        btnUltimo.setEnabled(true); // Habilita o botão para ir ao último registro.
    }

    public static void habilitarTodos() { // Habilita todos os botões de navegação.
        btnPrimeiro.setEnabled(true); // Habilita o botão para ir ao primeiro registro.
        btnAnterior.setEnabled(true); // Habilita o botão para ir ao registro anterior.
        btnProximo.setEnabled(true); // Habilita o botão para ir ao próximo registro.
        btnUltimo.setEnabled(true); // Habilita o botão para ir ao último registro.
    }

    public static void desabilitarTodos() { // Desabilita todos os botões de navegação.
        btnPrimeiro.setEnabled(false); // Desabilita o botão para ir ao primeiro registro.
        btnAnterior.setEnabled(false); // Desabilita o botão para ir ao registro anterior.
        btnProximo.setEnabled(false); // Desabilita o botão para ir ao próximo registro.
        btnUltimo.setEnabled(false); // Desabilita o botão para ir ao último registro.
    }

    public static boolean detectarPesquisa() { // Detecta se o campo de pesquisa tem texto.
        if (txtPesquisa.getText().trim().length() > 0) { // Verifica se o texto não está vazio.
            return true; // Retorna verdadeiro se houver texto.
        } else {
            return false; // Retorna falso se o campo estiver vazio.
        }
    }

    public static void limparCampos() { // Limpa os campos de Id, Nome e Email.
        txtId.setText(""); // Limpa o campo de Id.
        txtNome.setText(""); // Limpa o campo de Nome.
        txtEmail.setText(""); // Limpa o campo de Email.
    }

    public static TelaDePesquisaView appTelaDePesquisaView; // Declara uma instância da classe TelaDePesquisaView.

    public static void main(String[] args) { // Método principal.
        if (InterfaceView.idLoginAtual.equals("")) { // Verifica se o login atual está vazio.
            TelaDeLoginView.appTelaDeLoginView = new TelaDeLoginView(); // Cria a tela de login.
            TelaDeLoginView.appTelaDeLoginView.setDefaultCloseOperation(EXIT_ON_CLOSE); // Define o fechamento da janela de login.
        } else {
            appTelaDePesquisaView = new TelaDePesquisaView(); // Cria a tela de pesquisa.
            appTelaDePesquisaView.setDefaultCloseOperation(DISPOSE_ON_CLOSE); // Define o fechamento da janela de pesquisa.
        }
    }
}
