package com.inmprove10x.templerun;

public class SpikePit extends Obstacle{
    private int width;

    public SpikePit(int width){
        super("Spike Pit",50);
        this.width = width;
    }

    public void trap(Character character){
        System.out.println("The " + name + " is trapped " + character.getName() + " inside!. it is " + width + "meters wide.");
        character.healthDamage(damage);
    }
}
