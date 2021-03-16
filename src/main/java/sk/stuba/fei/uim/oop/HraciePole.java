package sk.stuba.fei.uim.oop;


import java.math.BigDecimal;

public abstract class  HraciePole {
    private String poleName;
    private BigDecimal cenaPola;
    private BigDecimal stojne;
    private Nehnutelnost nehnutelnost;

    public HraciePole(String poleName, BigDecimal cena, BigDecimal stojne) {
        this.poleName = poleName;
        this.cenaPola = cena;
        this.stojne = stojne;
    }

    public String getPoleName() {
        return poleName;
    }

    public BigDecimal getCena() {
        return cenaPola;
    }

    public BigDecimal getStojne() {
        return stojne;
    }

}
