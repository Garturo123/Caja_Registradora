package CajaRegistradora;
import java.util.Scanner;
/**
 * @author gaat1
 */
public class Caja {
    public static void main(String[] args) 
    {
        Scanner scanner =  new Scanner(System.in).useDelimiter("\n");
        String productoEstrella = "";
        boolean abierto = true, salir = false;
        int AzucarCompra = 25,                    AzucarVenta = 30;  
        int AvenaCompraB = 20, AvenaCompraC = 22, AvenaVenta = 25;
        int TrigoCompra = 30,                     TrigoVenta = 32;
        int MaizCompra = 18,                      MaizVenta = 20;
        
        int comprasDia = 0 , ventasDia =0;
        double CantAzucarVend = 0, CantTrigoVend = 0, CantMaizVend = 0, CantAvenaVend = 0;
        double CantAzucar = 0, CantAvena = 0, CantTrigo = 0, CantMaiz = 0;
        double mayorVenta = 0, mayorCompra = 0;
        double dinero = 0, ganancias = 0, ingreso, ingresoVentas = 0, gastos = 0, deposito;
        double inventario = CantAzucar + CantAvena + CantTrigo + CantMaiz;
        while (!salir) 
        {
            System.out.println("\n----------------------");
            System.out.println("     -*- MENU -*-");
            System.out.println("\n1.   Abrir Caja");
            System.out.println("2.   Comprar Productos");
            System.out.println("3.   Vender Productos");                
            System.out.println("4.   Reporte");
            System.out.println("5.   Cerrar");
            System.out.println("6.   Salir");
            System.out.print("\nIngrese una opcion: ");
            byte input = scanner.nextByte();
            switch (input){
                case 1://Abrir Caja
                    if (abierto){
                        System.out.print("\nCuanto dinero desea agregar a caja? : HNL.");
                        dinero +=  scanner.nextDouble();
                        System.out.println("Total en caja: HNL." + dinero);
                    }else{
                        System.out.print("\nAcaba de empezar un nuevo dia.");
                        abierto = true;
                    }
                    break;
                case 2://Comprar Productos
                    if (!abierto) { System.out.println("\nNecesita abrir caja antes.");
                        break;
                     }
                    if (dinero < 18) { System.out.println("\nNecesita agregar dinero a caja.");
                        break;
                     }
                    System.out.print("\nSeleccione el tipo de proveedor (A, B, C): ");
                    String proveedor = scanner.next().toUpperCase();
                    if (!proveedor.equals("A") && !proveedor.equals("B") && !proveedor.equals("C")){
                        System.out.println("\nNo existe este tipo de provedor.");
                        break;
                     }
                        System.out.println("Azucar   Precio: " + AzucarCompra);
                        System.out.println("Avena    Precio B: " + AvenaCompraB + " | C: " + AvenaCompraC);
                        System.out.println("Trigo    Precio: " + TrigoCompra);
                        System.out.println("Maiz     Precio: " + MaizCompra);

                        System.out.print("\nQue producto desea comprar?: ");
                        String producto = scanner.next().toLowerCase();

                        double cantidad;
                        double costo = 0;
                        boolean compraValida = true;
                        // Dandole un valor a la variable costo
                        if (producto.equals("maiz") && proveedor.equals("A")) costo = MaizCompra; 
                        else if (producto.equals("azucar") && proveedor.equals("A"))  costo = AzucarCompra;
                        else if (producto.equals("trigo") && proveedor.equals("B")) costo = TrigoCompra;
                        else if (producto.equals("avena") && proveedor.equals("B")) costo = AvenaCompraB;
                        else if (producto.equals("avena") && proveedor.equals("C")) costo = AvenaCompraC;
                        else {
                            compraValida = false;
                            System.out.println("\nEl proveedor no puede entregar ese producto.");
                        }
                         if (compraValida) {
                            System.out.print("\nCuantos kilogramos desea?: ");
                            cantidad = scanner.nextDouble();
                            double total = cantidad * costo;

                            if (total > dinero) {
                                System.out.println("\nFondos insuficientes. Agregue mas dinero o reduzca la cantidad.");
                            } else {
                                dinero -= total;
                                ganancias -= total;
                                gastos += total;
                                comprasDia++;

                                if (total > mayorCompra) {
                                    mayorCompra = total;
                                }
                                switch (producto){
                                    case "maiz": CantMaiz += cantidad;
                                        break;
                                    case "azucar": CantAzucar += cantidad;
                                        break;
                                    case "trigo": CantTrigo += cantidad;
                                        break;
                                    case "avena": CantAvena += cantidad;
                                        break;
                                }
                                inventario = CantAzucar + CantAvena + CantTrigo + CantMaiz;
                             }
                         }
                    break;
                case 3://Vender Productos
                    if (!abierto) { System.out.println("\nNecesita abrir caja antes.");
                        break;
                    }
                    if (inventario <= 0) { System.out.println("\nNecesita comprar productos.");
                        break;
                    }
                    System.out.print("\nSeleccione el tipo de cliente: A, B, C : ");
                    String Cliente = scanner.next().toUpperCase();
                    if (!Cliente.equals("A") && !Cliente.equals("B") && !Cliente.equals("C")) {
                        System.out.println("\nNo existe este cliente.");
                        break;
                    }
                    String selecion = "";
                    int subTotal = 0;
                    String Factura = "\n         **** Factura ****";
                    while(!selecion.equals("salir")){
                        double cantidadProducto =0;
                        double precio = 0;
                        boolean VentaValida = true;
                        System.out.println("\nAzucar   Precio: " + AzucarVenta);
                        System.out.println("Avena    Precio: " + AvenaVenta);
                        System.out.println("Trigo    Precio: " + TrigoVenta);
                        System.out.println("Maiz     Precio: " + MaizVenta);
                        System.out.println("Para salir escriba (salir)");
                        System.out.print("Que producto desea? : ");

                        selecion = scanner.next().toLowerCase();
                        // Dandole un valor a la variable precio
                        if (selecion.equals("maiz") && (Cliente.equals("C") || Cliente.equals("A")))precio = MaizVenta;
                        else if (selecion.equals("trigo") && (Cliente.equals("B") || Cliente.equals("A"))) precio = TrigoVenta;
                        else if (selecion.equals("avena") && (Cliente.equals("B") || Cliente.equals("A"))) precio = AvenaVenta;
                        else if (selecion.equals("azucar") && (Cliente.equals("B") || Cliente.equals("A"))) precio = AzucarVenta;
                        else{
                            System.out.println("\nEl cliente no puede comprar este producto.");
                            VentaValida = false;
                             }
                        if (VentaValida){
                            switch (selecion){
                                case "maiz": cantidadProducto = CantMaiz;
                                    break;
                                case "azucar": cantidadProducto = CantAzucar;
                                    break;
                                case "trigo": cantidadProducto = CantTrigo;
                                    break;
                                case "avena": cantidadProducto = CantAvena;
                                    break;
                            }
                            if (0<cantidadProducto){
                                System.out.print("\nCuantos kilogramos desea? : ");
                                cantidad = scanner.nextDouble();
                                if (cantidadProducto>cantidad){
                                    ingreso = precio * cantidad;
                                    switch (selecion){
                                        case "maiz":
                                            CantMaiz -= cantidad;
                                            CantMaizVend += cantidad;
                                            break;
                                        case "azucar":
                                            CantAzucar -= cantidad;
                                            CantAzucarVend += cantidad;
                                            break;
                                        case "trigo":
                                            CantTrigo -= cantidad;
                                            CantTrigoVend += cantidad;
                                            break;
                                        case "avena":
                                            CantAvena -= cantidad;
                                            CantAvenaVend += cantidad;
                                            break;
                                    }
                                if (ingreso > 0){
                                    Factura += "\n"+selecion + " Precio: "+ precio + " Cantidad: "+cantidad + " Total: "+ingreso;
                                    if (mayorVenta < ingreso){
                                        mayorVenta = ingreso;
                                    }
                                    ganancias += ingreso;       subTotal += ingreso;     ingresoVentas += ingreso;    
                                }else{
                                System.out.print("\nNo hubo compra.");  
                                }
                            }else{
                                System.out.print("\nLa tienda solo cuenta con: "+ cantidadProducto + "kg.");  
                                }
                            }else{
                                System.out.print("\nSe agotaron sus existencias en tienda.");  
                                }
                        }
                    }
                    ventasDia++;
                    Double descuento = (subTotal >= 5000) ? 0.1 : (subTotal >= 1000) ? 0.05 : 0;
                    Double descontado = subTotal * descuento;
                    Double impuesto = subTotal * 0.07;
                    Double Total = subTotal+impuesto-descontado;
                    dinero += Total-impuesto; 

                    System.out.println(Factura);
                    System.out.println("SubTotal: "+ subTotal);
                    System.out.println("Descuento: "+ descuento*100 + "% Descontado: " + String.format("%.2f", descontado));
                    System.out.println("Impuesto del 7%: "+ String.format("%.2f",impuesto));
                    System.out.println("Total: "+ String.format("%.2f",Total));
                    break;
                case 4://Reporte
                    double PromCompra = (comprasDia > 0) ? gastos/comprasDia : 0;
                    double PromVenta = (ventasDia > 0) ? ingresoVentas/ventasDia : 0;
                    double maxVendido = Math.max(Math.max(CantAzucarVend, CantAvenaVend), Math.max(CantTrigoVend, CantMaizVend));

                    if (maxVendido == CantAzucarVend) productoEstrella = "azucar";
                    else if (maxVendido == CantAvenaVend) productoEstrella = "avena";
                    else if (maxVendido == CantTrigoVend) productoEstrella = "trigo";
                    else if (maxVendido == CantMaizVend) productoEstrella = "maiz";

                    System.out.println("\nTotal de efectivo en caja: HNL."+ dinero);
                    System.out.println("Total de ventas realizadas: "+ ingresoVentas + " | Total de compras realizadas: "+ gastos);
                    System.out.println("Ventas realizadas hoy: "+ ventasDia + " | Compras realizadas hoy: "+ comprasDia + " | Ganancias: " + ganancias);
                    System.out.println("Valor medio de: ventas: "+ PromVenta + " | Compras: "+ PromCompra);
                    System.out.println("Mayor venta: "+ mayorVenta + " | Mayor Compra: "+ mayorCompra);
                    System.out.println("Producto estrella: "+ productoEstrella);
                    break;
                case 5://Cierre
                    System.out.println("\nTotal de efectivo en caja: HNL." + dinero);
 /*Reinicio */      ventasDia = 0; comprasDia = 0; productoEstrella = ""; ingresoVentas =0;ganancias = 0; gastos = 0; mayorVenta=0; mayorCompra = 0;
                    System.out.print("Solo puede depositar el 60% del dinero al banco. Desea depositar? : ");
                    deposito = scanner.nextDouble();
                    abierto = false;
                    if ((dinero*0.6)>=deposito){
                        System.out.print("Ingresastes a tu cuenta de banco: HNL."+deposito);
                    }
                    break;
                case 6:
                    salir = true;
                    System.out.println("\nApagando sistema...");
                    break;
                default:
                    System.out.println("\nNo existe esta opcion");
            }   
        }
    }
}
    