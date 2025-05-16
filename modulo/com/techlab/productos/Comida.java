package modulo.com.techlab.productos;

public class Comida extends Producto {
    private String fechaVencimiento;
    private Object[] atributos;

    public Comida(String nombre, double precio, int cantidad, String categoria, String fechaVencimiento) {
        super(nombre, precio, cantidad, categoria);
        this.fechaVencimiento = fechaVencimiento;
        this.atributos = new Object[] {nombre, precio, cantidad, categoria, fechaVencimiento}; // Inicializa atributos con los valores del constructor
    }

    public Object getAtributo(int indice) {
        if (indice < 0 || indice >= atributos.length) {
            throw new IndexOutOfBoundsException("Índice fuera de rango.");
        } else {
            return atributos[indice]; // Devuelve el atributo correspondiente
        }
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    @Override
    public double calcularPrecioTotal(int cantidad) {
        if (cantidad >= 15) {
            System.out.println("Aplicando descuento del 10% por compra de 15 o más unidades.");
            return getPrecio() * cantidad * 0.9; // 10% de descuento
        } else {
            return getPrecio() * cantidad; // Sin descuento
        }
    }
}
