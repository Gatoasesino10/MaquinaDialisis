package com.M.Dialisis.controller;

import com.M.Dialisis.model.Paciente;
import com.M.Dialisis.model.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public List<Paciente> obtenerTodosLosPacientes() {
        return pacienteService.getAllPacientes();
    }

    @GetMapping("/{dni}")
    public Paciente obtenerPacientePorDni(@PathVariable String dni) {
        return pacienteService.getPaciente(dni);
    }

    @PostMapping
    public Paciente crearPaciente(@RequestBody Paciente nuevoPaciente) {
        return pacienteService.addPaciente(nuevoPaciente);
    }

    @PutMapping
    public String actualizarPaciente(@RequestBody Paciente pacienteActualizado) {
        pacienteService.updatePaciente(pacienteActualizado);
        return "Paciente con DNI " + pacienteActualizado.getDni() + " actualizado.";
    }

    @DeleteMapping("/{dni}")
    public String eliminarPaciente(@PathVariable String dni) {
        pacienteService.removePacienteID(dni);
        return "Paciente con DNI " + dni + " eliminado.";
    }

    @GetMapping("/{dni}/rutina/{modo}")
    public Map<String, Object> escogerRutina(@PathVariable String dni, @PathVariable String modo) {
        Paciente p = pacienteService.getPaciente(dni);
        String modoNormalizado = modo.toUpperCase();
        boolean valido = modoNormalizado.equals("RAPIDO") || modoNormalizado.equals("LENTO");

        if (valido && p != null) {
            p.setRutinaActual(modoNormalizado);
            pacienteService.updatePaciente(p);
        }

        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("dni", dni);
        respuesta.put("rutinaValida", valido);
        respuesta.put("modoSeleccionado", p.getRutinaActual());
        return respuesta;
    }

    @GetMapping("/{dni}/comenzar")
    public Map<String, Object> comenzarDialisisEndpoint(@PathVariable String dni) {
        Paciente p = pacienteService.getPaciente(dni);
        boolean viaConectada = true;

        if (viaConectada && verAgua() >= 20) {
            p.setDialisisEnCurso(true);
            pacienteService.updatePaciente(p);
        }

        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("dni", dni);
        respuesta.put("dialisisIniciada", p.isDialisisEnCurso());
        respuesta.put("rutina", p.getRutinaActual());
        return respuesta;
    }

    @GetMapping("/{dni}/detener")
    public Map<String, Object> detenerDialisisEndpoint(@PathVariable String dni) {
        Paciente p = pacienteService.getPaciente(dni);
        p.setDialisisEnCurso(false);
        pacienteService.updatePaciente(p);

        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("dni", dni);
        respuesta.put("dialisisDetenida", true);
        respuesta.put("estadoActual", "DETENIDA_POR_PACIENTE");
        return respuesta;
    }

    public int verAgua() {
        return 85;
    }
}