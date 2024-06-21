package Factory;

import models.Dealer;
import models.Jogador;

// (talvez ainda nao esteja 100% mas) Reutilizamos a factory, adicionando o parametro nome para o jogador (caso venha a
// ter mais de um e estamos instanciando o dealer com o singleton.

public class BlackJackPlayerFactory implements PlayerFactory {
    @Override
    public Jogador criarJogador(String nome) {
        return new Jogador(nome);
    }

    @Override
    public Dealer criarDealer() {
        return Dealer.getInstance();
    }
}