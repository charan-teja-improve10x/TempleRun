package com.inmprove10x.templerun;

import java.util.Random;

public class TempleRunGame {
    public static void main(String[] args) throws InterruptedException {
        Player player = new Player("Charan Teja", 100);
        boolean isGameRunning = true;
        System.out.println("Game Started! ");
        while (isGameRunning){
           player=  handleObstacles(player);
            player.run();
            if (player.getHealth() <= 0){
                System.out.println("Your Game is Over! Final score is : " + player.getScore());
                isGameRunning = false;
            } else if (player instanceof PowerFullPlayer) {
                ((PowerFullPlayer) player).reduceSpecialPowerDuration();
            }
            Thread.sleep(1000);
        }
    }

    private static Player handleObstacles(Player player) {
        Obstacle obstacle = generateRandomObstacle();
        if (obstacle instanceof FireBall){
            ((FireBall) obstacle).roll();
            obstacle.collide(player);
        } else if (obstacle instanceof SpikePit) {
            ((SpikePit) obstacle).trap(player);
        }else if (obstacle instanceof Coin) {
            Coin coin = ((Coin) obstacle);
            player.collectCoin(coin);
            if (coin.getValue() == 1000) {
                player = new PowerFullPlayer(player, "Super speed");
                ((PowerFullPlayer) player).useSpecialPower();
            }
        }
        return player;
    }

    private static Obstacle generateRandomObstacle() {
        Random random = new Random();
        int obstacleType = random.nextInt(3);
        switch (obstacleType){
            case 1: return new FireBall(random.nextInt(30)+ 10);
            case 2: return new SpikePit(random.nextInt(10) + 5);
            default:{
                int[] coinValues = {10, 20, 30, 40, 50, 1000};
                int randomIndexValue = random.nextInt(coinValues.length);
                return new Coin(coinValues[randomIndexValue]);
            }
        }
    }
}
