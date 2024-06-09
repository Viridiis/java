package units;
import java.util.Random;
public abstract class Unit {
        Random random = new Random();                                                          // Random object
        public String name;                                                                    // Identificator
        public int maxHP;                                                                      // Max health
        public int maxDMG;                                                                     // Max damage
        public int currentHP;                                                                  // Current health
        public int maxHeal;                                                                    // Max heal;
        public int currentLevel;                                                               // Current level


        public Unit(String name, int maxHP, int maxDMG, int maxHeal, int currentLevel) {
                this.name = name;
                this.maxHP = maxHP;
                this.maxDMG = maxDMG;
                this.currentHP = maxHP;
                this.maxHeal = maxHeal;
                this.currentLevel = currentLevel;
        }

        public Unit(String name, int maxHP, int maxDMG, int currentHP){
                this.name = name;
                this.maxHP = maxHP;
                this.maxDMG = maxDMG;
                this.currentHP = currentHP;
        }

        public void displayStats(){                                                              // method to display opponent's stats
                System.out.println("\nUNIT: " + name);
                System.out.println("HP: " + currentHP + "   MAX DMG: " + maxDMG);
                System.out.println("MAX HP: " + maxHP);
        }

        public boolean isAlive(){                                                                 // method to check if unit is alive
            if(currentHP <= 0)
                    return false;
            else
                    return true;
        }

        public void takeDamage(int damage){                                               // method to calculate health after taking damage
                currentHP = currentHP - damage;
        }

        public void attack(Unit opponent){                                                          // method to deal damage
                int damageDealt = random.nextInt(maxDMG+1);
                opponent.takeDamage(damageDealt);
                if(damageDealt != 0){
                        System.out.printf(", they took " + damageDealt + " damage!\n");
                }
                else{
                        System.out.printf(", they missed!\n");
                }
        }

        public String toCSV(){
                String csvStats = name + "," + maxHP + "," + maxDMG + "," + currentHP;
                return csvStats;
        }

}