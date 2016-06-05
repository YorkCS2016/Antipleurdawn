package net.starbs.antipleurdawn.client;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpClient
{
    private String uri;

    public HttpClient(String uri)
    {
        this.uri = uri;
    }

    public Response send(String route) throws IOException
    {
          URL url = new URL(uri + route);

          HttpURLConnection connection = (HttpURLConnection) url.openConnection();
          connection.setDoOutput(true);
          connection.setRequestMethod("POST");

          OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());

          try {
              return new Response(connection.getResponseCode(), connection.getResponseMessage());
          } finally {
              out.close();
          }
    }
}
