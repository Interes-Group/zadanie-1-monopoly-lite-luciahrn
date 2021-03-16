package sk.stuba.fei.uim.oop;

import java.math.BigDecimal;
import java.lang.String;

public class PoleVazanie extends HraciePole{
    private String pocetStati;
    public PoleVazanie(String poleName, BigDecimal cena, BigDecimal stojne) {
        super(poleName, cena, stojne);
    }

    public String getPocetStati() {
        return pocetStati;
    }

    public void setPocetStati(String pocetStati) {
        this.pocetStati = pocetStati;
    }
}
