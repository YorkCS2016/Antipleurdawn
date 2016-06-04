package net.starbs.antipleurdawn;

import net.starbs.antipleurdawn.client.Client;
import net.starbs.antipleurdawn.events.MoveChosenEvent;
import net.starbs.antipleurdawn.events.MoveChosenEventListener;
import net.starbs.antipleurdawn.exceptions.InvalidMoveException;
import net.starbs.antipleurdawn.ui.BoardUI;

/**
 * Created by sharr_000 on 6/4/2016.
 */
public class BoardOperator implements MoveChosenEventListener{
    BoardUI board;
    Client client;

    public BoardOperator(BoardUI new_board, Client new_client) {
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

    BoardUI getBoard() {
        return board;
    }

    Client getClient() {
        return client;
    }
}
