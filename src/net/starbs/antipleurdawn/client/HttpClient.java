package net.starbs.antipleurdawn.client;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import net.starbs.antipleurdawn.exceptions.HttpClientException;
import net.starbs.antipleurdawn.exceptions.HttpServerException;

public class HttpClient
{
    private String uri;

    public HttpClient(String uri)
    {
        this.uri = uri;
    }

    public Response send(String route) throws IOException, HttpServerException, HttpClientException
    {
        URL url = new URL(uri + route);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.setRequestMethod("POST");

        OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());

        try {
            Response response = new Response(connection.getResponseCode(), connection.getResponseMessage());

            if (response.getCode() >= 300) {
                if (response.getCode() >= 500) {
                    throw new HttpServerException(response);
                } else {
                    throw new HttpClientException(response);
                  }
              }

            return response;
        } finally {
            out.close();
        }
    }
}
