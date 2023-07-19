import java.awt.*;
import java.util.Scanner;
import java.util.StringJoiner;

public class LevelRunner {
    private final LevelManager lm = new LevelManager();
    private final Scanner scan = Main.scan;
    private int level;
    private String word = "";
    private String result = "";

    public boolean playLevel(int l) {
        result = "";
        level = l;
        System.out.println("Level " + level);
        //Word
        word = lm.getWord(level);

        //result
        for (int i = 0; i < word.length(); i++) {
            result += "_";
        }
        System.out.println(result);

        //hp
        int hp = lm.getHp(level);
        printHp(hp);

        //missed letters
        StringJoiner missed = new StringJoiner(", ");
        printMissing(missed);


        // level loop
        while (true){
            String in = scan.nextLine();
            if(word.contains(in)) revelLetter(in);
            else {
                System.out.println("Letter not in word");
                hp--;
                missed.add(in);
            }

            System.out.println("--------------------");

            if(hp < 0){
                System.out.println("Game Over");
                return false;
            }
            System.out.println(result);
            printHp(hp);
            printMissing(missed);
            if(lm.getWord(level).equals(result) || lm.getWord(level).equals(in.trim())){
                System.out.println("---------------");
                System.out.println("Level Completed");
                if(level + 1 > lm.getMax()){
                    System.out.println("Completed the Game.");
                    lm.unlock(level + 1);
                    return true;
                }
                System.out.println("Unlocked level " + (level + 1));
                lm.unlock(level + 1);
                return true;
            }
        }
    }

    private void printMissing(StringJoiner missed) {
        if(missed.length() > 0) System.out.println("Letters missed: " + missed.toString());
        else System.out.println("Letters missed: none ");
    }

    private void revelLetter(String in) {
        in.toLowerCase();
        String before = lm.getWord(level);
        char[] res = result.toCharArray();

        String out = "";
        for (int i = 0; i < in.length(); i++) {
            out += "_";
        }
        word = word.replace(in, out);
        for (int i = 0; i < word.length(); i++) {
            if(word.charAt(i) == '_'){
                res[i] = before.charAt(i);
            }
        }
        result = "";
        for (int i = 0; i < res.length; i++) {
            result += res[i];
        }
    }

    public void printHp(int hp){
        System.out.println("You have " + hp + " tries left.");
    }
}
