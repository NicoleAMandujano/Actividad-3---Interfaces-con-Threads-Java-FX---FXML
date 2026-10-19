/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.niki.conteo;

import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;

public class Espera implements Runnable {

    private ProgressBar barra;
    private Button boton;

    public Espera(ProgressBar barra, Button boton) {
        this.barra = barra;
        this.boton = boton;
    }

    @Override
    public void run() {

        for (int i = 1; i <= 100; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                return;
            }

            final double avance = i / 100.0;

            Platform.runLater(() -> barra.setProgress(avance));
        }

        
        Platform.runLater(() -> boton.setDisable(false));
    }
}
