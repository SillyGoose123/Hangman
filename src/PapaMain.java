import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PapaMain {
	
	public static void main(String[] args) {
		LevelRunner levelRunner = new LevelRunner();
		if (levelRunner.firstGame() == false) {
			welcomeBack();
		} else {
			makeFirstStart();
		}
	
	}

	private static void welcomeBack() {
		//set up scanner
		Scanner scan = new Scanner(System.in);

		LevelProgressManager LevelProgressManager = new LevelProgressManager();
		System.out.println("Willkomen zurück bei Galgenmänchen");
		System.out.print("Wähle 1 um weiter zu Spielen bei Level " );
		System.out.println(LevelProgressManager.getLevel());
	    if (LevelProgressManager.getLevel() != 0) {
	    	System.out.println("Wähle 2 um den Spielstand zu reseten und erneut zu Straten bei Level 1");
	    }
		if (Yes_Or_NO.ja_nein(scan) == true) {
			System.out.println("Level " + LevelProgressManager.getLevel() + " is Loading");
			waitSeconds(5);
			try {
				if(LevelRunner.playLevel() == true) {
					System.out.println("Du hast Level " + LevelProgressManager.getLevel() + " bestanden");
					
				} else {
					
				}
			} catch (IOException e) {
				//ignore
				
			}
			
			
			
		} else {
			System.out.println("Willst du Wirklich von vorne starten? 1 ist Ja. 2 ist Nein.");
			if(Yes_Or_NO.ja_nein(scan) == true) {
				resetGame();
			} else {
				System.out.println("Level " + LevelProgressManager.getLevel() + " is Loading");
				waitSeconds(5);
				try {
					if(LevelRunner.playLevel() == true) {
						System.out.println("Du hast Level " + LevelProgressManager.getLevel() + " bestanden");
						
					} else {
						
					}
				} catch (IOException e) {
					//ignore
					
				}
			}
			
		}
	    
	}

	private static void resetGame() {
		FileWriter fw;
		try {
			fw = new FileWriter("Levels-Unlock.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("0");
			bw.close();
			makeFirstStart();
		} catch (IOException e) {
			//ignore
			e.printStackTrace();
		}
		

	}

	private static void makeFirstStart() {
		LevelProgressManager LevelProgressManager = new LevelProgressManager();

		System.out.println("Hallo und Herzlich Wilkommen bei Galgenmänchen");
		System.out.println("Das Spiel funktioniert so:");
		System.out.println("Du hast immer so viele Leben wie X unter den _ stehen." );
		System.out.println("Unter den Xsen stehen noch die Buchtsaben die Du schon geraten hast.");
		waitSeconds(10);
		System.out.println("Los gehts");
		try {
			if(LevelRunner.playLevel() == true) {
				System.out.println("Du hast Level " + LevelProgressManager.getLevel() + " bestanden");
				
			} else {
				
			}
		} catch (IOException e) {
			//ignore
			
		}
	}
	static void waitSeconds(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			//ingnore
		}
	}			
}
