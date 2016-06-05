package net.starbs.antipleurdawn.pusher;

import com.pusher.client.channel.SubscriptionEventListener;

import net.starbs.antipleurdawn.events.GameEndedEvent;
import net.starbs.antipleurdawn.events.GameUpdatedEvent;
import net.starbs.antipleurdawn.handlers.HandlerInterface;

public class PusherHandler implements SubscriptionEventListener
{
    private HandlerInterface handler;

    public PusherHandler(HandlerInterface handler)
    {
        this.handler = handler;
    }

    public void onEvent(String channel, String event, String data)
    {
        if (event == "GameUpdatedEvent") {
            handler.onGameUpdated(new GameUpdatedEvent(data));
        } else {
            handler.onGameEnded(new GameEndedEvent(data));
        }
    }
}
