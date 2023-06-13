import java.io.*;

public class LevelManager {

    private String[] word = {
            "pommes",
            "java",
            "baum",
            "rust",
            "radler",
            "manfred",
            "himmel",
            "badeschuhe",
            "windrad",
            "schnitzel",
            "bigtastybeacon",
            "petflasche",
            "wiese",
            "riese",
            "leitplanke",
            "wheat",
            "rasenmäher",
            "steak",
            "bigmac",
            "lampe",
            "addiletten",
            "bildschirm",
            "rad",
            "brücke",
            "tastatur",
            "gräser",
            "auto",
            "betriebsystem",
            "sitz",
            "lastkraftwagen",
            "teppich",
            "berg",
            "gigached",
            "lautsprecher",
            "becherhalter",
            "feuerlöscher",
            "wanduhr",
            "rakete",
            "limonade",
            "sonnebrille",
            "kino",
            "theater",
            "musical",
            "plane",
            "lehrpersonal",
            "bekleidung",
            "musik",
            "gueterzug",
            "frankfurt",
            "hauptbahnhof",
            "objektorientiert",
            "bücherei",
            "galgenmännchen",
            "microwelle",
            "kühlschrank",
            "gefrierschrank",
            "nackenkissen",
            "starwars",
            "ledwall",
            "konzert",
            "hölle",
            "glaube",
            "kirchlich",
            "bewaffnet",
            "büroklammer",
            "autobahn",
            "fähre",
            "schiffart",
            "speedboot",
            "weinberg",
            "trauben",
            "vehkehrsschild",
            "ausschuss",
            "ekelig",
            "busbahnhof",
            "haare",
            "zopf",
            "fischgraete",
            "pfeife",
            "santitaeter",
            "bakterienkultur",
            "biologe",
            "ziegenbart",
            "schnauzer",
            "baukran",
            "ladekabel",
            "kopfhörer",
            "sicherheitsgurt",
            "programiersprache",
            "polohemd",
            "ohring",
            "flugzeugabwehr",
            "landwirtschaft",
            "atomkraftwerk",
            "kapuzzenpullover",
            "rucksack",
            "reisetasche",
            "koffer",
            "gürtel",
            "knopf",
            "racketenwerfer"
    };

    public String getWord(int level){
        return word[level -1].toLowerCase();
    }

    public int getHp(int level) {
        int i = word[level - 1].length();
        while (i > 20){
            i--;
        }
        return i;
    }


    //unlock
    public void unlock(int level){
        File file = new File("unlocked.txt");
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            FileWriter w = new FileWriter(file);
            w.write(level + "");
            w.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int getUnlocked(){
        File file = new File("unlocked.txt");
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                FileWriter w = new FileWriter(file);
                w.write("1");
                w.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return 0;
        }
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            int i = Integer.parseInt(br.readLine());
            br.close();
            return i;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int getMax() {
        return word.length;
    }

    public void reset() {
        File file = new File("unlocked.txt");
        if(!file.exists()) file.delete();
    }
}
