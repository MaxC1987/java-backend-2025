package modulo.com.techlab.productos;

public class Infusiones extends Producto {

    public Infusiones(String nombre, double precio, int cantidad, String categoria) {
        super(nombre, precio, cantidad, categoria);
    }

    @Override
    public double calcularPrecioTotal(int cantidad) {
        if (cantidad >= 10) {
            System.out.println("Aplicando descuento del 10% por compra de 10 o más unidades.");
            return getPrecio() * cantidad * 0.9; // 10% de descuento
        } else {
            return getPrecio() * cantidad; // Sin descuento
        }
    }
}