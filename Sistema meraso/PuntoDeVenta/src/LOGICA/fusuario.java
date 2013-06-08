/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LOGICA;

import DATOS.vusuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author danny camacaro
 */
public class fusuario {
    
    
    private conexion mysql= new conexion();
    private Connection cn=mysql.conectar();
    private String sentenciaSQL="";
    public int totalRegistros;
    
    public DefaultTableModel mostrar (String buscar){
        DefaultTableModel modelo;
        String [] titulos ={"CODIGO","USUARIO","CLAVE","PRIVILEGIOS"};
        String [] registros = new String[4];
        
        totalRegistros=0;
        modelo= new DefaultTableModel(null,titulos);
            sentenciaSQL="select * from usuario where codigoUsuario like '%"+ buscar +"%' order by codigoUsuario";
        
        try {
           Statement st=cn.createStatement();
           ResultSet rs=st.executeQuery(sentenciaSQL);
           
           while (rs.next()){
               registros[0]=rs.getString("codigoUsuario");
               registros[1]=rs.getString("nombre");
               registros[2]=rs.getString("clave");
               registros[3]=rs.getString("privilegio");
               totalRegistros=totalRegistros+1;
               modelo.addRow(registros);
                       
           }
           return modelo;
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
         
    }
    
    public boolean insertar (vusuario dts){
        sentenciaSQL="insert into usuario (codigoUsuario,nombre,clave,privilegio)"+
                  "values(?,?,?,?)";
        try {

            PreparedStatement pst=cn.prepareStatement(sentenciaSQL);
            pst.setInt(1, dts.getCodigoUsuario());
            pst.setString(2, dts.getNombre());
            pst.setString(3, dts.getClave());
            pst.setString(4, dts.getPrivilegio());
            
            int n=pst.executeUpdate();
            
            if (n!=0){
                return true;
            }
            else{
                return false;
            }
                
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
        
    }
    
    public boolean modificar (vusuario dts){
        
        sentenciaSQL="update usuario set nombre=?,clave=?,privilegio=?   where codigoUsuario=?";
        try {

            PreparedStatement pst=cn.prepareStatement(sentenciaSQL);
            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getClave());
            pst.setString(3, dts.getPrivilegio());
            pst.setInt(4, dts.getCodigoUsuario());
            
            int n=pst.executeUpdate();
            
            if (n!=0){
                return true;
            }
            else{
                return false;
            }
                
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }
            
    public boolean eliminar (vusuario dts){
        sentenciaSQL="delete from usuario where codigoUsuario=?";
        try {

            PreparedStatement pst=cn.prepareStatement(sentenciaSQL);
            pst.setInt(1, dts.getCodigoUsuario());
            
            int n=pst.executeUpdate();
            
            if (n!=0){
                return true;
            }
            else{
                return false;
            } 
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }

     public Object[] combo(String tabla, String nombrecol){
      int registros = 0; 
      PreparedStatement pst=null;
      ResultSet rs=null;
      sentenciaSQL="select * from usuario";
      
      try{
          
         pst = cn.prepareStatement("SELECT count(*) as total FROM usuario");
         rs = pst.executeQuery();
         rs.next();
         registros = rs.getInt("total");
         rs.close();
      }catch(SQLException e){
         System.out.println(e);
      }

    Object[] datos = new Object[registros];
      try{
         pst = cn.prepareStatement(sentenciaSQL);
         rs = pst.executeQuery();
         int i = 0;
         while(rs.next()){
            datos[i] = rs.getObject("codigoUsuario");
            i++;
         }
         rs.close();
          }catch(SQLException e){
         System.out.println(e);
    }
    return datos;
 }

    
    
    
}
