package net.starbs.antipleurdawn.handlers;

import javafx.animation.Transition;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.BoxBlur;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import net.starbs.antipleurdawn.Piece;
import net.starbs.antipleurdawn.PlayerType;
import net.starbs.antipleurdawn.client.Client;
import net.starbs.antipleurdawn.events.GameBootedEvent;
import net.starbs.antipleurdawn.events.GameEndedEvent;
import net.starbs.antipleurdawn.events.GameUpdatedEvent;
import net.starbs.antipleurdawn.ui.Board;

public class BoardHandler implements BootHandlerInterface, PusherHandlerInterface
{
    private Board board;
    private Client client;
    private Scene scene;

    public BoardHandler(Board board, Client client, Scene scene)
    {
        this.board = board;
        this.client = client;
        this.scene = scene;

        scene.lookup("#quitButton").setOnMouseClicked(event -> Platform.exit());
    }

    public void onGameBooting(GameBootedEvent event)
    {
        Stage stage = event.getStage();

        stage.setScene(scene);
        stage.setTitle("Anti Chess");
        stage.setResizable(false);

        displayWaitingScreen();

        //(new Music()).play();
    }

    public void onGameUpdated(GameUpdatedEvent event)
    {
        displayCapturedPieces(event.getPiecesTakenBy(PlayerType.WHITE), event.getPiecesTakenBy(PlayerType.BLACK));

        board.displayData(event.getBoard());

        if (event.getCurrentPlayer() == client.getPlayer()) {
            hideWaitingScreen();
        } else {
            displayWaitingScreen();
        }
    }

    private void displayCapturedPieces(Piece[] piecesTakenByWhite, Piece[] piecesTakenByBlack)
    {
        FlowPane whiteCaptures = (FlowPane) scene.lookup("#whiteCaptures");
        FlowPane blackCaptures = (FlowPane) scene.lookup("#blackCaptures");

        whiteCaptures.getChildren().clear();
        blackCaptures.getChildren().clear();

        for (Piece piece : piecesTakenByWhite) {
            whiteCaptures.getChildren().add(piece.getImage());
        }

        for (Piece piece: piecesTakenByBlack) {
            blackCaptures.getChildren().add(piece.getImage());
        }
    }

    private void displayOverlay()
    {
        BoxBlur bb = new BoxBlur();
        bb.setWidth(5);
        bb.setHeight(5);
        bb.setIterations(1);

        scene.lookup("#main").setEffect(bb);
        scene.lookup("#overlay").setStyle("visibility: visible");
    }

    private void hideOverlay()
    {
        scene.lookup("#main").setEffect(null);
        scene.lookup("#overlay").setStyle("visibility: hidden");
    }

    private void displayWaitingScreen()
    {
        displayOverlay();
        scene.lookup("#waitingBox").setStyle("visibility: visible");
    }

    private void hideWaitingScreen()
    {
        hideOverlay();
        scene.lookup("#waitingBox").setStyle("visibility: hidden");
    }

    private void displayWinningScreen()
    {
        final int maxSize = 100;

        displayOverlay();

        Label endGameText = (Label)scene.lookup("#endGameText");
        endGameText.setText("You Win!");
        endGameText.getStyleClass().add("winningLabel");
        endGameText.setStyle("visibility: visible");

        Transition fontIncrease = new Transition() {
            {
                setCycleDuration(Duration.millis(1000));
            }
            @Override
            protected void interpolate(double frac) {
                endGameText.setStyle("-fx-font-size: " + Math.pow(frac, 3) * maxSize + "px");
            }
        };
        fontIncrease.setOnFinished(event -> scene.lookup("#endGameButtons").setStyle("visibility: visible"));
        fontIncrease.play();
    }

    private void displayLosingScreen(){
        displayOverlay();

        Label endGameText = (Label)scene.lookup("#endGameText");

        endGameText.setText("You Lose :(");
        endGameText.getStyleClass().add("losingLabel");
        endGameText.setStyle("visibility: visible");

        scene.lookup("#endGameButtons").setStyle("visibility: visible");
    }

    public void onGameEnded(GameEndedEvent event)
    {
        if (event.getWinner() == client.getPlayer()) {
            displayWinningScreen();
        } else {
            displayLosingScreen();
        }
    }
}
