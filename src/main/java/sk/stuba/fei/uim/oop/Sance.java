package sk.stuba.fei.uim.oop;

import java.util.*;

public class Sance {
    private Queue<Sanca> sance=new ArrayDeque();

    public Sance() {
       //sance.add
    }

    public Sanca getVrchnaSanca() {
        return sance.poll();
    }

    public void returnSanca (Sanca sanca) {
        sance.add(sanca);
    }
}


