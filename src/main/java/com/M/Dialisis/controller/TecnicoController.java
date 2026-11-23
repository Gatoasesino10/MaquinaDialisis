package com.M.Dialisis.controller; 

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
public class TecnicoController {

    // Atributo según el diagrama de clases: + id: String
    private final String id = "TEC-01";

    // Endpoint principal: http://localhost:8080/tecnico
    // Muestra la información del técnico y el resultado de validarEstado(m: Maquina)
    @GetMapping("/tecnico")
    public Map<String, Object> obtenerInfoTecnico() {
        // Simulamos la instancia de Maquina asociada (atributos de tu diagrama)
        String idMaquina = "MAQ-DIALISIS-001";
        boolean estadoVia = true;
        boolean alimentacionOk = true;

        // Ejecutamos la lógica del método de tu diagrama: validarEstado(m: Maquina)
        boolean estadoValido = validarEstado(estadoVia, alimentacionOk);

        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("idTecnico", this.id);
        respuesta.put("maquinaAsignada", idMaquina);
        respuesta.put("estadoVia", estadoVia);
        respuesta.put("alimentacionOk", alimentacionOk);
        respuesta.put("resultadoValidacionEstado", estadoValido);
        respuesta.put("mensaje", estadoValido ? "Máquina operativa y calibrada" : "Requiere reparación en taller");

        return respuesta;
    }

    // Endpoint adicional: http://localhost:8080/tecnico/validar/MAQ-02
    // Permite validar una máquina pasando su ID por la URL
    @GetMapping("/tecnico/validar/{idMaquina}")
    public Map<String, Object> validarMaquinaPorId(@PathVariable String idMaquina) {
        boolean estadoValido = validarEstado(true, true);

        Map<String, Object> resultado = new HashMap<>();
        resultado.put("tecnicoResponsable", this.id);
        resultado.put("maquinaRevisada", idMaquina);
        resultado.put("validaParaUsoClinico", estadoValido);
        return resultado;
    }

    // Método fiel al diagrama de clases: + validarEstado(m: Maquina): boolean
    private boolean validarEstado(boolean estadoVia, boolean alimentacionOk) {
        return estadoVia && alimentacionOk;
    }
}