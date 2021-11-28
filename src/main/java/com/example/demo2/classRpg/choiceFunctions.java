package com.example.demo2.classRpg;


import java.util.*;

public class choiceFunctions {

    static Scanner sc = new Scanner(System.in);

    public static List<Archetypes> choice1(int choiceInt, boolean choiceDone, List<Archetypes> heroList){

        int choiceArc = 0;
        boolean validOption = false;
        while (!validOption){
            try {
                System.out.println("Please choose a archetype : 1 : Default | 2 : Warrior | 3 : Wizard | 4 : Thief | 5 : Witch");
                choiceArc = sc.nextInt();
                validOption = true;
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid option");
                sc.next();
            }
        }

        System.out.println("My creator was too lazy to let me talk during the heroes creation soo... you'll be alone.. Be brave ! (ノ_<、)");
        if (choiceArc == 1){
            heroList.add(GameFunctions.characterBaseCreate());
        } else if (choiceArc == 2){
            heroList.add(GameFunctions.characterWarriorCreate());
        } else if (choiceArc == 3){
            heroList.add(GameFunctions.characterWizardCreate());
        } else if (choiceArc == 4){
            heroList.add(GameFunctions.characterThiefCreate());
        } else if (choiceArc == 5){
                heroList.add(GameFunctions.characterWitchCreate());}


        System.out.println("Yay You did it !! Wonderful !");
        return heroList;
    }

    public static void choice2(int choiceInt, boolean choiceDone, List<Archetypes> heroList){
        if (heroList.size() == 0){
            System.out.println("٩(╬ʘ益ʘ╬)۶ ARE YOU STUPID !? You didn't create any hero yet YOU IDIOT... Go and create some before I get angry \n");
            return;
        }
        for(int i = 0; i < heroList.size() ; i++) {
            System.out.println(i+1 + " - " + heroList.get(i).getName());
        }
        String choiceStr = "n";
        try{
            System.out.println("Do you want to see the detailed stat of a hero ? (y / n)  (×﹏×) Please don't I hate to do that ");
            choiceStr = sc.next();
        }
        catch (InputMismatchException e){
            System.out.println("ヽ( `д´*)ノ Can you PLEASE enter a valid option");
            sc.next();
        }

        if (choiceStr.equals("y")) {
            choiceDone = false;
            while (!choiceDone) {
                try {
                    System.out.println("Please choose a hero ( ` ω ´ ) Didn't I told you that i hated that ??? ");
                    choiceInt = sc.nextInt();
                    if (choiceInt-1 < heroList.size()) {
                        System.out.println(heroList.get(choiceInt -1));
                    } else {
                        System.out.println("(╬`益´) could you CHOOSE a valid hero !?!?");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("ヽ( `д´*)ノ Can you PLEASE enter a valid option");
                    sc.next();
                }
                try{
                    System.out.println("Do you want to see the detailed stat of an other hero ? (y / n)");
                    choiceStr = sc.next();
                }
                catch (InputMismatchException e){
                    System.out.println("ヽ( `д´*)ノ Can you PLEASE enter a valid option");
                    sc.next();
                }
                if (choiceStr.equals("n")){
                    choiceDone = true;
                }
            }
        }
    }

    public static void choice3(List<Archetypes> heroList, List<String> historicalFight) throws InterruptedException {
        int choiceFirstHero = 0;
        int choiceSecondHero = 0;
        String choice = "";
        if (heroList.size() < 2){
            System.out.println("٩(╬ʘ益ʘ╬)۶  You DON'T HAVE enough heroes to start a fight ! Please CREATE some... you idiot\n");
            return;
        }
        System.out.println("If you want to choose the heroes that will fight enter : choose / If you want random heroes to fight enter : random ... Don't you DARE to enter ihategiuby");
        choice = sc.next();
        if(choice.equals("choose")) {
            for (int i = 0; i < heroList.size(); i++) {
                System.out.println(i+1 + " - " + heroList.get(i).getName());
            }

            try {
                System.out.println("Which Hero do you want to fight ( choose the first one ) / If you want to cancel press 0");
                choiceFirstHero = sc.nextInt();
                if (choiceFirstHero == 0) {
                    return;
                } else if (choiceFirstHero - 1 < heroList.size()) {
                    System.out.println("You have chosen " + heroList.get(choiceFirstHero - 1).getName() + " as first hero \n");
                } else {
                    System.out.println("Please choose a valid hero");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid option");
                sc.next();

            }
            try {
                System.out.println("Which Hero do you want to fight ( choose the second one) / If you want to cancel press 0");
                choiceSecondHero = sc.nextInt();
                if (choiceSecondHero == 0) {
                    return;
                } else if (choiceSecondHero - 1 < heroList.size()) {
                    System.out.println("You have chosen " + heroList.get(choiceSecondHero - 1).getName() + " as second hero \n");
                } else {
                    System.out.println("Please choose a valid hero");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid option");
                sc.next();

            }
        }
        else if(choice.equals("random")){
            while( true) {
                double randNumber = Math.random();
                choiceFirstHero = ((int) (randNumber * heroList.size())) + 1;
                randNumber = Math.random();
                choiceSecondHero = ((int) (randNumber * heroList.size())) + 1;
                if (choiceFirstHero != choiceSecondHero) {
                    Archetypes firstHero = heroList.get(choiceFirstHero - 1);
                    Archetypes secondHero = heroList.get(choiceSecondHero - 1);
                    System.out.println("The first hero choosen is : " + firstHero.getName());
                    System.out.println("The first hero choosen is : " + secondHero.getName());


                    break;
                }
            }
        }
        else if(choice.equals("ihategiuby")){
            System.out.println("(◕‿◕)");
            Thread.sleep(1000);
            System.out.println("(`ー´)");
            Thread.sleep(1000);
            System.out.println("(╯°益°)╯彡┻━┻");
            Thread.sleep(1000);
            System.out.println("＼＼٩(๑`^´๑)۶／／ WHY DID YOU TYPE THAT !!!!????");
            System.out.println("∩┐(◣_◢)┌∩┐ GO BACK NOW");
            return;
        }
        else {
            System.out.println("(ノ°益°)ノ Please enter a valid option !!!");
        }

        boolean fightEnded = false;

        if (choiceFirstHero == choiceSecondHero){
            System.out.println("The hero fight his twin !!  (ಡ‸ಡ) That's so sad \n");
        }


        Archetypes firstHero = heroList.get(choiceFirstHero - 1);
        Archetypes secondHero = heroList.get(choiceSecondHero - 1);
        Archetypes hero1 = firstHero;
        int hero1Hp = hero1.getHp();
        Archetypes hero2 = secondHero;
        int hero2Hp = hero2.getHp();
        Archetypes hero3;
        int hero3Hp;

        if(firstHero.getSpeed() < secondHero.getSpeed()) {
            hero1 = secondHero;
            hero2 = firstHero;
        }

        int i = 0;
        while (!fightEnded) {
            if (hero1Hp <= 0){
                System.out.println(hero1.getName() + " lost the fight !! (⁀ᗢ⁀) HEHE " + hero1.getName() + " YOU ABSOLUTE LOOSER");
                String historicalWin = (hero2.getName() + " have killed " + hero1.getName() + " within " + (i/2) + " turn");
                historicalFight.add(historicalWin);
                break;
            }
            if (hero2Hp <= 0){
                System.out.println(hero2.getName() + " lost the fight !! (⁀ᗢ⁀) HEHE " + hero2.getName() + " YOU ABSOLUTE LOOSER");
                String historicalWin = (hero1.getName() + " have killed " + hero2.getName() + " within " + (i/2) + " turn");
                historicalFight.add(historicalWin);
                break;
            }

            hero2Hp = GameFunctions.fight(hero1, hero2, hero2Hp, i);

            hero3 = hero1;
            hero3Hp = hero1Hp;
            hero1 = hero2;
            hero1Hp = hero2Hp;
            hero2 = hero3;
            hero2Hp = hero3Hp;
            i ++;
        }
    }

    public static List<Archetypes> choice4(List<Archetypes> heroList) {
        String choiceStr = "n";
        int choiceInt = 0;
        boolean choiceDone = false;
        if (heroList.size() == 0){
            System.out.println("There isn't any Hero yet... You need to create some.. Please hurry up so we can have fun destroying them ! (*¯ ³¯*)♡");
            return heroList;
        }
        for(int i = 0; i < heroList.size() ; i++) {
        System.out.println(i+1 + " - " + heroList.get(i).getName());
        }
        try {
            System.out.println("Which Hero do you want to delete ? ♡( ◡‿◡ ) Choose with your heart... / Press 0 if you want to cancel (´-ω-`) Please don't");
            choiceInt = sc.nextInt();
            if (choiceInt == 0){
                return heroList;
            }
            if (choiceInt-1 < heroList.size()) {
                System.out.println("You have deleted " + heroList.get(choiceInt-1).getName() + "(≧◡≦) ♡ That was so coooool !");
                heroList.remove(heroList.get(choiceInt-1));
                for(int i = 0; i < heroList.size() ; i++) {
                    System.out.println(i + " - " + heroList.get(i).getName());
                }
            } else {
                System.out.println("Please choose a valid hero... Come ooon I'm sure you can do this ! here a motivation kiss (っ˘з(˘⌣˘ ) ♡");
            }
        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid option Come ooon I'm sure you can do this ! here a motivation kiss (っ˘з(˘⌣˘ ) ♡");
            sc.next();
        }
        try {
            System.out.println("Do you want to delete an other Hero ? (y / n ) (°◡°♡) Yaaaay please");
            choiceStr = sc.next();
        }
        catch (InputMismatchException e){
            System.out.println("Please enter a valid option... Come ooon I'm sure you can do this ! here a motivation kiss (っ˘з(˘⌣˘ ) ♡");
            sc.next();
        }

        if (choiceStr.equals("y")) {
            if (heroList.size() == 0){
                System.out.println("There isn't any Hero left... You need to create some.. Amazing you destroyed them all !! (◕‿◕)♡");
                return heroList;
            }

            for(int i = 0; i < heroList.size() ; i++) {
                System.out.println(i+1 + " - " + heroList.get(i).getName());
            }
            while (!choiceDone) {
                if (heroList.size() == 0){
                    System.out.println("There isn't any Hero left... You need to create some .. Please hurry up so we can have fun destroying them ! (*¯ ³¯*)♡");
                    return heroList;
                }
                try {
                    System.out.println("Which Hero do you want to delete ? (´｡• ᵕ •｡`) ♡ You're the best I know you can choose well !");
                    choiceInt = sc.nextInt() - 1;
                    if (choiceInt < heroList.size()) {
                        System.out.println("You have deleted " + heroList.get(choiceInt).getName() + "(≧◡≦) ♡ That was so coooool !");
                        heroList.remove(heroList.get(choiceInt));
                        for(int i = 0; i < heroList.size() ; i++) {
                            System.out.println(i + " - " + heroList.get(i).getName());
                        }
                    } else {
                        System.out.println("Please choose a valid hero... Come ooon I'm sure you can do this ! here a motivation kiss (っ˘з(˘⌣˘ ) ♡ ");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Please enter a valid option");
                    sc.next();
                }
                try {
                    System.out.println("Do you want to delete an other Hero ? (y / n ) (°◡°♡) Yaaaay please");
                    choiceStr = sc.next();
                }
                catch (InputMismatchException e){
                    System.out.println("Please enter a valid option...  Come ooon I'm sure you can do this ! here a motivation kiss (っ˘з(˘⌣˘ ) ♡");
                    sc.next();
                }
                if (choiceStr.equals(("n"))){
                    choiceDone = true;
                }
            }
        }
        return heroList;
    }

    public static void choice5(List<String> historicalFight) {
        if(historicalFight.size() != 0) {
            for (int i = 0; i < historicalFight.size(); i++) {
                System.out.println(historicalFight.get(i));
            }
        }
        else{
            System.out.println("The fight Historical is empty... Please start a fight.. I know you can do it ! Here a motivation kiss ❤ (ɔˆз(ˆ⌣ˆc)");
        }
        System.out.println("");
    }

    public static List<Archetypes> choice6(List<String> lineList, List<Archetypes> heroList) {
        Map<Integer, Map<String, String>> heroTab = new HashMap<>();

        lineList = file.file();
        int a =0;
        for(int i = 0; i<lineList.size(); i ++){
            heroTab = file.read(lineList.get(i), heroTab, a);
            a++;
        }
        int nbHero = 0;
        int y = 0;
        String name = "";
        int atk = 10;
        int hp = 100;
        int speed = 30;
        int dodge = 30;
        int crit = 30;
        int mana = 20;
        int shield = 5;
        int effect = 30;
        for (Map.Entry m : heroTab.entrySet()) {
            atk = 10;
            hp = 100;
            speed = 30;
            dodge = 30;
            crit = 30;
            mana = 20;
            shield = 5;
            effect = 30;
            Map<String, String> dict = heroTab.get(y);
            y++;
            for (Map.Entry n : dict.entrySet()) {
                String key = String.valueOf(n.getKey());
                String value = String.valueOf(n.getValue());
                ArrayList<String> liste = new ArrayList<String>();
                liste = file.separator(String.valueOf(n));
                    if (liste.get(0).equals("name")) {
                        name = liste.get(1);
                    }
                    if (liste.get(0).equals("hp")) {
                        hp = Integer.parseInt(liste.get(1));
                    }
                    if (liste.get(0).equals("atk")) {
                        atk = Integer.parseInt(liste.get(1));
                    }
                    if (liste.get(0).equals("speed")) {
                        speed = Integer.parseInt(liste.get(1));
                    }
                    if (liste.get(0).equals("dodge")) {
                        dodge = Integer.parseInt(liste.get(1));
                    }
                    if (liste.get(0).equals("critical")) {
                        crit = Integer.parseInt(liste.get(1));
                    }
                    if (liste.get(0).equals("mana")) {
                        mana = Integer.parseInt(liste.get(1));
                    }
                    if (liste.get(0).equals("shield")) {
                        shield = Integer.parseInt(liste.get(1));
                    }
                    if (liste.get(0).equals("effect")) {
                        effect = Integer.parseInt(liste.get(1));
                    }
                    if (key.equals("class")) {
                        if (value.equals("thief")) {
                            Thief thief = new Thief(name, atk, hp, speed, dodge, crit);
                            heroList.add(thief);
                            nbHero ++;
                        }
                        if (value.equals("warrior")) {
                            Warrior warrior = new Warrior(name, atk, hp, speed, shield);
                            heroList.add(warrior);
                            nbHero ++;
                        }
                        if (value.equals("wizard")) {
                            Wizard wizard = new Wizard(name, atk, hp, speed, mana);
                            heroList.add(wizard);
                            nbHero ++;
                        }
                        if (value.equals("neutral")) {
                            Neutral hero = new Neutral(name, atk, hp, speed);
                            heroList.add(hero);
                            nbHero ++;
                        }if (value.equals("witch")) {
                            Witch witch = new Witch(name, atk, hp, speed, effect);
                            heroList.add(witch);
                            nbHero ++;
                        }
                    }
                }
        }
        System.out.println("You have imported " + nbHero + " heroes !" );
        if (nbHero > 10){
            System.out.println("(；⌣̀_⌣́) You imported to much for my poor memory... ");
            System.out.println("Its not because you can create as many heroes as you want that you CAN do it without thinking !!!!");
        }

        return heroList;
    }
}