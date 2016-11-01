package com.pryadko.domain;

import org.junit.Assert;
import org.junit.Test;

public class BoardTest {
    @Test
    public void shouldGenereteEmptyBoardWhenWeCreateNewOne() throws Exception {
        Board board = new Board();

        System.out.println(board);
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
}