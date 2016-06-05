package net.starbs.antipleurdawn;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.stage.Stage;
import net.starbs.antipleurdawn.client.Client;
import net.starbs.antipleurdawn.client.ClientFactory;
import net.starbs.antipleurdawn.events.GameUpdatedEvent;
import net.starbs.antipleurdawn.ui.Board;

import java.io.IOException;

public class Main extends Application
{
    private Client client;
    private Board board;
    private BoardOperator boardOp;

    public Main()
    {
        client = (new ClientFactory()).make();
        board = null;
        boardOp = null;
    }

    public void start(Stage primaryStage) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));

        Scene main = new Scene(root, 670, 400, false, SceneAntialiasing.BALANCED);

        main.getStylesheets().add("file:src/main.css");

        board = (Board) main.lookup("#board");
        boardOp = new BoardOperator(board, client);

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

    void onGameUpdated(GameUpdatedEvent event)
    {
        //board.onGameUpdated(event);
        if (event.getCurrentPlayer() != client.getPlayer()) {
            // TODO: display waiting screen
        }
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
