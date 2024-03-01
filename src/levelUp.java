/********************************************************************************************************************
 * @file levelUp.java
 * @brief This class is the derived class from character which contains information for the different potions the user can by at the system store
 * @author Kyung Mo Doh
 * @data December 5, 2023
 *******************************************************************************************************************/

public class levelUp extends character {
    //field variable
    private int level;          //int variable for the character level
    private int healHP;         //int variable for the heal potion
    private int attackPotion;   //int variable for the attack potion
    private character hero;     //import the created object for character class

    //constructor
    public levelUp(character hero) {
        level = 0;
        healHP = 0;
        attackPotion = 0;
        this.hero = hero;
    }
    public levelUp(character hero, int level, int healHP) {
        this.level = level;
        this.healHP = healHP;
        attackPotion = 0;
        this.hero = hero;
    }
    public levelUp(character hero, int level, int healHP, int attackPotion) {
        this.level = level;
        this.healHP = healHP;
        this.attackPotion = attackPotion;
        this.hero = hero;
    }

    //set method
    public void setLevel(int level) {
        this.level = level;
    }

    public void setHealHP(int healHP) {
        this.healHP = healHP;
        ;
    }

    public void setAttackPotion(int attackPotion) {
        this.attackPotion = attackPotion;
    }

    //get method
    public int getLevel() {
        return level;
    }

    public int getHealHP() {
        return healHP;
    }

    public int getAttackPotion() {
        return attackPotion;
    }

    //increase the level of the character by 1, increase character health and attack by 3 1, and decrease 20 EXP from the character
    public void checkLevelUp() {
        level = level + 1;
        hero.setEXP(hero.getEXP() - 20);
        hero.setHealth(hero.getHealth() + 3);
        hero.setAttack(hero.getAttack() + 1);
    }

    //increase the health of the character by 10 and take 15 gold from the character. Add 40 score
    public void setHealth() {
        hero.setHealth(hero.getHealth() + healHP);
        System.out.println("You used the heal potion. Your health is now " + hero.getHealth());
        hero.minusGold(15);
        super.addScore(40);
    }

    //increase the attack of the character by 2 and take 20 gold from the user. Add 40 score
    public void setAttack() {
        hero.setAttack(hero.getAttack() + attackPotion);
        System.out.println("You used the attack Potion. Your attack is now " + hero.getAttack());
        hero.minusGold(20);
        super.addScore(40);
    }

    //print method after character health goes below 0
    public void endGame() {
        System.out.println(".\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n*****************************************************");
        System.out.println("Daniel's health is below zero. GAME OVER....");
        System.out.println("Your final level was level " + level);
        int finalScore = hero.getScore() + getScore();
        System.out.println("Your total score is " + finalScore);
        System.out.println("*****************************************************");
    }

}
