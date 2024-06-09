import java.util.*;
public class Methods {

    public static Random randomNumber = new Random();

    static List<Integer> arrListCreate(int arraySize) {
        List<Integer> arrList = new ArrayList<>();
        for (int i = 0; i < arraySize; i++) {
            arrList.add(randomNumber.nextInt(1000));
        }
        return arrList;
    }

    static List<Integer> linkListCreate(int arraySize) {
        List<Integer> linkList = new LinkedList<>();
        for (int i = 0; i < arraySize; i++){
            linkList.add(randomNumber.nextInt(1000));
        }
        return linkList;
    }


    static String timeAverage(List<Integer>timers, int numbersOfTestsDone){
        int sum = 0;

        for(int i = 0; i < 10; i++){
            sum += timers.get(i);
        }


        float average = (float) sum / 10;


        return switch (numbersOfTestsDone) {
            case 1 -> ("\n\nADD HEAD ARRAY LIST: " + average + " milliseconds");
            case 2 -> ("DELETE HEAD ARRAY LIST: " + average + " milliseconds");
            case 3 -> ("\n\nADD RANDOM ARRAY LIST: " + average + " milliseconds");
            case 4 -> ("DELETE RANDOM ARRAY LIST: " + average + " milliseconds");
            case 5 -> ("\n\nADD TAIL ARRAY LIST: " + average + " milliseconds");
            case 6 -> ("DELETE TAIL ARRAY LIST: " + average + " milliseconds");
            case 7 -> ("ADD HEAD LINK LIST: " + average + " milliseconds");
            case 8 -> ("DELETE HEAD LINK LIST: " + average + " milliseconds");
            case 9 -> ("ADD RANDOM LINK LIST: " + average + " milliseconds");
            case 10 -> ("DELETE RANDOM LINK LIST: " + average + " milliseconds");
            case 11 -> ("ADD TAIL LINK LIST: " + average + " milliseconds");
            case 12 -> ("DELETE TAIL LINK LIST: " + average + " milliseconds");
            default -> null;
        };
    }
}
