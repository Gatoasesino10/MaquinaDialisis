package com.M.Dialisis.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/personalSanitario")
public class PersonalpController {

    // Atributo según la clase Personal Sanitario del diagrama de clases: + id: String
    private final String id = "MED-042";

    // Estado de monitorización recibido mediante el patrón Observer (actualizar(sensor))
    private float ultimaTemperatura = 36.8f;
    private boolean aireDetectado = false;
    private boolean dialisisActiva = true;
    private boolean ambulanciaEnCamino = false;

    // Endpoint principal: http://localhost:8080/personalSanitario
    // Muestra el panel de control del sanitario y los datos recibidos del Observer
    @GetMapping
    public Map<String, Object> obtenerPanelSanitario() {
        Map<String, Object> panel = new HashMap<>();
        panel.put("idPersonalSanitario", this.id);
        panel.put("rol", "Nefrólogo / Supervisor Clínico");
        panel.put("dialisisPacienteActiva", this.dialisisActiva);
        panel.put("ambulanciaSolicitada", this.ambulanciaEnCamino);
        panel.put("telemetriaSensor_Temperatura_C", this.ultimaTemperatura);
        panel.put("telemetriaSensor_AireEnCircuito", this.aireDetectado);
        return panel;
    }

    // Método del diagrama: + consultarPaciente(p: Paciente)
    // Prueba en navegador: http://localhost:8080/personalSanitario/paciente/12345678A
    @GetMapping("/paciente/{dniPaciente}")
    public Map<String, Object> consultarPaciente(@PathVariable String dniPaciente) {
        Map<String, Object> datosPaciente = new HashMap<>();
        datosPaciente.put("medicoConsultor", this.id);
        datosPaciente.put("dniPaciente", dniPaciente);
        datosPaciente.put("estadoClinico", this.aireDetectado ? "ALERTA CRÍTICA" : "ESTABLE");
        datosPaciente.put("temperaturaSanguinea", this.ultimaTemperatura + " °C");
        datosPaciente.put("flujoSanguineo", "310 ml/min");
        datosPaciente.put("kt_v", 1.35);
        return datosPaciente;
    }

    // Método del diagrama: + verHistorial(Paciente): String
    // Prueba en navegador: http://localhost:8080/personalSanitario/historial/12345678A
    @GetMapping("/historial/{dniPaciente}")
    public Map<String, Object> verHistorialEndpoint(@PathVariable String dniPaciente) {
        String resumenHistorial = verHistorial(dniPaciente);

        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("dniPaciente", dniPaciente);
        respuesta.put("registroClinico", resumenHistorial);
        return respuesta;
    }

    // Método del diagrama: + interrumpirDialisis(bool): bool
    // Prueba en navegador: http://localhost:8080/personalSanitario/interrumpir
    @GetMapping("/interrumpir")
    public Map<String, Object> interrumpirDialisisEndpoint() {
        boolean ordenParada = true;
        boolean resultado = interrumpirDialisis(ordenParada);

        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("accionEjecutadaPor", this.id);
        respuesta.put("dialisisInterrumpida", resultado);
        respuesta.put("estadoSesion", this.dialisisActiva ? "EN_CURSO" : "DETENIDA_POR_MEDICO");
        return respuesta;
    }

    // Método del diagrama: + llamarAmbu(bool): bool
    // Prueba en navegador: http://localhost:8080/personalSanitario/ambulancia
    @GetMapping("/ambulancia")
    public Map<String, Object> llamarAmbuEndpoint() {
        boolean emergenciaVital = true;
        boolean llamadaRealizada = llamarAmbu(emergenciaVital);

        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("solicitadoPor", this.id);
        respuesta.put("ambulanciaEnviada", llamadaRealizada);
        respuesta.put("mensaje", "Alerta de emergencia transmitida al servicio externo de ambulancias.");
        return respuesta;
    }

    // --- IMPLEMENTACIÓN DE LOS MÉTODOS EXACTOS DEL DIAGRAMA ---

    public String verHistorial(String dniPaciente) {
        return "Sesión #104 (Completa - 3h - PRU: 69%) | Sesión #105 (Completa - 3h - PRU: 71%)";
    }

    public boolean interrumpirDialisis(boolean anomaliasDetectadas) {
        if (anomaliasDetectadas) {
            this.dialisisActiva = false;
            return true;
        }
        return false;
    }

    public boolean llamarAmbu(boolean riesgoVital) {
        if (riesgoVital) {
            this.ambulanciaEnCamino = true;
            return true;
        }
        return false;
    }

    // Método de la interfaz Observador: + actualizar(sensor: Sensor): void
    public void actualizar(float nuevaTemperatura, boolean presenciaAire) {
        this.ultimaTemperatura = nuevaTemperatura;
        this.aireDetectado = presenciaAire;
    }
}
