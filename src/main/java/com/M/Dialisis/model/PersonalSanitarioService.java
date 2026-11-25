package com.M.Dialisis.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonalSanitarioService {

    @Autowired
    RepositoryPersonalSanitario repositoryPersonalSanitario;

    public List<PersonalSanitario> getAllPersonalSanitario() {
        return repositoryPersonalSanitario.findAll();
    }

    public PersonalSanitario getPersonalSanitario(String id) {
        return repositoryPersonalSanitario.getReferenceById(id);
    }

    public PersonalSanitario addPersonalSanitario(PersonalSanitario p) {
        return repositoryPersonalSanitario.saveAndFlush(p);
    }

    public void updatePersonalSanitario(PersonalSanitario p) {
        PersonalSanitario personal = repositoryPersonalSanitario.getReferenceById(p.getId());
        personal.setUltimaTemperatura(p.getUltimaTemperatura());
        personal.setAireDetectado(p.isAireDetectado());
        personal.setDialisisActiva(p.isDialisisActiva());
        personal.setAmbulanciaEnCamino(p.isAmbulanciaEnCamino());
        repositoryPersonalSanitario.save(personal);
    }

    public void removePersonalSanitario(PersonalSanitario p) {
        repositoryPersonalSanitario.delete(p);
    }

    public void removePersonalSanitarioID(String id) {
        repositoryPersonalSanitario.deleteById(id);
    }
}