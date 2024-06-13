package utils;

import models.Carta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BaralhoUtil {

    public static List<Carta> gerarBaralho() {

        var baralho = new ArrayList<Carta>();
        String[] valores = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        String[] naipes = {"Copas", "Ouros", "Espadas", "Paus"};

        for (String naipe : naipes) {
            for (String valor : valores) {
                baralho.add(new Carta(naipe, valor));
            }
        }

        baralho.add(new Carta("Joker", "Joker"));

        return baralho;
    }

    public static List<Carta> embaralharBaralho() {
        var baralho = gerarBaralho();

        Collections.shuffle(baralho);

        return baralho;
    }

}
