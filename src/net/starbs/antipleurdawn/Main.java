package net.starbs.antipleurdawn;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        BorderPane top = new BorderPane();

        Label chessLabel = new Label("Anti Chess");
        chessLabel.setAlignment(Pos.TOP_RIGHT);
        chessLabel.setId("title");

        top.setLeft(chessLabel);

        TakenPieces yourTakenPieces = new TakenPieces();
        TakenPieces oppTakenPieces = new TakenPieces();

        Board board = new Board();

        BorderPane root = new BorderPane();
        root.setTop(top);
        root.setCenter(board.pane);

        Scene main = new Scene(root, 550, 500, false, SceneAntialiasing.BALANCED);
        Scene main = new Scene(root, 500, 500);

        main.getStylesheets().add("file:src/main.css");
        primaryStage.setScene(main);
        primaryStage.setTitle("Anti Chess");
        primaryStage.show();
        board.squares[0][0].setPiece(new Piece(PieceType.PAWN, PlayerType.WHITE));
    }


    public static void main(String[] args) {
        launch(args);
    }
}
