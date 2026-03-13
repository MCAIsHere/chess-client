package com.example.chessclient;

public class Piece {
    private final int color;
    private final char type;
    private boolean hasMoved;

    public Piece(int color, char type) {
        this.color = color;
        this.type = type;
        this.hasMoved = false;
    }

    public int getColor() { return color; }
    public char getType() { return type; }
    public boolean hasMoved() { return hasMoved; }

    public void setMoved(boolean moved) { this.hasMoved = true; }

    public boolean isWhite() { return color == 0; }
    public boolean isBlack() { return color == 1; }

    // Copy method
    public Piece copy() {
        Piece newPiece = new Piece(this.color, this.type);
        newPiece.setMoved(this.hasMoved);
        return newPiece;
    }
}