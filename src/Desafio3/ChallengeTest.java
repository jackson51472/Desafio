package Desafio3;

import org.junit.Test;
import static org.junit.Assert.*;
public class ChallengeTest {
    @Test
    public void deveRetornarEmpresaUmQuandoEquilibrioMenor10() {
        String actual0 = Challenge.escolheTaxi("0","1.7","5.0","1.0");
        System.out.println(actual0);
        assertEquals("Empresa 1 quando a distância < 7.14, Tanto faz quando a distância = 7.14, Empresa 2 quando a distância > 7.14", actual0);
    }

    @Test
    public void deveRetornarEmpresaDoisQuandoEquilibrioMenor10() {

        String actual0 = Challenge.escolheTaxi("5.0","0.75","2.5","1.0");
        assertEquals("Empresa 2 quando a distância < 10.0, Tanto faz quando a distância = 10.0, Empresa 1 quando a distância > 10.0", actual0);
    }

    @Test
    public void deveRetornarTantoFaz() {

        String actual0 = Challenge.escolheTaxi("2.5","2.5","2.5","2.5");
        assertEquals("Tanto faz", actual0);
    }

    @Test
    public void deveRetornarEmpresaUmQuandoKmForIgualMasTarifaMenor() {
        String actual0 = Challenge.escolheTaxi("1.25","2.5","2","2.5");
        assertEquals("Empresa 1", actual0);
    }

    @Test
    public void deveRetornarEmpresaDoisQuandoKmForIgualMasTarifaMenor() {
        String actual0 = Challenge.escolheTaxi("2","2.5","1.25","2.5");
        assertEquals("Empresa 2", actual0);
    }

    @Test
    public void deveRetornarEmpresaUmQuandoTarifaForIgualMasKmMenor() {
        String actual0 = Challenge.escolheTaxi("2","1.25","2","2.5");
        assertEquals("Empresa 1", actual0);
    }

    @Test
    public void deveRetornarEmpresaDoisQuandoTarifaForIgualMasKmMenor() {
        String actual0 = Challenge.escolheTaxi("2","1.25","2","2.5");
        assertEquals("Empresa 1", actual0);
    }
}