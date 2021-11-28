package com.example.demo2.classRpg;


import java.util.ArrayList;
import java.util.List;

public class Neutral implements Archetypes {
    protected String name;
    protected int atk;
    protected int hp;
    protected int speed;
    protected boolean sleep = false;
    List<Burn> burnList = new ArrayList<Burn>();
    protected int burnTurn = 0;

    public Neutral(String name, int atk, int hp, int speed) {
        this.name = name;
        this.atk = atk;
        this.hp = hp;
        this.speed = speed;
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

    @Override
    public int damageDone(int i) {
        if (!sleep){
            return this.atk;
        }
        else {
            System.out.println(this.name + " is sleeping ! He can't do any damage");
            this.sleep = false;
            return 0;
        }
    }

    @Override
    public String stateDone() {
        return "";
    }

    @Override
    public void stateTaken(String stateTaken) {
        if (stateTaken.equals("burn")){
            Burn burn = new Burn();
            burnList.add(burn);
        }
        else if (stateTaken.equals("sleep")){
            this.sleep = true;
        }
    }

    @Override public String toString() {
        return "Hero " + name + " :  Atk = " + atk + "/ Hp = " + hp + "/ Speed = " + speed;
    }


}