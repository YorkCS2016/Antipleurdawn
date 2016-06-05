package net.starbs.antipleurdawn.events;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import net.starbs.antipleurdawn.Piece;
import net.starbs.antipleurdawn.PieceType;
import net.starbs.antipleurdawn.PlayerType;

public class GameUpdatedEvent implements EventInterface
{
    private Piece[][] board;

    private Piece[] takenByWhite;

    private Piece[] takenByBlack;

    private PlayerType currentPlayer;

    public GameUpdatedEvent(String data)
    {
        JsonObject element = (new JsonParser()).parse(data).getAsJsonObject();

        initBoard(element.getAsJsonArray("board"));
        initTaken(element.getAsJsonArray("taken"));
        initCurrent(element.getAsJsonPrimitive("curent").getAsInt());
    }

    private void initBoard(JsonArray array)
    {
        board = new Piece[8][8];
        int i = 0;
        for (JsonElement row : array) {
            int j = 0;
            for (JsonElement el : row.getAsJsonArray()) {
                board[i][j] = new Piece(PieceType.values()[el.getAsInt()], PlayerType.values()[el.getAsInt()]);
                j++;
            }
            i++;
        }
    }

    private void initTaken(JsonArray array)
    {
        JsonArray white = array.get(PlayerType.WHITE.ordinal()).getAsJsonArray();
        takenByWhite = new Piece[white.size()];
        int i = 0;
        for (JsonElement el : white) {
            takenByWhite[i] = new Piece(PieceType.values()[el.getAsInt()], PlayerType.BLACK);
            i++;
        }

        JsonArray black = array.get(PlayerType.BLACK.ordinal()).getAsJsonArray();
        takenByBlack = new Piece[black.size()];
        i = 0;
        for (JsonElement el : black) {
            takenByWhite[i] = new Piece(PieceType.values()[el.getAsInt()], PlayerType.WHITE);
            i++;
        }
    }

    private void initCurrent(int index)
    {
        currentPlayer = PlayerType.values()[index];
    }

    public Piece[][] getBoard()
    {
        return board;
    }

    public Piece[] getPiecesTakenBy(PlayerType player)
    {
        return player == PlayerType.WHITE ? takenByWhite : takenByBlack;
    }

    public PlayerType getCurrentPlayer()
    {
        return currentPlayer;
    }
}
