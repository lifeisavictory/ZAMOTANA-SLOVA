void main() {
    Scanner scanner = new Scanner(System.in);
    Service service = new Service();
    int difficultyChoice = 0;

    System.out.println("Zahrajeme si spolu hru.");

    do {
        //START hry
        System.out.println("""            
                Z následujících možností si vyber jednu obtížnost:
                1) snadná
                2) střední
                3) obtížná
                """);
        System.out.println("Vlož odpověď: ");
        try {
            difficultyChoice = Integer.parseInt(scanner.nextLine().trim());
            service.pickRandomWord(difficultyChoice);
        } catch (NumberFormatException e) {
            System.out.println("Chyba: zadej číslo v rozmezí 1-3.");
            continue; //vraci na zacatek smycky
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            continue;
        }
        //zamichani pismen ve slove + hadani
        try {
            service.shuffleWord();
        } catch (Exception e) {
            System.out.println("Chyba při míchání písmen ve slově.");
            continue;
        }
        System.out.println("Zamíchané slovo je: " + service.getShuffledWord());
        System.out.println("Co je původní slovo?");
        String guess = scanner.nextLine().trim().toLowerCase(Locale.ROOT);
        //vyhodnoceni spravnosti (vcetne napovedy)
        service.buildHint(guess);
        //vyhodnoceni spravnosti odhadu
        service.evaluateRound(guess);
        System.out.println("Tvůj návrh: " + "\"" + service.getHint() + "\"" + " a to je " + service.getRoundResult() + " !");
        System.out.println();
        System.out.println("Kolik jsme měli kol: " + service.getRoundCount());
        System.out.println("SCORE ty vs. pocitac je: " +  service.getPlayerScore() + ":" + service.getComputerScore());
        System.out.println("Chceš si hru zopakovat a/n: ");
        String playAgainAnswer = scanner.nextLine().trim();
        if (!playAgainAnswer.equals("a")) {
            break;
        }
    } while (true);


}