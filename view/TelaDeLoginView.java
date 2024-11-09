package view;
import controller.*;
import model.MySQLConnector;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;


import javax.swing.*;

public class TelaDeLoginView extends JFrame 
{
    public static JLabel labelLogin;
    public static JTextField textLogin;
    public static JLabel labelSenha;
    public static JPasswordField textSenha;
    public static JButton btnLogin;
    public static JLabel lblNotificacoes;


    public TelaDeLoginView(){
    

    super("tela De Login");
    setLayout(new FlowLayout());

    labelLogin = new JLabel("lOGIN");
    add(labelLogin);

    textLogin = new JTextField(10);
    add(textLogin);

    labelSenha = new JLabel("SENHA");
    add(labelSenha);

    textSenha = new JPasswordField(10);
    add(textSenha);

    btnLogin = new JButton("LOGAR");
    add(btnLogin);

    lblNotificacoes = new JLabel("Notificacoes");
    add(lblNotificacoes);

    ButtonHandler buttonHandler = new ButtonHandler();
    btnLogin.addActionListener(buttonHandler);
    

    textSenha.addKeyListener(
            new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent e) {
                    if (String.valueOf(textSenha.getPassword()).trim().length() > 0) {
                        if (e.getKeyCode() == 10) {
                            System.out.println("Você teclou Enter");
                            TelaDeLoginController.logarController();
                        }
                    }
                }
            }
        );
    }


   

    private class ButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event){
          TelaDeLoginController.logarController();
              
        }


    }

    
public static String setHtmlFormat(String txt) {
  return "<html><body>" + txt + "</body></html>";
}

public static void notificarUsuario(String strTexto) {
  lblNotificacoes.setText(setHtmlFormat(strTexto));
}
     
      
public static TelaDeLoginView appDeLoginView;

public static void main(String[] args) {

   appDeLoginView = new TelaDeLoginView();
   appDeLoginView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   appDeLoginView.setSize(150,200);
   appDeLoginView.setVisible(true);
}
}
