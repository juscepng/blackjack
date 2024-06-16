import models.Baralho;
import models.Carta;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class BaralhoTest {

    @Test
    public void testeCriacaoBaralho(){
        Baralho baralho = new Baralho();

        assertEquals(53, baralho.getBaralho().size());
    }

    @Test
    public void testPuxarCarta(){
        Baralho baralho = new Baralho();
        Set<Carta> cartasPuxadas = new HashSet<>();

        for(int i = 0; i < 53; i++){
            Carta carta = baralho.puxarCarta();
            assertFalse(cartasPuxadas.contains(carta));
            cartasPuxadas.add(carta);
        }

        assertThrows(IndexOutOfBoundsException.class, baralho::puxarCarta);
    }

}
