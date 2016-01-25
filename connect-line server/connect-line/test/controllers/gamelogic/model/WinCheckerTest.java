package controllers.gamelogic.model;

import org.junit.Before;
import org.junit.Test;

import static controllers.gamelogic.model.Cell.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class WinCheckerTest {

    WinChecker winChecker;
    Board board;

    @Before
    public void setup() {
        board = new Board();
        winChecker = new WinChecker(board);
    }

    @Test
    public void not_win_if_empty_board() {
        assertThat(winChecker.win(PLAYER1, 0, 0), is(false));
    }

    @Test
    public void win_if_consecutive_horizontal() {
        board.placeToken(PLAYER1, 0, 0);
        board.placeToken(PLAYER1, 1, 0);
        board.placeToken(PLAYER1, 2, 0);
        board.placeToken(PLAYER1, 3, 0);

        assertThat(winChecker.win(PLAYER1, 0, 0), is(true));
        assertThat(winChecker.win(PLAYER1, 1, 0), is(true));
        assertThat(winChecker.win(PLAYER1, 2, 0), is(true));
        assertThat(winChecker.win(PLAYER1, 3, 0), is(true));
    }

    @Test
    public void win_if_consecutive_horizontal2() {
        board.placeToken(PLAYER1, 3, 0);
        board.placeToken(PLAYER1, 4, 0);
        board.placeToken(PLAYER1, 5, 0);
        board.placeToken(PLAYER1, 6, 0);

        assertThat(winChecker.win(PLAYER1, 3, 0), is(true));
        assertThat(winChecker.win(PLAYER1, 4, 0), is(true));
        assertThat(winChecker.win(PLAYER1, 5, 0), is(true));
        assertThat(winChecker.win(PLAYER1, 6, 0), is(true));
    }

    @Test
    public void not_win_if_horizontal_non_consecutive() {
        board.placeToken(PLAYER1, 0, 0);
        board.placeToken(PLAYER1, 1, 0);
        board.placeToken(PLAYER2, 2, 0);//Different player
        board.placeToken(PLAYER1, 3, 0);
        board.placeToken(PLAYER1, 4, 0);
        board.placeToken(PLAYER1, 5, 0);
        board.placeToken(PLAYER2, 6, 0);//Different player

        assertThat(winChecker.win(PLAYER1, 0, 0), is(false));
        assertThat(winChecker.win(PLAYER1, 1, 0), is(false));
        assertThat(winChecker.win(PLAYER2, 2, 0), is(false));
        assertThat(winChecker.win(PLAYER1, 3, 0), is(false));
        assertThat(winChecker.win(PLAYER1, 4, 0), is(false));
        assertThat(winChecker.win(PLAYER1, 5, 0), is(false));
        assertThat(winChecker.win(PLAYER2, 6, 0), is(false));
    }

    @Test
    public void win_if_consecutive_vertical() {
        board.placeToken(PLAYER1, 1, 0);
        board.placeToken(PLAYER1, 1, 1);
        board.placeToken(PLAYER1, 1, 2);
        board.placeToken(PLAYER1, 1, 3);

        assertThat(winChecker.win(PLAYER1, 1, 0), is(true));
        assertThat(winChecker.win(PLAYER1, 1, 1), is(true));
        assertThat(winChecker.win(PLAYER1, 1, 2), is(true));
        assertThat(winChecker.win(PLAYER1, 1, 3), is(true));
    }

    @Test
    public void not_win_if_vertical_non_consecutive() {
        board.placeToken(PLAYER1, 1, 0);
        board.placeToken(PLAYER1, 1, 1);
        board.placeToken(PLAYER1, 1, 2);
        board.placeToken(PLAYER2, 1, 3);
        board.placeToken(PLAYER1, 1, 4);
        board.placeToken(PLAYER1, 1, 5);

        assertThat(winChecker.win(PLAYER1, 1, 0), is(false));
        assertThat(winChecker.win(PLAYER2, 1, 1), is(false));
        assertThat(winChecker.win(PLAYER1, 1, 2), is(false));
        assertThat(winChecker.win(PLAYER1, 1, 3), is(false));
        assertThat(winChecker.win(PLAYER1, 1, 4), is(false));
        assertThat(winChecker.win(PLAYER2, 1, 5), is(false));
    }

    @Test
    public void win_if_consecutive_diagonal_incline() {
        board.placeToken(PLAYER1, 0, 0);
        board.placeToken(PLAYER1, 1, 1);
        board.placeToken(PLAYER1, 2, 2);
        board.placeToken(PLAYER1, 3, 3);

        assertThat(winChecker.win(PLAYER1, 0, 0), is(true));
        assertThat(winChecker.win(PLAYER1, 1, 1), is(true));
        assertThat(winChecker.win(PLAYER1, 2, 2), is(true));
        assertThat(winChecker.win(PLAYER1, 3, 3), is(true));
    }

    @Test
    public void not_win_if_non_consecutive_diagonal_incline() {
        board.placeToken(PLAYER1, 0, 0);
        board.placeToken(PLAYER2, 1, 1);
        board.placeToken(PLAYER1, 2, 2);
        board.placeToken(PLAYER1, 3, 3);

        assertThat(winChecker.win(PLAYER1, 0, 0), is(false));
        assertThat(winChecker.win(PLAYER1, 1, 1), is(false));
        assertThat(winChecker.win(PLAYER1, 2, 2), is(false));
        assertThat(winChecker.win(PLAYER1, 3, 3), is(false));
    }

    @Test
    public void not_win_if_non_consecutive_diagonal_incline2() {
        board.placeToken(PLAYER1, 2, 2);
        board.placeToken(PLAYER1, 3, 3);
        board.placeToken(PLAYER2, 4, 4);
        board.placeToken(PLAYER1, 5, 5);

        assertThat(winChecker.win(PLAYER1, 2, 2), is(false));
        assertThat(winChecker.win(PLAYER1, 3, 3), is(false));
        assertThat(winChecker.win(PLAYER1, 4, 4), is(false));
        assertThat(winChecker.win(PLAYER1, 5, 5), is(false));
    }

    @Test
    public void not_win_if_non_consecutive_diagonal_incline3() {
        board.placeToken(PLAYER1, 0, 0);
        board.placeToken(PLAYER2, 1, 1);
        board.placeToken(PLAYER1, 2, 2);
        board.placeToken(PLAYER1, 3, 3);
        board.placeToken(PLAYER2, 4, 4);
        board.placeToken(PLAYER1, 5, 5);


        assertThat(winChecker.win(PLAYER1, 0, 0), is(false));
        assertThat(winChecker.win(PLAYER1, 1, 1), is(false));
        assertThat(winChecker.win(PLAYER1, 2, 2), is(false));
        assertThat(winChecker.win(PLAYER1, 3, 3), is(false));
        assertThat(winChecker.win(PLAYER1, 4, 4), is(false));
        assertThat(winChecker.win(PLAYER1, 5, 5), is(false));
    }

    @Test
    public void win_if_consecutive_diagonal_decline() {
        board.placeToken(PLAYER1, 0, 3);
        board.placeToken(PLAYER1, 1, 2);
        board.placeToken(PLAYER1, 2, 1);
        board.placeToken(PLAYER1, 3, 0);

        assertThat(winChecker.win(PLAYER1, 0, 3), is(true));
        assertThat(winChecker.win(PLAYER1, 1, 2), is(true));
        assertThat(winChecker.win(PLAYER1, 2, 1), is(true));
        assertThat(winChecker.win(PLAYER1, 3, 0), is(true));
    }

    @Test
    public void win_if_consecutive_diagonal_decline2() {
        board.placeToken(PLAYER1, 2, 5);
        board.placeToken(PLAYER1, 3, 4);
        board.placeToken(PLAYER1, 4, 3);
        board.placeToken(PLAYER1, 5, 2);


        assertThat(winChecker.win(PLAYER1, 2, 5), is(true));
        assertThat(winChecker.win(PLAYER1, 3, 4), is(true));
        assertThat(winChecker.win(PLAYER1, 4, 3), is(true));
        assertThat(winChecker.win(PLAYER1, 5, 2), is(true));
    }

    @Test
    public void not_win_if_non_consecutive_diagonal_decline() {
        board.placeToken(PLAYER1, 0, 3);
        board.placeToken(PLAYER1, 1, 2);
        board.placeToken(PLAYER2, 2, 1);
        board.placeToken(PLAYER1, 3, 0);

        assertThat(winChecker.win(PLAYER1, 0, 3), is(false));
        assertThat(winChecker.win(PLAYER1, 1, 2), is(false));
        assertThat(winChecker.win(PLAYER1, 2, 1), is(false));
        assertThat(winChecker.win(PLAYER1, 3, 0), is(false));
    }

    @Test
    public void return_winning_line() {

    }
}