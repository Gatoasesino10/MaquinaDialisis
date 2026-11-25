package com.M.Dialisis.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Historial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSesion;

    private String fecha;
    private int duracion;
    private String graficasEvolucion;
    private String responsableInterrupcion;

    @ManyToOne
    private Paciente paciente;

    @ManyToOne
    private MaquinaDialisis maquinaDialisis;

    public Historial() {
    }

    public Historial(String fecha, int duracion, String graficasEvolucion, String responsableInterrupcion) {
        this.fecha = fecha;
        this.duracion = duracion;
        this.graficasEvolucion = graficasEvolucion;
        this.responsableInterrupcion = responsableInterrupcion;
    }

    public Long getIdSesion() { return idSesion; }
    public void setIdSesion(Long idSesion) { this.idSesion = idSesion; }

    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }

    public int getDuracion() { return duracion; }
    public void setDuracion(int duracion) { this.duracion = duracion; }

    public String getGraficasEvolucion() { return graficasEvolucion; }
    public void setGraficasEvolucion(String graficasEvolucion) { this.graficasEvolucion = graficasEvolucion; }

    public String getResponsableInterrupcion() { return responsableInterrupcion; }
    public void setResponsableInterrupcion(String responsableInterrupcion) { this.responsableInterrupcion = responsableInterrupcion; }

    public Paciente getPaciente() { return paciente; }
    public void setPaciente(Paciente paciente) { this.paciente = paciente; }

    public MaquinaDialisis getMaquinaDialisis() { return maquinaDialisis; }
    public void setMaquinaDialisis(MaquinaDialisis maquinaDialisis) { this.maquinaDialisis = maquinaDialisis; }
}