package sk.stuba.fei.uim.oop;
import java.io.*;
import java.util.Scanner;



public class Assignment1 {

    public Assignment1(){
        super();
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


