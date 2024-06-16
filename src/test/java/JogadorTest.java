import models.Carta;
import models.Jogador;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JogadorTest {
    private Jogador jogador;

    @BeforeEach
    public void setJogador(){
        jogador = new Jogador();
    }

    @Test
    public void testeAdicionarCarta(){
        Carta carta = new Carta("♦ Ouros", "5");

        jogador.adicionarCarta(carta);

        assertEquals(5, jogador.getPontuacao());
    }

    @Test
    public void testGetJoker() {
        Carta carta = new Carta("Joker", "Joker");
        jogador.adicionarCarta(carta);
        assertTrue(jogador.getJoker());
    }

    @Test
    public void testImprimirMao() {
        jogador.adicionarCarta(new Carta("♣ Paus", "10"));
        jogador.adicionarCarta(new Carta("♦ Ouros", "A"));
        assertEquals("10 de ♣ Paus, A de ♦ Ouros", jogador.imprimirMao());
    }

    @Test
    public void testPontuacao() {
        jogador.adicionarCarta(new Carta("♣ Paus", "10"));
        jogador.adicionarCarta(new Carta("♦ Ouros", "A"));
        assertEquals(21, jogador.getPontuacao());
    }
}
