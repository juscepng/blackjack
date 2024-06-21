package models;

// Transformamos o dealer em singleton, para termos certeza que so havera um dealer por jogo.

public class Dealer extends Jogador {

    private static Dealer instance;

    private Dealer() {
        super("Dealer");
    }

    public static Dealer getInstance() {
        if (instance == null) {
            instance = new Dealer();
        }
        return instance;
    }

    public String imprimirMaoDealer() {
        return mao.get(0).toString();
    }

    public boolean validarPuxarCarta(int pontuacaoJogador, int dealerPontuacao) {

        if (dealerPontuacao >= pontuacaoJogador) {
            return false;
        }

        double probabilidadePuxarCarta;

        if (dealerPontuacao <= 10) {
            probabilidadePuxarCarta = 0.9;
        } else if (dealerPontuacao < 15) {
            probabilidadePuxarCarta = 0.7;
        } else {
            probabilidadePuxarCarta = 0.3;
        }

        return Math.random() < probabilidadePuxarCarta;
    }

    public void limparMao() {
        this.mao.clear();
        this.pontuacao = 0;
    }
}
