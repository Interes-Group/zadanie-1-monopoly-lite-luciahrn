package sk.stuba.fei.uim.oop;

import java.math.BigDecimal;

public class PolePolicia extends HraciePole{
    private int pole ;
    public PolePolicia(String poleName, BigDecimal cena, BigDecimal stojne) {
        super(poleName, cena, stojne,false);
    }

    public int getPole() {
        return pole;
    }

    public void setPole(int pole) {
        this.pole = pole;
    }
}
