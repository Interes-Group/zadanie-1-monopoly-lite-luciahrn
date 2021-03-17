package sk.stuba.fei.uim.oop;

import java.math.BigDecimal;

import java.math.BigDecimal;

public class PoleStart extends HraciePole{
    private BigDecimal bonusStart;
    public PoleStart(String poleName, BigDecimal cena, BigDecimal stojne) {
        super(poleName, cena, stojne,false);
    }

    public BigDecimal getBonusStart() {
        return bonusStart;
    }

    public void setBonusStart(BigDecimal bonusStart) {
        this.bonusStart = bonusStart;
    }
}