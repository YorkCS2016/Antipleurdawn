package net.starbs.antipleurdawn;

import net.starbs.antipleurdawn.client.Client;
import net.starbs.antipleurdawn.events.MoveChosenEvent;
import net.starbs.antipleurdawn.events.MoveChosenEventListener;
import net.starbs.antipleurdawn.ui.Board;

public class BoardOperator implements MoveChosenEventListener
{
    private Board board;
    private Client client;

    public BoardOperator(Board board, Client client)
    {
        this.board = board;
        this.board.addMoveChosenEventListener(this);
        this.client = client;
    }

    public void moveChosenEventOccurred(MoveChosenEvent event)
    {
        try {
            client.move(event.getFrom(), event.getTo());
        } catch (Exception e) {
            // TODO: change this
            System.out.println(e.getMessage());
        }
    }
}
