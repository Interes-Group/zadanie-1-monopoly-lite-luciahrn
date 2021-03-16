package sk.stuba.fei.uim.oop;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class HraciaDoska {
    private List<Player> players = new ArrayList<>();
    private final List<HraciePole> policka = new ArrayList<>();
    {
        HraciePole pole1 = new PoleStart("Start",new BigDecimal(0),new BigDecimal(0));
        policka.add(pole1);
        HraciePole pole2 = new Nehnutelnost("Potraviny",new BigDecimal(1200),new BigDecimal(100));
        policka.add(pole2);
        HraciePole pole3 = new Nehnutelnost("Základná škola",new BigDecimal(2000),new BigDecimal(200));
        policka.add(pole3);
        //HraciePole pole4 = new PoleSanca();
       // policka.add(pole4);
        HraciePole pole5 = new Nehnutelnost("Hasičská zbrojnica",new BigDecimal(2200),new BigDecimal(300));
        policka.add(pole5);
        HraciePole pole6 = new Nehnutelnost("Nemocnica",new BigDecimal(2300),new BigDecimal(400));
        policka.add(pole6);
        HraciePole pole7 = new PoleVazanie("Väzenie",new BigDecimal(0),new BigDecimal(0));
        policka.add(pole7);
        HraciePole pole8 = new Nehnutelnost("Nemocnica",new BigDecimal(2500),new BigDecimal(500));
        policka.add(pole8);
        HraciePole pole9 = new Nehnutelnost("Kostol",new BigDecimal(2600),new BigDecimal(550));
        policka.add(pole9);
        //HraciePole pole10 = new PoleSanca();
       // policka.add(pole10);
        HraciePole pole11 = new Nehnutelnost("Galéria",new BigDecimal(2700),new BigDecimal(600));
        policka.add(pole11);
        HraciePole pole12 = new Nehnutelnost("Reštaurácia",new BigDecimal(2800),new BigDecimal(650));
        policka.add(pole12);
        HraciePole pole13 = new PolePlatbaDane("Platba Dane",new BigDecimal(0),new BigDecimal(0));
        policka.add(pole13);
        HraciePole pole14 = new Nehnutelnost("Vysoká škola",new BigDecimal(2900),new BigDecimal(700));
        policka.add(pole14);
        HraciePole pole15 = new Nehnutelnost("Budova súdu",new BigDecimal(3000),new BigDecimal(750));
        policka.add(pole15);
        //HraciePole pole16 = new PoleSanca();
        //policka.add(pole16);
        HraciePole pole17 = new Nehnutelnost("Laboratórium",new BigDecimal(3000),new BigDecimal(750));
        policka.add(pole17);
        HraciePole pole18 = new Nehnutelnost("Divadlo",new BigDecimal(3100),new BigDecimal(800));
        policka.add(pole18);
        HraciePole pole19 = new PolePolicia("Polícia",new BigDecimal(0),new BigDecimal(0));
        policka.add(pole19);
        HraciePole pole20 = new Nehnutelnost("Banka",new BigDecimal(3200),new BigDecimal(800));
        policka.add(pole20);
        HraciePole pole21 = new Nehnutelnost("Mrakodrap",new BigDecimal(3300),new BigDecimal(850));
        policka.add(pole21);
        //HraciePole pole22 = new PoleSanca();
        //policka.add(pole22);
        HraciePole pole23 = new Nehnutelnost("Parlament",new BigDecimal(3400),new BigDecimal(850));
        policka.add(pole23);
        HraciePole pole24 = new Nehnutelnost("Palác prezidenta",new BigDecimal(4000),new BigDecimal(1000));
        policka.add(pole24);


    }

    public HraciaDoska(List<Player> players) {
        this.players = players;
    }

    public void vyhodHraca(Player out) {
        players.remove(out);
    }
}
