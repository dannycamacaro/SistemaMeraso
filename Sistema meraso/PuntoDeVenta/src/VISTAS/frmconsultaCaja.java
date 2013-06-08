/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VISTAS;

import DATOS.vcaja;
import LOGICA.fcaja;
import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author user
 */
public class frmconsultaCaja extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmconsultaCaja
     */
    public frmconsultaCaja() {
        initComponents();
        asignarFecha();
        btnconsulta.doClick();
    }
    
    public int codigoSolicitud=0;

    private void mostrar (Date fecha){
        try {
            DefaultTableModel modelo;
        
            fcaja func= new fcaja();
            modelo=func.mostrarCajaDelDia(fecha);
            tbcaja.setModel(modelo);
            lblTotal.setText(""+ Integer.toString(func.totalRegistros));   
            sizetable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Error al cargar los registros en la tabla");
            JOptionPane.showMessageDialog(rootPane, e);

        }
 }
    
    
     private void asignarFecha() {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = new GregorianCalendar();
        int dia, mes, anio = 0;
        dia = c1.get(Calendar.DATE);
        mes = c1.get(Calendar.MONTH);
        anio = c1.get(Calendar.YEAR) - 1900;
        Date fechaActual = new Date(anio, mes, dia);
        jdfecha.setDate(fechaActual);

    }
    private void sizetable(){
        try {
            TableColumnModel columnModel = tbcaja.getColumnModel();
            columnModel.getColumn(0).setPreferredWidth(150);
            columnModel.getColumn(0).setMaxWidth(150);
            columnModel.getColumn(1).setPreferredWidth(200);
            columnModel.getColumn(1).setMaxWidth(200);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Error al ajustar la tabla");
            JOptionPane.showMessageDialog(rootPane, e);
        }
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbcaja = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        panel2 = new java.awt.Panel();
        btnmenu = new javax.swing.JButton();
        lblnombre = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        btnconsulta = new javax.swing.JButton();
        jdfecha = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(920, 590));
        setMinimumSize(new java.awt.Dimension(920, 590));
        setPreferredSize(new java.awt.Dimension(920, 590));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CONSULTA DE CAJA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 14), new java.awt.Color(255, 0, 0))); // NOI18N
        jPanel1.setMaximumSize(new java.awt.Dimension(960, 450));
        jPanel1.setMinimumSize(new java.awt.Dimension(960, 450));
        jPanel1.setLayout(null);

        tbcaja.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "CODIGO", "NOMBRE"
            }
        ));
        tbcaja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbcajaMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbcajaMousePressed(evt);
            }
        });
        jScrollPane4.setViewportView(tbcaja);

        jPanel1.add(jScrollPane4);
        jScrollPane4.setBounds(10, 20, 870, 450);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("TOTAL DE REGISTROS:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(700, 470, 140, 30);

        lblTotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(255, 0, 0));
        lblTotal.setText("0");
        jPanel1.add(lblTotal);
        lblTotal.setBounds(850, 470, 90, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 60, 900, 500);

        panel2.setBackground(new java.awt.Color(0, 102, 153));
        panel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panel2.setLayout(null);

        btnmenu.setBackground(new java.awt.Color(255, 255, 255));
        btnmenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ARCHIVOS/salida.png"))); // NOI18N
        btnmenu.setText("MENU");
        btnmenu.setToolTipText("IR A MENU");
        btnmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmenuActionPerformed(evt);
            }
        });
        panel2.add(btnmenu);
        btnmenu.setBounds(770, 0, 130, 50);

        lblnombre.setBackground(new java.awt.Color(255, 255, 255));
        lblnombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblnombre.setForeground(new java.awt.Color(255, 255, 255));
        lblnombre.setText("FECHA");
        panel2.add(lblnombre);
        lblnombre.setBounds(20, 20, 60, 30);

        btnEliminar.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ARCHIVOS/cubo-de-basura.png"))); // NOI18N
        btnEliminar.setToolTipText("MODIFICAR REGISTROS");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        panel2.add(btnEliminar);
        btnEliminar.setBounds(720, 0, 50, 50);

        btnconsulta.setBackground(new java.awt.Color(255, 255, 255));
        btnconsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ARCHIVOS/presentacion-de-informes.png"))); // NOI18N
        btnconsulta.setToolTipText("CANCELAR MODIFICACION");
        btnconsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnconsultaActionPerformed(evt);
            }
        });
        panel2.add(btnconsulta);
        btnconsulta.setBounds(250, 10, 50, 50);
        panel2.add(jdfecha);
        jdfecha.setBounds(70, 20, 180, 30);

        getContentPane().add(panel2);
        panel2.setBounds(0, 0, 1060, 60);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbcajaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbcajaMouseClicked
         try {
               int fila =tbcaja.rowAtPoint(evt.getPoint());   
                    codigoSolicitud=Integer.parseInt(tbcaja.getValueAt(fila, 0).toString());
            } catch (Exception e) {

            }
    }//GEN-LAST:event_tbcajaMouseClicked

    private void tbcajaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbcajaMousePressed
        // TODO add your handling code here:
       
           
        
    }//GEN-LAST:event_tbcajaMousePressed

    private void btnmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmenuActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnmenuActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int confirmacion = JOptionPane.showConfirmDialog(rootPane, "Seguro que quiere eliminar este registro?", "Confirmar", 2);

            if (confirmacion == 0) {
                try {

                    fcaja func = new fcaja();
                    vcaja dts = new vcaja();
                    System.out.println(codigoSolicitud);
                    dts.setCodigoSolicitud(codigoSolicitud);
                    boolean resultado = func.eliminar(dts);
                    if (resultado == true) {
                        JOptionPane.showMessageDialog(rootPane, "Registro eliminado exitosamente.");
                    }

                    btnconsulta.doClick();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(rootPane, "No se ha podido eliminar el registro");
                }

            }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnconsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconsultaActionPerformed
        
            /*
             CODIGO DEL CALENDARIO
             */
            Calendar calendario;
            int d, m, a;
            calendario = jdfecha.getCalendar();
            d = calendario.get(Calendar.DAY_OF_MONTH);
            m = calendario.get(Calendar.MONTH);
            a = calendario.get(Calendar.YEAR) - 1900;
            if(d!=0 && m!=0 && a!=0){
               mostrar(new Date(a,m,d));
            }
         
    }//GEN-LAST:event_btnconsultaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmconsultaCaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmconsultaCaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmconsultaCaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmconsultaCaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmconsultaCaja().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnconsulta;
    private javax.swing.JButton btnmenu;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane4;
    private com.toedter.calendar.JDateChooser jdfecha;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblnombre;
    private java.awt.Panel panel2;
    public static javax.swing.JTable tbcaja;
    // End of variables declaration//GEN-END:variables
}
