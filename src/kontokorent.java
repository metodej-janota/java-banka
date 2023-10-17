import java.util.Scanner;

public class kontokorent {
    private int kontokorentLimit = 0;
    private boolean aktivniKontokorent = false;
    private Scanner sc = new Scanner(System.in);

    public kontokorent(int limit) {
        this.kontokorentLimit = limit;
    }
    public boolean aktivni(){
        if (aktivniKontokorent == true){
            return true;
        }else {
            return false;
        }
    }
    public void zadostOKontokorent() {
        if (!aktivniKontokorent) {
            System.out.println("Kolik chcete váš kontokorent?");
            int castka = sc.nextInt();
            kontokorentLimit = castka;
            System.out.println("Váš kontokorent je: " + this.kontokorentLimit);
            aktivniKontokorent = true;
        } else {
            System.out.println("Již máte kontokorent");
        }
    }

    public int getKontokorentLimit() {
        return this.kontokorentLimit;
    }

    public void informaceOUctu() {
        System.out.println("Limit kontokorentu: " + kontokorentLimit);
    }
}