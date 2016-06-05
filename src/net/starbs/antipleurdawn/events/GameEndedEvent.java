package net.starbs.antipleurdawn.events;

import net.starbs.antipleurdawn.PlayerType;
import java.util.EventObject;

@SuppressWarnings("serial")
public class GameEndedEvent extends EventObject
{
    // TODO

    public GameEndedEvent(Object source) {
        super(source);
        // TODO
    }

    public PlayerType getWinner() {
        // TODO
        return PlayerType.BLACK;
    }

}
