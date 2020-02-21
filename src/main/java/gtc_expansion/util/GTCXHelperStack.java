package gtc_expansion.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.google.common.collect.Lists;

import gtclassic.api.tile.GTTileBaseMachine;
import ic2.api.recipe.IRecipeInput;
import ic2.core.IC2;
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
	
	public static IRecipeInput input(String name){
        	return input(name, 1);
    	}

    	public static IRecipeInput input(String name, int size){
        	return GTTileBaseMachine.input(name, size);
    	}

    	public static IRecipeInput input(ItemStack stack){
        	return GTTileBaseMachine.input(stack);
    	}
    
    	public static String getRefinedIronPlate() {
        	return IC2.config.getFlag("SteelRecipes") ? "plateSteel" : "plateRefinedIron";
    	}
}
