package net.starbs.antipleurdawn.client;

import java.io.IOException;

import net.starbs.antipleurdawn.PlayerType;
import net.starbs.antipleurdawn.exceptions.HttpClientException;
import net.starbs.antipleurdawn.exceptions.InvalidMoveException;
import net.starbs.antipleurdawn.exceptions.OpponentMovingException;

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
        String uri = "game/" + game + "/move?player=" + (player == PlayerType.WHITE ? "0" : "1");

        uri += "&from_row=" + from[0] + "&from_col=" + from[1];

        uri += "&to_row=" + to[0] + "&to_col=" + to[1];

        try {
            http.send(uri);
        } catch (HttpClientException e) {
            if (e.getResponse().getCode() == 400) {
                throw new InvalidMoveException();
            }

            if (e.getResponse().getCode() == 403) {
                throw new OpponentMovingException();
            }
        }
    }

    public PlayerType getPlayer()
    {
        return player;
    }

    public void forfeit()
    {
        //
    }
}
