package game;

import units.Unit;
import units.Hero;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class Game {

    static Hero hero = null;                                                                            // Object hero
    static Unit opponent;                                                                               // Object opponent aka imp

    static Scanner input = new Scanner(System.in);                                                       // Scanner to read console lines
    static int turnCounter = 1;                                                                          // Turn counter
    static int battleCounter = 1;

    public static boolean loadGame(){
        hero = SaveSystem.loadHero();
        opponent = SaveSystem.loadOpponent();
        return !(hero == null || opponent == null);
    }

    public static void newGame(){
        createHero();
        if(opponent == null)
            opponent = OpponentSpawner.spawn();
        gameLoop();
    }

    public static void startGame() {                                                                     // startGame method
        while(true){
            System.out.println("1. New game");
            System.out.println("2. Load game");
            String inputSave = input.nextLine();

            if(Objects.equals(inputSave, "1")){
                newGame();
                break;
            }

            else if(Objects.equals(inputSave, "2")){
                if(loadGame()){
                    hero.displayStats();
                    gameLoop();
                    break;
                }
                else{
                    System.out.println("Loading failed");
                }
            }
        }
    }

    public static void createHero()                                                                     // createHero method
    {
        System.out.println("An adventure begins. What is your name, hero?");                            // Ask for hero game
        hero = new Hero(input.nextLine(), 50, 10, 8, 1);
        hero.displayStats();                                                                            // Display hero's statistics
    }

    public static void handleChoice(int choice, Unit opponent){                                         // handleChoice method
        switch (choice){
            case 1:                                                                                     // if 1
                System.out.printf(hero.name + " attacks " + opponent.name);
                hero.attack(opponent);                                                                  // Hero will attack opponent
                break;
            case 2:                                                                                     // if 2
                hero.heal();                                                                            // Heal
                break;
            case 3:                                                                                     // if 3
                hero.neverGonnaGiveYouUp();                                                             // Set current hp to 0
                break;
            case 4:
                SaveSystem.save(hero, opponent);
                System.exit(0);
                break;
        }
    }



    public static Unit getWinner(){                                                                     // getWinner method
        System.out.println("\n=============================\n");
        System.out.println("Winner: ");
        if(hero.isAlive())                                                                              // if hero's alive
            return hero;                                                                                // return him
        else                                                                                            // otherwise
            return opponent;                                                                            // return opponent
    }


    public static void duel(){                                                                          // duel method
        opponent.displayStats();                                                                        // Display opponent's statistics (outside loop so it will display
                                                                                                        // at start of second etc. etc. battle)

        while(hero.isAlive() && opponent.isAlive()){                                                    // while both units are alive
            System.out.println("\nTurn: " + turnCounter);                                               // Display turn counter
            turnCounter++;                                                                              // Add +1 to turn counter

            System.out.println("=============================\n");
            Hero.displayActions();                                                                      // Hero's actions
            int playerChoice = input.nextInt();                                                         // Choice
            System.out.println();
            handleChoice(playerChoice, opponent);                                                       // handleChoice

            if (playerChoice == 3){                                                                     // if 3
                System.out.println(hero.name + " is a coward and gives up a fight!");                   // give up message
                break;                                                                                  // exit combat
            }


            if(!opponent.isAlive()){                                                                    // Check if opponent is alive
                break;                                                                                  // if not, exit combat
            }

            System.out.printf(opponent.name + " attacks " + hero.name);
            opponent.attack(hero);                                                                      // Opponent attacks you

            if(!hero.isAlive()){                                                                        // Check if hero is alive
                break;                                                                                  // if not, exit combat
            }


            System.out.println("=============================\n");
            hero.displayStats();                                                                        // Display updated hero's statistics
            opponent.displayStats();                                                                    // Display updated opponent's statistics

        }


        if(opponent.isAlive()) {                                                                        // if opponent's alive
            getWinner().displayStats();                                                                 // Display opponent's stats
            System.out.println("=============================\n");
            System.out.println("GAME OVER");                                                            // Game over
            System.out.print("You survived: " + (battleCounter -1) + " battles\n");                     // Battle counter overall message
        }

        if(hero.isAlive()) {                                                                            // if hero's alive
            hero.levelUp();                                                                             // Level up
            getWinner().displayStats();                                                                 // Display hero's stats
        }
            turnCounter = 1;
            opponent = null;
    }

    public static void gameLoop(){
        while(hero.isAlive()) {                                                                         // while hero's alive
            System.out.println("\nBattle: " + battleCounter);                                           // Battle counter
            duel();                                                                                     // Call duel method
            opponent = OpponentSpawner.spawn();                                                         // Randomize new opponent
            battleCounter++;                                                                            // Battle counter ++
        }
    }

}