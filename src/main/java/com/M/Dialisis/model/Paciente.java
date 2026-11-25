package com.M.Dialisis.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Paciente {

    @Id
    private String dni; 

    private float pesoSeco;
    private float peso;
    private float altura;
    private int edad;
    private String sexo;
    private String rutinaActual; 
    private boolean dialisisEnCurso;

    @OneToMany
    private List<Historial> historiales;

    @ManyToOne
    private PersonalSanitario personalSanitario;

    public Paciente() {
    }

    public Paciente(String dni, float pesoSeco, float peso, float altura, int edad, String sexo,
                    String rutinaActual, boolean dialisisEnCurso) {
        this.dni = dni;
        this.pesoSeco = pesoSeco;
        this.peso = peso;
        this.altura = altura;
        this.edad = edad;
        this.sexo = sexo;
        this.rutinaActual = rutinaActual;
        this.dialisisEnCurso = dialisisEnCurso;
    }

    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public float getPesoSeco() { return pesoSeco; }
    public void setPesoSeco(float pesoSeco) { this.pesoSeco = pesoSeco; }

    public float getPeso() { return peso; }
    public void setPeso(float peso) { this.peso = peso; }

    public float getAltura() { return altura; }
    public void setAltura(float altura) { this.altura = altura; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    public String getSexo() { return sexo; }
    public void setSexo(String sexo) { this.sexo = sexo; }

    public String getRutinaActual() { return rutinaActual; }
    public void setRutinaActual(String rutinaActual) { this.rutinaActual = rutinaActual; }

    public boolean isDialisisEnCurso() { return dialisisEnCurso; }
    public void setDialisisEnCurso(boolean dialisisEnCurso) { this.dialisisEnCurso = dialisisEnCurso; }

    public List<Historial> getHistoriales() { return historiales; }
    public void setHistoriales(List<Historial> historiales) { this.historiales = historiales; }

    public PersonalSanitario getPersonalSanitario() { return personalSanitario; }
    public void setPersonalSanitario(PersonalSanitario personalSanitario) { this.personalSanitario = personalSanitario; }
}