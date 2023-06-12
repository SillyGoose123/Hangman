import java.util.Scanner;

public class Yes_Or_NO {

	public static boolean ja_nein(Scanner scanner) {
		String input = scanner.nextLine();
		while (true) {
			int number = -1;
			try {
				number = Integer.parseInt(input.trim());
			} catch (Exception e) {
				// ignore
			}
			switch (number) {
			case 1:
				return true;
			case 2:
				return false;
			default:
				System.out.println("Number hat einen anderen Wert als 1 oder 2 gebe erneut eine zahl ein");
				input = scanner.nextLine();
			}
		}
	}

}
