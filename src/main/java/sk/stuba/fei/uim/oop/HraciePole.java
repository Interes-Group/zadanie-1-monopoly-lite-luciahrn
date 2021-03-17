package sk.stuba.fei.uim.oop;


import java.math.BigDecimal;

public class  HraciePole {
    private String poleName;
    private BigDecimal cenaPola;
    private BigDecimal stojne;
    private Nehnutelnost nehnutelnost;
    private boolean sanca = false;

    public HraciePole(String poleName, BigDecimal cena, BigDecimal stojne, boolean jeSanca) {
        this.poleName = poleName;
        this.cenaPola = cena;
        this.stojne = stojne;
        this.sanca = jeSanca;
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

    public boolean isSanca() {
        return sanca;
    }
}
