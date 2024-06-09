import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Tests {

    public static List<Integer> timers = new ArrayList<>();                        // list to contain timers
    public static List<String> averages = new ArrayList<>();

    static void program() {
        arrListTest();
        linkListTest();
        results();
    }

    // If your results are 0.0 ms, increase number of arraySize (in 1 or 2 lines, depends on test)

    static void arrListTest() {

        // ARRAY HEAD ADD TEST

        for (int i = 0; i < 10; i++) {

            List<Integer> arrList = Methods.arrListCreate(10000);                   // create array list

            Instant timerStart = Instant.now();                                             // timer start

            for (int j = 0; j < 10000; j++) {
                arrList.add(Methods.randomNumber.nextInt(0, 500));              // add to head
            }

            Instant timerEnd = Instant.now();                                               // timer end
            int diffSeconds = (int) (timerEnd.toEpochMilli() - timerStart.toEpochMilli());  // time in ms
            timers.add(diffSeconds);
        }

        averages.add(Methods.timeAverage(timers, 1));                      // calculate and print average + add result to list timers
        timers.clear();                                                                     // clear timers list



        // ARRAY HEAD REMOVE TEST

        for (int i = 0; i < 10; i++) {

            List<Integer> arrList = Methods.arrListCreate(10000);                  // create array list

            Instant timerStart = Instant.now();                                             // timer start

            for (int j = arrList.size(); j > 0; j--) {
                arrList.remove(j - 1);                                                  // remove from head
            }

            Instant timerEnd = Instant.now();                                               // timer end
            int diffSeconds = (int) (timerEnd.toEpochMilli() - timerStart.toEpochMilli());  // time in ms
            timers.add(diffSeconds);

        }

        averages.add(Methods.timeAverage(timers, 2));                      // calculate and print average + add result to list timers
        timers.clear();                                                                     // clear timers list



        // ARRAY RANDOM ADD TEST

        for (int i = 0; i < 10; i++) {                                                         // array random test

            List<Integer> arrList = Methods.arrListCreate(10000);                          // create array list

            Instant timerStart = Instant.now();                                                  // timer start

            for (int j = 0; j < 10000; j++) {
                arrList.add(Methods.randomNumber.nextInt(0, arrList.size()), Methods.randomNumber.nextInt(0, 500));
            }

            Instant timerEnd = Instant.now();                                               // timer end
            int diffSeconds = (int) (timerEnd.toEpochMilli() - timerStart.toEpochMilli());  // time in ms
            timers.add(diffSeconds);
        }

        averages.add(Methods.timeAverage(timers, 3));                      // calculate and print average + add result to list timers
        timers.clear();



        // ARRAY RANDOM REMOVE TEST

        for (int i = 0; i < 10; i++) {

            List<Integer> arrList = Methods.arrListCreate(10000);                          // create array list

            Instant timerStart = Instant.now();                                                  // timer start


            for (int j = arrList.size(); j > 0; j--) {
                arrList.remove(j - 1);
            }

            Instant timerEnd = Instant.now();                                               // timer end
            int diffSeconds = (int) (timerEnd.toEpochMilli() - timerStart.toEpochMilli());  // time in ms
            timers.add(diffSeconds);
        }

        averages.add(Methods.timeAverage(timers, 4));                      // calculate and print average + add result to list timers
        timers.clear();



        // ARRAY TAIL ADD TEST

        for (int i = 0; i < 10; i++) {

            List<Integer> arrList = Methods.arrListCreate(10000);                          // create array list

            Instant timerStart = Instant.now();                                                  // timer start


            for (int j = 0; j < 10000; j++) {
                arrList.add(0, Methods.randomNumber.nextInt(0, 500));
            }

            Instant timerEnd = Instant.now();                                               // timer end
            int diffSeconds = (int) (timerEnd.toEpochMilli() - timerStart.toEpochMilli());  // time in ms
            timers.add(diffSeconds);
        }
        averages.add(Methods.timeAverage(timers, 5));                      // calculate and print average + add result to list timers
        timers.clear();



        // ARRAY TAIL REMOVE TEST

        for (int i = 0; i < 10; i++) {

            List<Integer> arrList = Methods.arrListCreate(10000);                          // create array list

            Instant timerStart = Instant.now();                                                  // timer start


            for (int j = arrList.size(); j > 0; j--) {
                arrList.remove(0);
            }

            Instant timerEnd = Instant.now();                                               // timer end
            int diffSeconds = (int) (timerEnd.toEpochMilli() - timerStart.toEpochMilli());  // time in ms
            timers.add(diffSeconds);
        }

        averages.add(Methods.timeAverage(timers, 6));                      // calculate and print average + add result to list timers
        timers.clear();
    }





    static void linkListTest() {

        // LINK HEAD ADD TEST

        for (int i = 0; i < 10; i++) {

            List<Integer> linkList = Methods.linkListCreate(10000);                   // create link list

            Instant timerStart = Instant.now();                                             // timer start

            for (int j = 0; j < 10000; j++) {
                linkList.add(Methods.randomNumber.nextInt(0, 500));              // add to head
            }

            Instant timerEnd = Instant.now();                                               // timer end
            int diffSeconds = (int) (timerEnd.toEpochMilli() - timerStart.toEpochMilli());  // time in ms
            timers.add(diffSeconds);
        }

        averages.add(Methods.timeAverage(timers, 7));                      // calculate and print average + add result to list timers
        timers.clear();                                                                     // clear timers list



        // LINK HEAD REMOVE TEST

        for (int i = 0; i < 10; i++) {

            List<Integer> linkList = Methods.linkListCreate(10000);                   // create link list

            Instant timerStart = Instant.now();                                             // timer start

            for (int j = linkList.size(); j > 0; j--) {
                linkList.remove(j - 1);                                                  // remove from head
            }

            Instant timerEnd = Instant.now();                                               // timer end
            int diffSeconds = (int) (timerEnd.toEpochMilli() - timerStart.toEpochMilli());  // time in ms
            timers.add(diffSeconds);

        }

        averages.add(Methods.timeAverage(timers, 8));                      // calculate and print average + add result to list timers
        timers.clear();                                                                     // clear timers list



        // LINK RANDOM ADD TEST

        for (int i = 0; i < 10; i++) {

            List<Integer> linkList = Methods.linkListCreate(10000);                   // create link list

            Instant timerStart = Instant.now();                                                  // timer start

            for (int j = 0; j < 10000; j++) {
                linkList.add(Methods.randomNumber.nextInt(0, linkList.size()), Methods.randomNumber.nextInt(0, 500));
            }

            Instant timerEnd = Instant.now();                                               // timer end
            int diffSeconds = (int) (timerEnd.toEpochMilli() - timerStart.toEpochMilli());  // time in ms
            timers.add(diffSeconds);
        }

        averages.add(Methods.timeAverage(timers, 9));                      // calculate and print average + add result to list timers
        timers.clear();



        // LINK RANDOM REMOVE TEST

        for (int i = 0; i < 10; i++) {

            List<Integer> linkList = Methods.linkListCreate(10000);                   // create link list

            Instant timerStart = Instant.now();                                                  // timer start


            for (int j = linkList.size(); j > 0; j--) {
                linkList.remove(j - 1);
            }

            Instant timerEnd = Instant.now();                                               // timer end
            int diffSeconds = (int) (timerEnd.toEpochMilli() - timerStart.toEpochMilli());  // time in ms
            timers.add(diffSeconds);
        }

        averages.add(Methods.timeAverage(timers, 10));                      // calculate and print average + add result to list timers
        timers.clear();



        // LINK TAIL ADD TEST

        for (int i = 0; i < 10; i++) {

            List<Integer> linkList = Methods.linkListCreate(10000);                   // create link list

            Instant timerStart = Instant.now();                                                  // timer start


            for (int j = 0; j < 10000; j++) {
                linkList.add(0, Methods.randomNumber.nextInt(0, 500));
            }

            Instant timerEnd = Instant.now();                                               // timer end
            int diffSeconds = (int) (timerEnd.toEpochMilli() - timerStart.toEpochMilli());  // time in ms
            timers.add(diffSeconds);
        }
        averages.add(Methods.timeAverage(timers, 11));                      // calculate and print average + add result to list timers
        timers.clear();



        // LINK TAIL REMOVE TEST

        for (int i = 0; i < 10; i++) {

            List<Integer> linkList = Methods.linkListCreate(10000);                   // create link list

            Instant timerStart = Instant.now();                                                  // timer start


            for (int j = linkList.size(); j > 0; j--) {
                linkList.remove(0);
            }

            Instant timerEnd = Instant.now();                                               // timer end
            int diffSeconds = (int) (timerEnd.toEpochMilli() - timerStart.toEpochMilli());  // time in ms
            timers.add(diffSeconds);
        }

        averages.add(Methods.timeAverage(timers, 12));                      // calculate and print average + add result to list timers
        timers.clear();
    }


    static void results(){
        System.out.println(averages.get(0));
        System.out.println(averages.get(6));
        System.out.println(averages.get(1));
        System.out.println(averages.get(7));
        System.out.println(averages.get(2));
        System.out.println(averages.get(8));
        System.out.println(averages.get(3));
        System.out.println(averages.get(9));
        System.out.println(averages.get(4));
        System.out.println(averages.get(10));
        System.out.println(averages.get(5));
        System.out.println(averages.get(11));
    }

}