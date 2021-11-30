package com.example.demo2.rpg;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {
        List<Archetypes> heroList = new ArrayList<Archetypes>();
        List<String> historicalFight = new ArrayList<String>();
        List<String> lineList = new ArrayList<String>();

        System.out.println("Application is starting");
        Thread.sleep(1000);
        System.out.println("Writing the game... Please Wait ... __φ(．．)");
        Thread.sleep(800);
        System.out.print(".");
        Thread.sleep(800);
        System.out.print(".");
        Thread.sleep(800);
        System.out.print(".");
        Thread.sleep(800);
        System.out.println(".");
        Thread.sleep(800);

        System.out.println("(^０^)ノ Hello dear God... My name is Giuby..");
        System.out.println("I am here to entertain you ! \n");

        Thread.sleep(1000);
        GmFunctions.commentary();
        System.out.println("");

        Thread.sleep(4000);

        System.out.println("Application has successfully Started");
        System.out.println("");

        System.out.println("This 'game' is here to entertain you and I am here to help you use it <(￣︶￣)>");
        Thread.sleep(2500);
        System.out.println("You are here to create some 'creatures' named Heroes  (☆ω☆)");
        Thread.sleep(2500);
        System.out.println("Then you will have them fight each other ψ( ` ∇ ´ )ψ Muahahahahaha");
        Thread.sleep(2500);

        boolean gameRunning = true;

        while (gameRunning){

            int choiceInt = 5;
            boolean choiceDone = false;
            while (!choiceDone) {
                try {
                    System.out.println("");
                    System.out.println("Sooooo...");
                    System.out.println("What do you want to do ? (・_・ヾ");
                    System.out.println("1 : Create a hero... Come on show me what you got ! (^.~)☆");
                    System.out.println("2 : List of hero... Will show you the list of hero.. What is their to add ? (ーー;)");
                    System.out.println("3 : Hero fight... ←~(Ψ▼ｰ▼)∈ Let's kill some heroes Muahahahaha");
                    System.out.println("4 : Delete a Hero... (◕‿◕) I love destruction");
                    System.out.println("5 : Fight Historical... (；￣Д￣) Do I really need to remember every fight ??");
                    System.out.println("6 : Config File... ╮(￣_￣)╭ Ask the creator about it he didn't tell me what is it used for...");
                    System.out.println("7 : Leave... ((╬◣﹏◢)) DON'T YOU DARE TRY TO LEAVE");

                    choiceInt = sc.nextInt();
                    choiceDone = true;
                } catch (InputMismatchException e) {
                    System.out.println("Please choose an integer you stupid (・`ω´・)");
                    sc.next();
                }
            }
            if(choiceInt == 1){
            }
            if (choiceInt == 2){
                choiceFunctions.choice2(choiceInt, choiceDone, heroList);
            }
            if (choiceInt == 3){
                choiceFunctions.choice3(heroList, historicalFight);
            }
            if (choiceInt == 4){
                heroList = choiceFunctions.choice4(heroList);
            }
            if (choiceInt == 5){
                choiceFunctions.choice5(historicalFight);
            }
            if (choiceInt == 6){
                heroList = choiceFunctions.choice6(lineList, heroList);
            }
            if (choiceInt == 7){
                gameRunning = false;
            }
        }
        System.out.println("Application has ended");
        System.out.println("Hope I'll see you soon ! (＠＾◡＾)");
    }
}
