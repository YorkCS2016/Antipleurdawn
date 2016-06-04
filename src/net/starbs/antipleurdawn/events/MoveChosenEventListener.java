package net.starbs.antipleurdawn.events;

import java.util.EventListener;

public interface MoveChosenEventListener extends EventListener
{
    public void moveChosenEventOccurred(MoveChosenEvent event);
}
