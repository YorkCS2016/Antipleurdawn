package net.starbs.antipleurdawn.events;

import javafx.event.Event;
import net.starbs.antipleurdawn.Piece;
import net.starbs.antipleurdawn.PlayerType;

import java.util.EventObject;

/**
 * Created by sharr_000 on 6/4/2016.
 */
public class GameUpdatedEvent extends EventObject {
    // TODO

    public GameUpdatedEvent(Object source) {
        super(source);
        // TODO
    }

    public Piece[][] getBoard() {
        // TODO
        return new Piece[1][1];
    }

    public Piece[] getPiecesTakenBy(PlayerType player) {
        // TODO
        return new Piece[1];
    }

    public PlayerType getCurrentPlayer() {
        // TODO
        return PlayerType.WHITE;
    }

}
