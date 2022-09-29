/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Antonio Joao Zimila
 */
public class Conexao {
    public static java.sql.Connection getConexao() throws ClassNotFoundException{
    String URL   ="jdbc:mysql://localhost:3306/processos_cdevcm";
  //String URL   ="jdbc:mysql://sql5.freesqldatabase.com/sql5521610";
    String user  ="root";
    String senha ="";
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        java.sql.Connection conection =DriverManager.getConnection(URL,user,senha);
        return conection;
    } catch (SQLException ex) {
   JOptionPane.showMessageDialog(null,"Conexão falhou, por favor ligue a internet. "+ex);
    }
    return null;
}
    public static void close(java.sql.Connection conection){
    
          try {
              if(conection!=null)
              conection.close();
              
          } catch (SQLException ex) {
            ex.printStackTrace();
          }
      } 
    public static void close(java.sql.Connection conection,Statement stmt){ 
      close(conection);
      try {
              if(stmt!=null)
              stmt.close();
              
          } catch (SQLException ex) {
            ex.printStackTrace();
          }
}
    public static void close(java.sql.Connection conection,Statement stmt,ResultSet rs){
  close(conection,stmt);  
  try {
              if(rs!=null)
              rs.close();
              
          } catch (SQLException ex) {
            ex.printStackTrace();
          }
}
    
}
