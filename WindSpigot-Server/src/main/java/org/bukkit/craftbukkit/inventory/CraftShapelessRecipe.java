package org.bukkit.craftbukkit.inventory;

import java.util.List;

import org.bukkit.craftbukkit.util.CraftMagicNumbers;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;

import net.minecraft.server.CraftingManager;
import net.minecraft.server.ShapelessRecipes;

public class CraftShapelessRecipe extends ShapelessRecipe implements CraftRecipe {

	public CraftShapelessRecipe(ItemStack result) {
		super(result);
	}

	public CraftShapelessRecipe(ItemStack result, ShapelessRecipes recipe) {
		this(result);
		// TODO: Could eventually use this to add a matches() method or some such
	}

	public static CraftShapelessRecipe fromBukkitRecipe(ShapelessRecipe recipe) {
		if (recipe instanceof CraftShapelessRecipe) {
			return (CraftShapelessRecipe) recipe;
		}
		CraftShapelessRecipe ret = new CraftShapelessRecipe(recipe.getResult());
		for (ItemStack ingred : recipe.getIngredientList()) {
			ret.addIngredient(ingred.getType(), ingred.getDurability());
		}
		return ret;
	}

	@Override
	public void addToCraftingManager() {
		List<ItemStack> ingred = this.getIngredientList();
		Object[] data = new Object[ingred.size()];
		int i = 0;
		for (ItemStack mdata : ingred) {
			int id = mdata.getTypeId();
			short dmg = mdata.getDurability();
			data[i] = new net.minecraft.server.ItemStack(CraftMagicNumbers.getItem(id), 1, dmg);
			i++;
		}
		CraftingManager.getInstance().registerShapelessRecipe(CraftItemStack.asNMSCopy(this.getResult()), data);
	}
}
