/********************************************************************************************************************
 * @file monster.java
 * @brief This class implements a program that create different monsters in different states for the RPG game
 * @author Kyung Mo Doh
 * @data December 5, 2023
 *******************************************************************************************************************/

import java.util.Random;
public class monster{
    private String evilMonster;             //string variable for the monster name
    private int monsterHp;                  //int variable for the monster health
    private int monsterAtk;                 //int variable for the monster attack
    private int monsterGold;                //int variable for the amount of gold monster drops

    //constructor
    public monster(String name){
        evilMonster = name;
        monsterHp = 0;
        monsterAtk = 0;
        monsterGold = 0;
    }
    public monster(String name, int monsterHp){
        evilMonster = name;
        this.monsterHp = monsterHp;
        monsterAtk = 0;
        monsterGold = 0;
    }
    public monster(String name, int monsterHp, int monsterAtk){
        evilMonster = name;
        this.monsterHp = monsterHp;
        this.monsterAtk = monsterAtk;
        monsterGold = 0;
    }

    //set method
    public void setMonster(Random random){
        int num = random.nextInt(5);            //store random int variable from 0~4
        if(num == 0){                                  //if num is 0
            evilMonster = "Goblin";
            monsterHp = random.nextInt(5)+7;
            monsterAtk = random.nextInt(3)+4;
            monsterGold = random.nextInt(5)+4;
        }
        if(num == 1){                                  //if num is 1
            evilMonster = "Golem";
            monsterHp = random.nextInt(2)+13;
            monsterAtk = random.nextInt(3)+2;
            monsterGold = random.nextInt(6)+5;
        }
        if(num == 2){                                  //if num is 2
            evilMonster = "Orc";
            monsterHp = random.nextInt(4)+11;
            monsterAtk = random.nextInt(7)+4;
            monsterGold = random.nextInt(7)+3;
        }
        if(num == 3){                                  //if num is 3
            evilMonster = "Slime";
            monsterHp = random.nextInt(7)+5;
            monsterAtk = random.nextInt(6)+4;
            monsterGold = random.nextInt(9)+2;
        }
        if(num == 4){                                  //if num is 4
            evilMonster = "elf";
            monsterHp = random.nextInt(5)+6;
            monsterAtk = random.nextInt(3)+7;
            monsterGold = random.nextInt(5)+5;
        }
    }

    //adjust monster health after getting attacked by the character
    public void setMonsterHp(int damage) {
        monsterHp = monsterHp - damage;
    }

    //get methods
    public String getEvilMonster() {
        return evilMonster;
    }
    public int getMonsterHp() {
        return monsterHp;
    }
    public int getMonsterAtk() {
        return monsterAtk;
    }
    public int getMonsterGold() {
        return monsterGold;
    }

}
