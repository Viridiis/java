package game;
import units.Unit;
import units.Imp;
import units.Succubus;
import units.Devil;
import java.util.Random;


public class OpponentSpawner {

    public static Unit opponent;
    public static Unit spawn(){

        Random random = new Random();
        int number = random.nextInt(10)+1;        // randomize number

        if(number <= 6)                                 // if <1;6>
            opponent = new Imp();                       // Spawn imp

        if (number >= 7 && number <= 9)                 // if <7;9>
            opponent = new Succubus();                  // Spawn succubus

        if(number >= 10)                                // if >= 10
            opponent = new Devil();                     // Spawn devil

        return opponent;                                // return randomized opponent

    }

}
