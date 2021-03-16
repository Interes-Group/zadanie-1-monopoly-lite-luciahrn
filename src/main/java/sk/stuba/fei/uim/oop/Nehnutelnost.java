package sk.stuba.fei.uim.oop;

import java.math.BigDecimal;
import java.lang.String;

public class Nehnutelnost extends HraciePole{
    private String owner;
    public Nehnutelnost(String poleName, BigDecimal cena, BigDecimal stojne) {
        super(poleName, cena, stojne);
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
