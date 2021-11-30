package com.example.demo2;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable{
    @FXML
    private VBox global;

    @FXML
    private Label hboxRpg;

    @FXML
    private HBox hboxMorpion;

    @FXML
    private VBox vboxRpg;

    @FXML
    private VBox vboxMorpion;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        global.getChildren().removeAll(vboxMorpion, vboxRpg);

        hboxRpg.setOnMouseClicked(action -> {
            global.getChildren().removeAll(vboxMorpion, vboxRpg);
            global.getChildren().add(vboxRpg);
        });

        hboxMorpion.setOnMouseClicked(action -> {
            global.getChildren().removeAll(vboxMorpion, vboxRpg);
            global.getChildren().add(vboxMorpion);

        });

    }
}