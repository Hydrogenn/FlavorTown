package me.hydrogenn.flavortown;

import org.bukkit.ChatColor;

public enum FoodGroup {
	
	PROTEIN(ChatColor.RED, 1.0, 1.0),
	VEGETABLE(ChatColor.GREEN, 1.5, 1.5),
	FRUIT(ChatColor.BLUE, 0.75, 1.0),
	GRAIN(ChatColor.YELLOW, 1.0, 0.75),
	DAIRY(ChatColor.WHITE, 1.0, 1.0),
	SUGAR(ChatColor.DARK_GRAY, 1.0, 0.0),
	TOXIC(ChatColor.DARK_PURPLE, 0.0, 0.5),
	NONE(ChatColor.BLACK, 0.0, 0.0); //TODO do not display this food group at all
	
	ChatColor color;
	
	//TODO this could benefit from a little more simplicity.
	double stalenessFromLackOfVariety; //how quickly does this food get stale by itself? how bad does this taste by itself?
	double freshnessToOtherFoodGroups; //how much do you need to eat before other foods get less stale? how healthy is it for you?
	
	private FoodGroup(ChatColor color, double staleness, double freshness) {
		this.color = color;
		this.stalenessFromLackOfVariety = staleness;
		this.freshnessToOtherFoodGroups = freshness;
	}
	
	public ChatColor getColor() {
		return color;
	}
	
}
