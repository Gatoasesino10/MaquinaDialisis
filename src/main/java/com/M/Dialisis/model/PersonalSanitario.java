package com.M.Dialisis.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity

public class PersonalSanitario {

    @Id
    private String id; // Clave primaria según el diagrama de clases (+ id: String)

    // Atributos de estado clínico monitorizados en PersonalSanitarioController
    private float ultimaTemperatura;
    private boolean aireDetectado;
    private boolean dialisisActiva;
    private boolean ambulanciaEnCamino;

    

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getUltimaTemperatura() {
        return ultimaTemperatura;
    }

    public void setUltimaTemperatura(float ultimaTemperatura) {
        this.ultimaTemperatura = ultimaTemperatura;
    }

    public boolean isAireDetectado() {
        return aireDetectado;
    }

    public void setAireDetectado(boolean aireDetectado) {
        this.aireDetectado = aireDetectado;
    }

    public boolean isDialisisActiva() {
        return dialisisActiva;
    }

    public void setDialisisActiva(boolean dialisisActiva) {
        this.dialisisActiva = dialisisActiva;
    }

    public boolean isAmbulanciaEnCamino() {
        return ambulanciaEnCamino;
    }

    public void setAmbulanciaEnCamino(boolean ambulanciaEnCamino) {
        this.ambulanciaEnCamino = ambulanciaEnCamino;
    }
}
