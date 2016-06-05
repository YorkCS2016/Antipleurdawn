package net.starbs.antipleurdawn.exceptions;

import net.starbs.antipleurdawn.client.Response;

@SuppressWarnings("serial")
public class HttpServerException extends RuntimeException implements ExceptionInterface
{
    private Response response;

    public HttpServerException(Response response)
    {
        this.response = response;
    }

    public Response getResponse()
    {
        return response;
    }
}
