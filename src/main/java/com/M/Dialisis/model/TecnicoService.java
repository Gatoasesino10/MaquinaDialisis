package com.M.Dialisis.model; // <-- Cámbialo a com.M.Dialisis.model si lo guardas en esa carpeta

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TecnicoService {

    @Autowired
    RepositoryTecnico repositoryTecnico;

    // Devuelve todos los técnicos
    public List<Tecnico> getAllTecnicos() {
        return repositoryTecnico.findAll();
    }

    // Devuelve un técnico por ID
    public Tecnico getTecnico(String id) {
        return repositoryTecnico.getReferenceById(id);
    }

    // Crea un técnico
    public Tecnico addTecnico(Tecnico t) {
        return repositoryTecnico.saveAndFlush(t);
    }

    // Actualiza un técnico
    public void updateTecnico(Tecnico t) {
        Tecnico tecnico = repositoryTecnico.getReferenceById(t.getId());
        tecnico.setIdMaquinaAsignada(t.getIdMaquinaAsignada());
        tecnico.setEstadoVia(t.isEstadoVia());
        tecnico.setAlimentacionOk(t.isAlimentacionOk());
        repositoryTecnico.save(tecnico);
    }

    // Elimina un técnico
    public void removeTecnico(Tecnico t) {
        repositoryTecnico.delete(t);
    }

    // Elimina un técnico por ID
    public void removeTecnicoID(String id) {
        repositoryTecnico.deleteById(id);
    }
}
