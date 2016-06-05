package net.starbs.antipleurdawn.exceptions;

import net.starbs.antipleurdawn.client.Response;

@SuppressWarnings("serial")
public class HttpClientException extends RuntimeException implements ExceptionInterface
{
    private Response response;

    public HttpClientException(Response response)
    {
        this.response = response;
    }

    public Response getResponse()
    {
        return response;
    }
}
