package com.M.Dialisis.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonalSanitarioService {

    @Autowired
    RepositoryPersonalSanitario repositoryPersonalSanitario;

    // Devuelve todo el personal sanitario
    public List<PersonalSanitario> getAllPersonalSanitario() {
        return repositoryPersonalSanitario.findAll();
    }

    // Devuelve un miembro del personal sanitario por ID
    public PersonalSanitario getPersonalSanitario(String id) {
        return repositoryPersonalSanitario.getReferenceById(id);
    }

    // Crea un registro de personal sanitario
    public PersonalSanitario addPersonalSanitario(PersonalSanitario p) {
        return repositoryPersonalSanitario.saveAndFlush(p);
    }

    // Actualiza un registro de personal sanitario
    public void updatePersonalSanitario(PersonalSanitario p) {
        PersonalSanitario personal = repositoryPersonalSanitario.getReferenceById(p.getId());
        personal.setUltimaTemperatura(p.getUltimaTemperatura());
        personal.setAireDetectado(p.isAireDetectado());
        personal.setDialisisActiva(p.isDialisisActiva());
        personal.setAmbulanciaEnCamino(p.isAmbulanciaEnCamino());
        repositoryPersonalSanitario.save(personal);
    }

    // Elimina un registro de personal sanitario
    public void removePersonalSanitario(PersonalSanitario p) {
        repositoryPersonalSanitario.delete(p);
    }

    // Elimina un registro de personal sanitario por ID
    public void removePersonalSanitarioID(String id) {
        repositoryPersonalSanitario.deleteById(id);
    }
}