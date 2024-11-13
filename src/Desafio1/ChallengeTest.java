package Desafio1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChallengeTest {

    @Test
    public void deveRetornarQuinze() {
        assertEquals(15, Challenge.calculaTotalLeds(4, 2));
    }

    @Test
    public void deveRetornarZeroAltura() {
        assertEquals(0, Challenge.calculaTotalLeds(0, 2));


    }
    @Test
    public void deveRetornarZeroLargura() {
        assertEquals(0, Challenge.calculaTotalLeds(4, 0));


    }
}