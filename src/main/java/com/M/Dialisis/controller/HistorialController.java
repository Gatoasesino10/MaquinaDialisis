package com.M.Dialisis.controller;

import com.M.Dialisis.model.Historial;
import com.M.Dialisis.service.HistorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/historial")
public class HistorialController {

    @Autowired
    private HistorialService historialService;

    // 1. LEER TODOS (GET) -> Equivalente a obtenerHistorial() del diagrama
    // Prueba en navegador: http://localhost:8080/historial
    @GetMapping
    public List<Historial> obtenerHistorial() {
        return historialService.obtenerTodoElHistorial();
    }

    // 2. LEER POR ID (GET)
    // Prueba en navegador: http://localhost:8080/historial/1
    @GetMapping("/{id}")
    public Historial obtenerSesionPorId(@PathVariable Long id) {
        return historialService.obtenerPorId(id);
    }

    // 3. CREAR (POST) -> Equivalente a guardarInforme() del diagrama
    // Endpoint: POST http://localhost:8080/historial
    @PostMapping
    public Historial guardarInforme(@RequestBody Historial nuevaSesion) {
        return historialService.guardarInforme(nuevaSesion);
    }

    // 4. ACTUALIZAR (PUT)
    // Endpoint: PUT http://localhost:8080/historial/1
    @PutMapping("/{id}")
    public Historial actualizarSesion(@PathVariable Long id, @RequestBody Historial sesionActualizada) {
        return historialService.actualizarInforme(id, sesionActualizada);
    }

    // 5. BORRAR (DELETE)
    // Endpoint: DELETE http://localhost:8080/historial/1
    @DeleteMapping("/{id}")
    public String eliminarSesion(@PathVariable Long id) {
        historialService.eliminarInforme(id);
        return "Sesión con ID " + id + " eliminada correctamente del historial.";
    }
}