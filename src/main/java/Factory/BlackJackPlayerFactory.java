package Factory;

import models.Dealer;
import models.Jogador;

public class BlackJackPlayerFactory implements PlayerFactory {
    //Utilizamos o PlayerFactory para criar instancias individuais do jogador e do dealer.
    @Override
    public Jogador criarJogador() {
        return new Jogador();
    }

    @Override
    public Dealer criarDealer() {
        return new Dealer();
    }
}