package net.starbs.antipleurdawn;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.stage.Stage;
import net.starbs.antipleurdawn.client.Client;
import net.starbs.antipleurdawn.client.ClientFactoryEE;
import net.starbs.antipleurdawn.events.GameUpdatedEvent;

import java.io.IOException;

public class Main extends Application {
    private final Client client;
    //private final BoardOperator boardOp;

    public Main(){
        client = ClientFactoryEE.make();
        //boardOp = new BoardOperator(board, client);
    }

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

    void onGameUpdated(GameUpdatedEvent event) {
        //board.onGameUpdated(event);
        if(event.getCurrentPlayer() != client.getPlayer()) {
            // TODO: display waiting screen
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
