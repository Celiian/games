package com.example.demo2.rpg;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;


public class RpgController implements Initializable {

    @FXML
    private Button btnCombatHeros;

    @FXML
    private Button btnGestionHeros;

    @FXML
    private Button btnSauvegardeHero;

    @FXML
    private VBox vboxInclude;

    @FXML
    private VBox pageGestion;

    @FXML
    private VBox vboxMenu;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        vboxInclude.getChildren().remove(pageGestion);

        btnGestionHeros.setOnMouseClicked(action -> {
            vboxMenu.setVisible(false);
            vboxInclude.getChildren().add(pageGestion);
        });

        btnCombatHeros.setOnMouseClicked(action -> {
            vboxMenu.setVisible(false);
            vboxInclude.getChildren().removeAll(pageGestion);
        });

        btnSauvegardeHero.setOnMouseClicked(action -> {
            vboxMenu.setVisible(false);
            vboxInclude.getChildren().removeAll(pageGestion);
        });



    }
}
