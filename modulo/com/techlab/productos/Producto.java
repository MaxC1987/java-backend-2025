package modulo.com.techlab.productos;

public abstract class Producto {
    private String nombre;
    private double precio;
    private int cantidad;
    private String categoria;
    private Object[] atributos;

    public Producto(String nombre, double precio, int cantidad, String categoria) {
        this.nombre = formatearNombreProducto(nombre);
        this.precio = precio;
        this.cantidad = cantidad;
        this.categoria = categoria;
        this.atributos = new Object[0]; // Inicializa atributos como un arreglo vacío
    }

    public Object getAtributo(int indice) {
        if (indice < 0 || indice >= atributos.length) {
            throw new IndexOutOfBoundsException("Índice fuera de rango.");
        } else {
            return null;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setNombre(String nombre) {
        this.nombre = formatearNombreProducto(nombre);
    }  

    public void setPrecio(double precio) {
        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo.");
        } else {
            this.precio = precio;
        }
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double calcularPrecioTotal(int cantidad) {
            return getPrecio() * cantidad;
    }

    public static String formatearNombreProducto(String nombre) {
        nombre = nombre.trim().toLowerCase();
            String[] partes = nombre.split(" ");
            StringBuilder nombreFormateado = new StringBuilder();
            for (String parte : partes) {
                if (parte.length() > 0) {
                    nombreFormateado.append(Character.toUpperCase(parte.charAt(0)));
                    nombreFormateado.append(parte.substring(1).toLowerCase());
                    nombreFormateado.append(" ");
                }
            }
            return nombreFormateado.toString().trim(); 
        }
    }
