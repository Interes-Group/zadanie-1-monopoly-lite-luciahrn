package sk.stuba.fei.uim.oop;
import java.io.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;
import java.util.Random;


public class Assignment1 {

    public Assignment1(){
        super();
    }

    public void kupNehnutelnost (HraciaDoska doska, int pole,Player hrac) throws NotEnoughMoney {
        Scanner pomocna = new Scanner(System.in);
        System.out.println("Chces kupit nehnutelnost "+doska.getPolickoNaPozici(pole).getPoleName()+" za "+ doska.getPolickoNaPozici(pole).getCena()+"? Y/N\n");
        String  premenna = pomocna.nextLine();
        if (premenna.equals("Y")) {
            System.out.println("Prave si kupil" + doska.getPolickoNaPozici(pole).getPoleName());

            BigDecimal platba=doska.getPolickoNaPozici(pole).getCena();
            hrac.odoberPeniaze(platba);
            System.out.println("Aktualny stav na tvojom ucte je" +hrac.getPeniaze());



        }
    }



    public void spravTah(HraciaDoska doska) {
        Random rand = new Random();
        List <Player> hraci=doska.getPlayers();
        int pocet = 0;
        int maxPoli=24;
        BigDecimal money=new BigDecimal(2000);

        while (true) {
            for (Player hrac:hraci) {

                System.out.println("["+ hrac+ "]" );
                System.out.println(" Stav uctu hraca: "+ hrac.getPeniaze());
                int predoslaPozicia=hrac.getPole();
                int hodKockou=rand.nextInt(6);
                System.out.println(" Aktualny hod kockou: "+ hodKockou);
                hrac.zadajPole(hodKockou);

                int aktualnaPozicia=predoslaPozicia+hodKockou;
                if (aktualnaPozicia>maxPoli){
                    hrac.pridajPeniaze(money);
                    aktualnaPozicia=aktualnaPozicia-(maxPoli-1);
                }
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Posunul sa na policko: "+ doska.getPolickoNaPozici(aktualnaPozicia).getPoleName());
                hrac.setPole(aktualnaPozicia);
                if( doska.getPolickoNaPozici(aktualnaPozicia) instanceof Nehnutelnost)

                if (doska.getPolickoNaPozici(aktualnaPozicia).getStojne().compareTo(new BigDecimal(0))==1) {
                    try {
                        kupNehnutelnost(doska, aktualnaPozicia, hrac);
                    }
                    catch(NotEnoughMoney e) {
                        System.out.println("dbefyhe");
                    }

                }



            }

        }

    }

    public  Player getPlayer() {

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object

        System.out.println("Zadaj svoje meno");

        String userName = myObj.nextLine();  // Read user input
        Player hrac= new Player(userName);
        System.out.println("Meno je : " + userName);  // Output user input

        return hrac;

    }

    public  void nacitavajHracov(HraciaDoska doska) {
        Scanner pomocna = new Scanner(System.in);
        System.out.println("Pre zacatie hry a zaevidovanie hracov stlac 1:");
        String  premenna = pomocna.nextLine();
        int poradie=0;
        while (premenna.equals("1")) {
            doska.addPlayer(getPlayer());
            poradie=poradie+1;
            System.out.println("\nPoradie hraca je: "+ poradie);
            System.out.println("Ak si zapisal vsetkych hracov stlac 0 ak chces dalej zapisovat hracov stlac 1:");
            premenna = pomocna.nextLine();

        }
        if (poradie==1) {
            System.err.println("Iba jeden hrac nemoze hrat!");
            System.exit(0);
        }
        System.out.println("Hra zacina!");
        spravTah(doska);



    }




    public  void monopoly() {
        HraciaDoska doska = new HraciaDoska();
        this.nacitavajHracov(doska);
    }


    public static void main(String[] args) {
        Assignment1 monopoly= new Assignment1();
        monopoly.monopoly();
    }
}


