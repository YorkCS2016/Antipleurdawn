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
        http = new HttpClient(URI);
    }

    public ClientFactory(String uri)
    {
        http = new HttpClient(uri);
    }

    public Client make() throws IOException
    {
        JsonObject data = http.send("game").parse().getAsJsonObject("data");

        String game = data.getAsJsonObject("game").getAsString();
        
        PlayerType player = data.getAsJsonObject("player").getAsInt() == 0 ? PlayerType.WHITE : PlayerType.BLACK;
        
        return new Client(http, game, player);
    }
}
