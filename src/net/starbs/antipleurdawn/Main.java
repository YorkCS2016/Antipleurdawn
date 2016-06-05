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

        Scene main = new Scene(root, 710, 440, false, SceneAntialiasing.BALANCED);

        main.getStylesheets().add("file:src/main.css");

        board = (Board) main.lookup("#board");
        boardOp = new BoardOperator(board, client);

        primaryStage.setScene(main);
        primaryStage.setTitle("Anti Chess");
        primaryStage.setResizable(false);

        /*
        yourTakenPieces.displayPieces(new Piece[]{
                new Piece(PieceType.BISHOP, PlayerType.WHITE)
        });*/
        primaryStage.show();

    }

    void onGameUpdated(GameUpdatedEvent event)
    {
        board.onGameUpdated(event);
        if (event.getCurrentPlayer() == client.getPlayer()) {
            System.out.println("Make your move now.");
        } else {
            System.out.println("Opponent is making a move.");
        }
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
