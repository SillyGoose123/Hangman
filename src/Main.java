import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static int level = 0;
    private static LevelManager lm = new LevelManager();
    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        level = lm.getUnlocked();

        if(level == 0){
            System.out.println("Hello to Hangman.");
        } else if (level > lm.getMax()) {
            System.out.println("You completed the game");
            if(ask("Restart Game?")){
                lm.reset();
                level = 0;
            } else searchLevel();
        } else {
            System.out.println("Welcome back 47.");
        }
        gameloop();
    }

    private static void searchLevel() {
        System.out.println("Type a level numb between 1 and " + lm.getMax());
        int in = 0;
        while(true){
            in = Integer.parseInt(scan.nextLine());
            if(in > 0 && in < lm.getMax() + 1){
                break;
            }
        }
        lr.playLevel(in);
    }

    private static LevelRunner lr = new LevelRunner();
    private static void gameloop(){
        while (true){
            level = lm.getUnlocked();
            if(level > lm.getMax()){
                if(ask("Restart Game?")) lm.reset();
                else searchLevel();
            }
            System.out.println("Loading Level " + level + " ...");
            if(!lr.playLevel(level) && ask("Retry?"));
        }
    }

    private static boolean ask(String msg) {
        System.out.print(msg + " [Y|N]>");
        String in = scan.nextLine();
        return in.contains("Y") || in.contains("y");
    }
}