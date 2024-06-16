package models;

public class Dealer extends Jogador {
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
}
