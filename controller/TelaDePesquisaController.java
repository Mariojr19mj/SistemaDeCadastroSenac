package controller; // Define o pacote onde a classe está localizada, neste caso 'controller'.
import view.*; // Importa todas as classes do pacote 'view', permitindo o uso delas aqui.
import model.*; // Importa todas as classes do pacote 'model', permitindo o uso delas aqui.
import javax.swing.*; // Importa classes da biblioteca Swing para a criação de interfaces gráficas, como 'JLabel', 'JTextField', etc.
import java.awt.*; // Importa classes para manipulação de componentes gráficos, como 'ImageIcon'.

public class TelaDePesquisaController extends TelaDePesquisaView { // Define a classe 'TelaDePesquisaController', que herda de 'TelaDePesquisaView'.
    public static String registroDePesquisa = ""; // Declara uma variável estática que armazena o registro de pesquisa.

    public static String clausulasDePesquisaComWhere = ""; // Declara uma variável estática que armazena as cláusulas de pesquisa com 'WHERE'.

    public static String clausulasDePesquisaSemWhere = ""; // Declara uma variável estática que armazena as cláusulas de pesquisa sem 'WHERE'.

    public static void vaParaPrimeiroRegistro() { // Método estático que chama o modelo para navegar até o primeiro registro.
        TelaDePesquisaModel.vaParaPrimeiroRegistroModel(); // Chama o método 'vaParaPrimeiroRegistroModel' de 'TelaDePesquisaModel' para realizar a navegação.
    }

    public static void vaParaRegistroAnterior() { // Método estático que chama o modelo para navegar para o registro anterior.
        TelaDePesquisaModel.vaParaRegistroAnteriorModel(txtId.getText()); // Chama o método 'vaParaRegistroAnteriorModel' de 'TelaDePesquisaModel' passando o ID do texto como parâmetro.
    }

    public static void vaParaProximoRegistro() { // Método estático que chama o modelo para navegar para o próximo registro.
        TelaDePesquisaModel.vaParaProximoRegistroModel(txtId.getText()); // Chama o método 'vaParaProximoRegistroModel' de 'TelaDePesquisaModel' passando o ID do texto como parâmetro.
    }

    public static void vaParaUltimoRegistro() { // Método estático que chama o modelo para navegar até o último registro.
        TelaDePesquisaModel.vaParaUltimoRegistroModel(); // Chama o método 'vaParaUltimoRegistroModel' de 'TelaDePesquisaModel' para realizar a navegação.
    }

    public static void registrarPesquisa() { // Método estático que registra a pesquisa feita pelo usuário.
        TelaDePesquisaModel.registrarPesquisaModel(txtPesquisa.getText().trim()); // Chama o método 'registrarPesquisaModel' de 'TelaDePesquisaModel' com o texto da pesquisa inserido.
    }

    public static void inicializacaoDeRegistros() { // Método estático que chama a inicialização dos registros no modelo.
        TelaDePesquisaModel.inicializacaoDeRegistrosModel(); // Chama o método 'inicializacaoDeRegistrosModel' de 'TelaDePesquisaModel' para inicializar os registros.
    }

    public static void atualizarCampos(String id, String nome, String email, String foto) { // Método estático que atualiza os campos da interface gráfica com os dados fornecidos.
        if (foto != null) { // Verifica se a foto não é nula.
            if (foto.length() > 0) { // Se o nome da foto não for vazio, define a imagem da foto.
                lblFoto.setIcon(new ImageIcon(new ImageIcon(InterfaceView.localViewImgFolder + "\\" + foto).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT))); // Exibe a foto com o tamanho 100x100.
            } else { // Se a foto estiver vazia, define a imagem padrão.
                lblFoto.setIcon(new ImageIcon(new ImageIcon(InterfaceView.localViewFolder + "\\imagem-padrao.jpg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT))); // Exibe a imagem padrão com o tamanho 100x100.
            }
        } else { // Se a foto for nula, define a imagem padrão.
            lblFoto.setIcon(new ImageIcon(new ImageIcon(InterfaceView.localViewFolder + "\\imagem-padrao.jpg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT))); // Exibe a imagem padrão com o tamanho 100x100.
        }

        txtId.setText(id); // Define o valor do campo de texto 'txtId' com o ID fornecido.
        txtNome.setText(nome); // Define o valor do campo de texto 'txtNome' com o nome fornecido.
        txtEmail.setText(email); // Define o valor do campo de texto 'txtEmail' com o e-mail fornecido.
    }
}
