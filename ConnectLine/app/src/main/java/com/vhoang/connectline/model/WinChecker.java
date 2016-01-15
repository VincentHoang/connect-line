package com.vhoang.connectline.model;

import javax.inject.Inject;

public class WinChecker {
//TODO clean this up
    public static int WIN_COUNT = 4;

    private final Board board;

    @Inject
    public WinChecker(Board board) {
        //Either check whole board, or check board around last placed token
        this.board = board;
    }

    public boolean win(Cell cell, int x, int y) {//x and y  = last placed token
        if (board.getTokenAt(x, y) != cell) {
            return false;
        }

        //hori
        int maxSequence = 0, count = 0;
        for (int i=0; i<Board.WIDTH; i++) {
            if (board.getTokenAt(i, y).equals(cell)) {
                count++;
            } else {
                maxSequence = Math.max(maxSequence, count);
                count = 0;
            }
        }
        maxSequence = Math.max(maxSequence, count);

        //vert
        count = 0;
        for (int i=0; i<Board.HEIGHT; i++) {
            if (board.getTokenAt(x, i).equals(cell)) {
                count++;
            } else {
                maxSequence = Math.max(maxSequence, count);
                count = 0;
            }
        }
        maxSequence = Math.max(maxSequence, count);


        //** incline //
        count = 1;
        int x1 = x+1, y1 = y+1;
        for (; x1<Board.WIDTH && y1<Board.HEIGHT; x1++, y1++) {
            if (board.getTokenAt(x1, y1).equals(cell)) {
                count++;
            } else {
                break;
            }
        }
        x1 = x-1; y1 = y-1;
        for (; x1>=0 && y1>=0; x1--, y1--) {
            if (board.getTokenAt(x1, y1).equals(cell)) {
                count++;
            } else {
                break;
            }
        }
        maxSequence = Math.max(maxSequence, count);

        //****Decline ***//
        count = 1;
        x1 = x+1; y1 = y-1;
        for (; x1<Board.WIDTH && y1>=0; x1++, y1--) {
            if (board.getTokenAt(x1, y1).equals(cell)) {
                count++;
            } else {
                break;
            }
        }
        x1 = x-1; y1 = y+1;
        for (; x1>=0 && y1<Board.HEIGHT; x1--, y1++) {
            if (board.getTokenAt(x1, y1).equals(cell)) {
                count++;
            } else {
                break;
            }
        }
        maxSequence = Math.max(maxSequence, count);

//        //incli
//        count = 0;
//        int x1, y1;
//        if (x < y) {
//            x1 = 0;
//            y1 = y-x;
//        } else {
//            x1 = x-y;
//            y1 = 0;
//        }
//        for (; x1<Board.WIDTH && y1<Board.HEIGHT; x1++, y1++) {
//            if (board.getTokenAt(x1, y1).equals(cell)) {
//                count++;
//            }
//        }
//        maxSequence = Math.max(maxSequence, count);
//
//        //decli
//        count = 0;
//        if (x < y) {
//            x1 = 0;
//            y1 = y+x;
//        } else {
//            x1 = x-y;
//            y1 = Board.HEIGHT - 1;
//        }
//        for (; x1<Board.WIDTH && y1>=0; x1++, y1--) {
//            if (board.getTokenAt(x1, y1).equals(cell)) {
//                count++;
//            }
//        }
//        maxSequence = Math.max(maxSequence, count);



//        System.out.println(maxSequence);
        return maxSequence >= 4;
    }
}
