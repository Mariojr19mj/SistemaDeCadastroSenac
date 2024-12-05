package view; // Declara o pacote view.

import java.awt.*; // Importa classes relacionadas ao layout e componentes gráficos.
import java.awt.event.*; // Importa classes de eventos da interface gráfica.
import javax.swing.*; // Importa classes para componentes gráficos.

public class TelaDeMenuView extends JFrame { // Declara a classe TelaDeMenuView que estende JFrame para criar uma janela gráfica.
    private final JMenu cadastroMenu; // Declaração do menu "Cadastro".
    private final JLabel lblNomeDaTela; // Declaração do rótulo que exibe o nome da tela.
    private final JMenuBar menuBar; // Declaração da barra de menu.
    private final JMenuItem novoItem; // Declaração do item de menu "Novo".
    private final JMenuItem pesquisarItem; // Declaração do item de menu "Pesquisar".
    private final JMenuItem atualizarItem; // Declaração do item de menu "Atualizar".
    private final JMenuItem removerItem; // Declaração do item de menu "Remover".
    private final JMenuItem sairItem; // Declaração do item de menu "Sair".

    public TelaDeMenuView() { // Construtor da classe TelaDeMenuView.
        super("Tela de Menu"); // Chama o construtor da classe JFrame com o título "Tela de Menu".

        cadastroMenu = new JMenu("Cadastro"); // Cria o menu "Cadastro".
        lblNomeDaTela = new JLabel("Tela de Menu", SwingConstants.CENTER); // Cria um rótulo para exibir o nome da tela, centralizado.
        menuBar = new JMenuBar(); // Cria a barra de menu.

        novoItem = new JMenuItem("Novo"); // Cria o item de menu "Novo".
        pesquisarItem = new JMenuItem("Pesquisar"); // Cria o item de menu "Pesquisar".
        atualizarItem = new JMenuItem("Atualizar"); // Cria o item de menu "Atualizar".
        removerItem = new JMenuItem("Remover"); // Cria o item de menu "Remover".
        sairItem = new JMenuItem("Sair"); // Cria o item de menu "Sair".

        cadastroMenu.add(novoItem); // Adiciona o item "Novo" ao menu "Cadastro".
        cadastroMenu.add(pesquisarItem); // Adiciona o item "Pesquisar" ao menu "Cadastro".
        cadastroMenu.add(atualizarItem); // Adiciona o item "Atualizar" ao menu "Cadastro".
        cadastroMenu.add(removerItem); // Adiciona o item "Remover" ao menu "Cadastro".
        cadastroMenu.add(sairItem); // Adiciona o item "Sair" ao menu "Cadastro".

        menuBar.add(cadastroMenu); // Adiciona o menu "Cadastro" à barra de menu.

        setJMenuBar(menuBar); // Define a barra de menu para a tela.

        add(lblNomeDaTela, BorderLayout.CENTER); // Adiciona o rótulo de nome da tela ao centro da tela usando BorderLayout.

        // Adiciona um listener de ação para o item "Novo".
        novoItem.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    TelaDeCadastroView.appTelaDeCadastroView = new TelaDeCadastroView(); // Cria uma nova tela de cadastro.
                    TelaDeCadastroView.appTelaDeCadastroView.setDefaultCloseOperation(DISPOSE_ON_CLOSE); // Define o comportamento ao fechar a tela de cadastro.
                    appTelaDeMenuView.setVisible(false); // Torna a tela de menu invisível.
                    TelaDeCadastroView.appTelaDeCadastroView.addWindowListener( // Adiciona um listener para quando a tela de cadastro for fechada.
                        new WindowAdapter() {
                            public void windowClosing(WindowEvent e) {
                                appTelaDeMenuView.setVisible(true); // Torna a tela de menu visível novamente.
                            }
                        }
                    );
                }
            }
        );

        // Adiciona um listener de ação para o item "Pesquisar".
        pesquisarItem.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    TelaDePesquisaView.appTelaDePesquisaView = new TelaDePesquisaView(); // Cria uma nova tela de pesquisa.
                    TelaDePesquisaView.appTelaDePesquisaView.setDefaultCloseOperation(DISPOSE_ON_CLOSE); // Define o comportamento ao fechar a tela de pesquisa.
                    appTelaDeMenuView.setVisible(false); // Torna a tela de menu invisível.
                    TelaDePesquisaView.appTelaDePesquisaView.addWindowListener( // Adiciona um listener para quando a tela de pesquisa for fechada.
                        new WindowAdapter() {
                            public void windowClosing(WindowEvent e) {
                                appTelaDeMenuView.setVisible(true); // Torna a tela de menu visível novamente.
                            }
                        }
                    );
                }
            }
        );

        // Adiciona um listener de ação para o item "Atualizar".
        atualizarItem.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    TelaDeAtualizacaoView.appTelaDeAtualizacaoView = new TelaDeAtualizacaoView(); // Cria uma nova tela de atualização.
                    TelaDeAtualizacaoView.appTelaDeAtualizacaoView.setDefaultCloseOperation(DISPOSE_ON_CLOSE); // Define o comportamento ao fechar a tela de atualização.
                    appTelaDeMenuView.setVisible(false); // Torna a tela de menu invisível.
                    TelaDeAtualizacaoView.appTelaDeAtualizacaoView.addWindowListener( // Adiciona um listener para quando a tela de atualização for fechada.
                        new WindowAdapter() {
                            public void windowClosing(WindowEvent e) {
                                appTelaDeMenuView.setVisible(true); // Torna a tela de menu visível novamente.
                            }
                        }
                    );
                }
            }
        );

        // Adiciona um listener de ação para o item "Remover".
        removerItem.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    TelaDeRemoverView.appTelaDeRemoverView = new TelaDeRemoverView(); // Cria uma nova tela de remoção.
                    TelaDeRemoverView.appTelaDeRemoverView.setDefaultCloseOperation(DISPOSE_ON_CLOSE); // Define o comportamento ao fechar a tela de remoção.
                    appTelaDeMenuView.setVisible(false); // Torna a tela de menu invisível.
                    TelaDeRemoverView.appTelaDeRemoverView.addWindowListener( // Adiciona um listener para quando a tela de remoção for fechada.
                        new WindowAdapter() {
                            public void windowClosing(WindowEvent e) {
                                appTelaDeMenuView.setVisible(true); // Torna a tela de menu visível novamente.
                            }
                        }
                    );
                }
            }
        );

        // Adiciona um listener de ação para o item "Sair".
        sairItem.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    System.out.println("Aqui ok"); // Exibe uma mensagem no console.
                    if (JOptionPane.showConfirmDialog(null, "Deseja mesmo sair do sistema?") == 0) { // Exibe uma caixa de diálogo de confirmação.
                        System.exit(0); // Fecha a aplicação se a confirmação for positiva.
                    }
                }
            }
        );

        setSize(300,300); // Define o tamanho da janela como 300x300 pixels.
        setVisible(true); // Torna a janela visível.
    }

    public static TelaDeMenuView appTelaDeMenuView; // Declaração de uma instância estática da tela de menu.
    public static void main(String[] args) { // Método principal para iniciar a aplicação.
        // InterfaceView.idLoginAtual = "16"; // (Comentado) Define um ID de login atual.
        if (InterfaceView.idLoginAtual.equals("")) { // Se o ID de login atual for uma string vazia.
            TelaDeLoginView.appTelaDeLoginView = new TelaDeLoginView(); // Cria uma nova tela de login.
            TelaDeLoginView.appTelaDeLoginView.setDefaultCloseOperation(EXIT_ON_CLOSE); // Define o comportamento ao fechar a tela de login.
        } else {
            appTelaDeMenuView = new TelaDeMenuView(); // Cria uma nova tela de menu.
            appTelaDeMenuView.setDefaultCloseOperation(EXIT_ON_CLOSE); // Define o comportamento ao fechar a tela de menu.

            appTelaDeMenuView.addWindowListener( // Adiciona um listener para a janela de menu.
                new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        InterfaceView.removerImagensInuteis(); // Remove imagens desnecessárias ao fechar a janela.
                    }
                }
            );
        }
    }
}
