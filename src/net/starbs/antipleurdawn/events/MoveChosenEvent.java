package net.starbs.antipleurdawn.events;

import java.util.EventObject;

@SuppressWarnings("serial")
public class MoveChosenEvent extends EventObject
{
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
