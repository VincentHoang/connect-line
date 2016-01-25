package controllers.gamelogic.model;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

public class ConnectLineTest {

    private static final int COLUMN = 1;
    private static final int COLUMN_TWO = 2;

    Board board;
    ConnectLine connectLine;
    WinChecker winChecker;

    @Before
    public void setup() {
        board = new Board();
        winChecker = new WinChecker(board);

        connectLine = new ConnectLine(board, winChecker);
    }

    @Test
    public void placing_token_on_a_column_drops_the_token_to_the_bottom() {
        connectLine.placeToken(COLUMN);
        connectLine.placeToken(COLUMN_TWO);

        assertThat(board.getTokenAt(COLUMN, 0), not(Cell.NEUTRAL));
        assertThat(board.getTokenAt(COLUMN_TWO, 0), not(Cell.NEUTRAL));
    }

    @Test
    public void placing_token_on_a_column_stacks() {
        connectLine.placeToken(COLUMN);
        connectLine.placeToken(COLUMN);
        connectLine.placeToken(COLUMN);

        assertThat(board.getTokenAt(COLUMN, 0), not(Cell.NEUTRAL));
        assertThat(board.getTokenAt(COLUMN, 1), not(Cell.NEUTRAL));
        assertThat(board.getTokenAt(COLUMN, 2), not(Cell.NEUTRAL));
    }

    @Test
    public void place_token_of_the_current_player() {
        connectLine.placeToken(COLUMN);

        assertThat(board.getTokenAt(COLUMN, 0), is(Cell.PLAYER1));
    }

    @Test
    public void placing_a_token_switches_turn() {
        connectLine.placeToken(COLUMN);
        connectLine.placeToken(COLUMN);

        assertThat(board.getTokenAt(COLUMN, 0), is(Cell.PLAYER1));
        assertThat(board.getTokenAt(COLUMN, 1), is(Cell.PLAYER2));
    }

    @Test
    public void can_place_token() {
        assertThat(connectLine.canPlaceToken(COLUMN), is(true));
    }

    @Test
    public void cannot_place_token_if_column_is_full() {
        for (int i=0; i<Board.HEIGHT; i++) {
            connectLine.placeToken(COLUMN);
        }

        assertThat(connectLine.canPlaceToken(COLUMN), is(false));
    }

    @Test
    public void handle_placing_token_to_overflown_column() {
        for (int i=0; i<Board.HEIGHT; i++) {
            connectLine.placeToken(COLUMN);
        }
        connectLine.placeToken(COLUMN);
    }

    @Test
    public void foundWinner_is_true_when_there_is_a_winner() {
        connectLine.placeToken(COLUMN);
        connectLine.placeToken(COLUMN+1);

        connectLine.placeToken(COLUMN);
        connectLine.placeToken(COLUMN+1);

        connectLine.placeToken(COLUMN);
        connectLine.placeToken(COLUMN+1);

        connectLine.placeToken(COLUMN);

        assertThat(connectLine.foundWinner(), is(true));
    }

    @Test
    public void foundWinner_is_false_when_there_is_no_winner() {
        for (int i=0; i<WinChecker.WIN_COUNT; i++) {
            connectLine.placeToken(COLUMN);
        }

        assertThat(connectLine.foundWinner(), is(false));
    }

}