package com.example.demo2.classRpg;


import java.util.ArrayList;
import java.util.List;

public class Wizard implements Archetypes {
    protected int wizardDamage;
    protected String name;
    protected int damage;
    protected int hp;
    protected int speed;
    private int wizardDamageModified = wizardDamage;
    protected boolean sleep = false;
    List<Burn> burnList = new ArrayList<Burn>();


    public Wizard(String name, int damage, int hp, int speed, int wizardDamage) {
        this.wizardDamage = wizardDamage;
        this.name = name;
        this.damage = damage;
        this.hp = hp;
        this.speed = speed;
    }


    public int getWizardDamage() {
        return wizardDamage;
    }

    public void setWizardDamage(int wizardDamage) {
        this.wizardDamage = wizardDamage;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public void setDamage(int damage) {
        this.damage = damage;
    }

    @Override
    public int getHp() {
        return hp;
    }

    @Override
    public void setHp(int hp) {
        this.hp = hp;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
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
            if (i > 1){
                wizardDamageModified = wizardDamage;
            }
            int damageDone = this.damage + wizardDamageModified;
            this.wizardDamageModified /= 2;
            return damageDone;
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
    @Override
    public String toString() {
        return "Hero " + name + " :  Atk = " + damage + "/ Hp = " + hp + "/ Speed = " + speed+ "/ WizardDammage = " + wizardDamage;
    }
}
