package Factory;

import models.Dealer;
import models.Jogador;

public interface PlayerFactory {
    //Criamos uma base do factory que tem a função de criar o jogador e o dealer.
    Jogador criarJogador();

    Dealer criarDealer();
}