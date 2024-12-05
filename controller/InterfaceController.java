package controller; // Define o pacote no qual a classe está localizada, neste caso o pacote 'controller'.
import view.*; // Importa todas as classes do pacote 'view', permitindo que a classe use as funcionalidades desse pacote.
import java.io.*; // Importa classes da biblioteca de entrada e saída (I/O) de arquivos, como File, FileWriter, etc.
import java.util.*; // Importa classes utilitárias como ArrayList, Map, entre outras, que ajudam na manipulação de coleções.
import model.*; // Importa todas as classes do pacote 'model', permitindo que a classe use as funcionalidades desse pacote.

public class InterfaceController extends InterfaceView { // Define a classe 'InterfaceController' que herda de 'InterfaceView'. Isso permite que 'InterfaceController' acesse métodos e atributos da classe 'InterfaceView'.
    
    public static void verificarApagarImagensInuteis() { // Método estático chamado 'verificarApagarImagensInuteis' que verifica as imagens no diretório e valida aquelas que são úteis.
        
        final File folder = new File(localViewImgFolder); // Cria um objeto File chamado 'folder', representando o diretório localizado em 'localViewImgFolder' (uma variável que contém o caminho do diretório).
        
        ArrayList<String> strImagens = listFilesForFolder(folder); // Chama o método 'listFilesForFolder' passando 'folder' e armazena a lista de imagens (nomes dos arquivos) retornada em 'strImagens'.
        
        InterfaceModel.validarImagens(strImagens); // Chama o método 'validarImagens' da classe 'InterfaceModel' e passa a lista de nomes das imagens para validar quais são úteis.
    }

    public static ArrayList<String> listFilesForFolder(final File folder) { // Define um método estático chamado 'listFilesForFolder' que recebe um diretório (folder) e retorna uma lista de strings com os nomes dos arquivos presentes nesse diretório.
        
        ArrayList<String> strFiles = new ArrayList<String>(); // Cria uma lista (ArrayList) chamada 'strFiles' para armazenar os nomes dos arquivos encontrados no diretório.
        
        for (final File fileEntry : folder.listFiles()) { 
            // Inicia um loop que percorre todos os arquivos e subdiretórios dentro do diretório 'folder'.
            // A função 'listFiles()' retorna uma lista de objetos File representando cada arquivo ou diretório dentro de 'folder'.
            
            if (fileEntry.isDirectory()) { 
                // Verifica se o item iterado (fileEntry) é um diretório.
                
                listFilesForFolder(fileEntry); 
                // Se for um diretório, chama o método 'listFilesForFolder' recursivamente para explorar o conteúdo do subdiretório.
                
            } else { 
                // Caso o item não seja um diretório (portanto, é um arquivo), entra nesta parte.
                
                strFiles.add(fileEntry.getName()); 
                // Adiciona o nome do arquivo (obtido com 'getName()') à lista 'strFiles'.
                
                // System.out.println(fileEntry.getName()); 
                // Esta linha está comentada. Caso estivesse descomentada, ela imprimiria o nome de cada arquivo no diretório.
            }
        }

        return strFiles; 
        // Retorna a lista 'strFiles' contendo os nomes dos arquivos encontrados no diretório (não incluindo subdiretórios, pois são processados recursivamente).
    }
}
