package Interfaz;

import Clases.Categoria_Producto;
import Clases.Dimension;
import Clases.Producto;
import Clases.Proveedor;
import Clases.Validar;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author keiss
 */
public class JDialog_Producto extends javax.swing.JDialog {
    
    private void añadirProducto(){
        Producto prod = cargarDatos();

        if (prod != null) {
            if (prod.insertarProducto()){
                JOptionPane.showMessageDialog(null, "El producto: "+prod.getNombre()+", fue añadido correctamente.","Producto ingresado",JOptionPane.INFORMATION_MESSAGE);
                limpiar();
            }else
                JOptionPane.showMessageDialog(null, "El producto: "+prod.getNombre()+", no fue añadido.","Producto NO ingresado",JOptionPane.INFORMATION_MESSAGE);
        }  
    }

    private Producto cargarDatos(){
        Producto prod = new Producto();
        Validar v = new Validar();
        
        if (!v.campoVacio(txt_CodigoProducto.getText()) && !v.campoVacio(txt_NombreProducto.getText() ) && !v.campoVacio(txt_StockProducto.getText()) && !v.campoVacio(txt_PrecioProducto.getText())) {
            prod.setId(txt_CodigoProducto.getText());
            prod.setNombre(txt_NombreProducto.getText());
            prod.setStock(Integer.parseInt(txt_StockProducto.getText()));
            prod.setPrecio(Integer.parseInt(txt_PrecioProducto.getText()));
            prod.setId_categoria(Integer.valueOf(cmb_CatProducoto.getSelectedItem().toString()));
            prod.setId_proveedor(Integer.valueOf(cmb_IdProvProducto.getSelectedItem().toString()));
            prod.setId_dimension(Integer.valueOf(cmb_Dimencion.getSelectedItem().toString()));

            int activo = 1;
            if (cmb_ActivoProducto.getSelectedItem().equals("0 (No activo)")) 
                activo = 0;

            prod.setActivo(activo);

            return prod;
        }
        else{
            JOptionPane.showMessageDialog(null, "Algunos campos están vacíos","Producto NO ingresado",JOptionPane.WARNING_MESSAGE);
            return null;
        } 
    }
    
    static boolean añadir = false;
    static boolean modificar = false;
    
    private void iniciarComponentes(){
        txt_CodigoProducto.requestFocus();
        if (añadir)
            setTitle("Agregar Nuevo Producto - SpeedeX");
        else
            setTitle("Modificar Producto - SpeedeX");
        
        this.setLocationRelativeTo(null); //Centrar el JFrame al centro de la pantalla
        setIconImage(new ImageIcon(getClass().getResource("/Complementos/Logo Speedex2.png")).getImage()); // Icono del programa
        this.setResizable(false);
        setSize(824, 510); 
        
        lbl_Ingresar.setVisible(false);
        lbl_Modificar.setVisible(false);
        
        cargarCMBProv();
        cargarCMBCat();
        cargarCMBDim();
        
        //Carga manualmente los datos del cmb_ActivoProv
        cmb_ActivoProducto.removeAllItems();
        cmb_ActivoProducto.addItem("1 (Activo)");
        cmb_ActivoProducto.addItem("0 (No activo)");
    }
    
    private void constructorIngresar(){
        añadir = true;
        iniciarComponentes();
        
        lbl_Ingresar.setVisible(true);
    }
    
    public JDialog_Producto(java.awt.Frame parent, boolean modal, String codigo) {
        super(parent, modal);
        initComponents();
        
        constructorIngresar();
        
        txt_CodigoProducto.setText(codigo);
        txt_CodigoProducto.setEditable(false);
    }
    
    public JDialog_Producto(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        constructorIngresar();
    }
    
    public JDialog_Producto(java.awt.Frame parent,boolean modal, Producto prod) {
        super(parent, modal);
        initComponents();
        iniciarComponentes();
        //MODIFICAR VERDADERO
        lbl_Modificar.setVisible(true);
        modificar = true;
        //Cargando los text field con los datos del producto
        txt_CodigoProducto.setText(prod.getId());
        txt_NombreProducto.setText(prod.getNombre());
        txt_StockProducto.setText(String.valueOf(prod.getStock()));
        txt_PrecioProducto.setText(String.valueOf(prod.getPrecio()));
        //Cargando los combo box con los datos del producto
        cmb_IdProvProducto.setSelectedIndex(prod.getId_proveedor()- 1);
        cmb_CatProducoto.setSelectedIndex(prod.getId_categoria() - 1);
        cmb_Dimencion.setSelectedIndex(prod.getId_dimension() - 1);
        
        int activo = 1;   
        if (prod.getActivo() == 1) 
            activo = 0;
        
        cmb_ActivoProducto.setSelectedIndex(activo);
        //Inhabilitando campos importantes
        txt_CodigoProducto.setEditable(false);
        txt_StockProducto.setEditable(false); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_Producto = new javax.swing.JLayeredPane();
        jLabel5 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txt_CodigoProducto = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txt_NombreProducto = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        cmb_IdProvProducto = new javax.swing.JComboBox<>();
        jLabel30 = new javax.swing.JLabel();
        cmb_CatProducoto = new javax.swing.JComboBox<>();
        cmb_ActivoProducto = new javax.swing.JComboBox<>();
        btn_IdProveedor = new javax.swing.JButton();
        btn_CatProd = new javax.swing.JButton();
        txt_StockProducto = new javax.swing.JTextField();
        txt_PrecioProducto = new javax.swing.JTextField();
        btn_LimpiarNombre = new javax.swing.JButton();
        cmb_Dimencion = new javax.swing.JComboBox<>();
        btn_Dimencion = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lbl_Ingresar = new javax.swing.JLabel();
        lbl_Modificar = new javax.swing.JLabel();
        btn_Volver1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btn_Aceptar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_Producto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Textos/Codigo.png"))); // NOI18N
        pnl_Producto.add(jLabel5);
        jLabel5.setBounds(70, 50, 70, 30);

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Textos/Nombre.png"))); // NOI18N
        pnl_Producto.add(jLabel25);
        jLabel25.setBounds(50, 100, 90, 30);

        txt_CodigoProducto.setForeground(new java.awt.Color(0, 153, 153));
        txt_CodigoProducto.setCaretColor(new java.awt.Color(0, 102, 102));
        txt_CodigoProducto.setSelectionColor(new java.awt.Color(255, 153, 51));
        txt_CodigoProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_CodigoProductoKeyPressed(evt);
            }
        });
        pnl_Producto.add(txt_CodigoProducto);
        txt_CodigoProducto.setBounds(160, 50, 140, 30);

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Textos/Precio.png"))); // NOI18N
        pnl_Producto.add(jLabel26);
        jLabel26.setBounds(60, 200, 70, 30);

        txt_NombreProducto.setForeground(new java.awt.Color(0, 153, 153));
        txt_NombreProducto.setCaretColor(new java.awt.Color(0, 102, 102));
        txt_NombreProducto.setSelectionColor(new java.awt.Color(255, 153, 51));
        txt_NombreProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_NombreProductoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_NombreProductoKeyTyped(evt);
            }
        });
        pnl_Producto.add(txt_NombreProducto);
        txt_NombreProducto.setBounds(160, 100, 140, 30);

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Textos/Stock.png"))); // NOI18N
        pnl_Producto.add(jLabel27);
        jLabel27.setBounds(60, 150, 60, 30);

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Textos/Proveedor texto.png"))); // NOI18N
        pnl_Producto.add(jLabel28);
        jLabel28.setBounds(360, 100, 120, 30);

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Textos/Categoria.png"))); // NOI18N
        pnl_Producto.add(jLabel29);
        jLabel29.setBounds(370, 50, 90, 30);

        cmb_IdProvProducto.setForeground(new java.awt.Color(0, 204, 204));
        cmb_IdProvProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmb_IdProvProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmb_IdProvProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmb_IdProvProductoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cmb_IdProvProductoMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cmb_IdProvProductoMousePressed(evt);
            }
        });
        pnl_Producto.add(cmb_IdProvProducto);
        cmb_IdProvProducto.setBounds(500, 100, 130, 30);

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Textos/Activo.png"))); // NOI18N
        pnl_Producto.add(jLabel30);
        jLabel30.setBounds(390, 150, 80, 30);

        cmb_CatProducoto.setForeground(new java.awt.Color(0, 204, 204));
        cmb_CatProducoto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmb_CatProducoto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmb_CatProducoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmb_CatProducotoMouseClicked(evt);
            }
        });
        pnl_Producto.add(cmb_CatProducoto);
        cmb_CatProducoto.setBounds(500, 50, 130, 30);

        cmb_ActivoProducto.setForeground(new java.awt.Color(0, 204, 204));
        cmb_ActivoProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmb_ActivoProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnl_Producto.add(cmb_ActivoProducto);
        cmb_ActivoProducto.setBounds(500, 150, 130, 30);

        btn_IdProveedor.setForeground(new java.awt.Color(0, 204, 204));
        btn_IdProveedor.setText("jButton1");
        btn_IdProveedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_IdProveedor.setFocusPainted(false);
        btn_IdProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_IdProveedorActionPerformed(evt);
            }
        });
        pnl_Producto.add(btn_IdProveedor);
        btn_IdProveedor.setBounds(640, 100, 30, 30);

        btn_CatProd.setForeground(new java.awt.Color(0, 204, 204));
        btn_CatProd.setText("jButton1");
        btn_CatProd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_CatProd.setFocusPainted(false);
        btn_CatProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CatProdActionPerformed(evt);
            }
        });
        pnl_Producto.add(btn_CatProd);
        btn_CatProd.setBounds(640, 50, 30, 30);

        txt_StockProducto.setForeground(new java.awt.Color(0, 153, 153));
        txt_StockProducto.setCaretColor(new java.awt.Color(0, 102, 102));
        txt_StockProducto.setSelectionColor(new java.awt.Color(255, 153, 51));
        txt_StockProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_StockProductoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_StockProductoKeyTyped(evt);
            }
        });
        pnl_Producto.add(txt_StockProducto);
        txt_StockProducto.setBounds(160, 150, 140, 30);

        txt_PrecioProducto.setForeground(new java.awt.Color(0, 153, 153));
        txt_PrecioProducto.setCaretColor(new java.awt.Color(0, 102, 102));
        txt_PrecioProducto.setSelectionColor(new java.awt.Color(255, 153, 51));
        txt_PrecioProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_PrecioProductoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_PrecioProductoKeyTyped(evt);
            }
        });
        pnl_Producto.add(txt_PrecioProducto);
        txt_PrecioProducto.setBounds(160, 200, 140, 30);

        btn_LimpiarNombre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Boton Limpiar.png"))); // NOI18N
        btn_LimpiarNombre.setBorder(null);
        btn_LimpiarNombre.setBorderPainted(false);
        btn_LimpiarNombre.setContentAreaFilled(false);
        btn_LimpiarNombre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_LimpiarNombre.setFocusPainted(false);
        btn_LimpiarNombre.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Boton Limpiar Press.png"))); // NOI18N
        btn_LimpiarNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LimpiarNombreActionPerformed(evt);
            }
        });
        pnl_Producto.add(btn_LimpiarNombre);
        btn_LimpiarNombre.setBounds(680, 230, 50, 40);

        cmb_Dimencion.setForeground(new java.awt.Color(0, 204, 204));
        cmb_Dimencion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmb_Dimencion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnl_Producto.add(cmb_Dimencion);
        cmb_Dimencion.setBounds(500, 200, 130, 30);

        btn_Dimencion.setForeground(new java.awt.Color(0, 204, 204));
        btn_Dimencion.setText("jButton1");
        btn_Dimencion.setFocusPainted(false);
        btn_Dimencion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DimencionActionPerformed(evt);
            }
        });
        pnl_Producto.add(btn_Dimencion);
        btn_Dimencion.setBounds(640, 200, 30, 30);

        jLabel1.setFont(new java.awt.Font("Mairy Extrabold Oblicua", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 204));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Textos/Dimension.png"))); // NOI18N
        pnl_Producto.add(jLabel1);
        jLabel1.setBounds(370, 200, 110, 30);

        getContentPane().add(pnl_Producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 740, 280));

        lbl_Ingresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Textos/Ingresar Producto.png"))); // NOI18N
        getContentPane().add(lbl_Ingresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 450, -1));

        lbl_Modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Textos/Modificar Producto.png"))); // NOI18N
        getContentPane().add(lbl_Modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 800, -1));

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
        getContentPane().add(btn_Volver1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 400, 70, 60));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Logo Speedex Mini4.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, -1, 60));

        btn_Aceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Boton Aceptar.png"))); // NOI18N
        btn_Aceptar.setBorder(null);
        btn_Aceptar.setBorderPainted(false);
        btn_Aceptar.setContentAreaFilled(false);
        btn_Aceptar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Aceptar.setFocusPainted(false);
        btn_Aceptar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Boton Aceptar Press2.png"))); // NOI18N
        btn_Aceptar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Boton Aceptar Mouse.png"))); // NOI18N
        btn_Aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AceptarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Aceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 410, 170, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Fondo Proceso.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmb_IdProvProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmb_IdProvProductoMouseClicked

    }//GEN-LAST:event_cmb_IdProvProductoMouseClicked

    private void cmb_IdProvProductoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmb_IdProvProductoMouseEntered

    }//GEN-LAST:event_cmb_IdProvProductoMouseEntered

    private void cmb_IdProvProductoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmb_IdProvProductoMousePressed
        //cargarCMBProv();
    }//GEN-LAST:event_cmb_IdProvProductoMousePressed

    private void cmb_CatProducotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmb_CatProducotoMouseClicked
        //cargarCMBCat();
    }//GEN-LAST:event_cmb_CatProducotoMouseClicked

    private void btn_IdProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_IdProveedorActionPerformed
        JDialog_Proveedor jdpv = new JDialog_Proveedor(new javax.swing.JDialog(), true);
        jdpv.setVisible(true);

        cargarCMBProv();
        
        if (jdpv.seleccionarID() != 0)
            cmb_IdProvProducto.setSelectedIndex((jdpv.seleccionarID() - 1));
    }//GEN-LAST:event_btn_IdProveedorActionPerformed

    private void btn_CatProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CatProdActionPerformed
        JDialog_Categoria jdcat = new JDialog_Categoria(new javax.swing.JDialog(), true);
        jdcat.setVisible(true);

        //if (jdcat.creoCat()) 
            cargarCMBCat();

        if (jdcat.idSeleccionado() != 0) 
            cmb_CatProducoto.setSelectedIndex(jdcat.idSeleccionado() - 1);
    }//GEN-LAST:event_btn_CatProdActionPerformed

    private void btn_LimpiarNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LimpiarNombreActionPerformed
        limpiar();
    }//GEN-LAST:event_btn_LimpiarNombreActionPerformed
    private void limpiar(){
        if (añadir) {
            txt_CodigoProducto.setText("");
            txt_StockProducto.setText("");
        }
        this.txt_NombreProducto.setText("");
        this.txt_PrecioProducto.setText("");
        cmb_CatProducoto.setSelectedIndex(0);
        cmb_IdProvProducto.setSelectedIndex(0);
    }
    private void btn_Volver1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Volver1ActionPerformed
        añadir = false;
        modificar = false;
        this.setVisible(false);
    }//GEN-LAST:event_btn_Volver1ActionPerformed
    
    private void btn_AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AceptarActionPerformed
        if (añadir) 
            añadirProducto();
        else if (modificar)
            modificarProducto();
    }//GEN-LAST:event_btn_AceptarActionPerformed

    private void txt_NombreProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_NombreProductoKeyTyped
        Validar v = new Validar();       
        if (!v.maximoLargo(txt_NombreProducto.getText(), 30))
            evt.consume();
//
//        if(Character.isDigit(evt.getKeyChar())) 
//            evt.consume(); 
    }//GEN-LAST:event_txt_NombreProductoKeyTyped

    private void txt_StockProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_StockProductoKeyTyped
        Validar v = new Validar();       
        if (!v.maximoLargo(txt_StockProducto.getText(), 4))
            evt.consume();

        if(!Character.isDigit(evt.getKeyChar())) 
            evt.consume(); 
    }//GEN-LAST:event_txt_StockProductoKeyTyped

    private void txt_PrecioProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_PrecioProductoKeyTyped
        Validar v = new Validar();       
        if (!v.maximoLargo(txt_PrecioProducto.getText(), 9))
            evt.consume();

        if(!Character.isDigit(evt.getKeyChar())) 
            evt.consume(); 
    }//GEN-LAST:event_txt_PrecioProductoKeyTyped

    private void txt_CodigoProductoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_CodigoProductoKeyPressed
        if (añadir) {
            if(evt.getKeyCode() == KeyEvent.VK_ENTER)
                añadirProducto();
        }
    }//GEN-LAST:event_txt_CodigoProductoKeyPressed

    private void txt_NombreProductoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_NombreProductoKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER && añadir)
            añadirProducto();
        else if(evt.getKeyCode() == KeyEvent.VK_ENTER && modificar)
            modificarProducto();
    }//GEN-LAST:event_txt_NombreProductoKeyPressed

    private void txt_StockProductoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_StockProductoKeyPressed
         if(evt.getKeyCode() == KeyEvent.VK_ENTER && añadir)
            añadirProducto();
        else if(evt.getKeyCode() == KeyEvent.VK_ENTER && modificar)
            modificarProducto();
    }//GEN-LAST:event_txt_StockProductoKeyPressed

    private void txt_PrecioProductoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_PrecioProductoKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER && añadir)
            añadirProducto();
        else if(evt.getKeyCode() == KeyEvent.VK_ENTER && modificar)
            modificarProducto();
    }//GEN-LAST:event_txt_PrecioProductoKeyPressed

    private void btn_DimencionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DimencionActionPerformed
        JDimension jdim = new JDimension(new javax.swing.JDialog(), true);
        jdim.setVisible(true);
        
        cargarCMBDim();
        
        if (jdim.idSeleccionado() != 0) 
            cmb_Dimencion.setSelectedIndex(jdim.idSeleccionado() - 1);
    }//GEN-LAST:event_btn_DimencionActionPerformed

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
            java.util.logging.Logger.getLogger(JDialog_Producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDialog_Producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDialog_Producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDialog_Producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDialog_Producto dialog = new JDialog_Producto(new javax.swing.JDialog(), true);
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
    private javax.swing.JButton btn_Aceptar;
    private javax.swing.JButton btn_CatProd;
    private javax.swing.JButton btn_Dimencion;
    private javax.swing.JButton btn_IdProveedor;
    private javax.swing.JButton btn_LimpiarNombre;
    private javax.swing.JButton btn_Volver1;
    private javax.swing.JComboBox<String> cmb_ActivoProducto;
    private javax.swing.JComboBox<String> cmb_CatProducoto;
    private javax.swing.JComboBox<String> cmb_Dimencion;
    private javax.swing.JComboBox<String> cmb_IdProvProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lbl_Ingresar;
    private javax.swing.JLabel lbl_Modificar;
    private javax.swing.JLayeredPane pnl_Producto;
    private javax.swing.JTextField txt_CodigoProducto;
    private javax.swing.JTextField txt_NombreProducto;
    private javax.swing.JTextField txt_PrecioProducto;
    private javax.swing.JTextField txt_StockProducto;
    // End of variables declaration//GEN-END:variables

    private void modificarProducto() {
        Producto prod = cargarDatos();
        if (prod != null) {
            if (prod.actualizarProducto())
                JOptionPane.showMessageDialog(null, "Datos editados correctamente.","Datos producto editados",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void cargarCMBProv(){
        Proveedor prov = new Proveedor();
        
        cmb_IdProvProducto.removeAllItems();
        
        ArrayList<Proveedor> listaIDProv = prov.buscarDatosProveedor(false, "", "");
        
        for (int i = 0; i < listaIDProv.size(); i++) 
            cmb_IdProvProducto.addItem(String.valueOf(listaIDProv.get(i).getId()));       
    }
    
    private void cargarCMBCat(){
        Categoria_Producto catp = new Categoria_Producto();
        
        cmb_CatProducoto.removeAllItems();
        
        ArrayList<Categoria_Producto> listaID = catp.buscarDatosCategoria(false, "", "");
        
        for (int i = 0; i < listaID.size(); i++) 
            cmb_CatProducoto.addItem(String.valueOf(listaID.get(i).getId()));
    }

    private void cargarCMBDim() {
        Dimension dim = new Dimension();
        
        cmb_Dimencion.removeAllItems();
        
        ArrayList<Dimension> listaIDDim = dim.buscarDatosDimension(false, "", "","Dimension_Prod");
        
        for (int i = 0; i < listaIDDim.size(); i++) 
            cmb_Dimencion.addItem(String.valueOf(listaIDDim.get(i).getNumero()));       
    }
}