package com.example.demo2.rpg;

import java.util.Scanner;

public class GameFunctions {

    static Scanner sc = new Scanner(System.in);


    public static int fight(Archetypes hero_atk, Archetypes hero_def, int hero2Hp, int i){
        String effect_done = hero_atk.stateDone();
        hero_def.stateTaken(effect_done);

        int dmg_done = hero_atk.damageDone(i);
        int dmg_taken = hero_def.takenDamage(dmg_done);
        hero2Hp = (hero2Hp - dmg_taken);

        if (hero2Hp < 0){
            hero2Hp = 0;
        }
        if (dmg_taken > 20){
            System.out.println("OH MY GOD !!! " + hero_def.getName() + " took " + dmg_taken + " damage from " + hero_atk.getName() + " !!!! Can you imagine that ???");
        }
        else {
            System.out.println(hero_atk.getName() + " did " + dmg_taken + " to " + hero_def.getName() + " !");
        }
        if (hero2Hp < 30){
            System.out.println(hero_def.getName() + " have " + hero2Hp + " he is so clooose to die !!!");
        }

        System.out.println("Now " +  hero_def.getName() + " have " + hero2Hp + " hp left \n");

        return hero2Hp;
    }

    public static String nomAleatoire(){
        String name = "hero";
        int rand = (int) (Math.random() *100);
        if (rand == 1){
            name = "roger";
        }
        return name;

    }

    public static Archetypes creationPersonnage(String className){
        String name = nomAleatoire();
        Archetypes hero = switch (className) {
            case "sorciere" -> new Witch(name, 15, 100, 30, 35);
            case "guerrier" -> new Warrior(name, 20, 120, 20, 5);
            case "voleur" -> new Thief(name, 30, 80, 45, 20, 30);
            default -> new Neutral(name, 25, 100, 35);
        };
        return hero;
    }

    public static Archetypes creationPersonnage(String className,String name){
        Archetypes hero = switch (className) {
            case "sorciere" -> new Witch(name, 15, 100, 30, 35);
            case "guerrier" -> new Warrior(name, 20, 120, 20, 5);
            case "voleur" -> new Thief(name, 30, 80, 45, 20, 30);
            default -> new Neutral(name, 25, 100, 35);
        };
        return hero;
    }






}



