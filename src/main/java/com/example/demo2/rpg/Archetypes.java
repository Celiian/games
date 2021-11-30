package com.example.demo2.rpg;

public interface Archetypes {
    public String getClassName();

    public String getName();

    public void setName(String name);

    public int getDamage();

    public void setDamage(int damage);

    public int getHp();

    public void setHp(int hp);

    public int getSpeed();

    public void setSpeed(int speed);

    public int takenDamage(int damage);

    public int damageDone(int i);

    public String stateDone();

    public void stateTaken(String stateTaken);

}