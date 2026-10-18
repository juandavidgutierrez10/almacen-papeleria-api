package com.hellin.almacen.controller;

import com.hellin.almacen.model.Articulo;
import com.hellin.almacen.service.ArticuloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controlador REST para la gestión de artículos del almacén.
 *
 * @author Departamento de Informática
 * @version 1.0.0
 */
@RestController
@RequestMapping("/api/articulos")
public class ArticuloController {

    private final ArticuloService servicio;

    /**
     * Crea el controlador con el servicio de artículos.
     *
     * @param servicio servicio de artículos
     */
    public ArticuloController(ArticuloService servicio) {
        this.servicio = servicio;
    }

    /**
     * Devuelve todos los artículos del almacén.
     *
     * @return lista de todos los artículos en formato JSON
     */
    @GetMapping
    public List<Articulo> listarTodos() {
        return servicio.listarTodos();
    }

    // TODO (#n de la incidencia): GET /api/articulos/{id}/basico -> datos básicos (200) o 404 si no existe
}