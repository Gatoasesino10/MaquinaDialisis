package com.M.Dialisis.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TecnicoService {

    @Autowired
    RepositoryTecnico repositoryTecnico;

    public List<Tecnico> getAllTecnicos() {
        return repositoryTecnico.findAll();
    }

    public Tecnico getTecnico(String id) {
        return repositoryTecnico.getReferenceById(id);
    }

    public Tecnico addTecnico(Tecnico t) {
        return repositoryTecnico.saveAndFlush(t);
    }

    public void updateTecnico(Tecnico t) {
        Tecnico tecnico = repositoryTecnico.getReferenceById(t.getId());
        tecnico.setIdMaquinaAsignada(t.getIdMaquinaAsignada());
        tecnico.setEstadoVia(t.isEstadoVia());
        tecnico.setAlimentacionOk(t.isAlimentacionOk());
        repositoryTecnico.save(tecnico);
    }

    public void removeTecnico(Tecnico t) {
        repositoryTecnico.delete(t);
    }

    public void removeTecnicoID(String id) {
        repositoryTecnico.deleteById(id);
    }
}
