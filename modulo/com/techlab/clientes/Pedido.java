package modulo.com.techlab.clientes;

import java.util.ArrayList;

import modulo.com.techlab.productos.Bebida;
import modulo.com.techlab.productos.Comida;
import modulo.com.techlab.productos.Infusiones;
import modulo.com.techlab.productos.Producto;

public class Pedido {
    private ArrayList<Producto> carrito;
    private Cliente cliente;

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.carrito = new ArrayList<>();
    }

    public void agregarProductoAlCarrito(String nombre, double precio, int cantidad, String categoria) {
        this.carrito.add(new Infusiones(nombre, precio, cantidad, categoria));
    }

    public void agregarProductoAlCarrito(String nombre, double precio, int cantidad, String categoria, double volumenEnLitros) {
        this.carrito.add(new Bebida(nombre, precio, cantidad, categoria, volumenEnLitros));
    }

    public void agregarProductoAlCarrito(String nombre, double precio, int cantidad, String categoria, String fechaVencimiento) {
        this.carrito.add(new Comida(nombre, precio, cantidad, categoria, fechaVencimiento));
    }

    public void eliminarProductoDelCarrito(Producto producto) {
        this.carrito.remove(producto);
    }

    public ArrayList<Producto> getProductos() {
        return carrito;
    }

    public Cliente getCliente() {
        return cliente;
    }   

    public double calcularTotal() {
        double total = 0;
        System.out.println("\nProductos en el carrito:\n");
        for (Producto producto : carrito) {
            System.out.println(producto.getNombre() + " - Cantidad: " + producto.getCantidad() + " " + producto.getPrecio());
            total += producto.getPrecio();
        }
        return total + (total * 0.21); // IVA del 21%
    }
}
