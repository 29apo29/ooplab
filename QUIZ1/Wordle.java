import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

/**
* The program is a wordle game program.
* You can give the words with arguments or with inputs whatever you want
*
* @author  220717057
* @version 1.0
* @since   16.03.2024
*/

public class Wordle {
    public static void main(String[] args) {
        String[] flSeries = readFile();
        String keyWord = getRandomInSeries(flSeries);
        String[] predicts;
        if (args.length == 6) { //if there are 6 words in arguments.
            predicts = takeCommand(flSeries, args, keyWord);
        } else { //if there are no 6 words in arguments.
            predicts = takeInput(flSeries, keyWord);
        }
        if (predicts[predicts.length - 1] != keyWord) { // if the predicts are not true
            System.out.println("You failed! The key word is " + keyWord);
            System.out.println("Your predicts:");
            for(String predict:predicts){
                System.out.println(predict);
            }
        }
    }

    private static String[] takeCommand(String[] series, String[] predicts, String key) {
        /**
         * Values getting from command line and controling
         */
        String[] result = new String[0];
        for (int i = 0; i < predicts.length; i++) {
            String predict = predicts[i].toUpperCase(Locale.ENGLISH);
            if (predict.length() != key.length()) { // the predict's length is not true
                System.out.println("Try" + (i + 1) + "(" + predict + "): The length of word must be five!");
            } else if (!isValueInSeries(series, predict)) { // the predict is not match with the dataset
                System.out.println("Try" + (i + 1) + "(" + predict + "): The Word does not exist in the dictionary!");
            } else { // there is no problem
                System.out.println("Try" + (i + 1) + "(" + predict + "):");
                compareKeyInput(key, predict);
            }

            result = ArrayUtils.add(result, predict);
            if (predict.equals(key)) { // predict is true
                System.out.println("Congratulations! You guess right in " + (i + 1) + "th shot!");
                break;
            }
        }
        System.out.println("You exceeded maximum try shot!");
        return result;
    }

    private static void compareKeyInput(String key, String predict) {
        /**
         * Comparing input's each letter with the key value 
         */
        for (int i = 0; i < 5; i++) { // comparing the word's each letter with the key value
            char let = predict.charAt(i);
            int index = key.indexOf(let);
            if (index != -1 && i == index) { // right location
                System.out.println((i + 1) + ". letter exist and located in right position.");
            } else if (index != -1) { // wrong location
                System.out.println((i + 1) + ". letter exist but located in wrong position.");
            } else { // wrong letter
                System.out.println((i + 1) + ". letter  does not exist.");
            }
        }
    }

    private static boolean isValueInSeries(String[] keys, String predict) {
        /**
         * The serie has the value?
         * 
         */
        boolean result = false;
        if (ArrayUtils.contains(keys, predict)) {
            result = true;
        }
        return result;
    }

    private static String[] takeInput(String[] series, String key) {
        /**
         * Values getting from input and controling
         */
        String[] result = new String[0];
        Scanner sc = new Scanner(System.in);
        String inp = null;
        while(result.length < 6) { //taking inputs
            System.out.println("Please write " + (result.length + 1) + "th word:");
            inp = sc.nextLine().toUpperCase(Locale.ENGLISH);
            if (inp.length() != key.length()) { // if the input's length is not equal the key value
                System.out.println("Try" + (result.length + 1) + "(" + inp + ") The length of word must be five!");
                continue;
            } else if (!isValueInSeries(series, inp)) {// the input is not match with the dataset
                System.out.println("Try" + (result.length + 1) + "(" + inp + ") The Word does not exist in the dictionary!");
            } else { // there is no problem
                System.out.println("Try" + (result.length + 1) + "(" + inp + "):");
                compareKeyInput(key, inp);

            }
            result = ArrayUtils.add(result, inp);
            if (inp.equals(key)) {
                System.out.println("Congratulations! You guess right in " + (result.length) + "th shot!");
            }
        }
        System.out.println("You exceeded maximum try shot!");
        sc.close();
        return result;
    }

    private static String getRandomInSeries(String[] series) {
        /**
         * Get random value in an serie
         */
        int randNum = getRandInt(0, series.length);
        String result = series[randNum];
        return result;
    }

    private static String[] readFile() {
        /**
         * reading file and write it in a serie.
         * 
         * @return String[]
         */
        String path = new File("").getAbsolutePath() + "/dict.txt";
        File fl = new File(path);
        if (!fl.exists()) {
            path = new File("").getAbsolutePath() + "/QUIZ1/dict.txt";
            fl = new File(path);
        }

        Scanner scRead;
        // String[] resultChangable = new String[0];
        String[] result = new String[2317];
        try {
            scRead = new Scanner(fl);
            int counter = 0;
            while (scRead.hasNextLine()) {
                String line = scRead.nextLine();
                // ArrayUtils.add(resultChangable, line);
                result[counter] = line;
                counter++;
            }
            scRead.close();
        } catch (FileNotFoundException e) {
            System.out.println("File Error");
            e.printStackTrace();
            System.exit(0);
        }
        return result;

    }

    public static int getRandInt(int min, int max) {
        /**
         * getRandom Integer
         */
        int result = (int) ((Math.random() * (max - min)) + min);
        return result;
    }
}
