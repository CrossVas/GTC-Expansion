package gtc_expansion.recipes;

import gtc_expansion.GTCXConfiguration;
import gtc_expansion.util.GTCXHelperStack;
import gtclassic.api.material.GTMaterialGen;
import gtclassic.api.recipe.GTRecipeCraftingHandler;
import ic2.api.classic.recipe.ClassicRecipes;
import ic2.api.classic.recipe.crafting.ICraftingRecipeList;
import ic2.api.recipe.IRecipeInput;
import ic2.core.IC2;
import ic2.core.item.recipe.entry.RecipeInputCombined;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistry;

public class GTCXVanillaRecipes {
	
    static ICraftingRecipeList recipes = ClassicRecipes.advCrafting;
	
	public static void initVanillaRecipes() {
		
		/** Removals **/
		
        ((ForgeRegistry)ForgeRegistries.RECIPES).remove(new ResourceLocation("minecraft", "iron_bars"));
        ((ForgeRegistry)ForgeRegistries.RECIPES).remove(new ResourceLocation("minecraft", "hopper"));
        ((ForgeRegistry)ForgeRegistries.RECIPES).remove(new ResourceLocation("minecraft", "stick"));
        ((ForgeRegistry)ForgeRegistries.RECIPES).remove(new ResourceLocation("minecraft", "bucket"));
        ((ForgeRegistry)ForgeRegistries.RECIPES).remove(new ResourceLocation("minecraft", "minecart"));
        ((ForgeRegistry)ForgeRegistries.RECIPES).remove(new ResourceLocation("minecraft", "flint_and_steel"));
        ((ForgeRegistry)ForgeRegistries.RECIPES).remove(new ResourceLocation("minecraft", "light_weighted_pressure_plate"));
        ((ForgeRegistry)ForgeRegistries.RECIPES).remove(new ResourceLocation("minecraft", "heavy_weighted_pressure_plate"));
        ((ForgeRegistry)ForgeRegistries.RECIPES).remove(new ResourceLocation("quark", "hopper"));
        
        /** Additions **/
        
        recipes.addRecipe(GTMaterialGen.get(Blocks.IRON_BARS, 8), "RRR", "RRR", " W ", 'R', "rodIron", 'W', "craftingToolWrench");
        recipes.addRecipe(GTMaterialGen.get(Items.BUCKET), "PHP", " P ", 'P', "plateIron", 'H', "craftingToolForgeHammer");
        recipes.addRecipe(GTMaterialGen.get(Items.MINECART), "PHP", "PPP", 'P', "plateIron", 'H', "craftingToolForgeHammer");
        recipes.addRecipe(GTMaterialGen.get(Blocks.LIGHT_WEIGHTED_PRESSURE_PLATE), "PPH", 'P', "plateGold", 'H', "craftingToolForgeHammer");
        recipes.addRecipe(GTMaterialGen.get(Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE), "PPH", 'P', "plateIron", 'H', "craftingToolForgeHammer");
        recipes.addRecipe(GTMaterialGen.get(Items.FLINT_AND_STEEL), "N ", " F", 'N', "nuggetSteel", 'F', Items.FLINT);
        
        String nickel = GTCXConfiguration.general.usePlates ? "plateNickel" : "ingotNickel";
        String silver = GTCXConfiguration.general.usePlates ? "plateSilver" : "ingotSilver";
        String iron = GTCXConfiguration.general.usePlates ? "plateIron" : "ingotIron";
        IRecipeInput material = new RecipeInputCombined(1, GTCXHelperStack.input(RecipeHelper.bronze), RecipeHelper.aluminium, GTCXHelperStack.input(RecipeHelper.electrum), GTCXHelperStack.input(RecipeHelper.platinum), GTCXHelperStack.input(nickel),  GTCXHelperStack.input(RecipeHelper.refinedIron), GTCXHelperStack.input(silver), GTCXHelperStack.input(iron));
        int recipeID = IC2.config.getFlag("SteelRecipes") ? -305222786 : -156474894;
        GTRecipeCraftingHandler.overrideGTRecipe("gtclassic", "shaped_tile.hopper_" + recipeID, GTMaterialGen.get(Blocks.HOPPER), "IWI", "ICI", " I ", 'I', material, 'W', "craftingToolWrench", 'C', "chestWood");
        
        recipes.addShapelessRecipe(GTMaterialGen.get(Items.GUNPOWDER, 3), "dustCoal", "dustSulfur", "dustSaltpeter", "dustSaltpeter");
        recipes.addShapelessRecipe(GTMaterialGen.get(Items.GUNPOWDER, 2), "dustCharcoal", "dustSulfur", "dustSaltpeter", "dustSaltpeter");
	}

}
