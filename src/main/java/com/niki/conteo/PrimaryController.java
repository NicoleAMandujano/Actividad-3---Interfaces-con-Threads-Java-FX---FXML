package com.niki.conteo;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML private TextField txtClics;
    @FXML private Button btnEsperar;
    @FXML private ProgressBar barraProgreso;

    private int clics = 0;

    @FXML
    private void contar(ActionEvent event) {
        clics++;
        txtClics.setText(String.valueOf(clics));
    }

    @FXML
    private void esperar(ActionEvent event) {
        btnEsperar.setDisable(true);   
        barraProgreso.setProgress(0); 


       Espera espera = new Espera(barraProgreso, btnEsperar);
        Thread hilo = new Thread(espera);
        hilo.setDaemon(true); 
        hilo.start();      
        
    }
}

