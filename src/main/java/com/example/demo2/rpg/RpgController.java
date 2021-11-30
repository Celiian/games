package com.example.demo2.rpg;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static com.example.demo2.rpg.GameFunctions.*;


public class RpgController implements Initializable {
    @FXML
    private AnchorPane anchorGestion;

    @FXML
    private Button btnCombatHeros;

    @FXML
    private Button btnGestionHeros;

    @FXML
    private Button btnSauvegardeHero;

    @FXML
    private HBox hboxCombatHero;

    @FXML
    private HBox hboxHistoriqueHero;

    @FXML
    private HBox hboxModifierHero;

    @FXML
    private HBox hboxRecruterHero;

    @FXML
    private HBox hboxRetourMenu;

    @FXML
    private HBox hboxRetourMenu1;

    @FXML
    private HBox hboxSupprimerHero;

    @FXML
    private VBox pageGestion;

    @FXML
    private VBox pageCombat;

    @FXML
    private VBox vboxAjouterHero;

    @FXML
    private VBox vboxCombatHero;

    @FXML
    private VBox vboxGlobal;

    @FXML
    private VBox vboxInclude;

    @FXML
    private VBox vboxMenu;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        vboxInclude.getChildren().removeAll(pageGestion, pageCombat);

        //______________________________________________________________
        //BOUTONS DE GESTION ENTRE LE MENU ET LES DIFFERENTES PAGES DU JEU
        btnGestionHeros.setOnMouseClicked(action -> {
            vboxGlobal.getChildren().removeAll(vboxMenu);
            vboxInclude.getChildren().removeAll(pageGestion, pageCombat);
            vboxInclude.getChildren().add(pageGestion);
        });

        btnCombatHeros.setOnMouseClicked(action -> {
            vboxGlobal.getChildren().removeAll(vboxMenu);
            vboxInclude.getChildren().removeAll(pageGestion, pageCombat);
            vboxInclude.getChildren().add(pageCombat);
        });

        hboxRetourMenu.setOnMouseClicked(action -> {
            vboxGlobal.getChildren().add(vboxMenu);
            vboxInclude.getChildren().removeAll(pageGestion, pageCombat);
        });

        hboxRetourMenu1.setOnMouseClicked(action -> {
            vboxGlobal.getChildren().add(vboxMenu);
            vboxInclude.getChildren().removeAll(pageGestion, pageCombat);
        });

        hboxModifierHero.setOnMouseClicked(action -> {
            System.out.println(RpgAdditionHeroController.returnHeroList());
        });


    }

}
