/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LOGICA;

import DATOS.Vlogin;
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
public class flogin {
    
    private conexion mysql= new conexion();
    private Connection cn=mysql.conectar();
    private String sentenciaSQL="";
    public int totalRegistros;
    
    /*
        Procedimiento que recibe una cadena de texto y busca los resultados
        que coincida y los almacena de una tabla en memoria
    */
    
    public DefaultTableModel verificarUsurio (String nombre, String clave){
        DefaultTableModel modelo;
        
        String [] titulos ={"CODIGO","NOMBRE","CLAVE","PRIVILEGIOS"};
        String [] registros = new String[4];
        totalRegistros=0;
        modelo= new DefaultTableModel(null,titulos);
        //sentenciaSQL="select codigoUsuario, nombre, clave, privilegio from usuario where nombre like '%"+ nombre +"%' and clave like '%"+ clave +"%'";
        sentenciaSQL="select codigoUsuario, nombre, clave, privilegio from usuario where nombre='"+nombre+"' and clave='"+clave+"'";
        System.out.println(sentenciaSQL.toString());
        
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
               System.out.println(modelo);
                       
           }
           return modelo;
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
         
    }
   
        public DefaultTableModel mostrar (String buscar){
        DefaultTableModel modelo;
        String [] titulos ={"CODIGO","NOMBRE","CLAVE","PRIVILEGIOS"};
        String [] registros = new String[4];
        totalRegistros=0;
        modelo= new DefaultTableModel(null,titulos);
            sentenciaSQL="select codigoUsuario, nombre, clave, privilegio from usuario where nombre like '%"+ buscar +"%'";
        try {
           Statement st=cn.createStatement();
           ResultSet rs=st.executeQuery(sentenciaSQL);
           
           while (rs.next()){
               registros[0]=rs.getString("codigoUsuario");
               System.out.println(registros[0].toString());
               registros[1]=rs.getString("nombre");
               System.out.println(registros[1].toString());
               registros[2]=rs.getString("clave");
               System.out.println(registros[2].toString());
               registros[3]=rs.getString("privilegio");
               
               totalRegistros=totalRegistros+1;
               
               modelo.addRow(registros);
               System.out.println(modelo);
                       
           }
           return modelo;
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
         
    }
   
}
