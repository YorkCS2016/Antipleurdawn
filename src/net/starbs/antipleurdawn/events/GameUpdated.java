package net.starbs.antipleurdawn.events;

import javafx.event.Event;
import net.starbs.antipleurdawn.Piece;
import net.starbs.antipleurdawn.PlayerType;

/**
 * Created by sharr_000 on 6/4/2016.
 */
public class GameUpdated {
    // TODO

    GameUpdated() {
        // TODO
    }

    Piece[][] getBoard() {
        // TODO
        return new Piece[1][1];
    }

    Piece[] getPiecesTakenBy(PlayerType player) {
        // TODO
        return new Piece[1];
    }

    PlayerType getCurrentPlayer() {
        // TODO
        return PlayerType.WHITE;
    }

}