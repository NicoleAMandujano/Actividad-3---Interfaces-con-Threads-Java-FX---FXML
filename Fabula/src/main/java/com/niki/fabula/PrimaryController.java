package com.niki.fabula;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class PrimaryController implements Meta {

    @FXML private Button btnIniciar;
    @FXML private Label lblLiebre;
    @FXML private Label lblTortuga;
    @FXML private Label lblGanador;
    @FXML private ProgressBar barraLiebre;
    @FXML private ProgressBar barraTortuga;

    private List<Corredor> corredores = new ArrayList<>();
    private int llegaron = 0;
    private String ganador = null;

    @FXML
    private void iniciar(ActionEvent event) {
        btnIniciar.setDisable(true);
        lblGanador.setText("");
        barraLiebre.setProgress(0);
        barraTortuga.setProgress(0);
        llegaron = 0;
        ganador = null;

        corredores.clear();
        corredores.add(new Liebre(barraLiebre, lblLiebre, this));
        corredores.add(new Tortuga(barraTortuga, lblTortuga, this));

        for (Corredor c : corredores) {
            c.start();
        }
    }

    @Override
    public synchronized void llegada(Corredor corredor) {
        llegaron++;

        if (ganador == null) {
            ganador = corredor.getNombre();
            final String texto = "¡Ganó " + ganador + "!";
            Platform.runLater(() -> lblGanador.setText(texto));
        }

        if (llegaron == corredores.size()) {
            Platform.runLater(() -> btnIniciar.setDisable(false));
        }
    }
}