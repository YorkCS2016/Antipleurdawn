package net.starbs.antipleurdawn.handlers;

import net.starbs.antipleurdawn.events.GameEndedEvent;
import net.starbs.antipleurdawn.events.GameUpdatedEvent;

public interface HandlerInterface
{
    public void onGameUpdated(GameUpdatedEvent event);
    public void onGameEnded(GameEndedEvent event);
}
