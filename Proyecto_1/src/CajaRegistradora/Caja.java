package CajaRegistradora;
import java.util.Scanner;
/**
 * @author gaat1
 */
public class Caja {
    public static void main(String[] args) 
    {
        int  AzucarCompra, AvenaCompraB,AvenaCompraC, TrigoCompra, MaizCompra, AzucarVenta, AvenaVenta, TrigoVenta, MaizVenta;
        double CantAzucar = 0, CantAvena = 50, CantTrigo = 0, CantMaiz = 0, CantTrigoVend = 0, CantMaizVend = 0, CantAvenaVend = 0 , mayorProducto = 0, banco = 0;
        int comprasDia = 0 , compras = 0, ventasDia =0 , ventas = 0, CantAzucarVend = 0;
        Scanner scanner =  new Scanner(System.in).useDelimiter("\n");
        String input = "" , productoEstrella = "";
        double dinero = 0, ganancias = 0, gasto = 0, ingreso = 0, ingresoVentas = 0, gastos = 0, mayorVenta = 0, mayorCompra = 0, deposito;
        boolean abierto = true;
        
        AzucarCompra = 25;                    AzucarVenta = 30;  
        AvenaCompraB = 20; AvenaCompraC = 22; AvenaVenta = 25;
        TrigoCompra = 30;                     TrigoVenta = 30;
        MaizCompra = 18;                      MaizVenta = 20;
        
        while (!input.equals("salir")) 
        {
            System.out.println("\nDesea comprar productos de los provedores? (escriba: comprar) ");
            System.out.println("Quiere abrir caja? (escriba: abrir)");
            System.out.println("Desea vender productos? (escriba: vender)");                
            System.out.println("Desea ver el reporte de ventas? (escriba: reporte)");
            System.out.println("Desea cerrar caja? (escriba: cerrar)");
            System.out.print("Quiere salir del sistema? (escriba: salir)\n: ");
            input = scanner.next().toLowerCase();
            switch (input){
                case "comprar":
                    if (abierto){
                    double cant;
                    if (dinero > 0){
                        System.out.print("Selecione el tipo de cliente: A, B, C : ");
                        String Provedor = scanner.next().toUpperCase();
                        System.out.println("Azucar   Precio: " + AzucarCompra);
                        System.out.println("Avena    Precio: " + AvenaCompraB);
                        System.out.println("Avena    Precio: " + AvenaCompraC);
                        System.out.println("Trigo    Precio: " + TrigoCompra);
                        System.out.println("Maiz     Precio: " + MaizCompra);
                        String opciones = scanner.next().toLowerCase();
                        if (Provedor.equals("A") && opciones.equals("maiz"))
                        {
                            System.out.print("Cuantos kilogramos de maiz desea?: ");
                            cant = scanner.nextDouble();
                            if ((cant * MaizCompra) > dinero){
                                System.out.print("Agregue mas dinero a caja o redusca la compra.");
                            }else
                            {
                            gasto = cant * MaizCompra;
                            CantMaiz += cant;
                            }
                        }
                        else if (Provedor.equals("A") && opciones.equals("azucar")){
                            System.out.print("Cuantos kilogramos de azucar desea?: ");
                            cant = scanner.nextDouble();
                            if ((cant * AzucarCompra) > dinero){
                                System.out.print("Agregue mas dinero a caja o redusca la compra.");
                            }else{
                            gasto = cant * AzucarCompra;   
                            CantAzucar += cant;
                            }
                        }
                        else if (Provedor.equals("B") && opciones.equals("trigo")){
                            System.out.print("Cuantos kilogramos de trigo desea?: ");
                            cant = scanner.nextDouble();
                            if ((cant * TrigoCompra) > dinero){
                                System.out.print("Agregue mas dinero a caja o redusca la compra.");
                            }else{
                            gasto = cant * TrigoCompra;  
                            CantTrigo += cant;
                            }
                        }
                        else if (Provedor.equals("B") && opciones.equals("avena")){
                            System.out.print("Cuantos kilogramos de avena desea?: ");
                            cant = scanner.nextDouble();
                            if ((cant * AvenaCompraB) > dinero){
                                System.out.print("Agregue mas dinero a caja o redusca la compra.");
                            }else{
                            gasto = cant * AvenaCompraB;  
                            CantAvena += cant;
                            }
                        }
                        else if (Provedor.equals("C") && opciones.equals("avena")){
                            System.out.print("Cuantos kilogramos de avena desea?: ");
                            cant = scanner.nextDouble();
                            if ((cant * AvenaCompraC) > dinero){
                                System.out.print("Agregue mas dinero a caja o redusca la compra.");
                            }else{
                            gasto -= cant * AvenaCompraC;
                            CantAvena += cant;
                            }
                        }
                        else{
                            System.out.print("El provedor no puede entregar este producto.");
                        }
                        dinero -= gasto;     ganancias -= gasto;     gastos += gasto;
                        comprasDia += 1;
                        do {
                            mayorCompra = gasto;
                        }
                        while (mayorCompra > gasto );
                    }else{
                        System.out.println("Agregue dinero a caja para poder comprar");
                    }
                    }else{
                        System.out.println("Nesesita abrir caja antes.");
                    }
                    break;
                case "abrir":
                    if (abierto){
                        System.out.print("Cuanto dinero desea agregar a caja? : HNL.");
                        dinero +=  scanner.nextDouble();
                        System.out.println("Total en caja: HNL." + dinero);
                    }else{
                        System.out.print("Acaba de empezar un nuevo dia.");
                        abierto = true;
                    }
                    break;
                case "vender":
                    if (abierto){
                        System.out.print("Selecione el tipo de cliente: A, B, C : ");
                        String Cliente = scanner.next().toUpperCase();
                        String selecion = "";
                        int subTotal = 0;
                        double descuento = 0;
                        String Factura = "\n         **** Factura ****\n";
                        while(!selecion.equals("salir")){
                            double cantidad;
                            System.out.println("Azucar   Precio: " + AzucarVenta);
                            System.out.println("Avena    Precio: " + AvenaVenta);
                            System.out.println("Trigo    Precio: " + TrigoVenta);
                            System.out.println("Maiz     Precio: " + MaizVenta);
                            System.out.println("Para salir escriba (salir)");
                            System.out.print("Que producto desea? : ");

                            selecion = scanner.next().toLowerCase();
                            if (selecion.equals("maiz") && (Cliente.equals("C") || Cliente.equals("A"))){
                                System.out.print("Cuantos kilos de maiz desea? : ");
                                cantidad = scanner.nextInt();
                                if (cantidad <= CantMaiz){
                                    CantMaiz -= cantidad;
                                    CantMaizVend += cantidad;
                                    Factura += "Maiz Cantidad: "+ cantidad + " Precio Und: " + MaizVenta +"\n";
                                    ingreso = (cantidad * MaizVenta);
                                    if (CantMaizVend > mayorProducto){
                                        productoEstrella = "Maiz";
                                        mayorProducto = CantMaizVend;
                                    }
                                }else {
                                    System.out.print("Solo contamos con: "+ CantMaiz +" kilos de maiz.");
                                }
                            }
                            else if (selecion.equals("trigo") && (Cliente.equals("B") || Cliente.equals("A"))) {
                                System.out.print("Cuanto kilos de trigo desea? : ");
                                cantidad = scanner.nextInt();
                                if (cantidad <= CantTrigo){
                                    CantTrigo -= cantidad;
                                    CantTrigoVend += cantidad;
                                    Factura += "Trigo Cantidad: "+ cantidad + " Precio Und: " + TrigoVenta +"\n";
                                    ingreso = (cantidad * TrigoVenta);
                                    if (CantTrigoVend > mayorProducto){
                                        productoEstrella = "Trigo";
                                        mayorProducto = CantTrigoVend;
                                    }
                                }else{
                                    System.out.print("Solo contamos con: "+ CantTrigo +" kilos de trigo.");
                                }
                            }
                            else if (selecion.equals("avena") && (Cliente.equals("B") || Cliente.equals("A"))) {
                                System.out.print("Cuanto kilos de avena desea? : ");
                                cantidad = scanner.nextInt();
                                if (cantidad <= CantAvena){
                                    CantAvena -= cantidad;
                                    CantAvenaVend += cantidad;
                                    Factura += "Avena Cantidad: "+ cantidad + " Precio Und: " + AvenaVenta +"\n";
                                    ingreso = (cantidad * AvenaVenta);
                                    if (CantAvenaVend > mayorProducto){
                                        productoEstrella = "Avena";
                                        mayorProducto = CantAvenaVend;
                                    }
                                }else {
                                    System.out.print("Solo contamos con: "+ CantAvena +" kilos de trigo.");
                                }
                            }
                            else if (selecion.equals("azucar") && (Cliente.equals("B") || Cliente.equals("A"))) {
                                System.out.print("Cuanto kilos de azucar desea? : ");
                                cantidad = scanner.nextInt();
                                if (cantidad <= CantAzucar){
                                    CantAzucar -= cantidad;
                                    CantAzucarVend += cantidad;
                                    Factura += "Azucar Cantidad: "+ cantidad + " Precio Und: " + AzucarVenta +"\n";
                                    ingreso = (cantidad * AzucarVenta);
                                    if (CantAzucarVend > mayorProducto){
                                        productoEstrella = "Azucar";
                                        mayorProducto = CantAzucarVend;
                                    }
                                }else{
                                    System.out.print("Solo contamos con: "+ CantAzucar +" kilos de azucar.");
                                }
                            }
                            else{
                                System.out.println("El cliente no puede comprar este producto.");
                            }
                            do {
                                mayorVenta = ingreso;
                            }
                            while (mayorVenta > ingreso );
                            ganancias += ingreso;   subTotal += ingreso;    ingresoVentas += ingreso;
                            ventasDia += 1;
                            System.out.println("\nSu subTotal seria : "+ subTotal );    
                        }   
                            if (subTotal >= 5000){
                                descuento = 0.1;
                            }else if(subTotal >= 1000){
                                descuento = 0.05;
                            }
                            Double descontado = subTotal * descuento;
                            Double impuesto = subTotal * 0.07;
                            Double Total = subTotal+impuesto-descontado;

                            System.out.println(Factura);
                            System.out.println("SubTotal: "+ subTotal);
                            System.out.println("Descuento: "+ descuento*100 + "% Descontado: " + String.format("%.2f", descontado));
                            System.out.println("Impuesto del 7%: "+ String.format("%.2f",impuesto));
                            System.out.println("Total: "+ String.format("%.2f",Total));
                            dinero += Total;
                    }else {
                        System.out.println("Nesesita abrir caja antes.");
                    }
                    break;
                case "reporte":
                    ventas += ventasDia; compras += comprasDia;
                    System.out.println("Total de efectivo en caja: HNL."+ dinero);
                    System.out.println("Total de ventas realizadas: "+ ventas + " Total de compras realizadas: "+ compras);
                    System.out.println("Ventas realizadas hoy: "+ ventasDia + " Compras realizadas hoy: "+ comprasDia + " Ganancias: " + ganancias);
                    System.out.println("Valor medio de: ventas: "+ ingresoVentas/ventasDia + " Compras: "+ gastos/comprasDia);
                    System.out.println("Mayor venta: "+ mayorVenta + " Mayor Compras: "+ mayorCompra);
                    System.out.println("Producto estrella: "+ productoEstrella);
                    break;
                case "cierre":
                    System.out.println("Total de efectivo en caja: HNL." + dinero);
                    ventasDia = 0; comprasDia = 0; productoEstrella = ""; 
                    System.out.print("Solo puede despositar el 60% del dinero al banco. Desea depositar? : ");
                    deposito = scanner.nextDouble();
                    abierto = false;
                    if ((dinero*0.6)>=deposito){
                        banco += deposito;
                    }
                    break;
                case "salir":
                    System.out.println("Apagando sistema...");
                    break;
            }
        }
    }  
}