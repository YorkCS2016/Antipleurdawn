package net.starbs.antipleurdawn.client;

import java.io.IOException;

import com.google.gson.JsonObject;

import net.starbs.antipleurdawn.PlayerType;

public class ClientFactory
{
    public static final String URI = "https://negasaurus.starbs.net/";

    private HttpClient http;

    public ClientFactory()
    {
        this(URI);
    }

    public ClientFactory(String uri)
    {
        http = new HttpClient(uri);
    }

    public Client make() throws IOException
    {
        JsonObject data = http.send("game").parse().getAsJsonObject("data");

        String game = data.getAsJsonPrimitive("game").getAsString();

        PlayerType player = data.getAsJsonPrimitive("player").getAsInt() == 0 ? PlayerType.WHITE : PlayerType.BLACK;

        return new Client(http, game, player);
    }
}
