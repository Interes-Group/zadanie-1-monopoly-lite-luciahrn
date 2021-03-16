package sk.stuba.fei.uim.oop;

import java.math.BigDecimal;

public class Player {
    private String playerName;
    private BigDecimal peniaze=new BigDecimal(0);
    private boolean presielStartom;


    public Player(String name) {
        this.playerName = name;
    }

    public void pridajPeniaze(BigDecimal money) throws NotEnoughMoney {
        this.peniaze.add(money);
        if(this.peniaze.compareTo(new BigDecimal(0))<0){
            System.out.println("V hre konci"+this);
            throw new NotEnoughMoney();
        }

}

    public String toString() {
        return playerName;
    }
}
