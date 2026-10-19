/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.niki.fabula;

import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class Tortuga extends Corredor {

    public Tortuga(ProgressBar barra, Label etiqueta, Meta meta) {
        super("La Tortuga", barra, etiqueta, meta);
    }

    @Override
    protected double getAvance() {
        return 0.01; 
    }
}