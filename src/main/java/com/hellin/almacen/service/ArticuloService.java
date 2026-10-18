package com.hellin.almacen.service;

import com.hellin.almacen.model.Articulo;
import com.hellin.almacen.repository.ArticuloRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.LinkedHashMap;

// TODO: documentar la clase y todos sus métodos con Javadoc.
@Service
public class ArticuloService {

    private final ArticuloRepository repositorio;

    public ArticuloService(ArticuloRepository repositorio) {
        this.repositorio = repositorio;
    }

    /**
     * Devuelve todos los artículos del almacén.
     *
     * @return lista de todos los artículos, ordenados por id
     */
    public List<Articulo> listarTodos() {
        return repositorio.findAll();
    }

    /**
     * Busca un artículo por su id y devuelve sus datos básicos.
     * Si el artículo no existe, devuelve un Optional vacío.
     * Si el stock es cero, añade un mensaje indicando que está agotado.
     *
     * @param id identificador del artículo
     * @return Optional con los datos básicos (id, nombre, stock y, si procede,
     *         mensaje)
     */
    public Optional<Map<String, Object>> buscarBasico(Integer id) {
        return repositorio.findById(id).map(articulo -> {
            Map<String, Object> datos = new LinkedHashMap<>();
            datos.put("id", articulo.getId());
            datos.put("nombre", articulo.getNombre());
            datos.put("stock", articulo.getStock());
            if (articulo.getStock() == 0) {
                datos.put("mensaje", "Agotado");
            }
            return datos;
        });
    }

}
