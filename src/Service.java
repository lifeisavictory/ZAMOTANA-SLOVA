import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class Service {

    private String nahodneSlovo = "";
    private String zamichaneSlovo = "";
    private int pocetKol = 0;
    private int scoreClovek = 0;
    private int scorePocitac = 0;
    private String vyhodnoceniZnaku = "";
    private String vyhodnoceni = "";

    public Service() {
    }

    public String getNahodneSlovo() {
        return nahodneSlovo;
    }

    public String getZamichaneSlovo() {
        return zamichaneSlovo;
    }

    public int getPocetKol() {
        return pocetKol;
    }

    public int getScoreClovek() {
        return scoreClovek;
    }

    public int getScorePocitac() {
        return scorePocitac;
    }

    public String getVyhodnoceniZnaku() {
        return vyhodnoceniZnaku;
    }

    public String getVyhodnoceni() {
        return vyhodnoceni;
    }

    /**
     * Vybere nahodne slovo z dane obtiznosti.
     * @param tvojeVolba volba obtiznosti
     */
    public void vyberNahodneSlovo(int tvojeVolba) {
        if (tvojeVolba == 1) {
            nahodneSlovo = Words.EASY.getRandomWord().toLowerCase(Locale.ROOT);
        } else if (tvojeVolba == 2) {
            nahodneSlovo = Words.MEDIUM.getRandomWord().toLowerCase(Locale.ROOT);
        } else if (tvojeVolba == 3) {
            nahodneSlovo = Words.HARD.getRandomWord().toLowerCase(Locale.ROOT);
        } else {
            throw new IllegalArgumentException("Neplatná volba - " + tvojeVolba + " - (povoleno 1-3).");
        }
    }

    /**
     * Zamichá písmena ve slově.
     */
    public void zamichejSlovo() {
        //potrebujeme List z char, abysme ho mohli zamichat pres shuffle()
        List<Character> Letters = new ArrayList<>();
        StringBuilder zmeneneSlovo;
        do {
            Letters.clear();
            zmeneneSlovo = new StringBuilder();
            for (char d : nahodneSlovo.toCharArray()) {
                Letters.add(d);
            }
            Collections.shuffle(Letters);
            for (char c : Letters) {
                zmeneneSlovo.append(c);
            }
        } while (nahodneSlovo.equals(zmeneneSlovo.toString()));
        zamichaneSlovo = zmeneneSlovo.toString();
    }


    /**
     * Vyhodnotí odhad uživatele
     * Za špatně uhodnuté znaky dosadí znak "otazníku"
     *
     * @param tvujOdhadPuvodnihoSlova odhad uživatele
     */
    public void vyhodnotOdhadSNapovedou(String tvujOdhadPuvodnihoSlova) {
        vyhodnoceniZnaku = "";
        if (tvujOdhadPuvodnihoSlova.length() != nahodneSlovo.length()) {
            vyhodnoceniZnaku = "Slovo neodpovídá svojí délkou";
        } else {
            for (int i = 0; i < nahodneSlovo.length(); i++) {
                if (tvujOdhadPuvodnihoSlova.charAt(i) == nahodneSlovo.charAt(i)) {
                    vyhodnoceniZnaku += tvujOdhadPuvodnihoSlova.charAt(i);
                } else {
                    vyhodnoceniZnaku += "?";
                }
            }
        }
    }


    /**
     * Vyhodnotí odhad uživatele a aktualizuje skóre.
     *
     * @param tvujOdhadPuvodnihoSlova odhad uživatele
     */
    public void vyhodnotKolo(String tvujOdhadPuvodnihoSlova) {
        pocetKol++;
        if (tvujOdhadPuvodnihoSlova.equals(nahodneSlovo)) {
            scoreClovek++;
            vyhodnoceni = "SPRÁVNĚ";
        } else {
            scorePocitac++;
            vyhodnoceni = "ŠPATNĚ";
        }
    }


}