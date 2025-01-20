package org.iesvegademijas.tienda_informatica.modelo;

public class Producto {
    private int codigo;
    private String nombre;
    //private double precio;
    //private int id_fabricante;

    public Producto() {

    }

    public Producto(int codigo, String nombre) {
        super();
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Producto [codigo=" + codigo + ", nombre=" + nombre + "]";
    }
}
