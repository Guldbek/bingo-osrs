package com.bingohelper;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
@ConfigGroup("bingohelper")
public interface BingoHelper extends Config
{
	@ConfigItem(
		position = 0,
		keyName = "greeting",
		name = "Welcome Greeting",
		description = "The message to show to the user when they login"
	)
	default String greeting() { return "Hello"; }

	@ConfigItem(
		position = 1,
		keyName = "clanId",
		name = "Clan ID",
		description = "This can be found on the website at the How to page"
	)
	default String clanId() { return "123"; }

	@ConfigItem(
			position = 1,
			keyName = "userId",
			name = "User ID",
			description = "This can be found on the website at the How to page"
	)
	default String teamId() { return "123"; }

	@ConfigItem(
			position = 1,
			keyName = "teamId",
			name = "Team ID",
			description = "This can be found on the website at the How to page"
	)
	default String eventId() { return "123"; }

	@ConfigItem(
			position = 1,
			keyName = "eventId",
			name = "Event ID",
			description = "This can be found on the website at the How to page"
	)
	default String userId() { return "123"; }
}
