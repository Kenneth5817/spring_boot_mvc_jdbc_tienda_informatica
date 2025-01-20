package org.iesvegademijas.tienda_informatica.modelo;

public class Producto {
    //Atributos
    private int codigo;
    private String nombre;
    private double precio;
    private int id_fabricante;

    public Producto() {

    }

    public Producto(int codigo, String nombre, double precio, int id_fabricante) {
        super();
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio=precio;
        this.id_fabricante=id_fabricante;
    }



    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getId_fabricante() {
        return id_fabricante;
    }

    public void setId_fabricante(int id_fabricante) {
        this.id_fabricante = id_fabricante;
    }

    //ToString
    @Override
    public String toString() {
        return "Producto{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", id_fabricante=" + id_fabricante +
                '}';
    }



}
