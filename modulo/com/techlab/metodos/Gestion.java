package modulo.com.techlab.metodos;

import java.util.Scanner;

import modulo.com.techlab.productos.Bebida;
import modulo.com.techlab.productos.Comida;
import modulo.com.techlab.productos.Infusiones;
import modulo.com.techlab.productos.Producto;

import java.util.ArrayList;

public class Gestion {

    // AGREGAR PRODUCTO
    public static void agregarProducto(ArrayList<Producto> productos, Scanner scanner) {
        System.out.println("Ingrese el nombre del producto:");
        String nombre = scanner.nextLine().trim();
        
        System.out.println("Ingrese el precio del producto:");
        double precio = scanner.nextDouble();
        
        System.out.println("Ingrese la cantidad del producto:");
        int cantidad = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        
        System.out.println("Ingrese la categoria del producto:");
        String categoria = scanner.nextLine();

        System.out.println("Ingrese el tipo de producto (Infusiones, Bebida, Comida):");
        String tipoProducto = scanner.nextLine().trim().toLowerCase();

        while (!tipoProducto.equals("infusiones") && !tipoProducto.equals("bebida") && !tipoProducto.equals("comida")) {
            System.out.println("Tipo de producto no valido. Ingrese Infusiones, Bebida o Comida:");
            tipoProducto = scanner.nextLine().trim().toLowerCase();
        }
        if (tipoProducto.equals("infusiones")) {
            Producto nuevoProducto = new Infusiones(nombre, precio, cantidad, categoria);
            productos.add(nuevoProducto);
            System.out.println("Producto agregado exitosamente!");
            return;
        } else if (tipoProducto.equals("bebida")) {
            System.out.println("Ingrese el volumen en litros:");
            double volumenEnLitros = scanner.nextDouble();
            scanner.nextLine(); // Limpiar el buffer
            Producto nuevoProducto = new Bebida(nombre, precio, cantidad, categoria, volumenEnLitros);
            productos.add(nuevoProducto);
            System.out.println("Producto agregado exitosamente!");
            return;
        } else if (tipoProducto.equals("comida")) {
            System.out.println("Ingrese la fecha de vencimiento (dd/MM/yyyy):");
            String fechaVencimiento = scanner.nextLine().trim();
            Producto nuevoProducto = new Comida(nombre, precio, cantidad, categoria, fechaVencimiento);
            productos.add(nuevoProducto);
            System.out.println("Producto agregado exitosamente!");
            return;
        }
        
        System.out.println("Producto agregado exitosamente!");
    }

    // MODIFICAR PRODUCTO
    public static void modificarProducto(ArrayList<Producto> productos, Scanner scanner) {
        System.out.println("Ingrese el nombre del producto que desea modificar:");
        String nombreBuscado = scanner.nextLine().trim().toLowerCase();

        boolean encontrado = false;
        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombreBuscado)) {
                encontrado = true;
                System.out.println("Producto encontrado: " + producto.getNombre() + " - Precio: $" + producto.getPrecio() + " - Cantidad: " + producto.getCantidad());
                
                System.out.println("Ingrese el nuevo precio del producto:");
                double nuevoPrecio = scanner.nextDouble();
                
                System.out.println("Ingrese la nueva cantidad del producto:");
                int nuevaCantidad = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer
                
                System.out.println("Ingrese la nueva categoria del producto:");
                String nuevaCategoria = scanner.nextLine();
                
                producto.setPrecio(nuevoPrecio);
                producto.setCantidad(nuevaCantidad);
                producto.setCategoria(nuevaCategoria);
                
                System.out.println("Producto modificado exitosamente!");
                break;
            }
        }
        
        if (!encontrado) {
            System.out.println("No se encontraron productos con el nombre: " + nombreBuscado);
        }
    }

    // ELIMINAR PRODUCTO
    public static void eliminarProducto(ArrayList<Producto> productos, Scanner scanner) {
        System.out.println("Ingrese el nombre del producto que desea eliminar:");
        String nombreBuscado = scanner.nextLine().trim().toLowerCase();

        boolean encontrado = false;
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getNombre().equalsIgnoreCase(nombreBuscado)) {
                encontrado = true;
                productos.remove(i);
                System.out.println("Producto eliminado exitosamente!");
                break;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontraron productos con el nombre: " + nombreBuscado);
        }
    }

    // LISTAR PRODUCTOS
    public static void listarProductos(ArrayList<Producto> productos) {
        System.out.println("Lista de productos:");
        for (Producto producto : productos) {
            System.out.println(producto.getNombre() + " - Precio: $" + producto.getPrecio() + " - Cantidad: " + producto.getCantidad() + " - Categoria: " + producto.getCategoria());
        }
    }

    // BUSCAR PRODUCTO
    public static void buscarProducto(ArrayList<Producto> productos, Scanner scanner) {
        System.out.println("Ingrese el nombre del producto que desea buscar:");
        String nombreBuscado = scanner.nextLine().trim().toLowerCase();

        boolean encontrado = false;
        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombreBuscado)) {
                encontrado = true;
                System.out.println("Producto encontrado: " + producto.getNombre() + " - Precio: $" + producto.getPrecio() + " - Cantidad: " + producto.getCantidad() + " - Categoria: " + producto.getCategoria());
                break;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontraron productos con el nombre: " + nombreBuscado);
        }
    }

    // FILTRAR PRODUCTOS POR CATEGORIA
    public static void filtrarProductos(ArrayList<Producto> productos, Scanner scanner) {
        System.out.println("Ingrese la categoria por la que desea filtrar:");
        String categoriaBuscada = scanner.nextLine().trim().toLowerCase();

        boolean encontrado = false;
        for (Producto producto : productos) {
            if (producto.getCategoria().equalsIgnoreCase(categoriaBuscada)) {
                encontrado = true;
                System.out.println(producto.getNombre() + " - Precio: $" + producto.getPrecio() + " - Cantidad: " + producto.getCantidad());
            }
        }

        if (!encontrado) {
            System.out.println("No se encontraron productos en la categoria: " + categoriaBuscada);
        }
    }

    // REPONER STOCK DE UN PRODUCTO
    public static void reponerStock(ArrayList<Producto> productos, Scanner scanner) {
        System.out.println("Ingrese el nombre del producto que desea reponer:");
        String nombreBuscado = scanner.nextLine().trim().toLowerCase();

        boolean encontrado = false;
        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombreBuscado)) {
                encontrado = true;
                System.out.println("Producto encontrado: " + producto.getNombre() + " - Precio: $" + producto.getPrecio() + " - Cantidad: " + producto.getCantidad());
                
                System.out.println("Ingrese la cantidad a reponer:");
                int cantidadReponer = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer
                
                producto.setCantidad(producto.getCantidad() + cantidadReponer);
                
                System.out.println("Stock repuesto exitosamente en: " + producto.getNombre() + " - Nueva cantidad: " + producto.getCantidad());
                break;
            }
        }
        
        if (!encontrado) {
            System.out.println("No se encontraron productos con el nombre: " + nombreBuscado);
        }
    }
}