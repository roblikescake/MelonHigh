package com.melonquest.roblikescake.melonhigh;

import com.melonquest.roblikescake.melonhigh.listeners.PlayerListener;
import com.melonquest.roblikescake.melonhigh.managers.ItemManager;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class MelonHigh extends JavaPlugin {
	public static MelonHigh p;

	public MelonHigh() {
		p = this;
	}
	public void onEnable() {
		p = this;

		registerListeners();
		registerManagers();

		getLogger().info("Get your MelonHigh on!");
	}

	public void onDisable() {
		clearCustomRecipes();
		getLogger().info("MelonHigh went bye bye! :(");
	}

	public void registerListeners() {
		PluginManager pm = getServer().getPluginManager();

		pm.registerEvents(new PlayerListener(), this);
	}

	public void registerManagers() {
		new ItemManager();
	}

	public void clearCustomRecipes() {
		getServer().clearRecipes();
	}
}
