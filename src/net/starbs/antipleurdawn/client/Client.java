package net.starbs.antipleurdawn.client;

import java.io.IOException;

import net.starbs.antipleurdawn.PlayerType;

public class Client
{
    private HttpClient http;
    private String game;
    private PlayerType player;

    public Client(HttpClient http, String game, PlayerType player)
    {
        this.http = http;
        this.game = game;
        this.player = player;
    }

    public void move(int[] from, int[] to) throws IOException
    {
        http.send("game/" + game + "/move?from_row=" + from[0]);
    }

    public PlayerType getPlayer()
    {
        return player;
    }

    public void forfeit()
    {
        // TODO
    }
}
