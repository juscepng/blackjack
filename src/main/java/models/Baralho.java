package models;

import utils.BaralhoUtil;

import java.util.List;

// Transformamos o baralho em um singleton, para que sempre haja somente uma instancia do baralho por jogo.

public class Baralho {
    private List<Carta> baralho;
    private static Baralho instance;

    public Baralho(){
        this.baralho = BaralhoUtil.embaralharBaralho();
    }

    public static Baralho getInstance() {
        if (instance == null) {
            instance = new Baralho();
        }
        return instance;
    }

    public Carta puxarCarta(){
        return baralho.remove(baralho.size() - 1);
    }

    public List<Carta> getBaralho() {
        return baralho;
    }
}
