package com.inmprove10x.templerun;

import java.util.Random;

public class TempleRunGame {
    public static void main(String[] args) throws InterruptedException {
        Player player = new Player("Charan Teja", 100);
        boolean isGameRunning = true;
        System.out.println("Game Started! ");
        while (isGameRunning){
            player.run();
            handleObstacles(player);

            if (player.getHealth() <= 0){
                System.out.println("Your Game is Over! Final score is : " + player.getScore());
                isGameRunning = false;
            }
                Thread.sleep(1000);
        }
    }

    private static void handleObstacles(Player player) {
        Obstacle obstacle = generateRandomObstacle();
        if (obstacle instanceof FireBall){
            ((FireBall) obstacle).roll();
            obstacle.collide(player);
        } else if (obstacle instanceof SpikePit) {
            ((SpikePit) obstacle).trap(player);
        }else if (obstacle instanceof Coin){
            player.collectCoin((Coin) obstacle);
        }
    }

    private static Obstacle generateRandomObstacle() {
        Random random = new Random();
        int obstacleType = random.nextInt(3);
        switch (obstacleType){
            case 1: return new FireBall(random.nextInt(30)+ 10);
            case 2: return new SpikePit(random.nextInt(10) + 5);
            default:{
                int[] coinValues = {10, 20, 30, 40, 50};
                int randomIndexValue = random.nextInt(coinValues.length);
                return new Coin(coinValues[randomIndexValue]);
            }
        }
    }
}
