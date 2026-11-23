package com.M.Dialisis.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Tecnico {

    @Id
    private String id; // Clave primaria según el diagrama de clases (+ id: String)

    // Atributos de estado de revisión usados en TecnicoController
    private String idMaquinaAsignada;
    private boolean estadoVia;
    private boolean alimentacionOk;


    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdMaquinaAsignada() {
        return idMaquinaAsignada;
    }

    public void setIdMaquinaAsignada(String idMaquinaAsignada) {
        this.idMaquinaAsignada = idMaquinaAsignada;
    }

    public boolean isEstadoVia() {
        return estadoVia;
    }

    public void setEstadoVia(boolean estadoVia) {
        this.estadoVia = estadoVia;
    }

    public boolean isAlimentacionOk() {
        return alimentacionOk;
    }

    public void setAlimentacionOk(boolean alimentacionOk) {
        this.alimentacionOk = alimentacionOk;
    }
}
