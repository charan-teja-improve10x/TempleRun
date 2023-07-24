package com.inmprove10x.templerun;

public class FireBall extends Obstacle{

    public int speed;

    public FireBall(int speed){
        super("FireBall ", 30);
        this.speed = speed;
    }

    public void roll(){
        System.out.println("The " + name + " is Rolling With speed of " + speed + " mph.");
    }
}
