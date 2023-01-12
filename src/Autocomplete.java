import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Autocomplete {
    private final int MAX = 5;
    HashSet<String> dictionary;
    Trie tree;
    public Autocomplete(String filename) {
        dictionary = makeDictionary(filename);
        tree = new Trie();
        makeTrie();
    }
    private HashSet<String> makeDictionary(String filename) {
        try {
            HashSet<String> dictionary = new HashSet<>();
            File fp = new File(filename);
            Scanner scan = new Scanner(fp);
            while (scan.hasNextLine()) {
                String word = scan.nextLine();
                if (word.length() > 1) {
                    dictionary.add(word);
                }
            }
            return dictionary;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
    private void makeTrie() {
        for (String s: dictionary) {
            tree.put(s);
        }
    }
    public String[] autocomplete(String word) {
        ArrayList<String> list = tree.get(word);
        if (list == null) {
            return null;
        }
        int num = Math.min(list.size(), MAX);
        return list.subList(0, num).toArray(new String[]{});
    }
}
