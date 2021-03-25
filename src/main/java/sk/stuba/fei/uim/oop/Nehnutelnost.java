package sk.stuba.fei.uim.oop;

import java.math.BigDecimal;
import java.lang.String;

public class Nehnutelnost extends HraciePole{
    private Player owner=null;

    public Nehnutelnost(String poleName, BigDecimal cena, BigDecimal stojne) {
        super(poleName, cena, stojne,false);
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }


}
