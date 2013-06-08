/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VISTAS;

import DATOS.vcaja;
import DATOS.vdetalleSolicitud;
import DATOS.vinstitucion;
import DATOS.vpaciente;
import DATOS.vsolicitud;
import LOGICA.conexion;
import LOGICA.fcaja;
import LOGICA.fdetalleSolicitud;
import LOGICA.finstitucion;
import LOGICA.frecibo;
import LOGICA.fsolicitud;
import static VISTAS.frmmenu.escritorio;
import static VISTAS.frmrecibo.txtfecha;
import static VISTAS.frmrecibo.txthora;
import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author user
 */
public class frmsolicitud extends javax.swing.JInternalFrame {
public boolean EstadoSolicitud=false;
    /**
     * Creates new form frmsolicitud
     */
    public frmsolicitud() {
        initComponents();
        comboInstituciones("instituciones", "nombreInstitucion");
        asignarFecha();
        btnrecibo.setEnabled(false);
        btnetiqueta.setEnabled(false);
         sizetable();
    }
    public static void sizetable(){
            try {
            TableColumnModel columnModel = tbestudiosSolicitados.getColumnModel();
            columnModel.getColumn(0).setPreferredWidth(0);//codigo
            columnModel.getColumn(1).setPreferredWidth(0);//cedula
            columnModel.getColumn(2).setPreferredWidth(150);//nombre
            columnModel.getColumn(3).setPreferredWidth(600);//apellidos
            columnModel.getColumn(4).setPreferredWidth(150);//fecha nacimiento
        } catch (Exception e) {
         //   JOptionPane.showMessageDialog(rootPane, "Error al ajustar la tabla.");
        }
        
    }
    /*
        procedimiento de imprimir etiquetas
    */
    private void imprimirEtiquetas(){
        Map p = new HashMap();
        p.put("numeroSolicitud", Integer.parseInt(lblcodigoSolicitud.getText()));
        JasperReport report;
        JasperPrint print;
        try {
            report = JasperCompileManager.compileReport(new File("").getAbsolutePath()
                    + "/src/REPORTES/rptEtiquetas.jrxml");

            print = JasperFillManager.fillReport(report, p, connection);

            JasperViewer view = new JasperViewer(print, false);

            view.setTitle("Etiqueta de estudio");
            view.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    
    }
    
    /*
        VARIABLE QUE FUNCIONARA COMO UN MODIFICADOR PARA EVITAR LA MULTIPLICIDAD
    */
    public static boolean modificador=false;
    
    
    /*
        procedimiento que asigna la fecha actual y la hora
    */
    
        private void asignarFecha(){
         txtfechaSolicitud.setText("");
         Calendar c1= Calendar.getInstance();
         Calendar c2= new GregorianCalendar();
         String dia,mes,anio="";
         dia=Integer.toString(c1.get(Calendar.DATE));
         mes=Integer.toString(c1.get(Calendar.MONTH));
         anio=Integer.toString(c1.get(Calendar.YEAR));
         txtfechaSolicitud.setText(dia+"/"+mes+"/"+anio);
         String hora,minutos,meridiano="";
         hora=Integer.toString(c1.get(Calendar.HOUR));
         minutos=Integer.toString(c1.get(Calendar.MINUTE));
         
         if(c1.get(Calendar.AM_PM)==0){
          meridiano="A.M";   
          System.out.println(meridiano);
          lblturno.setText("DIURNO");
         }
         else{
             meridiano="P.M";
             lblturno.setText("MATUTINO");
             System.out.println(meridiano);
         }
         txthora.setText(hora+":"+minutos+" "+meridiano);
    }
    /*
        PROCEDIMIENTO QUE ASIGNA LA FECHA QUE HOY
    */
    private void vaciarTextos(){
        txtcedulaPaciente.setText("");
        txtapellidosPacientes.setText("");
        txtcodigoPaciente.setText("");
        txtnombresPaciente.setText("");
        txttelefonoPaciente.setText("");
        txtdireccionPaciente.setText("");
        txtnumeroReferencia.setText("");
    
    }

    private void nuevoCodigo(){
       int codigo=0;
       fsolicitud funcion= new fsolicitud();
       codigo=funcion.asignarCodigo();
       codigo=codigo+1; 
       lblcodigoSolicitud.setText(String.valueOf(codigo));
       System.out.println(codigo);
   }
    /*
        PROCEDIMIENTO QUE BUSCA AL PACIENTE EN LA BASE DE DATOS Y LO CARGA
        EN LOS CONTROLES DEL FORMULARIO.
    */
         void encontrarPaciente (String cedula){
             
             System.out.println("entro a encontrar paciente");
         try {
            DefaultTableModel modelo;
            fsolicitud func= new fsolicitud();
            modelo=func.EncontrarPaciente(cedula);
            
            txtcodigoDetalle.setText(modelo.getValueAt(0, 0).toString());
            txtcedulaPaciente.setText(modelo.getValueAt(0, 1).toString());
            txtnombresPaciente.setText(modelo.getValueAt(0, 2).toString());
            txtapellidosPacientes.setText(modelo.getValueAt(0, 3).toString());
            jdfechaNacimiento.setDateFormatString(modelo.getValueAt(0, 4).toString());
            txttelefonoPaciente.setText(modelo.getValueAt(0, 5).toString());
            txtdireccionPaciente.setText(modelo.getValueAt(0, 6).toString());
            if (modelo.getValueAt(0, 7).toString().equalsIgnoreCase("MASCULINO")){
                cbsexo.setSelectedIndex(0);
            }
            else{
                cbsexo.setSelectedIndex(1);
            }
                

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
            
        }
 }
    
    
        void cargarCodigoInstitucion(String nombre) {
        try {
            DefaultTableModel modelo;
            finstitucion func = new finstitucion();
            vinstitucion dts = new vinstitucion();
            dts.setNombreInstitucion(nombre);
            modelo = func.codigoInstitucion(dts.getNombreInstitucion());
            System.out.println(modelo.getValueAt(0, 0));
            txtcodigoInstitucion.setText(modelo.getValueAt(0, 0).toString());
        } catch (Exception e) {
            //JOptionPane.showConfirmDialog(rootPane, e);

        }
    }
        public static void mostrarEstudiofrmSolicitud (String numeroSolicitud){
        try {
            DefaultTableModel modelo;
            fdetalleSolicitud func= new fdetalleSolicitud();
            modelo=func.mostrarEstudioSolicitado(numeroSolicitud);
            tbestudiosSolicitados.setModel(modelo);
            
            NumberFormat df = NumberFormat.getCurrencyInstance();
            String totalEstudio=func.costoFactura;
            lbltotalFactura.setText(totalEstudio);
 
        } catch (Exception e) {
            

        }
 }
        
        private void mostrarEstudiofrmRecibo2 (String numeroSolicitud){
        try {
            DefaultTableModel modelo;
            frecibo func= new frecibo();
            modelo=func.mostrarEstudioSolicitado(numeroSolicitud);
            frmrecibo.tbestudiosSolicitados.setModel(modelo);
            frmrecibo.txtsubTotal.setText(func.totalFactura.toString());
 
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);

        }
 }
        
        
        private void GuardarSolicitud(){
            Calendar c1 = Calendar.getInstance();
            int dia, mes, anio = 0;
            dia = c1.get(Calendar.DATE);
            mes = c1.get(Calendar.MONTH);
            anio = c1.get(Calendar.YEAR) - 1900;
            try {
                vsolicitud dts = new vsolicitud();
                fsolicitud func = new fsolicitud();
                dts.setNumeroSolicitud(Integer.parseInt(lblcodigoSolicitud.getText()));
                dts.setFecha(new Date(anio, mes, dia));
                dts.setTurno(lblturno.getText());
                dts.setCodigoInstitucion(Integer.parseInt(txtcodigoInstitucion.getText()));
                dts.setCodigoPaciente(Integer.parseInt(txtcodigoPaciente.getText()));
                dts.setNumeroReferencia(txtnumeroReferencia.getText());

                func.insertar(dts);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "Error al guardar la Solicitud.");

            }
    }
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
        lblcedula = new javax.swing.JLabel();
        lblnombres = new javax.swing.JLabel();
        txtnombresPaciente = new javax.swing.JTextField();
        txtapellidosPacientes = new javax.swing.JTextField();
        lblapellidos = new javax.swing.JLabel();
        lbltelefono = new javax.swing.JLabel();
        txttelefonoPaciente = new javax.swing.JTextField();
        lblfechaNacimiento = new javax.swing.JLabel();
        txtdireccionPaciente = new javax.swing.JTextField();
        lbldireccion = new javax.swing.JLabel();
        lblsexo = new javax.swing.JLabel();
        cbsexo = new javax.swing.JComboBox();
        txtcedulaPaciente = new javax.swing.JTextField();
        jdfechaNacimiento = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        lblcontacto = new javax.swing.JLabel();
        txtcontactoOrganizacion = new javax.swing.JTextField();
        cbinstitucion = new javax.swing.JComboBox();
        lblcontacto3 = new javax.swing.JLabel();
        txtcodigoInstitucion = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbestudiosSolicitados = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        btnagregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btnrecibo = new javax.swing.JButton();
        btnetiqueta = new javax.swing.JButton();
        lbltotalFactura = new javax.swing.JLabel();
        lblcostoTotal = new javax.swing.JLabel();
        txtnumeroReferencia = new javax.swing.JTextField();
        lblnumeroReferencia = new javax.swing.JLabel();
        txtcodigoDetalle = new javax.swing.JTextField();
        lblcontacto12 = new javax.swing.JLabel();
        lblcontacto8 = new javax.swing.JLabel();
        lblturno = new javax.swing.JLabel();
        lblhora = new javax.swing.JLabel();
        lblfecha = new javax.swing.JLabel();
        lblsolicitud = new javax.swing.JLabel();
        lblcodigoSolicitud = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        btncancelar = new javax.swing.JButton();
        btnnuevo = new javax.swing.JButton();
        btnmenu = new javax.swing.JButton();
        txtfechaSolicitud = new javax.swing.JTextField();
        txthora = new javax.swing.JTextField();
        txtcodigoPaciente = new javax.swing.JTextField();
        lblcontacto9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SOLICITUD DE ESTUDIOS");
        setMaximumSize(new java.awt.Dimension(780, 560));
        setMinimumSize(new java.awt.Dimension(780, 560));
        setPreferredSize(new java.awt.Dimension(780, 560));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "SOLICITUD DE ESTUDIO", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 0, 0))); // NOI18N
        jPanel1.setLayout(null);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DETALLE DE PACIENTE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 0, 0))); // NOI18N
        jPanel3.setLayout(null);

        lblcedula.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblcedula.setText("CEDULA:");
        jPanel3.add(lblcedula);
        lblcedula.setBounds(10, 20, 70, 30);

        lblnombres.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblnombres.setText("NOMBRES:");
        jPanel3.add(lblnombres);
        lblnombres.setBounds(10, 60, 80, 30);

        txtnombresPaciente.setEnabled(false);
        txtnombresPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombresPacienteActionPerformed(evt);
            }
        });
        txtnombresPaciente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtnombresPacienteKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtnombresPacienteKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombresPacienteKeyTyped(evt);
            }
        });
        jPanel3.add(txtnombresPaciente);
        txtnombresPaciente.setBounds(90, 60, 280, 30);

        txtapellidosPacientes.setEnabled(false);
        txtapellidosPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtapellidosPacientesActionPerformed(evt);
            }
        });
        txtapellidosPacientes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtapellidosPacientesKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtapellidosPacientesKeyReleased(evt);
            }
        });
        jPanel3.add(txtapellidosPacientes);
        txtapellidosPacientes.setBounds(460, 60, 270, 30);

        lblapellidos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblapellidos.setText("APELLIDOS:");
        jPanel3.add(lblapellidos);
        lblapellidos.setBounds(380, 60, 80, 30);

        lbltelefono.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbltelefono.setText("TELEFONO:");
        jPanel3.add(lbltelefono);
        lbltelefono.setBounds(550, 20, 70, 30);

        txttelefonoPaciente.setEnabled(false);
        txttelefonoPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttelefonoPacienteActionPerformed(evt);
            }
        });
        txttelefonoPaciente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txttelefonoPacienteKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txttelefonoPacienteKeyReleased(evt);
            }
        });
        jPanel3.add(txttelefonoPaciente);
        txttelefonoPaciente.setBounds(620, 20, 110, 30);

        lblfechaNacimiento.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblfechaNacimiento.setText("FEC. NAC.:");
        jPanel3.add(lblfechaNacimiento);
        lblfechaNacimiento.setBounds(180, 20, 80, 30);

        txtdireccionPaciente.setEnabled(false);
        txtdireccionPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdireccionPacienteActionPerformed(evt);
            }
        });
        txtdireccionPaciente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtdireccionPacienteKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtdireccionPacienteKeyReleased(evt);
            }
        });
        jPanel3.add(txtdireccionPaciente);
        txtdireccionPaciente.setBounds(90, 100, 640, 30);

        lbldireccion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbldireccion.setText("DIRECCION:");
        jPanel3.add(lbldireccion);
        lbldireccion.setBounds(10, 100, 80, 30);

        lblsexo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblsexo.setText("SEXO:");
        jPanel3.add(lblsexo);
        lblsexo.setBounds(380, 20, 60, 30);

        cbsexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MASCULINO", "FEMENINO" }));
        cbsexo.setEnabled(false);
        jPanel3.add(cbsexo);
        cbsexo.setBounds(420, 20, 120, 30);

        txtcedulaPaciente.setEnabled(false);
        txtcedulaPaciente.setNextFocusableComponent(cbinstitucion);
        txtcedulaPaciente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtcedulaPacienteFocusLost(evt);
            }
        });
        txtcedulaPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcedulaPacienteActionPerformed(evt);
            }
        });
        txtcedulaPaciente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcedulaPacienteKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcedulaPacienteKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcedulaPacienteKeyTyped(evt);
            }
        });
        jPanel3.add(txtcedulaPaciente);
        txtcedulaPaciente.setBounds(90, 20, 80, 30);

        jdfechaNacimiento.setEnabled(false);
        jPanel3.add(jdfechaNacimiento);
        jdfechaNacimiento.setBounds(250, 20, 120, 30);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(10, 20, 740, 140);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DETALLE DE INSTITUCION", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 0, 0))); // NOI18N
        jPanel2.setLayout(null);

        lblcontacto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblcontacto.setText("CODIGO");
        jPanel2.add(lblcontacto);
        lblcontacto.setBounds(10, 70, 70, 30);

        txtcontactoOrganizacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcontactoOrganizacionActionPerformed(evt);
            }
        });
        txtcontactoOrganizacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcontactoOrganizacionKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcontactoOrganizacionKeyReleased(evt);
            }
        });
        jPanel2.add(txtcontactoOrganizacion);
        txtcontactoOrganizacion.setBounds(70, 70, 60, 30);

        cbinstitucion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbinstitucion.setNextFocusableComponent(btnagregar);
        cbinstitucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbinstitucionActionPerformed(evt);
            }
        });
        jPanel2.add(cbinstitucion);
        cbinstitucion.setBounds(70, 20, 660, 30);

        lblcontacto3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblcontacto3.setText("NOMBRE");
        jPanel2.add(lblcontacto3);
        lblcontacto3.setBounds(10, 20, 70, 30);

        txtcodigoInstitucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodigoInstitucionActionPerformed(evt);
            }
        });
        txtcodigoInstitucion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcodigoInstitucionKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcodigoInstitucionKeyReleased(evt);
            }
        });
        jPanel2.add(txtcodigoInstitucion);
        txtcodigoInstitucion.setBounds(690, 20, 40, 30);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(10, 160, 740, 60);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DETALLE DE ESTUDIO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 0, 0))); // NOI18N
        jPanel4.setLayout(null);

        tbestudiosSolicitados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        tbestudiosSolicitados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbestudiosSolicitadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbestudiosSolicitados);

        jPanel4.add(jScrollPane1);
        jScrollPane1.setBounds(12, 20, 580, 150);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)), null));
        jPanel5.setForeground(new java.awt.Color(204, 0, 0));
        jPanel5.setLayout(null);

        btnagregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ARCHIVOS/mas.png"))); // NOI18N
        btnagregar.setToolTipText("AGREGAR REGISTRO");
        btnagregar.setNextFocusableComponent(btnEliminar);
        btnagregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnagregarMouseClicked(evt);
            }
        });
        btnagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarActionPerformed(evt);
            }
        });
        jPanel5.add(btnagregar);
        btnagregar.setBounds(40, 0, 60, 50);

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ARCHIVOS/boton-circular-de-quitar.png"))); // NOI18N
        btnEliminar.setToolTipText("QUITAR REGISTRO");
        btnEliminar.setNextFocusableComponent(btnrecibo);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel5.add(btnEliminar);
        btnEliminar.setBounds(40, 50, 60, 50);
        jPanel5.add(jSeparator1);
        jSeparator1.setBounds(0, 100, 130, 10);

        btnrecibo.setText("RECIBO");
        btnrecibo.setToolTipText("GUARDAR REGISTRO");
        btnrecibo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreciboActionPerformed(evt);
            }
        });
        jPanel5.add(btnrecibo);
        btnrecibo.setBounds(10, 150, 110, 30);

        btnetiqueta.setText("GUARDAR");
        btnetiqueta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnetiquetaActionPerformed(evt);
            }
        });
        jPanel5.add(btnetiqueta);
        btnetiqueta.setBounds(10, 110, 110, 30);

        jPanel4.add(jPanel5);
        jPanel5.setBounds(600, 20, 130, 190);

        lbltotalFactura.setBackground(new java.awt.Color(255, 255, 255));
        lbltotalFactura.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbltotalFactura.setForeground(new java.awt.Color(255, 0, 0));
        lbltotalFactura.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbltotalFactura.setText("0.00");
        jPanel4.add(lbltotalFactura);
        lbltotalFactura.setBounds(470, 180, 120, 30);

        lblcostoTotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblcostoTotal.setText("COSTO TOTAL:");
        jPanel4.add(lblcostoTotal);
        lblcostoTotal.setBounds(370, 180, 100, 30);

        txtnumeroReferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnumeroReferenciaActionPerformed(evt);
            }
        });
        txtnumeroReferencia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtnumeroReferenciaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtnumeroReferenciaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnumeroReferenciaKeyTyped(evt);
            }
        });
        jPanel4.add(txtnumeroReferencia);
        txtnumeroReferencia.setBounds(100, 180, 160, 30);

        lblnumeroReferencia.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblnumeroReferencia.setText("REFERENCIA");
        jPanel4.add(lblnumeroReferencia);
        lblnumeroReferencia.setBounds(20, 180, 100, 30);

        jPanel1.add(jPanel4);
        jPanel4.setBounds(10, 220, 740, 220);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 60, 760, 450);

        txtcodigoDetalle.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtcodigoDetalleFocusLost(evt);
            }
        });
        txtcodigoDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodigoDetalleActionPerformed(evt);
            }
        });
        txtcodigoDetalle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcodigoDetalleKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcodigoDetalleKeyReleased(evt);
            }
        });
        getContentPane().add(txtcodigoDetalle);
        txtcodigoDetalle.setBounds(880, 390, 60, 30);

        lblcontacto12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblcontacto12.setText("Ndetalle");
        getContentPane().add(lblcontacto12);
        lblcontacto12.setBounds(880, 360, 110, 30);

        lblcontacto8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblcontacto8.setText("TURNO");
        getContentPane().add(lblcontacto8);
        lblcontacto8.setBounds(880, 70, 110, 30);

        lblturno.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblturno.setForeground(new java.awt.Color(255, 0, 0));
        lblturno.setText("TURNO");
        getContentPane().add(lblturno);
        lblturno.setBounds(880, 90, 70, 30);

        lblhora.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblhora.setText("HORA");
        getContentPane().add(lblhora);
        lblhora.setBounds(880, 120, 70, 30);

        lblfecha.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblfecha.setText("FECHA");
        getContentPane().add(lblfecha);
        lblfecha.setBounds(880, 180, 70, 30);

        lblsolicitud.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblsolicitud.setText("SOLICITUD");
        getContentPane().add(lblsolicitud);
        lblsolicitud.setBounds(880, 250, 70, 30);

        lblcodigoSolicitud.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblcodigoSolicitud.setForeground(new java.awt.Color(255, 0, 0));
        lblcodigoSolicitud.setText("TURNO");
        getContentPane().add(lblcodigoSolicitud);
        lblcodigoSolicitud.setBounds(880, 270, 70, 30);

        jPanel7.setBackground(new java.awt.Color(0, 102, 153));
        jPanel7.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel7.setLayout(null);

        btncancelar.setBackground(new java.awt.Color(255, 255, 255));
        btncancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ARCHIVOS/expediente.png"))); // NOI18N
        btncancelar.setToolTipText("CANCELAR REGISTRO");
        btncancelar.setNextFocusableComponent(btnnuevo);
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });
        jPanel7.add(btncancelar);
        btncancelar.setBounds(60, 0, 70, 60);

        btnnuevo.setBackground(new java.awt.Color(255, 255, 255));
        btnnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ARCHIVOS/agregar-documento-simbolo-delineado.png"))); // NOI18N
        btnnuevo.setToolTipText("NUEVO REGISTRO");
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });
        jPanel7.add(btnnuevo);
        btnnuevo.setBounds(0, 0, 60, 60);

        btnmenu.setBackground(new java.awt.Color(255, 255, 255));
        btnmenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ARCHIVOS/salida.png"))); // NOI18N
        btnmenu.setText("MENU");
        btnmenu.setToolTipText("IR A MENU");
        btnmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmenuActionPerformed(evt);
            }
        });
        jPanel7.add(btnmenu);
        btnmenu.setBounds(610, 0, 140, 60);

        getContentPane().add(jPanel7);
        jPanel7.setBounds(0, 0, 930, 60);

        txtfechaSolicitud.setText("jTextField1");
        txtfechaSolicitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfechaSolicitudActionPerformed(evt);
            }
        });
        getContentPane().add(txtfechaSolicitud);
        txtfechaSolicitud.setBounds(880, 210, 110, 30);

        txthora.setText("jTextField1");
        getContentPane().add(txthora);
        txthora.setBounds(880, 150, 100, 30);

        txtcodigoPaciente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtcodigoPacienteFocusLost(evt);
            }
        });
        txtcodigoPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodigoPacienteActionPerformed(evt);
            }
        });
        txtcodigoPaciente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcodigoPacienteKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcodigoPacienteKeyReleased(evt);
            }
        });
        getContentPane().add(txtcodigoPaciente);
        txtcodigoPaciente.setBounds(880, 470, 60, 30);

        lblcontacto9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblcontacto9.setText("codigoPaciente");
        getContentPane().add(lblcontacto9);
        lblcontacto9.setBounds(880, 440, 110, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        nuevoCodigo();
        asignarFecha();
        txtcedulaPaciente.setEnabled(true);
        vaciarTextos();
        btnnuevo.setEnabled(false);
        btnmenu.setEnabled(false);
        txtcedulaPaciente.grabFocus();
        btncancelar.setEnabled(true);
        asignarFecha();
        mostrarEstudiofrmSolicitud(lblcodigoSolicitud.getText());
        btnrecibo.setEnabled(true);
        btnetiqueta.setEnabled(true);
        modificador=false;
        cbinstitucion.setSelectedIndex(0);
        try {
            DefaultTableModel modelo;
            fdetalleSolicitud func= new fdetalleSolicitud();
            modelo=func.mostrarEstudioSolicitado(txtnumeroReferencia.getText());
            tbestudiosSolicitados.setModel(modelo);
        } catch (Exception e) {
            
        }
        
    }//GEN-LAST:event_btnnuevoActionPerformed

        void comboInstituciones(String tabla, String nombrecol){
        fsolicitud func= new fsolicitud();
        Object[] nombre = func.instituciones();
        cbinstitucion.removeAllItems();
        for(int i=0;i<nombre.length;i++){
        cbinstitucion.addItem(nombre[i]);    
        }
   }
    
    private void btnreciboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreciboActionPerformed
            try {
                    btnetiqueta.doClick();
                    formularioRecibo();
                    EnviarDatos();
                    mostrarEstudiofrmRecibo2(lblcodigoSolicitud.getText());
                    btnnuevo.setEnabled(true);
                    btnmenu.setEnabled(true);
                    frmrecibo.btncalcularFactura.doClick();  

        } catch (Exception e) {
            
        }
             
        
        
        
    }//GEN-LAST:event_btnreciboActionPerformed
    private void formularioRecibo(){
        frmrecibo form= new  frmrecibo();
        escritorio.add(form);
        form.toFront();
        form.setSize(700, 650);
        form.setVisible(true);
    }
    
    private void EnviarDatos(){
        frmrecibo.txtrasonSocial.setText(txtnombresPaciente.getText()+" "+txtapellidosPacientes.getText());
        frmrecibo.txtcedulaRif.setText(txtcedulaPaciente.getText());
        frmrecibo.txttelefono.setText(txttelefonoPaciente.getText());
        frmrecibo.txtdireccion.setText(txtdireccionPaciente.getText());
        frmrecibo.txtnumeroSolicitud.setText(lblcodigoSolicitud.getText());
        
    
    }  
    
    private void comprobarEtiqueta(){
        if(txtnombresPaciente.getText().length()==0 && txtapellidosPacientes.getText().length()==0)  {
            return;
        }
        else{
            JOptionPane.showInputDialog("Ingrese el numero de etiquetas que desea Imprimir",2);
        }
    }
    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        // TODO add your handling code here:

        btnmenu.setEnabled(true);
        btnnuevo.setEnabled(true);
        txtcedulaPaciente.setEnabled(false);
        vaciarTextos();
        cbinstitucion.setSelectedIndex(0);
        btnrecibo.setEnabled(false);
        btnetiqueta.setEnabled(false);
        
        /*
            ELIMNAR LOS ESTUDIOS AGREGADOS A LA TABLA
        */
        try {
            vsolicitud dts= new vsolicitud();
            fsolicitud funcion= new fsolicitud();

            dts.setNumeroSolicitud(Integer.parseInt(lblcodigoSolicitud.getText()));
            funcion.CancelarEstudiosSolicitud(dts);
            
            /*
            
                ACTUALIZA LA TABLA PARA VALIDAR QUE SE ELIMINARON LOS ESTUDIOS AGREGADOS
            */
            mostrarEstudiofrmSolicitud(lblcodigoSolicitud.getText());
        } catch (Exception e) {
        }
        

    }//GEN-LAST:event_btncancelarActionPerformed

    private void btnmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmenuActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnmenuActionPerformed

    private void txtnumeroReferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnumeroReferenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnumeroReferenciaActionPerformed

    private void txtnumeroReferenciaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnumeroReferenciaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnumeroReferenciaKeyPressed

    private void txtnumeroReferenciaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnumeroReferenciaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnumeroReferenciaKeyReleased

    private void txtnombresPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombresPacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombresPacienteActionPerformed

    private void txtnombresPacienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombresPacienteKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombresPacienteKeyPressed

    private void txtnombresPacienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombresPacienteKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombresPacienteKeyReleased

    private void txtapellidosPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtapellidosPacientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtapellidosPacientesActionPerformed

    private void txtapellidosPacientesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtapellidosPacientesKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtapellidosPacientesKeyPressed

    private void txtapellidosPacientesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtapellidosPacientesKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtapellidosPacientesKeyReleased

    private void txttelefonoPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttelefonoPacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttelefonoPacienteActionPerformed

    private void txttelefonoPacienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttelefonoPacienteKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttelefonoPacienteKeyPressed

    private void txttelefonoPacienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttelefonoPacienteKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txttelefonoPacienteKeyReleased

    private void txtdireccionPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdireccionPacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdireccionPacienteActionPerformed

    private void txtdireccionPacienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdireccionPacienteKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdireccionPacienteKeyPressed

    private void txtdireccionPacienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdireccionPacienteKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdireccionPacienteKeyReleased

    private void txtcontactoOrganizacionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcontactoOrganizacionKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcontactoOrganizacionKeyReleased

    private void txtcontactoOrganizacionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcontactoOrganizacionKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcontactoOrganizacionKeyPressed

    private void txtcontactoOrganizacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcontactoOrganizacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcontactoOrganizacionActionPerformed

    private void btnagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarActionPerformed
        // TODO add your handling code here:
        if (lblcodigoSolicitud.getText().length()==0){          
            JOptionPane.showConfirmDialog(rootPane, "Debe ingresar un Nuevo Registro!");
        }
        else{
            frmestudiosInstitucion form = new frmestudiosInstitucion();
            escritorio.add(form);
            form.toFront();
            form.setSize(760, 540);
            form.setVisible(true); 
            frmestudiosInstitucion.txtcodigoInstitucion.setText(txtcodigoInstitucion.getText());
            String nombreInstitucion= cbinstitucion.getSelectedItem().toString();
            frmestudiosInstitucion.txtnombreInstitucion.setText(nombreInstitucion);
            frmestudiosInstitucion.txtnumeroSolicitud.setText(lblcodigoSolicitud.getText());
            frmestudiosInstitucion.btnbuscar.doClick();
        }
    }//GEN-LAST:event_btnagregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:

        
            if (!txtcodigoDetalle.getText().equals("")) {

            int confirmacion = JOptionPane.showConfirmDialog(rootPane, "Seguro que quiere eliminar este registro?", "Confirmar", 2);

            if (confirmacion==0) {
                fdetalleSolicitud func= new fdetalleSolicitud();
                vdetalleSolicitud dts= new vdetalleSolicitud ();

                dts.setNumeroDetalle(Integer.parseInt(txtcodigoDetalle.getText()));
                func.eliminarDetalle(dts);
                mostrarEstudiofrmSolicitud(lblcodigoSolicitud.getText());
            }
        }
        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtcodigoInstitucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodigoInstitucionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodigoInstitucionActionPerformed

    private void txtcodigoInstitucionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodigoInstitucionKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodigoInstitucionKeyPressed

    private void txtcodigoInstitucionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodigoInstitucionKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodigoInstitucionKeyReleased

    private void txtcedulaPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcedulaPacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcedulaPacienteActionPerformed

    private void txtcedulaPacienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcedulaPacienteKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcedulaPacienteKeyPressed

    private void txtcedulaPacienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcedulaPacienteKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcedulaPacienteKeyReleased

    private void cbinstitucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbinstitucionActionPerformed
        // TODO add your handling code here:
            Object dato =(String)cbinstitucion.getSelectedItem();
            String nombre= String.valueOf(dato);
            System.out.println();
            cargarCodigoInstitucion(nombre);
    }//GEN-LAST:event_cbinstitucionActionPerformed

    private void txtcedulaPacienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcedulaPacienteFocusLost
        // TODO add your handling code here:
        
        if (txtcedulaPaciente.getText().length()==0){
            JOptionPane.showMessageDialog(rootPane, "Debe Ingresar una Cedula para buscar un paciente");
            return;
        }
        else{
            String cedula= txtcedulaPaciente.getText();
            System.out.println("esta es la cedula del paciente que se mando a buscar "+cedula);
            
            frmbuscarPaciente form = new frmbuscarPaciente();
            escritorio.add(form);
            form.toFront();
            form.setSize(820, 550);
            form.setVisible(true); 
            frmbuscarPaciente.txtbuscar.setText(cedula);
            frmbuscarPaciente.btnbuscar.doClick();
        }

            //encontrarPaciente(cedula);
    }//GEN-LAST:event_txtcedulaPacienteFocusLost

    private void txtcodigoDetalleFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcodigoDetalleFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodigoDetalleFocusLost

    private void txtcodigoDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodigoDetalleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodigoDetalleActionPerformed

    private void txtcodigoDetalleKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodigoDetalleKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodigoDetalleKeyPressed

    private void txtcodigoDetalleKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodigoDetalleKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodigoDetalleKeyReleased

    private void btnagregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnagregarMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_btnagregarMouseClicked

    private void tbestudiosSolicitadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbestudiosSolicitadosMouseClicked
        // TODO add your handling code here:
        
           int fila =tbestudiosSolicitados.rowAtPoint(evt.getPoint());

        txtcodigoDetalle.setText(tbestudiosSolicitados.getValueAt(fila, 0).toString());
    }//GEN-LAST:event_tbestudiosSolicitadosMouseClicked

    private void txtcodigoPacienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcodigoPacienteFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodigoPacienteFocusLost

    private void txtcodigoPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodigoPacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodigoPacienteActionPerformed

    private void txtcodigoPacienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodigoPacienteKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodigoPacienteKeyPressed

    private void txtcodigoPacienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodigoPacienteKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodigoPacienteKeyReleased

    private void txtfechaSolicitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfechaSolicitudActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfechaSolicitudActionPerformed

    private void btnetiquetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnetiquetaActionPerformed
        
        /*codigo para saber si el estudio posee una referencia*/
            if (modificador==false){
                GuardarSolicitud();
                 JOptionPane.showMessageDialog(rootPane, "Registro almacenado!.");
            }
        
    }//GEN-LAST:event_btnetiquetaActionPerformed
    private Connection connection= new conexion().conectar();   
    private void txtcedulaPacienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcedulaPacienteKeyTyped
        // TODO add your handling code here:
         Character c = evt.getKeyChar();
                if(Character.isLetter(c)) {
                    evt.setKeyChar(Character.toUpperCase(c));
                }
    }//GEN-LAST:event_txtcedulaPacienteKeyTyped

    private void txtnombresPacienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombresPacienteKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombresPacienteKeyTyped

    private void txtnumeroReferenciaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnumeroReferenciaKeyTyped
        Character c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            evt.setKeyChar(Character.toUpperCase(c));
        }
    }//GEN-LAST:event_txtnumeroReferenciaKeyTyped

    
        
    
    
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
            java.util.logging.Logger.getLogger(frmsolicitud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmsolicitud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmsolicitud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmsolicitud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmsolicitud().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnagregar;
    public static javax.swing.JButton btncancelar;
    public static javax.swing.JButton btnetiqueta;
    private javax.swing.JButton btnmenu;
    private javax.swing.JButton btnnuevo;
    public static javax.swing.JButton btnrecibo;
    public static javax.swing.JComboBox cbinstitucion;
    public static javax.swing.JComboBox cbsexo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    public static com.toedter.calendar.JDateChooser jdfechaNacimiento;
    private javax.swing.JLabel lblapellidos;
    private javax.swing.JLabel lblcedula;
    public static javax.swing.JLabel lblcodigoSolicitud;
    private javax.swing.JLabel lblcontacto;
    private javax.swing.JLabel lblcontacto12;
    private javax.swing.JLabel lblcontacto3;
    private javax.swing.JLabel lblcontacto8;
    private javax.swing.JLabel lblcontacto9;
    private javax.swing.JLabel lblcostoTotal;
    private javax.swing.JLabel lbldireccion;
    private javax.swing.JLabel lblfecha;
    private javax.swing.JLabel lblfechaNacimiento;
    private javax.swing.JLabel lblhora;
    private javax.swing.JLabel lblnombres;
    private javax.swing.JLabel lblnumeroReferencia;
    private javax.swing.JLabel lblsexo;
    private javax.swing.JLabel lblsolicitud;
    private javax.swing.JLabel lbltelefono;
    public static javax.swing.JLabel lbltotalFactura;
    public static javax.swing.JLabel lblturno;
    public static javax.swing.JTable tbestudiosSolicitados;
    public static javax.swing.JTextField txtapellidosPacientes;
    public static javax.swing.JTextField txtcedulaPaciente;
    public static javax.swing.JTextField txtcodigoDetalle;
    public static javax.swing.JTextField txtcodigoInstitucion;
    public static javax.swing.JTextField txtcodigoPaciente;
    public static javax.swing.JTextField txtcontactoOrganizacion;
    public static javax.swing.JTextField txtdireccionPaciente;
    private javax.swing.JTextField txtfechaSolicitud;
    private javax.swing.JTextField txthora;
    public static javax.swing.JTextField txtnombresPaciente;
    public static javax.swing.JTextField txtnumeroReferencia;
    public static javax.swing.JTextField txttelefonoPaciente;
    // End of variables declaration//GEN-END:variables
}
