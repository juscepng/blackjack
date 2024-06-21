package Factory;

import models.Dealer;
import models.Jogador;

public interface PlayerFactory {
    Jogador criarJogador(String nome);

    Dealer criarDealer();
}