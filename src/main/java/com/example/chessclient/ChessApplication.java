package com.example.chessclient;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.io.IOException;

public class ChessApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Referee referee = Referee.getInstance();

        Stage stageWhite;
        FXMLLoader loader_white = new FXMLLoader(ChessApplication.class.getResource("board.fxml"));
        Scene scene_white = new Scene(loader_white.load(), 640, 640);
        stageWhite = stage;
        stageWhite.setTitle("White screen");
        stageWhite.setScene(scene_white);

        ChessClient white_client = new ChessClient("127.0.0.1",5000,loader_white.getController());
        ChessController white_controller = loader_white.getController();
        white_client.startListening();
        white_controller.setPieces(0);
        white_controller.setClient(white_client,referee);
        stageWhite.show();

        Stage stageBlack;
        FXMLLoader loader_black = new FXMLLoader(ChessApplication.class.getResource("board.fxml"));
        Scene scene_black = new Scene(loader_black.load(), 640, 640);
        stageBlack = new Stage();
        stageBlack.setTitle("Black screen");
        stageBlack.setScene(scene_black);

        ChessClient black_client = new ChessClient("127.0.0.1",5000,loader_black.getController());
        ChessController black_controller = loader_black.getController();
        black_client.startListening();
        black_controller.setPieces(1);
        black_controller.setClient(black_client,referee);
        stageBlack.show();
    }
}
