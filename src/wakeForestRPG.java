/********************************************************************************************************************
 * @file wakeForestRPG.java
 * @brief This program implements text base RPG game to user
 * @author Kyung Mo Doh
 * @data December 5, 2023
 *******************************************************************************************************************/

import java.util.Scanner;
import java.util.Random;

public class wakeForestRPG{
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);                 //new Scanner variable
        Random random = new Random();                          //new Random variable

        character hero = new character("unknown", 0, 0);        //object created for character class
        levelUp heroLevel = new levelUp(hero);                                      //object created for levelUp class

        String name, ready;                    //string variable
        char buyGear;                          //char variable for checking the gear the user wants to buy

        hero.start();                          //print method in the character class
        name = scnr.next();
        hero.setName(name);                                          //set name of the character
        hero.setHealth(random.nextInt(11) + 20);              //set health of the character in random range from 20 to 30
        hero.setAttack(random.nextInt(3) + 4);                //set attack of the character in random range from 4 to 6
        hero.setGold((random.nextInt(21) + 50));              //set starting gold of the character in random range from 50 to 70

        //setting the value for private variable in levelUp class
        heroLevel.setLevel(1);
        heroLevel.setHealHP(10);
        heroLevel.setAttackPotion(2);

        System.out.println("\n" + hero.getName() + "'s starting health is " + hero.getHealth() + ", attack is " + hero.getAttack() + ", and gold is " + hero.getGold());
        System.out.println("It's time to start a journey!");
        System.out.println("Before you leave the starting town, you could buy gears with your gold");
        System.out.println("Armor[A] price is 60 gold which increase your health by 10 and Sword[S] price is 40 which increase your attack by 2");
        System.out.println("Which one do you want to buy");
        buyGear = scnr.next().charAt(0);            //scan the user input

        //if the user type A for the response
        if (buyGear == 'A') {
            if (hero.getGold() < 60) {          //if the player has less gold than 60
                System.out.println("Sorry you don't have enough gold");
            } else {                            //if the player has equal of more gold than 60
                System.out.println("You bought an Armor!");
                hero.setHealth(hero.getHealth() + 10);      //increase the character health by 10
                System.out.println("Your current max health is " + hero.getHealth());
                hero.setGold(hero.getGold() - 60);          //minus 60 gold
                System.out.println("Your current gold is " + hero.getGold());
            }
        } else if (buyGear == 'S') {            //if the player type S for the response
            System.out.println("You bought a Sword!");
            hero.setAttack(hero.getAttack() + 2);           //increase the character attack by 2
            System.out.println("Your current attack is " + hero.getAttack());
            hero.setGold(hero.getGold() - 40);              //minus 40 gold
            System.out.println("Your current gold is " + hero.getGold());
        } else {
            System.out.println("Sorry, Can't understand your order");
        }

        hero.info();                                        //print method from character class
        System.out.println("✦Your current gold is " + hero.getGold() + "✦");
        System.out.println("\nAre you ready?(You cannot say no)");
        ready = scnr.next();
        System.out.print("\nNow you are on your way to the forest");

        //loop continues unless the character health goes below 0
        while (hero.getHealth() > 0) {
            System.out.println(".\n.\n.\n.");
            System.out.println("You could feel some dark creature nearby you...");
            System.out.println(".\n.\n.\n.");
            System.out.println("✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧");
            monster newMonster = new monster("unknown");    //create new object for monster class
            newMonster.setMonster(random);                        //set random monster for the object
            System.out.println("You have encountered the " + newMonster.getEvilMonster() + "!\n");
            System.out.println(newMonster.getEvilMonster() + " hp is " + newMonster.getMonsterHp() + " and atk is " + newMonster.getMonsterAtk());

            //the loops continue unless the monster or character dies
            while((hero.getHealth() > 0) && (newMonster.getMonsterHp() > 0)){
                System.out.println(newMonster.getEvilMonster() + " attacked you");
                hero.changeHealth(newMonster.getMonsterAtk());
                System.out.println("Your remaining health is " + hero.getHealth() + "\n");

                //if the character hp is over 0
                if(hero.getHealth()>0){
                    System.out.println("You have attacked the " + newMonster.getEvilMonster());
                    newMonster.setMonsterHp(hero.getAttack());
                    System.out.println(newMonster.getEvilMonster() + "'s HP is " + newMonster.getMonsterHp() + "\n");
                }
                //if the monster hp goes below 0
                if(newMonster.getMonsterHp() <= 0){
                    System.out.println(newMonster.getEvilMonster() + "'s hp is below zero. You have defeated the " + newMonster.getEvilMonster());
                    System.out.println(newMonster.getEvilMonster() + " dropped " + newMonster.getMonsterGold() + " gold and 3 mystery box. You may get one of them.");
                    hero.addGold(newMonster.getMonsterGold());          //add random amount of gold the monster drop to the character
                    hero.changeExp(randomEXP(scnr, random),random);     //add the random exp the monster provided to the user
                    hero.addScore(100);                             //add 100 score to the character
                    System.out.println("✦Your current EXP is " + hero.getEXP() + "✦");

                    if(hero.getEXP() >= 20) {                           //if the character EXP is over 20
                        heroLevel.checkLevelUp();                       //method in the levelUp class which increase the player level
                        System.out.println("\n✦You have moved to level " + heroLevel.getLevel() + "✦");
                        System.out.println("✦You have " + hero.getEXP() + " EXP remaining✦");
                        System.out.println("✦Your health has increased by 3 and attack has increased by 1✦");
                        System.out.println("✦Your current health is " + hero.getHealth() + " and your current attack is " + hero.getAttack() + "✦");
                    }

                    System.out.println("\n✦Currently, you have " + hero.getGold() + " gold✦");
                    System.out.println("✦Heal(H) potion is 15 gold and heals " + heroLevel.getHealHP() + " hp✦");
                    System.out.println("✦Attack(A) potion is 20 gold and increase your attack by " + heroLevel.getAttackPotion()+ "✦");
                    System.out.println("✦Which potion do you want to buy?(If you don't want to buy anything, press (N)✦");
                    buyGear = scnr.next().charAt(0);
                    //if the user response if H
                    if(buyGear == 'H'){
                        if(hero.getGold() < 15){                //if the character have below 15 gold
                            System.out.println("✦You don't have enough gold to buy heal potion✦");
                        }
                        else{
                            heroLevel.setHealth();              //add character health by 10
                        }
                    }
                    else if(buyGear == 'A'){                    //if the user response if A
                        if(hero.getGold() < 20){                //if the character have less gold than 20
                            System.out.println("✦You don't have enough gold to buy the attack potion✦");
                        }
                        else{
                            heroLevel.setAttack();              //increase character attack by 2
                        }
                    }
                    else{
                        System.out.println("✦You didn't buy anything from the system store✦");
                    }

                    System.out.println("\nNow you are on a new adventure\n");
                    System.out.println("✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧");
                }
            }
        }

        System.out.println("✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧");
        heroLevel.endGame();                                    //print method in levelUp class
    }


    public static int randomEXP(Scanner scnr, Random random){               //method for random box which is dropped after the monster is dead
        int playerSelect;                //new int variable for player response
        int changedNum;                  //new int variable
        int[] randomBox = {0,0,0};       //new array for the random box
        int randomNum = random.nextInt(3);          //random number generated from 0~2

        if(randomNum == 0){              //if the random number is 0
            randomBox[0] = 8;
            randomBox[1] = 6;
            randomBox[2] = 9;
        }
        if(randomNum == 1){             //if the random number is 1
            randomBox[0] = 6;
            randomBox[1] = 9;
            randomBox[2] = 8;
        }
        if(randomNum == 2){             //if the random number us 2
            randomBox[0] = 9;
            randomBox[1] = 8;
            randomBox[2] = 6;
        }

        System.out.println("Which one do you want to have? (Enter 1 or 2 or 3)");
        playerSelect = scnr.nextInt();         //scan the response of the user
        changedNum = playerSelect -1;

        System.out.println("\nNumber " + playerSelect + " box had " + randomBox[changedNum] + " xp");
        return randomBox[changedNum];     //return the EXP value
    }


}



