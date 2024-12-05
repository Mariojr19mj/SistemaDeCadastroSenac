package controller; // Define o pacote onde a classe está localizada, neste caso 'controller'.
import view.*; // Importa todas as classes do pacote 'view', permitindo o uso delas aqui.
import model.*; // Importa todas as classes do pacote 'model', permitindo o uso delas aqui.
import java.util.*; // Importa a classe 'ArrayList' e outras classes da biblioteca 'java.util'.

public class TelaDeLoginController extends TelaDeLoginView { // Define a classe 'TelaDeLoginController', que herda de 'TelaDeLoginView'.
    public static void logarController() { // Método estático responsável por realizar o login, chamando o modelo para verificar as credenciais.
        ArrayList<String> resultados = new ArrayList<String>(TelaDeLoginModel.logarModel(txtLogin.getText(), String.valueOf(txtSenha.getPassword()))); // Chama o método 'logarModel' de 'TelaDeLoginModel', passando os dados de login e senha, e armazena o retorno em uma lista.
        resultados.size(); // Obtém o tamanho da lista 'resultados', embora o valor retornado não seja utilizado em seguida.
    }

    public static void abrirTelaDeMenu() { // Método estático responsável por abrir a tela do menu após o login.
        TelaDeMenuView.appTelaDeMenuView = new TelaDeMenuView(); // Cria uma nova instância da tela de menu.
        TelaDeMenuView.appTelaDeMenuView.setDefaultCloseOperation(EXIT_ON_CLOSE); // Define a operação de fechamento da janela de menu, fechando a aplicação ao ser fechada.
        TelaDeLoginView.appTelaDeLoginView.dispose(); // Fecha a janela de login, encerrando a tela atual.
    }
}
