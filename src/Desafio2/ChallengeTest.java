package Desafio2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ChallengeTest {

    @Nested
    @DisplayName("Basic Functionality")
    class BasicFunctionality {

        @Test
        @DisplayName("should work on a snake with just a head")
        public void shouldWorkOnASnakeWithJustAHead() {
            var grid = AL(
                    "   ",
                        " h ",
                        "   "
            );
            assertEquals(AL(AL(1, 1)), Challenge.findSnakeOnGrid(grid));
        }

        @Test
        @DisplayName("should work on a snake with a head and one tail segment")
        public void shouldWorkOnASnakeWithAHeadAndOneTailSegment() {
            var grid = AL("   ",
                              " h<",
                              "   "
            );
            assertEquals(AL(AL(1, 1), AL(2, 1)), Challenge.findSnakeOnGrid(grid));
        }

        @Test
        @DisplayName("should work on a snake with a head and two tail segments")
        public void shouldWorkOnASnakeWithAHeadAndTwoTailSegments() {
            var grid = AL(
                    "   ",
                    " h<",
                    "  ^"
            );
            var expected = AL(
                    AL(1, 1),
                    AL(2, 1),
                    AL(2, 2)
            );
            assertEquals(expected, Challenge.findSnakeOnGrid(grid));
        }

        @Test
        @DisplayName("should work on a snake with a head and three tail segments")
        public void shouldWorkOnASnakeWithAHeadAndThreeTailSegments() {
            var grid = AL(
                    "   ",
                    " h<",
                    " >^"
            );
            var expected = AL(
                    AL(1, 1),
                    AL(2, 1),
                    AL(2, 2),
                    AL(1, 2)
            );
            assertEquals(expected, Challenge.findSnakeOnGrid(grid));
        }

        @Test
        @DisplayName("should work on a snake that encircles the head")
        public void shouldWorkOnASnakeThatEncirclesTheHead() {
            var grid = AL(
                    "v<<",
                        "vh<",
                        ">>^"
            );
            var expected = AL(
                    AL(1, 1),
                    AL(2, 1),
                    AL(2, 2),
                    AL(1, 2),
                    AL(0, 2),
                    AL(0, 1),
                    AL(0, 0),
                    AL(1, 0),
                    AL(2, 0)
            );
            assertEquals(expected, Challenge.findSnakeOnGrid(grid));
        }

        @Test
        @DisplayName("should work on a snake that encircles the head counterclockwise")
        public void shouldWorkOnASnakeThatEncirclesTheHeadCounterclockwise() {
            var grid = AL(
                    ">>v",
                        "^h<",
                        "^<<"
            );
            var expected = AL(
                    AL(1, 1),
                    AL(2, 1),
                    AL(2, 0),
                    AL(1, 0),
                    AL(0, 0),
                    AL(0, 1),
                    AL(0, 2),
                    AL(1, 2),
                    AL(2, 2)
            );
            assertEquals(expected, Challenge.findSnakeOnGrid(grid));
        }

        @Test
        @DisplayName("should work on a slightly complex snake")
        public void shouldWorkOnASlightlyComplexSnake() {
            var grid = AL(
                    " >>h   ",
                        " ^   v ",
                        " ^<<<< "
            );
            var expected = AL(
                    AL(3, 0),
                    AL(2, 0),
                    AL(1, 0),
                    AL(1, 1),
                    AL(1, 2),
                    AL(2, 2),
                    AL(3, 2),
                    AL(4, 2),
                    AL(5, 2),
                    AL(5, 1)
            );
            assertEquals(expected, Challenge.findSnakeOnGrid(grid));
        }

        @Test
        @DisplayName("should work on a more complex snake")
        public void shouldWorkOnAMoreComplexSnake() {
            var grid = AL(
                    "           ",
                    " >>v  >>>h ",
                    " ^ >>>^ v  ",
                    " ^<<<<<<<  ",
                    "           "
            );
            var expected = AL(
                    AL(9, 1),
                    AL(8, 1),
                    AL(7, 1),
                    AL(6, 1),
                    AL(6, 2),
                    AL(5, 2),
                    AL(4, 2),
                    AL(3, 2),
                    AL(3, 1),
                    AL(2, 1),
                    AL(1, 1),
                    AL(1, 2),
                    AL(1, 3),
                    AL(2, 3),
                    AL(3, 3),
                    AL(4, 3),
                    AL(5, 3),
                    AL(6, 3),
                    AL(7, 3),
                    AL(8, 3),
                    AL(8, 2)
            );
            assertEquals(expected, Challenge.findSnakeOnGrid(grid));
        }
    }

    @SafeVarargs
    public static <T> ArrayList<T> AL(T ...a) {
        return new ArrayList<T>(Arrays.asList(a));
    }

}