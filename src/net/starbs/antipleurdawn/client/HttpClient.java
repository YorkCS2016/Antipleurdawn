package net.starbs.antipleurdawn.client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
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

        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", "antiplerdawn/1.0");

        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.flush();
        wr.close();

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

        try {
            String inputLine;
            StringBuffer buffer = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                buffer.append(inputLine);
            }

            Response response = new Response(con.getResponseCode(), buffer.toString());

            if (response.getCode() >= 300) {
                if (response.getCode() >= 500) {
                    throw new HttpServerException(response);
                } else {
                    throw new HttpClientException(response);
                  }
              }

            return response;
        } finally {
            in.close();
        }
    }
}
