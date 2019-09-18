package Interfaz;

import Clases.Categoria_Producto;
import Clases.Validar;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 * @author keiss
 */
public class JDialog_Categoria extends javax.swing.JDialog {

    DefaultTableModel modelo1;
    static String [] nombre;
    static boolean busqueda = false;
    
    private void cargarTablaCat(){
        Categoria_Producto cat = new Categoria_Producto();
        Validar v = new Validar();
        ArrayList <Categoria_Producto> cargarDatosCat = new ArrayList();
        
        modelo1 = (DefaultTableModel)tb_ConsultaCatProd.getModel();
        
        String tabla = v.obtenerTablaCat(txt_BuscarCat.getText());
        
        cargarDatosCat = cat.buscarDatosCategoria(busqueda, tabla, txt_BuscarCat.getText());
        
        if (cargarDatosCat == null || cargarDatosCat.size() == 0) 
        {//JOptionPane.showMessageDialog(null, "No se encontro ningún dato o aún no tiene ningún producto.","Información!",JOptionPane.INFORMATION_MESSAGE);
            for (int i = tb_ConsultaCatProd.getRowCount() -1; i >= 0; i--)
                    modelo1.removeRow(i); 
        }else{
            DefaultTableCellRenderer Alinear = new DefaultTableCellRenderer();
            Alinear.setHorizontalAlignment(SwingConstants.CENTER);//alinea  en el centro datos de la tabla 

            for (int i = tb_ConsultaCatProd.getRowCount() -1; i >= 0; i--)
                    modelo1.removeRow(i); 
            
            for (int i = 0; i < 3; i++) 
                tb_ConsultaCatProd.getColumnModel().getColumn(i).setCellRenderer(Alinear); //llama a centrar los dtos de las columnas de la tabla
            
            //datos que se cargaran en la tabla
            Object[] fila = new Object[modelo1.getColumnCount()];   
            String []nombre2 = new String[cargarDatosCat.size()];
            for (int i = 0; i < cargarDatosCat.size(); i++) {

                fila[0]=cargarDatosCat.get(i).getId();            
                fila[1]=cargarDatosCat.get(i).getNombre();
                nombre2[i] = cargarDatosCat.get(i).getNombre();
                fila[2]=cargarDatosCat.get(i).getDescripcion();

                modelo1.addRow(fila);
            }
            nombre = nombre2;
            tb_ConsultaCatProd.getColumnModel().getColumn(0).setPreferredWidth(27);
            tb_ConsultaCatProd.getColumnModel().getColumn(1).setPreferredWidth(100);
            tb_ConsultaCatProd.getColumnModel().getColumn(2).setPreferredWidth(100); 
            
            tb_ConsultaCatProd.setModel(modelo1);
            
        }
    }
    
    public JDialog_Categoria(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        setTitle("Nueva Categoría - SpeedeX");
        this.setLocationRelativeTo(null); //Centrar el JFrame al centro de la pantalla
        this.setResizable(false); //No permite modificar el tamaño
        setSize(580, 500); //Tamaño por defecto
        setIconImage(new ImageIcon(getClass().getResource("/Complementos/Logo Speedex2.png")).getImage()); //Icono de la app
        
        cargarTablaCat();
        
        Categoria_Producto catp = new Categoria_Producto();
        lbl_Codigo.setText(String.valueOf(catp.ObtenerCatId().getId() + 1) );
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbl_Codigo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_NombreCatProd = new javax.swing.JTextField();
        btn_LimpiarNombre = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_DescCatProd = new javax.swing.JTextPane();
        btn_Volver = new javax.swing.JButton();
        btn_Crear = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btn_Crear1 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_ConsultaCatProd = new javax.swing.JTable();
        txt_BuscarCat = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Textos/Crea una.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, -1, 20));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Textos/Codigo.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, -1, -1));

        lbl_Codigo.setFont(new java.awt.Font("Mairy Book", 0, 18)); // NOI18N
        lbl_Codigo.setForeground(new java.awt.Color(0, 204, 204));
        lbl_Codigo.setText("---");
        getContentPane().add(lbl_Codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 40, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Textos/Nombre.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, -1, -1));

        txt_NombreCatProd.setForeground(new java.awt.Color(0, 153, 153));
        txt_NombreCatProd.setSelectionColor(new java.awt.Color(255, 153, 51));
        txt_NombreCatProd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_NombreCatProdKeyTyped(evt);
            }
        });
        getContentPane().add(txt_NombreCatProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 203, 29));

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
        getContentPane().add(btn_LimpiarNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, 40, 40));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Textos/Describelo.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, -1, -1));

        txt_DescCatProd.setForeground(new java.awt.Color(0, 153, 153));
        txt_DescCatProd.setSelectionColor(new java.awt.Color(255, 153, 51));
        txt_DescCatProd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_DescCatProdKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(txt_DescCatProd);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, 200, 91));

        btn_Volver.setForeground(new java.awt.Color(255, 51, 51));
        btn_Volver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Boton Volver.png"))); // NOI18N
        btn_Volver.setBorderPainted(false);
        btn_Volver.setContentAreaFilled(false);
        btn_Volver.setFocusPainted(false);
        btn_Volver.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Boton Volver Press.png"))); // NOI18N
        btn_Volver.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Boton Volver Mouse.png"))); // NOI18N
        btn_Volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_VolverActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 390, 70, 70));

        btn_Crear.setForeground(new java.awt.Color(0, 204, 204));
        btn_Crear.setText("Crear");
        btn_Crear.setFocusPainted(false);
        btn_Crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CrearActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Crear, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 410, 90, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Lupa.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 100, 30, -1));

        btn_Crear1.setForeground(new java.awt.Color(0, 204, 204));
        btn_Crear1.setText("Seleccionar...");
        btn_Crear1.setFocusPainted(false);
        btn_Crear1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Crear1ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Crear1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 410, 130, 30));

        jButton1.setForeground(new java.awt.Color(0, 204, 204));
        jButton1.setText("Editar");
        jButton1.setFocusPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 410, 80, 30));

        tb_ConsultaCatProd.setBackground(new java.awt.Color(204, 204, 255));
        tb_ConsultaCatProd.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tb_ConsultaCatProd.setForeground(new java.awt.Color(0, 153, 153));
        tb_ConsultaCatProd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Descripción"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_ConsultaCatProd.setGridColor(new java.awt.Color(0, 51, 51));
        tb_ConsultaCatProd.setSelectionBackground(new java.awt.Color(0, 102, 153));
        tb_ConsultaCatProd.setSelectionForeground(new java.awt.Color(204, 255, 255));
        jScrollPane2.setViewportView(tb_ConsultaCatProd);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, 230, 250));

        txt_BuscarCat.setForeground(new java.awt.Color(0, 153, 153));
        txt_BuscarCat.setSelectionColor(new java.awt.Color(255, 153, 51));
        txt_BuscarCat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_BuscarCatKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_BuscarCatKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_BuscarCatKeyTyped(evt);
            }
        });
        getContentPane().add(txt_BuscarCat, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, 230, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 204, 204));
        jLabel7.setText("Búscalo:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, 70, 30));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Fondo Proceso.jpg"))); // NOI18N
        jLabel6.setText("jLabel6");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_LimpiarNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LimpiarNombreActionPerformed
        limpiar();
    }//GEN-LAST:event_btn_LimpiarNombreActionPerformed
    private void limpiar(){
        txt_NombreCatProd.setText("");
        txt_DescCatProd.setText("");
    }
    private void btn_VolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_VolverActionPerformed
        busqueda = false;
        this.setVisible(false);
        if (creo) {
            creo = false;
        }
    }//GEN-LAST:event_btn_VolverActionPerformed
    public boolean creoCat(){
        return creo;
    }
    
    static boolean creo = false;
    
    private void btn_CrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CrearActionPerformed
        Validar v = new Validar();
        
        if (!v.campoVacio(txt_NombreCatProd.getText()) && !v.campoVacio(txt_DescCatProd.getText())) 
            crearCategoria();
        else
            JOptionPane.showMessageDialog(null, "Los campos no pueden quedar vacíos.","Cuidado!",JOptionPane.WARNING_MESSAGE);
        
    }//GEN-LAST:event_btn_CrearActionPerformed
    public int idSeleccionado (){
        return id; //getValueAt ob tiene el valor de la fila
    }
    static int id = 0;
    
    private void btn_Crear1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Crear1ActionPerformed
        int filaseleccionada = tb_ConsultaCatProd.getSelectedRow();
        
        if (filaseleccionada >= 0){
            id = Integer.valueOf(tb_ConsultaCatProd.getValueAt(filaseleccionada, 0).toString()) ; //getValueAt ob tiene el valor de la fila
            idSeleccionado();
            this.setVisible(false);  
        }
        else
            JOptionPane.showMessageDialog(null, "Seleccione una categoria.","Seleccione",JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_btn_Crear1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int filaseleccionada = tb_ConsultaCatProd.getSelectedRow();

        if (filaseleccionada >= 0) {
            Categoria_Producto catp = new Categoria_Producto();

            catp.setId(Integer.valueOf(tb_ConsultaCatProd.getValueAt(filaseleccionada, 0).toString())) ;
            catp.setNombre(tb_ConsultaCatProd.getValueAt(filaseleccionada, 1).toString());
            catp.setDescripcion(tb_ConsultaCatProd.getValueAt(filaseleccionada, 2).toString());

            if (!catp.getNombre().equals("") && catp.getNombre() != null && !catp.getDescripcion().equals("") && catp.getDescripcion() != null) {

                if(JOptionPane.showConfirmDialog(null, "Seguro que quieres editar la categoría: "+catp.getId()+": "+nombre[filaseleccionada]+" a "+catp.getNombre()+"?", "Editar", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE)==JOptionPane.YES_OPTION){
                    if (catp.actualizarProveedor())
                    JOptionPane.showMessageDialog(null, "Datos editados correctamente.","Datos categoría editados",JOptionPane.INFORMATION_MESSAGE);
                }
                //else
                //tb_ConsultaCatProd.getValueAt(filaseleccionada, 1).toString() = nombre[filaseleccionada];
            }
            else
            JOptionPane.showMessageDialog(null, "Ingresa datos válidos","Datos vacíos",JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_BuscarCatKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_BuscarCatKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            busqueda = true;

            cargarTablaCat();
        }
    }//GEN-LAST:event_txt_BuscarCatKeyPressed

    private void txt_BuscarCatKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_BuscarCatKeyReleased
        busqueda = true;
        cargarTablaCat();
    }//GEN-LAST:event_txt_BuscarCatKeyReleased

    private void txt_NombreCatProdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_NombreCatProdKeyTyped
        Validar v = new Validar();       
        if (!v.maximoLargo(txt_NombreCatProd.getText(), 20))
            evt.consume();
    }//GEN-LAST:event_txt_NombreCatProdKeyTyped

    private void txt_DescCatProdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_DescCatProdKeyTyped
        Validar v = new Validar();       
        if (!v.maximoLargo(txt_DescCatProd.getText(), 60))
            evt.consume();
    }//GEN-LAST:event_txt_DescCatProdKeyTyped

    private void txt_BuscarCatKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_BuscarCatKeyTyped
        Validar v = new Validar();       
        if (!v.maximoLargo(txt_BuscarCat.getText(), 20))
            evt.consume();
    }//GEN-LAST:event_txt_BuscarCatKeyTyped

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
            java.util.logging.Logger.getLogger(JDialog_Categoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDialog_Categoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDialog_Categoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDialog_Categoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDialog_Categoria dialog = new JDialog_Categoria(new javax.swing.JDialog(), true);
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
    private javax.swing.JButton btn_Crear;
    private javax.swing.JButton btn_Crear1;
    private javax.swing.JButton btn_LimpiarNombre;
    private javax.swing.JButton btn_Volver;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_Codigo;
    private javax.swing.JTable tb_ConsultaCatProd;
    private javax.swing.JTextField txt_BuscarCat;
    private javax.swing.JTextPane txt_DescCatProd;
    private javax.swing.JTextField txt_NombreCatProd;
    // End of variables declaration//GEN-END:variables

    private void crearCategoria() {
        Categoria_Producto catp = new Categoria_Producto();
        catp.setNombre(txt_NombreCatProd.getText());
        catp.setDescripcion(txt_DescCatProd.getText());

        if(catp.insertarCat_Producto()){
            JOptionPane.showMessageDialog(null, "La categoría: "+catp.getNombre()+", fue añadida correctamente.","Categoría ingresada",JOptionPane.INFORMATION_MESSAGE);

            lbl_Codigo.setText(String.valueOf((Integer.parseInt(lbl_Codigo.getText() )+ 1)));

            String []datos = new String[3];
            datos[0] = String.valueOf(Integer.valueOf(lbl_Codigo.getText()) - 1);
            datos[1] = txt_NombreCatProd.getText();
            datos[2] = txt_DescCatProd.getText();

            modelo1.addRow(datos);
            creo = true;
            limpiar();
        }
    }
}