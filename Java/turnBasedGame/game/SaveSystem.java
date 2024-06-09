package game;

import units.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;


public class SaveSystem {

    static File heroFile = new File("heroFile.csv");
    static File opponentFile = new File("opponentFile.csv");
    public SaveSystem() throws FileNotFoundException {

    }


    public static void save(Hero hero, Unit opponent) {

        try {
            if (!heroFile.exists()) {
                heroFile.createNewFile();
            }

            if (!opponentFile.exists()) {
                opponentFile.createNewFile();
            }


            FileWriter heroFileWriter = new FileWriter(heroFile, false);
            heroFileWriter.write(hero.toCSV());
            heroFileWriter.close();

            FileWriter opponentFileWriter = new FileWriter(opponentFile, false);
            opponentFileWriter.write(opponent.toCSV());
            opponentFileWriter.close();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static Hero loadHero() {
        if (heroFile.exists()) {
            try {
                Scanner heroFileReader = new Scanner(heroFile);
                String data = heroFileReader.nextLine();
                heroFileReader.close();

                Hero hero = new Hero("tempt", 0, 0, 0, 0, 0);

                String[] dataStats = data.split(",");
                try {
                    hero.name = dataStats[0];
                    hero.maxHP = Integer.parseInt(dataStats[1]);
                    hero.maxDMG = Integer.parseInt(dataStats[2]);
                    hero.currentHP = Integer.parseInt(dataStats[3]);
                    hero.maxHeal = Integer.parseInt(dataStats[4]);
                    hero.currentLevel = Integer.parseInt(dataStats[5]);
                } catch (NumberFormatException nfe) {
                }


                return hero;

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        else {
            System.out.println("File doesnt exist");
            return null;
        }

    }


        public static Unit loadOpponent () {
            if(opponentFile.exists()) {
                try {
                    Scanner opponentFileReader = new Scanner(opponentFile);
                    String data = opponentFileReader.nextLine();
                    opponentFileReader.close();
                    Unit opponent = null;
                    String[] dataStats = data.split(",");

                    if (Objects.equals(dataStats[0], "Imp"))
                        opponent = new Imp();
                    if (Objects.equals(dataStats[0], "Succubus"))
                        opponent = new Succubus();
                    if (Objects.equals(dataStats[0], "Devil"))
                        opponent = new Devil();

                    opponent.name = dataStats[0];
                    opponent.maxHP = Integer.parseInt(dataStats[1]);
                    opponent.maxDMG = Integer.parseInt(dataStats[2]);
                    opponent.currentHP = Integer.parseInt(dataStats[3]);

                    return opponent;

                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            else{
                System.out.println("File doesn't exist");
                return null;
            }
        }
}
