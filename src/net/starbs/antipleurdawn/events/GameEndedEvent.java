package net.starbs.antipleurdawn.events;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import net.starbs.antipleurdawn.PlayerType;

public class GameEndedEvent implements EventInterface
{
    private PlayerType winner;

    public GameEndedEvent(String data)
    {
        JsonObject element = (new JsonParser()).parse(data).getAsJsonObject();

        int winner = element.getAsJsonPrimitive("winner").getAsInt();

        this.winner = winner == 0 ? PlayerType.WHITE : PlayerType.BLACK;
    }

    public PlayerType getWinner()
    {
        return this.winner;
    }
}
