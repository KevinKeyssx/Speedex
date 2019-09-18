package Interfaz;

import Clases.Dimension;
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
public class JDimension extends javax.swing.JDialog {

    /**
     * Creates new form JDimension
     * @param parent
     * @param modal
     */
    
    DefaultTableModel modelo;
    static boolean busqueda = false;
    static int id;
    
    public JDimension(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        Dimension dim = new Dimension();
               
        setTitle("Dimensión - SpeedeX");
        this.setLocationRelativeTo(null); //Centrar el JFrame al centro de la pantalla
        this.setResizable(false); //No permite modificar el tamaño
        setSize(650, 440); //Tamaño por defecto
        setIconImage(new ImageIcon(getClass().getResource("/Complementos/Logo Speedex2.png")).getImage()); //Icono de la app
        lbl_Codigo.setText(String.valueOf(dim.calculaDimension("", "Id_Dimension", 0).getNumero() + 1));
        tablaDimension();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tb_Dimension = new javax.swing.JTable();
        txt_Peso = new javax.swing.JTextField();
        txt_Alto = new javax.swing.JTextField();
        txt_Ancho = new javax.swing.JTextField();
        txt_Largo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_Busqueda = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btn_Volver1 = new javax.swing.JButton();
        btn_Crear = new javax.swing.JButton();
        btn_LimpiarNombre = new javax.swing.JButton();
        btn_Seleccionar = new javax.swing.JButton();
        btn_Editar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        lbl_Codigo = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tb_Dimension.setBackground(new java.awt.Color(204, 204, 255));
        tb_Dimension.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tb_Dimension.setForeground(new java.awt.Color(0, 153, 153));
        tb_Dimension.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Número", "Alto", "Ancho", "Largo", "Peso"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tb_Dimension.setGridColor(new java.awt.Color(0, 51, 51));
        tb_Dimension.setSelectionBackground(new java.awt.Color(0, 102, 153));
        tb_Dimension.setSelectionForeground(new java.awt.Color(204, 255, 255));
        tb_Dimension.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_DimensionMouseClicked(evt);
            }
        });
        tb_Dimension.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tb_DimensionKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(tb_Dimension);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 140, 320, 190));

        txt_Peso.setForeground(new java.awt.Color(0, 153, 153));
        txt_Peso.setSelectionColor(new java.awt.Color(255, 153, 51));
        txt_Peso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_PesoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_PesoKeyTyped(evt);
            }
        });
        getContentPane().add(txt_Peso, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 280, 100, 30));

        txt_Alto.setForeground(new java.awt.Color(0, 153, 153));
        txt_Alto.setSelectionColor(new java.awt.Color(255, 153, 51));
        txt_Alto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_AltoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_AltoKeyTyped(evt);
            }
        });
        getContentPane().add(txt_Alto, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 100, 30));

        txt_Ancho.setForeground(new java.awt.Color(0, 153, 153));
        txt_Ancho.setSelectionColor(new java.awt.Color(255, 153, 51));
        txt_Ancho.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_AnchoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_AnchoKeyTyped(evt);
            }
        });
        getContentPane().add(txt_Ancho, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 100, 30));

        txt_Largo.setForeground(new java.awt.Color(0, 153, 153));
        txt_Largo.setSelectionColor(new java.awt.Color(255, 153, 51));
        txt_Largo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_LargoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_LargoKeyTyped(evt);
            }
        });
        getContentPane().add(txt_Largo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, 100, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Textos/Peso.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 60, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Textos/Alto.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 60, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Textos/Ancho.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 70, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Textos/Largo.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 70, 30));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Lupa.png"))); // NOI18N
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 90, 30, -1));

        txt_Busqueda.setForeground(new java.awt.Color(0, 153, 153));
        txt_Busqueda.setSelectionColor(new java.awt.Color(255, 153, 51));
        txt_Busqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_BusquedaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_BusquedaKeyTyped(evt);
            }
        });
        getContentPane().add(txt_Busqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, 200, 30));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Textos/Buscar.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, 60, 30));

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
        getContentPane().add(btn_Volver1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 70, 60));

        btn_Crear.setForeground(new java.awt.Color(0, 204, 204));
        btn_Crear.setText("Crear");
        btn_Crear.setFocusPainted(false);
        btn_Crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CrearActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Crear, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 340, 70, 30));

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
        getContentPane().add(btn_LimpiarNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 350, -1, -1));

        btn_Seleccionar.setForeground(new java.awt.Color(0, 204, 204));
        btn_Seleccionar.setText("Seleccionar...");
        btn_Seleccionar.setFocusPainted(false);
        btn_Seleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SeleccionarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Seleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 350, 130, 30));

        btn_Editar.setForeground(new java.awt.Color(0, 204, 204));
        btn_Editar.setText("Editar");
        btn_Editar.setFocusPainted(false);
        btn_Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EditarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Editar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 350, 80, 30));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Textos/Codigo.png"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, -1, 30));

        lbl_Codigo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_Codigo.setForeground(new java.awt.Color(0, 204, 204));
        lbl_Codigo.setText("jLabel7");
        getContentPane().add(lbl_Codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 100, 30));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Textos/Crea una dimension.png"))); // NOI18N
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 220, 20));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Fondo Proceso.jpg"))); // NOI18N
        jLabel8.setText("jLabel6");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tb_DimensionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_DimensionMouseClicked
       
    }//GEN-LAST:event_tb_DimensionMouseClicked

    private void btn_Volver1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Volver1ActionPerformed
        id = 0;
        this.setVisible(false);
    }//GEN-LAST:event_btn_Volver1ActionPerformed

    private void btn_LimpiarNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LimpiarNombreActionPerformed
        limpiar();
    }//GEN-LAST:event_btn_LimpiarNombreActionPerformed

    private void btn_SeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SeleccionarActionPerformed
        int filaseleccionada = tb_Dimension.getSelectedRow();

        if (filaseleccionada >= 0){
            id = Integer.valueOf(tb_Dimension.getValueAt(filaseleccionada, 0).toString()) ; //getValueAt ob tiene el valor de la fila
            idSeleccionado();
            this.setVisible(false);
        }
        else
            JOptionPane.showMessageDialog(null, "Seleccione una categoria.","Seleccione",JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btn_SeleccionarActionPerformed

    private void btn_EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EditarActionPerformed
        modificar();
    }//GEN-LAST:event_btn_EditarActionPerformed

    private void btn_CrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CrearActionPerformed
        Validar v = new Validar();
        //if (v.validaIngresoDim(txt_Alto.getText()) && v.validaIngresoDim(txt_Ancho.getText()) && v.validaIngresoDim(txt_Largo.getText()) && v.validaIngresoDim(txt_Peso.getText())) {
            crear();
        //}
        //else
            //JOptionPane.showMessageDialog(null, "Algunos valores ingresados no son válidos.","Ingreso inválido",JOptionPane.WARNING_MESSAGE);
        
    }//GEN-LAST:event_btn_CrearActionPerformed

    private void txt_AltoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_AltoKeyTyped
        Validar v = new Validar();       
        if (!v.maximoLargo(txt_Alto.getText(), 3))
            evt.consume();

        if(!Character.isDigit(evt.getKeyChar())) 
            evt.consume(); 
    }//GEN-LAST:event_txt_AltoKeyTyped

    private void txt_AnchoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_AnchoKeyTyped
        Validar v = new Validar();       
        if (!v.maximoLargo(txt_Ancho.getText(), 3))
            evt.consume();

        if(!Character.isDigit(evt.getKeyChar())) 
            evt.consume();
    }//GEN-LAST:event_txt_AnchoKeyTyped

    private void txt_LargoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_LargoKeyTyped
        Validar v = new Validar();       
        if (!v.maximoLargo(txt_Largo.getText(), 3))
            evt.consume();

        if(!Character.isDigit(evt.getKeyChar())) 
            evt.consume();
    }//GEN-LAST:event_txt_LargoKeyTyped

    private void txt_PesoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_PesoKeyTyped
        Validar v = new Validar();       
        if (!v.maximoLargo(txt_Peso.getText(), 5))
            evt.consume();

        if(!Character.isDigit(evt.getKeyChar())) 
            evt.consume();
    }//GEN-LAST:event_txt_PesoKeyTyped

    private void txt_BusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_BusquedaKeyReleased
        busqueda = true;
        tablaDimension();
    }//GEN-LAST:event_txt_BusquedaKeyReleased

    private void txt_BusquedaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_BusquedaKeyTyped
        Validar v = new Validar();       
        if (!v.maximoLargo(txt_Ancho.getText(), 9))
            evt.consume();

        if(!Character.isDigit(evt.getKeyChar())) 
            evt.consume();
    }//GEN-LAST:event_txt_BusquedaKeyTyped

    private void txt_AltoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_AltoKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
            crear();
    }//GEN-LAST:event_txt_AltoKeyPressed

    private void txt_AnchoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_AnchoKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
           crear();
    }//GEN-LAST:event_txt_AnchoKeyPressed

    private void txt_LargoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_LargoKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
           crear();
    }//GEN-LAST:event_txt_LargoKeyPressed

    private void txt_PesoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_PesoKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
           crear();
    }//GEN-LAST:event_txt_PesoKeyPressed

    private void tb_DimensionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_DimensionKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
            modificar();
    }//GEN-LAST:event_tb_DimensionKeyPressed

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
            java.util.logging.Logger.getLogger(JDimension.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDimension.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDimension.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDimension.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDimension dialog = new JDimension(new javax.swing.JDialog(), true);
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
    private javax.swing.JButton btn_Editar;
    private javax.swing.JButton btn_LimpiarNombre;
    private javax.swing.JButton btn_Seleccionar;
    private javax.swing.JButton btn_Volver1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_Codigo;
    private javax.swing.JTable tb_Dimension;
    private javax.swing.JTextField txt_Alto;
    private javax.swing.JTextField txt_Ancho;
    private javax.swing.JTextField txt_Busqueda;
    private javax.swing.JTextField txt_Largo;
    private javax.swing.JTextField txt_Peso;
    // End of variables declaration//GEN-END:variables

    private void limpiar() {
        txt_Alto.setText("");
        txt_Ancho.setText("");
        txt_Largo.setText("");
        txt_Peso.setText("");
    }

    private void crear() {
        Dimension dim = new Dimension();
        Validar v = new Validar();

        if (campoVacio()) {
            if (valida()) {
                dim.setAlto(Integer.valueOf(txt_Alto.getText()));
                dim.setAncho(Integer.valueOf(txt_Ancho.getText()));
                dim.setLargo(Integer.valueOf(txt_Largo.getText()));
                dim.setPeso(Integer.valueOf(txt_Peso.getText()));
                
                if (dim.insertarDimension("Dimension_Prod")) {
                    JOptionPane.showMessageDialog(null, "Dimensión creada correctamente","Dimensión creada",JOptionPane.INFORMATION_MESSAGE);

                    lbl_Codigo.setText(String.valueOf((Integer.parseInt(lbl_Codigo.getText() )+ 1)));

                    tablaDimension();
                    //creo = true;
                    limpiar();
                } 
            }
            else
                JOptionPane.showMessageDialog(null, "Algunos valores ingresados no son válidos.","Ingreso inválido",JOptionPane.WARNING_MESSAGE);
        }
        else
            JOptionPane.showMessageDialog(null, "Algunos campos están vacíos.","Ingreso inválido",JOptionPane.WARNING_MESSAGE);
        
    }

    private void tablaDimension() {
        Dimension dim = new Dimension();
        Validar v = new Validar();
        
        modelo = (DefaultTableModel)tb_Dimension.getModel();         
        
        ArrayList <Dimension> cargarDatosPedido = dim.buscarDatosDimension(busqueda, txt_Busqueda.getText(), "Id_Dimension", "Dimension_Prod");
        
        if (cargarDatosPedido == null || cargarDatosPedido.isEmpty()){ 
            for (int i = tb_Dimension.getRowCount() -1; i >= 0; i--)
                modelo.removeRow(i); 
        }
        else{
            DefaultTableCellRenderer Alinear = new DefaultTableCellRenderer();
            Alinear.setHorizontalAlignment(SwingConstants.CENTER);//alinea  en el centro datos de la tabla 
            
            for (int i = tb_Dimension.getRowCount() -1; i >= 0; i--)
                modelo.removeRow(i); 
            
            for (int i = 0; i < 5; i++) 
                tb_Dimension.getColumnModel().getColumn(i).setCellRenderer(Alinear); //llama a centrar los dtos de las columnas de la tabla
            
            //datos que se cargaran en la tabla
            Object[] fila = new Object[modelo.getColumnCount()];   
            
            for (int i = 0; i < cargarDatosPedido.size(); i++) {

                fila[0]=cargarDatosPedido.get(i).getNumero();            
                fila[1]=cargarDatosPedido.get(i).getAlto();
                fila[2]=cargarDatosPedido.get(i).getAncho();
                fila[3]=cargarDatosPedido.get(i).getLargo();
                fila[4]=cargarDatosPedido.get(i).getPeso();
                
                modelo.addRow(fila);
            } 
            
            tb_Dimension.setModel(modelo);
        }
    }

    public int idSeleccionado() {
        return id;
    }

    private void modificar() {
        int filaseleccionada = tb_Dimension.getSelectedRow();
        
        if (filaseleccionada >= 0) {
            if (vacioTabla()) {
                if (validaTabla()) {
                    Dimension dim = new Dimension();

                    dim.setNumero(Integer.valueOf(tb_Dimension.getValueAt(filaseleccionada, 0).toString())) ;
                    dim.setAlto(Double.valueOf(tb_Dimension.getValueAt(filaseleccionada, 1).toString()));
                    dim.setAncho(Double.valueOf(tb_Dimension.getValueAt(filaseleccionada, 2).toString()));
                    dim.setLargo(Double.valueOf(tb_Dimension.getValueAt(filaseleccionada, 3).toString()));
                    dim.setPeso(Double.valueOf(tb_Dimension.getValueAt(filaseleccionada, 4).toString()));

                    if(JOptionPane.showConfirmDialog(null, "Seguro que quieres modificar la dimensión: "+dim.getNumero()+"?", "Editar", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE)==JOptionPane.YES_OPTION){
                        if (dim.modificarDimension("Dimension_Prod"))
                            JOptionPane.showMessageDialog(null, "Datos editados correctamente.","Datos dimensión editados",JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                else
                    JOptionPane.showMessageDialog(null, "Favor ingresa una dimensión válida","Ingreso inválido",JOptionPane.WARNING_MESSAGE);
            } 
            else
                JOptionPane.showMessageDialog(null, "Algunos campos están vacíos","Datos vacíos",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    private boolean campoVacio(){
        Validar v = new Validar();
        return !v.campoVacio(txt_Alto.getText()) && !v.campoVacio(txt_Ancho.getText()) && !v.campoVacio(txt_Largo.getText()) && !v.campoVacio(txt_Peso.getText());
    }
    
    private boolean valida(){
        Validar v = new Validar();
        return v.validaIngresoDim(txt_Alto.getText()) && v.validaIngresoDim(txt_Ancho.getText()) && v.validaIngresoDim(txt_Largo.getText()) && v.validaIngresoDim(txt_Peso.getText());
    }
    
    private boolean validaTabla(){
        int filaseleccionada = tb_Dimension.getSelectedRow();
        return ((double)tb_Dimension.getValueAt(filaseleccionada, 1) > 0) && ((double)tb_Dimension.getValueAt(filaseleccionada, 2) > 0) && ((double)tb_Dimension.getValueAt(filaseleccionada, 3) > 0) && ((double)tb_Dimension.getValueAt(filaseleccionada, 4) > 0);
    }
    
    private boolean vacioTabla(){
        int filaseleccionada = tb_Dimension.getSelectedRow();
        return tb_Dimension.getValueAt(filaseleccionada, 1) != null && tb_Dimension.getValueAt(filaseleccionada, 2) != null && tb_Dimension.getValueAt(filaseleccionada, 3) != null && tb_Dimension.getValueAt(filaseleccionada, 4) != null;
    }
    
    private boolean vacio(){
        Validar v = new Validar();
        Dimension dim = new Dimension();
        return !v.campoVacio(String.valueOf(dim.getAlto())) && !v.campoVacio(String.valueOf(dim.getAncho())) && !v.campoVacio(String.valueOf(dim.getLargo())) && !v.campoVacio(String.valueOf(dim.getPeso()));
    }
}