package com.pryadko.process;

import com.pryadko.domain.Board;
import org.junit.Assert;
import org.junit.Test;

public class LoaderTest {

    @Test
    public void shouldLoadBoardFromFole() throws Exception {
        Loader loader = new Loader();
        Board board = loader.loadBoard("./input.txt");

        Assert.assertEquals(
                "*************\n" +
                        "*123*123*123*\n" +
                        "*456*456*456*\n" +
                        "*789*789*789*\n" +
                        "*************\n" +
                        "*123*123*123*\n" +
                        "*456*456*456*\n" +
                        "*789*789*789*\n" +
                        "*************\n" +
                        "*123*123*123*\n" +
                        "*456*456*456*\n" +
                        "*789*789*789*\n" +
                        "*************\n",
                board.toString());
    }
}