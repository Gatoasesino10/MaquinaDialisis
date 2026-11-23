package com.M.Dialisis.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity

public class Paciente {

    @Id
    private String dni; // Clave primaria 

    private float pesoSeco;
    private float peso;
    private float altura;
    private int edad;
    private String sexo;

    // Atributos de estado usados en PacienteController
    private String rutinaActual; // "RAPIDO" o "LENTO" (ModoEnum)
    private boolean dialisisEnCurso;

   


    // Getters y Setters
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public float getPesoSeco() {
        return pesoSeco;
    }

    public void setPesoSeco(float pesoSeco) {
        this.pesoSeco = pesoSeco;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getRutinaActual() {
        return rutinaActual;
    }

    public void setRutinaActual(String rutinaActual) {
        this.rutinaActual = rutinaActual;
    }

    public boolean isDialisisEnCurso() {
        return dialisisEnCurso;
    }

    public void setDialisisEnCurso(boolean dialisisEnCurso) {
        this.dialisisEnCurso = dialisisEnCurso;
    }
}