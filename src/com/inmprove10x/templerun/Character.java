package com.inmprove10x.templerun;

public class Character {

    protected String name;
    protected int health;

    public Character(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void healthDamage(int damage){
        health = health - damage;
    }
}
