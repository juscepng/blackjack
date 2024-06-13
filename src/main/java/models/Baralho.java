package models;

import utils.BaralhoUtil;

import java.util.List;

public class Baralho {
    private List<Carta> baralho;

    public Baralho(){
        this.baralho = BaralhoUtil.embaralharBaralho();
    }

    public Carta puxarCarta(){
        return baralho.remove(baralho.size() - 1);
    }
}
