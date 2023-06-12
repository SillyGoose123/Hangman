import java.util.Scanner;

public class Letters {

	public static void printUnderscorebylenght(String split) {
		int lenght = split.length();
		for (int i = 0; i < lenght; i++) {
			System.out.print("_ ");

		}
	}

	public static void printLivesbylenght(String split) {
		int Lives = Integer.parseInt(split);
		for (int i = 0; i < Lives; i++) {
			System.out.print("X ");
		}

	}

	public static void takedLetterSanner(String split) {
		System.out.println(" ");
		System.out.print("Gebe einen Buchstaben ein um diesen auszuprobieren ");
		Scanner scan = new Scanner(System.in);
		String line = scan.next().toLowerCase();
		scan.close();
		if (line.length() != 1) {
			System.out.println("Gib bitte nur einen Buchstaben ein");
		}
		//char letter = line.charAt(0);
		
	}
}
