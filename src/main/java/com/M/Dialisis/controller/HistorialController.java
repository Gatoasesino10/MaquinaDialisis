package com.M.Dialisis.controller; 

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/historial")
public class HistorialController {

    // Atributos según la clase Historial del diagrama de clases
    private String idSesion = "SES-105";
    private String fecha = "2026-11-23";
    private int duracion = 180; // minutos (Modo RAPIDO)
    private String graficasEvolucion = "PRU: 70% | Kt/V: 1.38 | Flujo medio: 310 ml/min";
    private String responsableInterrupcion = "NINGUNO";

    // Endpoint principal: http://localhost:8080/historial
    // Implementa + obtenerHistorial(): void
    @GetMapping
    public Map<String, Object> obtenerHistorial() {
        Map<String, Object> informe = new HashMap<>();
        informe.put("idSesion", this.idSesion);
        informe.put("fecha", this.fecha);
        informe.put("duracion_minutos", this.duracion);
        informe.put("graficasEvolucion", this.graficasEvolucion);
        informe.put("responsableInterrupcion", this.responsableInterrupcion);
        informe.put("estadoSesion", this.responsableInterrupcion.equals("NINGUNO") ? "COMPLETA" : "INCOMPLETA");
        return informe;
    }

    // Endpoint para simular el guardado de un informe tras una sesión o interrupción
    // Implementa + guardarInforme(): void
    // Prueba en navegador: http://localhost:8080/historial/guardar/SES-106/PACIENTE
    @GetMapping("/guardar/{nuevoId}/{responsable}")
    public Map<String, Object> guardarInforme(@PathVariable String nuevoId, @PathVariable String responsable) {
        this.idSesion = nuevoId;
        this.responsableInterrupcion = responsable.toUpperCase();

        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("mensaje", "Informe guardado correctamente en el historial");
        respuesta.put("idSesionGuardada", this.idSesion);
        respuesta.put("responsableInterrupcion", this.responsableInterrupcion);
        return respuesta;
    }
}