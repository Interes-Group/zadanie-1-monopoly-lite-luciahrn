package sk.stuba.fei.uim.oop;

import java.math.BigDecimal;
import java.util.*;

public class Sance {
    private Queue<Sanca> sance=new ArrayDeque();

    public Sance() {
        Sanca karta1 =new Sanca("Zaplať banke 1000",new BigDecimal(1000),new BigDecimal(0),-1);
        sance.add(karta1);
        Sanca karta2 =new Sanca("Dostávaš bonus 500",new BigDecimal(0),new BigDecimal(500),-1);
        sance.add(karta2);
        Sanca karta3 =new Sanca("Presun sa na štart",new BigDecimal(0),new BigDecimal(0),0);
        sance.add(karta3);
        Sanca karta4 =new Sanca("Zaplať banke 500",new BigDecimal(500),new BigDecimal(0),-1);
        sance.add(karta4);
        Sanca karta5 =new Sanca("Dostávaš bonus 300",new BigDecimal(0),new BigDecimal(300),-1);
        sance.add(karta5);

    }

    public Sanca getVrchnaSanca() {
        return sance.poll();
    }

    public void returnSanca (Sanca sanca) {
        sance.add(sanca);
    }
}


