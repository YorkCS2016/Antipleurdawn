package net.starbs.antipleurdawn;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException{

        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));

        Scene main = new Scene(root, 670, 400, false, SceneAntialiasing.BALANCED);

        main.getStylesheets().add("file:src/main.css");

        primaryStage.setScene(main);
        primaryStage.setTitle("Anti Chess");
        primaryStage.setResizable(false);
        primaryStage.show();
        /*
        yourTakenPieces.displayPieces(new Piece[]{
                new Piece(PieceType.BISHOP, PlayerType.WHITE)
        });

        board.squares[0][0].setPiece(new Piece(PieceType.BISHOP, PlayerType.WHITE));
        */
    }


    public static void main(String[] args) {
        launch(args);
    }
}
