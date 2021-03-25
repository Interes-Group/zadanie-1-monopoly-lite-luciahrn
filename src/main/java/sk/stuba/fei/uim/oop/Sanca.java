package sk.stuba.fei.uim.oop;

import java.math.BigDecimal;

public  class Sanca {
    private String name;
    private BigDecimal zaplatenieBanke;
    private BigDecimal penaznyBonus;
    private int presunutieNaPole;

    public Sanca(String name, BigDecimal zaplatenieBanke, BigDecimal penaznyBonus,int presunutieNaPole) {
        this.name = name;
        this.zaplatenieBanke = zaplatenieBanke;
        this.penaznyBonus = penaznyBonus;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getZaplatenieBanke() {
        return zaplatenieBanke;
    }

    public BigDecimal getPenaznyBonus() {
        return penaznyBonus;
    }

    public int getPresunutieNaPole() {
        return presunutieNaPole;
    }
}
