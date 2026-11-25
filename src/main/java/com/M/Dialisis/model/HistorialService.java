package com.M.Dialisis.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistorialService {

    @Autowired
    RepositoryHistorial repositoryHistorial;

    public List<Historial> getAllHistoriales() {
        return repositoryHistorial.findAll();
    }

    public Historial getHistorial(Long id) {
        return repositoryHistorial.getReferenceById(id);
    }

    public Historial addHistorial(Historial h) {
        return repositoryHistorial.saveAndFlush(h);
    }

    public void updateHistorial(Historial h) {
        Historial historial = repositoryHistorial.getReferenceById(h.getIdSesion());
        historial.setFecha(h.getFecha());
        historial.setDuracion(h.getDuracion());
        historial.setGraficasEvolucion(h.getGraficasEvolucion());
        historial.setResponsableInterrupcion(h.getResponsableInterrupcion());
        repositoryHistorial.save(historial);
    }

    public void removeHistorial(Historial h) {
        repositoryHistorial.delete(h);
    }

    public void removeHistorialID(Long id) {
        repositoryHistorial.deleteById(id);
    }
}
