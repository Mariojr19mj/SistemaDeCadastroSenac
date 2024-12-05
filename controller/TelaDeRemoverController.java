package controller; // Define o pacote onde a classe está localizada, neste caso 'controller'.
import view.*; // Importa todas as classes do pacote 'view', permitindo o uso delas aqui.
import model.*; // Importa todas as classes do pacote 'model', permitindo o uso delas aqui.
import javax.swing.*; // Importa classes da biblioteca Swing para a criação de interfaces gráficas, como 'JLabel', 'JTextField', etc.
import java.awt.*; // Importa classes para manipulação de componentes gráficos, como 'ImageIcon'.

public class TelaDeRemoverController extends TelaDeRemoverView { // Define a classe 'TelaDeRemoverController', que herda de 'TelaDeRemoverView'.
    public static void removerController() { // Método estático que chama o modelo para remover um item baseado no ID selecionado.
        TelaDeRemoverModel.removerModel(String.valueOf(cbxId.getSelectedItem())); // Chama o método 'removerModel' de 'TelaDeRemoverModel', passando o ID selecionado do combo box como parâmetro.
    }

    public static void popularCbxIdController() { // Método estático que chama o modelo para popular o combo box com IDs.
        TelaDeRemoverModel.popularCbxIdModel(); // Chama o método 'popularCbxIdModel' de 'TelaDeRemoverModel' para popular o combo box.
    }

    public static void adicionarItemCbxId(String str) { // Método estático para adicionar um item ao combo box de IDs.
        cbxId.addItem(str); // Adiciona o item 'str' ao combo box 'cbxId'.
    }

    public static void preencherCampos(String nome, String email, String foto) { // Método estático para preencher os campos de nome, e-mail e foto na interface gráfica.
        if (foto != null) { // Verifica se a foto não é nula.
            if (foto.length() > 0) { // Se o nome da foto não for vazio, define a imagem da foto.
                lblFoto.setIcon(new ImageIcon(new ImageIcon(InterfaceView.localViewImgFolder + "\\" + foto).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT))); // Exibe a foto com o tamanho 100x100.
            } else { // Se a foto estiver vazia, define a imagem padrão.
                lblFoto.setIcon(new ImageIcon(new ImageIcon(InterfaceView.localViewFolder + "\\imagem-padrao.jpg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT))); // Exibe a imagem padrão com o tamanho 100x100.
            }
        } else { // Se a foto for nula, define a imagem padrão.
            lblFoto.setIcon(new ImageIcon(new ImageIcon(InterfaceView.localViewFolder + "\\imagem-padrao.jpg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT))); // Exibe a imagem padrão com o tamanho 100x100.
        }

        txtNome.setText(nome); // Define o valor do campo de texto 'txtNome' com o nome fornecido.
        txtEmail.setText(email); // Define o valor do campo de texto 'txtEmail' com o e-mail fornecido.
    }

    public static void atualizarCamposController() { // Método estático que chama o modelo para atualizar os campos com base no ID selecionado.
        TelaDeRemoverModel.atualizarCamposModel(String.valueOf(cbxId.getSelectedItem())); // Chama o método 'atualizarCamposModel' de 'TelaDeRemoverModel' passando o ID selecionado do combo box como parâmetro.
    }
}
