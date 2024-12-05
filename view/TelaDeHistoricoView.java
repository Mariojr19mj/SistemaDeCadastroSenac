```java
package view; // Declaração do pacote view.
import controller.*; // Importa todos os controladores.
import java.awt.*; // Importa classes relacionadas à interface gráfica.
import java.awt.event.*; // Importa classes de eventos da interface gráfica.
import javax.swing.*; // Importa classes para componentes gráficos.
import javax.swing.event.*; // Importa classes para eventos relacionados ao JList.

public class TelaDeHistoricoView extends JFrame { // Declaração da classe TelaDeHistoricoView que extende JFrame para criar uma janela gráfica.
    public static JList<String> lstHistorico; // Declaração de uma lista (JList) para exibir o histórico de strings.
    public static JButton btnEnviarHistorico; // Declaração de um botão para enviar o histórico.

    public static GridBagLayout gbLayout; // Declaração de um GridBagLayout para o layout da tela.
    public static GridBagConstraints gbConstraints; // Declaração de um GridBagConstraints para as restrições do layout.

    public TelaDeHistoricoView() { // Construtor da classe TelaDeHistoricoView.
        super("Tela de Histórico"); // Chama o construtor da classe JFrame com o título "Tela de Histórico".

        gbLayout = new GridBagLayout(); // Cria um novo GridBagLayout.
        setLayout(gbLayout); // Define o layout da tela como GridBagLayout.

        gbConstraints = new GridBagConstraints(); // Cria um novo GridBagConstraints.

        lstHistorico = new JList<String>(TelaDeHistoricoController.preencherHistorico()); // Cria uma JList e a preenche com o histórico obtido do controlador.
        lstHistorico.setVisibleRowCount(5); // Define o número de linhas visíveis da lista como 5.
        lstHistorico.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Define que apenas um item pode ser selecionado por vez.
        InterfaceView.addComponent(lstHistorico, 0, 0, 1, 1, gbLayout, gbConstraints, this); // Adiciona o JList na tela.

        btnEnviarHistorico = new JButton("Enviar Histórico"); // Cria o botão "Enviar Histórico".
        btnEnviarHistorico.setEnabled(false); // Define o botão como desabilitado inicialmente.
        InterfaceView.addComponent(btnEnviarHistorico, 1, 0, 1, 1, gbLayout, gbConstraints, this); // Adiciona o botão na tela.

        lstHistorico.addListSelectionListener( // Adiciona um listener para monitorar a seleção de itens na JList.
            new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent event) { // Método chamado quando a seleção de itens muda.
                    btnEnviarHistorico.setEnabled(true); // Habilita o botão "Enviar Histórico" quando um item é selecionado.
                }
            }
        );

        btnEnviarHistorico.addActionListener( // Adiciona um listener para o botão "Enviar Histórico".
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) { // Método chamado quando o botão "Enviar Histórico" é pressionado.
                    TelaDePesquisaView.txtPesquisa.setText(lstHistorico.getSelectedValue()); // Define o valor selecionado da lista como texto no campo de pesquisa.
                    TelaDePesquisaView.appTelaDePesquisaView.setVisible(true); // Torna a tela de pesquisa visível.
                    dispose(); // Fecha a tela de histórico.
                }
            }
        );

        setSize(200, 200); // Define o tamanho da janela como 200x200 pixels.
        setVisible(true); // Torna a janela visível.
    }

    public static TelaDeHistoricoView appTelaDeHistoricoView; // Declaração de uma instância estática da tela de histórico.
    public static void main(String[] args) { // Método principal para iniciar a aplicação.
        if (InterfaceView.idLoginAtual.equals("")) { // Se o id do usuário logado estiver vazio.
            TelaDeLoginView.appTelaDeLoginView = new TelaDeLoginView(); // Cria uma nova tela de login.
            TelaDeLoginView.appTelaDeLoginView.setDefaultCloseOperation(EXIT_ON_CLOSE); // Define o comportamento ao fechar a tela de login.
        } else {
            appTelaDeHistoricoView = new TelaDeHistoricoView(); // Cria uma nova tela de histórico.
            appTelaDeHistoricoView.setDefaultCloseOperation(DISPOSE_ON_CLOSE); // Define o comportamento ao fechar a tela de histórico (disposição da janela).

            appTelaDeHistoricoView.addWindowListener( // Adiciona um listener para monitorar o evento de fechamento da janela.
                new WindowAdapter() {
                    public void windowClosing(WindowEvent e) { // Método chamado quando a janela está prestes a ser fechada.
                        TelaDePesquisaView.appTelaDePesquisaView.setVisible(true); // Torna a tela de pesquisa visível.
                        appTelaDeHistoricoView.dispose(); // Fecha a tela de histórico.
                    }
                }
            );
        }
    }
}
```