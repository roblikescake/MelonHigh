package com.melonquest.roblikescake.melonhigh.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;
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

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();

		if (!player.hasPermission("melonhigh.admin")) {
			event.setJoinMessage(ChatColor.BLACK + "[" + ChatColor.GREEN + "+" + ChatColor.BLACK + "] " + ChatColor.GRAY + player.getName());
		} else {
			event.setJoinMessage(null);
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
	public void onPlayerQuit(PlayerQuitEvent event) {
		Player player = event.getPlayer();

	    if (!player.hasPermission("melonhigh.admin")) {
		    event.setQuitMessage(ChatColor.BLACK + "[" + ChatColor.RED + "-" + ChatColor.BLACK + "] " + ChatColor.GRAY + player.getName());
	    } else {
		    event.setQuitMessage(null);
	    }
	}

	@EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
	public void onPlayerKick(PlayerKickEvent event) {
		Player player = event.getPlayer();

		if (!player.hasPermission("melonhigh.admin")) {
			event.setLeaveMessage(ChatColor.BLACK + "[" + ChatColor.RED + "-" + ChatColor.BLACK + "] " + ChatColor.GRAY + player.getName());
		} else {
			event.setLeaveMessage(null);
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
	public void onBlockBreak(BlockBreakEvent event) {
		Block brokenBlock = event.getBlock();

		if (brokenBlock.getType() != Material.DOUBLE_STEP) {
			return;
		}

		Player player = event.getPlayer();
		ItemStack itemInHand = player.getItemInHand();

		if (itemInHand == null) {
			return;
		}

		if (!itemInHand.getItemMeta().hasEnchant(Enchantment.SILK_TOUCH)) {
			return;
		}

		brokenBlock.setType(Material.AIR);
		brokenBlock.getWorld().dropItemNaturally(brokenBlock.getLocation(), new ItemStack(Material.DOUBLE_STEP, 1));
	}
}
