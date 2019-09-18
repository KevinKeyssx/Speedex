package Interfaz;

import Clases.Producto;
import Clases.Proveedor;
import Clases.Validar;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * @author keiss
 */
public class JComprar extends javax.swing.JDialog {

    private void cargarCMBProv(){
        Proveedor prov = new Proveedor();
        
        cmb_Proveedor.removeAllItems();
        
        ArrayList<Proveedor> listaIDProv = prov.buscarDatosProveedor(false, "", "");
        
        for (int i = 0; i < listaIDProv.size(); i++) 
            cmb_Proveedor.addItem(String.valueOf(listaIDProv.get(i).getId())); 
    }
    
    private void cargarCMBProducto(){
        Producto prod = new Producto();
        
        cmb_Producto.removeAllItems();

        ArrayList<Producto> listaProd = prod.buscarDatosProducto(false, cmb_Proveedor.getSelectedItem().toString(), "Id_Proveedor", false);
        
        for (int i = 0; i < listaProd.size(); i++) 
            cmb_Producto.addItem(String.valueOf(listaProd.get(i).getId()));     
    }
    
    public JComprar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cargarCMBProv();
        cargarCMBProducto();
        
        setTitle("Comprar - SpeedeX");
        this.setLocationRelativeTo(null); //Centrar el JFrame al centro de la pantalla
        setIconImage(new ImageIcon(getClass().getResource("/Complementos/Logo Speedex2.png")).getImage()); // Icono del programa
        this.setResizable(false);
        setSize(540, 405);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        cmb_Proveedor = new javax.swing.JComboBox<>();
        cmb_Producto = new javax.swing.JComboBox<>();
        txt_Stock = new javax.swing.JTextField();
        btn_Proveedor = new javax.swing.JButton();
        btn_Producto = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btn_Volver1 = new javax.swing.JButton();
        btn_Aceptar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLayeredPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLayeredPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cmb_Proveedor.setForeground(new java.awt.Color(0, 204, 204));
        cmb_Proveedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmb_Proveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmb_ProveedorMouseClicked(evt);
            }
        });
        cmb_Proveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_ProveedorActionPerformed(evt);
            }
        });
        jLayeredPane1.add(cmb_Proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 130, 30));

        cmb_Producto.setForeground(new java.awt.Color(0, 204, 204));
        cmb_Producto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jLayeredPane1.add(cmb_Producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 130, 30));

        txt_Stock.setForeground(new java.awt.Color(0, 153, 153));
        txt_Stock.setSelectionColor(new java.awt.Color(255, 153, 51));
        txt_Stock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_StockKeyTyped(evt);
            }
        });
        jLayeredPane1.add(txt_Stock, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 140, 30));

        btn_Proveedor.setText("jButton1");
        btn_Proveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ProveedorActionPerformed(evt);
            }
        });
        jLayeredPane1.add(btn_Proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, 30, 30));

        btn_Producto.setText("jButton2");
        btn_Producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ProductoActionPerformed(evt);
            }
        });
        jLayeredPane1.add(btn_Producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 30, 30, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Textos/Proveedor texto.png"))); // NOI18N
        jLayeredPane1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, -1, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Textos/Codigo.png"))); // NOI18N
        jLayeredPane1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, -1, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Textos/Stock.png"))); // NOI18N
        jLayeredPane1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, -1, 30));

        getContentPane().add(jLayeredPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 470, 230));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Logo Speedex Mini4.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

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
        getContentPane().add(btn_Volver1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 310, 70, 60));

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
        getContentPane().add(btn_Aceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 320, 170, 40));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Textos/Comprar.png"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Fondo Proceso.jpg"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_Volver1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Volver1ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btn_Volver1ActionPerformed

    private void btn_AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AceptarActionPerformed
        comprar();
    }//GEN-LAST:event_btn_AceptarActionPerformed

    private void cmb_ProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmb_ProveedorMouseClicked
       cargarCMBProducto();
    }//GEN-LAST:event_cmb_ProveedorMouseClicked

    private void cmb_ProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_ProveedorActionPerformed
        //cargarCMBProducto();
    }//GEN-LAST:event_cmb_ProveedorActionPerformed

    private void btn_ProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ProveedorActionPerformed
        JDialog_Proveedor jprov = new JDialog_Proveedor(this, true);
        jprov.setVisible(true);
        
        cargarCMBProv();
        int id = jprov.ultimoID();
        
        if (id != 0) 
            cmb_Proveedor.setSelectedIndex((jprov.ultimoID() - 1));
    }//GEN-LAST:event_btn_ProveedorActionPerformed

    private void btn_ProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ProductoActionPerformed
        JDialog_Producto jprod = new JDialog_Producto(this, true);
        jprod.setVisible(true);
    }//GEN-LAST:event_btn_ProductoActionPerformed

    private void txt_StockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_StockKeyTyped
        Validar v = new Validar();       
        if (!v.maximoLargo(txt_Stock.getText(), 4))
            evt.consume();

        if(!Character.isDigit(evt.getKeyChar())) 
            evt.consume(); 
    }//GEN-LAST:event_txt_StockKeyTyped

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
            java.util.logging.Logger.getLogger(JComprar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JComprar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JComprar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JComprar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JComprar dialog = new JComprar(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btn_Producto;
    private javax.swing.JButton btn_Proveedor;
    private javax.swing.JButton btn_Volver1;
    private javax.swing.JComboBox<String> cmb_Producto;
    private javax.swing.JComboBox<String> cmb_Proveedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JTextField txt_Stock;
    // End of variables declaration//GEN-END:variables

    private void comprar() {
        Validar v = new Validar();
        if (!v.campoVacio(txt_Stock.getText()) ) {
            if (v.stockMaximo(cmb_Producto.getSelectedItem().toString(),Integer.valueOf(txt_Stock.getText()))) {
                Producto prod = cargarDatos();
                
                if (prod != null) {
                    if(prod.actualizarProducto())
                        JOptionPane.showMessageDialog(null, "Compra realizada","Información!",JOptionPane.INFORMATION_MESSAGE);
                }
            }
            else
                JOptionPane.showMessageDialog(null, "El stock no puede superar al stock máximo","Cuidado!",JOptionPane.WARNING_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null, "El stock esá vacío","Campo vacío",JOptionPane.WARNING_MESSAGE);
            txt_Stock.requestFocus();
        } 
    }
    
    private Producto cargarDatos(){
        Producto prod = new Producto();
        Validar v = new Validar();
        prod.buscarProducto((String) cmb_Producto.getSelectedItem());
        
        prod.setId(prod.buscarProducto(cmb_Producto.getSelectedItem().toString()).getId());
        prod.setNombre(prod.buscarProducto(cmb_Producto.getSelectedItem().toString()).getNombre());
        prod.setStock((prod.buscarProducto(cmb_Producto.getSelectedItem().toString()).getStock() + Integer.valueOf(txt_Stock.getText())));
        prod.setPrecio(prod.buscarProducto(cmb_Producto.getSelectedItem().toString()).getPrecio());
        prod.setId_categoria(prod.buscarProducto(cmb_Producto.getSelectedItem().toString()).getId_categoria());
        prod.setId_proveedor(prod.buscarProducto(cmb_Producto.getSelectedItem().toString()).getId_proveedor());
        prod.setActivo(prod.buscarProducto(cmb_Producto.getSelectedItem().toString()).getActivo());

        return prod;
    }   
}