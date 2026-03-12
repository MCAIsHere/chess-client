package com.example.chessclient;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.util.Pair;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ChessController {
    // 0 - white; 1 - black;
    private ChessClient chessClient;
    private Referee referee;

    private int row_clicked;
    private int col_clicked;
    private List<Pair<Integer, Integer>> squaresHighlighted = new ArrayList<>();

    @FXML
    private GridPane board;
    private StackPane[][] squares = new StackPane[8][8];
    @FXML
    public void initialize() {
        row_clicked = -1;
        col_clicked = -1;
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {

                StackPane square = new StackPane();
                square.setPrefSize(60, 60);
                square.setId(String.format("%d%d", row, col));

                if ((row + col) % 2 == 0) square.setStyle("-fx-background-color: white;");
                else square.setStyle("-fx-background-color: black;");

                final int r = row, c = col;
                square.setOnMouseClicked(event -> {SquareClick(r, c);});

                board.add(square, col, row);
                squares[row][col] = square;
            }
        }
    }
    private void setImage(String piece, int row, int col){
        Image img = new Image(getClass().getResourceAsStream("/pieces/" + piece));
        ImageView view = new ImageView(img);

        view.setFitHeight(60);
        view.setFitWidth(60);

        squares[row][col].getChildren().clear();
        squares[row][col].getChildren().add(view);
    }
    public void setPieces(int id){
        String[] white_row = {"wr.png","wn.png","wb.png","wq.png","wk.png","wb.png","wn.png","wr.png"};
        String[] black_row = {"br.png","bn.png","bb.png","bq.png","bk.png","bb.png","bn.png","br.png"};
        if (id == 0){
            for (int i = 0; i < 8; i++){
                setImage(black_row[i],0,i);
                setImage("bp.png",1,i);
            }
            for (int i = 0; i < 8; i++){
                setImage("wp.png",6,i);
                setImage(white_row[i],7,i);
            }
        }else{
            for (int i = 0; i < 8; i++){
                setImage(white_row[i],0,i);
                setImage("wP.png",1,i);
            }
            for (int i = 0; i < 8; i++){
                setImage("bP.png",6,i);
                setImage(black_row[i],7,i);
            }
        }
    }
    public void setClient(ChessClient chessClient, Referee referee){
        this.chessClient = chessClient;
        this.referee = referee;
    }

    private void SquareClick(int r, int c){
        if (r == row_clicked && c == col_clicked){

        }
    }
    private void Move(int r, int c){

    }
}
