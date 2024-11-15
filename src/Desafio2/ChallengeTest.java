package Desafio2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ChallengeTest {

    @Nested
    @DisplayName("Orientação de direçãoes da cobra")
    class orientacoesCobra {

        @Test
        public void deveRetornarCaudaDireita() {
            var grid = AL("   ",
                              " h<",
                              "   "
            );
            assertEquals(AL(AL(1, 1), AL(2, 1)), Challenge.findSnakeOnGrid(grid));
        }

        @Test
        public void deveRetornarCaudaEsquerda() {
            var grid = AL("   ",
                    ">h ",
                    "   "
            );
            assertEquals(AL(AL(1, 1), AL(0, 1)), Challenge.findSnakeOnGrid(grid));
        }

        @Test
        public void deveRetornarCaudaEmBaixo() {
            var grid = AL("   ",
                    " h ",
                    " ^ "
            );
            assertEquals(AL(AL(1, 1), AL(1, 2)), Challenge.findSnakeOnGrid(grid));
        }

        @Test
        public void deveRetornarCaudaEmCima() {
            var grid = AL(" v ",
                              " h ",
                              "   "
            );
            assertEquals(AL(AL(1, 1), AL(1, 0)), Challenge.findSnakeOnGrid(grid));
        }

        @Test
        public void NaoDeveRetornarCaudaDireita() {
            var grid = AL("   ",
                              " h>",
                              "   "
            );
            assertEquals(AL(AL(1, 1)), Challenge.findSnakeOnGrid(grid));
        }

        @Test
        public void NaoDeveRetornarCaudaEsquerda() {
            var grid = AL("   ",
                              "vh ",
                              "   "
            );
            assertEquals(AL(AL(1, 1)), Challenge.findSnakeOnGrid(grid));
        }

        @Test
        public void NaoDeveRetornarCaudaEmBaixo() {
            var grid = AL("   ",
                    " h ",
                    " v "
            );
            assertEquals(AL(AL(1, 1)), Challenge.findSnakeOnGrid(grid));
        }

        @Test
        public void NaoDeveRetornarCaudaEmCima() {
            var grid = AL(" > ",
                    " h ",
                    "   "
            );
            assertEquals(AL(AL(1, 1)), Challenge.findSnakeOnGrid(grid));
        }
    }

    @SafeVarargs
    public static <T> ArrayList<T> AL(T ...a) {
        return new ArrayList<T>(Arrays.asList(a));
    }

    @Nested
    @DisplayName("Teste da função acharCabeca")
    class acharCabeca {

        @Test
        public void deveRetornarApenasCabeca() {
            var grid = AL(
                    "   ",
                    " h ",
                    "   "
            );
            assertEquals(AL(AL(1, 1)), Challenge.findSnakeOnGrid(grid));
        }

        @Test
        public void NaodeveRetornarCabeca() {
            var grid = AL(
                    "0  ",
                        "   ",
                        "   "
            );
            assertEquals(null, Challenge.findSnakeOnGrid(grid));
        }

    }


}