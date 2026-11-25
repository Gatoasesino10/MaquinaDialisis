package com.M.Dialisis.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Tecnico {

    @Id
    private String id; 

    private String idMaquinaAsignada;
    private boolean estadoVia;
    private boolean alimentacionOk;

    // Relación 1:n (como en la diapositiva 35: Libreria -> List<Libro>)
    @OneToMany
    private List<MaquinaDialisis> maquinas;

    // Constructor vacío obligatorio para JPA / H2
    public Tecnico() {
    }

    // Constructor con atributos básicos
    public Tecnico(String id, String idMaquinaAsignada, boolean estadoVia, boolean alimentacionOk) {
        this.id = id;
        this.idMaquinaAsignada = idMaquinaAsignada;
        this.estadoVia = estadoVia;
        this.alimentacionOk = alimentacionOk;
    }

    // Getters y Setters de atributos
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getIdMaquinaAsignada() { return idMaquinaAsignada; }
    public void setIdMaquinaAsignada(String idMaquinaAsignada) { this.idMaquinaAsignada = idMaquinaAsignada; }

    public boolean isEstadoVia() { return estadoVia; }
    public void setEstadoVia(boolean estadoVia) { this.estadoVia = estadoVia; }

    public boolean isAlimentacionOk() { return alimentacionOk; }
    public void setAlimentacionOk(boolean alimentacionOk) { this.alimentacionOk = alimentacionOk; }

    // Getter y Setter de la relación
    public List<MaquinaDialisis> getMaquinas() { return maquinas; }
    public void setMaquinas(List<MaquinaDialisis> maquinas) { this.maquinas = maquinas; }
}