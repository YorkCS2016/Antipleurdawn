package net.starbs.antipleurdawn.client;

public class Response
{
    private int code;

    private String message;

    public Response(int code, String message)
    {
        this.code = code;
        this.message = message;
    }

    public int getCode()
    {
        return code;
    }

    public String getMessage()
    {
        return message;
    }
}
