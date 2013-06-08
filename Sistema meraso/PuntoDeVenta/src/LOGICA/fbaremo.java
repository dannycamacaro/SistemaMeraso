/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LOGICA;

import DATOS.vestudiosInstitucion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class fbaremo {
    
    private conexion mysql= new conexion();
    private Connection cn=mysql.conectar();
    private String sentenciaSQL="";
    public int totalRegistros;
    
    
    
    public DefaultTableModel mostrarBaremoInstitucion (String codigoInstitucion,String categoria){
        DefaultTableModel modelo;
        String [] titulos ={"NUMERO ESTUDIO","NOMBRE","PRECIO"};
        String [] registros = new String[3];
        totalRegistros=0;
        modelo= new DefaultTableModel(null,titulos);
        
            sentenciaSQL="SELECT numeroEstudio, nombre, precios FROM estudioinstitucion "
                    + "where codigoOrganizacion ='"+codigoInstitucion+"' and  categoria= '"+categoria+"' ORDER BY nombre";
        try {
           Statement st=cn.createStatement();
           ResultSet rs=st.executeQuery(sentenciaSQL);
           
           while (rs.next()){
               registros[0]=rs.getString("numeroEstudio");
               registros[1]=rs.getString("nombre");
               registros[2]=rs.getString("precios");
               totalRegistros=totalRegistros+1;
               modelo.addRow(registros);
                       
           }
           return modelo;
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return modelo;
        }
         
    }
    public boolean modificar (vestudiosInstitucion dts){
        
        sentenciaSQL="UPDATE estudioinstitucion set  nombre=?, precios=? where numeroEstudio=?";
        try {

            PreparedStatement pst=cn.prepareStatement(sentenciaSQL);
            
            pst.setString(1, dts.getNombre());
            pst.setDouble(2, dts.getPrecios());
            pst.setInt(3, dts.getNumeroEstudio());
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
      
}
