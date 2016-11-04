package com.pryadko.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static java.util.Comparator.comparingInt;
import static org.junit.Assert.assertArrayEquals;

public class BoardTest {

    private static final Map<Integer, Integer[]> EXPECTED = new HashMap<Integer, Integer[]>() {
        {
            put(0, new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 18, 19, 20, 27, 36, 45, 54, 63, 72});
            put(80, new Integer[]{72, 73, 74, 75, 76, 77, 78, 79, 8, 17, 26, 35, 44, 53, 62, 71, 60, 61, 69, 70});
            put(8, new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 17, 26, 35, 44, 53, 62, 71, 80, 15, 16, 24, 25});
            put(72, new Integer[]{0, 9, 18, 27, 36, 45, 54, 63, 73, 74, 75, 76, 77, 78, 79, 80, 55, 56, 64, 65});
            put(39, new Integer[]{36, 37, 38, 40, 41, 42, 43, 44, 3, 12, 21, 30, 48, 57, 66, 75, 31, 32, 49, 50});
            put(50, new Integer[]{5, 14, 23, 32, 41, 59, 68, 77, 45, 46, 47, 48, 49, 51, 52, 53, 39, 40, 30, 31});
            put(5, new Integer[]{14, 23, 32, 41, 50, 59, 68, 77, 0, 1, 2, 3, 4, 6, 7, 8, 12, 13, 21, 22});
            put(47, new Integer[]{2, 11, 20, 29, 38, 56, 65, 74, 45, 46, 48, 49, 50, 51, 52, 53, 27, 28, 36, 37});
            put(68, new Integer[]{63, 64, 65, 66, 67, 69, 70, 71, 77, 5, 14, 23, 32, 41, 50, 59, 57, 58, 75, 76});
            put(34, new Integer[]{27, 28, 29, 30, 31, 32, 33, 35, 7, 16, 25, 43, 52, 61, 70, 79, 42, 51, 44, 53});
        }
    };
    private static final String EMPTY_BOARD =
            "*************\n" +
                    "*   *   *   *\n" +
                    "*   *   *   *\n" +
                    "*   *   *   *\n" +
                    "*************\n" +
                    "*   *   *   *\n" +
                    "*   *   *   *\n" +
                    "*   *   *   *\n" +
                    "*************\n" +
                    "*   *   *   *\n" +
                    "*   *   *   *\n" +
                    "*   *   *   *\n" +
                    "*************\n";

    @Before
    public void setUp() throws Exception {
        EXPECTED.forEach((integer, integers) -> Arrays.sort(integers));
    }

    @Test
    public void shouldGenerateEmptyBoardWhenWeCreateNewOne() throws Exception {
        Board board = new Board();

        Assert.assertEquals(EMPTY_BOARD, board.toString());
    }

    @Test
    public void shouldPopulateDependentsIdForCell() throws Exception {
        Board board = new Board();

        EXPECTED.forEach((key, expected) -> assertArrayEquals(expected, toIds(board.getDependentCell(key))));
    }

    private Integer[] toIds(Set<Cell> actual) {
        return actual.stream()
                .sorted(comparingInt(Cell::getId))
                .map(Cell::getId)
                .toArray(Integer[]::new);
    }
}