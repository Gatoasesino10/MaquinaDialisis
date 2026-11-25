package com.M.Dialisis.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaquinaDialisisService {

    @Autowired
    RepositoryMaquinaDialisis repositoryMaquinaDialisis;

    public List<MaquinaDialisis> getAllMaquinasDialisis() {
        return repositoryMaquinaDialisis.findAll();
    }

    public MaquinaDialisis getMaquinaDialisis(String id) {
        return repositoryMaquinaDialisis.getReferenceById(id);
    }

    public MaquinaDialisis addMaquinaDialisis(MaquinaDialisis m) {
        return repositoryMaquinaDialisis.saveAndFlush(m);
    }

    public void updateMaquinaDialisis(MaquinaDialisis m) {
        MaquinaDialisis maquina = repositoryMaquinaDialisis.getReferenceById(m.getId());
        maquina.setEstadoVia(m.isEstadoVia());
        maquina.setAlimentacionOk(m.isAlimentacionOk());
        maquina.setNivelAgua(m.getNivelAgua());
        maquina.setTemperatura(m.getTemperatura());
        maquina.setFlujoSanguineo(m.getFlujoSanguineo());
        maquina.setAireDetectado(m.isAireDetectado());
        maquina.setEnFuncionamiento(m.isEnFuncionamiento());
        repositoryMaquinaDialisis.save(maquina);
    }

    public void removeMaquinaDialisis(MaquinaDialisis m) {
        repositoryMaquinaDialisis.delete(m);
    }

    public void removeMaquinaDialisisID(String id) {
        repositoryMaquinaDialisis.deleteById(id);
    }
}