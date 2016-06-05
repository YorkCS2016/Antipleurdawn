package net.starbs.antipleurdawn;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.Label;
import javafx.scene.effect.BoxBlur;
import javafx.stage.Stage;
import net.starbs.antipleurdawn.client.*;
import net.starbs.antipleurdawn.events.*;
import net.starbs.antipleurdawn.ui.*;

import java.io.IOException;

public class Main extends Application
{
    private Client client;
    private Board board;
    private BoardOperator boardOp;
    private Scene main;

    public Main() throws IOException
    {
        client = (new ClientFactory()).make();
        board = null;
        boardOp = null;
    }

    public void start(Stage primaryStage) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));

        main = new Scene(root, 710, 440, false, SceneAntialiasing.BALANCED);

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

    public void displayWaitingScreen(){
        BoxBlur bb = new BoxBlur();
        bb.setWidth(5);
        bb.setHeight(5);
        bb.setIterations(1);

        main.lookup("#main").setEffect(bb);
        main.lookup("#overlay").setStyle("visibility: visible");
    }

    public void updatePlayerTypeBox(){
        Label desc = (Label)main.lookup("#playerDesc");
        if(client.getPlayer() == PlayerType.BLACK) {
            desc.getStyleClass().set(1, "black");
            desc.setText("Black Player");
        }
        else{
            desc.getStyleClass().set(1, "white");
            desc.setText("White Player");
        }
    }

    public void onGameUpdated(GameUpdatedEvent event) {
        board.onGameUpdated(event);
        updatePlayerTypeBox();
        if (event.getCurrentPlayer() == client.getPlayer()) {
            System.out.println("Make your move now.");
        } else {
            displayWaitingScreen();
        }
    }

    public void onGameEnded(GameEndedEvent event) {
        if(event.getWinner() == client.getPlayer()) {
            System.out.println("You win!");
        } else {
            System.out.println("You are a burden on modern society.");
        }
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
