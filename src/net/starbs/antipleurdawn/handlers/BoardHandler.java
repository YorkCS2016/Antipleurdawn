package net.starbs.antipleurdawn.handlers;

import javafx.scene.Scene;
import javafx.scene.effect.BoxBlur;
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
        board.onGameUpdated(event);
        if (event.getCurrentPlayer() == client.getPlayer()) {
            System.out.println("Make your move now.");
        } else {
            displayWaitingScreen();
        }
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

    public void onGameEnded(GameEndedEvent event)
    {
        if (event.getWinner() == client.getPlayer()) {
            System.out.println("You win!");
        } else {
            System.out.println("You are a burden on modern society.");
        }
    }
}
