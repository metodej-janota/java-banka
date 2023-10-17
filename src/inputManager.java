import java.util.*;

public class inputManager {
    private Scanner sc = new Scanner(System.in);

    static void zakladMoznosti() {
        System.out.println("Vyberte možnost:");
        System.out.println("1. Vytvořit nový účet");
        System.out.println("2. Přepnout na jiný účet");
        System.out.println("3. Provádět operace na aktuálním účtu");
        System.out.println("4. Konec");
        System.out.println(" ");
        System.out.println("Vyberte číslo 1-4 podle služby kterou chcete použít");
    }

    int moznosti() {
        System.out.println("Zde jsou vaše možnosti");
        System.out.println(" ");
        System.out.println("1. Vklad");
        System.out.println("2. Výběr");
        System.out.println("3. Kontokorent");
        System.out.println("4. Spořitelský úvěr");
        System.out.println("5. Informace o účtu");
        System.out.println(" ");
        System.out.println("Vyberte číslo 1-5 podle služby kterou chcete použít");

        while (true) {
            if (sc.hasNextInt()) {
                int volba = sc.nextInt();
                sc.nextLine();
                return volba;
            } else {
                System.out.println("Ne e, zadejte číslo 1-5");
                sc.nextLine();
            }
        }
    }

    void startBanky() {
        List<bankovniUcet> bankovniUcty = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        bankovniUcet aktualniUcet = null;

        while (true) {
            inputManager.zakladMoznosti();

            int volba = sc.nextInt();
            sc.nextLine();

            switch (volba) {
                case 1:
                    bankovniUcet novyUcet = new bankovniUcet();
                    novyUcet.kontokorentUcet = new kontokorent(0);

                    novyUcet.informace();
                    bankovniUcty.add(novyUcet);
                    break;

                case 2:
                    System.out.println("Zadejte číslo účtu na který chcete přepnout:");

                    for (bankovniUcet ucet : bankovniUcty) {
                        System.out.println("Účet: " + ucet.getCisloUctu());
                    }

                    int cisloUctu = sc.nextInt();
                    sc.nextLine();

                    for (bankovniUcet ucet : bankovniUcty) {
                        if (ucet.getCisloUctu() == cisloUctu) {
                            aktualniUcet = ucet;
                            break;
                        }
                    }

                    break;

                case 3:
                    if (aktualniUcet != null) {
                        inputManager moznosti = new inputManager();
                        int volbaOperace = moznosti.moznosti();

                        switch (volbaOperace) {
                            case 1:
                                aktualniUcet.vklad();
                                break;

                            case 2:
                                aktualniUcet.vyber();
                                break;

                            case 3:
                                System.out.println("Zde jsou vaše kontokorent možnosti");
                                System.out.println(" ");
                                System.out.println("1. Zažádání o kontokorent");
                                System.out.println("2. Stav kontokorentu");
                                System.out.println(" ");
                                System.out.println("Vyberte číslo 1-2 podle služby kterou chcete použít");

                                int kontokorentVolba = sc.nextInt();
                                sc.nextLine();

                                switch (kontokorentVolba) {
                                    case 1:
                                        aktualniUcet.zavoleZadostOKontokorent();
                                        break;

                                    case 2:
                                        aktualniUcet.zavolejInformaceOUctu();
                                        break;

                                    default:
                                        System.out.println("Ne e");
                                        break;
                                }

                                break;











                            case 4:
                                System.out.println("Zde jsou vaše možnosti pro spořitelský uuuvěr");
                                System.out.println(" ");
                                System.out.println("1. Zažádání o spořitelský uuuvěr");
                                System.out.println("2. Stav spořitelského uuuvěru");
                                System.out.println(" ");
                                System.out.println("Vyberte číslo 1-2 podle služby kterou chcete použít");

                                int uverVolba = sc.nextInt();
                                sc.nextLine();

                                switch (uverVolba) {
                                    case 1:
                                        aktualniUcet.zavoleZadostOUver();
                                        break;

                                    case 2:
                                        aktualniUcet.zavoleInformaceOUveru();
                                        break;

                                    default:
                                        System.out.println("Ne e");
                                        break;
                                }
                                break;












                            case 5:
                                aktualniUcet.informaceOUctu();
                                break;

                            default:
                                System.out.println("Ne e");
                                break;
                        }
                    } else {
                        System.out.println("Nejprve přepněte na účet");
                    }
                    break;

                case 4:
                    System.out.println("Konec programu");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Ne e");
                    break;
            }
        }
    }
}