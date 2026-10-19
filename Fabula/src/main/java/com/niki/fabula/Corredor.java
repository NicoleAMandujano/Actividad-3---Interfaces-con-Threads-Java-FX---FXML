package com.niki.fabula;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public abstract class Corredor extends Thread {

    protected String nombre;
    protected ProgressBar barra;
    protected Label etiqueta;
    protected double progreso = 0;   
    private Meta meta;

    public Corredor(String nombre, ProgressBar barra, Label etiqueta, Meta meta) {
        this.nombre = nombre;
        this.barra = barra;
        this.etiqueta = etiqueta;
        this.meta = meta;
        setDaemon(true); 
    }

    protected abstract double getAvance();

    protected void despuesDeAvanzar() {
    }

    public String getNombre() {
        return nombre;
    }

    protected void mostrarEstado(String estado) {
        Platform.runLater(() -> etiqueta.setText(nombre + ": " + estado));
    }

    protected void dormir(int milisegundos) {
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
        }
    }

    @Override
    public void run() {
        mostrarEstado("¡Está corriendo!");

        while (progreso < 1.0) {
            progreso = progreso + getAvance();
            if (progreso > 1.0) {
                progreso = 1.0;
            }

            final double valor = progreso;
            Platform.runLater(() -> barra.setProgress(valor));

            despuesDeAvanzar();
            dormir(100); 
        }

        mostrarEstado("¡Llegó a la meta!");
        meta.llegada(this); 
    }
}
