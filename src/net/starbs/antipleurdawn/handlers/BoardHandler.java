package net.starbs.antipleurdawn.handlers;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.effect.BoxBlur;
import javafx.scene.layout.FlowPane;
import net.starbs.antipleurdawn.Piece;
import net.starbs.antipleurdawn.client.Client;
import net.starbs.antipleurdawn.events.GameEndedEvent;
import net.starbs.antipleurdawn.events.GameUpdatedEvent;
import net.starbs.antipleurdawn.ui.Board;

public class BoardHandler implements HandlerInterface
{
    private Board board;
    private Client client;
    private Scene scene;

    public BoardHandler(Board board, Client client, Scene scene)
    {
        this.board = board;
        this.client = client;
        this.scene = scene;
    }

    public void onGameUpdated(GameUpdatedEvent event)
    {
        displayCapturedPieces(event.getPiecesTakenBy(client.getPlayer()), event.getPiecesTakenBy(client.getOpponent()));

        board.displayData(event.getBoard());

        if (event.getCurrentPlayer() == client.getPlayer()) {
            hideWaitingScreen();
        } else {
            displayWaitingScreen();
        }
    }

    // TODO
    private void displayCapturedPieces(Piece[] yourCaptures, Piece[] oppCaptures)
    {
//        FlowPane yourCapturesUI = (FlowPane) scene.lookup("yourCaptures");
//        FlowPane oppCapturesUI = (FlowPane) scene.lookup("oppCaptures");
//
//        yourCapturesUI.getChildren().removeAll();
//        oppCapturesUI.getChildren().removeAll();
//
//        for (Piece yourCapture : yourCaptures) {
//            yourCapturesUI.getChildren().add(yourCapture.getImage());
//        }
//
//        for (Piece oppCapture: oppCaptures) {
//            oppCapturesUI.getChildren().add(oppCapture.getImage());
//        }
    }

    private void displayWaitingScreen()
    {
        BoxBlur bb = new BoxBlur();
        bb.setWidth(5);
        bb.setHeight(5);
        bb.setIterations(1);

        scene.lookup("#main").setEffect(bb);
        scene.lookup("#overlay").setStyle("visibility: visible");
    }

    private void hideWaitingScreen() {
        scene.lookup("#main").setEffect(null);
        scene.lookup("#overlay").setStyle("visibility: hidden");
    }

    public void onGameEnded(GameEndedEvent event)
    {
        if (event.getWinner() == client.getPlayer()) {
            System.out.println("You win!");
        } else {
            System.out.println("You are a burden on modern society.");
        }
        
        Platform.exit();
    }
}
