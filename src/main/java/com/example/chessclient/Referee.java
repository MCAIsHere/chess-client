package com.example.chessclient;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Referee {
    private static Referee single_instance = null;
    private Piece[][] board;
    private int currentTurn;

    private Referee() {
        this.currentTurn = 0;
        this.board = new Piece[8][8];
        setBoard();
    }
    // Singleton class
    public static synchronized Referee getInstance()
    {
        if (single_instance == null)
            single_instance = new Referee();

        return single_instance;
    }

    public int getTurn() { return currentTurn; }
    public Piece[][] getBoard() { return board; }
    public List<Pair<Integer,Integer>> getVisibleSquares(int r, int c, int id) {
        List<Pair<Integer,Integer>> res = new ArrayList<>();

        return res;
    }
    private void setBoard(){
        board[0][0] = new Piece(1,'R');
        board[0][1] = new Piece(1,'N');
        board[0][2] = new Piece(1,'B');
        board[0][3] = new Piece(1,'Q');
        board[0][4] = new Piece(1,'K');
        board[0][5] = new Piece(1,'B');
        board[0][6] = new Piece(1,'N');
        board[0][7] = new Piece(1,'R');
        for (int i = 0; i < 8; i++) board[1][i] = new Piece(0,'P');
        for (int i = 0; i < 8; i++) board[6][i] = new Piece(1,'P');
        board[7][0] = new Piece(0,'R');
        board[7][1] = new Piece(0,'N');
        board[7][2] = new Piece(0,'B');
        board[7][3] = new Piece(0,'Q');
        board[7][4] = new Piece(0,'K');
        board[7][5] = new Piece(0,'B');
        board[7][6] = new Piece(0,'N');
        board[7][7] = new Piece(0,'R');
    }


    private boolean isValid(int r, int c) {
        return r >= 0 && r < 8 && c >= 0 && c < 8;
    }

}
