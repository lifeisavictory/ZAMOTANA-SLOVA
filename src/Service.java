import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class Service {

    private String originalWord = "";
    private String shuffledWord = "";
    private int roundCount = 0;
    private int playerScore = 0;
    private int computerScore = 0;
    private String hint = "";
    private String roundResult = "";

    public Service() {
    }

    public String getOriginalWord() {
        return originalWord;
    }

    public String getShuffledWord() {
        return shuffledWord;
    }

    public int getRoundCount() {
        return roundCount;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public int getComputerScore() {
        return computerScore;
    }

    public String getHint() {
        return hint;
    }

    public String getRoundResult() {
        return roundResult;
    }

    /**
     * Vybere nahodne slovo z dane obtiznosti.
     * @param difficulty volba obtiznosti
     */
    public void pickRandomWord(int difficulty) {
        if (difficulty == 1) {
            originalWord = Words.EASY.getRandomWord().toLowerCase(Locale.ROOT);
        } else if (difficulty == 2) {
            originalWord = Words.MEDIUM.getRandomWord().toLowerCase(Locale.ROOT);
        } else if (difficulty == 3) {
            originalWord = Words.HARD.getRandomWord().toLowerCase(Locale.ROOT);
        } else {
            throw new IllegalArgumentException("Neplatná volba - " + difficulty + " - (povoleno 1-3).");
        }
    }

    /**
     * Zamichá písmena ve slově.
     */
    public void shuffleWord() {
        //potrebujeme List z char, abysme ho mohli zamichat pres shuffle()
        List<Character> letters = new ArrayList<>();
        StringBuilder shuffled;
        do {
            letters.clear();
            shuffled = new StringBuilder();
            for (char letter : originalWord.toCharArray()) {
                letters.add(letter);
            }
            Collections.shuffle(letters);
            for (char letter : letters) {
                shuffled.append(letter);
            }
        } while (originalWord.equals(shuffled.toString()));
        shuffledWord = shuffled.toString();
    }


    /**
     * Vyhodnotí odhad uživatele
     * Za špatně uhodnuté znaky dosadí znak "otazníku"
     *
     * @param guess odhad uživatele
     */
    public void buildHint(String guess) {
        hint = "";
        if (guess.length() != originalWord.length()) {
            hint = "Slovo neodpovídá svojí délkou";
        } else {
            for (int i = 0; i < originalWord.length(); i++) {
                if (guess.charAt(i) == originalWord.charAt(i)) {
                    hint += guess.charAt(i);
                } else {
                    hint += "?";
                }
            }
        }
    }


    /**
     * Vyhodnotí odhad uživatele a aktualizuje skóre.
     *
     * @param guess odhad uživatele
     */
    public void evaluateRound(String guess) {
        roundCount++;
        if (guess.equals(originalWord)) {
            playerScore++;
            roundResult = "SPRÁVNĚ";
        } else {
            computerScore++;
            roundResult = "ŠPATNĚ";
        }
    }


}