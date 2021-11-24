package com.bingohelper;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.*;
import net.runelite.client.events.NpcLootReceived;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.ItemStack;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

import java.io.IOException;
import java.util.Collection;

@Slf4j
@PluginDescriptor(
	name = "Bingo Helper"
)
public class BingoHelperPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private BingoHelper config;

	@Override
	protected void startUp() throws Exception
	{
		log.info("Example started!");
	}

	@Override
	protected void shutDown() throws Exception
	{
		log.info("Example stopped!");
	}

	@Subscribe
	public void onNpcLootReceived(final NpcLootReceived npcLootReceived)
	{
		final Player player = client.getLocalPlayer();
		final NPC npc = npcLootReceived.getNpc();
		final Collection<ItemStack> items = npcLootReceived.getItems();
		final String name = npc.getName();

		JsonRequestBuilder jsonRequestBuilder = new JsonRequestBuilder(player.getName(), npc.getName(), items);

		try{
			jsonRequestBuilder.send();
		}catch (Exception e) {
			log.info("Something went wrong with the request to the web app" + e);
		}
	}

	@Provides
    BingoHelper provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(BingoHelper.class);
	}
}
