import java.util.List;
import java.util.Random;

public enum Words {

    EASY(
            "pes", "dům", "les", "kos", "led", "sůl", "mák", "noc", "den", "oko",
            "nos", "kůň", "myš", "sýr", "čaj", "míč", "byt", "sad", "dub", "lev",
            "vlk", "had", "rak", "zub", "vůz", "syn", "koš", "ryba", "žába", "růže",
            "léto", "zima", "ucho", "ruka", "auto", "vlak", "hrad", "most", "pole", "sníh",
            "déšť", "mrak", "vítr", "list", "kost", "koza", "ovce", "sova", "pták", "dort",
            "bota", "kolo", "hora", "řeka", "voda", "mapa", "lano", "pero", "noha", "oheň"
    ),
    MEDIUM(
            "kočka", "škola", "strom", "kniha", "tužka", "židle", "lampa", "hrnek", "mléko", "houba",
            "včela", "motýl", "ježek", "liška", "skála", "měsíc", "mrkev", "papír", "skříň", "kabát",
            "sešit", "zajíc", "opice", "zebra", "sopka", "jablko", "hruška", "slunce", "hvězda", "chleba",
            "medvěd", "jezero", "jahoda", "malina", "třešeň", "cibule", "okurka", "postel", "čepice", "vrabec",
            "kohout", "kachna", "žirafa", "delfín", "ostrov", "kytara", "zahrada", "řeřicha", "květina", "vajíčko",
            "letadlo", "silnice", "počítač", "koberec", "kalhoty", "veverka", "slepice", "planeta", "vesnice", "polévka"
    ),
    HARD(
            "knihovna", "zmrzlina", "čokoláda", "lednička", "kalendář", "hudebník", "sněhulák", "televize", "brambora", "vrtulník",
            "mravenec", "papoušek", "motocykl", "krokodýl", "pomeranč", "tiskárna", "kuchařka", "čtvrtletí", "nemocnice", "kamarádka",
            "rozhledna", "železnice", "elektřina", "zemědělec", "astronaut", "prázdniny", "zahradník", "hvězdárna", "nosorožec", "palačinka",
            "bramborák", "obrazovka", "sluchátka", "olympiáda", "basketbal", "veterinář", "architekt", "houslista", "křižovatka", "dinosaurus",
            "spisovatel", "matematika", "lokomotiva", "fotografie", "chobotnice", "klávesnice", "fotbalista", "meteorolog", "kanalizace", "parkoviště",
            "restaurace", "parašutista", "reproduktor", "supermarket", "programování", "mateřídouška", "ministerstvo", "dobrodružství", "nakladatelství", "velvyslanectví"
    );

    private static final Random RANDOM = new Random();

    private final List<String> words;

    Words(String... words) {
        this.words = List.of(words);
    }

    public String getRandomWord() {
        int index = RANDOM.nextInt(words.size());
        return words.get(index);


    }
}