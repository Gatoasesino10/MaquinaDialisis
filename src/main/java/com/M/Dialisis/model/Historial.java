package com.M.Dialisis.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Historial {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idSesion; // Clave primaria autogenerada por H2 (en el diagrama: idSesion)

    private String fecha;
    private int duracion;
    private String graficasEvolucion;
    private String responsableInterrupcion;

  
    // Getters y Setters
    public Long getIdSesion() {
        return idSesion;
    }

    public void setIdSesion(Long idSesion) {
        this.idSesion = idSesion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getGraficasEvolucion() {
        return graficasEvolucion;
    }

    public void setGraficasEvolucion(String graficasEvolucion) {
        this.graficasEvolucion = graficasEvolucion;
    }

    public String getResponsableInterrupcion() {
        return responsableInterrupcion;
    }

    public void setResponsableInterrupcion(String responsableInterrupcion) {
        this.responsableInterrupcion = responsableInterrupcion;
    }
} 
