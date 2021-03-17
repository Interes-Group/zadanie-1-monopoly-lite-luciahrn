package sk.stuba.fei.uim.oop;

import java.math.BigDecimal;

public class Player {
    private String playerName;
    private BigDecimal peniaze=new BigDecimal(2000);
    private boolean presielStartom;
    private int pole;


    public Player(String name) {
        this.playerName = name;
    }

    public void pridajPeniaze(BigDecimal money) {
        this.peniaze.add(money);
        System.out.println("V hre konci"+this);

        }



    public void odoberPeniaze(BigDecimal money) throws NotEnoughMoney {
        this.peniaze.add(money);
        if(this.peniaze.compareTo(new BigDecimal(0))<0){
            System.out.println("V hre konci"+this);
            throw new NotEnoughMoney();
        }

    }

    public String toString() {
        return playerName;
    }

    public int getPole() {
        return pole;
    }

    public void setPole(int pole) {
        this.pole = pole;
    }

    public int zadajPole(int poleTah) {
        this.pole=poleTah;
        // if(this.pole.compareTo(new BigDecimal(0))<2){
        //     System.out.println("V hre konci"+this);
        //     throw new NotEnoughMoney();
        return pole;
    }

    public BigDecimal getPeniaze() {
        return peniaze;
    }
}

