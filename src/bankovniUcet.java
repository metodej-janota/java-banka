import java.util.*;

public class bankovniUcet {
    Scanner sc = new Scanner(System.in);
    List<Integer> listUctu = new ArrayList<>();
    private int cisloUctu;
    private String jmeno;
    private String prijmeni;
    private String adresa;
    private boolean vydanaKarta;
    private boolean login;
    private boolean proJistotu = false;
    protected int penize = 0;
    kontokorent kontokorentUcet = new kontokorent(0);
    sporitelskyUver uver = new sporitelskyUver(0);

    void informace() {
        while (true) {
            if (this.proJistotu == false) {
                zadejInformace();
                pravdiveInforamce();
            } else {
                this.proJistotu = true;
                break;
            }
        }
    }

    void novyUser() {
        login = false;
        proJistotu = false;
        informace();
    }

    void zavoleZadostOKontokorent() {
        this.kontokorentUcet.zadostOKontokorent();
    }

    void getUver(){
        this.uver.dejMiProcento();
    }

    void zavoleZadostOUver() {
        int pripocti = this.uver.zadostOSporitelskyUver();

        System.out.println("K vašemu účtu bylo připočteno: " + pripocti);
        this.penize += pripocti;
        System.out.println("Stav vašeho účtu: " + this.penize);
    }

    void zavolejInformaceOUctu() {
        this.kontokorentUcet.informaceOUctu();
    }

    void zavoleInformaceOUveru() {
        this.uver.informaceOSporitelskyUver();
    }

    private void zadejInformace() {
        System.out.println("Zadejte své jméno");
        this.jmeno = sc.nextLine();

        System.out.println("Zadejte své příjmení");
        this.prijmeni = sc.nextLine();

        System.out.println("Zadejte svou adresu");
        this.adresa = sc.nextLine();

        System.out.println("Je vaše karta vydaná?");
        System.out.println("ANO/NE");

        while (true) {
            String kontrola = sc.nextLine();
            if (kontrola.equals("ANO") || kontrola.equals("NE")) {
                if (kontrola.equals("ANO")) {
                    this.vydanaKarta = true;
                    break;
                } else {
                    this.vydanaKarta = false;
                    break;
                }
            } else {
                System.out.println("Ne e");
            }
        }

        mezera();
    }

    void mezera() {
        for (int i = 0; i < 10; i++) {
            System.out.println(" ");
        }
    }

    private void pravdiveInforamce() {
        System.out.println("JSOU INFORMACE PRAVDIVÉ? (ANO/NE)");
        System.out.println("Jméno: " + this.jmeno);
        System.out.println("Příjmení: " + this.prijmeni);
        System.out.println("Adresa: " + this.adresa);
        if (this.vydanaKarta == true) {
            System.out.println("Vydaná karta: ANO");
        } else {
            System.out.println("Vydaná karta: NE");
        }

        while (true) {
            String kontrola = sc.nextLine();
            if (kontrola.equals("ANO") || kontrola.equals("NE")) {
                if (kontrola.equals("ANO")) {
                    this.login = true;
                    this.proJistotu = true;
                    cisloUctu();
                    break;
                } else {
                    break;
                }
            } else {
                System.out.println("Ne e");
            }
        }
    }


    private void cisloUctu() {
        int noveCislo;
        do {
            noveCislo = new Random().nextInt(10000000);
        } while (listUctu.contains(noveCislo));

        this.cisloUctu = noveCislo;
        listUctu.add(this.cisloUctu);
    }

    void informaceOUctu() {
        mezera();
        System.out.println("Jméno: " + this.jmeno);
        System.out.println("Příjmení: " + this.prijmeni);
        System.out.println("Adresa: " + this.adresa);
        if (this.vydanaKarta == true) {
            System.out.println("Vydaná karta: ANO");
        } else {
            System.out.println("Vydaná karta: NE");
        }
        System.out.println("Peníze na účtě: " + this.penize);
        System.out.println("Váš kontokorent: " + this.kontokorentUcet.getKontokorentLimit());
        System.out.println("Číslo účtu: " + this.cisloUctu);
        System.out.println(" ");
    }

    void vklad() {
        mezera();
        System.out.println("Kolik chcete vložit?");
        int castka = this.kontrolaCastky();
        int stavSporitelsky = this.uver.chceVlozitPenizeTakMuJeSeberemeLmao();
        if (stavSporitelsky != 0){
            System.out.println("Splácíš dluh bro");
            int swag = this.uver.beremePrachy(castka);
            this.penize += swag;
            System.out.println("Bylo ti připočteno " + swag + " z půvoních " + castka );
        }else {
            this.penize += castka;
        }
        System.out.println("Stav vašeho účtu: " + this.penize);
    }

    void vyber() {
        mezera();
        System.out.println("Kolik chcete vybrat?");
        int castka = this.kontrolaCastky();

        if (this.penize - castka > 0){
            this.penize = (this.penize - castka);

            System.out.println("Stav vašeho účtu: " + this.penize);

        }else if (this.penize - castka < 0) {
            if (this.kontokorentUcet.aktivni() == true) {
                if ((this.kontokorentUcet.getKontokorentLimit() + this.penize) < castka) {
                    System.out.println("Nedostatek peněz na účtě ani na kontokorentu lol");

                } else if (((this.kontokorentUcet.getKontokorentLimit()) + (this.penize)) > castka) {
                    this.penize -= castka;

                    System.out.println("Na Vašem účtě nebylo dostatečně peněz => čerpáte z kontokorentu");
                    System.out.println("Stav Vašich peněz: " + this.penize);
                }else {
                    System.out.println("ne e");
                }
            }else {
                System.out.println("Nedostatek peněz na účtě");
            }
        }
    }

    protected int kontrolaCastky() {
        while (true) {
            if (sc.hasNextInt()) {
                int castka = sc.nextInt();
                sc.nextLine();
                return castka;
            } else {
                System.out.println("Ne e");
                sc.nextLine();
            }
        }
    }

    public int getCisloUctu() {
        return this.cisloUctu;
    }
}
