package net.starbs.antipleurdawn.client;

import java.io.IOException;

import net.starbs.antipleurdawn.PlayerType;
import net.starbs.antipleurdawn.exceptions.HttpClientException;
import net.starbs.antipleurdawn.exceptions.InvalidGameException;
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

    public String getGame()
    {
        return game;
    }

    public PlayerType getPlayer()
    {
        return player;
    }

    public PlayerType getOpponent()
    {
        return player == PlayerType.WHITE ? PlayerType.BLACK : PlayerType.WHITE ;
    }

    public void move(int[] from, int[] to) throws IOException
    {
        String uri = "game/" + game + "/move?player=" + (player == PlayerType.WHITE ? "0" : "1");

        uri += "&from_row=" + from[0] + "&from_col=" + from[1];

        uri += "&to_row=" + to[0] + "&to_col=" + to[1];

        try {
            http.send(uri);
        } catch (HttpClientException e) {
            switch (e.getResponse().getCode()) {
            case 400:
                throw new InvalidMoveException();
            case 403:
                throw new OpponentMovingException();
            case 404:
                throw new InvalidGameException();
            default:
                throw e;
            }
        }
    }

    public void forfeit() throws IOException
    {
        try {
            http.send("game/" + game + "/forfeit?player=" + (player == PlayerType.WHITE ? "0" : "1"));
        } catch (HttpClientException e) {
            switch (e.getResponse().getCode()) {
            case 404:
                throw new InvalidGameException();
            default:
                throw e;
            }
        }

    }
}
