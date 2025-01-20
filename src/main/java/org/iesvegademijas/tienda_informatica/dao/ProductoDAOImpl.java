package org.iesvegademijas.tienda_informatica.dao;


import org.iesvegademijas.tienda_informatica.modelo.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoDAOImpl  implements ProductoDAO{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * Inserta en base de datos el nuevo fabricante, actualizando el id en el bean fabricante.
     */
    @Override
    public synchronized void create(Producto producto) {

        jdbcTemplate.update("INSERT INTO producto (nombre) VALUES (?)",producto.getNombre());

    }

    /**
     * Devuelve lista con todos loa fabricantes.
     */
    @Override
    public List<Producto> getAll() {

        List<Producto> listProds = jdbcTemplate.query(
                "SELECT * FROM producto",
                (rs, rowNum) -> new Producto(rs.getInt("codigo"),rs.getString("nombre"),rs.getDouble("precio"), rs.getInt("id_fabricante"))
        );

        return listProds;

    }

    /**
     * Devuelve Optional de fabricante con el ID dado.
     */
    @Override
    public Optional<Producto> find(int id) {

        Producto producto =  jdbcTemplate
                .queryForObject("SELECT * FROM producto WHERE codigo = ?"
                        , (rs, rowNum) -> new Producto(rs.getInt("codigo"),rs.getString("nombre"),rs.getDouble("precio"), rs.getInt("id_fabricante"))
                        , id
                );

        if (producto != null) return Optional.of(producto);
        else return Optional.empty();

    }
    /**
     * Actualiza fabricante con campos del bean fabricante según ID del mismo.
     */
    @Override
    public void update(Producto producto) {

        int rows = jdbcTemplate.update("UPDATE fabricante SET nombre = ?  WHERE codigo = ?", producto.getNombre(), producto.getCodigo(), producto.getPrecio(),producto.getId_fabricante());
        if (rows == 0) System.out.println("Update de producto con 0 registros actualizados.");

    }

    /**
     * Borra fabricante con ID proporcionado.
     */
    @Override
    public void delete(int id) {

        int rows = jdbcTemplate.update("DELETE FROM producto WHERE codigo = ?", id);

        if (rows == 0) System.out.println("Update de producto con 0 registros actualizados.");

    }

}
