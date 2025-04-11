package com.example.aplicacionpoonombreestudiante;

public class PersonaIMC {
    private String nombre; private double peso; private double altura;
    private String genero;
    private String ciudad;
    public PersonaIMC(String nombre, double peso, double altura, String genero, String ciudad) {
        this.nombre = nombre;
        this.peso = peso;
        this.altura = altura;
        this.genero = genero;
        this.ciudad = ciudad;
    }
    public double calcularIMC() {
        return peso / (altura * altura);
    }
    public String getResumen() {
        return nombre + " (" + genero + ") - " + ciudad + "\nIMC: " + String.format("%.2f", calcularIMC());
    }
}

