package com.pryadko.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static java.util.Comparator.comparingInt;

public class BoardTest {

    private static final Map<Integer, Integer[]> EXPECTED = new HashMap<Integer, Integer[]>() {
        {
            put(0, new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 18, 19, 20, 27, 36, 45, 54, 63, 72});
            put(80, new Integer[]{72, 73, 74, 75, 76, 77, 78, 79, 80, 8, 17, 26, 35, 44, 53, 62, 71, 60, 61, 69, 70});
            put(8, new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 17, 26, 35, 44, 53, 62, 71, 80, 15, 16, 24, 25});
        }
    };

    @Before
    public void setUp() throws Exception {
        EXPECTED.forEach((integer, integers) -> Arrays.sort(integers));
    }

    @Test
    public void shouldGenereteEmptyBoardWhenWeCreateNewOne() throws Exception {
        Board board = new Board();

        Assert.assertEquals(
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
                        "*************\n",
                board.toString());
    }

    @Test
    public void shouldPopulateDependentsIdForCell0() throws Exception {
        Board board = new Board();

        Set<Cell> actual = board.getDependentCell(0);

        Assert.assertArrayEquals(EXPECTED.get(0), toIds(actual));
    }

    @Test
    public void shouldPopulateDependentsIdForCell80() throws Exception {
        Board board = new Board();

        Set<Cell> actual = board.getDependentCell(80);

        Assert.assertArrayEquals(EXPECTED.get(80), toIds(actual));
    }

    @Test
    public void shouldPopulateDependentsIdForCell8() throws Exception {
        Board board = new Board();

        Set<Cell> actual = board.getDependentCell(8);

        Assert.assertArrayEquals(EXPECTED.get(8), toIds(actual));
    }

    private Integer[] toIds(Set<Cell> actual) {
        return actual.stream()
                .sorted(comparingInt(Cell::getId))
                .map(Cell::getId)
                .toArray(Integer[]::new);
    }
}