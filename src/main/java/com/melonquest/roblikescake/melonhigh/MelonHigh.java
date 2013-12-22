package com.melonquest.roblikescake.melonhigh;

import com.melonquest.roblikescake.melonhigh.listeners.PlayerListener;
import org.bukkit.plugin.java.JavaPlugin;

public class MelonHigh extends JavaPlugin {
	public static MelonHigh p;

	public MelonHigh() {
		p = this;
	}
	public void onEnable() {
		p = this;
		getServer().getPluginManager().registerEvents(new PlayerListener(), this);
		getLogger().info("Get your MelonHigh on!");
	}

	public void onDisable() {
		getLogger().info("MelonHigh went bye bye! :(");
	}
}
