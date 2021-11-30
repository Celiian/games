package com.example.demo2.rpg;

import com.example.demo2.rpg.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Timer;

import static com.example.demo2.rpg.GameFunctions.creationPersonnage;

public class RpgAdditionHeroController implements Initializable {

    @FXML
    private Button btnAjouterGuerrier;

    @FXML
    private Button btnAjouterNeutre;

    @FXML
    private Button btnAjouterSorciere;

    @FXML
    private Button btnAjouterVoleur;

    @FXML
    private Label labelNombreGuerrier;

    @FXML
    private Label labelNombreNeutre;

    @FXML
    private Label labelNombreSorciere;

    @FXML
    private Label labelNombreVoleur;

    @FXML
    private VBox vboxCreationhero;

    @FXML
    private VBox vboxRecruterHero;

    @FXML
    private TextField textFieldGuerrier;

    @FXML
    private TextField textFieldNeutre;

    @FXML
    private TextField textFieldSorciere;

    @FXML
    private TextField textFieldVoleur;

    @FXML
    private Button btnRafraichir;

    static ArrayList<Archetypes> heroList = new ArrayList<Archetypes>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        btnAjouterGuerrier.setOnMouseClicked(action -> {
            Warrior guerrier;
            if (!textFieldGuerrier.getText().equals("")){
                guerrier = (Warrior) creationPersonnage("guerrier", textFieldGuerrier.getText());
            }
            else {
                guerrier = (Warrior) creationPersonnage("guerrier");

            }
            heroList.add(guerrier);
            labelNombreGuerrier.setText(String.valueOf(Integer.parseInt(labelNombreGuerrier.getText()) + 1));
        });

        btnAjouterNeutre.setOnMouseClicked(action -> {
            Neutral neutre;
            if (!textFieldNeutre.getText().equals("")){
                neutre = (Neutral) creationPersonnage("neutre", textFieldNeutre.getText());
            }
            else {
                neutre = (Neutral) creationPersonnage("neutre");

            }
            heroList.add(neutre);
            labelNombreNeutre.setText(String.valueOf(Integer.parseInt(labelNombreNeutre.getText()) + 1));
        });

        btnAjouterSorciere.setOnMouseClicked(action -> {
            Witch sorciere;
            if (!textFieldSorciere.getText().equals("")){
                sorciere = (Witch) creationPersonnage("sorciere", textFieldSorciere.getText());
            }
            else {
                sorciere = (Witch) creationPersonnage("sorciere");

            }            heroList.add(sorciere);
            labelNombreSorciere.setText(String.valueOf(Integer.parseInt(labelNombreSorciere.getText()) + 1));
        });

        btnAjouterVoleur.setOnMouseClicked(action -> {
            Thief voleur;
            if (!textFieldVoleur.getText().equals("")){
                voleur = (Thief) creationPersonnage("voleur", textFieldVoleur.getText());
            }
            else {
                voleur = (Thief) creationPersonnage("voleur");

            }            heroList.add(voleur);
            labelNombreVoleur.setText(String.valueOf(Integer.parseInt(labelNombreVoleur.getText()) + 1));
        });

        btnRafraichir.setOnMouseClicked(action -> {
            int nbVoleur = 0;
            int nbGuerrier = 0;
            int nbSorciere = 0;
            int nbNeutral = 0;
            for (int i = 0; i < heroList.size(); i++) {
                if (heroList.get(i).getClassName().equals("voleur")) {
                    nbVoleur++;
                }
                if (heroList.get(i).getClassName().equals("guerrier")) {
                    nbGuerrier++;
                }
                if (heroList.get(i).getClassName().equals("sorciere")) {
                    nbSorciere++;
                }
                if (heroList.get(i).getClassName().equals("neutre")) {
                    nbNeutral++;
                }
            }

            labelNombreGuerrier.setText(String.valueOf(nbGuerrier));
            labelNombreNeutre.setText(String.valueOf(nbNeutral));
            labelNombreSorciere.setText(String.valueOf(nbSorciere));
            labelNombreVoleur.setText(String.valueOf(nbVoleur));
        });
    }

    public static ArrayList<Archetypes> returnHeroList(){
        return heroList;
    }

    public static void setHeroList(ArrayList<Archetypes> heroListModified){heroList = heroListModified;}
}
