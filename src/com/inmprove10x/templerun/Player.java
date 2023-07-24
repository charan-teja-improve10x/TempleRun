package com.inmprove10x.templerun;

public class Player extends Character{

    private int score;

    public Player(String name, int health) {
        super(name, health);
        this.score = 0;
    }
    public void run(){
        System.out.println("Running........");
    }

    public int getScore() {
        return score;
    }

    public void collectCoin(Coin coin){
        this.score += coin.getValue();
    }
}
