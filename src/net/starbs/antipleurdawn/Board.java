package net.starbs.antipleurdawn;

import net.starbs.antipleurdawn.ui.*;
import net.starbs.antipleurdawn.events.GameUpdatedEvent;

/**
 * Created by Hickman on 02/06/2016.
 */
public class Board{
    private BoardUI ui;

    void onGameUpdated(GameUpdatedEvent event) {
        Piece[][] new_board = event.getBoard();
        ui.displayData(new_board);
    }

    public Board(BoardUI ui) {
        this.ui = ui;
    }
}
