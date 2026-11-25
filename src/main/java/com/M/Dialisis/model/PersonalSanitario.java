package com.M.Dialisis.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class PersonalSanitario {

    @Id
    private String id; 

    private float ultimaTemperatura;
    private boolean aireDetectado;
    private boolean dialisisActiva;
    private boolean ambulanciaEnCamino;

    @OneToMany
    private List<Paciente> pacientes;

    @OneToMany
    private List<MaquinaDialisis> maquinas;

    public PersonalSanitario() {
    }

    public PersonalSanitario(String id, float ultimaTemperatura, boolean aireDetectado,
                             boolean dialisisActiva, boolean ambulanciaEnCamino) {
        this.id = id;
        this.ultimaTemperatura = ultimaTemperatura;
        this.aireDetectado = aireDetectado;
        this.dialisisActiva = dialisisActiva;
        this.ambulanciaEnCamino = ambulanciaEnCamino;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public float getUltimaTemperatura() { return ultimaTemperatura; }
    public void setUltimaTemperatura(float ultimaTemperatura) { this.ultimaTemperatura = ultimaTemperatura; }

    public boolean isAireDetectado() { return aireDetectado; }
    public void setAireDetectado(boolean aireDetectado) { this.aireDetectado = aireDetectado; }

    public boolean isDialisisActiva() { return dialisisActiva; }
    public void setDialisisActiva(boolean dialisisActiva) { this.dialisisActiva = dialisisActiva; }

    public boolean isAmbulanciaEnCamino() { return ambulanciaEnCamino; }
    public void setAmbulanciaEnCamino(boolean ambulanciaEnCamino) { this.ambulanciaEnCamino = ambulanciaEnCamino; }

    public List<Paciente> getPacientes() { return pacientes; }
    public void setPacientes(List<Paciente> pacientes) { this.pacientes = pacientes; }

    public List<MaquinaDialisis> getMaquinas() { return maquinas; }
    public void setMaquinas(List<MaquinaDialisis> maquinas) { this.maquinas = maquinas; }
}