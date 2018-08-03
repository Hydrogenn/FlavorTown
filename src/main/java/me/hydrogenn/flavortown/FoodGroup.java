package me.hydrogenn.flavortown;

import org.bukkit.ChatColor;

public enum FoodGroup {
	
	PROTEIN(ChatColor.RED),
	DAIRY(ChatColor.WHITE), //not final
	FRUIT(ChatColor.BLUE), //not final
	VEGETABLE(ChatColor.GREEN),
	GRAIN(ChatColor.YELLOW),
	TOXIC(ChatColor.DARK_PURPLE),
	SUGAR(ChatColor.GRAY),
	NONE(ChatColor.AQUA); //not final
	
	ChatColor color;
	
	private FoodGroup(ChatColor color) {
		this.color = color;
	}
	
	public ChatColor getColor() {
		return color;
	}
	
}
