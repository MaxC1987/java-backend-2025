package modulo.com.techlab.productos;

public class Bebida extends Producto {
    private double volumenEnLitros;
    private Object[] atributos;

    public Bebida(String nombre, double precio, int cantidad, String categoria, double volumenEnLitros) {
        super(nombre, precio, cantidad, categoria);
        this.volumenEnLitros = volumenEnLitros;
        this.atributos = new Object[] {nombre, precio, cantidad, categoria, volumenEnLitros}; // Inicializa atributos con los valores del constructor
    }

    public Object getAtributo(int indice) {
        if (indice < 0 || indice >= atributos.length) {
            throw new IndexOutOfBoundsException("Índice fuera de rango.");
        } else {
            return atributos[indice]; // Devuelve el atributo correspondiente
        }
    }

    public double getVolumenEnLitros() {
        return volumenEnLitros;
    }

    @Override
    public double calcularPrecioTotal(int cantidad) {
        if (cantidad >= 6) {
            System.out.println("Aplicando descuento del 15% por compra de 6 o más unidades.");
            return getPrecio() * cantidad * 0.85; // 15% de descuento
        } else {
            return getPrecio() * cantidad; // Sin descuento
        }
    }
}