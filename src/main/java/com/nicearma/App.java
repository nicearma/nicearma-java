package com.nicearma;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        HttpServer server = Vertx.vertx().createHttpServer();

        server.requestHandler(request -> {

            // This handler gets called for each request that arrives on the server
            HttpServerResponse response = request.response();
            response.putHeader("content-type", "application/json");
            response.putHeader("Access-Control-Allow-Origin", "*");

            JsonObject j = new JsonObject();
            j.getValue("hello", "hello");

            // Write to the response and end it
            response.end(j.toString());
        });

        server.listen(9000);

    }
}
