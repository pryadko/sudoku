package com.pryadko.domain;

import org.junit.Assert;
import org.junit.Test;

import java.util.Set;

public class BoardTest {
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
    public void name() throws Exception {
        Board board = new Board();

        Set<Cell> actual = board.getDependentCell(0);

        Integer[] expected = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 18, 19, 20, 27, 36, 45, 54, 63, 72};
        Assert.assertArrayEquals(expected, toIds(actual));
    }

    private Integer[] toIds(Set<Cell> actual) {
        return actual.stream()
                .map(Cell::getId)
                .toArray(Integer[]::new);
    }
}