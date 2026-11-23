package com.M.Dialisis.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistorialService {

    @Autowired
    RepositoryHistorial repositoryHistorial;

    // Devuelve todos los registros del historial
    public List<Historial> getAllHistoriales() {
        return repositoryHistorial.findAll();
    }

    // Devuelve un registro del historial por ID
    public Historial getHistorial(Long id) {
        return repositoryHistorial.getReferenceById(id);
    }

    // Crea un registro en el historial
    public Historial addHistorial(Historial h) {
        return repositoryHistorial.saveAndFlush(h);
    }

    // Actualiza un registro del historial
    public void updateHistorial(Historial h) {
        Historial historial = repositoryHistorial.getReferenceById(h.getIdSesion());
        historial.setFecha(h.getFecha());
        historial.setDuracion(h.getDuracion());
        historial.setGraficasEvolucion(h.getGraficasEvolucion());
        historial.setResponsableInterrupcion(h.getResponsableInterrupcion());
        repositoryHistorial.save(historial);
    }

    // Elimina un registro del historial
    public void removeHistorial(Historial h) {
        repositoryHistorial.delete(h);
    }

    // Elimina un registro del historial por ID
    public void removeHistorialID(Long id) {
        repositoryHistorial.deleteById(id);
    }
}
