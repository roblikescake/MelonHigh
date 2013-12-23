package com.melonquest.roblikescake.melonhigh.managers;

import com.melonquest.roblikescake.melonhigh.MelonHigh;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class ItemManager {

	public ItemManager() {
		MelonHigh.p.getServer().addRecipe(getDoubleStoneSlabRecipe());
	}

	public static ShapedRecipe getDoubleStoneSlabRecipe() {
		ShapedRecipe DoubleStoneSlab = new ShapedRecipe(getDoubleStoneSlab());
		DoubleStoneSlab.shape("   ", " X ", " X ");
		DoubleStoneSlab.setIngredient('X', Material.STEP);
		return DoubleStoneSlab;
	}

	public static ItemStack getDoubleStoneSlab() {
		return new ItemStack(Material.DOUBLE_STEP);
	}
}
