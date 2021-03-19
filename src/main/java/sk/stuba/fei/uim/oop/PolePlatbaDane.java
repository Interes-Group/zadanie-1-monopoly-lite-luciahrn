package sk.stuba.fei.uim.oop;

import java.math.BigDecimal;

public class PolePlatbaDane extends HraciePole{
    private BigDecimal dan=new BigDecimal(500) ;
    public PolePlatbaDane(String poleName, BigDecimal cena, BigDecimal stojne) {
        super(poleName, cena, stojne,false);
    }

    public BigDecimal getDan() {
        return dan;
    }

    public void setDan(BigDecimal dan) {
        this.dan = dan;
    }
}