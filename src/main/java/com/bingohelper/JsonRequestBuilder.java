package com.bingohelper;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import net.runelite.client.game.ItemStack;

import java.util.Collection;

public class JsonRequestBuilder {
    String playerName;
    String npcName;
    Collection items;

    JsonRequestBuilder(String playerName, String npcName, Collection<ItemStack> items)
    {
        this.playerName = playerName;
        this.npcName = npcName;
        this.items = items;
    }

    public String build(){
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
