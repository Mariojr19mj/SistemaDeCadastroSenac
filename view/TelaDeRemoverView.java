package view; // Define o pacote da classe.
import controller.*; // Importa classes do pacote controller.
import java.awt.*; // Importa classes do pacote AWT para a interface gráfica.
import java.awt.event.*; // Importa classes de eventos de AWT.
import javax.swing.*; // Importa classes do pacote Swing para a interface gráfica.

public class TelaDeRemoverView extends JFrame { // Define a classe TelaDeRemoverView, que estende JFrame (uma janela).
    public static JLabel lblFoto; // Declara um JLabel estático chamado lblFoto.

    public static JLabel lblId; // Declara um JLabel estático chamado lblId.
    public static JComboBox<String> cbxId; // Declara um JComboBox estático para selecionar o Id.

    public static JLabel lblNome; // Declara um JLabel estático chamado lblNome.
    public static JTextField txtNome; // Declara um JTextField estático para o nome.

    public static JLabel lblEmail; // Declara um JLabel estático chamado lblEmail.
    public static JTextField txtEmail; // Declara um JTextField estático para o email.

    public static JButton btnRemover; // Declara um JButton estático para o botão Remover.
    public static JButton btnCancelar; // Declara um JButton estático para o botão Cancelar.

    public static JLabel lblNotificacoes; // Declara um JLabel estático para notificações.

    public static GridBagLayout gbLayout; // Declara um layout de GridBag.
    public static GridBagConstraints gbConstraints; // Declara as restrições do GridBag.

    public TelaDeRemoverView() { // Construtor da classe TelaDeRemoverView.
        super("Tela de Remover"); // Chama o construtor da superclasse JFrame com o título "Tela de Remover".

        gbLayout = new GridBagLayout(); // Inicializa o layout de GridBag.
        setLayout(gbLayout); // Define o layout da janela como GridBagLayout.
        gbConstraints = new GridBagConstraints(); // Inicializa as restrições do GridBag.

        lblFoto = new JLabel("", SwingConstants.CENTER); // Cria o JLabel lblFoto, com alinhamento centralizado.
        lblFoto.setIcon(new ImageIcon(new ImageIcon(InterfaceView.localViewFolder + "\\imagem-padrao.jpg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT))); // Define o ícone da lblFoto com uma imagem redimensionada.
        InterfaceView.addComponent(lblFoto, 0, 0, 4, 2, gbLayout, gbConstraints, this); // Adiciona lblFoto à interface gráfica.

        lblId = new JLabel("Id:", SwingConstants.RIGHT); // Cria o JLabel lblId com o texto "Id" e alinhamento à direita.
        InterfaceView.addComponent(lblId, 2, 0, 1, 1, gbLayout, gbConstraints, this); // Adiciona lblId à interface gráfica.

        cbxId = new JComboBox<String>(); // Cria o JComboBox cbxId.
        TelaDeRemoverController.popularCbxIdController(); // Chama o método para popular o JComboBox com dados.
        InterfaceView.addComponent(cbxId, 2, 1, 1, 1, gbLayout, gbConstraints, this); // Adiciona cbxId à interface gráfica.

        lblNome = new JLabel("Nome:", SwingConstants.RIGHT); // Cria o JLabel lblNome com o texto "Nome" e alinhamento à direita.
        InterfaceView.addComponent(lblNome, 3, 0, 1, 1, gbLayout, gbConstraints, this); // Adiciona lblNome à interface gráfica.

        txtNome = new JTextField(10); // Cria o campo de texto txtNome com 10 colunas.
        txtNome.setEditable(false); // Define o campo txtNome como não editável.
        InterfaceView.addComponent(txtNome, 3, 1, 1, 1, gbLayout, gbConstraints, this); // Adiciona txtNome à interface gráfica.

        lblEmail = new JLabel("Email:", SwingConstants.RIGHT); // Cria o JLabel lblEmail com o texto "Email" e alinhamento à direita.
        InterfaceView.addComponent(lblEmail, 4, 0, 1, 1, gbLayout, gbConstraints, this); // Adiciona lblEmail à interface gráfica.

        txtEmail = new JTextField(10); // Cria o campo de texto txtEmail com 10 colunas.
        txtEmail.setEditable(false); // Define o campo txtEmail como não editável.
        InterfaceView.addComponent(txtEmail, 4, 1, 1, 1, gbLayout, gbConstraints, this); // Adiciona txtEmail à interface gráfica.

        TelaDeRemoverController.atualizarCamposController(); // Chama o método para atualizar os campos na interface.

        btnRemover = new JButton("Remover"); // Cria o botão btnRemover com o texto "Remover".
        InterfaceView.addComponent(btnRemover, 5, 0, 1, 1, gbLayout, gbConstraints, this); // Adiciona btnRemover à interface gráfica.

        btnCancelar = new JButton("Cancelar"); // Cria o botão btnCancelar com o texto "Cancelar".
        InterfaceView.addComponent(btnCancelar, 5, 1, 1, 1, gbLayout, gbConstraints, this); // Adiciona btnCancelar à interface gráfica.

        lblNotificacoes = new JLabel("Notificações", SwingConstants.CENTER); // Cria o JLabel lblNotificacoes com o texto "Notificações" e alinhamento centralizado.
        InterfaceView.addComponent(lblNotificacoes, 6, 0, 2, 1, gbLayout, gbConstraints, this); // Adiciona lblNotificacoes à interface gráfica.

        cbxId.addItemListener( // Adiciona um ItemListener ao JComboBox cbxId.
            new ItemListener() { // Cria um ItemListener para o JComboBox.
                @Override
                public void itemStateChanged(ItemEvent event) { // Método chamado quando o estado do item muda.
                    if (event.getStateChange() == ItemEvent.SELECTED) { // Verifica se o item foi selecionado.
                        TelaDeRemoverController.atualizarCamposController(); // Atualiza os campos da interface.
                    }
                    if (event.getItem().equals(InterfaceView.idLoginAtual)) { // Verifica se o item selecionado é igual ao id do login atual.
                        btnRemover.setEnabled(false); // Desabilita o botão de remover se o item for o login atual.
                    } else {
                        btnRemover.setEnabled(true); // Habilita o botão de remover caso contrário.
                    }
                }
            }
        );

        btnRemover.addActionListener( // Adiciona um ActionListener ao botão btnRemover.
            new ActionListener() { // Cria o ActionListener para o botão.
                @Override
                public void actionPerformed(ActionEvent event) { // Método chamado quando o botão é pressionado.
                    if (JOptionPane.showConfirmDialog(null, "Tem certeza de que você deseja remover o id: " + String.valueOf(cbxId.getSelectedItem()) + "?") == 0) { // Exibe uma caixa de diálogo de confirmação.
                        TelaDeRemoverController.removerController(); // Chama o controlador para remover o item selecionado.
                        try { // Tenta remover o item da lista de IDs.
                            cbxId.setSelectedIndex(cbxId.getSelectedIndex() + 1); // Move a seleção para o próximo item.
                            cbxId.removeItemAt(cbxId.getSelectedIndex() - 1); // Remove o item selecionado.
                        } catch (Exception e) { // Captura qualquer exceção.
                            cbxId.setSelectedIndex(cbxId.getSelectedIndex() - 1); // Move a seleção para o item anterior.
                            cbxId.removeItemAt(cbxId.getSelectedIndex() + 1); // Remove o item selecionado.
                        }
                        TelaDeRemoverController.atualizarCamposController(); // Atualiza os campos da interface após a remoção.
                    }
                }
            }
        );

        btnCancelar.addActionListener( // Adiciona um ActionListener ao botão btnCancelar.
            new ActionListener() { // Cria o ActionListener para o botão.
                @Override
                public void actionPerformed(ActionEvent event) { // Método chamado quando o botão é pressionado.
                    TelaDeMenuView.appTelaDeMenuView.setVisible(true); // Torna a tela de menu visível.
                    dispose(); // Fecha a tela de remover.
                }
            }
        );

        setSize(300,300); // Define o tamanho da janela.
        setVisible(true); // Torna a janela visível.
    }

    public static TelaDeRemoverView appTelaDeRemoverView; // Declara uma instância estática de TelaDeRemoverView.
    public static void main(String[] args) { // Método principal.
        // InterfaceView.idLoginAtual = "16"; // Descomentado: define o id do login atual.
        if (InterfaceView.idLoginAtual.equals("")) { // Verifica se o idLoginAtual está vazio.
            TelaDeLoginView.appTelaDeLoginView = new TelaDeLoginView(); // Cria a tela de login.
            TelaDeLoginView.appTelaDeLoginView.setDefaultCloseOperation(EXIT_ON_CLOSE); // Define a operação de fechamento da tela de login.
        } else {
            appTelaDeRemoverView = new TelaDeRemoverView(); // Cria a tela de remover.
            appTelaDeRemoverView.setDefaultCloseOperation(EXIT_ON_CLOSE); // Define a operação de fechamento da tela de remover.
            // InterfaceView.verificarLarguraEAltura(appTelaDeAtualizacaoView,lblNotificacoes); // Comentado: método para verificar largura e altura.
        }
    }
}
