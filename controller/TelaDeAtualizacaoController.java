package controller; // Define o pacote onde a classe está localizada, neste caso 'controller'.

import view.*; // Importa todas as classes do pacote 'view', permitindo o uso delas aqui.

import model.*; // Importa todas as classes do pacote 'model', permitindo o uso delas aqui.

import java.util.*; // Importa classes utilitárias, como ArrayList, para manipulação de coleções.

import static java.nio.file.StandardCopyOption.*; // Importa opções padrão de cópia de arquivos, como 'REPLACE_EXISTING', para usar em operações de cópia de arquivos.

import java.nio.file.*; // Importa classes de manipulação de caminhos e arquivos, como Path e Files.

import javax.swing.*; // Importa classes para criar interfaces gráficas, como componentes de GUI (ex. JFileChooser, ImageIcon, etc.).

import java.awt.*; // Importa classes para trabalhar com a interface gráfica (GUI), como Image e outras.

public class TelaDeAtualizacaoController extends TelaDeAtualizacaoView { 
    // Define a classe 'TelaDeAtualizacaoController', que herda de 'TelaDeAtualizacaoView', permitindo o uso da interface gráfica definida na classe pai.
    
    public static void popularCbxIdController() { 
        // Método estático que popula o comboBox (cbxId) com IDs, usando dados obtidos do modelo (TelaDeAtualizacaoModel).
        
        ArrayList<String> ids = TelaDeAtualizacaoModel.popularCbxIdModel(); 
        // Chama o método 'popularCbxIdModel' de 'TelaDeAtualizacaoModel' para obter uma lista de IDs.
        
        for (int i = 0; i < ids.size(); i++) { 
            // Itera sobre a lista de IDs retornada pelo modelo.
            
            cbxId.addItem(ids.get(i)); 
            // Adiciona cada ID à lista suspensa (comboBox) 'cbxId'.
        }
    }

    public static void atualizarCamposController() { 
        // Método estático que atualiza os campos da interface gráfica com os dados do modelo.
        
        ArrayList<String> dados = TelaDeAtualizacaoModel.atualizarCamposModel(String.valueOf(cbxId.getSelectedItem())); 
        // Chama o método 'atualizarCamposModel' de 'TelaDeAtualizacaoModel' para obter os dados correspondentes ao ID selecionado no comboBox.
        
        String foto = dados.get(2); 
        // Obtém o nome da foto (índice 2) da lista 'dados' retornada pelo modelo.
        
        if (foto != null) { 
            // Verifica se o nome da foto não é nulo.
            
            if (foto.length() > 0) { 
                // Se o nome da foto não for vazio.
                
                lblFoto.setIcon(new ImageIcon(new ImageIcon(InterfaceView.localViewImgFolder + "\\" + foto).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT))); 
                // Atualiza o ícone da label 'lblFoto' com a imagem correspondente ao nome da foto, redimensionada para 100x100 pixels.
                
                btnRemoverFoto.setEnabled(true); 
                // Habilita o botão 'btnRemoverFoto', permitindo ao usuário remover a foto.
            } else {
                lblFoto.setIcon(new ImageIcon(new ImageIcon(InterfaceView.localViewFolder + "\\imagem-padrao.jpg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT))); 
                // Se a foto não existir, define uma imagem padrão como ícone da label 'lblFoto'.
                
                btnRemoverFoto.setEnabled(false); 
                // Desabilita o botão 'btnRemoverFoto' caso não haja foto.
            }
        } else {
            lblFoto.setIcon(new ImageIcon(new ImageIcon(InterfaceView.localViewFolder + "\\imagem-padrao.jpg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT))); 
            // Caso a foto seja nula, define a imagem padrão como ícone da label 'lblFoto'.
            
            btnRemoverFoto.setEnabled(false); 
            // Desabilita o botão 'btnRemoverFoto'.
        }

        txtNome.setText(dados.get(0)); 
        // Define o texto do campo 'txtNome' com o nome obtido da lista 'dados' (índice 0).
        
        txtEmail.setText(dados.get(1)); 
        // Define o texto do campo 'txtEmail' com o email obtido da lista 'dados' (índice 1).
    }

    public static void atualizarController() { 
        // Método estático que atualiza os dados no modelo, se os dados forem válidos.
        
        if (TelaDeAtualizacaoModel.atualizarModel(String.valueOf(cbxId.getSelectedItem()), txtNome.getText().trim(), txtEmail.getText().trim(), String.valueOf(txtSenha.getPassword()).trim(), nomeArquivoFoto)) { 
            // Chama o método 'atualizarModel' para atualizar os dados do modelo com os valores dos campos da interface gráfica, como nome, email e senha.
            
            txtNomeCarregado = txtNome.getText().trim(); 
            // Atualiza a variável 'txtNomeCarregado' com o nome inserido pelo usuário.
            
            txtEmailCarregado = txtEmail.getText().trim(); 
            // Atualiza a variável 'txtEmailCarregado' com o email inserido pelo usuário.
            
            btnAtualizar.setEnabled(false); 
            // Desabilita o botão 'btnAtualizar', pois os dados já foram atualizados.
        }
    }

    public static void carregarFoto() { 
        // Método estático que permite ao usuário carregar uma foto e copiá-la para um diretório.
        
        try { 
            // Tenta executar o código dentro do bloco 'try', tratando possíveis exceções.
            
            JFileChooser chooser = new JFileChooser(); 
            // Cria um novo objeto JFileChooser para permitir ao usuário selecionar um arquivo de imagem.
            
            chooser.setDialogTitle("Selecione o arquivo que deseja copiar"); 
            // Define o título da caixa de diálogo do JFileChooser.
            
            chooser.setApproveButtonText("Copiar arquivo"); 
            // Define o texto do botão de aprovação na caixa de diálogo.
            
            int returnVal = chooser.showOpenDialog(null); 
            // Exibe a caixa de diálogo para o usuário escolher um arquivo e armazena a resposta (se o usuário clicou em OK ou Cancelar).
            
            String fileFullPath = ""; 
            // Variável para armazenar o caminho completo do arquivo selecionado.
            
            String fileName = ""; 
            // Variável para armazenar o nome do arquivo selecionado.
            
            if(returnVal == JFileChooser.APPROVE_OPTION) { 
                // Se o usuário clicou em "OK" para selecionar um arquivo.
                
                fileFullPath = chooser.getSelectedFile().getAbsolutePath(); 
                // Obtém o caminho completo do arquivo selecionado.
                
                fileName = "file-" + Math.random() + "-" + chooser.getSelectedFile().getName(); 
                // Gera um novo nome para o arquivo selecionado, usando um identificador aleatório.
            } else { 
                System.out.println("Usuário não selecionou o arquivo para copiar..."); 
                // Caso o usuário tenha clicado em "Cancelar", imprime uma mensagem no console.
            }

            Path pathOrigin = Paths.get(fileFullPath); 
            // Cria um objeto Path com o caminho do arquivo de origem.

            Path pathDestination = Paths.get(InterfaceView.localViewImgFolder + "\\" + fileName); 
            // Cria um objeto Path com o caminho de destino para salvar a imagem na pasta 'localViewImgFolder'.

            if (fileFullPath.length() > 0) { 
                // Verifica se o caminho do arquivo não está vazio.
                
                Files.copy(pathOrigin, pathDestination, REPLACE_EXISTING); 
                // Copia o arquivo da origem para o destino, substituindo se já existir um arquivo com o mesmo nome.
                
                System.out.println("Arquivo " + chooser.getSelectedFile().getName() + " copiado/colado com sucesso."); 
                // Imprime uma mensagem indicando que o arquivo foi copiado com sucesso.
            } else {
                System.out.println("Ops! Não foi possível copiar o arquivo. Por favor, verifique e tente novamente mais tarde."); 
                // Imprime uma mensagem de erro caso não seja possível copiar o arquivo.
            }

            nomeArquivoFoto = fileName; 
            // Atualiza a variável 'nomeArquivoFoto' com o novo nome do arquivo copiado.

            lblFoto.setIcon(new ImageIcon(new ImageIcon(InterfaceView.localViewImgFolder + "\\" + nomeArquivoFoto).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT))); 
            // Atualiza o ícone da label 'lblFoto' com a foto carregada, redimensionada para 100x100 pixels.
            
            btnRemoverFoto.setEnabled(true); 
            // Habilita o botão 'btnRemoverFoto', permitindo que o usuário remova a foto.
            
            btnAtualizar.setEnabled(true); 
            // Habilita o botão 'btnAtualizar', permitindo que o usuário atualize os dados após carregar a foto.
        } catch (Exception e) { 
            // Caso ocorra um erro ao carregar a foto.
            
            System.out.println("Não foi possível copiar o arquivo."); 
            // Imprime uma mensagem de erro caso ocorra uma exceção.
        }
    }

    public static void removerFoto() { 
        // Método estático que remove a foto carregada, restaurando a imagem padrão.
        
        lblFoto.setIcon(new ImageIcon(new ImageIcon(InterfaceView.localViewFolder + "\\imagem-padrao.jpg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT))); 
        // Define a imagem padrão como ícone da label 'lblFoto'.
        
        nomeArquivoFoto = ""; 
        // Limpa o nome da foto carregada.
        
        btnAtualizar.setEnabled(true); 
        // Habilita o botão 'btnAtualizar', permitindo que o usuário atualize os dados mesmo sem foto.
        
        btnRemoverFoto.setEnabled(false); 
        // Desabilita o botão 'btnRemoverFoto' após remover a foto.
    }
}
