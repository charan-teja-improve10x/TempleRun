package com.inmprove10x.templerun;

public class PowerFullPlayer extends Player{
    private String specialPowerType;
    private int specialPowerDuration;

    public PowerFullPlayer(Player player, String specialPowerType) {
        super(player.name, player.health);
        this.setScore(player.getScore());
        this.specialPowerType = specialPowerType;
        specialPowerDuration = 0;
    }

    public void useSpecialPower(){
        if (specialPowerType != null && !specialPowerType.isEmpty()){
            System.out.println(getName() + " has gained " + specialPowerType + " as special power.");
            if (specialPowerType.equals("Super speed")){
                specialPowerDuration = 5;
            } else if (specialPowerType.equals("Invisibility")) {
                specialPowerDuration = 8;
            }
            System.out.println(getName() + " has activated the power for " + specialPowerDuration + " min duration.");
        }else {
            System.out.println(getName() + " dose not have any special powers.");
        }
    }

    public void reduceSpecialPowerDuration(){
        if (specialPowerType != null && specialPowerDuration > 0 && specialPowerType.equals("Super speed")){
            specialPowerDuration--;
        }else {
            specialPowerType = null;
            System.out.println(specialPowerType + " has ended for " + getName());
        }
    }

    @Override
    public void run() {
        if (specialPowerType != null && specialPowerType.equals("Supper speed")){
            System.out.println(getName() + " is running at supper speed.");
        }else {
            System.out.println(getName() + " is running at normal speed.");
        }
    }
}
