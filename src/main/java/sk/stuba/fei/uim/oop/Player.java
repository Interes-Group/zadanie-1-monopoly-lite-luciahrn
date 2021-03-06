package sk.stuba.fei.uim.oop;

import java.math.BigDecimal;

public class Player {
    private String playerName;
    private BigDecimal peniaze=new BigDecimal(2000);
    private int kolkoUzJeNaPoliVazenie=0;
    private int pole;


    public Player(String name) {
        this.playerName = name;
    }

    public void pridajPeniaze(BigDecimal money) {
        this.peniaze = this.peniaze.add(money);


        }



    public void odoberPeniaze(BigDecimal money) throws NotEnoughMoney {
        this.peniaze = this.peniaze.subtract(money);
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
        return pole;
    }

    public BigDecimal getPeniaze() {
        return peniaze;
    }

    public int getKolkoUzJeNaPoliVazenie() {
        return kolkoUzJeNaPoliVazenie;
    }

    public void setKolkoUzJeNaPoliVazenie(int kolkoUzJeNaPoliVazenie) {
        this.kolkoUzJeNaPoliVazenie = kolkoUzJeNaPoliVazenie;
    }


}

