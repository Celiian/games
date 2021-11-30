package com.example.demo2.rpg;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import static com.example.demo2.rpg.GameFunctions.creationPersonnage;

public class RpgCombatController implements Initializable {

    @FXML
    private VBox boxCombatHero;

    @FXML
    private VBox boxGlobalCombat;

    @FXML
    private VBox boxSelectionHero;

    @FXML
    private Button btnChoisirPremierHero;

    @FXML
    private Button btnChoisirSeconHero;

    @FXML
    private Label labelPremierHero;

    @FXML
    private Label labelSecondHero;

    @FXML
    private Pane paneTree;

    @FXML
    private Pane paneTxtCombat;

    @FXML
    private Button btnValiderHeroCombat;

    @FXML
    private ScrollPane scrollPaneCombat;

    @FXML
    private Button btnContinuerCombat;

    Neutral neutral = new Neutral("Cliquez ici pour raffraichir la liste", 0, 0, 0);
    TreeItem<Archetypes> rootItem = new TreeItem<Archetypes>(neutral);
    TreeView<Archetypes> tree = new TreeView<Archetypes>(rootItem);
    VBox vboxTxtCombat = new VBox();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        paneTxtCombat.getChildren().add(vboxTxtCombat);

        Map<String, Archetypes> heroChoice = new HashMap<String, Archetypes>();

        Thief premierVoleur = (Thief) creationPersonnage("voleur", "root");
        Warrior premierGuerrier = (Warrior) creationPersonnage("guerrier", "root");
        Witch premierSorciere = (Witch) creationPersonnage("sorciere", "root");
        Neutral premierNeutral = (Neutral) creationPersonnage("neutral", "root");

        TreeItem<Archetypes> rootVoleur = new TreeItem<Archetypes>(premierVoleur);
        rootVoleur.setExpanded(true);
        TreeItem<Archetypes> rootGuerrier = new TreeItem<Archetypes>(premierGuerrier);
        rootGuerrier.setExpanded(true);
        TreeItem<Archetypes> rootNeutral = new TreeItem<Archetypes>(premierNeutral);
        rootNeutral.setExpanded(true);
        TreeItem<Archetypes> rootSorciere = new TreeItem<Archetypes>(premierSorciere);
        rootSorciere.setExpanded(true);

        rootItem.getChildren().addAll(rootGuerrier, rootVoleur, rootSorciere, rootNeutral);
        paneTree.getChildren().add(tree);


        tree.setOnMouseClicked(action -> {
            if(tree.getSelectionModel().getSelectedItem() == rootItem) {
                paneTree.getChildren().clear();
                paneTree.getChildren().add(tree);
                rootGuerrier.getChildren().clear();
                rootVoleur.getChildren().clear();
                rootNeutral.getChildren().clear();
                rootSorciere.getChildren().clear();
                ArrayList<Archetypes> heroList = RpgAdditionHeroController.returnHeroList();
                for (int i = 0; i < heroList.size(); i++) {
                    if (heroList.get(i).getClassName().equals("voleur")) {
                        TreeItem<Archetypes> voleur = new TreeItem<Archetypes>(heroList.get(i));
                        rootVoleur.getChildren().add(voleur);
                    }
                    if (heroList.get(i).getClassName().equals("guerrier")) {
                        TreeItem<Archetypes> guerrier = new TreeItem<Archetypes>(heroList.get(i));
                        rootGuerrier.getChildren().add(guerrier);
                    }
                    if (heroList.get(i).getClassName().equals("sorciere")) {
                        TreeItem<Archetypes> sorciere = new TreeItem<Archetypes>(heroList.get(i));
                        rootSorciere.getChildren().add(sorciere);
                    }
                    if (heroList.get(i).getClassName().equals("neutre")) {
                        TreeItem<Archetypes> neutre = new TreeItem<Archetypes>(heroList.get(i));
                        rootNeutral.getChildren().add(neutre);
                    }
                }
            }
        });

        btnChoisirPremierHero.setOnMouseClicked(action -> {
            TreeItem<Archetypes> item = tree.getSelectionModel().getSelectedItem();
            if (!item.isExpanded()) {
                Archetypes firstHero = item.getValue();
                labelPremierHero.setText("Le premier hero est : " + firstHero.toString());
                heroChoice.put("firstHero", item.getValue());
            }
        });
        btnChoisirSeconHero.setOnMouseClicked(action -> {
            TreeItem<Archetypes> item = tree.getSelectionModel().getSelectedItem();
            if (!item.isExpanded()){
                Archetypes secondHero = item.getValue();
                labelSecondHero.setText("Le second hero est : " + secondHero.toString());
                heroChoice.put("secondHero", item.getValue());
            }
        });

        btnValiderHeroCombat.setOnMouseClicked(action -> {
            boxGlobalCombat.getChildren().removeAll(boxSelectionHero, boxCombatHero);
            boxGlobalCombat.getChildren().add(boxCombatHero);
            ArrayList<Archetypes> heroList = RpgAdditionHeroController.returnHeroList();
            heroList.remove(fight(heroChoice));

            RpgAdditionHeroController.setHeroList(heroList);
        });

        btnContinuerCombat.setOnMouseClicked(action -> {
            vboxTxtCombat.getChildren().clear();
            boxGlobalCombat.getChildren().removeAll(boxSelectionHero, boxCombatHero);
            boxGlobalCombat.getChildren().add(boxSelectionHero);
        });
    }

    public Archetypes fight(Map heroChoice) {
        Archetypes hero1 = (Archetypes) heroChoice.get("firstHero");
        int hero1Hp = hero1.getHp();
        Archetypes hero2 = (Archetypes) heroChoice.get("secondHero");
        int hero2Hp = hero2.getHp();
        Archetypes hero3;
        int hero3Hp;

        if (((Archetypes) heroChoice.get("firstHero")).getSpeed() < ((Archetypes) heroChoice.get("secondHero")).getSpeed()) {
            hero1 = (Archetypes) heroChoice.get("secondHero");
            hero2 = (Archetypes) heroChoice.get("firstHero");
        }

        int i = 0;
        boolean fightEnded = false;

        Label text = new Label(hero1.getName() + " à " + hero1.getHp() + " pv.");
        vboxTxtCombat.getChildren().add(text);
        Label txt2 = new Label(hero2.getName() + " à " + hero2.getHp() + " pv.");
        vboxTxtCombat.getChildren().add(txt2);

        while (!fightEnded) {
            if (hero1Hp <= 0) {
                Label txt = new Label(hero1.getName() + " est mort !!");
                vboxTxtCombat.getChildren().add(txt);
                return hero1;
            }
            if (hero2Hp <= 0) {
                Label txt = new Label(hero2.getName() + " est mort !!");
                vboxTxtCombat.getChildren().add(txt);
                return hero2;
            }

            hero2Hp = dmg(hero1, hero2, hero2Hp, i);

            hero3 = hero1;
            hero3Hp = hero1Hp;
            hero1 = hero2;
            hero1Hp = hero2Hp;
            hero2 = hero3;
            hero2Hp = hero3Hp;
            i++;

        }
        return null;
    }
    public int dmg(Archetypes hero_atk, Archetypes hero_def, int hero2Hp, int i){
        String effect_done = hero_atk.stateDone();

        int dmg_done = hero_atk.damageDone(i);
        int dmg_taken = hero_def.takenDamage(dmg_done);
        hero2Hp = (hero2Hp - dmg_taken);
        if(!effect_done.equals("")){
            Label txt = new Label(hero_atk.getName() + " a infligé l'effet " + effect_done + " !");
            vboxTxtCombat.getChildren().add(txt);
        }
        else if (dmg_taken == 0){
            Label txt = new Label(hero_def.getName() + " a esquivé l'attaque !");
            vboxTxtCombat.getChildren().add(txt);
        }
        if (dmg_done > hero_atk.getDamage()){
            Label txt = new Label(hero_atk.getName() + " a effectué un coup critique !");
            vboxTxtCombat.getChildren().add(txt);
        }
        hero_def.stateTaken(effect_done);

        if (hero2Hp < 0){
            hero2Hp = 0;
        }

        Text text = new Text(hero_atk.getName() + " à fais " + dmg_taken + " dégats à " + hero_def.getName() + " !");
        vboxTxtCombat.getChildren().add(text);

        if (hero2Hp < 30 && hero2Hp > 0){
            Text txt = new Text(hero_def.getName() + " à " + hero2Hp + " pv il est vraiment proche de la mort !!!");
           vboxTxtCombat.getChildren().add(txt);
        }
        Text txt = new Text(hero_def.getName() + " à " + hero2Hp + " pv restants \n");
        vboxTxtCombat.getChildren().add(txt);

        return hero2Hp;
    }

}
