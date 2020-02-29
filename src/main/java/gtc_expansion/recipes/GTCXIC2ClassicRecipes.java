package gtc_expansion.recipes;

import gtc_expansion.GTCExpansion;
import gtc_expansion.GTCXConfiguration;
import gtc_expansion.GTCXItems;
import gtc_expansion.material.GTCXMaterial;
import gtc_expansion.material.GTCXMaterialGen;
import gtc_expansion.util.GTCXHelperStack;
import gtclassic.GTMod;
import gtclassic.api.material.GTMaterial;
import gtclassic.api.material.GTMaterialGen;
import gtclassic.api.recipe.GTRecipeCraftingHandler;
import gtclassic.common.GTBlocks;
import gtclassic.common.GTConfig;
import gtclassic.common.GTItems;
import gtclassic.common.tile.GTTileUUMAssembler;
import ic2.api.classic.recipe.ClassicRecipes;
import ic2.api.classic.recipe.crafting.ICraftingRecipeList;
import ic2.api.recipe.IRecipeInput;
import ic2.core.IC2;
import ic2.core.item.recipe.entry.RecipeInputCombined;
import ic2.core.item.recipe.entry.RecipeInputItemStack;
import ic2.core.platform.registry.Ic2Items;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class GTCXIC2ClassicRecipes {
	
    static ICraftingRecipeList recipes = ClassicRecipes.advCrafting;
    
    public static void initIC2Recipes () {
        GTCExpansion.logger.info("Tweaking IC2 UU-Recipes");
    	if (GTConfig.general.gregtechUURecipes){
            if (!GTCXConfiguration.general.removeCraftingUURecipes){
                recipes.addRecipe(GTMaterialGen.getGem(GTCXMaterial.Olivine, 1), "UU ", "UUU", "UU ", 'U', Ic2Items.uuMatter, true);
                recipes.addRecipe(GTMaterialGen.getDust(GTCXMaterial.Zinc, 10), "   ", "U U", "U  ", 'U', Ic2Items.uuMatter, true);
                recipes.addRecipe(GTMaterialGen.getDust(GTMaterial.Nickel, 10), "U  ", "U U", "   ", 'U', Ic2Items.uuMatter, true);
                recipes.addRecipe(GTCXMaterialGen.getSmallDust(GTCXMaterial.Osmium, 1), "U U", "UUU", "U U", 'U', Ic2Items.uuMatter, true);
            }
            GTTileUUMAssembler.addUUMAssemblerValue(7, GTMaterialGen.getGem(GTCXMaterial.Olivine, 1));
            GTTileUUMAssembler.addUUMAssemblerValue(3, GTMaterialGen.getDust(GTCXMaterial.Zinc, 10));
            GTTileUUMAssembler.addUUMAssemblerValue(3, GTMaterialGen.getDust(GTMaterial.Nickel, 10));
            GTTileUUMAssembler.addUUMAssemblerValue(7, GTCXMaterialGen.getSmallDust(GTCXMaterial.Osmium, 1));
        }
        if (GTCXConfiguration.general.removeCraftingUURecipes){
            GTRecipeCraftingHandler.removeRecipe("ic2", "shaped_tile.stonebrick_-602048670");
            GTRecipeCraftingHandler.removeRecipe("ic2", "shaped_tile.stone.stone_-217206169");
            GTRecipeCraftingHandler.removeRecipe("ic2", "shaped_tile.glass_1510125347");
            GTRecipeCraftingHandler.removeRecipe("ic2", "shaped_tile.grass_1277632969");
            GTRecipeCraftingHandler.removeRecipe("ic2", "shaped_tile.log.oak_-1277881396");
            GTRecipeCraftingHandler.removeRecipe("ic2", "shaped_tile.log.spruce_1770332581");
            GTRecipeCraftingHandler.removeRecipe("ic2", "shaped_tile.log.birch_-1277881334");
            GTRecipeCraftingHandler.removeRecipe("ic2", "shaped_tile.log.jungle_1730114793");
            GTRecipeCraftingHandler.removeRecipe("ic2", "shaped_tile.log.acacia_569794864");
            GTRecipeCraftingHandler.removeRecipe("ic2", "shaped_tile.log.big_oak_529577045");
            GTRecipeCraftingHandler.removeRecipe("ic2", "shaped_tile.dirt.default_294096457");
            GTRecipeCraftingHandler.removeRecipe("ic2", "shaped_tile.sponge.dry_-486870232");
            GTRecipeCraftingHandler.removeRecipe("ic2", "shaped_tile.whitestone_1292746542");
            GTRecipeCraftingHandler.removeRecipe("ic2", "shaped_tile.stonemoss_-71282124");
            GTRecipeCraftingHandler.removeRecipe("ic2", "shaped_tile.sandstone.default_-222457682");
            GTRecipeCraftingHandler.removeRecipe("ic2", "shaped_tile.redsandstone.default_1661771456");
            GTRecipeCraftingHandler.removeRecipe("ic2", "shaped_tile.snow_-66319588");
            GTRecipeCraftingHandler.removeRecipe("ic2", "shaped_tile.water_2131885151");
            GTRecipeCraftingHandler.removeRecipe("ic2", "shaped_tile.lava_1530544253");
            GTRecipeCraftingHandler.removeRecipe("ic2", "shaped_tile.oreiron_-329870047");
            GTRecipeCraftingHandler.removeRecipe("ic2", "shaped_tile.oregold_-862634671");
            GTRecipeCraftingHandler.removeRecipe("ic2", "shaped_tile.obsidian_-440375730");
            GTRecipeCraftingHandler.removeRecipe("ic2", "shaped_tile.hellrock_-1150777333");
            GTRecipeCraftingHandler.removeRecipe("ic2", "shaped_item.netherstalkseeds_-1945039845");
            GTRecipeCraftingHandler.removeRecipe("ic2", "shaped_tile.lightgem_-1357010811");
            GTRecipeCraftingHandler.removeRecipe("ic2", "shaped_tile.cactus_1557334976");
            GTRecipeCraftingHandler.removeRecipe("ic2", "shaped_tile.vine_-128181428");
            GTRecipeCraftingHandler.removeRecipe("ic2", "shaped_item.chorusfruit_-621965693");
            GTRecipeCraftingHandler.removeRecipe("ic2", "shaped_tile.cloth.white_77283415");
            GTRecipeCraftingHandler.removeRecipe("ic2", "shaped_item.coal_-894344071");
            GTRecipeCraftingHandler.removeRecipe("ic2", "shaped_item.diamond_-839125610");
            GTRecipeCraftingHandler.removeRecipe("ic2", "shaped_item.redstone_609035693");
            GTRecipeCraftingHandler.removeRecipe("ic2", "shaped_item.netherquartz_-150174040");
            GTRecipeCraftingHandler.removeRecipe("ic2", "shaped_item.dyepowder.blue_-1943975137");
            GTRecipeCraftingHandler.removeRecipe("ic2", "shaped_item.feather_1656145116");
            GTRecipeCraftingHandler.removeRecipe("ic2", "shaped_item.leather_2089489131");
            GTRecipeCraftingHandler.removeRecipe("ic2", "shaped_item.snowball_-427886876");
            GTRecipeCraftingHandler.removeRecipe("ic2", "shaped_item.sulphur_-1833859045");
            GTRecipeCraftingHandler.removeRecipe("ic2", "shaped_item.enderpearl_2025630033");
            GTRecipeCraftingHandler.removeRecipe("ic2", "shaped_item.clay_916245029");
            GTRecipeCraftingHandler.removeRecipe("ic2", "shaped_item.blazerod_1662380818");
            GTRecipeCraftingHandler.removeRecipe("ic2", "shaped_item.prismarinecrystals_-886701636");
            GTRecipeCraftingHandler.removeRecipe("ic2", "shaped_item.prismarineshard_-2053819173");
            GTRecipeCraftingHandler.removeRecipe("ic2", "shaped_item.dyepowder.brown_1426380757");
            GTRecipeCraftingHandler.removeRecipe("ic2", "shaped_item.dyepowder.black_953740984");
            GTRecipeCraftingHandler.removeRecipe("ic2", "shaped_item.reeds_-459416326");
            GTRecipeCraftingHandler.removeRecipe("ic2", "shaped_item.flint_-1284138319");
            GTRecipeCraftingHandler.removeRecipe("ic2", "shaped_item.bone_-835878595");
            GTRecipeCraftingHandler.removeRecipe("ic2", "shaped_item.itemharz_2066627912");
            GTRecipeCraftingHandler.removeRecipe("ic2", "shaped_item.itemoreiridium_358070459");
            GTRecipeCraftingHandler.removeRecipe("ic2", "shaped_tile.mycel_1348556715");
            GTRecipeCraftingHandler.removeRecipe("ic2", "shaped_tile.stonebricksmooth.chiseled_1563944091");
            GTRecipeCraftingHandler.removeRecipe("ic2", "shaped_tile.blockorecopper_-1838757257");
            GTRecipeCraftingHandler.removeRecipe("ic2", "shaped_tile.blockoretin_1214808534");
            GTRecipeCraftingHandler.removeRecipe("ic2", "shaped_tile.blockoresilver_1084210042");
            GTRecipeCraftingHandler.removeRecipe("ic2", "shaped_item.emerald_981588030");
            GTRecipeCraftingHandler.removeRecipe(GTMod.MODID, "shaped_item.gtclassic.gemruby_891389810");
            GTRecipeCraftingHandler.removeRecipe(GTMod.MODID, "shaped_item.gtclassic.gemsapphire_-674562982");
            GTRecipeCraftingHandler.removeRecipe(GTMod.MODID, "shaped_tile.gtclassic.orebauxite_-377989822");
            GTRecipeCraftingHandler.removeRecipe(GTMod.MODID, "shaped_item.gtclassic.dusttitanium_171358254");
            GTRecipeCraftingHandler.removeRecipe(GTMod.MODID, "shaped_item.gtclassic.dustaluminium_575613706");
            GTRecipeCraftingHandler.removeRecipe(GTMod.MODID, "shaped_item.gtclassic.dustplatinum_645900471");
            GTRecipeCraftingHandler.removeRecipe(GTMod.MODID, "shaped_item.gtclassic.dusttungsten_1935969503");
        }
        GTCExpansion.logger.info("Tweaking Regular IC2 Recipes");
        
        /** Removals **/
        
        GTRecipeCraftingHandler.removeRecipe("ic2", "shaped_item.itemPlasmaCable_449044295");
        GTRecipeCraftingHandler.removeRecipe("ic2", "shaped_item.precisionwrench_-1943783685");
        GTRecipeCraftingHandler.removeRecipe("ic2", "shaped_item.itemcellempty_-1610951248");
        GTRecipeCraftingHandler.removeRecipe("ic2", "shaped_item.upgradekit.mfs_-1749227982");
        GTRecipeCraftingHandler.removeRecipe("ic2", "shapeled_item.itempartcarbonfibre_794316583");
        GTRecipeCraftingHandler.removeRecipe("ic2", "shapeless_item.itemdustbronze_-364730307");
	GTRecipeCraftingHandler.removeRecipe("ic2", "shaped_item.itemtoolwrench_-354759652");
        
        GTRecipeCraftingHandler.removeRecipe("ic2", "shaped_tile.hopper_-82413824");
        GTRecipeCraftingHandler.removeRecipe("ic2", "shaped_tile.blockrotary_-1360333248");
        GTRecipeCraftingHandler.removeRecipe("ic2", "shaped_tile.blockiridiumstone_-48520064");
        GTRecipeCraftingHandler.removeRecipe("ic2", "shaped_tile.blockwatergenerator_-2059790844");
        GTRecipeCraftingHandler.removeRecipe("ic2", "shaped_tile.blockwindgenerator_1669945012");
        GTRecipeCraftingHandler.removeRecipe("ic2", "shaped_tile.blockwindgenerator_-244136268");
        GTRecipeCraftingHandler.removeRecipe("ic2", "shaped_tile.blockgenerator_234578637");
        GTRecipeCraftingHandler.removeRecipe("ic2", "shaped_tile.blockgenerator_183901657");
        GTRecipeCraftingHandler.removeRecipe("ic2", "shaped_tile.blockmacerator_127744036");
        
        //recipes.addRecipe(GTMaterialGen.getIc2(Ic2Items.industrialTNT, 5), "FFF", "TTT", "FFF", 'F', "dustFlint", 'T', Blocks.TNT);
        //recipes.addRecipe(GTMaterialGen.getIc2(Ic2Items.industrialTNT, 5), "FTF", "FTF", "FTF", 'F', "dustFlint", 'T', Blocks.TNT);

        
        /** Override **/
        
        int recipeId = IC2.config.getFlag("SteelRecipes") ? -1329500063 : 241486317;
        ItemStack battery = Ic2Items.battery;
        String circuit = "circuitBasic";
        String machineBlock = "machineBlockBasic";
        String machineBlockCheap = "machineBlockCheap";
        String technetium = "plateTechnetium";
        String tin = "plateTin";
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setBoolean("Lossless", true);
        ItemStack stack = Ic2Items.precisionWrench.copy();
        stack.setTagCompound(nbt);
        recipes.overrideRecipe("shaped_item.precisionwrench_-1322002202", stack, "CRC", "SIS", "CWC", 'C', "circuitAdvanced", 'R', GTItems.rockCutter, 'S', "rodTungsten", 'I', Ic2Items.iridiumPlate, 'W', Ic2Items.electricWrench);
        recipes.overrideRecipe("shaped_tile.blockgenerator_-66857461", Ic2Items.generator, "B", "M", "F", 'B', battery, 'M', machineBlock, 'F', Blocks.FURNACE);
        recipes.overrideRecipe("shaped_tile.blockreactorchamber_1490756150", Ic2Items.reactorChamber, " C ", "CMC", " C ", 'C', Ic2Items.denseCopperPlate, 'M', machineBlock);
        recipes.overrideRecipe("shaped_tile.blockextractor_-1404085260", Ic2Items.extractor, "TMT", "TCT", 'T', Ic2Items.treeTap, 'M', machineBlock, 'C', circuit);
        recipes.overrideRecipe("shaped_tile.blockcompressor_-1019977500", Ic2Items.compressor, "S S", "SMS", "SCS", 'S', "stone", 'M', machineBlock, 'C', circuit);
        recipes.overrideRecipe("shaped_tile.blockcanner_-1437776888", Ic2Items.canner, "TCT", "TMT", "TTT", 'T', tin, 'M', machineBlock, 'C', circuit);
        recipes.overrideRecipe("shaped_tile.blockelectrolyzer_-502750552", Ic2Items.electrolyzer, "c c", "cCc", "tMt", 'c', Ic2Items.insulatedCopperCable, 't', Ic2Items.emptyCell, 'M', machineBlock, 'C', circuit);
        recipes.overrideRecipe("shaped_tile.blockcropscanner_-1289883511", Ic2Items.cropAnalyzerBlock, " c ", "CMC", 'c', Ic2Items.cropAnalyzer, 'M', machineBlock, 'C', circuit);
        recipes.overrideRecipe("shaped_tile.blockmagnetizer_-465205004", Ic2Items.magnetizer, "RFR", "RMR", "RFR", 'R', "dustRedstone", 'F', Ic2Items.ironFence, 'M', machineBlock);
        recipes.overrideRecipe("shaped_tile.blockpump_-527344087", Ic2Items.pump, "cCc", "cMc", "PTP", 'c', Ic2Items.emptyCell, 'P', Ic2Items.miningPipe, 'T', Ic2Items.treeTap, 'M', machineBlock, 'C', circuit);
        recipes.overrideRecipe("shaped_tile.blockminer_-59581574", Ic2Items.miner, "CMC", " p ", " p ", 'M', machineBlock, 'C', circuit, 'p', Ic2Items.miningPipe);
        recipes.overrideRecipe("shaped_tile.blockcropmatron_1348153838", Ic2Items.cropmatron, "CcC", "sMs", "sss", 'c', "chest", 's', Ic2Items.cropStick, 'M', machineBlock, 'C', circuit);
        recipes.overrideRecipe("shaped_tile.blocksoundbeacon_755381740", Ic2Items.soundBeacon, "FcF", "cMc", "BcB", 'F', Ic2Items.frequencyTransmitter, 'c', RecipeHelper.copper, 'M', machineBlock, 'B', battery);
        recipes.overrideRecipe("shaped_tile.blockcroplibrary_1883857081", Ic2Items.cropLibary, "sBs", "LNO", "CMC", 's', Ic2Items.cropStick, 'B', battery, 'L', Ic2Items.luminator, 'N', Ic2Items.carbonBox, 'O', Ic2Items.obscurator, 'M', machineBlock, 'C', circuit);
        recipes.overrideRecipe("shaped_tile.blockmachinebuffer_-989169435", Ic2Items.machineBuffer, " b ", "CTC", " M ", 'b', Ic2Items.upgradeBase, 'T', Ic2Items.toolBox, 'M', machineBlock, 'C', circuit);
        recipes.overrideRecipe("shaped_tile.blockindustrialworktable_2049276174", Ic2Items.industrialWorktable, "HCH", "NcN", "HMH", 'H', Blocks.HOPPER, 'C', GTCXHelperStack.input(circuit, 4), 'N', Ic2Items.carbonBox, 'c', new ItemStack(Blocks.CRAFTING_TABLE, 28), 'M', machineBlock);
        recipes.overrideRecipe("shaped_tile.blocksawmill_-1444206344", Ic2Items.sawMill, "ABA", "bMb", "bCb", 'A', Items.STONE_AXE, 'B', Ic2Items.turbineBlade, 'b', RecipeHelper.bronze, 'M', machineBlock, 'C', circuit);
        recipes.overrideRecipe("shaped_tile.blockadvmachine_1515831549", Ic2Items.advMachine, " C ", "AMA", " C ", 'C', Ic2Items.carbonPlate, 'A', Ic2Items.advancedAlloy, 'M', machineBlock);
        recipes.overrideRecipe("shaped_tile.blockadvmachine_-1920290047", Ic2Items.advMachine, " A ", "CMC", " A ", 'C', Ic2Items.carbonPlate, 'A', Ic2Items.advancedAlloy, 'M', machineBlock);
        recipes.overrideRecipe("shaped_tile.blocktransformermv_-1785545281", Ic2Items.transformerMV, "C", "M", "C", 'C', Ic2Items.doubleInsulatedGoldCable, 'M', machineBlock);
        recipes.overrideRecipe("shaped_tile.blocktransformermv_-1775375979", Ic2Items.transformerMV, "C", "M", "C", 'C', GTMaterialGen.getIc2(Ic2Items.doubleInsulatedBronzeCable, 2), 'M', machineBlock);
        recipes.overrideRecipe("shaped_tile.blockpersonaltrader_1344478433", Ic2Items.tradeOMat, "RRR", "cMc", 'R', "dustRedstone", 'c', "chest", 'M', machineBlock);
        recipes.overrideRecipe("shaped_tile.blockpersonaltraderfluid_2117013984", Ic2Items.fluidOMat,"GGG", "PMP", 'G', "blockGlass", 'P', Ic2Items.pump, 'M', machineBlock);
        recipes.overrideRecipe("shaped_tile.blockpersonaltraderenergy_-949356331", Ic2Items.energyOMat,"RBR", "cMc", 'R', "dustRedstone", 'B', battery, 'c', Ic2Items.insulatedCopperCable, 'M', machineBlock);
        recipes.overrideRecipe("shaped_tile.blockpersonalchest_-1405328861", Ic2Items.personalSafe, "C", "M", "I", 'C', circuit, 'M', machineBlock, 'I', "chest");
        recipes.overrideRecipe("shaped_tile.blockpersonalenergystoragebatbox_1253794578", Ic2Items.personalEnergyStorageBatBox, "C", "M", "I", 'C', circuit, 'M', machineBlock, 'I', Ic2Items.batBox);
        recipes.overrideRecipe("shaped_tile.blockpersonalenergystoragemfe_1253218358", Ic2Items.personalEnergyStorageMFE, "C", "M", "I", 'C', circuit, 'M', machineBlock, 'I', Ic2Items.mfe);
        recipes.overrideRecipe("shaped_tile.blockpersonalenergystoragemfsu_1245973306", Ic2Items.personalEnergyStorageMFSU, "C", "M", "I", 'C', circuit, 'M', machineBlock, 'I', Ic2Items.mfsu);
        recipes.overrideRecipe("shaped_item.mufflerupgrade_-77325382", Ic2Items.mufflerUpgrade, "WWW", "WMW", "WWW", 'W', Blocks.WOOL, 'M', machineBlock);
        recipes.overrideRecipe("shaped_item.expcollectorupgrade_-1525635881", Ic2Items.expCollectorUpgrade, "DMD", "CHC", "DBD", 'D', Ic2Items.denseCopperPlate, 'M', machineBlock, 'C', "circuitAdvanced", 'H', Blocks.HOPPER, 'B', Items.GLASS_BOTTLE);
        recipes.overrideRecipe("shaped_item.sideaccessupgrade_-607927002", Ic2Items.sideAccessUpgrade, " T ", "TMT", " T ", 'T', "trapdoorWood", 'M', machineBlock);
        recipes.overrideRecipe("shaped_item.rotationdisablerupgrade_412194477", Ic2Items.rotationDissablerUpgrade, "C", "R", "M", 'C', Items.COMPASS, 'R', Blocks.REDSTONE_TORCH, 'M', machineBlock);
        recipes.overrideRecipe("shaped_item.itemarmorquantumlegs_-1246661396", Ic2Items.quantumLeggings, "MLM", "INI", "G G", 'M', machineBlock, 'L', Ic2Items.lapotronCrystal, 'I', Ic2Items.iridiumPlate, 'N', Ic2Items.nanoLeggings, 'G', "dustGlowstone");
        recipes.overrideRecipe("shaped_item.itemtoolcutter_" + recipeId, GTMaterialGen.get(GTCXItems.cutter), "R R", " R ", "I I", 'R', RecipeHelper.materialRefinedIron, 'I', "ingotIron");
        recipes.overrideRecipe("shaped_item.itemplasmacore_-1985082214", Ic2Items.plasmaCore, "CSC", "SPS", "CSC", 'C', GTBlocks.tileSuperconductorCableMAX, 'S', RecipeHelper.tungsten, 'P', Ic2Items.plasmaCell);
        recipes.overrideRecipe("shaped_item.itempesd_-912043277", Ic2Items.pesd, "CSC", "SPS", "CSC", 'C', GTItems.orbEnergy, 'S', RecipeHelper.tungsten, 'P', Ic2Items.plasmaCore);
        recipes.overrideRecipe("shaped_item.itemportableteleporter_-869928001", Ic2Items.portableTeleporter, "ADA", "ACA", "ETE", 'A', RecipeHelper.platinum, 'D', "circuitData", 'C', "circuitMaster", 'E', GTItems.orbEnergy, 'T', Ic2Items.teleporter);
        recipes.overrideRecipe("shaped_item.quantumoverclockerupgrade_-1387578587", Ic2Items.quantumOverclockerUpgrade, "THT", "HOH", "TST", 'T', technetium, 'H', GTItems.heatStorageHelium6, 'O', Ic2Items.overClockerUpgrade, 'S', GTItems.superConductor);
        recipes.overrideRecipe("shaped_tile.blockpesu_281205134", Ic2Items.pesu, "SCS", "PPP", "SCS", 'S', RecipeHelper.tungsten, 'C', "circuitMaster", 'P', Ic2Items.pesd);
        recipes.overrideRecipe("shaped_tile.blockTransformerIV_1876908464", Ic2Items.transformerIV.copy(), "XYX", "CVB", "XYX", 'X', RecipeHelper.tungsten, 'Y', "craftingSuperconductor", 'C', "circuitMaster", 'V', Ic2Items.transformerEV.copy(), 'B', Ic2Items.pesd);
        recipes.overrideRecipe("shaped_item.itempartiridium_1100834802", GTMaterialGen.get(GTCXItems.iridiumAlloyIngot), "IAI", "ADA", "IAI", 'I', "ingotIridium", 'A', Ic2Items.advancedAlloy, 'D', "dustDiamond");
        recipeId = IC2.config.getFlag("SteelRecipes") ? -342403874 : -1588477206;
        recipes.overrideRecipe("shaped_item.itemtoolddrill_1955483893", Ic2Items.diamondDrill, " D ", "DdD", "TCT", 'D', "dustDiamond", 'd', Ic2Items.electricDrill, 'T', RecipeHelper.titanium, 'C', "circuitAdvanced");
        recipes.overrideRecipe("shaped_item.itemtooldrill_" + recipeId, Ic2Items.electricDrill, " S ", "SCS", "SBS", 'S', "plateStainlessSteel", 'C', circuit, 'B', battery);
        recipeId = IC2.config.getFlag("SteelRecipes") ? 286640886 : -824616294;
        recipes.overrideRecipe("shaped_item.itemtoolchainsaw_" + recipeId, Ic2Items.chainSaw, " SS", "SCS", "BS ", 'S', "plateStainlessSteel", 'C', circuit, 'B', battery);
        recipeId = IC2.config.getFlag("SteelRecipes") ? 1723493281 : -137638623;
        recipes.overrideRecipe("shaped_item.itemtoolhoe_" + recipeId, Ic2Items.electricHoe, "SS ", " C ", " B ", 'S', "plateStainlessSteel", 'C', circuit, 'B', battery);
        recipes.overrideRecipe("shaped_item.itemtreetapelectric_-1455688385", Ic2Items.electricTreeTap, " B ", "SCS", "T  ", 'T', Ic2Items.treeTap, 'S', "plateStainlessSteel", 'C', circuit, 'B', battery);
        recipes.overrideRecipe("shaped_item.electricsprayer_-335930196", Ic2Items.electricCfSprayer, "sS ", "SC ", "  B", 's', Ic2Items.cfSprayer, 'S', "plateStainlessSteel", 'C', circuit, 'B', battery);
        recipes.overrideRecipe("shaped_item.itemnanosaber_644260803", Ic2Items.nanoSaber, "PI ", "PI ", "CEC", 'P', RecipeHelper.platinum, 'I', Ic2Items.iridiumPlate, 'C', Ic2Items.carbonPlate, 'E', Ic2Items.energyCrystal);
	IRecipeInput wrench = new RecipeInputItemStack(Ic2Items.wrench);
        nbt = new NBTTagCompound();
        nbt.setBoolean("losslessMode", true);
        stack = Ic2Items.electricWrench.copy();
        stack.setTagCompound(nbt);
        recipes.overrideRecipe("shaped_item.itemtoolwrenchelectric_883008511", stack, "S S", "SCS", " B ",'S', "plateStainlessSteel", 'C', circuit, 'B', battery);
        recipes.overrideRecipe("shaped_item.itemtoolmininglaser_1732214669", Ic2Items.miningLaser,"RHE", "TTC", " AA", 'R', "gemRuby", 'H', GTItems.heatStorageHelium6, 'E', RecipeHelper.tier2Energy, 'T', RecipeHelper.titanium, 'C', "circuitAdvanced", 'A', Ic2Items.advancedAlloy);
        recipes.overrideRecipe("shaped_item.itembatre_2077392104", Ic2Items.battery, " C ", "TRT", "TRT", 'C', Ic2Items.insulatedCopperCable, 'T', tin, 'R', "dustRedstone");
        recipeId = IC2.config.getFlag("SteelRecipes") ? 389795443 : -650149377;
        recipes.overrideRecipe("shaped_item.itemingotalloy_" + recipeId, GTMaterialGen.getIc2(Ic2Items.mixedMetalIngot, 2), "TTT", "MMM", "BBB", 'T', RecipeHelper.materialRefinedIron, 'M', RecipeHelper.materialBrassBronze, 'B', RecipeHelper.materialTinZinc);
        if (IC2.config.getFlag("CraftingNuke")) {
            recipes.overrideRecipe("shaped_tile.blocknuke_-814805840", Ic2Items.nuke, "UCU", "BAB", "UCU", 'U', Ic2Items.reactorReEnrichedUraniumRod, 'C', "circuitAdvanced", 'B', "blockUranium", 'A', "machineBlockAdvanced");
        }
        if (IC2.config.getFlag("SteelRecipes")) {
            recipes.overrideRecipe("shaped_item.itemingotadviron_845672146", GTMaterialGen.getIngot(GTCXMaterial.Steel, 8), "M", 'M', Ic2Items.machine);
        }
        if (GTConfig.general.harderIC2Macerator) {
            recipes.overrideRecipe("shaped_tile.blockStoneMacerator_-130868445", Ic2Items.stoneMacerator.copy(), "WDH", "GMG", "BPB", 'D', "gemDiamond", 'W', "craftingToolWrench", 'H', "craftingToolForgeHammer", 'G', "gearBronze", 'M', machineBlockCheap, 'B', "plateBronze", 'P', RecipeHelper.anyPiston);
            recipes.overrideRecipe("shaped_tile.blockMacerator_2072794668", Ic2Items.macerator.copy(), "FDF", "DMD", "FCF", 'D', "gemDiamond", 'F', RecipeHelper.materialSteels, 'M', "machineBlockBasic", 'C',
                    "circuitAdvanced"); 
            recipes.addRecipe(Ic2Items.macerator.copy(), "FGF", "CMC", "FCF", 'G', RecipeHelper.grinder, 'F', RecipeHelper.materialSteels, 'M', "machineBlockBasic", 'C',
                    "circuitBasic");
            recipes.overrideRecipe("shaped_tile.blockrotary_-1598189826", Ic2Items.rotaryMacerator, "GGG", "GMG", "GAG", 'G', RecipeHelper.grinder, 'M', Ic2Items.macerator, 'A', "machineBlockAdvanced");
        }
        recipeId = IC2.config.getFlag("SteelRecipes") ? 1913907474 : 1986006418;
        recipes.overrideRecipe("shaped_tile.blockfenceiron_" + recipeId, GTMaterialGen.getIc2(Ic2Items.ironFence, 6), "RRR", "RRR", " W ", 'R', "rodRefinedIron", 'W', "craftingToolWrench");
        recipeId = IC2.config.getFlag("SteelRecipes") ? 480320652 : 527557260;
        recipes.overrideRecipe("shaped_tile.blockmachine_" + recipeId, Ic2Items.machine, "PPP", "PWP", "PPP", 'P', GTCXHelperStack.getRefinedIronPlate(), 'W', "craftingToolWrench");
        recipes.overrideRecipe("shaped_item.upgradekit.mfs_1186329581", Ic2Items.mfsuUpgradeKid, "BMB", "BBB", " B ", 'B', "ingotBronze", 'M', Ic2Items.mfsu);
        IRecipeInput ingotElectric = new RecipeInputCombined(1, GTCXHelperStack.input(RecipeHelper.ingotRefinedIron), GTCXHelperStack.input("itemSilicon"), GTCXHelperStack.input("ingotAluminium"), GTCXHelperStack.input("ingotSilver"), GTCXHelperStack.input("ingotElectrum"), GTCXHelperStack.input("ingotPlatinum"));
        IRecipeInput ingotSilver = new RecipeInputCombined(1, GTCXHelperStack.input("ingotSilver"), GTCXHelperStack.input("ingotElectrum"));
        IRecipeInput circuitBasicX2 = GTCXHelperStack.input("circuitBasic", 2);
        
        if (GTCXConfiguration.general.harderCircuits) {
            recipeId = IC2.config.getFlag("SteelRecipes") ? 1921363733 : 1058514721;
            recipes.overrideRecipe("shaped_item.itempartcircuit_" + recipeId, Ic2Items.electricCircuit, "CCC", "RER", "CCC", 'C', Ic2Items.insulatedCopperCable, 'R', "plateRedAlloy", 'E', RecipeHelper.plateElectric);
            recipeId = IC2.config.getFlag("SteelRecipes") ? -1911001323 : 1521116961;
            recipes.overrideRecipe("shaped_item.itempartcircuit_" + recipeId, Ic2Items.electricCircuit, "CRC", "CEC", "CRC", 'C', Ic2Items.insulatedCopperCable, 'R', "plateRedAlloy", 'E', RecipeHelper.plateElectric);
            recipes.overrideRecipe("shaped_item.itemPartCircuitAdv_-1948043137", GTMaterialGen.getIc2(Ic2Items.advancedCircuit, 1), "RGR", "LCL", "RGR", 'R', "plateRedAlloy", 'G', "dustGlowstone", 'C', "circuitBasic", 'L', RecipeHelper.anyLapis);
            recipes.overrideRecipe("shaped_item.itemPartCircuitAdv_-205948801", GTMaterialGen.getIc2(Ic2Items.advancedCircuit, 1), "RLR", "GCG", "RLR", 'R', "plateRedAlloy", 'G', "dustGlowstone", 'C', "circuitBasic", 'L', RecipeHelper.anyLapis);
        } else {
            if (GTConfig.general.addBasicCircuitRecipes) {
                recipeId = IC2.config.getFlag("SteelRecipes") ? 1921363733 : 1058514721;
                recipes.overrideRecipe("shaped_item.itemPartCircuit_"
                        + recipeId, GTMaterialGen.getIc2(Ic2Items.electricCircuit, 1), "CCC", "RIR", "CCC", 'C', Ic2Items.insulatedCopperCable.copy(), 'R', "dustRedstone", 'I', ingotElectric);
                recipeId = IC2.config.getFlag("SteelRecipes") ? -1911001323 : 1521116961;
                recipes.overrideRecipe("shaped_item.itemPartCircuit_"
                        + recipeId, GTMaterialGen.getIc2(Ic2Items.electricCircuit, 1), "CRC", "CIC", "CRC", 'C', Ic2Items.insulatedCopperCable.copy(), 'R', "dustRedstone", 'I', ingotElectric);
            }
            if (GTConfig.general.addAdvCircuitRecipes) {
                recipes.overrideRecipe("shaped_item.itemPartCircuitAdv_-1948043137", GTMaterialGen.getIc2(Ic2Items.advancedCircuit, 1), "RGR", "LCL", "RGR", 'R', "dustRedstone", 'G', "dustGlowstone", 'C', "circuitBasic", 'L', RecipeHelper.anyLapis);
                recipes.overrideRecipe("shaped_item.itemPartCircuitAdv_-205948801", GTMaterialGen.getIc2(Ic2Items.advancedCircuit, 1), "RLR", "GCG", "RLR", 'R', "dustRedstone", 'G', "dustGlowstone", 'C', "circuitBasic", 'L', RecipeHelper.anyLapis);
            }
        }

        /** Additions **/
        
        recipes.addRecipe(Ic2Items.pesu, "SsS", "CTP", "SsS", 'S', RecipeHelper.tungsten, 's', GTItems.superConductor, 'C', "circuitMaster", 'T', Ic2Items.transformerEV, 'P', Ic2Items.pesd);
        recipes.addRecipe(GTMaterialGen.getIc2(Ic2Items.suBattery, 32), "C", "S", "L", 'C', Ic2Items.insulatedCopperCable, 'S', GTMaterialGen.getTube(GTCXMaterial.SulfuricAcid, 1), 'L', "dustLead");
        recipes.addRecipe(GTMaterialGen.getIc2(Ic2Items.suBattery, 32), "C", "L", "S", 'C', Ic2Items.insulatedCopperCable, 'S', GTMaterialGen.getTube(GTCXMaterial.SulfuricAcid, 1), 'L', "dustLead");
        recipes.addRecipe(GTMaterialGen.getIc2(Ic2Items.battery, 2), " C ", "TST", "TLT", 'C', Ic2Items.insulatedCopperCable, 'T', tin, 'S', GTMaterialGen.getTube(GTCXMaterial.SulfuricAcid, 1), 'L', "dustLead");
        if (GTConfig.general.addBasicCircuitRecipes) {
            recipes.addRecipe(GTMaterialGen.getIc2(Ic2Items.electricCircuit, 2), "CCC", "III", "CCC", 'C', Ic2Items.insulatedCopperCable.copy(), 'I', ingotElectric);
            recipes.addRecipe(GTMaterialGen.getIc2(Ic2Items.electricCircuit, 2), "CIC", "CIC", "CIC", 'C', Ic2Items.insulatedCopperCable.copy(), 'I', ingotElectric);
        }
        if (GTConfig.general.addAdvCircuitRecipes) {
            recipes.addRecipe(GTMaterialGen.getIc2(Ic2Items.advancedCircuit, 2), "RGR", "LCL", "RGR", 'R', ingotSilver, 'G', "dustGlowstone", 'C', circuitBasicX2, 'L', RecipeHelper.anyLapis);
            recipes.addRecipe(GTMaterialGen.getIc2(Ic2Items.advancedCircuit, 2), "RLR", "GCG", "RLR", 'R', ingotSilver, 'G', "dustGlowstone", 'C', circuitBasicX2, 'L', RecipeHelper.anyLapis);
        }
        recipes.addShapelessRecipe(Ic2Items.reactorPlatingExplosive, Ic2Items.reactorPlating, RecipeHelper.lead);
    }
}
