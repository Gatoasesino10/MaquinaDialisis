package com.M.Dialisis.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    // Atributos según la clase Paciente del diagrama de clases
    private final String dni = "12345678A";
    private final float pesoSeco = 68.5f;
    private final float peso = 71.2f;
    private final float altura = 1.75f;
    private final int edad = 54;
    private final String sexo = "Femenino";

    // Estado interno de sesión y rutina (ModoEnum: RAPIDO / LENTO)
    private String rutinaActual = "RAPIDO";
    private boolean dialisisEnCurso = false;

    // Endpoint principal: http://localhost:8080/paciente
    // Muestra los datos biométricos del paciente y el estado de sus funciones
    @GetMapping
    public Map<String, Object> obtenerInfoPaciente() {
        Map<String, Object> info = new HashMap<>();
        info.put("dni", this.dni);
        info.put("pesoSeco_kg", this.pesoSeco);
        info.put("pesoActual_kg", this.peso);
        info.put("liquidoAExtraer_kg", Math.round((this.peso - this.pesoSeco) * 100.0) / 100.0);
        info.put("altura_m", this.altura);
        info.put("edad", this.edad);
        info.put("sexo", this.sexo);
        info.put("rutinaSeleccionada", this.rutinaActual);
        info.put("dialisisActiva", this.dialisisEnCurso);
        info.put("nivelAguaDisponible", verAgua() + "%");
        info.put("proximoHorario", consultarHorario());
        return info;
    }

    // Método del diagrama: + escogerRutina(enum): bool, enum
    // Prueba en navegador: http://localhost:8080/paciente/rutina/LENTO (o RAPIDO)
    @GetMapping("/rutina/{modo}")
    public Map<String, Object> escogerRutina(@PathVariable String modo) {
        String modoNormalizado = modo.toUpperCase();
        boolean valido = modoNormalizado.equals("RAPIDO") || modoNormalizado.equals("LENTO");

        if (valido) {
            this.rutinaActual = modoNormalizado;
        }

        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("rutinaValida", valido);
        respuesta.put("modoSeleccionado", this.rutinaActual);
        respuesta.put("mensaje", valido ? "Rutina actualizada correctamente" : "Modo no válido (use RAPIDO o LENTO)");
        return respuesta;
    }

    // Método del diagrama: + comenzarDialisis(bool): bool
    // Prueba en navegador: http://localhost:8080/paciente/comenzar
    @GetMapping("/comenzar")
    public Map<String, Object> comenzarDialisisEndpoint() {
        boolean viaConectada = true; // Simulamos que la vía está correctamente conectada
        boolean iniciada = comenzarDialisis(viaConectada);

        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("viaConectada", viaConectada);
        respuesta.put("dialisisIniciada", iniciada);
        respuesta.put("rutina", this.rutinaActual);
        return respuesta;
    }

    // Método del diagrama: + detenerDialisis(bool): bool
    // Prueba en navegador: http://localhost:8080/paciente/detener
    @GetMapping("/detener")
    public Map<String, Object> detenerDialisisEndpoint() {
        boolean confirmacionParada = true;
        boolean detenida = detenerDialisis(confirmacionParada);

        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("dialisisDetenida", detenida);
        respuesta.put("estadoActual", this.dialisisEnCurso ? "EN_CURSO" : "DETENIDA_POR_PACIENTE");
        return respuesta;
    }

    // --- IMPLEMENTACIÓN DE LOS MÉTODOS EXACTOS DEL DIAGRAMA ---

    public int verAgua() {
        return 85; // Devuelve porcentaje de agua disponible en el depósito
    }

    public String consultarHorario() {
        return "Lunes, Miércoles y Viernes - 18:00h (" + this.rutinaActual + ")";
    }

    public boolean comenzarDialisis(boolean viaLista) {
        if (viaLista && verAgua() >= 20) {
            this.dialisisEnCurso = true;
            return true;
        }
        return false;
    }

    public boolean detenerDialisis(boolean emergencia) {
        if (emergencia) {
            this.dialisisEnCurso = false;
            return true;
        }
        return false;
    }
}