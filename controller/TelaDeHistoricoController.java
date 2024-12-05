package controller; // Define o pacote onde a classe está localizada, neste caso 'controller'.
import view.*; // Importa todas as classes do pacote 'view', permitindo o uso delas aqui.
import model.*; // Importa todas as classes do pacote 'model', permitindo o uso delas aqui.

public class TelaDeHistoricoController extends TelaDeHistoricoView { // Define a classe 'TelaDeHistoricoController', que herda de 'TelaDeHistoricoView'.
    public static String[] preencherHistorico() { // Método estático que chama o método de 'TelaDeHistoricoModel' para capturar o histórico.
        return TelaDeHistoricoModel.capturarHistorico(); // Chama o método 'capturarHistorico' da classe 'TelaDeHistoricoModel' e retorna o histórico como um array de Strings.
    }
}

