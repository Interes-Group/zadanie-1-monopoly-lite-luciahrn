package sk.stuba.fei.uim.oop;
import java.io.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;
import java.util.Random;


public class Assignment1 {
    private Sance sance=new Sance();
    public Assignment1(){
        super();

    }




    public void kupNehnutelnost (HraciaDoska doska, int pole,Player hrac) throws NotEnoughMoney {
        Scanner pomocna = new Scanner(System.in);
        Nehnutelnost neh = (Nehnutelnost) doska.getPolickoNaPozici(pole);
        BigDecimal peniazeHraca=hrac.getPeniaze();
        BigDecimal cena = neh.getCena();
        if (neh.getOwner()==null) {     //ak nema owner

            if (peniazeHraca.compareTo(cena)>=0) {
                System.out.println("Chces kupit nehnutelnost " + doska.getPolickoNaPozici(pole).getPoleName() + " za " + doska.getPolickoNaPozici(pole).getCena() + "? Y/N");
                String premenna = pomocna.nextLine();
                if (premenna.equals("Y")) {
                    System.out.println("Prave si kupil " + doska.getPolickoNaPozici(pole).getPoleName());
                    neh.setOwner(hrac);

                    BigDecimal platba = doska.getPolickoNaPozici(pole).getCena();
                    hrac.odoberPeniaze(platba);

                    System.out.println("Aktualny stav na tvojom ucte je " + hrac.getPeniaze() + "\n");
                }
            }
            else  {
                System.out.println("Nemáš peniaze na tuto nehnutelnost!!");
            }

        }
        else if (neh.getOwner()!=null) { //zaplat stojne
            if (!neh.getOwner().equals(hrac)) {
                System.out.println("Stupil si na policko hraca " + neh.getOwner() + " a musis mu zaplatit stojne " + neh.getStojne() + "!");
                hrac.odoberPeniaze(neh.getStojne());
                neh.getOwner().pridajPeniaze(neh.getStojne());
            }


        }
    }

    public void stojisVoVazeni (HraciaDoska doska,Player hrac) {
        if (hrac.getKolkoUzJeNaPoliVazenie()==0) {
            hrac.setKolkoUzJeNaPoliVazenie(1);
        }

        else if (hrac.getKolkoUzJeNaPoliVazenie()==1) {
            hrac.setKolkoUzJeNaPoliVazenie(2);
        }

        else if (hrac.getKolkoUzJeNaPoliVazenie()==2) {
            hrac.setKolkoUzJeNaPoliVazenie(0);
        }

    }

    public void vyberTypPola(HraciaDoska doska,int pole,Player hrac) throws NotEnoughMoney  {

        if (doska.getPolickoNaPozici(pole) instanceof Nehnutelnost) {

                kupNehnutelnost(doska, pole, hrac);

        }
        if (doska.getPolickoNaPozici(pole) instanceof PolePlatbaDane)  {
            PolePlatbaDane dan = (PolePlatbaDane) doska.getPolickoNaPozici(pole);
            System.out.println("Musíš zaplatiť daň 500!");
            hrac.odoberPeniaze(dan.getDan());

        }

        if (doska.getPolickoNaPozici(pole) instanceof PoleVazanie) {
            System.out.println("Dostal si sa na špeciálne políčko Väzenia, stojíš dve kolá!");
            hrac.setKolkoUzJeNaPoliVazenie(1);

        }

        if (doska.getPolickoNaPozici(pole) instanceof PolePolicia) {
            System.out.println("Dostal si sa na špeciálne políčko Polície, ideš na políčko Väzenie a stojíš 2 kolá!");
            hrac.setPole(6);
            hrac.setKolkoUzJeNaPoliVazenie(1);

        }
        if (doska.getPolickoNaPozici(pole).isSanca()) {
            System.out.println("Dostal si sa na špeciálne políčko Šanca, ťaháš si kartu ŠANCA!");
            Sanca kartaSanca=sance.getVrchnaSanca();
            System.out.println("KARTA ŠANCA: "+kartaSanca.getName());
            if (!kartaSanca.getPenaznyBonus().equals(new BigDecimal(0))) {
                hrac.pridajPeniaze(kartaSanca.getPenaznyBonus());
            }
            if (!kartaSanca.getZaplatenieBanke().equals(new BigDecimal(0))) {

                    hrac.odoberPeniaze(kartaSanca.getZaplatenieBanke());

            }

            if (kartaSanca.getPresunutieNaPole()>=0) {
                hrac.setPole(kartaSanca.getPresunutieNaPole());
            }

            sance.returnSanca(kartaSanca);

        }


    }

    public void hodKockou (Player hrac,int min, int max, int maxPoli,BigDecimal money, HraciaDoska doska,int hodKockou,int predoslaPozicia) {

        System.out.println("Aktualny hod kockou: " + hodKockou);
        hrac.zadajPole(hodKockou);
        int aktualnaPozicia = predoslaPozicia + hodKockou;
        if (aktualnaPozicia > maxPoli) {
            System.out.println("Presiel si cez start dostavas peniaze!!");
            hrac.pridajPeniaze(money);
            aktualnaPozicia = aktualnaPozicia % 24;
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Posunul si sa na policko: "+aktualnaPozicia + " - " + doska.getPolickoNaPozici(aktualnaPozicia).getPoleName());
        hrac.setPole(aktualnaPozicia);
        try {
            vyberTypPola(doska, aktualnaPozicia, hrac);
        }catch (NotEnoughMoney e) {
            doska.vyhodHraca(hrac);
        }

    }


    public void spravTah(HraciaDoska doska)  {
        Random rand = new Random();
        List <Player> hraci=doska.getPlayers();
        int maxPoli=23;
        int min=1;
        int max=6;
        BigDecimal money=new BigDecimal(2000);

        while (true) {
            for (Player hrac:hraci) {

                System.out.println("["+ hrac+ "]" );
                System.out.println("Stav uctu hraca: "+ hrac.getPeniaze());
                int predoslaPozicia=hrac.getPole();
                int hodKockou= rand.nextInt(max - min) + min;
                if (hrac.getKolkoUzJeNaPoliVazenie()==0) {
                    hodKockou (hrac,min, max, maxPoli,money,doska,hodKockou,predoslaPozicia);
                }
                else {
                    stojisVoVazeni(doska,hrac);
                    System.out.println("Stale stojis vo vazeni!");
                }
                }
            }

        }



    public  Player getPlayer(Scanner myObj) throws ZlyInput {

        //Scanner myObj = new Scanner(System.in);  // Create a Scanner object

        System.out.println("Zadaj svoje meno");

        String userName = myObj.nextLine();  // Read user input
        if(userName.trim().equals("")) {
            throw new ZlyInput("UserName je neplatny retazec");
        }
        Player hrac= new Player(userName);
        System.out.println("Meno je : " + userName);  // Output user input

        return hrac;

    }

    public void nacitavajHracov(HraciaDoska doska)  {
        Scanner pomocna = new Scanner(System.in);
        System.out.println("Pre zacatie hry a zaevidovanie hracov stlac 1:");
        String  premenna = pomocna.nextLine();
        if(!premenna.trim().equals("1")) {
            System.out.println("Zlý vstup! Spusti hru odznova!!");
            System.exit(0);
        }
        int poradie=0;
        while (premenna.equals("1")) {
            try {

                doska.addPlayer(getPlayer(pomocna));
            }catch (ZlyInput e) {
                System.out.println("Hráč musí mať nejaké meno!! Spusti hru odznova!!");
                System.exit(0);
            }
            poradie=poradie+1;
            System.out.println("\nPoradie hraca je: "+ poradie);
            System.out.println("Ak si zapisal vsetkych hracov stlac 0 ak chces dalej zapisovat hracov stlac 1:");
            premenna = pomocna.nextLine();
            if( (!premenna.trim().equals("1")) && !premenna.trim().equals("0") ) {
                System.out.println("Zlý vstup! Spusti hru odznova!!");
                System.exit(0);
            }

        }
        if (poradie==1) {
            System.err.println("Iba jeden hrac nemoze hrat!");
            System.exit(0);
        }
        System.out.println("Hra zacina!");
        spravTah(doska);

    }




    public  void monopoly()  {
        HraciaDoska doska = new HraciaDoska();
        this.nacitavajHracov(doska);
    }


    public static void main(String[] args) {
        Assignment1 monopoly= new Assignment1();
        monopoly.monopoly();
    }
}


