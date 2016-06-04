package net.starbs.antipleurdawn;

import net.starbs.antipleurdawn.client.Client;
import net.starbs.antipleurdawn.events.MoveChosenEvent;
import net.starbs.antipleurdawn.events.MoveChosenEventListener;
import net.starbs.antipleurdawn.exceptions.InvalidMoveException;
import net.starbs.antipleurdawn.ui.Board;

public class BoardOperator implements MoveChosenEventListener
{
    Board board;
    Client client;

    public BoardOperator(Board new_board, Client new_client) {
        board = new_board;
        board.addMoveChosenEventListener(this);
        client = new_client;
    }

    public void moveChosenEventOccurred(MoveChosenEvent event) {
        try {
            client.move(event.getFrom(), event.getTo());
        } catch (InvalidMoveException exception) {
            System.out.println("Invalid move made, try again!");
        }
    }

    Board getBoard() {
        return board;
    }

    Client getClient() {
        return client;
    }
}
