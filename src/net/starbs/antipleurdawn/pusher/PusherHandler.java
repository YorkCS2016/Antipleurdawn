package net.starbs.antipleurdawn.pusher;

import com.pusher.client.channel.SubscriptionEventListener;

import javafx.application.Platform;
import net.starbs.antipleurdawn.events.GameEndedEvent;
import net.starbs.antipleurdawn.events.GameUpdatedEvent;
import net.starbs.antipleurdawn.handlers.PusherHandlerInterface;

public class PusherHandler implements SubscriptionEventListener
{
    private PusherHandlerInterface handler;

    public PusherHandler(PusherHandlerInterface handler)
    {
        this.handler = handler;
    }

    public void onEvent(String channel, String event, String data)
    {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                if (event.equals("GameUpdatedEvent")) {
                    handler.onGameUpdated(new GameUpdatedEvent(data));
                } else {
                    handler.onGameEnded(new GameEndedEvent(data));
                }
            }
        });
    }
}
