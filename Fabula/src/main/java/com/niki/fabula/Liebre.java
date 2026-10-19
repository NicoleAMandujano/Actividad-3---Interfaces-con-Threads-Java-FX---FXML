/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.niki.fabula;

import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class Liebre extends Corredor {

    private boolean yaDurmio = false;

    public Liebre(ProgressBar barra, Label etiqueta, Meta meta) {
        super("La Liebre", barra, etiqueta, meta);
    }

    @Override
    protected double getAvance() {
        return 0.04; 
    }

    @Override
    protected void despuesDeAvanzar() {
        if (!yaDurmio && progreso >= 0.5) {
            yaDurmio = true;
            mostrarEstado("¡Se durmió!");
            dormir(9000); 
            mostrarEstado("¡Despertó y está corriendo!");
        }
    }
}