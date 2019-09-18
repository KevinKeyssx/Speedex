package Interfaz;

import Clases.Cliente;
import Clases.Configurar;
import Clases.DetalleVenta;
import Clases.Empleado;
import Clases.Producto;
import Clases.Proveedor;
import Clases.Validar;
import Clases.Venta;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author keiss
 */
public final class Seleccion extends javax.swing.JFrame implements Runnable{
    static boolean cambio = false;
    static boolean empleado = false;
    static boolean cliente = false;
    static boolean proveedor = false;
    static boolean producto = false;
    static boolean ventas = true;
    //static int id;
    DefaultTableModel modelo0;
    DefaultTableModel modelo;
    DefaultTableModel modelo1;
    DefaultTableModel modelo2;
    DefaultTableModel modelo3;
    
    public Empleado empl;
    static String dia,mes,año;
    boolean busqueda = false;
    
    public void fechaActual(){
        Calendar cal = Calendar.getInstance();
        dia = cal.get(Calendar.DATE) +"";
        mes = (cal.get(Calendar.MONTH) + 1 ) + ""; 
        año = cal.get(Calendar.YEAR) + "";
        lbl_Fecha.setText(dia+"/"+mes+"/"+año);
    }

    private Empleado modificarEmpleado(){
        Empleado emp = new Empleado();
        
        int filaseleccionada = tb_ConsultaEmpleado.getSelectedRow();

        emp.setIdEmpleado(tb_ConsultaEmpleado.getValueAt(filaseleccionada, 0).toString()); //getValueAt ob tiene el valor de la fila
        emp.setNombre(tb_ConsultaEmpleado.getValueAt(filaseleccionada, 1).toString());
        emp.setApellidoP(tb_ConsultaEmpleado.getValueAt(filaseleccionada, 2).toString());
        emp.setApellidoM(tb_ConsultaEmpleado.getValueAt(filaseleccionada, 3).toString());
        emp.setRut(tb_ConsultaEmpleado.getValueAt(filaseleccionada, 4).toString());
        emp.setContraseña(tb_ConsultaEmpleado.getValueAt(filaseleccionada, 5).toString());

        if (cambio){
            if (btn_InhabilitarEmpleado.isVisible())
                emp.setTipo("Inhabilitado");
            else
                emp.setTipo("Empleado");
        }else
            emp.setTipo(tb_ConsultaEmpleado.getValueAt(filaseleccionada, 6).toString());
       
        return emp;  
    }
    
    private void modificarProveedor(){
        Proveedor prov = new Proveedor();
        
        int filaseleccionada = tb_ConsultaProveedor.getSelectedRow();
        
        if (filaseleccionada>=0) {
            //DefaultTableModel modelo = (DefaultTableModel)tb_ConsultaProveedor.getModel();
            prov.setId(Integer.valueOf(tb_ConsultaProveedor.getValueAt(filaseleccionada, 0).toString())); //getValueAt ob tiene el valor de la fila
            prov.setNombre(tb_ConsultaProveedor.getValueAt(filaseleccionada, 1).toString());
            prov.setRut(tb_ConsultaProveedor.getValueAt(filaseleccionada, 2).toString());
            prov.setTelefono(tb_ConsultaProveedor.getValueAt(filaseleccionada, 3).toString());
            prov.setDireccion(tb_ConsultaProveedor.getValueAt(filaseleccionada, 4).toString());
            prov.setActivo(Integer.valueOf(tb_ConsultaProveedor.getValueAt(filaseleccionada, 5).toString()));

            JDialog_Proveedor jdpv = new JDialog_Proveedor(this, true, prov);
            jdpv.setVisible(true);
            
            for (int i = tb_ConsultaProveedor.getRowCount() - 1; i >=0 ; i--)
                modelo1.removeRow(i); // El modelo limpia la tabla

            tablaProveedor();
        }
        else
            JOptionPane.showMessageDialog(null, "No ha seleccionado ningún empleado.","Seleccione empleado",JOptionPane.INFORMATION_MESSAGE);    
    }
    
    private void modificarProducto(){
         Producto prod = new Producto();
        
        int filaseleccionada = tb_ConsultaProducto.getSelectedRow();
        
        if (filaseleccionada >= 0) {
            //DefaultTableModel modelo = (DefaultTableModel)tb_ConsultaProducto.getModel();
            prod.setId(tb_ConsultaProducto.getValueAt(filaseleccionada, 0).toString()); //getValueAt ob tiene el valor de la fila
            prod.setNombre(tb_ConsultaProducto.getValueAt(filaseleccionada, 1).toString());
            prod.setStock(Integer.valueOf(tb_ConsultaProducto.getValueAt(filaseleccionada, 2).toString()) );
            prod.setPrecio(Integer.valueOf( tb_ConsultaProducto.getValueAt(filaseleccionada, 3).toString()));
            prod.setId_categoria(Integer.valueOf(tb_ConsultaProducto.getValueAt(filaseleccionada, 4).toString()));
            prod.setId_proveedor(Integer.valueOf(tb_ConsultaProducto.getValueAt(filaseleccionada, 5).toString()));
            prod.setActivo(Integer.valueOf(tb_ConsultaProducto.getValueAt(filaseleccionada, 6).toString()));
            prod.setId_dimension(Integer.valueOf(tb_ConsultaProducto.getValueAt(filaseleccionada, 7).toString()));
            
            JDialog_Producto jdprod = new JDialog_Producto(this,true, prod);
            jdprod.setVisible(true);
           //Termina la ejecucion de jdprod y actualiza los datos 
            for (int i = tb_ConsultaProducto.getRowCount() - 1; i >=0 ; i--)
                modelo.removeRow(i); // El modelo limpia la tabla

            tablaProducto(); // Volvemos a cargar la tabla
            
            for (int i = tb_ConsultaProveedor.getRowCount() - 1; i >=0 ; i--)
                modelo1.removeRow(i); // El modelo limpia la tabla

            tablaProveedor(); // Volvemos a cargar la tabla
        }
        else
            JOptionPane.showMessageDialog(null, "No ha seleccionado ningún producto.","Seleccione producto",JOptionPane.INFORMATION_MESSAGE);    
    }
   
    private void llamarBusquedaProveedor() {
        busqueda = true;
        tablaProveedor();
    }
    private void llamarBusquedaProducto(){
        busqueda = true;
        tablaProducto();
    }
    
    private void llamarBusquedaEmpleado(){
        busqueda = true;
        tablaEmpleado();
    }
    
    private void llamarBusquedaCiente(){
        busqueda = true;
        tablaCliente();
    }

    private void productoNoRegistrado(){
        if(JOptionPane.showConfirmDialog(null, "Este producto no está registado, ¿Quieres registarlo?", "Producto no registrado", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE)==JOptionPane.YES_OPTION){
            String productos= "";
            if (ventas)
                productos = txtCodigoProducto.getText();
            else if (producto)
                productos = txt_BuscadorProducto.getText();

            JDialog_Producto jdemp = new JDialog_Producto(this, true, productos);
            jdemp.setVisible(true);

            if (ventas) 
                tablaVenta();
            
            if (!txt_BuscadorProducto.getText().equals("") && producto) {
                for (int i = tb_ConsultaProducto.getRowCount() - 1; i >=0 ; i--)
                    modelo.removeRow(i); // El modelo limpia la tabla
            }
            
            tablaProducto(); // Volvemos a cargar la tabla
        }
        else{
            txtCodigoProducto.setText("");
            txt_BuscadorProducto.setText("");
        }
    }
    
    ArrayList <Producto> cargarDatosVenta = new ArrayList();
    
    private void tablaVenta(){
        Producto prod = new Producto();
        Validar v = new Validar();
    
        modelo0 = (DefaultTableModel)tb_Venta.getModel();
        
        cargarDatosVenta = prod.buscarDatosProducto(true, txtCodigoProducto.getText(), "Id_Producto", producto);
        
        if (cargarDatosVenta == null || cargarDatosVenta.isEmpty())
            productoNoRegistrado();
        else{
            DefaultTableCellRenderer Alinear = new DefaultTableCellRenderer();
            Alinear.setHorizontalAlignment(SwingConstants.CENTER);//alinea  en el centro datos de la tabla 
            //llama a centrar los dtos de las columnas de la tabla
            for (int i = 0; i < 5; i++) 
                tb_Venta.getColumnModel().getColumn(i).setCellRenderer(Alinear); 
            
            //datos que se cargaran en la tabla
            Object[] fila = new Object[modelo.getColumnCount()];   

            //boolean existe = codigoExistente();
            
            int cantidad = 1;
            
            if (!txtCantidad.getText().equals(""))
                cantidad = Integer.parseInt(txtCantidad.getText());
            
            if (!codigoExistente()) {
                if (v.activoProducto(txtCodigoProducto.getText())) { //Revisa si el producto esta activo
                    fila[0] = cargarDatosVenta.get(0).getId();    //Código           
                    fila[1] = cargarDatosVenta.get(0).getNombre();//Nombre
                    fila[2] = cantidad;                           //Cantidad
                    fila[3] = cargarDatosVenta.get(0).getPrecio();//Precio
                    fila[4] = cargarDatosVenta.get(0).getPrecio();//Sub Total

                    modelo0.addRow(fila);

                    tb_Venta.setModel(modelo0);
                }
                else
                    JOptionPane.showMessageDialog(null, "El producto está inactivo.","Cuidado!",JOptionPane.WARNING_MESSAGE);     
            }
            
            if (v.activoProducto(txtCodigoProducto.getText()))//Vuelve a revisar para que no muestre el estado del stock
                revisaStock();
            
            calculaTotal();
            calcularCantidad(); 
        }
    }

    private boolean codigoExistente(){
        int cantidad;
        boolean existe = false;
        //valida primero si hay filas
        if (modelo0.getRowCount() >= 0) {
            //Si las hay recorre toda las filas
            for (int i = 0; i < modelo0.getRowCount(); i++) {
                //Busca una coincidencia
                if (cargarDatosVenta.get(0).getId().equals(modelo0.getValueAt(i, 0))) {
                    //Valida si el texto cantidad tiene un valor
                    if (!txtCantidad.getText().equals("")) 
                        cantidad = Integer.valueOf(txtCantidad.getText()); // Si tiene valor se pondra ese valor automatic
                    else                       
                        cantidad = Integer.valueOf(modelo0.getValueAt(i, 2).toString()) + 1 ; // Si no se suma uno

                    existe = true;//Si hay una existencia
                    modelo0.setValueAt(cantidad, i, 2);//Al modelo0 en la column cantidad le cambiamos el valor por la cantidad
                    modelo0.setValueAt((cantidad * cargarDatosVenta.get(0).getPrecio()), i, 4);//Lo mismo pero ahora el precio se multiplica
                    break;//Salimos
                }
                else
                    existe = false;//No hay coinsidencias 
            }
        }
        return existe;
    }
    
    static float total1 = 0;
    
    private void calcularCantidad(){
        txtCodigoProducto.setText("");    
        int cantidad = 0 ;

        for (int i = 0; i < modelo0.getRowCount(); i++) 
            cantidad = (cantidad + Integer.valueOf(modelo0.getValueAt(i, 2).toString()));

        lbl_Articulos.setText(String.valueOf(cantidad));
    }
    
    private void calculaTotal(){
        Validar v = new Validar();    
        float total = 0 ;

        for (int i = 0; i < modelo0.getRowCount(); i++) 
            total = (total + Float.valueOf(modelo0.getValueAt(i, 4).toString()));

        txtTotalaPagar.setText(String.valueOf(total));
        total1 = Float.valueOf(txtTotalaPagar.getText()) ;
        
        if (rb_Tarjeta.isSelected()) 
            txtRecibo.setText(txtTotalaPagar.getText());
        
    }
    
    private void tablaProducto(){
        Producto prod = new Producto();
        Validar v = new Validar();

        modelo = (DefaultTableModel)tb_ConsultaProducto.getModel();

        String comboProducto = v.cargarCMBProducto(cmb_BusquedaProducto.getSelectedItem().toString());         
        
        ArrayList <Producto> cargarDatosProducto = prod.buscarDatosProducto(busqueda, txt_BuscadorProducto.getText(), comboProducto, producto);
        
        if (cargarDatosProducto == null || cargarDatosProducto.isEmpty()){ 
            if (producto) {
                for (int i = tb_ConsultaProducto.getRowCount() -1; i >= 0; i--)
                    modelo.removeRow(i); 
            } 
            if (agrega) 
                productoNoRegistrado();
            
        }
        else{
            DefaultTableCellRenderer Alinear = new DefaultTableCellRenderer();
            Alinear.setHorizontalAlignment(SwingConstants.CENTER);//alinea  en el centro datos de la tabla 
            
            for (int i = tb_ConsultaProducto.getRowCount() -1; i >= 0; i--)
                modelo.removeRow(i); 
            
            for (int i = 0; i < tb_ConsultaProducto.getColumnCount(); i++) 
                tb_ConsultaProducto.getColumnModel().getColumn(i).setCellRenderer(Alinear); //llama a centrar los dtos de las columnas de la tabla
            
            //datos que se cargaran en la tabla
            Object[] fila = new Object[modelo.getColumnCount()];   
            
            for (int i = 0; i < cargarDatosProducto.size(); i++) {

                fila[0]=cargarDatosProducto.get(i).getId();            
                fila[1]=cargarDatosProducto.get(i).getNombre();
                fila[2]=cargarDatosProducto.get(i).getStock();
                fila[3]=cargarDatosProducto.get(i).getPrecio();
                fila[4]=cargarDatosProducto.get(i).getId_categoria();
                fila[5]=cargarDatosProducto.get(i).getId_proveedor();
                fila[6]=cargarDatosProducto.get(i).getActivo();
                fila[7]=cargarDatosProducto.get(i).getId_dimension();

                modelo.addRow(fila);
            } 
            
            tb_ConsultaProducto.setModel(modelo);
        }
    }
    
    private void tablaProveedor(){
        Proveedor prov = new Proveedor();
        ArrayList <Proveedor> cargarDatosProveedor;
        Validar v = new Validar();
        
        String tabla = v.cargarCMBProveedor(cmb_BusquedaProveedor.getSelectedItem().toString());
        
        modelo1 = (DefaultTableModel)tb_ConsultaProveedor.getModel();
        cargarDatosProveedor = prov.buscarDatosProveedor(busqueda, tabla, txt_BuscadorProveedor.getText());
        
        if (cargarDatosProveedor == null || cargarDatosProveedor.isEmpty()) {
            //JOptionPane.showMessageDialog(null, "No se encontro ningún dato o aún no tiene ningún proveedor.","Información!",JOptionPane.INFORMATION_MESSAGE);
            for (int i = tb_ConsultaProveedor.getRowCount() -1; i >= 0; i--)
                    modelo1.removeRow(i); 
        } else{
            DefaultTableCellRenderer Alinear = new DefaultTableCellRenderer();
            Alinear.setHorizontalAlignment(SwingConstants.CENTER);//alinea  en el centro datos de la tabla 
            
            for (int i = tb_ConsultaProveedor.getRowCount() -1; i >= 0; i--)
                    modelo1.removeRow(i); 
            
            for (int i = 0; i < 6; i++) 
                tb_ConsultaProveedor.getColumnModel().getColumn(i).setCellRenderer(Alinear); //llama a centrar los dtos de las columnas de la tabla
            
            //datos que se cargaran en la tabla
            Object[] fila = new Object[modelo1.getColumnCount()];           
            
            for (int i = 0; i <cargarDatosProveedor.size(); i++) {

                fila[0]=cargarDatosProveedor.get(i).getId();            
                fila[1]=cargarDatosProveedor.get(i).getNombre();
                fila[2]=cargarDatosProveedor.get(i).getRut();
                fila[3]=cargarDatosProveedor.get(i).getTelefono();
                fila[4]=cargarDatosProveedor.get(i).getDireccion();
                fila[5]=cargarDatosProveedor.get(i).getActivo();

                modelo1.addRow(fila);
            }  
        
            tb_ConsultaProveedor.setModel(modelo1);
        }
    }
    
    private void tablaEmpleado(){
        Empleado emp = new Empleado();
        Validar v = new Validar();
        
        ArrayList <Empleado> cargarDatosEmpleado;
        modelo2 = (DefaultTableModel)tb_ConsultaEmpleado.getModel();
        
        String tabla = v.cargarCMBEmpleado(cmb_BusquedaEmpleado.getSelectedItem().toString());
        
        cargarDatosEmpleado = emp.buscarDatosEmpleado(busqueda, tabla, txt_BuscadorEmpleado.getText());
        
        if (cargarDatosEmpleado == null || cargarDatosEmpleado.isEmpty() && busqueda) {
            //JOptionPane.showMessageDialog(null, "No se encontro ningún dato.","Información!",JOptionPane.INFORMATION_MESSAGE); 
            for (int i = tb_ConsultaEmpleado.getRowCount() -1; i >= 0; i--)
                    modelo2.removeRow(i); 
        }
        else{
            DefaultTableCellRenderer Alinear = new DefaultTableCellRenderer();
            Alinear.setHorizontalAlignment(SwingConstants.CENTER);//alinea  en el centro datos de la tabla             
            //Borra todos los datos de la tabla
            for (int i = tb_ConsultaEmpleado.getRowCount() -1; i >= 0; i--)
                    modelo2.removeRow(i); 
            
            for (int i = 0; i < 7; i++) 
                tb_ConsultaEmpleado.getColumnModel().getColumn(i).setCellRenderer(Alinear); //llama a centrar los dtos de las columnas de la tabla
            
            //datos que se cargaran en la tabla
            Object[] fila = new Object[modelo2.getColumnCount()];
            
            for (int i = 0; i <cargarDatosEmpleado.size(); i++) {

                fila[0]=cargarDatosEmpleado.get(i).getIdEmpleado();            
                fila[1]=cargarDatosEmpleado.get(i).getNombre();
                fila[2]=cargarDatosEmpleado.get(i).getApellidoP();
                fila[3]=cargarDatosEmpleado.get(i).getApellidoM();
                fila[4]=cargarDatosEmpleado.get(i).getRut();
                fila[5]=cargarDatosEmpleado.get(i).getContraseña();
                fila[6]=cargarDatosEmpleado.get(i).getTipo();

                modelo2.addRow(fila);
            }  
                
            tb_ConsultaEmpleado.setModel(modelo2);
        }
    }
    
    private void tablaCliente(){
        Cliente clien = new Cliente();
        Validar v = new Validar();
        
        ArrayList <Cliente> cargarDatosCliente;
        modelo3 = (DefaultTableModel)tb_ConsultaCliente.getModel();
        
        String tabla = v.cargarCMBCliente(cmb_BusquedaCliente.getSelectedItem().toString());
        String seleccion = "=";
        
        if (ckb_Cliente.isSelected()) 
            seleccion = "like";
        
        cargarDatosCliente = clien.buscarDatosCliente(busqueda, tabla, txt_BuscadorCliente.getText(), seleccion);
        
        if (cargarDatosCliente == null || cargarDatosCliente.isEmpty() && busqueda) 
            JOptionPane.showMessageDialog(null, "No se encontro ningún dato.","Información!",JOptionPane.INFORMATION_MESSAGE);
        else{
            DefaultTableCellRenderer Alinear = new DefaultTableCellRenderer();
            Alinear.setHorizontalAlignment(SwingConstants.CENTER);//alinea  en el centro datos de la tabla             
            //Borra todos los datos de la tabla
            for (int i = tb_ConsultaCliente.getRowCount() -1; i >= 0; i--)
                    modelo3.removeRow(i); 
            
            for (int i = 0; i < 6; i++) 
                tb_ConsultaCliente.getColumnModel().getColumn(i).setCellRenderer(Alinear); //llama a centrar los dtos de las columnas de la tabla
            
            //datos que se cargaran en la tabla
            Object[] fila = new Object[modelo3.getColumnCount()];
            
            for (int i = 0; i <cargarDatosCliente.size(); i++) {

                fila[0]=cargarDatosCliente.get(i).getRut();            
                fila[1]=cargarDatosCliente.get(i).getNombre();
                fila[2]=cargarDatosCliente.get(i).getApellidoP();
                fila[3]=cargarDatosCliente.get(i).getApellidoM();
                fila[4]=cargarDatosCliente.get(i).getDireccion();
                fila[5]=cargarDatosCliente.get(i).getCorreo();
                fila[6]=cargarDatosCliente.get(i).getFono();

                modelo3.addRow(fila);
            }  
                
            tb_ConsultaCliente.setModel(modelo3);
        }
    }

    public Seleccion(Empleado emp){
        initComponents();   
        //Verifica el tipo de empleado 
        if (emp.getTipo().equals("Administrador")){
            btn_InsertarEmpleado.setEnabled(true);
            tablaEmpleado();
            menu_Empleado.setEnabled(true);
        }
        empl = emp;
        Venta venta = new Venta();
        //menu_Empleado.setEnabled(false);
        //Inicializa los componentes para el jframe
        setTitle("Datos - SpeedeX");
        this.setLocationRelativeTo(null); //Centrar el JFrame al centro de la pantalla
        this.setResizable(false); //No permite modificar el tamaño
        setSize(970, 617); //Tamaño por defecto
        setIconImage(new ImageIcon(getClass().getResource("/Complementos/Logo Speedex2.png")).getImage()); //Icono de la app
        //Ocultando los paneles
        pnl_Ventas.setVisible(true);
        pnl_PanelMenu.setVisible(false);
        pnl_IngresoCliente.setVisible(false);
        pnl_IngresoEmpleado.setVisible(false);
        pnl_Proveedor.setVisible(false);
        pnl_Producto.setVisible(false);
        pnl_Despachos.setVisible(false);
        
        txtCodigoProducto.requestFocus();
        //Campos importantes no editables
        txtVendedor.setText(emp.getNombre()+" "+emp.getApellidoP());
        //txtVendedor.setHorizontalAlignment(4);
        txtCodigoVenta.setEditable(false);
        txtVendedor.setEditable(false);
        txtVuelto.setEditable(false);
        txtTotalaPagar.setEditable(false);
        txtTotalaPagar.setText("0");
        txtVuelto.setText("0");
        txtTotalaPagar.setHorizontalAlignment(4);
        txtVuelto.setHorizontalAlignment(4);
        txtRecibo.setText("0");
        txtRecibo.setHorizontalAlignment(4);
        rb_Efectivo.setSelected(true);
        txtCodigoVenta.setText(String.valueOf("000"+(venta.buscarID().getId() + 1)));
        txtCodigoVenta.setHorizontalAlignment(4);
        lbl_Articulos.setText("0");
        txtDescuento.setHorizontalAlignment(4);
        lbl_StockNormal.setVisible(false);
        lbl_StockMalo.setVisible(false);
        //Cargando las tablas
        tablaProveedor();
        tablaProducto();
        tablaCliente();
        fechaActual();
        //Ocultando los lbl's
        lbl_Ventas.setVisible(true);
        lbl_Empleado.setVisible(false);
        lbl_Cliente.setVisible(false);
        lbl_Productos.setVisible(false);
        lbl_Proveedor.setVisible(false);
        //Cangando el combobox de Productos
        cmb_BusquedaProducto.removeAllItems();
        cmb_BusquedaProducto.addItem("Código");
        cmb_BusquedaProducto.addItem("Nombre");
        cmb_BusquedaProducto.addItem("Stock");
        cmb_BusquedaProducto.addItem("Precio");
        cmb_BusquedaProducto.addItem("Categoría");
        cmb_BusquedaProducto.addItem("Proveedor");
        cmb_BusquedaProducto.addItem("Activo");
        //Cargando combobox de Empleado
        cmb_BusquedaEmpleado.removeAllItems();
        cmb_BusquedaEmpleado.addItem("Id");
        cmb_BusquedaEmpleado.addItem("Nombre");
        cmb_BusquedaEmpleado.addItem("Apellido Paterno");
        cmb_BusquedaEmpleado.addItem("Apellido Materno");
        cmb_BusquedaEmpleado.addItem("Rut");
        cmb_BusquedaEmpleado.addItem("Tipo");
        //Caragar comboboc Proveedor
        cmb_BusquedaProveedor.removeAllItems();
        cmb_BusquedaProveedor.addItem("Id");
        cmb_BusquedaProveedor.addItem("Nombre");
        cmb_BusquedaProveedor.addItem("Rut");
        cmb_BusquedaProveedor.addItem("Teléfono");
        cmb_BusquedaProveedor.addItem("Dirección");
        cmb_BusquedaProveedor.addItem("Activo");
        
        cmb_BusquedaCliente.removeAllItems();
        cmb_BusquedaCliente.addItem("Rut");
        cmb_BusquedaCliente.addItem("Nombre");
        cmb_BusquedaCliente.addItem("Apellido Paterno");
        cmb_BusquedaCliente.addItem("Apellido Materno");
        cmb_BusquedaCliente.addItem("Dirección");
        cmb_BusquedaCliente.addItem("Correo");
        cmb_BusquedaCliente.addItem("Teléfono");
        
        btn_HabilitarEmpleado.setVisible(false);
        
        h1 = new Thread(this);
        h1.start();
        //setLocationRelativeTo(null);//para centrar la ventana
        //setVisible(true);
        
        calculaPedido(false);
        
    }
    //Constructor vacio
    public Seleccion() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TipoPago = new javax.swing.ButtonGroup();
        btn_Aceptar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btn_PanelMenu = new javax.swing.JButton();
        pnl_PanelMenu = new javax.swing.JDesktopPane();
        btn_CerrarSesion = new javax.swing.JButton();
        btn_Producto = new javax.swing.JButton();
        btn_Proveedor = new javax.swing.JButton();
        lbl_Linea = new javax.swing.JLabel();
        btn_Venta = new javax.swing.JButton();
        btn_InsertarEmpleado = new javax.swing.JButton();
        btn_HistorialVentas = new javax.swing.JButton();
        btn_Menu = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pnl_Despachos = new javax.swing.JPanel();
        lbl_NumeroNot = new javax.swing.JLabel();
        lbl_CirculoNot = new javax.swing.JLabel();
        btn_Despacho = new javax.swing.JButton();
        btn_Comprar = new javax.swing.JButton();
        btn_Cliente = new javax.swing.JButton();
        btn_Conductor = new javax.swing.JButton();
        btn_Movil = new javax.swing.JButton();
        pnl_IngresoEmpleado = new javax.swing.JLayeredPane();
        btn_ModificarEmpleado = new javax.swing.JButton();
        btn_InhabilitarEmpleado = new javax.swing.JButton();
        btn_Agregar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_ConsultaEmpleado = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        txt_BuscadorEmpleado = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cmb_BusquedaEmpleado = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        btn_HabilitarEmpleado = new javax.swing.JButton();
        pnl_IngresoCliente = new javax.swing.JLayeredPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        tb_ConsultaCliente = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        cmb_BusquedaCliente = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        txt_BuscadorCliente = new javax.swing.JTextField();
        ckb_Cliente = new javax.swing.JCheckBox();
        pnl_Proveedor = new javax.swing.JLayeredPane();
        btn_AñadirProv = new javax.swing.JButton();
        btn_ModificarProv = new javax.swing.JButton();
        btn_EliminarProv = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb_ConsultaProveedor = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        cmb_BusquedaProveedor = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        txt_BuscadorProveedor = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        lbl_Productos = new javax.swing.JLabel();
        lbl_Proveedor = new javax.swing.JLabel();
        lbl_Empleado = new javax.swing.JLabel();
        pnl_Producto = new javax.swing.JLayeredPane();
        btn_AgregarProducto = new javax.swing.JButton();
        btn_ModificarProd = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tb_ConsultaProducto = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        cmb_BusquedaProducto = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        txt_BuscadorProducto = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        lbl_Ventas = new javax.swing.JLabel();
        pnl_Ventas = new javax.swing.JLayeredPane();
        jLabel7 = new javax.swing.JLabel();
        txtCodigoVenta = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtVendedor = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtCodigoProducto = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtDescuento = new javax.swing.JTextField();
        txtCancelarVenta = new javax.swing.JButton();
        btnQuitarProducto = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tb_Venta = new javax.swing.JTable();
        txtRecibo = new javax.swing.JTextField();
        txtVuelto = new javax.swing.JTextField();
        txtTotalaPagar = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        lbl_Fecha = new javax.swing.JLabel();
        lbl_Hora = new javax.swing.JLabel();
        pnl_Stock = new javax.swing.JLayeredPane();
        lbl_StockMalo = new javax.swing.JLabel();
        lbl_StockNormal = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        lbl_Articulos = new javax.swing.JLabel();
        pnl_TipoPago = new javax.swing.JPanel();
        rb_Efectivo = new javax.swing.JRadioButton();
        rb_Tarjeta = new javax.swing.JRadioButton();
        jLabel24 = new javax.swing.JLabel();
        lbl_Cliente = new javax.swing.JLabel();
        btn_Conductor1 = new javax.swing.JButton();
        lbl_NuevoPedido = new javax.swing.JLabel();
        lbl_NumeroCantidad = new javax.swing.JLabel();
        lbl_Nuevo = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbl_Fecha1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menu_CambiarContraseña = new javax.swing.JMenu();
        menu_Configuracion = new javax.swing.JMenuItem();
        menu_CambiarContra = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menu_CerrarSesion = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menu_Ventas = new javax.swing.JMenuItem();
        menu_Producto = new javax.swing.JMenuItem();
        menu_Proveedor = new javax.swing.JMenuItem();
        menu_Empleado = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        menu_HistorialVenta = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        menu_Movil = new javax.swing.JMenuItem();
        menu_Cliente = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        getContentPane().add(btn_Aceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 510, 170, 40));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 510, -1, -1));

        btn_PanelMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Boton Menú1.png"))); // NOI18N
        btn_PanelMenu.setBorder(null);
        btn_PanelMenu.setBorderPainted(false);
        btn_PanelMenu.setContentAreaFilled(false);
        btn_PanelMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_PanelMenu.setFocusPainted(false);
        btn_PanelMenu.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Boton Menú1 Press.png"))); // NOI18N
        btn_PanelMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_PanelMenuActionPerformed(evt);
            }
        });
        getContentPane().add(btn_PanelMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 30, 30));

        pnl_PanelMenu.setBackground(java.awt.SystemColor.control);
        pnl_PanelMenu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnl_PanelMenu.setForeground(new java.awt.Color(0, 204, 204));
        pnl_PanelMenu.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pnl_PanelMenuFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                pnl_PanelMenuFocusLost(evt);
            }
        });

        btn_CerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Boton Apagar1.png"))); // NOI18N
        btn_CerrarSesion.setBorder(null);
        btn_CerrarSesion.setBorderPainted(false);
        btn_CerrarSesion.setContentAreaFilled(false);
        btn_CerrarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_CerrarSesion.setFocusPainted(false);
        btn_CerrarSesion.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Boton Apagar Press.png"))); // NOI18N
        btn_CerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CerrarSesionActionPerformed(evt);
            }
        });
        pnl_PanelMenu.add(btn_CerrarSesion);
        btn_CerrarSesion.setBounds(10, 380, 40, 31);
        btn_CerrarSesion.getAccessibleContext().setAccessibleParent(pnl_PanelMenu);

        btn_Producto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Boton Producto.png"))); // NOI18N
        btn_Producto.setBorder(null);
        btn_Producto.setBorderPainted(false);
        btn_Producto.setContentAreaFilled(false);
        btn_Producto.setFocusPainted(false);
        btn_Producto.setPreferredSize(new java.awt.Dimension(39, 39));
        btn_Producto.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Boton Producto Press.png"))); // NOI18N
        btn_Producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ProductoActionPerformed(evt);
            }
        });
        pnl_PanelMenu.add(btn_Producto);
        btn_Producto.setBounds(10, 90, 40, 40);

        btn_Proveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Boton Proveedor.png"))); // NOI18N
        btn_Proveedor.setBorder(null);
        btn_Proveedor.setBorderPainted(false);
        btn_Proveedor.setContentAreaFilled(false);
        btn_Proveedor.setFocusPainted(false);
        btn_Proveedor.setPreferredSize(new java.awt.Dimension(39, 39));
        btn_Proveedor.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Boton Proveedor Press.png"))); // NOI18N
        btn_Proveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ProveedorActionPerformed(evt);
            }
        });
        pnl_PanelMenu.add(btn_Proveedor);
        btn_Proveedor.setBounds(10, 160, 40, 40);

        lbl_Linea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Divider.png"))); // NOI18N
        lbl_Linea.setText("jLabel5");
        pnl_PanelMenu.add(lbl_Linea);
        lbl_Linea.setBounds(0, 350, 60, 20);

        btn_Venta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Boton Ventas.png"))); // NOI18N
        btn_Venta.setBorder(null);
        btn_Venta.setBorderPainted(false);
        btn_Venta.setContentAreaFilled(false);
        btn_Venta.setFocusPainted(false);
        btn_Venta.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Boton Ventas Press.png"))); // NOI18N
        btn_Venta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_VentaActionPerformed(evt);
            }
        });
        pnl_PanelMenu.add(btn_Venta);
        btn_Venta.setBounds(10, 20, 40, 40);

        btn_InsertarEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Boton Empleado1.png"))); // NOI18N
        btn_InsertarEmpleado.setBorder(null);
        btn_InsertarEmpleado.setBorderPainted(false);
        btn_InsertarEmpleado.setContentAreaFilled(false);
        btn_InsertarEmpleado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_InsertarEmpleado.setEnabled(false);
        btn_InsertarEmpleado.setFocusPainted(false);
        btn_InsertarEmpleado.setMaximumSize(new java.awt.Dimension(73, 73));
        btn_InsertarEmpleado.setMinimumSize(new java.awt.Dimension(73, 73));
        btn_InsertarEmpleado.setPreferredSize(new java.awt.Dimension(122, 54));
        btn_InsertarEmpleado.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Boton Empleado1 Press.png"))); // NOI18N
        btn_InsertarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_InsertarEmpleadoActionPerformed(evt);
            }
        });
        pnl_PanelMenu.add(btn_InsertarEmpleado);
        btn_InsertarEmpleado.setBounds(10, 230, 40, 40);

        btn_HistorialVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Boton Historial Ventas.png"))); // NOI18N
        btn_HistorialVentas.setBorder(null);
        btn_HistorialVentas.setBorderPainted(false);
        btn_HistorialVentas.setContentAreaFilled(false);
        btn_HistorialVentas.setFocusPainted(false);
        btn_HistorialVentas.setPreferredSize(new java.awt.Dimension(39, 39));
        btn_HistorialVentas.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Boton Historial Ventas Press.png"))); // NOI18N
        btn_HistorialVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_HistorialVentasActionPerformed(evt);
            }
        });
        pnl_PanelMenu.add(btn_HistorialVentas);
        btn_HistorialVentas.setBounds(10, 290, 39, 39);

        getContentPane().add(pnl_PanelMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 60, 430));
        getContentPane().add(btn_Menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Logo Speedex Mini4.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, -1, -1));

        pnl_Despachos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnl_Despachos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_NumeroNot.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbl_NumeroNot.setForeground(new java.awt.Color(255, 255, 255));
        lbl_NumeroNot.setText("1");
        pnl_Despachos.add(lbl_NumeroNot, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 10, 30));

        lbl_CirculoNot.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Notificacion.png"))); // NOI18N
        lbl_CirculoNot.setText("jLabel28");
        pnl_Despachos.add(lbl_CirculoNot, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 30, 30));

        btn_Despacho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Boton Despacho.png"))); // NOI18N
        btn_Despacho.setBorder(null);
        btn_Despacho.setBorderPainted(false);
        btn_Despacho.setContentAreaFilled(false);
        btn_Despacho.setFocusPainted(false);
        btn_Despacho.setPreferredSize(new java.awt.Dimension(39, 39));
        btn_Despacho.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Boton Despacho Press.png"))); // NOI18N
        btn_Despacho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DespachoActionPerformed(evt);
            }
        });
        pnl_Despachos.add(btn_Despacho, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 40, 40));

        btn_Comprar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Comprar.png"))); // NOI18N
        btn_Comprar.setBorder(null);
        btn_Comprar.setBorderPainted(false);
        btn_Comprar.setContentAreaFilled(false);
        btn_Comprar.setFocusPainted(false);
        btn_Comprar.setPreferredSize(new java.awt.Dimension(39, 39));
        btn_Comprar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Comprar Press.png"))); // NOI18N
        btn_Comprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ComprarActionPerformed(evt);
            }
        });
        pnl_Despachos.add(btn_Comprar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 40, 40));

        btn_Cliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/cliente2.png"))); // NOI18N
        btn_Cliente.setBorder(null);
        btn_Cliente.setBorderPainted(false);
        btn_Cliente.setContentAreaFilled(false);
        btn_Cliente.setFocusPainted(false);
        btn_Cliente.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Cliente Press.png"))); // NOI18N
        btn_Cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ClienteActionPerformed(evt);
            }
        });
        pnl_Despachos.add(btn_Cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 40, 40));

        btn_Conductor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Boton Conductor.png"))); // NOI18N
        btn_Conductor.setBorder(null);
        btn_Conductor.setBorderPainted(false);
        btn_Conductor.setContentAreaFilled(false);
        btn_Conductor.setFocusPainted(false);
        btn_Conductor.setPreferredSize(new java.awt.Dimension(39, 39));
        btn_Conductor.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Boton Conductor Press.png"))); // NOI18N
        btn_Conductor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ConductorActionPerformed(evt);
            }
        });
        pnl_Despachos.add(btn_Conductor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, -1, -1));

        btn_Movil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Boton Movil.png"))); // NOI18N
        btn_Movil.setBorder(null);
        btn_Movil.setBorderPainted(false);
        btn_Movil.setContentAreaFilled(false);
        btn_Movil.setFocusPainted(false);
        btn_Movil.setPreferredSize(new java.awt.Dimension(39, 39));
        btn_Movil.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Boton Movil Press.png"))); // NOI18N
        btn_Movil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_MovilActionPerformed(evt);
            }
        });
        pnl_Despachos.add(btn_Movil, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        getContentPane().add(pnl_Despachos, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 60, 60, 360));

        pnl_IngresoEmpleado.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btn_ModificarEmpleado.setForeground(new java.awt.Color(0, 204, 204));
        btn_ModificarEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Editar.png"))); // NOI18N
        btn_ModificarEmpleado.setText("Modificar");
        btn_ModificarEmpleado.setFocusPainted(false);
        btn_ModificarEmpleado.setFocusable(false);
        btn_ModificarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ModificarEmpleadoActionPerformed(evt);
            }
        });
        pnl_IngresoEmpleado.add(btn_ModificarEmpleado);
        btn_ModificarEmpleado.setBounds(370, 340, 120, 40);

        btn_InhabilitarEmpleado.setForeground(new java.awt.Color(255, 102, 102));
        btn_InhabilitarEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Inhabilitar.png"))); // NOI18N
        btn_InhabilitarEmpleado.setText("Inhabilitar");
        btn_InhabilitarEmpleado.setFocusPainted(false);
        btn_InhabilitarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_InhabilitarEmpleadoActionPerformed(evt);
            }
        });
        pnl_IngresoEmpleado.add(btn_InhabilitarEmpleado);
        btn_InhabilitarEmpleado.setBounds(560, 340, 130, 40);

        btn_Agregar.setForeground(new java.awt.Color(0, 204, 204));
        btn_Agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Agregar.png"))); // NOI18N
        btn_Agregar.setText("Agregar");
        btn_Agregar.setFocusPainted(false);
        btn_Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AgregarActionPerformed(evt);
            }
        });
        pnl_IngresoEmpleado.add(btn_Agregar);
        btn_Agregar.setBounds(180, 340, 120, 40);

        tb_ConsultaEmpleado.setBackground(new java.awt.Color(204, 204, 255));
        tb_ConsultaEmpleado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tb_ConsultaEmpleado.setForeground(new java.awt.Color(0, 153, 153));
        tb_ConsultaEmpleado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Apellido P", "Apellido M", "Rut", "Contraseña", "Tipo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_ConsultaEmpleado.setGridColor(new java.awt.Color(0, 51, 51));
        tb_ConsultaEmpleado.setSelectionBackground(new java.awt.Color(0, 102, 153));
        tb_ConsultaEmpleado.setSelectionForeground(new java.awt.Color(204, 255, 255));
        tb_ConsultaEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_ConsultaEmpleadoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tb_ConsultaEmpleado);

        pnl_IngresoEmpleado.add(jScrollPane2);
        jScrollPane2.setBounds(60, 100, 730, 210);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Lupa.png"))); // NOI18N
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setFocusPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        pnl_IngresoEmpleado.add(jButton2);
        jButton2.setBounds(660, 40, 40, 30);

        txt_BuscadorEmpleado.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_BuscadorEmpleado.setForeground(new java.awt.Color(0, 153, 153));
        txt_BuscadorEmpleado.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_BuscadorEmpleado.setSelectionColor(new java.awt.Color(255, 153, 51));
        txt_BuscadorEmpleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_BuscadorEmpleadoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_BuscadorEmpleadoKeyReleased(evt);
            }
        });
        pnl_IngresoEmpleado.add(txt_BuscadorEmpleado);
        txt_BuscadorEmpleado.setBounds(380, 40, 320, 30);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 204));
        jLabel1.setText("Buscar:");
        pnl_IngresoEmpleado.add(jLabel1);
        jLabel1.setBounds(150, 40, 70, 30);

        cmb_BusquedaEmpleado.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cmb_BusquedaEmpleado.setForeground(new java.awt.Color(0, 204, 204));
        cmb_BusquedaEmpleado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        pnl_IngresoEmpleado.add(cmb_BusquedaEmpleado);
        cmb_BusquedaEmpleado.setBounds(210, 40, 120, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 204, 204));
        jLabel5.setText("=");
        pnl_IngresoEmpleado.add(jLabel5);
        jLabel5.setBounds(350, 40, 40, 30);

        btn_HabilitarEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Habilitar.png"))); // NOI18N
        btn_HabilitarEmpleado.setText("Habilitar");
        btn_HabilitarEmpleado.setFocusPainted(false);
        btn_HabilitarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_HabilitarEmpleadoActionPerformed(evt);
            }
        });
        pnl_IngresoEmpleado.add(btn_HabilitarEmpleado);
        btn_HabilitarEmpleado.setBounds(560, 340, 130, 40);

        getContentPane().add(pnl_IngresoEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 840, 410));

        pnl_IngresoCliente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tb_ConsultaCliente.setBackground(new java.awt.Color(204, 204, 255));
        tb_ConsultaCliente.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tb_ConsultaCliente.setForeground(new java.awt.Color(0, 153, 153));
        tb_ConsultaCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Rut", "Nombre", "Apellido Paterno", "Apellido Materno", "Dirección", "Correo", "Teléfono"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_ConsultaCliente.setGridColor(new java.awt.Color(0, 51, 51));
        tb_ConsultaCliente.setSelectionBackground(new java.awt.Color(0, 102, 153));
        tb_ConsultaCliente.setSelectionForeground(new java.awt.Color(204, 255, 255));
        jScrollPane5.setViewportView(tb_ConsultaCliente);

        pnl_IngresoCliente.add(jScrollPane5);
        jScrollPane5.setBounds(60, 100, 730, 210);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 204, 204));
        jLabel4.setText("Buscar:");
        pnl_IngresoCliente.add(jLabel4);
        jLabel4.setBounds(80, 40, 70, 30);

        cmb_BusquedaCliente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cmb_BusquedaCliente.setForeground(new java.awt.Color(0, 204, 204));
        cmb_BusquedaCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        pnl_IngresoCliente.add(cmb_BusquedaCliente);
        cmb_BusquedaCliente.setBounds(140, 40, 120, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 204, 204));
        jLabel6.setText("=");
        pnl_IngresoCliente.add(jLabel6);
        jLabel6.setBounds(280, 40, 40, 30);

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Lupa.png"))); // NOI18N
        jButton8.setBorderPainted(false);
        jButton8.setContentAreaFilled(false);
        jButton8.setFocusPainted(false);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        pnl_IngresoCliente.add(jButton8);
        jButton8.setBounds(590, 40, 40, 30);

        txt_BuscadorCliente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_BuscadorCliente.setForeground(new java.awt.Color(0, 153, 153));
        txt_BuscadorCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_BuscadorCliente.setSelectionColor(new java.awt.Color(255, 153, 51));
        txt_BuscadorCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_BuscadorClienteKeyPressed(evt);
            }
        });
        pnl_IngresoCliente.add(txt_BuscadorCliente);
        txt_BuscadorCliente.setBounds(310, 40, 320, 30);

        ckb_Cliente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ckb_Cliente.setForeground(new java.awt.Color(0, 204, 204));
        ckb_Cliente.setText("Búsqueda ámplia");
        ckb_Cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckb_ClienteActionPerformed(evt);
            }
        });
        pnl_IngresoCliente.add(ckb_Cliente);
        ckb_Cliente.setBounds(660, 40, 150, 30);

        getContentPane().add(pnl_IngresoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 850, 410));

        pnl_Proveedor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btn_AñadirProv.setForeground(new java.awt.Color(0, 204, 204));
        btn_AñadirProv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Agregar.png"))); // NOI18N
        btn_AñadirProv.setText("Agregar");
        btn_AñadirProv.setFocusPainted(false);
        btn_AñadirProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AñadirProvActionPerformed(evt);
            }
        });
        pnl_Proveedor.add(btn_AñadirProv);
        btn_AñadirProv.setBounds(180, 340, 120, 40);

        btn_ModificarProv.setForeground(new java.awt.Color(0, 204, 204));
        btn_ModificarProv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Editar.png"))); // NOI18N
        btn_ModificarProv.setText("Modificar");
        btn_ModificarProv.setFocusPainted(false);
        btn_ModificarProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ModificarProvActionPerformed(evt);
            }
        });
        pnl_Proveedor.add(btn_ModificarProv);
        btn_ModificarProv.setBounds(370, 340, 120, 40);

        btn_EliminarProv.setForeground(new java.awt.Color(255, 102, 102));
        btn_EliminarProv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Inhabilitar.png"))); // NOI18N
        btn_EliminarProv.setText("Eliminar");
        btn_EliminarProv.setFocusPainted(false);
        btn_EliminarProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EliminarProvActionPerformed(evt);
            }
        });
        pnl_Proveedor.add(btn_EliminarProv);
        btn_EliminarProv.setBounds(560, 340, 130, 40);

        tb_ConsultaProveedor.setBackground(new java.awt.Color(204, 204, 255));
        tb_ConsultaProveedor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tb_ConsultaProveedor.setForeground(new java.awt.Color(0, 153, 153));
        tb_ConsultaProveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Rut", "Teléfono", "Dirección", "Activo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_ConsultaProveedor.setGridColor(new java.awt.Color(0, 51, 51));
        tb_ConsultaProveedor.setSelectionBackground(new java.awt.Color(0, 102, 153));
        tb_ConsultaProveedor.setSelectionForeground(new java.awt.Color(204, 255, 255));
        tb_ConsultaProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_ConsultaProveedorMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tb_ConsultaProveedor);

        pnl_Proveedor.add(jScrollPane3);
        jScrollPane3.setBounds(60, 100, 730, 210);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 204, 204));
        jLabel15.setText("Buscar:");
        pnl_Proveedor.add(jLabel15);
        jLabel15.setBounds(150, 40, 70, 30);

        cmb_BusquedaProveedor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cmb_BusquedaProveedor.setForeground(new java.awt.Color(0, 204, 204));
        cmb_BusquedaProveedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        pnl_Proveedor.add(cmb_BusquedaProveedor);
        cmb_BusquedaProveedor.setBounds(210, 40, 120, 30);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 204, 204));
        jLabel16.setText("=");
        pnl_Proveedor.add(jLabel16);
        jLabel16.setBounds(350, 40, 40, 30);

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Lupa.png"))); // NOI18N
        jButton7.setBorderPainted(false);
        jButton7.setContentAreaFilled(false);
        jButton7.setFocusPainted(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        pnl_Proveedor.add(jButton7);
        jButton7.setBounds(660, 40, 40, 30);

        txt_BuscadorProveedor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_BuscadorProveedor.setForeground(new java.awt.Color(0, 153, 153));
        txt_BuscadorProveedor.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_BuscadorProveedor.setSelectionColor(new java.awt.Color(255, 153, 51));
        txt_BuscadorProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_BuscadorProveedorKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_BuscadorProveedorKeyReleased(evt);
            }
        });
        pnl_Proveedor.add(txt_BuscadorProveedor);
        txt_BuscadorProveedor.setBounds(380, 40, 320, 30);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Lupa.png"))); // NOI18N
        jButton6.setBorderPainted(false);
        jButton6.setContentAreaFilled(false);
        jButton6.setFocusPainted(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        pnl_Proveedor.add(jButton6);
        jButton6.setBounds(590, 40, 40, 30);

        getContentPane().add(pnl_Proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 860, 410));

        lbl_Productos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Textos/Productos.png"))); // NOI18N
        getContentPane().add(lbl_Productos, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 250, 50));

        lbl_Proveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Textos/Proveedor.png"))); // NOI18N
        getContentPane().add(lbl_Proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 280, -1));

        lbl_Empleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Textos/Empleado.png"))); // NOI18N
        getContentPane().add(lbl_Empleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, -1));

        pnl_Producto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btn_AgregarProducto.setForeground(new java.awt.Color(0, 204, 204));
        btn_AgregarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Agregar.png"))); // NOI18N
        btn_AgregarProducto.setText("Agregar");
        btn_AgregarProducto.setFocusPainted(false);
        btn_AgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AgregarProductoActionPerformed(evt);
            }
        });
        pnl_Producto.add(btn_AgregarProducto);
        btn_AgregarProducto.setBounds(180, 340, 120, 40);

        btn_ModificarProd.setForeground(new java.awt.Color(0, 204, 204));
        btn_ModificarProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Editar.png"))); // NOI18N
        btn_ModificarProd.setText("Modificar");
        btn_ModificarProd.setFocusPainted(false);
        btn_ModificarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ModificarProdActionPerformed(evt);
            }
        });
        pnl_Producto.add(btn_ModificarProd);
        btn_ModificarProd.setBounds(370, 340, 120, 40);

        jButton3.setForeground(new java.awt.Color(255, 102, 102));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Inhabilitar.png"))); // NOI18N
        jButton3.setText("Eliminar");
        jButton3.setFocusPainted(false);
        pnl_Producto.add(jButton3);
        jButton3.setBounds(560, 340, 130, 40);

        tb_ConsultaProducto.setBackground(new java.awt.Color(204, 204, 255));
        tb_ConsultaProducto.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tb_ConsultaProducto.setForeground(new java.awt.Color(0, 153, 153));
        tb_ConsultaProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre", "Stock", "Precio", "Categoría", "Proveedor", "Activo", "Dimension"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_ConsultaProducto.setGridColor(new java.awt.Color(0, 51, 51));
        tb_ConsultaProducto.setSelectionBackground(new java.awt.Color(0, 102, 153));
        tb_ConsultaProducto.setSelectionForeground(new java.awt.Color(204, 255, 255));
        tb_ConsultaProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_ConsultaProductoMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tb_ConsultaProducto);

        pnl_Producto.add(jScrollPane4);
        jScrollPane4.setBounds(60, 100, 730, 200);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Lupa.png"))); // NOI18N
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.setFocusPainted(false);
        pnl_Producto.add(jButton4);
        jButton4.setBounds(660, 40, 40, 30);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 204, 204));
        jLabel13.setText("Buscar:");
        pnl_Producto.add(jLabel13);
        jLabel13.setBounds(150, 40, 70, 30);

        cmb_BusquedaProducto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cmb_BusquedaProducto.setForeground(new java.awt.Color(0, 204, 204));
        cmb_BusquedaProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        pnl_Producto.add(cmb_BusquedaProducto);
        cmb_BusquedaProducto.setBounds(210, 40, 120, 30);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 204, 204));
        jLabel14.setText("=");
        pnl_Producto.add(jLabel14);
        jLabel14.setBounds(350, 40, 40, 30);

        txt_BuscadorProducto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_BuscadorProducto.setForeground(new java.awt.Color(0, 153, 153));
        txt_BuscadorProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_BuscadorProducto.setSelectionColor(new java.awt.Color(255, 153, 51));
        txt_BuscadorProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_BuscadorProductoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_BuscadorProductoKeyReleased(evt);
            }
        });
        pnl_Producto.add(txt_BuscadorProducto);
        txt_BuscadorProducto.setBounds(380, 40, 320, 30);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Lupa.png"))); // NOI18N
        jButton5.setBorderPainted(false);
        jButton5.setContentAreaFilled(false);
        jButton5.setFocusPainted(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        pnl_Producto.add(jButton5);
        jButton5.setBounds(590, 40, 40, 30);

        getContentPane().add(pnl_Producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 870, 410));

        lbl_Ventas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Textos/Ventas.png"))); // NOI18N
        getContentPane().add(lbl_Ventas, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, -1));

        pnl_Ventas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnl_Ventas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Mairy Extralight Oblicua", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 204, 204));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Textos/Nro Venta.png"))); // NOI18N
        pnl_Ventas.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, 30));

        txtCodigoVenta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtCodigoVenta.setForeground(new java.awt.Color(0, 153, 153));
        txtCodigoVenta.setSelectionColor(new java.awt.Color(255, 153, 51));
        pnl_Ventas.add(txtCodigoVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 80, 30));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Textos/Vendedor.png"))); // NOI18N
        pnl_Ventas.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, -1, 30));

        txtVendedor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtVendedor.setForeground(new java.awt.Color(0, 153, 153));
        txtVendedor.setSelectionColor(new java.awt.Color(255, 153, 51));
        pnl_Ventas.add(txtVendedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 30, 120, 30));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Textos/Fecha.png"))); // NOI18N
        pnl_Ventas.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 30, 50, 30));

        txtCodigoProducto.setForeground(new java.awt.Color(0, 153, 153));
        txtCodigoProducto.setSelectionColor(new java.awt.Color(255, 153, 51));
        txtCodigoProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCodigoProductoMouseClicked(evt);
            }
        });
        txtCodigoProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoProductoKeyPressed(evt);
            }
        });
        pnl_Ventas.add(txtCodigoProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 260, 30));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Textos/Codigo.png"))); // NOI18N
        pnl_Ventas.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, -1, 30));

        txtDescuento.setFont(new java.awt.Font("DS-Digital", 0, 18)); // NOI18N
        txtDescuento.setForeground(new java.awt.Color(0, 153, 153));
        txtDescuento.setSelectionColor(new java.awt.Color(255, 153, 51));
        txtDescuento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDescuentoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDescuentoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescuentoKeyTyped(evt);
            }
        });
        pnl_Ventas.add(txtDescuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 290, 50, 30));

        txtCancelarVenta.setForeground(new java.awt.Color(255, 51, 51));
        txtCancelarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Inhabilitar.png"))); // NOI18N
        txtCancelarVenta.setText("Cancelar");
        txtCancelarVenta.setFocusPainted(false);
        txtCancelarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCancelarVentaActionPerformed(evt);
            }
        });
        pnl_Ventas.add(txtCancelarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 340, 120, 40));

        btnQuitarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Quitar.png"))); // NOI18N
        btnQuitarProducto.setFocusPainted(false);
        btnQuitarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarProductoActionPerformed(evt);
            }
        });
        pnl_Ventas.add(btnQuitarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 160, 40, 40));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Textos/Stock1.png"))); // NOI18N
        pnl_Ventas.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 90, 60, 30));

        tb_Venta.setBackground(new java.awt.Color(204, 204, 255));
        tb_Venta.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tb_Venta.setForeground(new java.awt.Color(0, 153, 153));
        tb_Venta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre", "Cantidad", "Precio", "Sub Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_Venta.setGridColor(new java.awt.Color(0, 51, 51));
        tb_Venta.setSelectionBackground(new java.awt.Color(0, 102, 153));
        tb_Venta.setSelectionForeground(new java.awt.Color(204, 255, 255));
        tb_Venta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_VentaMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tb_Venta);

        pnl_Ventas.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 590, 170));

        txtRecibo.setFont(new java.awt.Font("DS-Digital", 0, 18)); // NOI18N
        txtRecibo.setForeground(new java.awt.Color(0, 153, 153));
        txtRecibo.setSelectionColor(new java.awt.Color(255, 153, 51));
        txtRecibo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtReciboMouseClicked(evt);
            }
        });
        txtRecibo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtReciboKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtReciboKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtReciboKeyTyped(evt);
            }
        });
        pnl_Ventas.add(txtRecibo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 340, 110, 30));

        txtVuelto.setFont(new java.awt.Font("DS-Digital", 0, 18)); // NOI18N
        txtVuelto.setForeground(new java.awt.Color(0, 153, 153));
        txtVuelto.setSelectionColor(new java.awt.Color(255, 153, 51));
        pnl_Ventas.add(txtVuelto, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 340, 110, 30));

        txtTotalaPagar.setFont(new java.awt.Font("DS-Digital", 0, 18)); // NOI18N
        txtTotalaPagar.setForeground(new java.awt.Color(255, 102, 102));
        txtTotalaPagar.setSelectionColor(new java.awt.Color(255, 153, 51));
        txtTotalaPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalaPagarActionPerformed(evt);
            }
        });
        pnl_Ventas.add(txtTotalaPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 340, 110, 30));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Textos/Total.png"))); // NOI18N
        pnl_Ventas.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 340, -1, 30));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Textos/Recibo.png"))); // NOI18N
        pnl_Ventas.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 340, -1, 30));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Textos/Vuelto.png"))); // NOI18N
        pnl_Ventas.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 340, -1, 30));

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Textos/Descuento.png"))); // NOI18N
        pnl_Ventas.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 290, -1, 30));

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Textos/Hora.png"))); // NOI18N
        pnl_Ventas.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 30, 50, 30));

        lbl_Fecha.setFont(new java.awt.Font("DS-Digital", 0, 24)); // NOI18N
        lbl_Fecha.setForeground(new java.awt.Color(0, 204, 204));
        lbl_Fecha.setText("00/00/00");
        pnl_Ventas.add(lbl_Fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 30, 110, 30));

        lbl_Hora.setFont(new java.awt.Font("DS-Digital", 0, 24)); // NOI18N
        lbl_Hora.setForeground(new java.awt.Color(0, 204, 204));
        lbl_Hora.setText("00:00:00");
        pnl_Ventas.add(lbl_Hora, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 30, -1, 30));

        pnl_Stock.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lbl_StockMalo.setForeground(new java.awt.Color(255, 153, 153));
        lbl_StockMalo.setText("Por debajo de la media");
        pnl_Stock.add(lbl_StockMalo);
        lbl_StockMalo.setBounds(20, 0, 150, 50);

        lbl_StockNormal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_StockNormal.setForeground(new java.awt.Color(0, 204, 204));
        lbl_StockNormal.setText("Por sobre la media");
        pnl_Stock.add(lbl_StockNormal);
        lbl_StockNormal.setBounds(20, 0, 150, 50);

        pnl_Ventas.add(pnl_Stock, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 80, 170, 50));

        jLabel20.setForeground(new java.awt.Color(0, 204, 204));
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Textos/Cantidad.png"))); // NOI18N
        pnl_Ventas.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 90, -1, 30));

        txtCantidad.setForeground(new java.awt.Color(0, 153, 153));
        txtCantidad.setSelectionColor(new java.awt.Color(255, 153, 51));
        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCantidadKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCantidadKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });
        pnl_Ventas.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 90, 70, 30));

        jLabel21.setForeground(new java.awt.Color(0, 204, 204));
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Textos/Articulos.png"))); // NOI18N
        pnl_Ventas.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 240, -1, 30));

        lbl_Articulos.setFont(new java.awt.Font("DS-Digital", 0, 18)); // NOI18N
        lbl_Articulos.setForeground(new java.awt.Color(0, 204, 204));
        lbl_Articulos.setText("------");
        pnl_Ventas.add(lbl_Articulos, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 240, -1, 30));

        pnl_TipoPago.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        TipoPago.add(rb_Efectivo);
        rb_Efectivo.setForeground(new java.awt.Color(0, 153, 153));
        rb_Efectivo.setText("Efectivo");
        rb_Efectivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rb_EfectivoMouseClicked(evt);
            }
        });
        pnl_TipoPago.add(rb_Efectivo);

        TipoPago.add(rb_Tarjeta);
        rb_Tarjeta.setForeground(new java.awt.Color(0, 153, 153));
        rb_Tarjeta.setText("Tarjeta");
        rb_Tarjeta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rb_TarjetaMouseClicked(evt);
            }
        });
        pnl_TipoPago.add(rb_Tarjeta);

        pnl_Ventas.add(pnl_TipoPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 150, 90, 70));

        jLabel24.setFont(new java.awt.Font("DS-Digital", 0, 24)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 204, 204));
        jLabel24.setText("%");
        pnl_Ventas.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 290, 20, 30));

        getContentPane().add(pnl_Ventas, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 880, 410));

        lbl_Cliente.setForeground(new java.awt.Color(0, 153, 153));
        lbl_Cliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Textos/Usuarios.png"))); // NOI18N
        getContentPane().add(lbl_Cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, -1));

        btn_Conductor1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Boton Menú 2.png"))); // NOI18N
        btn_Conductor1.setBorder(null);
        btn_Conductor1.setBorderPainted(false);
        btn_Conductor1.setContentAreaFilled(false);
        btn_Conductor1.setFocusPainted(false);
        btn_Conductor1.setPreferredSize(new java.awt.Dimension(39, 39));
        btn_Conductor1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Boton Menú 2 Press.png"))); // NOI18N
        btn_Conductor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Conductor1ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Conductor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 20, 40, -1));

        lbl_NuevoPedido.setFont(new java.awt.Font("DS-Digital", 0, 18)); // NOI18N
        lbl_NuevoPedido.setForeground(new java.awt.Color(255, 51, 51));
        lbl_NuevoPedido.setText("notificacion:");
        getContentPane().add(lbl_NuevoPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 30, -1, 20));

        lbl_NumeroCantidad.setFont(new java.awt.Font("DS-Digital", 0, 18)); // NOI18N
        lbl_NumeroCantidad.setForeground(new java.awt.Color(255, 51, 51));
        lbl_NumeroCantidad.setText("1");
        getContentPane().add(lbl_NumeroCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 30, 20, 20));

        lbl_Nuevo.setFont(new java.awt.Font("DS-Digital", 0, 18)); // NOI18N
        lbl_Nuevo.setForeground(new java.awt.Color(255, 51, 51));
        lbl_Nuevo.setText("Nuevo pedido");
        getContentPane().add(lbl_Nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 30, -1, 20));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Fondo Proceso.jpg"))); // NOI18N
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 960, 590));

        lbl_Fecha1.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        lbl_Fecha1.setForeground(new java.awt.Color(0, 204, 204));
        lbl_Fecha1.setText("--");
        getContentPane().add(lbl_Fecha1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        menu_CambiarContraseña.setText("Configuración");
        menu_CambiarContraseña.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        menu_Configuracion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        menu_Configuracion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        menu_Configuracion.setText("Configuración");
        menu_Configuracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_ConfiguracionActionPerformed(evt);
            }
        });
        menu_CambiarContraseña.add(menu_Configuracion);

        menu_CambiarContra.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK));
        menu_CambiarContra.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        menu_CambiarContra.setText("Cambiar contraseña");
        menu_CambiarContra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_CambiarContraActionPerformed(evt);
            }
        });
        menu_CambiarContraseña.add(menu_CambiarContra);
        menu_CambiarContraseña.add(jSeparator1);

        menu_CerrarSesion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        menu_CerrarSesion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        menu_CerrarSesion.setText("Cerrar sesión");
        menu_CerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_CerrarSesionActionPerformed(evt);
            }
        });
        menu_CambiarContraseña.add(menu_CerrarSesion);

        jMenuBar1.add(menu_CambiarContraseña);

        jMenu2.setText("Ver");
        jMenu2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        menu_Ventas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        menu_Ventas.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        menu_Ventas.setText("Ventas");
        menu_Ventas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_VentasActionPerformed(evt);
            }
        });
        jMenu2.add(menu_Ventas);

        menu_Producto.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        menu_Producto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        menu_Producto.setText("Productos");
        menu_Producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_ProductoActionPerformed(evt);
            }
        });
        jMenu2.add(menu_Producto);

        menu_Proveedor.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        menu_Proveedor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        menu_Proveedor.setText("Proveedor");
        menu_Proveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_ProveedorActionPerformed(evt);
            }
        });
        jMenu2.add(menu_Proveedor);

        menu_Empleado.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        menu_Empleado.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        menu_Empleado.setText("Empleados");
        menu_Empleado.setEnabled(false);
        menu_Empleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_EmpleadoActionPerformed(evt);
            }
        });
        jMenu2.add(menu_Empleado);
        jMenu2.add(jSeparator2);

        menu_HistorialVenta.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        menu_HistorialVenta.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        menu_HistorialVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complementos/Lupa.png"))); // NOI18N
        menu_HistorialVenta.setText("Historial de ventas");
        menu_HistorialVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_HistorialVentaActionPerformed(evt);
            }
        });
        jMenu2.add(menu_HistorialVenta);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Despachos");
        jMenu3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jMenuItem1.setText("Pedidos");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jMenuItem2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jMenuItem2.setText("Comprar");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        menu_Movil.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        menu_Movil.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        menu_Movil.setText("Móviles");
        menu_Movil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_MovilActionPerformed(evt);
            }
        });
        jMenu3.add(menu_Movil);

        menu_Cliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        menu_Cliente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        menu_Cliente.setText("Clientes");
        menu_Cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_ClienteActionPerformed(evt);
            }
        });
        jMenu3.add(menu_Cliente);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        jMenuItem3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jMenuItem3.setText("Conductor");
        jMenu3.add(jMenuItem3);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_PanelMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_PanelMenuActionPerformed
        //Verifica el estado del panel lo hace visible o invisible
        if (this.pnl_PanelMenu.isVisible() == false)
            pnl_PanelMenu.setVisible(true);
        else
            pnl_PanelMenu.setVisible(false); 
    }//GEN-LAST:event_btn_PanelMenuActionPerformed

    private void btn_AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AceptarActionPerformed
       
        if (ventas) 
            hacerVenta();
        else if (cliente)
           llamarBusquedaCiente();
        else if (producto) 
           llamarBusquedaProducto();
        else if (empleado)
            llamarBusquedaEmpleado();
        else if (proveedor)
            llamarBusquedaProveedor();
  
    }//GEN-LAST:event_btn_AceptarActionPerformed

    private void btn_DespachoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DespachoActionPerformed
        abrirPedido();
    }//GEN-LAST:event_btn_DespachoActionPerformed
    
    private void nadaVisible(){
        ventas = false;
        producto = false;
        proveedor = false;
        empleado = false;
        cliente = false;
        
        lbl_Ventas.setVisible(false);
        lbl_Productos.setVisible(false);
        lbl_Proveedor.setVisible(false);
        lbl_Empleado.setVisible(false);
        lbl_Cliente.setVisible(false);
        
        pnl_Ventas.setVisible(false);
        pnl_Producto.setVisible(false); 
        pnl_Proveedor.setVisible(false);
        pnl_IngresoEmpleado.setVisible(false);
        pnl_IngresoCliente.setVisible(false);
    }
    
    private void panelCliente(){
        nadaVisible();
        cliente = true;
        pnl_IngresoCliente.setVisible(true);
        lbl_Cliente.setVisible(true);
    }
    
    private void btn_ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ClienteActionPerformed
        panelCliente();
        txt_BuscadorCliente.requestFocus();
    }//GEN-LAST:event_btn_ClienteActionPerformed
    
    private void panelProducto(){
        nadaVisible();
        producto = true;
        lbl_Productos.setVisible(true);
        pnl_Producto.setVisible(true);
    }
    
    private void btn_ProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ProductoActionPerformed
        panelProducto();
        txt_BuscadorProducto.requestFocus();
    }//GEN-LAST:event_btn_ProductoActionPerformed
   
    private void panelProveedor(){
        nadaVisible();
        pnl_Proveedor.setVisible(true);
        proveedor = true;
        lbl_Proveedor.setVisible(true);
    }
    
    private void btn_ProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ProveedorActionPerformed
        panelProveedor();
        txt_BuscadorProveedor.requestFocus();
    }//GEN-LAST:event_btn_ProveedorActionPerformed

    private void btn_MovilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_MovilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_MovilActionPerformed

    private void btn_ConductorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ConductorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_ConductorActionPerformed

    private void btn_CerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CerrarSesionActionPerformed
        cerrarSesion();
    }//GEN-LAST:event_btn_CerrarSesionActionPerformed
    
    private void cerrarSesion(){
        busqueda = false;
        Inicio ini = new Inicio();
        this.setVisible(false);
        ini.setVisible(true);
    }
    
    private void panelEmpleado(){
        nadaVisible();
        empleado = true;
        pnl_IngresoEmpleado.setVisible(true);
        lbl_Empleado.setVisible(true);
    }
    
    private void btn_InsertarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_InsertarEmpleadoActionPerformed
        panelEmpleado();
        txt_BuscadorEmpleado.requestFocus();
    }//GEN-LAST:event_btn_InsertarEmpleadoActionPerformed
    
    private void panelVentas(){
        nadaVisible();
        lbl_Ventas.setVisible(true);
        pnl_Ventas.setVisible(true);
    }
    
    private void btn_VentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_VentaActionPerformed
        panelVentas();
        txtCodigoProducto.requestFocus();
        ventas = true;
    }//GEN-LAST:event_btn_VentaActionPerformed

    private void pnl_PanelMenuFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pnl_PanelMenuFocusLost
        pnl_PanelMenu.setVisible(false);
    }//GEN-LAST:event_pnl_PanelMenuFocusLost

    private void pnl_PanelMenuFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pnl_PanelMenuFocusGained
        pnl_PanelMenu.setVisible(false);
    }//GEN-LAST:event_pnl_PanelMenuFocusGained

    private void btn_ModificarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ModificarEmpleadoActionPerformed
        Empleado emp;
        cambio = false;
        int filaseleccionada = tb_ConsultaEmpleado.getSelectedRow();
        
        if (filaseleccionada >= 0) {
        
            emp = modificarEmpleado();

            JDialog_Emple jdem = new JDialog_Emple(this, true, emp);
            jdem.setVisible(true);
            
            for (int i = tb_ConsultaEmpleado.getRowCount() - 1; i >=0 ; i--)
                modelo2.removeRow(i); // El modelo limpia la tabla
        
            tablaEmpleado(); // Volvemos a cargar la tabla
            tablaVenta();
        }
        else
            JOptionPane.showMessageDialog(null, "No ha seleccionado ningún empleado.","Seleccione empleado",JOptionPane.INFORMATION_MESSAGE);   
        
    }//GEN-LAST:event_btn_ModificarEmpleadoActionPerformed

    private void btn_InhabilitarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_InhabilitarEmpleadoActionPerformed
        Empleado emp = new Empleado();
        
        int filaseleccionada = tb_ConsultaEmpleado.getSelectedRow();
  
        emp.setNombre(tb_ConsultaEmpleado.getValueAt(filaseleccionada, 1).toString()); //getValueAt ob tiene el valor de la fila

        cambio = true;
        
        if(JOptionPane.showConfirmDialog(null, "Seguro que quieres inhabilitar al empleado: "+emp.getNombre()+"?", "Inhabilitar", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE)==JOptionPane.YES_OPTION){
            emp = modificarEmpleado();

            if (emp.actualizarEmpleado())
                JOptionPane.showMessageDialog(null, "Empleado inhabilitado correctamente.","Empleado inhabilitado",JOptionPane.INFORMATION_MESSAGE);
            else
                JOptionPane.showMessageDialog(null, "Ocurrio un error al intentar inhabilitar al cliente","Cliente NO inhabilitado",JOptionPane.ERROR_MESSAGE);            
            
            
            for (int i = tb_ConsultaEmpleado.getRowCount() - 1; i >=0 ; i--)
                modelo2.removeRow(i); // El modelo limpia la tabla
        
            tablaEmpleado(); // Volvemos a cargar la tabla
        }  
    }//GEN-LAST:event_btn_InhabilitarEmpleadoActionPerformed

    private void btn_AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AgregarActionPerformed
        JDialog_Emple jdem = new JDialog_Emple(this, true);
        jdem.setVisible(true);
//        int filaseleccionada = tb_ConsultaEmpleado.getSelectedRow();
        for (int i = tb_ConsultaEmpleado.getRowCount() - 1; i >=0 ; i--)
            modelo2.removeRow(i); // El modelo limpia la tabla

        tablaEmpleado(); // Volvemos a cargar la tabla
        //Convert.ToInt64(grdEjemplo.Rows[i].Cells[0].Value.ToString())
//        for (int i = 0; i < tb_ConsultaEmpleado.getRowCount(); i++){
//            
//            if (filaseleccionada == Integer.valueOf(tb_ConsultaEmpleado.getValueAt(i, filaseleccionada).toString()) ) {
//                
//                tb_ConsultaEmpleado.getRowHeight(i);
//                //Seleccionamos la primera celda que esté visible. En este caso la 1
//                tb_ConsultaEmpleado.CurrentCell = tb_ConsultaEmpleado.Rows[i].Cells[1];
//                break;
//            }
//        }
    }//GEN-LAST:event_btn_AgregarActionPerformed

    private void btn_AñadirProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AñadirProvActionPerformed
        JDialog_Proveedor jdpv = new JDialog_Proveedor(new javax.swing.JDialog(), true);
        jdpv.setVisible(true);
        
        for (int i = tb_ConsultaProveedor.getRowCount() - 1; i >=0 ; i--)
            modelo1.removeRow(i); // El modelo limpia la tabla

        tablaProveedor();
    }//GEN-LAST:event_btn_AñadirProvActionPerformed

    private void btn_ModificarProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ModificarProvActionPerformed
        modificarProveedor();
    }//GEN-LAST:event_btn_ModificarProvActionPerformed

    private void btn_EliminarProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EliminarProvActionPerformed
        Proveedor prov = new Proveedor();
        int filaseleccionada = tb_ConsultaProveedor.getSelectedRow();
        
        if (filaseleccionada>=0) {
            //DefaultTableModel modelo = (DefaultTableModel)tb_ConsultaEmpleado.getModel();
            prov.setId(Integer.valueOf(tb_ConsultaProveedor.getValueAt(filaseleccionada, 0).toString()) ); //getValueAt ob tiene el valor de la fila
            prov.setNombre(tb_ConsultaProveedor.getValueAt(filaseleccionada, 1).toString());
            int filaselec = tb_ConsultaProveedor.getSelectedRow();
            if(JOptionPane.showConfirmDialog(null, "Seguro que quieres eliminar al proveedor: "+prov.getNombre()+"?", "Eliminar", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE)==JOptionPane.YES_OPTION){

                if (prov.eliminarProveedor(prov.getId())){
                    JOptionPane.showMessageDialog(null, "Proveedor eliminado correctamente.","Proveedor eliminado",JOptionPane.INFORMATION_MESSAGE);
                    modelo.removeRow(filaselec); 
                }
                else
                    JOptionPane.showMessageDialog(null, "Ocurrio un error al intentar eliminar al proveedor","Proveedor NO eliminado",JOptionPane.ERROR_MESSAGE);            
            }
        }
        else
            JOptionPane.showMessageDialog(null, "No ha seleccionado ningún proveedor.","Seleccione proveedor",JOptionPane.INFORMATION_MESSAGE);           
    }//GEN-LAST:event_btn_EliminarProvActionPerformed

    private void btn_AgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AgregarProductoActionPerformed
        JDialog_Producto jdprod = new JDialog_Producto(new javax.swing.JDialog(), true);
        jdprod.setVisible(true);

        for (int i = tb_ConsultaProducto.getRowCount() - 1; i >=0 ; i--)
            modelo.removeRow(i); // El modelo limpia la tabla

        tablaProducto(); // Volvemos a cargar la tabla
    }//GEN-LAST:event_btn_AgregarProductoActionPerformed

    private void btn_ModificarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ModificarProdActionPerformed
        modificarProducto();
    }//GEN-LAST:event_btn_ModificarProdActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void txt_BuscadorEmpleadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_BuscadorEmpleadoKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
            llamarBusquedaEmpleado();
    }//GEN-LAST:event_txt_BuscadorEmpleadoKeyPressed

    private void txt_BuscadorProductoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_BuscadorProductoKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            //if (cmb_BusquedaProducto.getSelectedItem().equals("Código" ) && !txt_BuscadorProducto.getText().equals("")){
                agrega = true;
                llamarBusquedaProducto();
                //    productoNoRegistrado();
            //}
            //else
               // llamarBusquedaProducto();
        }
    }//GEN-LAST:event_txt_BuscadorProductoKeyPressed
    
    private void txt_BuscadorProveedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_BuscadorProveedorKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
            llamarBusquedaProveedor();
    }//GEN-LAST:event_txt_BuscadorProveedorKeyPressed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void txt_BuscadorClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_BuscadorClienteKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
            llamarBusquedaCiente();
    }//GEN-LAST:event_txt_BuscadorClienteKeyPressed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void ckb_ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckb_ClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ckb_ClienteActionPerformed

    private void tb_ConsultaEmpleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_ConsultaEmpleadoMouseClicked
        Empleado emp;
        
        if (evt.getClickCount() == 2) {
            int filaseleccionada = tb_ConsultaEmpleado.getSelectedRow();
            cambio = false;
            
            if (filaseleccionada >= 0) {
                
                emp = modificarEmpleado();

                JDialog_Emple jdem = new JDialog_Emple(this, true, emp);
                jdem.setVisible(true);
            
                for (int i = tb_ConsultaEmpleado.getRowCount() - 1; i >=0 ; i--)
                    modelo2.removeRow(i); // El modelo limpia la tabla
        
                tablaEmpleado(); // Volvemos a cargar la tabla
            }
            else
                JOptionPane.showMessageDialog(null, "No ha seleccionado ningún empleado.","Seleccione empleado",JOptionPane.INFORMATION_MESSAGE);   
        
        }
        else if (evt.getClickCount() == 1){
            int filaseleccionada = tb_ConsultaEmpleado.getSelectedRow();
            
            if (!tb_ConsultaEmpleado.getValueAt(filaseleccionada, 6).toString().equals("Inhabilitado")) {
                btn_InhabilitarEmpleado.setVisible(true);
                btn_HabilitarEmpleado.setVisible(false);
            }
            else{
                btn_HabilitarEmpleado.setVisible(true);
                btn_InhabilitarEmpleado.setVisible(false); 
            }
        }
    }//GEN-LAST:event_tb_ConsultaEmpleadoMouseClicked

    private void tb_ConsultaProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_ConsultaProductoMouseClicked
        if (evt.getClickCount() == 2) 
            modificarProducto();
    }//GEN-LAST:event_tb_ConsultaProductoMouseClicked

    private void tb_ConsultaProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_ConsultaProveedorMouseClicked
        if (evt.getClickCount() == 2) 
            modificarProveedor();
    }//GEN-LAST:event_tb_ConsultaProveedorMouseClicked

    private void menu_CambiarContraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_CambiarContraActionPerformed
        JDialog_Contraseña jdcontra = new JDialog_Contraseña(this, true, empl);
        jdcontra.setVisible(true);

        if (jdcontra.cambio()) {
            this.setVisible(false);
            Inicio ini = new Inicio();
            ini.setVisible(true);
        }
    }//GEN-LAST:event_menu_CambiarContraActionPerformed

    private void menu_CerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_CerrarSesionActionPerformed
        cerrarSesion();
    }//GEN-LAST:event_menu_CerrarSesionActionPerformed

    private void menu_VentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_VentasActionPerformed
        panelVentas();
    }//GEN-LAST:event_menu_VentasActionPerformed

    private void menu_ProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_ProductoActionPerformed
        panelProducto();
    }//GEN-LAST:event_menu_ProductoActionPerformed

    private void menu_ProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_ProveedorActionPerformed
        panelProveedor();
    }//GEN-LAST:event_menu_ProveedorActionPerformed

    private void menu_EmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_EmpleadoActionPerformed
        panelEmpleado();
    }//GEN-LAST:event_menu_EmpleadoActionPerformed

    private void menu_ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_ClienteActionPerformed
        panelCliente();
    }//GEN-LAST:event_menu_ClienteActionPerformed

    private void btn_HabilitarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_HabilitarEmpleadoActionPerformed
        Empleado emp = new Empleado();
        int filaseleccionada = tb_ConsultaEmpleado.getSelectedRow();
        emp.setNombre(tb_ConsultaEmpleado.getValueAt(filaseleccionada, 1).toString()); //getValueAt ob tiene el valor de la fila
        cambio = true;
        
        if(JOptionPane.showConfirmDialog(null, "Seguro que quieres habilitar al empleado: "+emp.getNombre()+"?", "Inhabilitar", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE)==JOptionPane.YES_OPTION){
            emp = modificarEmpleado();

            if (emp.actualizarEmpleado())
                JOptionPane.showMessageDialog(null, "Empleado habilitado correctamente.","Empleado habilitado",JOptionPane.INFORMATION_MESSAGE);
            else
                JOptionPane.showMessageDialog(null, "Ocurrio un error al intentar habilitar al cliente","Cliente NO habilitado",JOptionPane.ERROR_MESSAGE);            

            for (int i = tb_ConsultaEmpleado.getRowCount() - 1; i >=0 ; i--)
                modelo2.removeRow(i); // El modelo limpia la tabla
        
            tablaEmpleado(); // Volvemos a cargar la tabla
        } 
    }//GEN-LAST:event_btn_HabilitarEmpleadoActionPerformed
    
    private void abrirHistorial(){
        Historial_Venta hv = new Historial_Venta(this, true);
        hv.setVisible(true);
    }    
    
    private void menu_HistorialVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_HistorialVentaActionPerformed
        abrirHistorial();
    }//GEN-LAST:event_menu_HistorialVentaActionPerformed
    
    private void eliminarProducto(){
        int filaseleccionada = tb_Venta.getSelectedRow();
        //Resta la cantidad del sub total al total
        txtTotalaPagar.setText(String.valueOf(Float.valueOf(txtTotalaPagar.getText()) - Float.valueOf(modelo0.getValueAt(filaseleccionada, 4).toString())));
        // El modelo limpia la tabla
        modelo0.removeRow(filaseleccionada); 
        lbl_Articulos.setText(String.valueOf(0));
        
        calculaDescuento();
        calculaTotal();
        calcularVuelto();
        calcularCantidad();
    }
    
    private void tb_VentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_VentaMouseClicked
        if (evt.getClickCount() == 2)
            eliminarProducto();
    }//GEN-LAST:event_tb_VentaMouseClicked

    private void txtTotalaPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalaPagarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalaPagarActionPerformed
    private void calcularVuelto(){
        Validar v = new Validar();
        if (Float.valueOf(txtTotalaPagar.getText()) > 0) {
            if (!txtRecibo.getText().equals("")) {
                if (Float.valueOf(txtRecibo.getText()) - Float.valueOf(txtTotalaPagar.getText()) >= 0)
                    txtVuelto.setText(String.valueOf(Float.valueOf(txtRecibo.getText()) - Float.valueOf(txtTotalaPagar.getText())));
            }
            else
                txtVuelto.setText("0");
        } 
    }
    private void txtReciboKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtReciboKeyReleased
        calcularVuelto();
    }//GEN-LAST:event_txtReciboKeyReleased

    private void txtCodigoProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCodigoProductoMouseClicked
        
    }//GEN-LAST:event_txtCodigoProductoMouseClicked

    private void txtCodigoProductoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoProductoKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
            tablaVenta();
    }//GEN-LAST:event_txtCodigoProductoKeyPressed

    private void btnQuitarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarProductoActionPerformed
        int filaseleccionada = tb_Venta.getSelectedRow();
        
        if(tb_Venta.getRowCount()!=0 && tb_Venta.getSelectedRow()!=-1){
            if (filaseleccionada >= 0) 
                eliminarProducto();
            else
                JOptionPane.showMessageDialog(null, "No ha seleccionado ningún producto.","Seleccione producto",JOptionPane.INFORMATION_MESSAGE);   
        } 
    }//GEN-LAST:event_btnQuitarProductoActionPerformed
    
    static boolean click = true;
    
    private void txtReciboMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtReciboMouseClicked
        if (click) {
            txtRecibo.setText("");
            click = false;
        }
    }//GEN-LAST:event_txtReciboMouseClicked
    
    private void quitarTodasLasVentas(){
        if(this.tb_Venta.getRowCount()!=0){
            
            for (int i = tb_Venta.getRowCount() -1; i >= 0; i--)
                modelo0.removeRow(i);

            txtRecibo.setText("");
            txtVuelto.setText("0");
            txtDescuento.setText("0");
            txtCantidad.setText("");
            lbl_Articulos.setText("0");
            calculaTotal();
        }
    }
    
    private void txtCancelarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCancelarVentaActionPerformed
        quitarTodasLasVentas();
    }//GEN-LAST:event_txtCancelarVentaActionPerformed

    private void txtReciboKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtReciboKeyPressed

    }//GEN-LAST:event_txtReciboKeyPressed
    
    private void calculaDescuento(){
        if(this.tb_Venta.getRowCount()!=0){
            if (!txtDescuento.getText().equals("")) {
                if (Float.valueOf(txtDescuento.getText())  <= 100) {
                    float porc = total1 - (total1/100 * Float.valueOf(txtDescuento.getText())) ;
                    txtTotalaPagar.setText(String.valueOf(Float.valueOf(porc)));
                    
                    if (rb_Tarjeta.isSelected()) 
                        txtRecibo.setText(txtTotalaPagar.getText());
                }
                else
                    calculaTotal();
            }
            else
                calculaTotal();
        }
        else
            txtDescuento.setText("");
    }
    
    private void txtDescuentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescuentoKeyReleased
        calculaDescuento();
    }//GEN-LAST:event_txtDescuentoKeyReleased

    private void txtCantidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyReleased

    }//GEN-LAST:event_txtCantidadKeyReleased

    private void txtCantidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
            tablaVenta();
    }//GEN-LAST:event_txtCantidadKeyPressed

    private void rb_TarjetaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rb_TarjetaMouseClicked
        txtRecibo.setEditable(false);
        txtRecibo.setText(txtTotalaPagar.getText());
        txtVuelto.setText("0");   
    }//GEN-LAST:event_rb_TarjetaMouseClicked

    private void rb_EfectivoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rb_EfectivoMouseClicked
        txtRecibo.setEditable(true);
    }//GEN-LAST:event_rb_EfectivoMouseClicked

    private void txt_BuscadorEmpleadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_BuscadorEmpleadoKeyReleased
        llamarBusquedaEmpleado();
    }//GEN-LAST:event_txt_BuscadorEmpleadoKeyReleased
    private boolean agrega = false;
    private void txt_BuscadorProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_BuscadorProductoKeyReleased
        agrega = false;
        llamarBusquedaProducto(); 
    }//GEN-LAST:event_txt_BuscadorProductoKeyReleased

    private void txt_BuscadorProveedorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_BuscadorProveedorKeyReleased
        llamarBusquedaProveedor();
    }//GEN-LAST:event_txt_BuscadorProveedorKeyReleased

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped
        Validar v = new Validar();       
        if (!v.maximoLargo(txtCantidad.getText(), 4))
            evt.consume();  
        
        if(!Character.isDigit(evt.getKeyChar())) 
            evt.consume(); 
    }//GEN-LAST:event_txtCantidadKeyTyped

    private void menu_ConfiguracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_ConfiguracionActionPerformed
        Configuracion con = new Configuracion(this, true);
        con.setVisible(true);
    }//GEN-LAST:event_menu_ConfiguracionActionPerformed

    private void btn_ComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ComprarActionPerformed
        abrirCompras();
        tablaProducto();
    }//GEN-LAST:event_btn_ComprarActionPerformed

    private void btn_HistorialVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_HistorialVentasActionPerformed
        abrirHistorial();
    }//GEN-LAST:event_btn_HistorialVentasActionPerformed

    private void btn_Conductor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Conductor1ActionPerformed
        
        if (pnl_Despachos.isVisible()) 
            pnl_Despachos.setVisible(false);
        else
            pnl_Despachos.setVisible(true);
    }//GEN-LAST:event_btn_Conductor1ActionPerformed

    private void txtReciboKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtReciboKeyTyped
        Validar v = new Validar();  
        
        if (!v.maximoLargo(txtRecibo.getText(), 9))
            evt.consume();

        if(!Character.isDigit(evt.getKeyChar())) 
            evt.consume(); 
    }//GEN-LAST:event_txtReciboKeyTyped

    private void txtDescuentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescuentoKeyPressed

    }//GEN-LAST:event_txtDescuentoKeyPressed

    private void txtDescuentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescuentoKeyTyped
        Validar v = new Validar();       
        if (!v.maximoLargo(txtDescuento.getText(), 2))
            evt.consume();  
        
        if(!Character.isDigit(evt.getKeyChar())) 
            evt.consume(); 
    }//GEN-LAST:event_txtDescuentoKeyTyped

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        abrirPedido();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        abrirCompras();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void menu_MovilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_MovilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menu_MovilActionPerformed

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
            java.util.logging.Logger.getLogger(Seleccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Seleccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Seleccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Seleccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        new Seleccion();
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Seleccion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.ButtonGroup TipoPago;
    private javax.swing.JButton btnQuitarProducto;
    private javax.swing.JButton btn_Aceptar;
    private javax.swing.JButton btn_Agregar;
    private javax.swing.JButton btn_AgregarProducto;
    private javax.swing.JButton btn_AñadirProv;
    private javax.swing.JButton btn_CerrarSesion;
    private javax.swing.JButton btn_Cliente;
    private javax.swing.JButton btn_Comprar;
    private javax.swing.JButton btn_Conductor;
    private javax.swing.JButton btn_Conductor1;
    private javax.swing.JButton btn_Despacho;
    private javax.swing.JButton btn_EliminarProv;
    private javax.swing.JButton btn_HabilitarEmpleado;
    private javax.swing.JButton btn_HistorialVentas;
    private javax.swing.JButton btn_InhabilitarEmpleado;
    private javax.swing.JButton btn_InsertarEmpleado;
    private javax.swing.JLabel btn_Menu;
    private javax.swing.JButton btn_ModificarEmpleado;
    private javax.swing.JButton btn_ModificarProd;
    private javax.swing.JButton btn_ModificarProv;
    private javax.swing.JButton btn_Movil;
    private javax.swing.JButton btn_PanelMenu;
    private javax.swing.JButton btn_Producto;
    private javax.swing.JButton btn_Proveedor;
    private javax.swing.JButton btn_Venta;
    private javax.swing.JCheckBox ckb_Cliente;
    private javax.swing.JComboBox<String> cmb_BusquedaCliente;
    private javax.swing.JComboBox<String> cmb_BusquedaEmpleado;
    private javax.swing.JComboBox<String> cmb_BusquedaProducto;
    private javax.swing.JComboBox<String> cmb_BusquedaProveedor;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JLabel lbl_Articulos;
    private javax.swing.JLabel lbl_CirculoNot;
    private javax.swing.JLabel lbl_Cliente;
    private javax.swing.JLabel lbl_Empleado;
    private javax.swing.JLabel lbl_Fecha;
    private javax.swing.JLabel lbl_Fecha1;
    private javax.swing.JLabel lbl_Hora;
    private javax.swing.JLabel lbl_Linea;
    private javax.swing.JLabel lbl_Nuevo;
    private javax.swing.JLabel lbl_NuevoPedido;
    private javax.swing.JLabel lbl_NumeroCantidad;
    private javax.swing.JLabel lbl_NumeroNot;
    private javax.swing.JLabel lbl_Productos;
    private javax.swing.JLabel lbl_Proveedor;
    private javax.swing.JLabel lbl_StockMalo;
    private javax.swing.JLabel lbl_StockNormal;
    private javax.swing.JLabel lbl_Ventas;
    private javax.swing.JMenuItem menu_CambiarContra;
    private javax.swing.JMenu menu_CambiarContraseña;
    private javax.swing.JMenuItem menu_CerrarSesion;
    private javax.swing.JMenuItem menu_Cliente;
    private javax.swing.JMenuItem menu_Configuracion;
    private javax.swing.JMenuItem menu_Empleado;
    private javax.swing.JMenuItem menu_HistorialVenta;
    private javax.swing.JMenuItem menu_Movil;
    private javax.swing.JMenuItem menu_Producto;
    private javax.swing.JMenuItem menu_Proveedor;
    private javax.swing.JMenuItem menu_Ventas;
    private javax.swing.JPanel pnl_Despachos;
    private javax.swing.JLayeredPane pnl_IngresoCliente;
    private javax.swing.JLayeredPane pnl_IngresoEmpleado;
    private javax.swing.JDesktopPane pnl_PanelMenu;
    private javax.swing.JLayeredPane pnl_Producto;
    private javax.swing.JLayeredPane pnl_Proveedor;
    private javax.swing.JLayeredPane pnl_Stock;
    private javax.swing.JPanel pnl_TipoPago;
    private javax.swing.JLayeredPane pnl_Ventas;
    private javax.swing.JRadioButton rb_Efectivo;
    private javax.swing.JRadioButton rb_Tarjeta;
    private javax.swing.JTable tb_ConsultaCliente;
    private javax.swing.JTable tb_ConsultaEmpleado;
    private javax.swing.JTable tb_ConsultaProducto;
    private javax.swing.JTable tb_ConsultaProveedor;
    private javax.swing.JTable tb_Venta;
    private javax.swing.JButton txtCancelarVenta;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCodigoProducto;
    private javax.swing.JTextField txtCodigoVenta;
    private javax.swing.JTextField txtDescuento;
    private javax.swing.JTextField txtRecibo;
    private javax.swing.JTextField txtTotalaPagar;
    private javax.swing.JTextField txtVendedor;
    private javax.swing.JTextField txtVuelto;
    private javax.swing.JTextField txt_BuscadorCliente;
    private javax.swing.JTextField txt_BuscadorEmpleado;
    private javax.swing.JTextField txt_BuscadorProducto;
    private javax.swing.JTextField txt_BuscadorProveedor;
    // End of variables declaration//GEN-END:variables

    private void revisaStock(){
        Configurar conf = new Configurar();         
        Validar v = new Validar();
        
        if (v.ventana()) {
            if (v.stockMinimo(txtCodigoProducto.getText()))
                JOptionPane.showMessageDialog(null, "Stock por debajo de "+conf.buscarConfiguracion().getStockMinimo()+" productos","Alerta!",JOptionPane.WARNING_MESSAGE);
            else{
                lbl_StockNormal.setVisible(true);
                lbl_StockMalo.setVisible(false);
            }
        }
        else{
            if (v.stockMinimo(txtCodigoProducto.getText())){
                lbl_StockMalo.setVisible(true);
                lbl_StockNormal.setVisible(false);
            }
            else{
                lbl_StockNormal.setVisible(true);
                lbl_StockMalo.setVisible(false);
            }
        }
    }
    
    private void hacerVenta() {
        Validar v = new Validar();
        if (tb_Venta.getRowCount()!=0) {
            if (!v.campoVacio(txtRecibo.getText())) {
                if (Float.valueOf(txtRecibo.getText())>= Float.valueOf(txtTotalaPagar.getText()) ) {
                    Venta venta = new Venta();
                    //2012-12-01 05:35:29
                    Calendar calendario = Calendar.getInstance();
                    int hora, minutos, segundos;
                    hora =calendario.get(Calendar.HOUR_OF_DAY);
                    minutos = calendario.get(Calendar.MINUTE);
                    segundos = calendario.get(Calendar.SECOND);

                    venta.setIdEmpleado(Integer.valueOf(empl.getIdEmpleado()));
                    venta.setFecha(año+"-"+mes+"-"+dia+" "+hora+":"+minutos+":"+segundos);
                    venta.setCantidadTotal(Integer.valueOf(lbl_Articulos.getText()));
                    venta.setVentaTotal(Float.valueOf(txtTotalaPagar.getText()) );

                    String tipopago;
                    float vuelto = 0, recibo;

                    if (rb_Efectivo.isSelected()) {
                        tipopago = "Efectivo";
                        vuelto = Float.valueOf(txtVuelto.getText()); 
                        recibo = Float.valueOf(txtRecibo.getText());
                    }
                    else{
                        tipopago = "Tarjeta";
                        recibo = Float.valueOf(txtTotalaPagar.getText());
                    }

                    venta.setTipoPago(tipopago);
                    venta.setVuelto(vuelto);
                    venta.setRecibo(recibo);

                    float descuento = 0;

                    if (!txtDescuento.getText().equals("")) 
                        descuento = Float.valueOf(txtDescuento.getText());

                    venta.setDescuento(descuento);
                    venta.setEstado("Vigente");

                    if (venta.insertarVenta()){
                        hacerDetalle();

                        txtCodigoVenta.setText(String.valueOf("000"+(venta.buscarID().getId() + 1)));
                        quitarTodasLasVentas();

                        if (tipopago.equals("Efectivo")) {
                            Boleta_Electronica be = new Boleta_Electronica(this, true, venta);
                            be.setVisible(true);
                        }
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "El monto ingresado no supera la cantidad de pago.","Alerta!",JOptionPane.WARNING_MESSAGE);
                    txtRecibo.setText("");
                    txtRecibo.requestFocus();
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "No ingresaste te la cantidad del recibo.","Alerta!",JOptionPane.WARNING_MESSAGE);
                txtRecibo.requestFocus();
            }
        }
        else
            JOptionPane.showMessageDialog(null, "No haz ingresado ningún producto.","Alerta!",JOptionPane.WARNING_MESSAGE);   
    }

    private void hacerDetalle() {
        DetalleVenta dventa = new DetalleVenta();
        Venta ven = new Venta();
        
        for (int i = 0; i < modelo0.getRowCount(); i++) {
            dventa.setIdVenta(ven.buscarID().getId());
            dventa.setIdProducto(modelo0.getValueAt(i, 0).toString());
            dventa.setCantidad(Integer.valueOf(modelo0.getValueAt(i, 2).toString()));
            dventa.setSubTotal(Float.valueOf(modelo0.getValueAt(i, 4).toString()));
            
            dventa.insertarDetalle();
        }
    }

    private void abrirPedido() {
        JDespachos jdes = new  JDespachos(this, true);
        jdes.setVisible(true);
    }

    private void abrirCompras() {
        JComprar jcom = new JComprar(this, true);
        jcom.setVisible(true);
    }
    /***************Operacion para mostrar la hora****************/
    String hora,minutos,segundos,ampm;
    Calendar calendario;    
    Thread h1;
    static boolean aux = true;
    static int almacena = 0;
    
    @Override
    public void run() {
        Thread ct = Thread.currentThread();
        
        while(ct == h1) {   
            calculaHora();

            if (aux) {
                almacena = Integer.valueOf(minutos);
                aux = false;
            }

            if ( (almacena + 1) == Integer.valueOf(minutos)) {
                calculaPedido(true);
            }
            
            lbl_Hora.setText(hora + ":" + minutos + ":" + segundos + " "+ampm);
//            try {
//                Thread.sleep(1000);
//            }
//            catch(InterruptedException e) {}
        }
    }
    
    public void calculaHora () {        
        Calendar calendario = new GregorianCalendar();
        Date fechaHoraActual = new Date();

        calendario.setTime(fechaHoraActual);
        ampm = calendario.get(Calendar.AM_PM) == Calendar.AM?"AM":"PM";

        if(ampm.equals("PM")){
            int h = calendario.get(Calendar.HOUR_OF_DAY)-12;
            hora = h>9? ""+h : "0"+h;
        }else
            hora = calendario.get(Calendar.HOUR_OF_DAY)>9?""+calendario.get(Calendar.HOUR_OF_DAY):"0"+calendario.get(Calendar.HOUR_OF_DAY);            
        
        minutos = calendario.get(Calendar.MINUTE)>9?""+calendario.get(Calendar.MINUTE):"0"+calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND)>9?""+calendario.get(Calendar.SECOND):"0"+calendario.get(Calendar.SECOND); 
    }

    private void calculaPedido(boolean visible) {
        lbl_CirculoNot.setVisible(visible);
        lbl_NumeroNot.setVisible(visible);
        
        lbl_NuevoPedido.setVisible(visible);
        lbl_NumeroCantidad.setVisible(visible);
        lbl_Nuevo.setVisible(visible);
    }
}