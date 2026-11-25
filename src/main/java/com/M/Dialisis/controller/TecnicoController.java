package com.M.Dialisis.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.M.Dialisis.model.Tecnico;
import com.M.Dialisis.model.TecnicoService; // <-- Cámbialo a com.M.Dialisis.model.TecnicoService si lo tienes en model

@RestController
public class TecnicoController {

    @Autowired
    private TecnicoService tecnicoService;

    // Devuelve todos los técnicos de H2
    @GetMapping("/tecnicos")
    public List<Tecnico> getTecnicos() {
        return tecnicoService.getAllTecnicos();
    }

    // Devuelve un técnico por ID
    @GetMapping("/tecnico/{id}")
    public Tecnico getTecnico(@PathVariable("id") String id) {
        return tecnicoService.getTecnico(id);
    }

    // Crea un técnico con el objeto Tecnico recibido en formato JSON
    @PostMapping(value = "/tecnico", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> saveTecnico(@RequestBody Tecnico tecnico) {
        try {
            tecnicoService.addTecnico(tecnico);
            return ResponseEntity.ok().body("Un nuevo técnico se ha añadido");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("El técnico ya existe");
        }
    }

    // Crea un técnico con el objeto Tecnico recibido en formato HTML Form
    @PostMapping(value = "/tecnico", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public ResponseEntity<?> saveHTML(Tecnico tecnico) {
        try {
            tecnicoService.addTecnico(tecnico);
            return ResponseEntity.ok().body("Un nuevo técnico se ha añadido");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("El técnico ya existe");
        }
    }

    // Actualiza un técnico con el objeto Tecnico
    @PutMapping("/tecnico")
    public ResponseEntity<?> updateTecnico(Tecnico tecnico) {
        try {
            tecnicoService.updateTecnico(tecnico);
            return ResponseEntity.ok().body("El técnico se ha actualizado");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al actualizar el técnico");
        }
    }

    // Elimina un técnico pasando el objeto Tecnico
    @DeleteMapping("/tecnico")
    public ResponseEntity<?> deleteTecnico(@RequestBody Tecnico tecnico) {
        try {
            tecnicoService.removeTecnico(tecnico);
            return ResponseEntity.ok().body("El técnico se ha eliminado");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al eliminar el técnico");
        }
    }

    // Otra forma de eliminar un técnico con el ID
    @DeleteMapping("/tecnico/{id}")
    public ResponseEntity<?> deleteTecnico(@PathVariable("id") String id) {
        try {
            tecnicoService.removeTecnicoID(id);
            return ResponseEntity.ok().body("El técnico se ha eliminado");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al eliminar el técnico");
        }
    }

    // --- MÉTODO DEL DIAGRAMA DE CLASES: + validarEstado(m: Maquina): boolean ---
    // Prueba en navegador: http://localhost:8080/tecnico/TEC-01/validar
    @GetMapping("/tecnico/{id}/validar")
    public Map<String, Object> validarMaquinaDeTecnico(@PathVariable("id") String id) {
        Tecnico t = tecnicoService.getTecnico(id);
        boolean estadoValido = validarEstado(t.isEstadoVia(), t.isAlimentacionOk());

        Map<String, Object> resultado = new HashMap<>();
        resultado.put("tecnicoResponsable", t.getId());
        resultado.put("maquinaRevisada", t.getIdMaquinaAsignada());
        resultado.put("validaParaUsoClinico", estadoValido);
        resultado.put("mensaje", estadoValido ? "Máquina operativa y calibrada" : "Requiere reparación en taller");
        return resultado;
    }

    private boolean validarEstado(boolean estadoVia, boolean alimentacionOk) {
        return estadoVia && alimentacionOk;
    }
}