import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LevelProgressManager {

	private static final File LEVEL_PROGRESS_FILE = new File("Level_Unlock.txt");

	private int level;

	public LevelProgressManager() {
		level = getUnlockedLevel();
	}

	public int getLevel() {
		getUnlockedLevel();
		return level;
	}

	public boolean isFirstGame() {
		if (getUnlockedLevel() == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	private static int getUnlockedLevel() {
		Scanner scan = null;
		try {
			scan = new Scanner(LEVEL_PROGRESS_FILE);
			if (scan.hasNextInt()) {
				return scan.nextInt();
			}
			
		} catch (IOException e) {
        //ignore	
		} finally {
			if (scan != null) {
				scan.close();
			}
		}
		return 0;
	}

	public void increaseUnlockedLevel() {
		level++;
		FileWriter fw = null;
		try {
			fw = new FileWriter(LEVEL_PROGRESS_FILE);
			fw.write(Integer.toString(level));
		} catch (IOException e) {
			// ignore
		} finally {
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					// Ignore
				}
			}
		}
	}

	public static int getLevel1() {
		int level1 = getUnlockedLevel();
		return level1 ;
		
		}
	}


