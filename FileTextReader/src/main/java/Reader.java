import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Reader {
    public static void main(String[] args) {
        System.out.println(wordCount("text.txt"));
//        System.out.println(numberOfLines("text.txt"));
//        System.out.println(averageLettersPerWord("text.txt"));
//        System.out.println(mostCommonLetter("text.txt"));
    }

    public static StringBuilder fileReader(String file) { //methods reads the file
        StringBuilder text = new StringBuilder();
        try {
            File textFile = new File(file);
            Scanner scan = new Scanner(textFile);
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                text.append(line).append("\n ");
            }
        }catch (FileNotFoundException e){
            System.out.println("File not found");
        }
        return text;
    }

    public static String singleString(String file) { // method returns a single string without new lines
        StringBuilder text = fileReader(file);
        String longString =  text.toString();
        return longString.replaceAll("[\n]", " ").toLowerCase();
    }

    public static char mostCommonLetter(String file) {
        String single = singleString(file);
        String letters = single.replaceAll("[^a-z]", ""); // removes all non-alphabetic characters
        char maxChar = ' ';
        int maxCount = 0;
        int[] charCount = new int[128];
        for (int i = letters.length() - 1; i >= 0; i--) {
            char ch = letters.charAt(i);
            if (++charCount[ch] >= maxCount) {
                maxCount = charCount[ch];
                maxChar = ch;
            }
        }
        return maxChar;
    }

    public static double averageLettersPerWord(String file){
        int wordCount = wordCount(file);
        String single = singleString(file);
        String letters = single.replaceAll("[^a-z]", ""); // removes all non-alphabetic characters
        double numberOfLetters = letters.length();
        return Math.round(numberOfLetters / wordCount * 10.0) / 10.0; // rounds it down to one decimal place
    }

    public static int numberOfLines(String file) {
        StringBuilder text = fileReader(file);
        String textString = text.toString();
        int lines = textString.split("[\n]").length;
        return lines - 1;
    }

    public static int wordCount(String file) {
        String single = singleString(file);
        StringTokenizer tokens = new StringTokenizer(single);
        return tokens.countTokens();
    }
}
