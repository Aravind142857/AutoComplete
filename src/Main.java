import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Autocomplete ac = new Autocomplete("wordsALT.txt");
        Autocomplete acALT = new Autocomplete("words.txt");

        while (true) {
            System.out.println("Enter a word/phrase: ");
            Scanner read = new Scanner(System.in);
            String word = read.nextLine();
            System.out.println(word);
            String[] words = ac.autocomplete(word);
            if (words == null) {
                words = acALT.autocomplete(word);
                if (words == null) {
                    System.out.println("Sorry. Word not found in dictionary");
                } else {
                    System.out.println(Arrays.stream(words).toList().toString());
                }
            } else {
                System.out.println(Arrays.stream(words).toList().toString());
            }
        }
    }
}
