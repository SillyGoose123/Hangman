import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LevelLoader {
	static String loadLevels() throws IOException {
		FileReader fr = new FileReader("Levels.txt");
		BufferedReader br = new BufferedReader(fr);
	
			switch (LevelProgressManager.getLevel1()) {
			case 1:
				String zeile1 = br.readLine();
				br.close();
				return zeile1;
			case 2:
				br.readLine();
				String zeile2 = br.readLine();
				br.close();
				return zeile2;
			case 3:
				br.readLine();
				br.readLine();
				String zeile3 = br.readLine();
				br.close();
				return zeile3;
			case 4:
				br.readLine();
				br.readLine();
				br.readLine();
				String zeile4 = br.readLine();
				br.close();
				return zeile4;
			case 5:
				br.readLine();
				br.readLine();
				br.readLine();
				br.readLine();
				String zeile5 = br.readLine();
				br.close();
				return zeile5;

			}

		
		br.close();
		return null;

	}
}
