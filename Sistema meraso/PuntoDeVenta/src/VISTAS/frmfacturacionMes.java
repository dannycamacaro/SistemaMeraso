
package VISTAS;

import DATOS.vinstitucion;
import LOGICA.conexion;
import LOGICA.finstitucion;
import LOGICA.fsolicitud;
import static VISTAS.frmsolicitud.txtcodigoInstitucion;
import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;


public class frmfacturacionMes extends javax.swing.JInternalFrame {

    public frmfacturacionMes() {
        initComponents();
        comboInstituciones("instituciones", "nombreInstitucion");
        txtcodigoInstitucion.setVisible(false);
    }
    void comboInstituciones(String tabla, String nombrecol){
        fsolicitud func= new fsolicitud();
        Object[] nombre = func.instituciones();
        cbInstitucion.removeAllItems();
        for(int i=0;i<nombre.length;i++){
        cbInstitucion.addItem(nombre[i]);    
        }
   }

    void cargarCodigoInstitucion(String nombre) {
        try {
            DefaultTableModel modelo;
            finstitucion func = new finstitucion();
            vinstitucion dts = new vinstitucion();
            dts.setNombreInstitucion(nombre);
            modelo = func.codigoInstitucion(dts.getNombreInstitucion());
            txtcodigoInstitucion.setText(modelo.getValueAt(0, 0).toString());
        } catch (Exception e) {
            //JOptionPane.showConfirmDialog(rootPane, e);

        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblfechaDesde = new javax.swing.JLabel();
        lblInstitucion = new javax.swing.JLabel();
        jdfechaDesde = new com.toedter.calendar.JDateChooser();
        cbInstitucion = new javax.swing.JComboBox();
        jdfechaHasta = new com.toedter.calendar.JDateChooser();
        lblfechaHasta = new javax.swing.JLabel();
        txtcodigoInstitucion = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        btnmenu = new javax.swing.JButton();
        btnreporte = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(500, 240));
        setMinimumSize(new java.awt.Dimension(500, 240));
        setPreferredSize(new java.awt.Dimension(500, 240));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "REPORTE MENSUAL DE FACTURACION", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 14), new java.awt.Color(255, 0, 0))); // NOI18N
        jPanel1.setLayout(null);

        lblfechaDesde.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblfechaDesde.setText("DESDE:");
        jPanel1.add(lblfechaDesde);
        lblfechaDesde.setBounds(10, 90, 50, 30);

        lblInstitucion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblInstitucion.setText("INSTITUCION:");
        jPanel1.add(lblInstitucion);
        lblInstitucion.setBounds(10, 20, 90, 30);
        jPanel1.add(jdfechaDesde);
        jdfechaDesde.setBounds(60, 90, 170, 30);

        cbInstitucion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "DIURNO", "MATUTINO" }));
        cbInstitucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbInstitucionActionPerformed(evt);
            }
        });
        jPanel1.add(cbInstitucion);
        cbInstitucion.setBounds(10, 50, 450, 30);
        jPanel1.add(jdfechaHasta);
        jdfechaHasta.setBounds(290, 90, 170, 30);

        lblfechaHasta.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblfechaHasta.setText("HASTA:");
        jPanel1.add(lblfechaHasta);
        lblfechaHasta.setBounds(240, 90, 50, 30);

        txtcodigoInstitucion.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#"))));
        txtcodigoInstitucion.setText("0");
        txtcodigoInstitucion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(txtcodigoInstitucion);
        txtcodigoInstitucion.setBounds(430, 10, 40, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 50, 480, 150);

        jPanel2.setBackground(new java.awt.Color(0, 102, 153));
        jPanel2.setLayout(null);

        btnmenu.setBackground(new java.awt.Color(255, 255, 255));
        btnmenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ARCHIVOS/salida.png"))); // NOI18N
        btnmenu.setText("MENU");
        btnmenu.setToolTipText("IR A MENU");
        btnmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmenuActionPerformed(evt);
            }
        });
        jPanel2.add(btnmenu);
        btnmenu.setBounds(360, 0, 120, 50);

        btnreporte.setBackground(new java.awt.Color(255, 255, 255));
        btnreporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ARCHIVOS/impresora-3.png"))); // NOI18N
        btnreporte.setText("REPORTE");
        btnreporte.setToolTipText("IMPRIMIR REPORTE");
        btnreporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreporteActionPerformed(evt);
            }
        });
        jPanel2.add(btnreporte);
        btnreporte.setBounds(240, 0, 120, 50);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 490, 50);

        pack();
    }// </editor-fold>//GEN-END:initComponents
private Connection connection= new conexion().conectar();
    private void btnreporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreporteActionPerformed
        JOptionPane.showMessageDialog(rootPane, "Imprimiendo Reporte.");
            Calendar calendario1,calendario2;
            int d1, m1, a1,d2, m2, a2;
            calendario1 = jdfechaDesde.getCalendar();
            calendario2 = jdfechaHasta.getCalendar();
            d1 = calendario1.get(Calendar.DAY_OF_MONTH);
            m1 = calendario1.get(Calendar.MONTH);
            a1 = calendario1.get(Calendar.YEAR) - 1900;
            
            d2 = calendario2.get(Calendar.DAY_OF_MONTH);
            m2 = calendario2.get(Calendar.MONTH);
            a2 = calendario2.get(Calendar.YEAR) - 1900;
            
        Map p= new HashMap();
        p.put("codigoInstitucion",(Integer.parseInt(txtcodigoInstitucion.getText())));
        p.put("fechaDesde",(new Date(a1, m1, d1)));
        p.put("fechaHasta",(new Date(a2, m2, d2)));
        JasperReport report;
        JasperPrint print;
        try {
            report=JasperCompileManager.compileReport(new File("").getAbsolutePath()+
                "/src/REPORTES/rptInstitucionMes.jrxml");

            print=JasperFillManager.fillReport(report, p,connection);

            JasperViewer view= new JasperViewer(print, false);
            view.setTitle("Reporte de Instituciones por mes.");
            view.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnreporteActionPerformed

    private void btnmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmenuActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnmenuActionPerformed

    private void cbInstitucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbInstitucionActionPerformed
        Object dato = (String) cbInstitucion.getSelectedItem();
        String nombre = String.valueOf(dato);
        System.out.println();
        cargarCodigoInstitucion(nombre);
    }//GEN-LAST:event_cbInstitucionActionPerformed

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
            java.util.logging.Logger.getLogger(frmfacturacionMes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmfacturacionMes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmfacturacionMes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmfacturacionMes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmfacturacionMes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnmenu;
    private javax.swing.JButton btnreporte;
    private javax.swing.JComboBox cbInstitucion;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private com.toedter.calendar.JDateChooser jdfechaDesde;
    private com.toedter.calendar.JDateChooser jdfechaHasta;
    private javax.swing.JLabel lblInstitucion;
    private javax.swing.JLabel lblfechaDesde;
    private javax.swing.JLabel lblfechaHasta;
    private javax.swing.JFormattedTextField txtcodigoInstitucion;
    // End of variables declaration//GEN-END:variables
}
