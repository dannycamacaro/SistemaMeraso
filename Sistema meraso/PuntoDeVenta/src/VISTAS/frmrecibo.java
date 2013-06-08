/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VISTAS;

import DATOS.vcaja;
import DATOS.vcontrol;
import DATOS.vdetalleSolicitud;
import DATOS.vfactura;
import LOGICA.conexion;
import LOGICA.fcaja;
import LOGICA.fcontrol;
import LOGICA.fdetalleSolicitud;
import LOGICA.ffactura;
import LOGICA.frecibo;
import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Time;
import java.text.DecimalFormat;
import java.text.NumberFormat;
//import java.time.Instant;
import java.util.Calendar;
//import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author user
 */
public class frmrecibo extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmrecibo
     */
    public frmrecibo() {
        initComponents();
        asignarFecha();
        AsignarIva();
        sizetable();
        nuevoNumeroControl();
        nuevoNumeroFactura();
        txtdescuento.setVisible(false);
        inhabilitarDatos();
    }
    /*
        variable  que evita la duplicidad de registros
    */
    public static boolean modificarRecibo=false;
    
    /*
        procedimiento que muestra los estudios agregados a la solicitud
    */
    public static void mostrarEstudiofrmRecibo2 (String numeroSolicitud){
        try {
            DefaultTableModel modelo;
            frecibo func= new frecibo();
            modelo=func.mostrarEstudioSolicitado(numeroSolicitud);
            frmrecibo.tbestudiosSolicitados.setModel(modelo);
            frmrecibo.txtsubTotal.setText(func.totalFactura.toString());
 
        } catch (Exception e) {
          //  JOptionPane.showConfirmDialog(rootPane, e);

        }
 }
    
    /*
        procedimiento que guarda los datos de la factura
    */
    private void guardarRecibo(){
        
        try {
            vfactura dts = new vfactura();
            ffactura funcion = new ffactura();

            Calendar c1 = Calendar.getInstance();
            int dia, mes, anio = 0;
            dia = c1.get(Calendar.DATE);
            mes = c1.get(Calendar.MONTH);
            anio = c1.get(Calendar.YEAR) - 1900;
            int hora, minutos, segundos, meridiano = 0;
            hora = c1.get(Calendar.HOUR);
            minutos = c1.get(Calendar.MINUTE);
            segundos = c1.get(Calendar.SECOND);

            dts.setNumeroFactura(Integer.parseInt(txtnumeroFactura.getText()));
            dts.setNumeroControl((txtnumeroControl.getText()));
            dts.setFecha(new Date(anio, mes, dia));
            dts.setHora(new Time(hora, minutos, segundos));
            dts.setRazonSocial(txtrasonSocial.getText());
            dts.setRifCedula(txtcedulaRif.getText());
            dts.setDireccion(txtdireccion.getText());
            dts.setTelefono(txttelefono.getText());
            dts.setIva(Double.parseDouble(txttotalIva.getText()));
            dts.setSubtotal(Double.parseDouble(txtsubTotal.getText()));
            dts.setTotal(Double.parseDouble(txttotal.getText()));
            dts.setDescuento(Double.parseDouble(txtdescuento.getText()));
            dts.setObservaciones(taobservaciones.getText());
            dts.setNumeroSolicitud(Integer.parseInt(txtnumeroSolicitud.getText()));
            dts.setAlicuota(Integer.parseInt(txtiva.getText()));

            funcion.insertar(dts);
                /*
                procedimiento de almacenar en caja
            */
            try {
                vcaja dtsCaja = new vcaja();
                fcaja funcionCaja = new fcaja();
                dtsCaja.setFecha(new Date(anio, mes, dia));
                dtsCaja.setTurno(frmsolicitud.lblturno.getText());
                dtsCaja.setTotalEstudio(Double.parseDouble(frmsolicitud.lbltotalFactura.getText()));
                dtsCaja.setCodigoSolicitud(Integer.parseInt(txtnumeroSolicitud.getText()));
                dtsCaja.setNombrePaciente(frmsolicitud.txtnombresPaciente.getText() + " " + frmsolicitud.txtapellidosPacientes.getText());
                funcionCaja.insertar(dtsCaja);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "Error al guardar la Solicitud en la caja.");
            }
        } catch (Exception e) {
        }
        
    }
    
    private void nuevoNumeroControl(){
        try {
            int codigo=0;
            frecibo funcion= new frecibo();
            codigo=funcion.asignarNumeroControl();
            codigo=codigo+1; 
            txtnumeroControl.setText(String.valueOf(codigo));
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, "Error al cargar el nuevo numero de control");
            JOptionPane.showConfirmDialog(rootPane, e);
        }
   }
    
    /*
        asignacion de impuesto
    */
    private void AsignarIva(){
        try {
            int iva=0;
            frecibo funcion= new frecibo();
            iva=funcion.asignarIva(); 
            txtiva.setText(String.valueOf(iva));
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, "Error al cargar el iva");
            JOptionPane.showConfirmDialog(rootPane, e);
        }
   }
    
    
    private void nuevoNumeroFactura(){
        try {
            int codigo=0;
            frecibo funcion= new frecibo();
            codigo=funcion.asignarNumeroFactura();
            codigo=codigo+1; 
            txtnumeroFactura.setText(String.valueOf(codigo));
            System.out.println(codigo);
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, "Error al cargar el nuevo numero de factura");
            JOptionPane.showConfirmDialog(rootPane, e);
        }
   }
    private void sizetable(){
        TableColumnModel columnModel = tbestudiosSolicitados.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(100);
        columnModel.getColumn(0).setMaxWidth(100);
        columnModel.getColumn(1).setPreferredWidth(700);
        columnModel.getColumn(1).setMaxWidth(700);
        columnModel.getColumn(2).setPreferredWidth(100);
        columnModel.getColumn(2).setMaxWidth(100);
    }
    
    
    
    public void calcularFactura(){
        Double totalIva,total,descuento,subtotal;
        Double iva;
        descuento=Double.parseDouble(txtdescuento.getText());
        DecimalFormat formato= new DecimalFormat("#.##");
        iva=Double.parseDouble(txtiva.getText());
        
        double temporaliva;
        subtotal=Double.parseDouble(txtsubTotal.getText());
        if (iva==0){
            totalIva=0.00;
        }
        else{
            iva=Double.parseDouble((txtiva.getText()));
            temporaliva=iva/100;
            totalIva=subtotal*temporaliva;
            
        }
        
        total=(subtotal+totalIva-descuento);
        txtsubTotal.setText(subtotal.toString());
        txttotalIva.setText(totalIva.toString());
        txttotal.setText(total.toString());
    }
    
    private void inhabilitarDatos(){
        txtnumeroControl.setEnabled(false);
        txtnumeroFactura.setEnabled(false);
        txtnumeroSolicitud.setEnabled(false);
        txtfecha.setEnabled(false);
        txthora.setEnabled(false);
        txtsubTotal.setEnabled(false);
        txttotalIva.setEnabled(false);
        txttotal.setEnabled(false);
    }
    private void asignarFecha(){
         Calendar c1= Calendar.getInstance();
         Calendar c2= new GregorianCalendar();
         String dia,mes,anio="";
         dia=Integer.toString(c1.get(Calendar.DATE));
         mes=Integer.toString(c1.get(Calendar.MONTH));
         anio=Integer.toString(c1.get(Calendar.YEAR));
         txtfecha.setText(dia+"/"+mes+"/"+anio);
         String hora,minutos,segundos,meridiano="";
         hora=Integer.toString(c1.get(Calendar.HOUR));
         minutos=Integer.toString(c1.get(Calendar.MINUTE));
         int meridianos= c1.get(Calendar.AM);
         if(c1.get(Calendar.AM_PM)==0){
          meridiano="A.M";     
         }
         else{
             meridiano="P.M";
         }
         txthora.setText(hora+":"+minutos+" "+meridiano);
    }
    
    private void asignarHora(){
      //  DateTime horaActual= new DateTime();
         
    }

    
//        private void mostrarEstudiofrmSolicitud (String numeroSolicitud){
//        try {
//            DefaultTableModel modelo;
//            fdetalleSolicitud func= new fdetalleSolicitud();
//            modelo=func.mostrarEstudioSolicitado(numeroSolicitud);
//            if (modelo==null){
//                return;
//            } else {
//                tbestudiosSolicitados.setModel(modelo);
//                sizetable();
//                lblsubTotal.setText(func.totalFactura.toString());
//                
//            }
//            
//            
//        } catch (Exception e) {
//            JOptionPane.showConfirmDialog(rootPane, e);
//
//        }
// }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lblcontacto1 = new javax.swing.JLabel();
        lblcodigo8 = new javax.swing.JLabel();
        txtcedulaRif = new javax.swing.JTextField();
        txttelefono = new javax.swing.JTextField();
        lblcodigo9 = new javax.swing.JLabel();
        lblcodigo10 = new javax.swing.JLabel();
        txtdireccion = new javax.swing.JTextField();
        txtrasonSocial = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbestudiosSolicitados = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        taobservaciones = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        lblcontacto7 = new javax.swing.JLabel();
        lblcontacto6 = new javax.swing.JLabel();
        lblcontacto8 = new javax.swing.JLabel();
        txtsubTotal = new javax.swing.JFormattedTextField();
        txttotalIva = new javax.swing.JFormattedTextField();
        txttotal = new javax.swing.JFormattedTextField();
        txtiva = new javax.swing.JFormattedTextField();
        lblcontacto9 = new javax.swing.JLabel();
        btncalcularFactura = new javax.swing.JButton();
        txtdescuento = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        btncancelar = new javax.swing.JButton();
        btnrecibo = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtnumeroFactura = new javax.swing.JTextField();
        txtnumeroControl = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtfecha = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txthora = new javax.swing.JTextField();
        txtnumeroSolicitud = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("RECIBO DE FACTURA");
        setMaximumSize(new java.awt.Dimension(700, 650));
        setMinimumSize(new java.awt.Dimension(700, 650));
        setPreferredSize(new java.awt.Dimension(700, 650));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "RECIBO DE CLIENTE", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 0, 0))); // NOI18N
        jPanel1.setLayout(null);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DETALLE DE FACTURACION", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 0, 0))); // NOI18N
        jPanel3.setLayout(null);

        lblcontacto1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblcontacto1.setText("RAZON SOCIAL");
        jPanel3.add(lblcontacto1);
        lblcontacto1.setBounds(10, 20, 100, 30);

        lblcodigo8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblcodigo8.setText("CEDULA / RIF");
        jPanel3.add(lblcodigo8);
        lblcodigo8.setBounds(10, 50, 90, 30);

        txtcedulaRif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcedulaRifActionPerformed(evt);
            }
        });
        txtcedulaRif.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcedulaRifKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcedulaRifKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcedulaRifKeyTyped(evt);
            }
        });
        jPanel3.add(txtcedulaRif);
        txtcedulaRif.setBounds(110, 50, 180, 30);

        txttelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttelefonoActionPerformed(evt);
            }
        });
        txttelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txttelefonoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txttelefonoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttelefonoKeyTyped(evt);
            }
        });
        jPanel3.add(txttelefono);
        txttelefono.setBounds(400, 50, 250, 30);

        lblcodigo9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblcodigo9.setText("TELEFONO");
        jPanel3.add(lblcodigo9);
        lblcodigo9.setBounds(340, 50, 80, 30);

        lblcodigo10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblcodigo10.setText("DIRECCION");
        jPanel3.add(lblcodigo10);
        lblcodigo10.setBounds(10, 80, 80, 30);

        txtdireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdireccionActionPerformed(evt);
            }
        });
        txtdireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtdireccionKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtdireccionKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdireccionKeyTyped(evt);
            }
        });
        jPanel3.add(txtdireccion);
        txtdireccion.setBounds(110, 80, 540, 30);

        txtrasonSocial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtrasonSocialFocusLost(evt);
            }
        });
        txtrasonSocial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtrasonSocialActionPerformed(evt);
            }
        });
        txtrasonSocial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtrasonSocialKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtrasonSocialKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtrasonSocialKeyTyped(evt);
            }
        });
        jPanel3.add(txtrasonSocial);
        txtrasonSocial.setBounds(110, 20, 540, 30);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(10, 20, 660, 120);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DETALLE DE FACTURA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 0, 0))); // NOI18N
        jPanel4.setLayout(null);

        tbestudiosSolicitados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbestudiosSolicitados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbestudiosSolicitadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbestudiosSolicitados);

        jPanel4.add(jScrollPane1);
        jScrollPane1.setBounds(12, 20, 640, 190);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel6.setLayout(null);

        taobservaciones.setColumns(20);
        taobservaciones.setRows(5);
        taobservaciones.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                taobservacionesKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(taobservaciones);

        jPanel6.add(jScrollPane2);
        jScrollPane2.setBounds(0, 30, 310, 60);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        jPanel2.setLayout(null);

        lblcontacto7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblcontacto7.setText("SUBTOTAL:");
        jPanel2.add(lblcontacto7);
        lblcontacto7.setBounds(10, 0, 80, 30);

        lblcontacto6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblcontacto6.setText("IVA:");
        jPanel2.add(lblcontacto6);
        lblcontacto6.setBounds(10, 30, 40, 30);

        lblcontacto8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblcontacto8.setText("TOTAL:");
        jPanel2.add(lblcontacto8);
        lblcontacto8.setBounds(10, 60, 50, 30);

        txtsubTotal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.##"))));
        txtsubTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel2.add(txtsubTotal);
        txtsubTotal.setBounds(80, 0, 109, 30);

        txttotalIva.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.##"))));
        txttotalIva.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel2.add(txttotalIva);
        txttotalIva.setBounds(80, 30, 109, 30);

        txttotal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.##"))));
        txttotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel2.add(txttotal);
        txttotal.setBounds(80, 60, 109, 30);

        txtiva.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#"))));
        txtiva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtivaActionPerformed(evt);
            }
        });
        jPanel2.add(txtiva);
        txtiva.setBounds(40, 30, 40, 30);

        jPanel6.add(jPanel2);
        jPanel2.setBounds(450, 0, 190, 90);

        lblcontacto9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblcontacto9.setText("OBSERVACION:");
        jPanel6.add(lblcontacto9);
        lblcontacto9.setBounds(0, 0, 100, 30);

        btncalcularFactura.setText("calcular");
        btncalcularFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncalcularFacturaActionPerformed(evt);
            }
        });
        jPanel6.add(btncalcularFactura);
        btncalcularFactura.setBounds(360, 60, 90, 30);

        txtdescuento.setText("0");
        jPanel6.add(txtdescuento);
        txtdescuento.setBounds(310, 0, 50, 30);

        jPanel4.add(jPanel6);
        jPanel6.setBounds(10, 210, 640, 100);

        jPanel1.add(jPanel4);
        jPanel4.setBounds(10, 140, 660, 330);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 130, 680, 480);

        jPanel7.setBackground(new java.awt.Color(0, 102, 153));
        jPanel7.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel7.setLayout(null);

        btncancelar.setBackground(new java.awt.Color(255, 255, 255));
        btncancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ARCHIVOS/flecha-de-volver.png"))); // NOI18N
        btncancelar.setText("VOLVER\n");
        btncancelar.setToolTipText("VOLVER ATRAS");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });
        jPanel7.add(btncancelar);
        btncancelar.setBounds(540, 0, 140, 50);

        btnrecibo.setBackground(new java.awt.Color(255, 255, 255));
        btnrecibo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ARCHIVOS/impresora-3.png"))); // NOI18N
        btnrecibo.setText("RECIBO");
        btnrecibo.setToolTipText("IMPRIMIR REGISTRO");
        btnrecibo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreciboActionPerformed(evt);
            }
        });
        jPanel7.add(btnrecibo);
        btnrecibo.setBounds(0, 0, 150, 50);

        getContentPane().add(jPanel7);
        jPanel7.setBounds(0, 0, 860, 50);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATOS DE FACTURA", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 14), new java.awt.Color(255, 0, 0))); // NOI18N
        jPanel8.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("# FACTURA");
        jPanel8.add(jLabel1);
        jLabel1.setBounds(30, 20, 90, 20);

        txtnumeroFactura.setText(" ");
        txtnumeroFactura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnumeroFacturaKeyTyped(evt);
            }
        });
        jPanel8.add(txtnumeroFactura);
        txtnumeroFactura.setBounds(30, 40, 90, 30);

        txtnumeroControl.setText(" ");
        txtnumeroControl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnumeroControlKeyTyped(evt);
            }
        });
        jPanel8.add(txtnumeroControl);
        txtnumeroControl.setBounds(150, 40, 90, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("# CONTROL");
        jPanel8.add(jLabel2);
        jLabel2.setBounds(150, 20, 90, 20);

        txtfecha.setText(" ");
        jPanel8.add(txtfecha);
        txtfecha.setBounds(390, 40, 130, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("FECHA");
        jPanel8.add(jLabel3);
        jLabel3.setBounds(390, 20, 120, 20);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("HORA");
        jPanel8.add(jLabel4);
        jLabel4.setBounds(550, 20, 110, 20);

        txthora.setText(" ");
        jPanel8.add(txthora);
        txthora.setBounds(550, 40, 110, 30);

        txtnumeroSolicitud.setText(" ");
        txtnumeroSolicitud.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnumeroSolicitudKeyTyped(evt);
            }
        });
        jPanel8.add(txtnumeroSolicitud);
        txtnumeroSolicitud.setBounds(270, 40, 90, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("# SOLICITUD");
        jPanel8.add(jLabel5);
        jLabel5.setBounds(270, 20, 90, 20);

        getContentPane().add(jPanel8);
        jPanel8.setBounds(0, 50, 680, 80);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtcedulaRifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcedulaRifActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcedulaRifActionPerformed

    private void txtcedulaRifKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcedulaRifKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcedulaRifKeyPressed

    private void txtcedulaRifKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcedulaRifKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcedulaRifKeyReleased

    private void txttelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttelefonoActionPerformed

    private void txttelefonoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttelefonoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttelefonoKeyPressed

    private void txttelefonoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttelefonoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txttelefonoKeyReleased

    private void txtdireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdireccionActionPerformed

    private void txtdireccionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdireccionKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdireccionKeyPressed

    private void txtdireccionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdireccionKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdireccionKeyReleased

    private void txtrasonSocialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtrasonSocialFocusLost
        // TODO add your handling code here:

 

        //encontrarPaciente(cedula);
    }//GEN-LAST:event_txtrasonSocialFocusLost

    private void txtrasonSocialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtrasonSocialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtrasonSocialActionPerformed

    private void txtrasonSocialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtrasonSocialKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtrasonSocialKeyPressed

    private void txtrasonSocialKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtrasonSocialKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtrasonSocialKeyReleased

    private void tbestudiosSolicitadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbestudiosSolicitadosMouseClicked
        // TODO add your handling code here:

     
    }//GEN-LAST:event_tbestudiosSolicitadosMouseClicked

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();

    }//GEN-LAST:event_btncancelarActionPerformed

    private void btnreciboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreciboActionPerformed
        if (modificarRecibo==false){
            try {
                guardarRecibo();
                try {
                    fcontrol func = new fcontrol();
                    vcontrol dts1 = new vcontrol();

                    dts1.setNumeroControl(Long.valueOf(txtnumeroControl.getText()));
                    dts1.setFactura(Integer.parseInt(txtnumeroFactura.getText()));
                    func.incrementarNumeroControlfch(dts1);
                    JOptionPane.showMessageDialog(rootPane, "Registro Almacenado, Imprimiendo Factura!");
                    // codigo de imprimir
                    Map p = new HashMap();
                    p.put("numeroFactura", Integer.parseInt(txtnumeroFactura.getText()));
                    JasperReport report;
                    JasperPrint print;

                    try {
                        report = JasperCompileManager.compileReport(new File("").getAbsolutePath()
                                + "/src/REPORTES/rptFactura.jrxml");

                        print = JasperFillManager.fillReport(report, p, connection);
                        //esta linea es nueva
                        JasperPrintManager.printReport(print, false);

                    } catch (Exception e) {
                        e.printStackTrace();
                        return;
                    }
                } catch (Exception e) {

                }

            } catch (Exception e) {
                //System.out.println(e);
            }
        }
                                              

        
        modificarRecibo=false;
        frmsolicitud.btncancelar.setEnabled(false);
        
    }//GEN-LAST:event_btnreciboActionPerformed
    private Connection connection= new conexion().conectar();   
    private void btncalcularFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncalcularFacturaActionPerformed
        // TODO add your handling code here:
        calcularFactura();
        sizetable();
    }//GEN-LAST:event_btncalcularFacturaActionPerformed

    private void txtnumeroFacturaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnumeroFacturaKeyTyped
        Character c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            evt.setKeyChar(Character.toUpperCase(c));
        }
    }//GEN-LAST:event_txtnumeroFacturaKeyTyped

    private void txtnumeroControlKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnumeroControlKeyTyped
        Character c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            evt.setKeyChar(Character.toUpperCase(c));
        }
    }//GEN-LAST:event_txtnumeroControlKeyTyped

    private void txtnumeroSolicitudKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnumeroSolicitudKeyTyped
        Character c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            evt.setKeyChar(Character.toUpperCase(c));
        }
    }//GEN-LAST:event_txtnumeroSolicitudKeyTyped

    private void txtrasonSocialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtrasonSocialKeyTyped
        Character c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            evt.setKeyChar(Character.toUpperCase(c));
        }
    }//GEN-LAST:event_txtrasonSocialKeyTyped

    private void txtcedulaRifKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcedulaRifKeyTyped
        Character c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            evt.setKeyChar(Character.toUpperCase(c));
        }
    }//GEN-LAST:event_txtcedulaRifKeyTyped

    private void txttelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttelefonoKeyTyped
        Character c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            evt.setKeyChar(Character.toUpperCase(c));
        }
    }//GEN-LAST:event_txttelefonoKeyTyped

    private void txtdireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdireccionKeyTyped
        Character c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            evt.setKeyChar(Character.toUpperCase(c));
        }
    }//GEN-LAST:event_txtdireccionKeyTyped

    private void taobservacionesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_taobservacionesKeyTyped
        Character c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            evt.setKeyChar(Character.toUpperCase(c));
        }
    }//GEN-LAST:event_taobservacionesKeyTyped

    private void txtivaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtivaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtivaActionPerformed

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
            java.util.logging.Logger.getLogger(frmrecibo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmrecibo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmrecibo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmrecibo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmrecibo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btncalcularFactura;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btnrecibo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblcodigo10;
    private javax.swing.JLabel lblcodigo8;
    private javax.swing.JLabel lblcodigo9;
    private javax.swing.JLabel lblcontacto1;
    private javax.swing.JLabel lblcontacto6;
    private javax.swing.JLabel lblcontacto7;
    private javax.swing.JLabel lblcontacto8;
    private javax.swing.JLabel lblcontacto9;
    public static javax.swing.JTextArea taobservaciones;
    public static javax.swing.JTable tbestudiosSolicitados;
    public static javax.swing.JTextField txtcedulaRif;
    private javax.swing.JTextField txtdescuento;
    public static javax.swing.JTextField txtdireccion;
    public static javax.swing.JTextField txtfecha;
    public static javax.swing.JTextField txthora;
    public static javax.swing.JFormattedTextField txtiva;
    public static javax.swing.JTextField txtnumeroControl;
    public static javax.swing.JTextField txtnumeroFactura;
    public static javax.swing.JTextField txtnumeroSolicitud;
    public static javax.swing.JTextField txtrasonSocial;
    public static javax.swing.JFormattedTextField txtsubTotal;
    public static javax.swing.JTextField txttelefono;
    public static javax.swing.JFormattedTextField txttotal;
    public static javax.swing.JFormattedTextField txttotalIva;
    // End of variables declaration//GEN-END:variables
}
