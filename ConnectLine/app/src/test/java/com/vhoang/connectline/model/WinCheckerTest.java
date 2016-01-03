package com.vhoang.connectline.model;

import org.junit.Before;
import org.junit.Test;

public class WinCheckerTest {

    WinChecker winChecker;
    Board board;

    @Before
    public void setup() {
        board = new Board();
        winChecker = new WinChecker(board);
    }

    @Test
    public void not_win_on_creation() {

    }

    @Test
    public void win_if_consecutive_horizontal() {

    }

    @Test
    public void not_win_if_none_consecutive() {

    }

    @Test
    public void win_if_consecutive_vertical() {

    }

    @Test
    public void win_if_consecutive_diagonal_incline() {

    }

    @Test
    public void win_if_consecutive_diagonal_decline() {

    }

    @Test
    public void return_winning_line() {

    }
}