package net.starbs.antipleurdawn.pusher;

import com.pusher.client.Pusher;
import com.pusher.client.PusherOptions;
import com.pusher.client.channel.Channel;

import net.starbs.antipleurdawn.client.Client;
import net.starbs.antipleurdawn.handlers.PusherHandlerInterface;

public class PusherBinder
{
    public static String KEY = "c9966412cb187712940c";

    public static String REGION = "eu";

    private Channel channel;

    public PusherBinder(Client client)
    {
        this(client, KEY, REGION);
    }

    public PusherBinder(Client client, String key, String region)
    {
        PusherOptions options = new PusherOptions();

        options.setCluster(region);

        Pusher pusher = new Pusher(key, options);

        pusher.connect();

        channel = pusher.subscribe(client.getGame());
    }

    public void bind(PusherHandlerInterface handler)
    {
        channel.bind("GameUpdatedEvent", new PusherHandler(handler));
        channel.bind("GameEndedEvent", new PusherHandler(handler));
    }
}
