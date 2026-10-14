void main() {
    Scanner scanner = new Scanner(System.in);
    Service service = new Service();
    int tvojeVolba = 0;

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
            tvojeVolba = Integer.parseInt(scanner.nextLine().trim());
            service.vyberNahodneSlovo(tvojeVolba);
        } catch (NumberFormatException e) {
            System.out.println("Chyba: zadej číslo v rozmezí 1-3.");
            continue; //vraci na zacatek smycky
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            continue;
        }
        //zamichani pismen ve slove + hadani
        try {
            service.zamichejSlovo();
        } catch (Exception e) {
            System.out.println("Chyba při míchání písmen ve slově.");
            continue;
        }
        System.out.println("Zamíchané slovo je: " + service.getZamichaneSlovo());
        System.out.println("Co je původní slovo?");
        String tvujOdhadPuvodnihoSlova = scanner.nextLine().trim().toLowerCase(Locale.ROOT);
        //vyhodnoceni spravnosti (vcetne napovedy)
        service.vyhodnotOdhadSNapovedou(tvujOdhadPuvodnihoSlova);
        //vyhodnoceni spravnosti odhadu
        service.vyhodnotKolo(tvujOdhadPuvodnihoSlova);
        System.out.println("Tvůj návrh: " + "\"" + service.getVyhodnoceniZnaku() + "\"" + " a to je " + service.getVyhodnoceni() + " !");
        System.out.println();
        System.out.println("Kolik jsme měli kol: " + service.getPocetKol());
        System.out.println("SCORE ty vs. pocitac je: " +  service.getScoreClovek() + ":" + service.getScorePocitac());
        System.out.println("Chceš si hru zopakovat a/n: ");
        String odpoved = scanner.nextLine().trim();
        if (!odpoved.equals("a")) {
            break;
        }
    } while (true);


}