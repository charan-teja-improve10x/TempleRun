package com.inmprove10x.templerun;

public class Obstacle {

    protected String name;
    protected int damage;

    public Obstacle(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

    public void collide(Character character){
        System.out.println(name + " has Collide with " + character.getName() + " and caused " + damage + " damage.");
        character.healthDamage(damage);
    }
}
