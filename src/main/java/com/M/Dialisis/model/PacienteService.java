package com.M.Dialisis.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {

    @Autowired
    RepositoryPaciente repositoryPaciente;

    public List<Paciente> getAllPacientes() {
        return repositoryPaciente.findAll();
    }

    public Paciente getPaciente(String dni) {
        return repositoryPaciente.getReferenceById(dni);
    }

    public Paciente addPaciente(Paciente p) {
        return repositoryPaciente.saveAndFlush(p);
    }

    public void updatePaciente(Paciente p) {
        Paciente paciente = repositoryPaciente.getReferenceById(p.getDni());
        paciente.setPesoSeco(p.getPesoSeco());
        paciente.setPeso(p.getPeso());
        paciente.setAltura(p.getAltura());
        paciente.setEdad(p.getEdad());
        paciente.setSexo(p.getSexo());
        paciente.setRutinaActual(p.getRutinaActual());
        paciente.setDialisisEnCurso(p.isDialisisEnCurso());
        repositoryPaciente.save(paciente);
    }

    public void removePaciente(Paciente p) {
        repositoryPaciente.delete(p);
    }

    public void removePacienteID(String dni) {
        repositoryPaciente.deleteById(dni);
    }
}