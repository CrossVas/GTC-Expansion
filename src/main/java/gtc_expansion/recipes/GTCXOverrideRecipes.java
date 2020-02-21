package gtc_expansion.recipes;

import static gtclassic.common.recipe.GTRecipeMods.input;

import gtc_expansion.GTCExpansion;
import gtc_expansion.GTCXItems;
import gtclassic.api.helpers.GTValues;
import gtclassic.api.material.GTMaterialGen;
import gtclassic.api.recipe.GTRecipeCraftingHandler;
import gtclassic.common.GTConfig;
import gtclassic.common.GTItems;
import ic2.api.classic.recipe.ClassicRecipes;
import ic2.api.recipe.IRecipeInput;
import ic2.core.IC2;
import ic2.core.item.recipe.entry.RecipeInputCombined;
import ic2.core.item.recipe.entry.RecipeInputOreDict;
import ic2.core.platform.registry.Ic2Items;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistry;

public class GTCXOverrideRecipes {

	static GTRecipeCraftingHandler recipe;
	
	public static void initGTCXOverride() {
		if (Loader.isModLoaded(GTValues.MOD_ID_IC2_EXTRAS) && GTConfig.modcompat.compatIc2Extras) {
			GTCExpansion.logger.info("Messing with IC2_Extras!");
            GTRecipeCraftingHandler.removeRecipe(GTValues.MOD_ID_IC2_EXTRAS, "shapeless_item.itemdustbronze_-1753288283");
            ClassicRecipes.macerator.removeRecipe(input("oreBauxite", 1));
            ClassicRecipes.macerator.removeRecipe(input("oreIridium", 1));
            String circuit = "circuitBasic";
            String machineBlock = "machineBlockBasic";
            int recipeId = IC2.config.getFlag("SteelRecipes") ? 42294514 : -997650306;
            GTRecipeCraftingHandler.overrideGTRecipe(GTValues.MOD_ID_IC2_EXTRAS, "shaped_tile.orewashingplant_" + recipeId, GTMaterialGen.getModItem(GTValues.MOD_ID_IC2_EXTRAS, "orewashingplant"), "PPP", "BMB", "cCc", 'P', RecipeHelper.materialRefinedIron, 'B', Items.BUCKET, 'M', machineBlock, 'c', Ic2Items.carbonMesh, 'C', circuit);
            GTRecipeCraftingHandler.overrideGTRecipe(GTValues.MOD_ID_IC2_EXTRAS, "shaped_tile.roller_-2064391190", GTMaterialGen.getModItem(GTValues.MOD_ID_IC2_EXTRAS, "roller"), "CPC", "PMP", "cPc", 'C', circuit, 'P', Blocks.PISTON, 'M', machineBlock, 'c', GTMaterialGen.getModItem(GTValues.MOD_ID_IC2_EXTRAS, "coil"));
            IRecipeInput casing = new RecipeInputCombined(1, new RecipeInputOreDict("casingSteel"), new RecipeInputOreDict("casingRefinedIron"), new RecipeInputOreDict("casingBronze"));
            GTRecipeCraftingHandler.overrideGTRecipe(GTValues.MOD_ID_IC2_EXTRAS, "shaped_tile.extruder_704871140", GTMaterialGen.getModItem(GTValues.MOD_ID_IC2_EXTRAS, "extruder"), "SCS", "cMc", "SCS", 'C', circuit, 'S', casing, 'M', machineBlock, 'c', GTMaterialGen.getModItem(GTValues.MOD_ID_IC2_EXTRAS, "coil"));
		}
		if (Loader.isModLoaded(GTValues.MOD_ID_FORESTRY)) {
			GTCExpansion.logger.info("Messing with Forestry!");
			String[] forestryPlanksType = { "_larch", "_teak", "_acacia", "_lime", "_chestnut", "_wenge", "_baobab", "_sequoia", "_kapok", "_ebony", "_mahogany", "_balsa", "_willow", "_walnut", "_greenheart", "_cherry", "_mahoe", "_poplar", "_palm", "_papaya", "_pine", "_plum", "_maple", "_citrus", "_giganteum", "_ipe", "_padauk", "_cocobolo", "_zebrawood", "_oak", "_spruce", "_birch", "_jungle", "_acacia", "_dark_oak" };
    		for (int i = 0; i < forestryPlanksType.length; i++) {
    			((ForgeRegistry)ForgeRegistries.RECIPES).remove(new ResourceLocation("forestry", "planks" + forestryPlanksType[i]));
    			((ForgeRegistry)ForgeRegistries.RECIPES).remove(new ResourceLocation("forestry", "fireproof_" + "planks" + forestryPlanksType[i]));
    		}
    		((ForgeRegistry)ForgeRegistries.RECIPES).remove(new ResourceLocation("forestry", "gear_bronze"));
    		((ForgeRegistry)ForgeRegistries.RECIPES).remove(new ResourceLocation("forestry", "gear_copper"));
    		((ForgeRegistry)ForgeRegistries.RECIPES).remove(new ResourceLocation("forestry", "gear_tin"));
		}
		if (Loader.isModLoaded(GTValues.MOD_ID_TFOREST) && GTConfig.modcompat.compatTwilightForest) {
			GTCExpansion.logger.info("Messing with The Twilight Forest!");
			String[] twilightPlanksType = { "wood/twilight_oak_", "wood/canopy_", "wood/mangrove_", "wood/darkwood_", "wood/time_", "wood/trans_", "wood/mine_", "wood/sort_" }; 
    		for (int i = 0; i < twilightPlanksType.length; i++) {
    			((ForgeRegistry)ForgeRegistries.RECIPES).remove(new ResourceLocation("twilightforest", twilightPlanksType[i] + "planks"));
    		}
		}
		if (Loader.isModLoaded(GTValues.MOD_ID_THERMAL) && GTConfig.modcompat.compatThermal) {
			GTCExpansion.logger.info("Messing with Thermal Mods!");
            recipe.overrideGTRecipe("thermalexpansion", "frame", GTMaterialGen.getModItem("thermalexpansion", "frame"), "SGS", "GTG", "SGS", 'S', "ingotSteel", 'G', "blockGlass", 'T', "gearTin");
            for (int i = 61; i <= 81; ++i) {
            	String TFgear = "material_";
            	((ForgeRegistry)ForgeRegistries.RECIPES).remove(new ResourceLocation("thermalfoundation", TFgear + i));
            }
		}
		if (Loader.isModLoaded("gravisuit")) {
			GTCExpansion.logger.info("Tweaking GraviSuit");
            GTRecipeCraftingHandler.overrideGTRecipe("gravisuit", "shaped_item.advanceddiamondchainsaw_-416372460", GTMaterialGen.getModItem("gravisuit", "advancedchainsaw"), " SS", "SCS", "BS ", 'S', RecipeHelper.tungstenSteel, 'C', GTCXItems.diamondChainsaw, 'B', GTItems.lithiumBattery);
            GTRecipeCraftingHandler.overrideGTRecipe("gravisuit", "shaped_item.advanceddrill_1408250051", GTMaterialGen.getModItem("gravisuit", "advanceddrill"), " S ", "SDS", "SBS", 'S', RecipeHelper.tungstenSteel, 'D', Ic2Items.diamondDrill, 'B', GTItems.lithiumBattery);
		}
		if (Loader.isModLoaded("railcraft")) {
			GTCExpansion.logger.info("Wait a minute... RailCraft?! No way!!");
		}
		GTCExpansion.logger.info("Vanilla... Bruh...");
    		String[] vanillaPlanksType = { "oak_", "spruce_", "birch_", "jungle_", "acacia_", "dark_oak_" };
		for (int i = 0; i < vanillaPlanksType.length; i++) {
			((ForgeRegistry)ForgeRegistries.RECIPES).remove(new ResourceLocation("minecraft", vanillaPlanksType[i] + "planks"));	
		}
	}
	
}
