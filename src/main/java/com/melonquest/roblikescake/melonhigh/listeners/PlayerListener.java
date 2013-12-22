package com.melonquest.roblikescake.melonhigh.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PlayerListener implements Listener{

	@EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
	public void onPlayerInteract(PlayerInteractEvent event) {
		if (event.getAction() != Action.LEFT_CLICK_BLOCK) {
			return;
		}

		Block clickedBlock = event.getClickedBlock();

		if (clickedBlock.getType() != Material.LONG_GRASS) {
			return;
		}

		Player player = event.getPlayer();
		ItemStack itemInHand = player.getItemInHand();

		if (itemInHand.getType() != Material.PAPER) {
			return;
		}

		player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 200, 5));
		player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 200, 5));
		player.sendMessage(ChatColor.DARK_GREEN + "Heyyyy man are you enjoying that buzzzzz???");
	}
}
