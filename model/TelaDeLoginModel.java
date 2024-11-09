package model;

import controller.*;

import java.sql.*;
import java.util.*;

public class TelaDeLoginModel {
    public static ArrayList<String> logarModel(String login, String senha){
        ArrayList<String> resultados = new ArrayList<String>();
        resultados.add("resultado1");
        try{
            Connection conexao = MySQLConnector.conectar(); 
          String strdString = "select * from `db_senac`.`tbl_senac` where `email` = '" + login + "'and `senha` = '" + senha + "';";
      
          Statement stmSqlLogin = conexao.createStatement();
          ResultSet rstSqlLogin = stmSqlLogin.executeQuery(strdString);
          if  (rstSqlLogin.next()) { 
            TelaDeLoginController.notificarUsuario("Login realizado com sucesso");
           
      
          } else{
            TelaDeLoginController.notificarUsuario("Nao foi possivel encontrar o login e/ou senha digitados. por favor, verifique e tente novamente.");
      
          }
          stmSqlLogin.close();
        } catch (Exception e) {
          TelaDeLoginController.notificarUsuario("houve um problema e não será possivel realizar o login neste momento. por favor, tente novamente mais tarde");
            System.err.println("Ops! Deu ruim, se liga no erro" + e);
        }
        return resultados;

    }
    
}
