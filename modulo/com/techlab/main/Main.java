package modulo.com.techlab.main;

import java.util.ArrayList;
import java.util.Scanner;

import modulo.com.techlab.clientes.Cliente;
import modulo.com.techlab.metodos.Compra;
import modulo.com.techlab.metodos.Gestion;
import modulo.com.techlab.productos.Bebida;
import modulo.com.techlab.productos.Comida;
import modulo.com.techlab.productos.Infusiones;
import modulo.com.techlab.productos.Producto;

public class Main {
    public static void main(String[] args) {
        ArrayList<Producto> productos = new ArrayList<>();
        ArrayList<Cliente> clientes = new ArrayList<>();

        productos.add(new Infusiones("Te negro", 1500, 10, "Te"));
        productos.add(new Infusiones("Cafe", 2500, 5, "Cafe"));
        productos.add(new Infusiones("Te verde", 1800, 20, "Te"));
        productos.add(new Bebida("Agua mineral", 2000, 15, "Bebida", 1.5));
        productos.add(new Comida("Galletas", 500, 30, "Comida", "Mayo 2026"));

        clientes.add(new Cliente("Juan", "Perez", "juan@perez.com"));
        clientes.add(new Cliente("Maria", "Gomez", "maria@gomez.com"));
        clientes.add(new Cliente("Pedro", "Lopez", "pedro@lopez.com"));

        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("Bienvenido a la gestion de productos.");
            System.out.println("Por favor, elija una opcion:\n");
            System.out.println("1. Agregar producto");
            System.out.println("2. Modificar producto");
            System.out.println("3. Eliminar producto");
            System.out.println("4. Listar productos");
            System.out.println("5. Buscar producto");
            System.out.println("6. Filtrar productos por categoria");
            System.out.println("7. Reponer stock de un producto");
            System.out.println("8. Realizar compra");
            System.out.println("0. Salir\n");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch(opcion) {
                case 1:
                    Gestion.agregarProducto(productos, scanner);
                    break;
                case 2:
                    Gestion.modificarProducto(productos, scanner);
                    break;
                case 3:
                    Gestion.eliminarProducto(productos, scanner);
                    break;
                case 4:
                    Gestion.listarProductos(productos);
                    break;
                case 5:
                    Gestion.buscarProducto(productos, scanner);
                    break;
                case 6:
                    Gestion.filtrarProductos(productos, scanner);
                    break;
                case 7:
                    Gestion.reponerStock(productos, scanner);
                    break;
                case 8:
                    Compra.realizarCompra(productos, clientes, scanner);
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    return;
                default:
                    System.out.println("Opcion no valida. Por favor, elija una opcion entre 1 y 8.");
            }
        }
}
}