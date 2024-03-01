/********************************************************************************************************************
 * @file character.java
 * @brief This class is a program that creates a character with stats for the texted base RPG game
 * @author Kyung Mo Doh
 * @data December 5, 2023
 *******************************************************************************************************************/

import java.util.Random;

public class character{
    //field variable
    private String name;                //String variable for the character name
    private int health;                 //int variable for the character health
    private int attack;                 //int variable for the character attack
    private int EXP;                    //int variable for the character EXP
    private int gold;                   //int variable for the character gold
    private int score;                  //int variable for the score

    //constructor
    public character(){
        name = "unknown";
        health = 0;
        attack = 0;
        EXP = 0;
        gold = 0;
        score = 0;
    }
    public character(String name, String gender, int age, int health, int attack){
        this.name = name;
        this.health = health;
        this.attack = attack;
        EXP = 0;
        gold = 0;
        score = 0;
    }
    public character(String name, int health, int attack){
        this.name = name;
        this.health = health;
        this.attack = attack;
        EXP = 0;
        gold = 0;
        score = 0;
    }

    //set methods
    public void setName(String name) {
        this.name = name;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public void setAttack(int attack) {
        this.attack = attack;
    }
    public void setEXP(int EXP) {
        this.EXP = EXP;
    }
    public void setGold(int gold) {
        this.gold = gold;
    }
    public void setScore(int score) {
        this.score = score;
    }

    //get methods
    public String getName() {
        return name;
    }
    public int getHealth() {
        return health;
    }
    public int getAttack() {
        return attack;
    }
    public int getEXP() {
        return EXP;
    }
    public int getGold() {
        return gold;
    }
    public int getScore() {
        return score;
    }

    //print method
    public void start(){
        System.out.println("✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧");
        System.out.println("✦Welcome to Wake Forest, a world full of mystery✦");
        System.out.println("✦You are the chosen one to start the journey✦");
        System.out.println("✦Please type your name✦");
    }

    //print method
    public void info(){
        System.out.println("\n✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧");
        System.out.println("Before you go out to fight, their are few things you should know");
        System.out.println("Your current level is 1 and you could level up by gaining 20 exp.");
        System.out.println("Everytime you level up, your health increase by 3 and attack increase by 1");
        System.out.println("Every time you defeat a monster, you gain Exp. The amount of Exp you gain defers by the monster");
        System.out.println("Also you gain random amount of gold and 100 score as you kill a monster");
        System.out.println("After each battle, you could upgrade your attack or by HP potion in the system shop");
        System.out.println("Every time you by a potion in the store, you gain 40 score");
        System.out.println("Your goal is to gain high score before your HP goes to 0");
        System.out.println("Now let's start the journey!");
        System.out.println("✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧");
        System.out.println("\n✦Since I used a lot of effort as giving the basic information to you, I will take away 2 gold from you✦");
        minusGold(2);
    }

    //adjust the player health after getting attacked by the monster
    public void changeHealth(int damage){
        health = health - damage;
    }

    //adjust the player EXP after receiving EXP
    public void changeExp(int newEXP,Random random){
        EXP = EXP + newEXP;
        bonusEXP(random);
    }

    //increase the player score by the given amount
    public void addScore(int val){
        score = score + val;
    }

    //add gold by the given amount
    public void addGold(int monsterGold){
        gold = gold + monsterGold;
    }

    //minus the amount of gold the user chose to use in the store
    public void minusGold(int spend){
        gold = gold - spend;
    }

    //bonus EXP gained after user defeats the monster
    public void bonusEXP(Random random){
        int number = random.nextInt(4);         //store random int variable from 0~3
        if(number == 1){                               //if the number is 1
            System.out.println("Luckily, you earned a bonus EXP of 5");
            EXP = EXP + 5;                            //assign extra 5 EXP to the character
        }
    }




}
