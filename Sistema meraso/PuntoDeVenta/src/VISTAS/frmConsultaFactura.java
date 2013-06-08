/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VISTAS;

import LOGICA.ffactura;
import static VISTAS.frmmenu.escritorio;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author user
 */
public class frmConsultaFactura extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmConsultaFactura
     */
    public frmConsultaFactura() {
        initComponents();
    }

    private void mostrar (String parametro,String buscar){
        try {
            DefaultTableModel modelo;
            String valor;
            String valorfinal;
            valorfinal="";
            valor= cbparametro.getSelectedItem().toString();
            if (valor=="RIF/CEDULA"){
                valorfinal="rifCedula";
            }
            if (valor=="#FACTURA"){
                valorfinal="numeroFactura";
            }
            ffactura func= new ffactura();
            modelo=func.mostrarFacturaDePaciente(valorfinal,buscar);
            tbFactura.setModel(modelo);
            lblTotal.setText(""+ Integer.toString(func.totalRegistros));   
            sizetable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Error al cargar los registros en la tabla");
            JOptionPane.showMessageDialog(rootPane, e);

        }
 }
    
    
    private void sizetable(){
        try {
            TableColumnModel columnModel = tbFactura.getColumnModel();
            columnModel.getColumn(0).setPreferredWidth(150);
            columnModel.getColumn(0).setMaxWidth(150);
            columnModel.getColumn(1).setPreferredWidth(700);
            columnModel.getColumn(1).setMaxWidth(700);
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
        tbFactura = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        panel2 = new java.awt.Panel();
        btnmenu = new javax.swing.JButton();
        lblparametro = new javax.swing.JLabel();
        cbparametro = new javax.swing.JComboBox();
        btnbuscar = new javax.swing.JButton();
        txtbuscar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CONSULTA DE  FACTURA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 14), new java.awt.Color(255, 0, 0))); // NOI18N
        jPanel1.setMaximumSize(new java.awt.Dimension(960, 450));
        jPanel1.setMinimumSize(new java.awt.Dimension(960, 450));
        jPanel1.setLayout(null);

        tbFactura.setModel(new javax.swing.table.DefaultTableModel(
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
        tbFactura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbFacturaMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbFacturaMousePressed(evt);
            }
        });
        jScrollPane4.setViewportView(tbFactura);

        jPanel1.add(jScrollPane4);
        jScrollPane4.setBounds(10, 30, 700, 360);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("TOTAL DE REGISTROS:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(470, 390, 140, 30);

        lblTotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(255, 0, 0));
        lblTotal.setText("0");
        jPanel1.add(lblTotal);
        lblTotal.setBounds(620, 390, 90, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 80, 720, 420);

        panel2.setBackground(new java.awt.Color(0, 102, 153));
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
        btnmenu.setBounds(580, 0, 130, 50);

        lblparametro.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblparametro.setForeground(new java.awt.Color(255, 255, 255));
        lblparametro.setText("PARAMETRO DE BUSQUEDA");
        panel2.add(lblparametro);
        lblparametro.setBounds(10, 20, 180, 30);

        cbparametro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "RIF/CEDULA", "#FACTURA" }));
        cbparametro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbparametroActionPerformed(evt);
            }
        });
        panel2.add(cbparametro);
        cbparametro.setBounds(190, 20, 260, 30);

        btnbuscar.setBackground(new java.awt.Color(255, 255, 255));
        btnbuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ARCHIVOS/buscar.png"))); // NOI18N
        btnbuscar.setToolTipText("IR A MENU");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });
        panel2.add(btnbuscar);
        btnbuscar.setBounds(510, 0, 65, 50);

        getContentPane().add(panel2);
        panel2.setBounds(0, 0, 1000, 50);

        txtbuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtbuscarMousePressed(evt);
            }
        });
        txtbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuscarActionPerformed(evt);
            }
        });
        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtbuscarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtbuscarKeyTyped(evt);
            }
        });
        getContentPane().add(txtbuscar);
        txtbuscar.setBounds(10, 50, 710, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbFacturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbFacturaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbFacturaMouseClicked

    private void tbFacturaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbFacturaMousePressed
    
        if (evt.getClickCount()==2){
            
            frmrecibo form = new frmrecibo();
            escritorio.add(form);
            form.toFront();
            form.setSize(700, 650);
            form.setVisible(true);
            try {
                int fila =tbFactura.rowAtPoint(evt.getPoint());
                frmrecibo.txtnumeroFactura.setText(tbFactura.getValueAt(fila, 0).toString());
                frmrecibo.txtnumeroControl.setText(tbFactura.getValueAt(fila, 1).toString());
                frmrecibo.txtfecha.setText(tbFactura.getValueAt(fila, 2).toString());
                frmrecibo.txthora.setText(tbFactura.getValueAt(fila, 3).toString());
                frmrecibo.txtrasonSocial.setText(tbFactura.getValueAt(fila, 4).toString());
                frmrecibo.txtcedulaRif.setText(tbFactura.getValueAt(fila, 5).toString());
                frmrecibo.txtdireccion.setText(tbFactura.getValueAt(fila, 6).toString());
                frmrecibo.txttelefono.setText(tbFactura.getValueAt(fila, 7).toString());
                frmrecibo.txttotalIva.setText(tbFactura.getValueAt(fila, 8).toString());
                frmrecibo.txtsubTotal.setText(tbFactura.getValueAt(fila, 9).toString());
                frmrecibo.txttotal.setText(tbFactura.getValueAt(fila, 10).toString());
                //frmrecibo.txtdescuento.setText(tbFactura.getValueAt(fila, 11).toString());
                frmrecibo.taobservaciones.setText(tbFactura.getValueAt(fila, 12).toString());
                frmrecibo.txtnumeroSolicitud.setText(tbFactura.getValueAt(fila, 13).toString());
                frmrecibo.txtiva.setText(tbFactura.getValueAt(fila, 14).toString());
                frmrecibo.mostrarEstudiofrmRecibo2(tbFactura.getValueAt(fila, 13).toString());
                frmrecibo.modificarRecibo=true;
            } catch (Exception e) {

            }

        }
    }//GEN-LAST:event_tbFacturaMousePressed

    private void btnmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmenuActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnmenuActionPerformed

    private void cbparametroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbparametroActionPerformed
        // TODO add your handling code here:

        mostrar("","");
        System.out.println(cbparametro.getSelectedItem().toString());
    }//GEN-LAST:event_cbparametroActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        // TODO add your handling code here:
        String dato="";
        dato=txtbuscar.getText();
        mostrar(cbparametro.getSelectedItem().toString(),dato);
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void txtbuscarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtbuscarMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbuscarMousePressed

    private void txtbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbuscarActionPerformed

    private void txtbuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyPressed

    }//GEN-LAST:event_txtbuscarKeyPressed

    private void txtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyReleased

    }//GEN-LAST:event_txtbuscarKeyReleased

    private void txtbuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyTyped
        Character c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            evt.setKeyChar(Character.toUpperCase(c));
        }
    }//GEN-LAST:event_txtbuscarKeyTyped

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
            java.util.logging.Logger.getLogger(frmConsultaFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmConsultaFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmConsultaFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmConsultaFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmConsultaFactura().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btnmenu;
    private javax.swing.JComboBox cbparametro;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblparametro;
    private java.awt.Panel panel2;
    public static javax.swing.JTable tbFactura;
    public static javax.swing.JTextField txtbuscar;
    // End of variables declaration//GEN-END:variables
}
