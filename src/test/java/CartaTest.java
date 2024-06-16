import models.Carta;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CartaTest {

    @Test
    public void testCriacaoDeCarta(){
        Carta carta = new Carta("♥ Copas", "A");
        assertEquals("♥ Copas", carta.getNaipe());
        assertEquals("A", carta.getValor());
    }
    @Test
    public void testCartaIsCuringa() {
        Carta carta = new Carta("Joker", "Joker");
        assertTrue(carta.isCuringa());
    }

    @Test
    public void testCartaToString() {
        Carta carta = new Carta("♦ Ouros", "10");
        assertEquals("10 de ♦ Ouros", carta.toString());
    }
}
