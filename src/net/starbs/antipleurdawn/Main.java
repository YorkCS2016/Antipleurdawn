package net.starbs.antipleurdawn;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.control.Label;
import javafx.scene.effect.BoxBlur;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.Stack;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        BorderPane top = new BorderPane();

        Label chessLabel = new Label("Anti Chess");
        chessLabel.setAlignment(Pos.TOP_RIGHT);
        chessLabel.getStyleClass().add("topPanel");

        Label yourPlayer = new Label("White Player");
        yourPlayer.getStyleClass().add("playerDesc");
        yourPlayer.getStyleClass().add("topPanel");

        top.setLeft(chessLabel);
        top.setRight(yourPlayer);

        TakenPieces yourTakenPieces = new TakenPieces();
        TakenPieces oppTakenPieces = new TakenPieces();

        Board board = new Board();
        board.pane.getStyleClass().add("board");

        StackPane root2 = new StackPane();
        StackPane overlayScreen = new StackPane();

        Label waitingLabel = new Label("Waiting for the other player");
        StackPane overlayPane = new StackPane();
        overlayPane.getChildren().add(waitingLabel);

        waitingLabel.getStyleClass().add("waitingBox");

        overlayScreen.getChildren().add(waitingLabel);
        overlayScreen.getStyleClass().add("overlayScreen");

        BoxBlur bb = new BoxBlur();
        bb.setWidth(5);
        bb.setHeight(5);
        bb.setIterations(1);

        BorderPane root = new BorderPane();
        root.getStyleClass().add("body");
        root.setTop(top);
        root.setCenter(board.pane);
        root.setLeft(yourTakenPieces.pane);
        root.setRight(oppTakenPieces.pane);

        //root.setEffect(bb);

        root2.getChildren().add(root);
        //root2.getChildren().add(overlayScreen);
        //root2.getChildren().add(overlayPane);

        Scene main = new Scene(root2, 670, 400, false, SceneAntialiasing.BALANCED);

        main.getStylesheets().add("file:src/main.css");
        primaryStage.setScene(main);
        primaryStage.setTitle("Anti Chess");
        primaryStage.setResizable(false);
        primaryStage.show();
        /*
        yourTakenPieces.displayPieces(new Piece[]{
                new Piece(PieceType.BISHOP, PlayerType.WHITE)
        });

        board.squares[0][0].setPiece(new Piece(PieceType.BISHOP, PlayerType.WHITE));*/
    }


    public static void main(String[] args) {
        launch(args);
    }
}
