import models.Carta;
import models.Dealer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DealerTest {

    private Dealer dealer;

    @BeforeEach
    public void setUp() {
        dealer = new Dealer();
    }

    @Test
    public void testImprimirMaoDealer() {
        dealer.adicionarCarta(new Carta("♣ Paus", "10"));
        dealer.adicionarCarta(new Carta("♦ Ouros", "A"));
        assertEquals("10 de ♣ Paus", dealer.imprimirMaoDealer());
    }
}
