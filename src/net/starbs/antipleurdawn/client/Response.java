package net.starbs.antipleurdawn.client;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Response
{
    private int code;

    private String message;

    private JsonParser parser;

    public Response(int code, String message)
    {
        this.code = code;
        this.message = message;
        parser = new JsonParser();
    }

    public int getCode()
    {
        return code;
    }

    public String getMessage()
    {
        return message;
    }

    public JsonObject parse()
    {
        JsonElement element = parser.parse(message);

        return element.getAsJsonObject();
    }
}
