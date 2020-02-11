package gtc_expansion.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.google.common.collect.Lists;

import ic2.core.util.misc.StackUtil;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistry;

public class GTCXHelperStack {
	
	/** damages craftingTools on crafting **/
	public static boolean damageItem(ItemStack stack, int damageInt) {
		if (stack.isItemStackDamageable()) {
			if (stack.attemptDamageItem(damageInt, new Random(), null)) {
				stack.shrink(1);
			}
			return true;
		}
		return false;
	}
	
	/** removes recipe by modId and recipeId **/
	public static void removeModRecipe(String modId, String recipeId) {
		((ForgeRegistry<?>) ForgeRegistries.RECIPES).remove(new ResourceLocation(modId, recipeId));
	}
	
	/** removes recipe by Output Stack **/
	public static void removeStackRecipe(ItemStack stack) {
		ForgeRegistry<IRecipe> recipeRegistry = (ForgeRegistry<IRecipe>) ForgeRegistries.RECIPES;
		ArrayList<IRecipe> recipesList = Lists.newArrayList(recipeRegistry.getValues());
		for (IRecipe recipe : recipesList) {
			ItemStack outputStack = recipe.getRecipeOutput();
			if (outputStack.getItem() == stack.getItem()) {
				recipeRegistry.remove(recipe.getRegistryName());
			}
		}
	}
	
	/** simulates a fake 3X3 crafting table **/
    	public static ItemStack resultStack(ItemStack stack) {
    		InventoryCrafting inventory = new InventoryCrafting(new Container() {
    			public boolean canInteractWith(EntityPlayer player) {
    				return true;
    			}
    		}, 3, 3);
    		inventory.setInventorySlotContents(4, StackUtil.copyWithSize(stack, 1));
    		try {
    			return CraftingManager.findMatchingResult(inventory, null);
    		}
    		catch (Exception e) {}
    		return null;
    	}	

    	/** returns a list of items with the same ID, but different meta **/
    	public static List<ItemStack> getBlockByMeta(ItemStack stack) {
    		NonNullList<ItemStack> list = NonNullList.create();
    		stack.getItem().getSubItems(CreativeTabs.SEARCH, list);
    		return list;
    	}
}
