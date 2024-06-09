package units;
import java.util.Random;

public class Hero extends Unit {

    public Hero(String name, int maxHP, int maxDMG, int maxHeal, int currentLevel) {
        super(name, maxHP, maxDMG, maxHeal, currentLevel);
    }

    public Hero(String name, int maxHP, int maxDMG, int currentHP, int currentLevel, int maxHeal) {    //
        super(name, maxHP, maxDMG, currentHP);
    }

    Random random = new Random();


    public void heal() {
        if(currentHP == maxHP)
            System.out.println("Why would you heal while being at max health points, gg on wasting your turn kid");
        else {
            int heal = random.nextInt(maxHeal) + 1;
            int oldHp = currentHP;
            currentHP = Math.min(currentHP + heal, maxHP);
            int healedHP = currentHP - oldHp;

            System.out.printf(name + " heals for " + String.valueOf(healedHP) + " health points\n");
        }
    }


    public void neverGonnaGiveYouUp(){
        currentHP = 0;
    }

    public static void displayActions(){
        System.out.println("1. Attack");
        System.out.println("2. Heal");
        System.out.println("3. Give up");
        System.out.println("4. Save game");
    }

    public void levelUp(){
        currentLevel = currentLevel + 1;
        maxHP = maxHP + 5;
        maxDMG = maxDMG + 3;
        maxHeal = maxHeal +2;
    }

    public void displayStats(){
        System.out.println("UNIT: " + name);                                             // method to display hero's stats
        System.out.println("HP: " + currentHP + "   MAX DMG: " + maxDMG);
        System.out.println("MAX HP: " + maxHP + "   MAX HEAL: " + maxHeal);
        System.out.println("CURRENT LEVEL: " + currentLevel);
    }

    public String toCSV(){
        String csvStats = name + "," + maxHP + "," + maxDMG + "," + currentHP + "," + maxHeal + "," + currentLevel;
        return csvStats;
    }

}


