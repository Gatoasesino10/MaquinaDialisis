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

import com.M.Dialisis.model.PersonalSanitario;
import com.M.Dialisis.model.PersonalSanitarioService;

@RestController
public class PersonalController {

    @Autowired
    private PersonalSanitarioService personalSanitarioService;

    @GetMapping("/personalSanitarios")
    public List<PersonalSanitario> getPersonalSanitarios() {
        return personalSanitarioService.getAllPersonalSanitario();
    }

    @GetMapping("/personalSanitario/{id}")
    public PersonalSanitario getPersonalSanitario(@PathVariable("id") String id) {
        return personalSanitarioService.getPersonalSanitario(id);
    }

    @PostMapping(value = "/personalSanitario", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> savePersonalSanitario(@RequestBody PersonalSanitario personal) {
        try {
            personalSanitarioService.addPersonalSanitario(personal);
            return ResponseEntity.ok().body("Un nuevo miembro del personal sanitario se ha añadido");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("El personal sanitario ya existe");
        }
    }

    @PostMapping(value = "/personalSanitario", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public ResponseEntity<?> saveHTML(PersonalSanitario personal) {
        try {
            personalSanitarioService.addPersonalSanitario(personal);
            return ResponseEntity.ok().body("Un nuevo miembro del personal sanitario se ha añadido");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("El personal sanitario ya existe");
        }
    }

    @PutMapping("/personalSanitario")
    public ResponseEntity<?> updatePersonalSanitario(PersonalSanitario personal) {
        try {
            personalSanitarioService.updatePersonalSanitario(personal);
            return ResponseEntity.ok().body("El personal sanitario se ha actualizado");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al actualizar el personal sanitario");
        }
    }

    @DeleteMapping("/personalSanitario")
    public ResponseEntity<?> deletePersonalSanitario(@RequestBody PersonalSanitario personal) {
        try {
            personalSanitarioService.removePersonalSanitario(personal);
            return ResponseEntity.ok().body("El personal sanitario se ha eliminado");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al eliminar el personal sanitario");
        }
    }

    @DeleteMapping("/personalSanitario/{id}")
    public ResponseEntity<?> deletePersonalSanitario(@PathVariable("id") String id) {
        try {
            personalSanitarioService.removePersonalSanitarioID(id);
            return ResponseEntity.ok().body("El personal sanitario se ha eliminado");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al eliminar el personal sanitario");
        }
    }

    @GetMapping("/personalSanitario/{id}/interrumpir")
    public Map<String, Object> interrumpirDialisisEndpoint(@PathVariable("id") String id) {
        PersonalSanitario p = personalSanitarioService.getPersonalSanitario(id);
        p.setDialisisActiva(false);
        personalSanitarioService.updatePersonalSanitario(p);

        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("accionEjecutadaPor", p.getId());
        respuesta.put("dialisisInterrumpida", true);
        respuesta.put("estadoSesion", "DETENIDA_POR_MEDICO");
        return respuesta;
    }

    @GetMapping("/personalSanitario/{id}/ambulancia")
    public Map<String, Object> llamarAmbuEndpoint(@PathVariable("id") String id) {
        PersonalSanitario p = personalSanitarioService.getPersonalSanitario(id);
        p.setAmbulanciaEnCamino(true);
        personalSanitarioService.updatePersonalSanitario(p);

        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("solicitadoPor", p.getId());
        respuesta.put("ambulanciaEnviada", true);
        respuesta.put("mensaje", "Alerta de emergencia transmitida al servicio externo de ambulancias.");
        return respuesta;
    }
}