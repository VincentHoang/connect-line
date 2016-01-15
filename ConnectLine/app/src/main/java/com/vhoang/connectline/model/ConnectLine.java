package com.vhoang.connectline.model;

import com.google.common.base.Optional;

import javax.inject.Inject;

import lombok.Getter;

import static com.vhoang.connectline.model.Cell.PLAYER1;
import static com.vhoang.connectline.model.Cell.PLAYER2;

public class ConnectLine {

    @Getter private Cell turn;
    private Board board;
    private WinChecker winChecker;
    private int[] rowPointers;
    private Optional<Winner> winner;


    @Inject
    public ConnectLine(Board board, WinChecker winChecker) {
        this.board = board;
        this.winChecker = winChecker;
        winner = Optional.absent();
        rowPointers = new int[Board.WIDTH];
        for (int i=0; i< rowPointers.length; i++) {
            rowPointers[i] = 0;
        }
        turn = PLAYER1;
    }

    public void placeToken(int column) {
        if (canPlaceToken(column)) {
            board.placeToken(turn, column, rowPointers[column]);
            handleWin(column, rowPointers[column]);
            rowPointers[column]++;
            turn = turn == PLAYER1 ? PLAYER2 : PLAYER1;
        }
    }

    private void handleWin(int x, int y) {
        boolean win = winChecker.win(turn, x, y);
        if (win) {
            winner = Optional.of(new Winner(turn, x, y));
        }
    }

    public boolean canPlaceToken(int column) {
        return rowPointers[column] < Board.HEIGHT;
    }

    public boolean foundWinner() {
        return winner.isPresent();
    }

    private class Winner {
        private final Cell cell;
        private final int x;
        private final int y;

        public Winner(Cell cell, int x, int y) {
            this.cell = cell;
            this.x = x;
            this.y = y;
        }
    }

}
