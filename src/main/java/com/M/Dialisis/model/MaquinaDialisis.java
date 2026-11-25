package com.M.Dialisis.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class MaquinaDialisis {

    @Id
    private String id;

    private boolean estadoVia;
    private boolean alimentacionOk;
    private int nivelAgua;
    private float temperatura;
    private int flujoSanguineo;
    private boolean aireDetectado;
    private boolean enFuncionamiento;

    @OneToOne
    private Paciente paciente;

    @ManyToOne
    private PersonalSanitario personalSanitario;

    @ManyToOne
    private Tecnico tecnico;

    @OneToMany
    private List<Historial> historiales;

    public MaquinaDialisis() {
    }

    public MaquinaDialisis(String id, boolean estadoVia, boolean alimentacionOk, int nivelAgua,
                           float temperatura, int flujoSanguineo, boolean aireDetectado, boolean enFuncionamiento) {
        this.id = id;
        this.estadoVia = estadoVia;
        this.alimentacionOk = alimentacionOk;
        this.nivelAgua = nivelAgua;
        this.temperatura = temperatura;
        this.flujoSanguineo = flujoSanguineo;
        this.aireDetectado = aireDetectado;
        this.enFuncionamiento = enFuncionamiento;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public boolean isEstadoVia() { return estadoVia; }
    public void setEstadoVia(boolean estadoVia) { this.estadoVia = estadoVia; }

    public boolean isAlimentacionOk() { return alimentacionOk; }
    public void setAlimentacionOk(boolean alimentacionOk) { this.alimentacionOk = alimentacionOk; }

    public int getNivelAgua() { return nivelAgua; }
    public void setNivelAgua(int nivelAgua) { this.nivelAgua = nivelAgua; }

    public float getTemperatura() { return temperatura; }
    public void setTemperatura(float temperatura) { this.temperatura = temperatura; }

    public int getFlujoSanguineo() { return flujoSanguineo; }
    public void setFlujoSanguineo(int flujoSanguineo) { this.flujoSanguineo = flujoSanguineo; }

    public boolean isAireDetectado() { return aireDetectado; }
    public void setAireDetectado(boolean aireDetectado) { this.aireDetectado = aireDetectado; }

    public boolean isEnFuncionamiento() { return enFuncionamiento; }
    public void setEnFuncionamiento(boolean enFuncionamiento) { this.enFuncionamiento = enFuncionamiento; }

    public Paciente getPaciente() { return paciente; }
    public void setPaciente(Paciente paciente) { this.paciente = paciente; }

    public PersonalSanitario getPersonalSanitario() { return personalSanitario; }
    public void setPersonalSanitario(PersonalSanitario personalSanitario) { this.personalSanitario = personalSanitario; }

    public Tecnico getTecnico() { return tecnico; }
    public void setTecnico(Tecnico tecnico) { this.tecnico = tecnico; }

    public List<Historial> getHistoriales() { return historiales; }
    public void setHistoriales(List<Historial> historiales) { this.historiales = historiales; }
}