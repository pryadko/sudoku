package com.pryadko.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Set;

import static java.util.Comparator.comparingInt;

public class BoardTest {

    private static final Integer[] EXPECTED_FOR_0 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 18, 19, 20, 27, 36, 45, 54, 63, 72};

    @Before
    public void setUp() throws Exception {
        Arrays.sort(EXPECTED_FOR_0);
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

        Assert.assertArrayEquals(EXPECTED_FOR_0, toIds(actual));
    }

    private Integer[] toIds(Set<Cell> actual) {
        return actual.stream()
                .sorted(comparingInt(Cell::getId))
                .map(Cell::getId)
                .toArray(Integer[]::new);
    }
}