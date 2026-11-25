package com.M.Dialisis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.M.Dialisis.model.Historial;
import com.M.Dialisis.model.HistorialService;

@RestController
public class HistorialController {

    @Autowired
    private HistorialService historialService;

    @GetMapping("/historiales")
    public List<Historial> getHistoriales() {
        return historialService.getAllHistoriales();
    }

    @GetMapping("/historial/{id}")
    public Historial getHistorial(@PathVariable("id") Long id) {
        return historialService.getHistorial(id);
    }

    @PostMapping(value = "/historial", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> saveHistorial(@RequestBody Historial historial) {
        try {
            historialService.addHistorial(historial);
            return ResponseEntity.ok().body("Un nuevo informe se ha añadido al historial");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al guardar el informe en el historial");
        }
    }

    @PostMapping(value = "/historial", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public ResponseEntity<?> saveHTML(Historial historial) {
        try {
            historialService.addHistorial(historial);
            return ResponseEntity.ok().body("Un nuevo informe se ha añadido al historial");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al guardar el informe en el historial");
        }
    }

    @PutMapping("/historial")
    public ResponseEntity<?> updateHistorial(Historial historial) {
        try {
            historialService.updateHistorial(historial);
            return ResponseEntity.ok().body("El informe del historial se ha actualizado");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al actualizar el informe");
        }
    }

    @DeleteMapping("/historial")
    public ResponseEntity<?> deleteHistorial(@RequestBody Historial historial) {
        try {
            historialService.removeHistorial(historial);
            return ResponseEntity.ok().body("El informe se ha eliminado del historial");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al eliminar el informe");
        }
    }

    @DeleteMapping("/historial/{id}")
    public ResponseEntity<?> deleteHistorial(@PathVariable("id") Long id) {
        try {
            historialService.removeHistorialID(id);
            return ResponseEntity.ok().body("El informe se ha eliminado del historial");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al eliminar el informe");
        }
    }
}