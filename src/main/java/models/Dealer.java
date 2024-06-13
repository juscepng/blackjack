package models;

public class Dealer extends Jogador {
    public void imprimirMaoDealer(){
        System.out.println(mao.getFirst().toString());
    }

    public boolean validarPuxarCarta(int pontuacaoJogador, int dealerPontuacao) {

        if(dealerPontuacao >= pontuacaoJogador) {
            return false;
        }

        if(dealerPontuacao < pontuacaoJogador) {
            return true;
        }

        if(dealerPontuacao < 15) {
            System.out.println(Math.random() * 10 / 10 > 0.1);
            return Math.random() * 10 / 10 > 0.3;
        } else if(dealerPontuacao > 15 && dealerPontuacao < 18){
            return Math.random() * 10 / 10 > 0.5;
        } else if(dealerPontuacao >= 18){
            return Math.random() * 10 / 10 > 0.7;
        } else {
            return false;
        }
    }
}
