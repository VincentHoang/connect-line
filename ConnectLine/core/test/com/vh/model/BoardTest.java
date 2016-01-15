package com.vh.model;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BoardTest {

    Board board;

    @Before
    public void setup() {
        board = new Board();
    }

    @Test
    public void should_be_neutral_on_creation() {
        assertThat(board.getTokenAt(1, 1), is(Cell.NEUTRAL));
    }

    @Test
    public void should_return_the_correct_cell_state_at_a_given_position() {
        board.placeToken(Cell.PLAYER1, 1, 2);

        assertThat(board.getTokenAt(1, 2), is(Cell.PLAYER1));
        assertThat(board.getTokenAt(0, 1), is(Cell.NEUTRAL));
    }
}