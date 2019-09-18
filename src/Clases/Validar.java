package Clases;

import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 * @author keiss
 */
public class Validar {
    
    public String quitaDG(String rut){
        String RUT = "";
        
        for (int i = 0; i < rut.length()-2; i++) 
            RUT = RUT + rut.charAt(i) ;
        
        long Rut;
        
        try{
            Rut = Long.valueOf(RUT);
        }
        catch(Exception e){
            return null;
        }
        
        String dv = rut.charAt(9) + "" +rut.charAt(10);
        JOptionPane.showMessageDialog(null, "RUT: "+(numerosConPuntos(Rut)+ dv),"",JOptionPane.INFORMATION_MESSAGE);   
        return numerosConPuntos(Rut) + dv;
    }
    
    public String validarRut (String rut){
        String RUT="";
        
        //Obtener el DV
        char dv = rut.charAt(rut.length()-1);
        //Obtener rut antes del guión
        int i = 0;
        while (rut.charAt(i) != '-') {
            RUT = RUT+rut.charAt(i);//Coonstruye el rut
            i++;
        }
        
        rut = RUT;
        int DV=0;
        
        String digi = ""+dv;

        try{
            DV =Integer.parseInt(digi);
        }
        catch (Exception ex){
            if (dv == 'k' || dv == 'K')
                DV = 10;
        }

        int cont;
        int contar = 2;
        int acumulador = 0;
        int divisor;
        int dig;
        
        int Rut;
        try{
            Rut = Integer.parseInt(rut);
        }
        catch(Exception e){
            return null;
        }
        
        do{
            cont = ((Rut % 10) * contar);
            acumulador = acumulador + cont;
            Rut = (Rut / 10);
            contar++;
            if (contar == 8)
                contar = 2;
        } while (Rut != 0);

        divisor = acumulador % 11;

        if (divisor == 0)
            divisor = 11;

        dig = 11 - divisor;

        if (dig == DV)
            return RUT+"-"+dig;
        else
            return null;
    }
    
    public String numerosConPuntos (long numero){
        String palabreDeNumero = String.valueOf(numero);

        if (palabreDeNumero.length()>3) {          
            char letra;
            int suma=0,pts=0;
            String totalreal="";

            for (int i = palabreDeNumero.length()-1; i >=0; i--) {
                //Recorre cada latra
                letra = palabreDeNumero.charAt(i);
                //Crea la nueva palabra
                totalreal = letra+totalreal;
                //Contador de puntos
                suma++;
                //Compara los largos para no imprimir el punto al principio
                if (totalreal.length()-pts!=palabreDeNumero.length()) {
                    //Concatena el punto
                    if (suma==3) {
                          totalreal = "."+totalreal;
                          suma=0; //Reinicia la suma
                          pts++; //Suma los puntos
                    }   
                }     
            }
            
            return totalreal;
        }
        else
            return palabreDeNumero;
    }
    
    public boolean ventana (){
        Configurar conf = new Configurar();         
        
        return conf.buscarConfiguracion().getVentana() == 1;
    }
    /**********Consulta por el stock minimo y revisa si hay suficien
     * @param codigo
     * @return t*********/
    public boolean stockMinimo(String codigo){
        Configurar conf = new Configurar();
        Producto prod = new Producto();

        return prod.buscarProducto(codigo).getStock() < conf.buscarConfiguracion().getStockMinimo();
    }
    
    public boolean stockMaximo(String codigo, int stock){
        Configurar conf = new Configurar();
        Producto prod = new Producto();

        return (stock + prod.buscarProducto(codigo).getStock()) < conf.buscarConfiguracion().getStockMaximo();
    }
    
    public boolean permitirEmpleado(){
        Configurar conf = new Configurar();
        
        return conf.buscarConfiguracion().getPermisoEmpleado() == 1;
    }
    /*********Obtiene el stock minimo de configuracio
     * @return n***********/
    public int cargaStockMinimo(){
        Configurar conf = new Configurar();
        
        return conf.buscarConfiguracion().getStockMinimo();
    }
    /*********Obtiene el stock maximo de configuracio
     * @return n***********/
    public int cargaStockMaximo(){
        Configurar conf = new Configurar();
        
        return conf.buscarConfiguracion().getStockMaximo();
    }
    
    public boolean iniciarSecion(){
        Configurar conf = new Configurar();
         
        return conf.buscarConfiguracion().getIniciarSesion() == 1;
    }
    
    public String empleado(){
        Configurar conf = new Configurar();
        
        return conf.buscarConfiguracion().getIdEmpleado();
    }
    
    public String contra(){
        Configurar conf = new Configurar();
        
       return conf.buscarConfiguracion().getContraseña();
    }
    
    public String cargarCMBProducto(String seleccion){
        String tabla = "";

        switch (seleccion) {
            case "Código":
                tabla = "Id_Producto";
            break;
            
            case "Nombre":
                tabla = "Nombre_Producto";
            break;
            
            case "Stock":
                tabla = "Stock_Producto";
            break;
            
            case "Precio":
                tabla = "Precio_Prod";
            break;
            case "Categoría":
                tabla = "Id_Cat_Prod";
            break;
            
            case "Proveedor":
                tabla = "Id_Proveedor";
            break;
            
            case "Activo":
                tabla = "Activo_Producto";
            break;
        }
    
        return tabla;
    }
    
    public String cargarCMBEmpleado (String comboEmpleado){
        String columna = "";

        switch (comboEmpleado) {
            case "Id":
                columna = "Id_Empleado";
            break;
            case "Nombre":
                columna = "Nombre_Empleado";
            break;
            case "Apellido Paterno":
                columna = "ApellidoP_Empleado";
            break;
            case "Apellido Materno":
                columna = "ApellidoM_Empleado";
            break;
            case "Rut":
                columna = "Rut_Empleado";
            break;
            case "Tipo":
                columna = "Tipo_Empleado";
            break;
        }
        
        return columna;
    }
    
    public String cargarCMBProveedor(String comboProveedor){
        String columna = "";

        switch (comboProveedor) {
            case "Id":
                columna = "Id_Proveedor";
            break;
            case "Nombre":
                columna = "Nombre_Preveedor";
            break;
            case "Rut":
                columna = "Rut_Proveedor";
            break;
            case "Teléfono":
                columna = "Teléfono_Prov";
            break;
            case "Dirección":
                columna = "Direccion_Prov";
            break;
            case "Activo":
                columna = "Activo_Proveedor";
            break;
        }
        
        return columna;
    }
    
    public String cargarCMBCliente(String comboCliente){
        String columna = "";

        switch (comboCliente) {
            case "Rut":
                columna = "Rut_Cliente";
            break;
            case "Nombre":
                columna = "Nombre_Cliente";
            break;
            case "Apellido Paterno":
                columna = "ApeP_Cliente";
            break;
            case "Apellido Materno":
                columna = "ApeM_Cliente";
            break;
            case "Dirección":
                columna = "Direccion_Cliente";
            break;
            case "Correo":
                columna = "Correo_Cliente";
            break;
            case "Teléfono":
                columna = "Teléfono_Cliente";
            break;
        }
        
        return columna;
    }
    
    public String cargarCMBDespacho(String comboDespacho){
        switch (comboDespacho) {
            case "Id":
                return "Id_Despacho";
            case "Pedido":
                return "Id_Pedido";
            case "Conductor":
                return "Id_Conductor";
            default:
                return "";
        }
    }

    public String obtenerTablaCat (String texto){
        try{
            Integer.valueOf(texto);
            return "Id_Cat_Prod";
        }
        catch(Exception e){
            return "Nom_Cat_Prod";
        }
    }
    
    public String obtenerColVenta(String combo){
        String columna = "";
        
        switch (combo) {
            case "Nro Venta":
                columna = "Venta.Id_Venta";
            break;
            case "Código":
                columna = "DetalleVenta.Id_Producto";
            break;
            case "Total":
                columna = "Total_Venta";
            break;
            case "Cantidad":
                columna = "Cantidad_DetalleVenta";
            break;
            case "Fecha":
                columna = "Venta.Fecha_Venta";
            break;
            case "Tipo de Pago":
                columna = "Venta.TipoPago_Venta";
            break;
            case "Estado":
                columna = "Venta.Estado_Venta";
            break;
            case "Sub Total":
                columna = "DetalleVenta.SubTotal_Detalle";
            break;
            case "Empleado":
                columna = "Venta.Id_Empleado";
            break;
            case "Recibo":
                columna = "Venta.Recibo";
            break;
            case "Vuelto":
                columna = "Venta.Vuelto_Venta";
            break;
            case "Descuento":
                columna = "Venta.Descuento";
            break;
        }
        
        return columna;
    }
    
    public String obtenerColPedido(String combo){     
        switch (combo) {
            case "Código":
                return "Id_Pedido";
            case "Rut":
                return "Rut_Cliente";
            case "Productos":
                return "Cantidad_Total";
            case "Fecha entrega":
                return "Fecha_Entrega";
            case "Estado":
                return "Estado";
            default:
                return "";
        }
    }
    
    public String validaOrden(boolean chekedOrden){
        if (chekedOrden) 
            return "order by DetalleVenta.Id_Venta desc";
        else
            return "";
    }
    /**Metodo para regresar una consul
     * @param dia
     * @param mes
     * @param año
     * @param fecha
     * @return */
    public String buscaFecha(boolean dia, boolean mes, boolean año, String fecha){
        String Dia = String.valueOf(fecha.charAt(0) +""+ fecha.charAt(1));
        String Mes = fecha.charAt(3) +""+ fecha.charAt(4) +"";
        String Año = fecha.charAt(6) +""+ fecha.charAt(7) + fecha.charAt(8) + fecha.charAt(9) +"";       
        
        if (dia && !mes && !año)//Solo el dia
            return "DAY(Venta.Fecha_Venta) = " + Dia;
        else if (!dia && mes && !año)//Solo el mes
            return "MONTH(Venta.Fecha_Venta) = " + Mes;
        else if (!dia && !mes && año) //Solo el año
            return "YEAR(Venta.Fecha_Venta) = " + Año;
        else if (dia && mes && !año) //Dia y mes
            return "DAY(Venta.Fecha_Venta) = " + Dia + " and MONTH(Venta.Fecha_Venta) = " + Mes;
        else if (!dia && mes && año) //Mes y año
            return "MONTH(Venta.Fecha_Venta) = " + Mes + " and YEAR(Venta.Fecha_Venta) = " + Año;
        else if (dia && !mes && año) //Dia y año
            return "DAY(Venta.Fecha_Venta) = " + Dia + " and YEAR(Venta.Fecha_Venta) = " + Año;
        else if (dia && mes && año) //Dia, Mes y año
            return "DAY(Venta.Fecha_Venta) = " + Dia + " and MONTH(Venta.Fecha_Venta) = " + Mes + " and YEAR(Venta.Fecha_Venta) = " + Año;
        else //Nada
            return "";
    }
    /*********************Revisa si el producto esta activ
     * @param codigo
     * @return ***********************/
    public boolean activoProducto(String codigo){
        Producto prod = new Producto();
        return prod.buscarProducto(codigo).getActivo() == 1;
    }
    /*Revisa si el empleado no esta inhabilitado*/
    public boolean empleadoHabilitado(String codigo, String contraseña){
        Empleado emp = new Empleado();
        return emp.buscarEmpleado(codigo, contraseña).getTipo().equals("Inhabilitado");
    }
    
    public boolean maximoLargo(String cadena, int max){
        return cadena.length() < max;
    }
    
    public boolean campoVacio(String cadena){
        return cadena.isEmpty();
    }
    
    public boolean soloNumeros (String rut){
        return rut.matches("[0-9]*");
    }

    public int calculo(boolean busqueda, int calculo, String fecha, String col, String dato){
        Venta v = new Venta();
        int cal = 0;
        switch (calculo) {
            case 1:
                cal = v.calculoVenta(busqueda,"SUM", "Total_Venta", fecha, dato, col).getId();
            break;
            case 2:
                cal = v.calculoVenta(busqueda,"MAX", "Total_Venta", fecha, dato, col).getId();
            break;
            case 3:
                cal = v.calculoVenta(busqueda,"MIN", "Total_Venta", fecha, dato, col).getId();
            break;
            case 4:
                cal = v.calculoVenta(busqueda,"AVG", "Total_Venta", fecha, dato, col).getId();
            break;
            case 5:
                cal = v.calculoVenta(busqueda,"SUM", "Vuelto_Venta", fecha, dato, col).getId();
            break;
            case 6:
                cal = v.calculoVenta(busqueda,"SUM", "Descuento", fecha, dato, col).getId();
            break;
            case 7:
                cal = v.calculoVenta(busqueda,"COUNT", "Total_Venta", fecha, dato, col).getId();
            break; 
            case 8:
                cal = v.calculoVenta(busqueda,"SUM", "CantidadTotal_Venta", fecha, dato, col).getId();
            break; 
        }
        
        return cal;
    }
    
    public String fechaActual(){
        Calendar cal = Calendar.getInstance();
        String dia = cal.get(Calendar.DATE) + "";
        String mes = (cal.get(Calendar.MONTH) + 1 ) + ""; 
        String año = cal.get(Calendar.YEAR) + "";
        return (dia+"/"+mes+"/"+año);
    }
    
    public String mesActual(){
        Calendar cal = Calendar.getInstance();
        return (cal.get(Calendar.MONTH) + 1 ) + "";
    }
    
    public int prodNulo (String fecha, String tabla, String dato){
        Venta venta = new Venta();
        return venta.prodNulo(fecha, tabla, dato).getId();
    }
    
    /********************************Dimensiónes****************************************************************************
     * @param codigo
     * @param columna
     * @return la logistica de la moto*******************************/
    //Obtener dimension del producto
    public double obtenerDimProd (String codigo, String columna){
        Dimension dim = new Dimension();
    
        switch (columna) {
            case "Alto":
                return dim.buscarDimension(codigo, true, 0).getAlto();
            case "Ancho":
                return dim.buscarDimension(codigo, true, 0).getAncho();
            case "Largo":
                return dim.buscarDimension(codigo, true, 0).getLargo();
            case "Peso":
                return dim.buscarDimension(codigo, true, 0).getPeso();
            default:
                return 0;
        } 
    }
    
    public double obtenerAltoMovil(int idDimension){
        Dimension dim = new Dimension();
        return dim.buscarDimension("", false, idDimension).getAlto();
    }
    
    public double obtenerAnchoMovil(int idDimension){
        Dimension dim = new Dimension();
        return dim.buscarDimension("", false, idDimension).getAncho();
    }
    
    public double obtenerLargoMovil(int idDimension){
        Dimension dim = new Dimension();
        return dim.buscarDimension("", false, idDimension).getLargo();
    }
    
    public double obtenerPesoMovil(int idDimension){
        Dimension dim = new Dimension();
        return dim.buscarDimension("", false, idDimension).getPeso();
    }

    public double formulaDimension(String calculo, String columna, int id){
        Dimension dim = new Dimension();
        return dim.calculaDimension(calculo, columna, id).getNumero();
    }
    
    public boolean validaIngresoDim(String texto){
        return Integer.valueOf(texto) > 0;
    }
}