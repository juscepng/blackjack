import Factory.BlackJackPlayerFactory;
import Factory.PlayerFactory;
import models.Carta;
import models.Dealer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Adicionamos um teste para validar o singleton do dealer e tambem um teste para o modulo novo de limpar a pontuação do mesmo.

public class DealerTest {

    PlayerFactory playerFactory = new BlackJackPlayerFactory();
    private Dealer dealer;

    @BeforeEach
    public void setUp() {
        this.dealer = playerFactory.criarDealer();
    }

    @Test
    public void testImprimirMaoDealer() {
        dealer.adicionarCarta(new Carta("♣ Paus", "10"));
        dealer.adicionarCarta(new Carta("♦ Ouros", "A"));
        assertEquals("10 de ♣ Paus", dealer.imprimirMaoDealer());
    }

    @Test
    public void testDealerSingleton() {
        Dealer dealer1 = Dealer.getInstance();
        Dealer dealer2 = Dealer.getInstance();

        assertSame(dealer1, dealer2, "Deveria haver apenas uma instância de Dealer");
    }

    @Test
    public void testLimparPontuacao() {
        dealer.adicionarCarta(new Carta("♣ Paus", "10"));
        dealer.adicionarCarta(new Carta("♦ Ouros", "A"));

        dealer.limparMao();

        assertEquals(0, dealer.getPontuacao());
    }
}
