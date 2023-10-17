import java.util.Scanner;

public class sporitelskyUver extends kontokorent{
    private Scanner sc = new Scanner(System.in);
    private int uver = 0;
    int dohromady = 0;

    public sporitelskyUver(int limit) {
        super(limit);
    }

    public int zadostOSporitelskyUver() {
        System.out.println("Kolik chcete váš spořitelský úvěr?");
        int castka = sc.nextInt();
        this.dohromady += castka;
        this.uver = 5;
        return castka;
    }

    int chceVlozitPenizeTakMuJeSeberemeLmao(){
        return this.dohromady;
    }

    int beremePrachy(int castka){
        int swag = (castka / 100) * 95;
        this.dohromady -= (castka / 100) * this.uver;
        return swag;
    }

    public void informaceOSporitelskyUver(){
        System.out.println("Dohromady jste si půjčili: " + this.dohromady);
        System.out.println("Dohromady je Váš úvěr: " + this.uver + "%");
    }

    public int dejMiProcento(){
        return this.uver;
    }
}
