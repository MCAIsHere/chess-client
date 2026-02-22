package com.example.chessclient;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class ChessController {
    @FXML
    private GridPane board;
    private StackPane[][] squares = new StackPane[8][8];
    // 0 - white; 1 - black;
    private int turn;

    @FXML
    public void initialize() {
        turn = 0;
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {

                StackPane square = new StackPane();
                square.setPrefSize(60, 60);
                square.setId(String.format("%d%d", row, col));

                if ((row + col) % 2 == 0) square.setStyle("-fx-background-color: white;");
                else square.setStyle("-fx-background-color: black;");


                board.add(square, col, row);
                squares[row][col] = square;
            }
        }
    }
}
