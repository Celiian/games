package com.example.demo2.rpg;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class gestionHeroController implements Initializable {

    @FXML
    private Button btnAjouterGuerrier;

    @FXML
    private Button btnAjouterMage;

    @FXML
    private Button btnAjouterNeutre;

    @FXML
    private Button btnAjouterSorciere;

    @FXML
    private Button btnAjouterVoleur;

    @FXML
    private HBox hboxModifierHero;

    @FXML
    private HBox hboxRecruterHero;

    @FXML
    private HBox hboxRetourMenu;

    @FXML
    private HBox hboxSupprimerHero;

    @FXML
    private VBox vboxCreationhero;

    @FXML
    private VBox vboxMaineGestionHero;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
