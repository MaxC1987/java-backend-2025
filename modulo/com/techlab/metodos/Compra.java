package modulo.com.techlab.metodos;

import java.util.Scanner;

import modulo.com.techlab.clientes.Cliente;
import modulo.com.techlab.clientes.Pedido;
import modulo.com.techlab.productos.Producto;

import java.util.ArrayList;

public class Compra {
    public static void realizarCompra(ArrayList<Producto> productos, ArrayList<Cliente> clientes, Scanner scanner) {

        System.out.println("Bienvenido a la compra de productos.");
        System.out.println("Por favor, ingrese sus datos:");
        //DATOS DEL CLIENTE
        System.out.println("Nombre:");
        String nombre = scanner.nextLine();
        System.out.println("Apellido:");
        String apellido = scanner.nextLine();
        System.out.println("Email:");
        String email = scanner.nextLine();

        Pedido pedido = new Pedido(new Cliente(nombre, apellido, email));

        if (clientes.contains(pedido.getCliente())) {
            System.out.println("\nGracias por volver " + nombre + " " + apellido + "!");
        } else {
            clientes.add(new Cliente(nombre, apellido, email));
            System.out.println("\nCliente registrado exitosamente.\n" + "Bienvenido " + nombre + " " + apellido + "!");
        }

        // MOSTRAR PRODUCTOS DISPONIBLES
        while (true) {
        System.out.println("\nIngrese el numero del producto que desea comprar o 0 para salir:\n");
        for (int i = 0; i < productos.size(); i++) {
            System.out.println((i + 1) + ". " + productos.get(i).getNombre() + " - Precio: $" + productos.get(i).getPrecio() + " - Cantidad: " + productos.get(i).getCantidad());
        }

        int numeroProducto = scanner.nextInt() - 1;
        scanner.nextLine(); // Limpiar el buffer

        // INICIO DE LA COMPRA
        if (numeroProducto < -1 || numeroProducto >= productos.size()) {
            System.out.println("\nNumero de producto no valido.\n");
            continue;
        } else if (numeroProducto == -1) {
            System.out.println("\nSaliendo de la compra.\n");
            break;
        } else {
            Producto producto = productos.get(numeroProducto);
            String nombreProducto = producto.getNombre();
            System.out.println("\nIngrese la cantidad que desea comprar:\n");
            int cantidadCompra = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            if (cantidadCompra > producto.getCantidad()) {
                System.out.println("\nNo hay suficiente stock para completar la compra.\n");

            // SI EL PRODUCTO YA ESTA EN EL CARRITO
            } else if (pedido.getProductos().stream().anyMatch(p -> p.getNombre().equalsIgnoreCase(nombreProducto) && p.getCantidad() + cantidadCompra > producto.getCantidad())) {
                System.out.println("\nNo hay suficiente stock para completar la compra.\n");
            } else if (pedido.getProductos().stream().anyMatch(p -> p.getNombre().equalsIgnoreCase(nombreProducto))) {
                producto.setCantidad(producto.getCantidad() - cantidadCompra);

                Producto productoCarrito = pedido.getProductos().stream()
                        .filter(p -> p.getNombre().equalsIgnoreCase(nombreProducto))
                        .findFirst()
                        .orElse(null);

                productoCarrito.setCantidad(productoCarrito.getCantidad() + cantidadCompra);
                productoCarrito.setPrecio(producto.calcularPrecioTotal(productoCarrito.getCantidad()));
                System.out.println("\nProducto ya en el carrito, se ha actualizado la cantidad.\n");

                for (Producto p : pedido.getProductos()) {
                System.out.println(p.getNombre() + " - Cantidad: " + p.getCantidad() + " - Precio total: $" + p.getPrecio());
            }
                continue;

            // SI EL PRODUCTO NO ESTA EN EL CARRITO
            } else {
                producto.setCantidad(producto.getCantidad() - cantidadCompra);

                try {
                    producto.getAtributo(4);
                    try {
                        Double valor = (double) producto.getAtributo(4);
                        pedido.agregarProductoAlCarrito(producto.getNombre(), producto.calcularPrecioTotal(cantidadCompra), cantidadCompra, producto.getCategoria(), valor);
                    } catch (ClassCastException e) {
                        String valor = producto.getAtributo(4).toString();
                        pedido.agregarProductoAlCarrito(producto.getNombre(), producto.calcularPrecioTotal(cantidadCompra), cantidadCompra, producto.getCategoria(), valor);
                    }
                } catch (IndexOutOfBoundsException e) {
                    pedido.agregarProductoAlCarrito(producto.getNombre(), producto.calcularPrecioTotal(cantidadCompra), cantidadCompra, producto.getCategoria());
                }
                System.out.println("\nProductos agregados al carrito: ");

                for (Producto p : pedido.getProductos()) {
                    System.out.println(p.getNombre() + " - Cantidad: " + p.getCantidad() + " - Precio total: $" + p.getPrecio());
                }
                continue;
            }
        }
        }
        System.out.println("\nTotal a pagar: $" + pedido.calcularTotal() + " (IVA incluido)");
        System.out.println("\nGracias por su compra, " + pedido.getCliente().getNombre() + " " + pedido.getCliente().getApellido() + "!\n");
}
}