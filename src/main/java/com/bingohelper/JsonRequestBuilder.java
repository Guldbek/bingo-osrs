package com.bingohelper;

import com.google.gson.Gson;
import net.runelite.client.game.ItemStack;
import okhttp3.*;

import java.io.IOException;
import java.util.Collection;

public class JsonRequestBuilder {

    String playerName;
    String npcName;
    Collection items;
    String eventId;
    String teamId;

    JsonRequestBuilder(String playerName, String npcName, Collection<ItemStack> items)
    {
        this.playerName = playerName;
        this.npcName = npcName;
        this.items = items;
        this.eventId = "1";
        this.teamId = "1";
    }

    private String build()
    {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public void send() throws IOException
    {
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(
                MediaType.parse("application/json"), build());

        Request request = new Request.Builder()
                .url("http://localhost:3000/api/users_event_items")
                .header("x-api-version", "v1")
                .post(body)
                .build();

        client.newCall(request).execute();
    }
}
