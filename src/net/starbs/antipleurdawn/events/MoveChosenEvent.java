package net.starbs.antipleurdawn.events;

import java.util.EventObject;

/**
 * Created by sharr_000 on 6/4/2016.
 */
public class MoveChosenEvent extends EventObject {
    // Used by BoardUI to signal to BoardOperator that a move has been taken.

    int[] from;
    int[] to;

    public MoveChosenEvent(Object source, int[] pnt_from, int[] pnt_to) {
        super(source);
        from = pnt_from;
        to = pnt_to;
    }

    public int[] getFrom() {
        return from;
    }

    public int[] getTo() {
        return to;
    }
}
