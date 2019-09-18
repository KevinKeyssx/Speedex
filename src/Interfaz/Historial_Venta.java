package Interfaz;

import Clases.Validar;
import Clases.Venta;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 * @author keiss
 */
public class Historial_Venta extends javax.swing.JDialog {  
    
    DefaultTableModel modelo;
    ArrayList <Venta> cargarDatosHistorial = new ArrayList();
    static int  ventas, productos, nula, alta, baja, vuelto, descuento, prodmasvendido;
    static float promedio;
    static long totalventas;
    static boolean busqueda = true;
    static String columna, fecha;
    
    private void tablaHistorial(){
        Venta venta = new Venta();
        Validar v = new Validar();
    
        modelo = (DefaultTableModel)tb_HistorialVenta.getModel();

        columna = v.obtenerColVenta((String) cmb_Seleccion.getSelectedItem());

        fecha = v.buscaFecha(ck_Dia.isSelected(), ck_Mes.isSelected(), ck_Año.isSelected(), getFecha()); 
        
        if (!fecha.equals("")) 
            columna = " and "+columna;
        
        String orden = v.validaOrden(ck_Orden.isSelected());

        cargarDatosHistorial = venta.buscarDatosVenta(busqueda, fecha, columna, txt_Busqueda.getText(), orden);
        
        if (cargarDatosHistorial == null || cargarDatosHistorial.isEmpty()){
            for (int i = tb_HistorialVenta.getRowCount() -1; i >= 0; i--)
                modelo.removeRow(i);
            
            todoEnCero();
        
        }   
        else{
            DefaultTableCellRenderer Alinear = new DefaultTableCellRenderer();
            Alinear.setHorizontalAlignment(SwingConstants.CENTER);//alinea  en el centro datos de la tabla 
            
            for (int i = tb_HistorialVenta.getRowCount() -1; i >= 0; i--)
                modelo.removeRow(i); 

            //llama a centrar los dtos de las columnas de la tabla
            for (int i = 0; i < 12; i++) 
                tb_HistorialVenta.getColumnModel().getColumn(i).setCellRenderer(Alinear); 
            
            //datos que se cargaran en la tabla
            Object[] fila = new Object[modelo.getColumnCount()];   

            for (int i = 0; i < cargarDatosHistorial.size(); i++) {
                fila[0]=cargarDatosHistorial.get(i).getId();                                             //Nro Venta      
                fila[1]=cargarDatosHistorial.get(i).getDetalleVenta().get(i).getIdProducto();            //Código Producto
                fila[2]=v.numerosConPuntos((long) cargarDatosHistorial.get(i).getVentaTotal()) ;         //Total
                fila[3]=cargarDatosHistorial.get(i).getDetalleVenta().get(i).getCantidad();              //Cantidad
                fila[4]=cargarDatosHistorial.get(i).getFecha();                                          //Fecha
                fila[5]=cargarDatosHistorial.get(i).getTipoPago();                                       //Tipo Pago
                fila[6]=cargarDatosHistorial.get(i).getEstado();                                         //Estado
                fila[7]=v.numerosConPuntos((long)cargarDatosHistorial.get(i).getDetalleVenta().get(i).getSubTotal()) ;              //Sub Total
                fila[8]=cargarDatosHistorial.get(i).getIdEmpleado();                                     //Empleado
                fila[9]=v.numerosConPuntos((long) cargarDatosHistorial.get(i).getRecibo()) ;             //Recibo
                fila[10]=v.numerosConPuntos((long) cargarDatosHistorial.get(i).getVuelto()) ;            //vuelto
                fila[11]=v.numerosConPuntos((long) cargarDatosHistorial.get(i).getDescuento()) ;         //Descuento
                
                modelo.addRow(fila);               
            }
            
            tb_HistorialVenta.setModel(modelo);
            
            //cambiaColor();
            
            calculaTotal();
            ventasRealizadas();
            productosVendidos();
            promedioVenta();
            ventasNulas();
            ventaAlta();
            ventaBaja();
            totalVuelto();
            totalDescuento();
        }
    }
    
    public Historial_Venta(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        setTitle("Historial de Ventas - SpeedeX");
        this.setLocationRelativeTo(null); //Centrar el JFrame al centro de la pantalla
        this.setResizable(false); //No permite modificar el tamaño
        setSize(970, 590); //Tamaño por defecto
        setIconImage(new ImageIcon(getClass().getResource("/Complementos/Logo Speedex2.png")).getImage()); //Icono de la app
        
        cmb_Seleccion.removeAllItems();
        cmb_Seleccion.addItem("Nro Venta");
        cmb_Seleccion.addItem("Código");
        cmb_Seleccion.addItem("Total");
        cmb_Seleccion.addItem("Cantidad");
        cmb_Seleccion.addItem("Fecha");
        cmb_Seleccion.addItem("Tipo de Pago");
        cmb_Seleccion.addItem("Estado");
        cmb_Seleccion.addItem("Sub Total");
        cmb_Seleccion.addItem("Empleado");
        cmb_Seleccion.addItem("Recibo");
        cmb_Seleccion.addItem("Vuelto");
        cmb_Seleccion.addItem("Descuento");
        
        txt_Busqueda.requestFocus();
        txt_Busqueda.setToolTipText("Búsca una venta...");
        dc_Fecha.setToolTipText("Ingresa un fecha");
        
        fechaDefecto();
        
        ck_Dia.setSelected(true);
        ck_Mes.setSelected(true);
        ck_Año.setSelected(true);
        tablaHistorial();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_HistorialVenta = new javax.swing.JTable();
        btn_Anular = new javax.swing.JButton();
        cmb_Seleccion = new javax.swing.JComboBox<>();
        ck_Dia = new javax.swing.JCheckBox();
        ck_Mes = new javax.swing.JCheckBox();
        ck_Año = new javax.swing.JCheckBox();
        dc_Fecha = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        txt_Busqueda = new javax.swing.JTextField();
        lbl_TotalVentas = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbl_VentasRealizadas = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbl_TotalVuelto = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbl_TotalDescuentos = new javax.swing.JLabel();
        ck_Orden = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        lbl_VentaPromedio = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbl_MasAlta = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lbl_MasBaja = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lbl_VentasNulas = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lbl_ProductosVendidos = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel19 = new javax.swing.JLabel();
        btn_Volver1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        lbl_Masvendido = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLayeredPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLayeredPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tb_HistorialVenta.setBackground(new java.awt.Color(204, 204, 255));
        tb_HistorialVenta.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tb_HistorialVenta.setForeground(new java.awt.Color(0, 153, 153));
        tb_HistorialVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nro Venta", "Código", "Total", "Cantidad", "Fecha", "Tipo Pago", "Estado", "Sub Total", "Empleado", "Recibo", "Vuelto", "Descuento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Long.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.String.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_HistorialVenta.setGridColor(new java.awt.Color(0, 51, 51));
        tb_HistorialVenta.setSelectionBackground(new java.awt.Color(0, 102, 153));
        tb_HistorialVenta.setSelectionForeground(new java.awt.Color(204, 255, 255));
        tb_HistorialVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_HistorialVentaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tb_HistorialVenta);

        jLayeredPane1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 870, 200));

        btn_Anular.setForeground(new java.awt.Color(255, 102, 102));
        btn_Anular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Inhabilitar.png"))); // NOI18N
        btn_Anular.setText("Anular");
        btn_Anular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AnularActionPerformed(evt);
            }
        });
        jLayeredPane1.add(btn_Anular, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 400, 120, 40));

        cmb_Seleccion.setForeground(new java.awt.Color(0, 204, 204));
        cmb_Seleccion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jLayeredPane1.add(cmb_Seleccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, 130, 30));

        ck_Dia.setForeground(new java.awt.Color(0, 204, 204));
        ck_Dia.setText("Dia");
        ck_Dia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ck_DiaMouseClicked(evt);
            }
        });
        jLayeredPane1.add(ck_Dia, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 30, -1, 30));

        ck_Mes.setForeground(new java.awt.Color(0, 204, 204));
        ck_Mes.setText("Mes");
        ck_Mes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ck_MesMouseClicked(evt);
            }
        });
        jLayeredPane1.add(ck_Mes, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 30, -1, 30));

        ck_Año.setForeground(new java.awt.Color(0, 204, 204));
        ck_Año.setText("Año");
        ck_Año.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ck_AñoMouseClicked(evt);
            }
        });
        ck_Año.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ck_AñoActionPerformed(evt);
            }
        });
        jLayeredPane1.add(ck_Año, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 30, -1, 30));

        dc_Fecha.setBackground(new java.awt.Color(0, 153, 153));
        dc_Fecha.setForeground(new java.awt.Color(0, 153, 153));
        jLayeredPane1.add(dc_Fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 30, 100, 30));

        jLabel1.setForeground(new java.awt.Color(0, 204, 204));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Textos/Total de Ventas.png"))); // NOI18N
        jLayeredPane1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, 120, -1));

        txt_Busqueda.setForeground(new java.awt.Color(0, 153, 153));
        txt_Busqueda.setSelectionColor(new java.awt.Color(255, 153, 51));
        txt_Busqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_BusquedaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_BusquedaKeyReleased(evt);
            }
        });
        jLayeredPane1.add(txt_Busqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, 230, 30));

        lbl_TotalVentas.setFont(new java.awt.Font("DS-Digital", 0, 18)); // NOI18N
        lbl_TotalVentas.setForeground(new java.awt.Color(0, 153, 153));
        lbl_TotalVentas.setText("jLabel2");
        jLayeredPane1.add(lbl_TotalVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 300, -1, -1));

        jLabel3.setForeground(new java.awt.Color(0, 204, 204));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Textos/Ventas Realizadas.png"))); // NOI18N
        jLayeredPane1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, 140, -1));

        lbl_VentasRealizadas.setFont(new java.awt.Font("DS-Digital", 0, 18)); // NOI18N
        lbl_VentasRealizadas.setForeground(new java.awt.Color(0, 153, 153));
        lbl_VentasRealizadas.setText("jLabel4");
        jLayeredPane1.add(lbl_VentasRealizadas, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 320, -1, -1));

        jLabel5.setForeground(new java.awt.Color(0, 204, 204));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Textos/Total Vuelto.png"))); // NOI18N
        jLayeredPane1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 320, 100, -1));

        lbl_TotalVuelto.setFont(new java.awt.Font("DS-Digital", 0, 18)); // NOI18N
        lbl_TotalVuelto.setForeground(new java.awt.Color(0, 153, 153));
        lbl_TotalVuelto.setText("jLabel6");
        jLayeredPane1.add(lbl_TotalVuelto, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 320, -1, -1));

        jLabel7.setForeground(new java.awt.Color(0, 204, 204));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Textos/Ventas descuento.png"))); // NOI18N
        jLayeredPane1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 340, 120, -1));

        lbl_TotalDescuentos.setFont(new java.awt.Font("DS-Digital", 0, 18)); // NOI18N
        lbl_TotalDescuentos.setForeground(new java.awt.Color(0, 153, 153));
        lbl_TotalDescuentos.setText("jLabel8");
        jLayeredPane1.add(lbl_TotalDescuentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 340, -1, -1));

        ck_Orden.setForeground(new java.awt.Color(0, 204, 204));
        ck_Orden.setText("Orden descendente");
        ck_Orden.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ck_OrdenMouseClicked(evt);
            }
        });
        jLayeredPane1.add(ck_Orden, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 410, -1, -1));

        jLabel9.setForeground(new java.awt.Color(0, 204, 204));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Textos/Venta Promedio.png"))); // NOI18N
        jLayeredPane1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 300, 130, -1));

        lbl_VentaPromedio.setFont(new java.awt.Font("DS-Digital", 0, 18)); // NOI18N
        lbl_VentaPromedio.setForeground(new java.awt.Color(0, 153, 153));
        lbl_VentaPromedio.setText("jLabel10");
        jLayeredPane1.add(lbl_VentaPromedio, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 300, -1, -1));

        jLabel11.setForeground(new java.awt.Color(0, 204, 204));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Textos/Ventas mas altas.png"))); // NOI18N
        jLayeredPane1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 340, 120, -1));

        lbl_MasAlta.setFont(new java.awt.Font("DS-Digital", 0, 18)); // NOI18N
        lbl_MasAlta.setForeground(new java.awt.Color(0, 153, 153));
        lbl_MasAlta.setText("jLabel12");
        jLayeredPane1.add(lbl_MasAlta, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 340, -1, -1));

        jLabel13.setForeground(new java.awt.Color(0, 204, 204));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Textos/Ventas mas baja.png"))); // NOI18N
        jLayeredPane1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 300, 130, -1));

        lbl_MasBaja.setFont(new java.awt.Font("DS-Digital", 0, 18)); // NOI18N
        lbl_MasBaja.setForeground(new java.awt.Color(0, 153, 153));
        lbl_MasBaja.setText("jLabel14");
        jLayeredPane1.add(lbl_MasBaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 300, -1, -1));

        jLabel15.setForeground(new java.awt.Color(0, 204, 204));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Textos/Ventas Nulas.png"))); // NOI18N
        jLayeredPane1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 320, 100, -1));

        lbl_VentasNulas.setFont(new java.awt.Font("DS-Digital", 0, 18)); // NOI18N
        lbl_VentasNulas.setForeground(new java.awt.Color(0, 153, 153));
        lbl_VentasNulas.setText("jLabel16");
        jLayeredPane1.add(lbl_VentasNulas, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 320, -1, -1));

        jLabel17.setForeground(new java.awt.Color(0, 204, 204));
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Textos/Productos vendidos.png"))); // NOI18N
        jLayeredPane1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 340, 160, -1));

        lbl_ProductosVendidos.setFont(new java.awt.Font("DS-Digital", 0, 18)); // NOI18N
        lbl_ProductosVendidos.setForeground(new java.awt.Color(0, 153, 153));
        lbl_ProductosVendidos.setText("jLabel18");
        jLayeredPane1.add(lbl_ProductosVendidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 340, -1, -1));
        jLayeredPane1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, 810, 10));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Logo Speedex Mini4.png"))); // NOI18N
        jLayeredPane1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 100, 60));

        btn_Volver1.setForeground(new java.awt.Color(255, 51, 51));
        btn_Volver1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Boton Volver.png"))); // NOI18N
        btn_Volver1.setBorderPainted(false);
        btn_Volver1.setContentAreaFilled(false);
        btn_Volver1.setFocusPainted(false);
        btn_Volver1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Boton Volver Press.png"))); // NOI18N
        btn_Volver1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Boton Volver Mouse.png"))); // NOI18N
        btn_Volver1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Volver1ActionPerformed(evt);
            }
        });
        jLayeredPane1.add(btn_Volver1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 390, 70, 60));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Textos/Buscar.png"))); // NOI18N
        jLayeredPane1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, -1, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 204, 204));
        jLabel8.setText("=");
        jLayeredPane1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, 20, 30));

        getContentPane().add(jLayeredPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 910, 460));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Textos/Historial de ventas.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 490, -1));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Fondo Proceso.jpg"))); // NOI18N
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 570));

        lbl_Masvendido.setText("jLabel6");
        getContentPane().add(lbl_Masvendido, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 100, -1, 20));

        jLabel4.setText("Producto mas vendido:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 80, 130, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tb_HistorialVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_HistorialVentaMouseClicked
        Venta venta = new Venta();
//        if (evt.getClickCount() == 2) {
//            int filaseleccionada = tb_HistorialVenta.getSelectedRow();
//            
//
//            if (filaseleccionada >= 0) {}
//
//        }
//        else 
            if (evt.getClickCount() == 1){
            int filaseleccionada = tb_HistorialVenta.getSelectedRow();
            
            
            if (!tb_HistorialVenta.getValueAt(filaseleccionada, 6).toString().equals("NULA"))                           
                btn_Anular.setEnabled(true);
            else
                btn_Anular.setEnabled(false);
        }
    }//GEN-LAST:event_tb_HistorialVentaMouseClicked

    private String getFecha(){
        try{
            String formato = dc_Fecha.getDateFormatString(); //agrega el formato dd-mm-yy
            Date date = dc_Fecha.getDate(); //Guarda en una variable de tipo DATE
            SimpleDateFormat sdf = new SimpleDateFormat(formato); //Instacia con un formato
            return String.valueOf(sdf.format(date));//Transformamos a string el formato
        }
        catch(Exception ex){
           JOptionPane.showMessageDialog(null, "Ingresa una fecha válida.","Fecha inválida",JOptionPane.WARNING_MESSAGE);  
           return null;
        }
    }
    
    private void btn_AnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AnularActionPerformed
        int filaseleccionada = tb_HistorialVenta.getSelectedRow();
        Venta venta = new Venta();
        if (filaseleccionada >= 0) {
            if(JOptionPane.showConfirmDialog(null, "¿Está seguro que desea anular la venta Nro. "+tb_HistorialVenta.getValueAt(filaseleccionada, 0).toString()+"?\n Una vez anulada es imposible habilitar", "Anular venta", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE)==JOptionPane.YES_OPTION){
                venta.setId((int) tb_HistorialVenta.getValueAt(filaseleccionada, 0));
                
                if (venta.anularVenta()) {
                    JOptionPane.showMessageDialog(null, "Venta anulada exitosamente.","Información!",JOptionPane.INFORMATION_MESSAGE);   
                   
                    for (int i = tb_HistorialVenta.getRowCount() -1; i >= 0; i--)
                        modelo.removeRow(i); 
                    
                    tablaHistorial();
                }
            }
        }
        else
            JOptionPane.showMessageDialog(null, "No ha seleccionado ningúna venta.","Seleccione venta",JOptionPane.WARNING_MESSAGE);   
    }//GEN-LAST:event_btn_AnularActionPerformed

    private void txt_BusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_BusquedaKeyReleased
        if (getFecha() != null){
            tablaHistorial();
        
        busqueda = true;}
    }//GEN-LAST:event_txt_BusquedaKeyReleased

    private void btn_Volver1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Volver1ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btn_Volver1ActionPerformed

    private void txt_BusquedaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_BusquedaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            if (getFecha() != null) {
                busqueda = true;
                tablaHistorial();
            } 
        }
    }//GEN-LAST:event_txt_BusquedaKeyPressed

    private void ck_DiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ck_DiaMouseClicked
        busqueda = true;
        tablaHistorial();
    }//GEN-LAST:event_ck_DiaMouseClicked

    private void ck_MesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ck_MesMouseClicked
        busqueda = true;
        tablaHistorial();
    }//GEN-LAST:event_ck_MesMouseClicked

    private void ck_AñoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ck_AñoMouseClicked
        busqueda = true;
        tablaHistorial();
    }//GEN-LAST:event_ck_AñoMouseClicked

    private void ck_OrdenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ck_OrdenMouseClicked
        tablaHistorial();
    }//GEN-LAST:event_ck_OrdenMouseClicked

    private void ck_AñoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ck_AñoActionPerformed
        tablaHistorial();
    }//GEN-LAST:event_ck_AñoActionPerformed

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
            java.util.logging.Logger.getLogger(Historial_Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Historial_Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Historial_Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Historial_Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Historial_Venta dialog = new Historial_Venta(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Anular;
    private javax.swing.JButton btn_Volver1;
    private javax.swing.JCheckBox ck_Año;
    private javax.swing.JCheckBox ck_Dia;
    private javax.swing.JCheckBox ck_Mes;
    private javax.swing.JCheckBox ck_Orden;
    private javax.swing.JComboBox<String> cmb_Seleccion;
    private com.toedter.calendar.JDateChooser dc_Fecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbl_MasAlta;
    private javax.swing.JLabel lbl_MasBaja;
    private javax.swing.JLabel lbl_Masvendido;
    private javax.swing.JLabel lbl_ProductosVendidos;
    private javax.swing.JLabel lbl_TotalDescuentos;
    private javax.swing.JLabel lbl_TotalVentas;
    private javax.swing.JLabel lbl_TotalVuelto;
    private javax.swing.JLabel lbl_VentaPromedio;
    private javax.swing.JLabel lbl_VentasNulas;
    private javax.swing.JLabel lbl_VentasRealizadas;
    private javax.swing.JTable tb_HistorialVenta;
    private javax.swing.JTextField txt_Busqueda;
    // End of variables declaration//GEN-END:variables

    private void calculaTotal(){
        Validar v = new Validar();
        totalventas = v.calculo(busqueda, 1, fecha, columna, txt_Busqueda.getText());

        lbl_TotalVentas.setText(String.valueOf(v.numerosConPuntos(totalventas)) );
    }
    
    private void ventasRealizadas() {
        Validar v = new Validar();
        ventas = v.calculo(busqueda, 7, fecha, columna, txt_Busqueda.getText());
        
        
        lbl_VentasRealizadas.setText(v.numerosConPuntos(ventas));
    }    
    
    private void promedioVenta(){
        Validar v = new Validar();
        promedio = v.calculo(busqueda, 4, fecha, columna, txt_Busqueda.getText());

        lbl_VentaPromedio.setText(v.numerosConPuntos((long) promedio));
    
    }

    private void ventaAlta() {
        Validar v = new Validar();
        alta = v.calculo(busqueda, 2, fecha, columna, txt_Busqueda.getText());
        
        lbl_MasAlta.setText(v.numerosConPuntos(alta));
    }

    private void ventaBaja() {
        Validar v = new Validar();
        baja = v.calculo(busqueda, 3, fecha, columna, txt_Busqueda.getText());
        
        lbl_MasBaja.setText(v.numerosConPuntos(baja));
    }
    
    private void totalVuelto(){
        Validar v = new Validar();
        vuelto = v.calculo(busqueda, 5, fecha, columna, txt_Busqueda.getText());
        
        lbl_TotalVuelto.setText(v.numerosConPuntos(vuelto));
    }
    
    private void totalDescuento(){
        Validar v = new Validar();
        descuento = v.calculo(busqueda, 6, fecha, columna, txt_Busqueda.getText());
        
        lbl_TotalDescuentos.setText(v.numerosConPuntos(descuento));
    }
    
    
    private void ventasNulas(){      
        nula = new Validar().prodNulo(fecha, columna, txt_Busqueda.getText());
        lbl_VentasNulas.setText(String.valueOf(nula) );
    }
    
    private void cambiaColor(){
        for (int i = 0; i < modelo.getRowCount(); i++) {       
            if (modelo.getValueAt(i, 6).equals("NULA")) 
                tb_HistorialVenta.setBackground(Color.orange);
            else
                tb_HistorialVenta.setBackground(Color.CYAN);
        }
    }
    
    private void fechaDefecto(){
        Validar v = new Validar();
        try {
            String Fecha = v.fechaActual();
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Date fechaDate = formato.parse(Fecha);
            dc_Fecha.setDate(fechaDate);
        } 
        catch (ParseException ex) {
            //Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }     
    }

    private void todoEnCero() {
        lbl_TotalVentas.setText("0");
        lbl_VentasRealizadas.setText("0");
        lbl_ProductosVendidos.setText("0");
        lbl_VentaPromedio.setText("0");
        lbl_VentasNulas.setText("0");
        lbl_MasAlta.setText("0");
        lbl_MasBaja.setText("0");
        lbl_TotalVuelto.setText("0");
        lbl_TotalDescuentos.setText("0");
    }

    private void productosVendidos() {
        Validar va = new Validar();
        productos = va.calculo(busqueda, 8, fecha, columna, txt_Busqueda.getText());
        
        lbl_ProductosVendidos.setText(va.numerosConPuntos(productos));
    }
}