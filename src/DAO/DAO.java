/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Trabalhador;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Antonio Joao Zimila
 */
public class DAO {
    public static void guardar(Trabalhador t) throws ClassNotFoundException{
        try {
            
    java.sql.Connection conn = Conexao.getConexao();
    Statement stmt = conn.createStatement();

       //String sqlSaver="INSERT INTO `processos_cdevcm`.`Trabalhador` (`id`, `Nome`, `Sector`, `Actividade`) VALUES ('"+t.getId()+"', '"+t.getNome()+"', '"+t.getLocalTrabalho()+"','"+t.getActividade()+"');";
       String sqlSaver="INSERT INTO `processos_cdevcm`.`Trabalhador2` (`Nome`, `Empresa`, `Funcao`,`Contrato`,`inicio`,`fim`) VALUES ('"+t.getNome()+"', '"+t.getEmpresa()+"','"+t.getFuncao()+"','"+t.getContrato()+"','"+t.getDataInicio()+"','"+t.getDataFim()+"');";
             stmt.executeUpdate(sqlSaver);
            
            Conexao.close(conn,stmt);
       // JOptionPane.showMessageDialog(null,"gravado com sucesso");
            
        } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null,"Não foi possivel gravar. "+ex);
        ex.printStackTrace();
        }
    } 
     
       public static List<Trabalhador> selecTudo() throws ClassNotFoundException{
        java.sql.Connection conn = Conexao.getConexao();
        String sqlSaver="SELECT * FROM `processos_cdevcm`.`Trabalhador2`";
      
       List<Trabalhador> t = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs =stmt.executeQuery(sqlSaver);
            while(rs.next()){
        t.add(new Trabalhador(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)));   
          
            }
            Conexao.close(conn,stmt,rs);
            return t;
        } catch (SQLException ex) {
      // ex.printStackTrace();
        }  
        return null;
    }
        public static void deletar(Trabalhador t) throws ClassNotFoundException{
     try {
          String sqlSaver="DELETE FROM `processos_cdevcm`.`Trabalhador2` WHERE (`id` = '"+t.getId()+"');";
          java.sql.Connection conn = Conexao.getConexao();
       
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sqlSaver);
            Conexao.close(conn,stmt);
          JOptionPane.showMessageDialog(null,"Removido com Sucesso.");
           } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Não foi possivel remover devido ao erro "+ex);
          }
    }
        public static void atualizar(Trabalhador t) throws ClassNotFoundException{
          try {
       String sqlSaver="UPDATE `processos_cdevcm`.`Trabalhador2` SET `Nome` = '"+t.getNome()+"',`Empresa` = '"+t.getEmpresa()+"',`Funcao` = '"+t.getFuncao()+"',`Contrato`='"+t.getContrato()+"',`Inicio` = '"+t.getDataInicio()+"',`Fim` = '"+t.getDataFim()+"' WHERE `id` = '"+t.getId()+"';";
        java.sql.Connection conn = Conexao.getConexao();
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(sqlSaver);
        Conexao.close(conn,stmt);
          JOptionPane.showMessageDialog(null,"Atualização feita com sucesso.");
        } catch (SQLException ex) {
       JOptionPane.showMessageDialog(null,"Não foi possivel atualizar.");
       System.out.println(ex);
    }    
    } 
}
