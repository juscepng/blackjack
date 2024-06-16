
import models.Carta;
import org.junit.jupiter.api.Test;
import utils.BaralhoUtil;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BaralhoUtilTest {

    @Test
    public void testGerarBaralho() {
        List<Carta> baralho = BaralhoUtil.gerarBaralho();

        assertNotNull(baralho);
        assertEquals(53, baralho.size());

        long copasCount = baralho.stream().filter(carta -> carta.getNaipe().equals("♥ Copas")).count();
        long ourosCount = baralho.stream().filter(carta -> carta.getNaipe().equals("♦ Ouros")).count();
        long espadasCount = baralho.stream().filter(carta -> carta.getNaipe().equals("♠ Espadas")).count();
        long pausCount = baralho.stream().filter(carta -> carta.getNaipe().equals("♣ Paus")).count();
        long jokerCount = baralho.stream().filter(carta -> carta.getNaipe().equals("Joker")).count();

        assertEquals(13, copasCount);
        assertEquals(13, ourosCount);
        assertEquals(13, espadasCount);
        assertEquals(13, pausCount);
        assertEquals(1, jokerCount);
    }

    @Test
    public void testEmbaralharBaralho() {
        List<Carta> baralho1 = BaralhoUtil.gerarBaralho();
        List<Carta> baralho2 = BaralhoUtil.embaralharBaralho();

        assertNotNull(baralho1);
        assertNotNull(baralho2);
        assertEquals(baralho1.size(), baralho2.size());

        assertNotEquals(baralho1, baralho2);

        boolean isShuffled = false;
        for (int i = 0; i < baralho1.size(); i++) {
            if (!baralho1.get(i).equals(baralho2.get(i))) {
                isShuffled = true;
                break;
            }
        }
        assertTrue(isShuffled);
    }
}
