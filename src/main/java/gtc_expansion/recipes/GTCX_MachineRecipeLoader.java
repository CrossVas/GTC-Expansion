package gtc_expansion.recipes;

import static gtclassic.common.recipe.GTRecipeMods.input;

import gtc_expansion.GTCExpansion;
import gtc_expansion.GTCXBlocks;
import gtc_expansion.GTCXConfiguration;
import gtc_expansion.GTCXItems;
import gtc_expansion.material.GTCXMaterial;
import gtc_expansion.material.GTCXMaterialGen;
import gtc_expansion.tile.GTCXTileAlloySmelter;
import gtc_expansion.tile.GTCXTileAssemblingMachine;
import gtc_expansion.tile.GTCXTileMicrowave;
import gtclassic.api.helpers.GTHelperStack;
import gtclassic.api.helpers.GTValues;
import gtclassic.api.material.GTMaterial;
import gtclassic.api.material.GTMaterialGen;
import gtclassic.api.recipe.GTRecipeCraftingHandler;
import gtclassic.api.recipe.GTRecipeMachineHandler;
import gtclassic.api.tile.GTTileBaseMachine;
import gtclassic.common.GTConfig;
import gtclassic.common.GTItems;
import gtclassic.common.recipe.GTRecipe;
import gtclassic.common.tile.GTTileCentrifuge;
import ic2.api.classic.recipe.ClassicRecipes;
import ic2.api.recipe.IRecipeInput;
import ic2.core.block.machine.low.TileEntityCompressor;
import ic2.core.block.machine.low.TileEntityExtractor;
import ic2.core.block.machine.low.TileEntityMacerator;
import ic2.core.item.recipe.entry.RecipeInputCombined;
import ic2.core.item.recipe.entry.RecipeInputOreDict;
import ic2.core.platform.registry.Ic2Items;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class GTCX_MachineRecipeLoader {
	
	static GTRecipeCraftingHandler recipe;
	
	public static void init() {
		
        GTHelperStack.removeSmelting(Ic2Items.rubber);
        GameRegistry.addSmelting(GTCXBlocks.oreSheldonite, GTMaterialGen.getIngot(GTMaterial.Platinum, 1), 1.0F);
        GameRegistry.addSmelting(GTCXBlocks.oreCassiterite, GTMaterialGen.getIc2(Ic2Items.tinIngot, 2), 0.5F);
        GameRegistry.addSmelting(GTCXBlocks.oreTetrahedrite, Ic2Items.copperIngot, 0.5F);
        GameRegistry.addSmelting(GTMaterialGen.getDust(GTCXMaterial.Tetrahedrite, 1), GTCXMaterialGen.getNugget(GTCXMaterial.Copper, 6), 0.5F);
        GameRegistry.addSmelting(Ic2Items.stoneMacerator, GTMaterialGen.getIc2(Ic2Items.bronzeIngot, 12), 1.0F);
        GameRegistry.addSmelting(GTCXBlocks.stoneExtractor, GTMaterialGen.getIc2(Ic2Items.bronzeIngot, 5), 1.0F);
        GameRegistry.addSmelting(GTCXBlocks.stoneCompressor, GTMaterialGen.getIc2(Ic2Items.bronzeIngot, 8), 1.0F);
        GameRegistry.addSmelting(GTMaterialGen.getDust(GTCXMaterial.Rubber, 1), GTMaterialGen.getIc2(Ic2Items.rubber, 1), 0.5F);
        GameRegistry.addSmelting(GTCXMaterialGen.getCrushedOre(GTCXMaterial.Cassiterite, 1), Ic2Items.tinIngot, 0.5F);
        GameRegistry.addSmelting(GTCXMaterialGen.getPurifiedCrushedOre(GTCXMaterial.Cassiterite, 1), Ic2Items.tinIngot, 0.5F);
        ClassicRecipes.furnace.addRecipe(GTTileBaseMachine.input(Ic2Items.stoneMacerator), GTMaterialGen.getIc2(Ic2Items.bronzeIngot, 12), "stoneMacerator");
        ClassicRecipes.furnace.addRecipe(GTTileBaseMachine.input(GTMaterialGen.get(GTCXBlocks.stoneExtractor)), GTMaterialGen.getIc2(Ic2Items.bronzeIngot, 5), "stoneExtractor");
        ClassicRecipes.furnace.addRecipe(GTTileBaseMachine.input(GTMaterialGen.get(GTCXBlocks.stoneCompressor)), GTMaterialGen.getIc2(Ic2Items.bronzeIngot, 8), "stoneCompressor");
        ClassicRecipes.furnace.addRecipe(GTTileBaseMachine.input(GTMaterialGen.getDust(GTCXMaterial.Rubber, 1)), Ic2Items.rubber, "dustRubber");
        
        if (GTCXConfiguration.general.removeVanillaCharcoalRecipe) {
            GTHelperStack.removeSmelting(new ItemStack(Items.COAL, 1, 1));
        }
        
        GTRecipe.maceratorUtil("oreSodalite", 1, GTMaterialGen.getDust(GTMaterial.Sodalite, 12));

        if ((!Loader.isModLoaded(GTValues.MOD_ID_IC2_EXTRAS) || !GTConfig.modcompat.compatIc2Extras)) {
            ClassicRecipes.compressor.removeRecipe(GTTileBaseMachine.input("ingotCopper", 8));
            TileEntityCompressor.addRecipe("plateCopper", 8, Ic2Items.denseCopperPlate);
            GTRecipe.maceratorUtil("orePyrite", 1, GTMaterialGen.getDust(GTMaterial.Pyrite, 5));
            GTRecipe.maceratorUtil("oreCinnabar", 1, GTMaterialGen.getDust(GTCXMaterial.Cinnabar, 3));
            GTRecipe.maceratorUtil("oreSphalerite", 1, GTMaterialGen.getDust(GTCXMaterial.Sphalerite, 4));
            GTRecipe.maceratorUtil("oreTungstate", 1, GTMaterialGen.getDust(GTMaterial.Tungsten, 2));
        }
        if (GTConfig.modcompat.compatIc2Extras && Loader.isModLoaded(GTValues.MOD_ID_IC2_EXTRAS)) { 
            GTCXRecipe.addCrushedOreRecipes(GTCXMaterial.Tetrahedrite, GTCXMaterialGen.getTinyDust(GTCXMaterial.Antimony, 1), GTCXMaterialGen.getTinyDust(GTCXMaterial.Zinc, 1));
            GTCXRecipe.addCrushedOreRecipes(GTCXMaterial.Cassiterite, GTMaterialGen.getModItem(GTValues.MOD_ID_IC2_EXTRAS, "tintinydust"), GTMaterialGen.getModItem(GTValues.MOD_ID_IC2_EXTRAS, "tintinydust"));
            GTCXRecipe.addCrushedOreRecipes(GTCXMaterial.Galena, GTCXMaterialGen.getTinyDust(GTMaterial.Sulfur, 2), GTMaterialGen.getModItem(GTValues.MOD_ID_IC2_EXTRAS, "silvertinydust"));
            GTCXRecipe.addCrushedOreRecipes(GTCXMaterial.Cinnabar, GTCXMaterialGen.getTinyDust(GTCXMaterial.Redstone, 1), GTCXMaterialGen.getTinyDust(GTMaterial.Sulfur, 1));
            GTCXRecipe.addCrushedOreRecipes(GTCXMaterial.Sphalerite, GTCXMaterialGen.getTinyDust(GTCXMaterial.Zinc, 1), GTCXMaterialGen.getTinyDust(GTCXMaterial.GarnetYellow, 1));
            GTCXRecipe.addCrushedOreRecipes(GTMaterial.Pyrite, GTCXMaterialGen.getTinyDust(GTMaterial.Sulfur, 1), GTCXMaterialGen.getTinyDust(GTMaterial.Phosphorus, 1));
            GTCXRecipe.addCrushedOreRecipes(GTMaterial.Bauxite, GTCXMaterialGen.getTinyDust(GTCXMaterial.Grossular, 1), GTCXMaterialGen.getTinyDust(GTMaterial.Titanium, 1));
            GTCXRecipe.addCrushedOreRecipes(GTMaterial.Platinum, GTCXMaterialGen.getTinyDust(GTMaterial.Sulfur, 2), GTCXMaterialGen.getTinyDust(GTMaterial.Nickel, 1));
            GTCXRecipe.addCrushedOreRecipes(GTMaterial.Tungsten, GTCXMaterialGen.getTinyDust(GTCXMaterial.Manganese, 1), GTMaterialGen.getModItem(GTValues.MOD_ID_IC2_EXTRAS, "silvertinydust"));
            GTCXRecipe.addCrushedOreRecipes(GTMaterial.Iridium, GTCXMaterialGen.getTinyDust(GTMaterial.Platinum, 1), GTCXMaterialGen.getTinyDust(GTCXMaterial.Osmium, 1));
            GTCXRecipe.addCrushedOreRecipes(GTCXMaterial.Chromite, GTMaterialGen.getModItem(GTValues.MOD_ID_IC2_EXTRAS, "irontinydust"), GTCXMaterialGen.getTinyDust(GTMaterial.Chrome, 1));
            GTRecipe.maceratorUtil("oreGalena", 1, GTCXMaterialGen.getCrushedOre(GTCXMaterial.Galena, 2));
            GTRecipe.maceratorUtil("oreTetrahedrite", 1, GTCXMaterialGen.getCrushedOre(GTCXMaterial.Tetrahedrite, 2));
            GTRecipe.maceratorUtil("oreCassiterite", 1, GTCXMaterialGen.getCrushedOre(GTCXMaterial.Cassiterite, 4));
            GTRecipe.maceratorUtil("orePyrite", 1, GTCXMaterialGen.getCrushedOre(GTMaterial.Pyrite, 5));
            GTRecipe.maceratorUtil("oreCinnabar", 1, GTCXMaterialGen.getCrushedOre(GTCXMaterial.Cinnabar, 3));
            GTRecipe.maceratorUtil("oreSphalerite", 1, GTCXMaterialGen.getCrushedOre(GTCXMaterial.Sphalerite, 4));
            GTRecipe.maceratorUtil("orePlatinum", 1, GTCXMaterialGen.getCrushedOre(GTMaterial.Platinum, 2));
            GTRecipe.maceratorUtil("oreTungstate", 1, GTCXMaterialGen.getCrushedOre(GTMaterial.Tungsten, 2));
            GTRecipe.maceratorUtil("oreChromite", 1, GTCXMaterialGen.getCrushedOre(GTCXMaterial.Chromite, 2));
            TileEntityMacerator.addRecipe("oreBauxite", 1, GTCXMaterialGen.getCrushedOre(GTMaterial.Bauxite, 4));
            TileEntityMacerator.addRecipe("oreIridium", 1, GTCXMaterialGen.getCrushedOre(GTMaterial.Iridium, 2));
            GameRegistry.addSmelting(GTCXMaterialGen.getCrushedOre(GTCXMaterial.Tetrahedrite, 1), GTCXMaterialGen.getNugget(GTCXMaterial.Copper, 6), 0.5F);
            GameRegistry.addSmelting(GTCXMaterialGen.getPurifiedCrushedOre(GTCXMaterial.Tetrahedrite, 1), GTCXMaterialGen.getNugget(GTCXMaterial.Copper, 6), 0.5F);
            GameRegistry.addSmelting(GTCXMaterialGen.getPurifiedCrushedOre(GTMaterial.Platinum, 1), GTMaterialGen.getIngot(GTMaterial.Platinum, 1), 1.0F);
            GameRegistry.addSmelting(GTCXMaterialGen.getCrushedOre(GTMaterial.Platinum, 1), GTMaterialGen.getIngot(GTMaterial.Platinum, 1), 1.0F);
        }
        
        ClassicRecipes.canningMachine.registerCannerItem(GTMaterialGen.get(GTItems.testTube), GTTileBaseMachine.input(GTMaterialGen.get(GTCXItems.oilberry)), GTMaterialGen.getTube(GTMaterial.Oil, 1));
        ClassicRecipes.canningMachine.registerCannerItem(GTMaterialGen.get(GTCXItems.batteryHull), GTTileBaseMachine.input(GTMaterialGen.getTube(GTCXMaterial.SulfuricAcid, 2)), GTCXItems.acidBattery.getFull());
        ClassicRecipes.canningMachine.registerCannerItem(GTMaterialGen.get(GTCXItems.batteryHull), GTTileBaseMachine.input(GTMaterialGen.getTube(GTMaterial.Mercury, 2)), GTCXItems.mercuryBattery.getFull());
        ClassicRecipes.canningMachine.registerCannerItem(GTMaterialGen.get(GTCXItems.batteryHull), GTTileBaseMachine.input("dustLithium", 2), GTMaterialGen.get(GTItems.lithiumBattery));
        ClassicRecipes.canningMachine.registerCannerItem(GTMaterialGen.get(GTCXItems.batteryHull), GTTileBaseMachine.input(GTMaterialGen.getTube(GTMaterial.Sodium, 2)), GTMaterialGen.get(GTCXItems.sodiumBattery));
        ClassicRecipes.canningMachine.registerCannerItem(GTMaterialGen.get(GTCXItems.batteryHull), GTTileBaseMachine.input(GTMaterialGen.get(Items.REDSTONE, 2)), Ic2Items.battery);
        ClassicRecipes.canningMachine.registerCannerItem(GTMaterialGen.get(GTCXItems.largeBatteryHull), GTTileBaseMachine.input(GTMaterialGen.getTube(GTCXMaterial.SulfuricAcid, 6)), GTCXItems.largeAcidBattery.getFull());
        ClassicRecipes.canningMachine.registerCannerItem(GTMaterialGen.get(GTCXItems.largeBatteryHull), GTTileBaseMachine.input(GTMaterialGen.getTube(GTMaterial.Mercury, 6)), GTCXItems.largeMercuryBattery.getFull());
        ClassicRecipes.canningMachine.registerCannerItem(GTMaterialGen.get(GTCXItems.largeBatteryHull), GTTileBaseMachine.input("dustLithium", 6), GTMaterialGen.get(GTCXItems.largeLithiumBattery));
        ClassicRecipes.canningMachine.registerCannerItem(GTMaterialGen.get(GTCXItems.largeBatteryHull), GTTileBaseMachine.input(GTMaterialGen.getTube(GTMaterial.Sodium, 6)), GTMaterialGen.get(GTCXItems.largeSodiumBattery));
        
        ClassicRecipes.compressor.removeRecipe(GTTileBaseMachine.input("dustRuby", 1));
        ClassicRecipes.compressor.removeRecipe(GTTileBaseMachine.input("dustSapphire", 1));
        ClassicRecipes.compressor.removeRecipe(GTTileBaseMachine.input("dustGreenSapphire", 1));
        ClassicRecipes.compressor.removeRecipe(GTTileBaseMachine.input("dustOlivine", 1));
        ClassicRecipes.compressor.removeRecipe(GTTileBaseMachine.input("dustRedGarnet", 1));
        ClassicRecipes.compressor.removeRecipe(GTTileBaseMachine.input("dustYellowGarnet", 1));
        ClassicRecipes.compressor.removeRecipe(GTTileBaseMachine.input("dustCarbon", 8));
        ClassicRecipes.compressor.removeRecipe(GTTileBaseMachine.input(Ic2Items.coalChunk));
        ClassicRecipes.compressor.removeRecipe(GTTileBaseMachine.input("dustThorium", 1));
        ClassicRecipes.compressor.removeRecipe(GTTileBaseMachine.input("dustEmerald", 1));   
        ClassicRecipes.extractor.removeRecipe(GTTileBaseMachine.input(Ic2Items.stickyResin));
        ClassicRecipes.extractor.removeRecipe(GTTileBaseMachine.input(Ic2Items.rubberSapling));
        ClassicRecipes.extractor.removeRecipe(GTTileBaseMachine.input(Ic2Items.rubberWood));
        ClassicRecipes.macerator.removeRecipe(GTTileBaseMachine.input("oreRedstone", 1));
        ClassicRecipes.macerator.addRecipe(new RecipeInputOreDict("gemDiamond", 1), GTMaterialGen.getDust(GTCXMaterial.Diamond, 1), "gemDiamond");
        ClassicRecipes.fluidGenerator.getBurnMap().remove(GTMaterialGen.getFluid(GTMaterial.Methane));
        ClassicRecipes.fluidGenerator.getBurnMap().remove(GTMaterialGen.getFluid(GTMaterial.Hydrogen));
        
        TileEntityExtractor.addRecipe(GTCXItems.acidBattery.getEmpty(), GTMaterialGen.get(GTCXItems.batteryHull));
        TileEntityExtractor.addRecipe(GTCXItems.mercuryBattery.getEmpty(), GTMaterialGen.get(GTCXItems.batteryHull));
        TileEntityExtractor.addRecipe(GTCXItems.largeAcidBattery.getEmpty(), GTMaterialGen.get(GTCXItems.largeBatteryHull));
        TileEntityExtractor.addRecipe(GTCXItems.largeMercuryBattery.getEmpty(), GTMaterialGen.get(GTCXItems.largeBatteryHull));
        TileEntityExtractor.addRecipe(Ic2Items.stickyResin, GTMaterialGen.getDust(GTCXMaterial.Rubber, 3));
        TileEntityExtractor.addRecipe(Ic2Items.rubberSapling, GTMaterialGen.getDust(GTCXMaterial.Rubber, 1));
        TileEntityExtractor.addRecipe(Ic2Items.rubberWood, GTMaterialGen.getDust(GTCXMaterial.Rubber, 1));
        TileEntityExtractor.addRecipe("oreOlivine", 1, GTMaterialGen.getGem(GTCXMaterial.Olivine, 3));
        TileEntityMacerator.addRecipe("oreRedstone", 1, GTMaterialGen.get(Items.REDSTONE, 8));
        
        GTTileCentrifuge.addRecipe(GTMaterialGen.get(Items.GOLDEN_APPLE, 1), 0, GTCXRecipe.totalCentrifugeEu(50000), GTMaterialGen.get(Items.GOLD_INGOT, 6), GTMaterialGen.getTube(GTMaterial.Methane, 1));
        GTTileCentrifuge.addRecipe(new ItemStack(Items.GOLDEN_APPLE, 1, 1), 0, GTCXRecipe.totalCentrifugeEu(50000), GTMaterialGen.get(Items.GOLD_INGOT, 64), GTMaterialGen.getTube(GTMaterial.Methane, 2));
        GTTileCentrifuge.addRecipe(GTMaterialGen.get(Items.GOLDEN_CARROT, 1), 0, GTCXRecipe.totalCentrifugeEu(50000), GTMaterialGen.get(Items.GOLD_NUGGET, 6), GTMaterialGen.getTube(GTMaterial.Methane, 1));
        GTTileCentrifuge.addRecipe(GTMaterialGen.get(Items.SPECKLED_MELON, 8), 0, GTCXRecipe.totalCentrifugeEu(50000), GTMaterialGen.get(Items.GOLD_NUGGET, 6), GTMaterialGen.getTube(GTMaterial.Methane, 1));
        GTTileCentrifuge.addRecipe("dustEndstone", 64, 2, GTCXRecipe.totalCentrifugeEu(100000), GTMaterialGen.get(Blocks.SAND, 48), GTMaterialGen.getTube(GTMaterial.Helium3, 4), GTMaterialGen.getTube(GTMaterial.Helium, 4), GTMaterialGen.getDust(GTMaterial.Tungsten, 1));
        GTTileCentrifuge.addRecipe("dustRedGarnet", 16, 0, GTCXRecipe.totalCentrifugeEu(15000), GTMaterialGen.getDust(GTCXMaterial.Pyrope, 3), GTMaterialGen.getDust(GTCXMaterial.Almandine, 5), GTMaterialGen.getDust(GTCXMaterial.Spessartine, 8));
        GTTileCentrifuge.addRecipe("dustYellowGarnet", 16, 0, GTCXRecipe.totalCentrifugeEu(17500), GTMaterialGen.getDust(GTCXMaterial.Uvarovite, 3), GTMaterialGen.getDust(GTCXMaterial.Andradite, 5), GTMaterialGen.getDust(GTCXMaterial.Grossular, 8));
        GTTileCentrifuge.addRecipe("dustDarkAshes", 2, 0, GTCXRecipe.totalCentrifugeEu(1250), GTMaterialGen.getDust(GTCXMaterial.Ashes, 1), GTMaterialGen.getDust(GTCXMaterial.Slag, 1));
        IRecipeInput ashes = new RecipeInputCombined(2, new RecipeInputOreDict("dustAshes", 2), new RecipeInputOreDict("dustAsh", 2));
        GTTileCentrifuge.addRecipe(new IRecipeInput[]{ashes}, GTCXRecipe.totalCentrifugeEu(1250), GTMaterialGen.getDust(GTMaterial.Carbon, 1));
        GTTileCentrifuge.addRecipe("dustSlag", 16, 0, GTCXRecipe.totalCentrifugeEu(4000), GTMaterialGen.get(Items.IRON_NUGGET, 3), GTMaterialGen.get(Items.GOLD_NUGGET, 1), GTMaterialGen.getDust(GTMaterial.Sulfur, 4), GTMaterialGen.getDust(GTMaterial.Phosphorus, 4));
        GTTileCentrifuge.addRecipe("dustRedRock", 16, 0, GTCXRecipe.totalCentrifugeEu(2000), GTMaterialGen.getDust(GTMaterial.Calcite, 8), GTMaterialGen.getDust(GTMaterial.Flint, 4), GTMaterialGen.getIc2(Ic2Items.clayDust, 4));
        GTTileCentrifuge.addRecipe("dustMarble", 8, 0, GTCXRecipe.totalCentrifugeEu(5275), GTMaterialGen.getDust(GTCXMaterial.Magnesium, 1), GTMaterialGen.getDust(GTMaterial.Calcite, 7));
        GTTileCentrifuge.addRecipe("dustBasalt", 16, 0, GTCXRecipe.totalCentrifugeEu(24000), GTMaterialGen.getDust(GTCXMaterial.Olivine, 1), GTMaterialGen.getDust(GTMaterial.Calcite, 3), GTMaterialGen.getDust(GTMaterial.Flint, 8), GTMaterialGen.getDust(GTCXMaterial.DarkAshes, 4));
        GTTileCentrifuge.addRecipe("dustBrass", 4,0, GTCXRecipe.totalCentrifugeEu(7500), GTMaterialGen.getDust(GTCXMaterial.Zinc, 1), GTMaterialGen.getIc2(Ic2Items.copperDust, 3));
        GTTileCentrifuge.addRecipe("dustInvar", 3,0, GTCXRecipe.totalCentrifugeEu(7500), GTMaterialGen.getDust(GTMaterial.Nickel, 1), GTMaterialGen.getIc2(Ic2Items.ironDust, 2));
        GTTileCentrifuge.addRecipe("dustConstantan", 3,0, GTCXRecipe.totalCentrifugeEu(7500), GTMaterialGen.getDust(GTMaterial.Nickel, 1), GTMaterialGen.getIc2(Ic2Items.copperDust, 2));
        GTTileCentrifuge.addRecipe("dustTetrahedrite", 8, 0, GTCXRecipe.totalCentrifugeEu(18240), GTMaterialGen.getIc2(Ic2Items.copperDust, 3), GTMaterialGen.getDust(GTCXMaterial.Antimony, 1), GTMaterialGen.getDust(GTMaterial.Sulfur, 3));
        GTTileCentrifuge.addRecipe("dustBatteryAlloy", 5, 0, GTCXRecipe.totalCentrifugeEu(37800), GTMaterialGen.getDust(GTCXMaterial.Antimony, 1), GTMaterialGen.getDust(GTCXMaterial.Lead, 4));
        GTTileCentrifuge.addRecipe("dustCoal", 9, 0, GTCXRecipe.totalCentrifugeEu(960), Ic2Items.coalDust, GTCXMaterialGen.getSmallDust(GTMaterial.Thorium, 4));
        
        GTCXRecipeLists.EXTRACTOR_RECIPE_LIST.startMassChange();
        GTRecipeMachineHandler.removeRecipe(GTCXRecipeLists.EXTRACTOR_RECIPE_LIST, "item.itemRubber");
        GTRecipeMachineHandler.removeRecipe(GTCXRecipeLists.EXTRACTOR_RECIPE_LIST, "item.itemRubber_1");
        GTRecipeMachineHandler.removeRecipe(GTCXRecipeLists.EXTRACTOR_RECIPE_LIST, "item.itemRubber_2");
        GTRecipeMachineHandler.addRecipe(GTCXRecipeLists.EXTRACTOR_RECIPE_LIST, new IRecipeInput[] { GTTileBaseMachine.input(Ic2Items.stickyResin) }, null, GTMaterialGen.getDust(GTCXMaterial.Rubber, 3));
        GTRecipeMachineHandler.addRecipe(GTCXRecipeLists.EXTRACTOR_RECIPE_LIST, new IRecipeInput[] { GTTileBaseMachine.input(Ic2Items.rubberSapling) }, null, GTMaterialGen.getDust(GTCXMaterial.Rubber, 1));
        GTRecipeMachineHandler.addRecipe(GTCXRecipeLists.EXTRACTOR_RECIPE_LIST, new IRecipeInput[] { GTTileBaseMachine.input(Ic2Items.rubberWood) }, null, GTMaterialGen.getDust(GTCXMaterial.Rubber, 1));
        GTCXRecipeLists.EXTRACTOR_RECIPE_LIST.finishMassChange();
        
        GTCXRecipeLists.COMPRESSOR_RECIPE_LIST.startMassChange();
        GTRecipeMachineHandler.removeRecipe(GTCXRecipeLists.COMPRESSOR_RECIPE_LIST, "item.gtclassic.gemRuby");
        GTRecipeMachineHandler.removeRecipe(GTCXRecipeLists.COMPRESSOR_RECIPE_LIST, "item.gtclassic.gemSapphire");
        GTRecipeMachineHandler.removeRecipe(GTCXRecipeLists.COMPRESSOR_RECIPE_LIST, "item.gtclassic.gemOlivine");
        GTRecipeMachineHandler.removeRecipe(GTCXRecipeLists.COMPRESSOR_RECIPE_LIST, "item.gtclassic.gemRedGarnet");
        GTRecipeMachineHandler.removeRecipe(GTCXRecipeLists.COMPRESSOR_RECIPE_LIST, "item.gtclassic.gemYellowGarnet");
        GTRecipeMachineHandler.removeRecipe(GTCXRecipeLists.COMPRESSOR_RECIPE_LIST, "item.itemPartIndustrialDiamond");
        GTRecipeMachineHandler.removeRecipe(GTCXRecipeLists.COMPRESSOR_RECIPE_LIST, "item.itemPartCarbonFibre");
        GTRecipeMachineHandler.removeRecipe(GTCXRecipeLists.COMPRESSOR_RECIPE_LIST, "item.thorium232Ingot");
        GTRecipeMachineHandler.removeRecipe(GTCXRecipeLists.COMPRESSOR_RECIPE_LIST, "item.thorium230Ingot");
        GTRecipeMachineHandler.removeRecipe(GTCXRecipeLists.COMPRESSOR_RECIPE_LIST, "item.gtclassic.ingotThorium");
        GTRecipeMachineHandler.removeRecipe(GTCXRecipeLists.COMPRESSOR_RECIPE_LIST, "item.emerald");
        GTRecipeMachineHandler.removeRecipe(GTCXRecipeLists.COMPRESSOR_RECIPE_LIST, "item.itemPartDCP");
        GTCXRecipeLists.COMPRESSOR_RECIPE_LIST.finishMassChange();
        
        GTTileCentrifuge.RECIPE_LIST.startMassChange();
        GTCXRecipe.removeCentrifugeRecipe("item.gtclassic.test_tube");
        GTCXRecipe.removeCentrifugeRecipe("item.gtclassic.test_tube_1");
        GTCXRecipe.removeCentrifugeRecipe("item.itemCellEmpty");
        GTCXRecipe.removeCentrifugeRecipe("item.itemCellEmpty_1");
        GTCXRecipe.removeCentrifugeRecipe("item.gtclassic.dustCarbon");
        GTCXRecipe.removeCentrifugeRecipe("item.gtclassic.dustAluminium");
        GTCXRecipe.removeCentrifugeRecipe("item.gtclassic.dustAluminium_1");
        GTCXRecipe.removeCentrifugeRecipe("item.itemDustIron");
        GTCXRecipe.removeCentrifugeRecipe("item.itemDustIron_1");
        GTCXRecipe.removeCentrifugeRecipe("item.gtclassic.test_tube_8");
        GTCXRecipe.removeCentrifugeRecipe("item.gtclassic.test_tube_9");
        GTCXRecipe.removeCentrifugeRecipe("item.gtclassic.test_tube_10");
        GTCXRecipe.removeCentrifugeRecipe("item.gtclassic.test_tube_11");
        GTCXRecipe.removeCentrifugeRecipe("item.gtclassic.test_tube_12");
        GTCXRecipe.removeCentrifugeRecipe("item.gtclassic.test_tube_13");
        GTCXRecipe.removeCentrifugeRecipe("item.itemDustCoal");
        GTCXRecipe.removeCentrifugeRecipe("item.gtclassic.dustSilicon");
        GTCXRecipe.removeCentrifugeRecipe("item.gtclassic.dustSilicon_1");
        GTCXRecipe.removeCentrifugeRecipe("item.gtclassic.dustSilicon_2");
        GTCXRecipe.removeCentrifugeRecipe("item.gtclassic.dustSilicon_3");
        GTCXRecipe.removeCentrifugeRecipe("item.gtclassic.dustLithium");
        GTTileCentrifuge.RECIPE_LIST.finishMassChange();
        
        // Remove smelting from mods who dont respect my authority
        if (GTCXConfiguration.general.ingotsRequireBlastFurnace) {
            for (Item item : Item.REGISTRY) {
                NonNullList<ItemStack> items = NonNullList.create();
                item.getSubItems(CreativeTabs.SEARCH, items);
                for (ItemStack stack : items) {
                    if (!stack.isEmpty() && OreDictionary.getOreIDs(stack).length > 0) {
                        for(int i = 0; i < OreDictionary.getOreIDs(stack).length; ++i) {
                            if (OreDictionary.getOreName(OreDictionary.getOreIDs(stack)[i]).startsWith("dust") || OreDictionary.getOreName(OreDictionary.getOreIDs(stack)[i]).startsWith("crushed") || OreDictionary.getOreName(OreDictionary.getOreIDs(stack)[i]).startsWith("crushedPurified")) {
                                GTCXTileMicrowave.explodeList.add(stack);
                                break;
                            }
                        }
                    }
                    if (GTHelperStack.matchOreDict(stack,"ingotOsmium")
                            || GTHelperStack.matchOreDict(stack,"ingotSteel")
                            || GTHelperStack.matchOreDict(stack,"ingotStainlessSteel")
                            || GTHelperStack.matchOreDict(stack,"ingotThorium")
                            || GTHelperStack.matchOreDict(stack, "ingotIridium")
                            || GTHelperStack.matchOreDict(stack, "ingotTungsten")
                            || GTHelperStack.matchOreDict(stack, "ingotChrome")
                            || GTHelperStack.matchOreDict(stack, "ingotTitanium")
                            || GTHelperStack.matchOreDict(stack, "ingotAluminium")
                            || GTHelperStack.matchOreDict(stack, "ingotAluminum")
                            || GTHelperStack.matchOreDict(stack, "ingotSilicon")
                            || GTHelperStack.matchOreDict(stack, "itemSilicon")) {
                        GTHelperStack.removeSmelting(stack);
                    }
                }
            }
        }
        
		if (Loader.isModLoaded(GTValues.MOD_ID_THERMAL) && GTConfig.modcompat.compatThermal) {
			GTCExpansion.logger.info("Tweaking TE Recipes");
            GTCXTileAlloySmelter.addRecipe("dustCopper", 1, "blockGlassHardened", 2, GTMaterialGen.getModMetaItem(GTValues.MOD_ID_THERMAL, "glass", 0, 2));
            GTCXTileAlloySmelter.addRecipe("dustTin", 1, "blockGlassHardened", 2, GTMaterialGen.getModMetaItem(GTValues.MOD_ID_THERMAL, "glass", 1, 2));
            GTCXTileAlloySmelter.addRecipe("dustSilver", 1, "blockGlassHardened", 2, GTMaterialGen.getModMetaItem(GTValues.MOD_ID_THERMAL, "glass", 2, 2));
            GTCXTileAlloySmelter.addRecipe("dustLead", 1, "dustObsidian", 4, GTMaterialGen.getModMetaItem(GTValues.MOD_ID_THERMAL, "glass", 3, 2));
            GTCXTileAlloySmelter.addRecipe("dustAluminium", 1, "blockGlassHardened", 2, GTMaterialGen.getModMetaItem(GTValues.MOD_ID_THERMAL, "glass", 4, 2));
            GTCXTileAlloySmelter.addRecipe("dustNickel", 1, "blockGlassHardened", 2, GTMaterialGen.getModMetaItem(GTValues.MOD_ID_THERMAL, "glass", 5, 2));
            GTCXTileAlloySmelter.addRecipe("dustPlatinum", 1, "blockGlassHardened", 2, GTMaterialGen.getModMetaItem(GTValues.MOD_ID_THERMAL, "glass", 6, 2));
            GTCXTileAlloySmelter.addRecipe("dustIridium", 1, "blockGlassHardened", 2, GTMaterialGen.getModMetaItem(GTValues.MOD_ID_THERMAL, "glass", 7, 2));
            GTCXTileAlloySmelter.addRecipe("dustMithril", 1, "blockGlassHardened", 2, GTMaterialGen.getModMetaItem(GTValues.MOD_ID_THERMAL, "glass", 8, 2));
            GTCXTileAlloySmelter.addRecipe("dustSteel", 1, "blockGlassHardened", 2, GTMaterialGen.getModMetaItem(GTValues.MOD_ID_THERMAL, "glass_alloy", 0, 2));
            GTCXTileAlloySmelter.addRecipe("dustElectrum", 1, "blockGlassHardened", 2, GTMaterialGen.getModMetaItem(GTValues.MOD_ID_THERMAL, "glass_alloy", 1, 2));
            GTCXTileAlloySmelter.addRecipe("dustInvar", 1, "blockGlassHardened", 2, GTMaterialGen.getModMetaItem(GTValues.MOD_ID_THERMAL, "glass_alloy", 2, 2));
            GTCXTileAlloySmelter.addRecipe("dustBronze", 1, "blockGlassHardened", 2, GTMaterialGen.getModMetaItem(GTValues.MOD_ID_THERMAL, "glass_alloy", 3, 2));
            GTCXTileAlloySmelter.addRecipe("dustConstantan", 1, "blockGlassHardened", 2, GTMaterialGen.getModMetaItem(GTValues.MOD_ID_THERMAL, "glass_alloy", 4, 2));
            GTCXTileAlloySmelter.addRecipe("dustSignalum", 1, "blockGlassHardened", 2, GTMaterialGen.getModMetaItem(GTValues.MOD_ID_THERMAL, "glass_alloy", 5, 2));
            GTCXTileAlloySmelter.addRecipe("dustLumium", 1, "blockGlassHardened", 2, GTMaterialGen.getModMetaItem(GTValues.MOD_ID_THERMAL, "glass_alloy", 6, 2));
            GTCXTileAlloySmelter.addRecipe("dustEnderium", 1, "blockGlassHardened", 2, GTMaterialGen.getModMetaItem(GTValues.MOD_ID_THERMAL, "glass_alloy", 7, 2));
		}
		
        GTCExpansion.logger.info("Tweaking RC Recipes");
        if (Loader.isModLoaded("railcraft") && GTCXConfiguration.modcompat.compatRailcraft) {
            GTCXTileAssemblingMachine.addRecipe(new IRecipeInput[]{new RecipeInputCombined(6, input("rodIron", 6), input("rodBronze", 6)), new RecipeInputCombined(6, input("rodIron", 6), input("rodBronze", 6))}, GTCXTileAssemblingMachine.setUsageEuPerTick(2), GTCXTileAssemblingMachine.totalEu(400), GTMaterialGen.getModMetaItem("railcraft", "rail", 0, 8));
            GTCXTileAssemblingMachine.addRecipe("rodInvar", 6, "rodInvar", 6, GTCXTileAssemblingMachine.setUsageEuPerTick(2), 400, GTMaterialGen.getModMetaItem("railcraft", "rail", 0, 12));
            GTCXTileAssemblingMachine.addRecipe("rodSteel", 6, "rodSteel", 6, GTCXTileAssemblingMachine.setUsageEuPerTick(2), 400, GTMaterialGen.getModMetaItem("railcraft", "rail", 0, 16));
            GTCXTileAssemblingMachine.addRecipe(new IRecipeInput[]{new RecipeInputCombined(6, input("rodTitanium", 6), input("rodTungsten", 6)), new RecipeInputCombined(6, input("rodTitanium", 6), input("rodTungsten", 6))}, GTCXTileAssemblingMachine.setUsageEuPerTick(2), GTCXTileAssemblingMachine.totalEu(400), GTMaterialGen.getModMetaItem("railcraft", "rail", 0, 32));
            GTCXTileAssemblingMachine.addRecipe("rodTungstensteel", 6, "rodTungstensteel", 6, GTCXTileAssemblingMachine.setUsageEuPerTick(2), 400, GTMaterialGen.getModMetaItem("railcraft", "rail", 0, 48));
            GTCXTileAssemblingMachine.addRecipe("rodSteel", 12, "dustObsidian", 3, GTCXTileAssemblingMachine.setUsageEuPerTick(2), 400, GTMaterialGen.getModMetaItem("railcraft", "rail", 4, 8));
            GTCXTileAssemblingMachine.addRecipe("rodInvar", 12, "dustObsidian", 3, GTCXTileAssemblingMachine.setUsageEuPerTick(2), 400, GTMaterialGen.getModMetaItem("railcraft", "rail", 4, 4));
            GTCXTileAssemblingMachine.addRecipe("rodTungstensteel", 12, "dustObsidian", 3, GTCXTileAssemblingMachine.setUsageEuPerTick(2), 400, GTMaterialGen.getModMetaItem("railcraft", "rail", 4, 16));
            GTCXTileAssemblingMachine.addRecipe("rodGold", 12, "dustRedstone", 3, GTCXTileAssemblingMachine.setUsageEuPerTick(2), 400, GTMaterialGen.getModMetaItem("railcraft", "rail", 1, 8));
            GTCXTileAssemblingMachine.addRecipe("rodCopper", 6, "rodCopper", 6, GTCXTileAssemblingMachine.setUsageEuPerTick(2), 400, GTMaterialGen.getModMetaItem("railcraft", "rail", 5, 6));
            GTCXTileAssemblingMachine.addRecipe("rodSteel", 12, "rodCopper", 6, GTCXTileAssemblingMachine.setUsageEuPerTick(2), 400, GTMaterialGen.getModMetaItem("railcraft", "rail", 5, 12));
//            GTCXTileWiremill.addRecipe(new RecipeInputCombined(6, input("rodIron", 6), input("rodBronze", 6)), 400, GTMaterialGen.getModItem("railcraft", "rebar", 4));
//            GTCXTileWiremill.addRecipe(new RecipeInputCombined(6, input("rodRefinedIron", 6), input("rodInvar", 6)), 400, GTMaterialGen.getModItem("railcraft", "rebar", 6));
//            GTCXTileWiremill.addRecipe(new RecipeInputCombined(6, input("rodTungsten", 6), input("rodTitanium", 6)), 400, GTMaterialGen.getModItem("railcraft", "rebar", 16));
//            GTCXTileWiremill.addRecipe("rodSteel", 6, GTMaterialGen.getModItem("railcraft", "rebar", 8));
        }
	}
}
