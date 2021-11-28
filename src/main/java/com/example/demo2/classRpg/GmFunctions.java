package com.example.demo2.classRpg;

public class GmFunctions {
    public static void commentary() throws InterruptedException {
        double x = Math.random();
        x = x * 4;
        int y = (int) x;
        if (y == 0){
            System.out.println("A thief one day tried to rob my regard for you");
            Thread.sleep(100);
            System.out.println("Of course since I don't have any he couldn't...");
        }
        if (y == 1){
            System.out.println("The Warrior are real fighters the bravest above all");
            Thread.sleep(100);
            System.out.println("But if they see a butterfly they drops their weapons...");
        }
        if (y ==2){
            System.out.println("The Wizard are very powerful and have mastered many spells");
            Thread.sleep(100);
            System.out.println("But they can't use any since they don't know how to really use their mana...");
        }
        if ( y == 3){
            System.out.println("The 'neutral' don't have any features... Nobody know how they got here");
        }
        if(y == 4){
            System.out.println("The Witch are very old and powerful watch out for their burn !");
            System.out.println("But don't worry your hero just need a water bucket to kill them");
        }













    }
}
