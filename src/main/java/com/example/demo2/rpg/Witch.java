package com.example.demo2.rpg;


import java.util.ArrayList;
import java.util.List;

public class Witch implements Archetypes {
    protected String name;
    protected int atk;
    protected int hp;
    protected int speed;
    protected int effect;
    protected boolean sleep = false;
    List<Burn> burnList = new ArrayList<Burn>();
    protected String className = "sorciere";


    public Witch(String name, int atk, int hp, int speed, int effect) {
        this.name = name;
        this.atk = atk;
        this.hp = hp;
        this.speed = speed;
        this.effect = effect;
    }

    @Override
    public String getName() {
        return name;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return atk;
    }

    public void setDamage(int damage) {
        this.atk = damage;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public int takenDamage(int damage) {
        int burnDamage = 0;
        for (int i = 0; i < burnList.size(); i++) {
            burnDamage +=3;
            int bturn = burnList.get(i).burnTurn();
            if (bturn == 5) {
                burnList.remove(i);
            }
        }
        if (burnList.size() != 0) {
            System.out.println(this.name + " is burning !! he took " + burnDamage + " additional damages");
            return damage + burnDamage;
        }
        return damage;
    }

    public int damageDone(int i) {
        if (!sleep){
        return this.atk;
        }
        else {
            System.out.println(this.name + " is sleeping ! He can't do any damage");
            return 0;
        }
    }

    public String stateDone() {
        String effectDone = " ";
        double randNumber = Math.random();
        double randNumber2 = Math.random();
        randNumber2 = randNumber2 * 2;
        randNumber2 = (int) randNumber2;
        if (randNumber2 > 1){
            effectDone = "endormissement";
        }
        else {
            effectDone = "brûlure";
        }

        double effect = randNumber * 100;
        effect = (int)effect;
        if (effect < this.effect){
            return effectDone;
        }
        return "";
    }


    public void stateTaken(String stateTaken) {
        if (stateTaken.equals("brûlure")){
            Burn burn = new Burn();
            burnList.add(burn);
        }
        else if (stateTaken.equals("endormissement")){
            this.sleep = true;
        }
    }

    public String toString() {
        if (this.name.equals("root")){
            return "Sorcières :";
        }
        else {
            return this.name;
        }
    }
}