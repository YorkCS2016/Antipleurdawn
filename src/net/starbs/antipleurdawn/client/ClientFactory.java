package net.starbs.antipleurdawn.client;

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

    public Client make()
    {
        return new Client(http, "", PlayerType.WHITE);
    }
}
