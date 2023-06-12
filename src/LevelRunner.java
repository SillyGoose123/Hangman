import java.io.IOException;

public class LevelRunner {

	private LevelProgressManager levelProgress = new LevelProgressManager();
	
	/**
	 * Play next level.
	 * 
	 * @return true if played successfully, else false
	 */
	public static boolean playLevel() throws IOException {
		String levels = LevelLoader.loadLevels();
		String [] split = levels.split(";");
		String [] levelsplit = split[LevelProgressManager.getLevel1() + 1].split(",");
		System.out.println(levels);
		Letters.printUnderscorebylenght(levelsplit[2]);
        Letters.printLivesbylenght(levelsplit[1]);
        PapaMain.waitSeconds(1);
		Letters.takedLetterSanner(split[2]); 
		return false;
	}

	
		
	

	public boolean firstGame() {
		return levelProgress.isFirstGame();

	}

}
