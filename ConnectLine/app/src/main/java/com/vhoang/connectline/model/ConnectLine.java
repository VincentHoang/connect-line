package com.vhoang.connectline.model;

import javax.inject.Inject;

import lombok.Getter;

import static com.vhoang.connectline.model.Cell.PLAYER1;
import static com.vhoang.connectline.model.Cell.PLAYER2;

public class ConnectLine {

    @Getter private Cell turn;
    private Board board;
    private WinChecker winChecker;
    private int[] rowPointers;

    @Inject
    public ConnectLine(Board board, WinChecker winChecker) {
        this.board = board;
        this.winChecker = winChecker;
        rowPointers = new int[Board.WIDTH];
        for (int i=0; i< rowPointers.length; i++) {
            rowPointers[i] = 0;
        }
        turn = PLAYER1;
    }

    public void placeToken(int column) {
        if (canPlaceToken(column)) {
            board.placeToken(turn, column, rowPointers[column]);
            rowPointers[column]++;
            turn = turn == PLAYER1 ? PLAYER2 : PLAYER1;
        }
    }

    public boolean canPlaceToken(int column) {
        return rowPointers[column] < Board.HEIGHT;
    }

}
