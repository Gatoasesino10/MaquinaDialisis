package com.M.Dialisis.model; // <-- Cámbialo a com.M.Dialisis.model si lo guardas en esa carpeta

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {

    @Autowired
    RepositoryPaciente repositoryPaciente;

    // Devuelve todos los pacientes
    public List<Paciente> getAllPacientes() {
        return repositoryPaciente.findAll();
    }

    // Devuelve un paciente por DNI (ID)
    public Paciente getPaciente(String dni) {
        return repositoryPaciente.getReferenceById(dni);
    }

    // Crea un paciente
    public Paciente addPaciente(Paciente p) {
        return repositoryPaciente.saveAndFlush(p);
    }

    // Actualiza un paciente
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

    // Elimina un paciente
    public void removePaciente(Paciente p) {
        repositoryPaciente.delete(p);
    }

    // Elimina un paciente por DNI (ID)
    public void removePacienteID(String dni) {
        repositoryPaciente.deleteById(dni);
    }
}