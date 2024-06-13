package models;

public class Carta {

    public String naipe;
    public String valor;

    public Carta(String naipe, String valor) {
        this.naipe = naipe;
        this.valor = valor;
    }

    public String getNaipe() {
        return naipe;
    }

    public String getValor() {
        return valor;
    }

    public boolean isCuringa() {
        return this.naipe.equals("Joker");
    }

    @Override
    public String toString() {
        return valor + " de " + naipe;
    }

}
