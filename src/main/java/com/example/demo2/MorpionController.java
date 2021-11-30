package com.example.demo2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class MorpionController implements Initializable {

    @FXML
    private Button btn_1;

    @FXML
    private Button btn_2;

    @FXML
    private Button btn_3;

    @FXML
    private Button btn_4;

    @FXML
    private Button btn_5;

    @FXML
    private Button btn_6;

    @FXML
    private Button btn_7;

    @FXML
    private Button btn_8;

    @FXML
    private Button btn_9;

    @FXML
    private Button restart;

    @FXML
    private Text Player_Name_Turn;

    @FXML
    private Text winnerText;

    @FXML
    private TextField historic_title;

    @FXML
    private VBox Vbox_historic;

    @FXML
    private TextField historic_Score;

    @FXML
    private TextArea historic;

    @FXML
    private Button historic_button;

    private int score_0 = 0;
    private int score_X = 0;
    private int playerTurn = 0;

    ArrayList<Button> buttons;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        buttons = new ArrayList<>(Arrays.asList(btn_1,btn_2,btn_3,btn_4,btn_5,btn_6,btn_7,btn_8,btn_9));

        buttons.forEach(button ->{
            button_action(button);
            button.setFocusTraversable(false);
        });
        Vbox_historic.getChildren().removeAll(historic_title ,historic_Score, historic);
        historic_button.setOnMouseClicked(affiche_historic ->{
            Vbox_historic.getChildren().addAll(historic_title ,historic_Score ,historic);
        });
    }

    private void button_action(Button button) {
        button.setOnMouseClicked(mouseEvent -> {
            choice_player(button);
            button.setDisable(true);
            verifVictoire();
        });
    }

    private void choice_player(Button button) {
        if(playerTurn % 2 == 0){
            button.setText("O");
            playerTurn = 1;
            Player_Name_Turn.setText("X Player Turn");

        } else{
            button.setText("X");
            playerTurn = 0;
            Player_Name_Turn.setText("O Player Turn");

        }
    }

    public void verifVictoire(){
        for (int a = 0; a < 8; a++) {
            String line = switch (a) {
                case 0 -> btn_1.getText() + btn_2.getText() + btn_3.getText();
                case 1 -> btn_4.getText() + btn_5.getText() + btn_6.getText();
                case 2 -> btn_7.getText() + btn_8.getText() + btn_9.getText();
                case 3 -> btn_1.getText() + btn_5.getText() + btn_9.getText();
                case 4 -> btn_3.getText() + btn_5.getText() + btn_7.getText();
                case 5 -> btn_1.getText() + btn_4.getText() + btn_7.getText();
                case 6 -> btn_2.getText() + btn_5.getText() + btn_8.getText();
                case 7 -> btn_3.getText() + btn_6.getText() + btn_9.getText();
                default -> null;
            };

            if (line.equals("OOO")) {
                winnerText.setText("O Player won!");
                historic.appendText("O Player won!" + "\n");
                int scoreO_result = score_0++;
                historic_Score.setText("O = " + (scoreO_result+1) + " // X = " + score_X);
            }

            else if (line.equals("XXX")) {
                winnerText.setText("X Player won!");
                historic.appendText("X Player won!" + "\n");
                int scoreX_result = score_X++;
                historic_Score.setText("O = " + score_0 + " // X = " + (scoreX_result+1));
            }
        }
    }

    @FXML
    void restartGame(ActionEvent event) {
        buttons.forEach(this::restart_morpion);
        winnerText.setText("");
    }

    public void restart_morpion(Button button){
        button.setDisable(false);
        button.setText("");
    }

}