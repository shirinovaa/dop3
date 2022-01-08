package com.company;

import java.util.Random;

public class Main {


    public static int[] heroesHealth = {250, 250, 250, 500,210,140,175,150};
    public static int[] heroesDamage = {20, 15, 25, 0,10,5,20,25};
    public static int medicsHealing = (int) (Math.random() * 35);
    public static String[] attackType = {"Physical", "Magical", "Aura", "Healing", "nothing ", "nothing", "nothing", "nothing"};
    public static String[] heroesNames = {"Warrior", "Mage", "Damage dealer", "Medic", "Tank", "Robber", "Berserk", "Thor"};
    public static int demonLordHealth = 666;
    public static int demonLordDamage = (int) (Math.random() * 90);
    public static String demonLordDefence = "";
    public static int roundNum = 1;

    public static void demonDefType() {
        Random random = new Random(); //1:48:03
        int ranIndex = random.nextInt(attackType.length);
        demonLordDefence = attackType[ranIndex];
        System.out.println("Demon choose " + demonLordDefence);

    }public static void main(String[] args) {
        Statistics();
        while (!Finishing()) {
            round();
        }


    }

    public static void round() {
        roundNum++;
        demonDefType();
        demonLordDamage = (int) (Math.random() * 90);
        demonHit();
        heroesHit();
        Statistics();

    }

    public static void demonHit() {
        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[3] == 0) {
                medicsHealing = 1;
            }
            if (demonLordDefence == attackType[3]) {
                demonLordHealth = demonLordHealth + medicsHealing;
            }


            if (heroesHealth[i] > 0) {
                if (heroesHealth[i] < demonLordDamage) {
                    heroesHealth[i] = 0;
                } else {
                    heroesHealth[i] = heroesHealth[i] - demonLordDamage;
                }
            }

        }
    }

    public static void heroesHit() {
        if (heroesHealth[3] > 0) {
            heroesHealth[3] = heroesHealth[3] + (medicsHealing = 0);
        }

        for (int i = 0; i < heroesDamage.length; i++) {
            if (heroesHealth[i] > 0 && demonLordHealth > 0) {

                if (demonLordDefence == attackType[i]) {
                    Random random = new Random();
                    int c = random.nextInt(10) + 2;
                    if (demonLordHealth < heroesDamage[i] * c) {
                        demonLordHealth = 0;
                    } else {
                        demonLordHealth = demonLordHealth - heroesDamage[i] * c;

                    }
                    final double absorbedDamage = demonLordDamage / 100 * 19;
                    if (demonLordDamage > 100) {
                        heroesHealth[4] = (int) absorbedDamage;
                    }
                    if (Math.random() * 100 < 20) {
                        heroesHealth[5] = demonLordDamage = 0;
                        break;
                    } else if (demonLordDamage > 20) {
                        heroesHealth[6] = (demonLordDamage - 60);
                        heroesDamage[6] = demonLordDamage;
                    }
                    if (heroesHealth[6] <= 0) {
                        heroesHealth[6] = 0;
                        heroesDamage[6] = 0;
                    }
                    if (Math.random() * 100 > 30) {
                        heroesHealth[7] = demonLordDamage = 0;
                        System.out.println("***The Demon is stunned***");

                    }

                    System.out.println("critical damage " + heroesDamage[i] * c);
                    break;
                } else {
                    if (heroesHealth[3] == 0) {
                        medicsHealing = 0;
                    }
                    if (heroesHealth[i] < 100) {
                        heroesHealth[i] = heroesHealth[i] + medicsHealing;

                    }

                    if (demonLordHealth < heroesDamage[i]) {
                        demonLordHealth = 0;
                    } else {
                        demonLordHealth = demonLordHealth - heroesDamage[i];

                    }
                }

            }
        }
    }

    public static boolean Finishing() {
        if (demonLordHealth <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean heroesDeath = true;
        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[i] > 0) {
                heroesDeath = false;
                break;
            }

        }
        if (heroesDeath) {
            System.out.println("Demon lord won!!!");

        }
        return heroesDeath;

    }

    public static void Statistics() {
        System.out.println("ROUND  " + roundNum);
        System.out.println("_________________________________________________");
        System.out.println("Boss Health: " + demonLordHealth + " [" + demonLordDamage + "] ");
        for (int i = 0; i < heroesHealth.length; i++) {
            System.out.println(heroesNames[i] + "'s health: " + heroesHealth[i] + " [" + heroesDamage[i] + "] ");

        }
        System.out.println();

    }
}


