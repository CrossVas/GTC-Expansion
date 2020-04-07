package gtc_expansion.recipes;

import static gtclassic.common.recipe.GTRecipeMods.input;
import static gtclassic.common.recipe.GTRecipeMods.metal;

import gtc_expansion.GTCExpansion;
import gtc_expansion.GTCXBlocks;
import gtc_expansion.GTCXConfiguration;
import gtc_expansion.GTCXItems;
import gtc_expansion.item.tools.GTCXToolGen;
import gtc_expansion.material.GTCXMaterial;
import gtc_expansion.material.GTCXMaterialGen;
import gtc_expansion.tile.multi.GTCXTileMultiIndustrialBlastFurnace;
import gtc_expansion.tile.multi.GTCXTileMultiPrimitiveBlastFurnace;
import gtc_expansion.util.GTCXHelperStack;
import gtclassic.GTMod;
import gtclassic.api.helpers.GTValues;
import gtclassic.api.material.GTMaterial;
import gtclassic.api.material.GTMaterialGen;
import gtclassic.api.recipe.GTRecipeCraftingHandler;
import gtclassic.common.GTBlocks;
import gtclassic.common.GTConfig;
import gtclassic.common.GTItems;
import gtclassic.common.recipe.GTRecipe;
import gtclassic.common.tile.GTTileUUMAssembler;
import ic2.api.classic.recipe.ClassicRecipes;
import ic2.api.classic.recipe.crafting.ICraftingRecipeList;
import ic2.api.recipe.IRecipeInput;
import ic2.core.IC2;
import ic2.core.block.machine.low.TileEntityCompressor;
import ic2.core.block.machine.low.TileEntityExtractor;
import ic2.core.block.machine.low.TileEntityMacerator;
import ic2.core.item.recipe.entry.RecipeInputCombined;
import ic2.core.item.recipe.entry.RecipeInputItemStack;
import ic2.core.item.recipe.entry.RecipeInputOreDict;
import ic2.core.item.recipe.upgrades.EnchantmentModifier;
import ic2.core.platform.registry.Ic2Items;
import net.minecraft.init.Blocks;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.ForgeRegistry;

public class GTCX_CraftingRecipeLoader {
	/**
	 * 
	 * Use this class for all Vanilla/Mods recipes 
	 * Removals, additions.
	 *
	 **/
	
    static ICraftingRecipeList recipes = ClassicRecipes.advCrafting;
    
    public static void init() {
    	GTCExpansion.logger.info("Loading non-oreDict Recipes");
    	GTCExpansion.logger.info("Tweaking GregTech Classic Recipes: Blocks");
    	/** Fusion Coil**/
        ItemStack top = GTConfig.modcompat.compatTwilightForest && Loader.isModLoaded(GTValues.MOD_ID_TFOREST) ? GTMaterialGen.getModItem(GTValues.MOD_ID_TFOREST, "uncrafting_table") : GTMaterialGen.getIc2(Ic2Items.extractor);
        IRecipeInput wrench = new RecipeInputCombined(1, GTCXHelperStack.input("craftingToolMonkeyWrench"), GTCXHelperStack.input("craftingToolWrench"));
        IRecipeInput rodIron = new RecipeInputOreDict("rodRefinedIron");
        IRecipeInput rodTiW = new RecipeInputCombined(1, GTCXHelperStack.input("rodTitanium", 1), GTCXHelperStack.input("rodTungstensteel", 1));
        IRecipeInput plate = new RecipeInputCombined(1, GTCXHelperStack.input(RecipeHelper.titanium, 1), GTCXHelperStack.input(RecipeHelper.tungstenSteel, 1));
        
        recipes.addRecipe(GTMaterialGen.get(GTBlocks.casingFusion), "CSC", "NMN", "CRC", 'C', "circuitMaster", 'S', "craftingSuperconductor", 'N', GTCXItems.nichromeHeatingCoil, 'M', "machineBlockElite", 'R', Ic2Items.reactorReflectorIridium);
        recipes.addRecipe(GTMaterialGen.get(GTBlocks.casingHighlyAdvanced), "CTC", "TMT", "CTC", 'C', RecipeHelper.chrome, 'T', RecipeHelper.titanium, 'M', "machineBlockAdvanced");
        recipes.addRecipe(GTMaterialGen.get(GTBlocks.casingHighlyAdvanced), "TCT", "CMC", "TCT", 'C', RecipeHelper.chrome, 'T', RecipeHelper.titanium, 'M', "machineBlockAdvanced");
        recipes.addRecipe(GTMaterialGen.get(GTBlocks.tileCentrifuge), "RCR", "MEM", "RCR", 'R', "plateStainlessSteel", 'C', "circuitAdvanced", 'M', "machineBlockAdvanced", 'E', Ic2Items.extractor);
        recipes.addRecipe(GTMaterialGen.get(GTBlocks.tileDisassembler, 1), "RAR", "ECE", "RWR", 'A', top, 'W', GTCXBlocks.assemblingMachine, 'R', RecipeHelper.materialRefinedIron, 'E', Ic2Items.insulatedCopperCable.copy(), 'C', "circuitAdvanced" );
        GTCXRecipe.overrideGTRecipe("shaped_tile.gtclassic.playerdetector_481673285", GTMaterialGen.get(GTBlocks.tilePlayerDetector, 1), " D ", "ACA", " D ", 'D', GTItems.chipData, 'A', "circuitAdvanced", 'C', GTBlocks.tileComputer);
        GTCXRecipe.overrideGTRecipe("shaped_tile.gtclassic.magicenergyconverter_605182006", GTMaterialGen.get(GTBlocks.tileMagicEnergyConverter, 1), "ATA", "PBP", "ALA", 'A', "circuitAdvanced", 'T', Ic2Items.teleporter, 'P', "platePlatinum", 'B', Blocks.BEACON, 'L', Ic2Items.lapotronCrystal);
        GTCXRecipe.overrideGTRecipe("shaped_tile.gtclassic.digitalchest_262693768", GTMaterialGen.get(GTBlocks.tileDigitalChest, 1), "PPP", "PDP", "PMP", 'P', RecipeHelper.materialMachine, 'D', GTItems.orbData, 'M', GTCXItems.computerMonitor);
        recipes.addRecipe(GTMaterialGen.get(GTBlocks.tileQuantumChest), "DCD", "HTH", "DdD", 'D', GTItems.orbData, 'C', GTCXItems.computerMonitor, 'H', "machineBlockElite", 'T', Ic2Items.teleporter, 'd', GTBlocks.tileDigitalChest);
        recipes.addRecipe(GTMaterialGen.get(GTBlocks.tileQuantumTank), "CPC", "PcP", "CPC", 'C', GTItems.circuitEnergy, 'P', RecipeHelper.platinum, 'C', "circuitMaster", 'c', GTBlocks.tileQuantumChest);
        recipes.addRecipe(GTMaterialGen.get(GTBlocks.tileTesseractMaster),"TCT", "CEC", "TcT", 'T', RecipeHelper.titanium, 'C', "circuitElite", 'E', Blocks.ENDER_CHEST, 'c', GTBlocks.tileComputer);
        recipes.addRecipe(GTMaterialGen.get(GTBlocks.tileTesseractSlave),"TCT", "CEC", "TcT", 'T', RecipeHelper.titanium, 'C', "circuitElite", 'E', Blocks.ENDER_CHEST, 'c', Ic2Items.advMachine);
        recipes.addRecipe(GTMaterialGen.get(GTBlocks.tileTranslocator), "EWE", "CBC", "EME", 'E', RecipeHelper.electrum, 'W', Ic2Items.insulatedCopperCable, 'C', "circuitBasic", 'B', "machineBlockCheap", 'M', GTCXItems.conveyorModule);
        recipes.addRecipe(GTMaterialGen.get(GTBlocks.tileBufferLarge), "EWE", "CBC", "EcE", 'E', RecipeHelper.electrum, 'W', Ic2Items.insulatedCopperCable, 'C', "circuitAdvanced", 'B', "machineBlockCheap", 'c', "chestWood");
        recipes.addRecipe(GTMaterialGen.get(GTBlocks.tileBufferFluid), "EWE", "CBC", "EbE", 'E', RecipeHelper.electrum, 'W', Ic2Items.insulatedCopperCable, 'C', "circuitAdvanced", 'B', "machineBlockCheap", 'b', Items.BUCKET);
        recipes.addRecipe(GTMaterialGen.get(GTBlocks.tileCabinet), "III", "CIC", "III", 'I', RecipeHelper.materialMachine, 'C', "chestWood");
        recipes.addRecipe(GTMaterialGen.get(GTBlocks.tileDrum), "PWP", "PMP", "PRP", 'P', RecipeHelper.materialMachine, 'W', wrench, 'M', rodIron, 'R', "rodRefinedIron");
        recipes.addRecipe(GTMaterialGen.get(GTBlocks.tileWorktable), "ICI", "III", "IcI", 'I', RecipeHelper.materialMachine, 'C', "workbench", 'c', "chestWood");
        recipes.addRecipe(GTMaterialGen.get(GTBlocks.tileAutocrafter), "EBE", "CcC", "EME", 'E', RecipeHelper.electrum, 'B', Ic2Items.battery, 'C', "circuitAdvanced", 'c', "workbench", 'M', "machineBlockAdvanced");
        recipes.addRecipe(GTMaterialGen.get(GTBlocks.tileTranslocatorFluid), "EWE", "CBC", "EME", 'E', RecipeHelper.electrum, 'W', Ic2Items.insulatedCopperCable, 'C', "circuitBasic", 'B', "machineBlockCheap", 'M', Ic2Items.basicFluidImportUpgrade);
        recipes.addRecipe(GTMaterialGen.get(GTBlocks.tileItemFilter), "III", "TCB", "III", 'I', RecipeHelper.materialMachine, 'C', GTValues.CIRCUIT_BASIC, 'T', GTBlocks.tileTranslocator, 'B', GTBlocks.tileBufferLarge);
        recipes.addRecipe(GTMaterialGen.get(GTBlocks.tileTypeFilter), "III", "TCB", "III", 'I', RecipeHelper.materialMachine, 'C', GTValues.CIRCUIT_ADVANCED, 'T', GTBlocks.tileTranslocator, 'B', GTBlocks.tileBufferLarge);
        recipes.addRecipe(GTMaterialGen.get(GTBlocks.tileCharcoalPit), new Object[] { "IFI", "IFI", "IFI", 'I', RecipeHelper.materialMachine, 'F', Items.FLINT });
		recipes.addRecipe(GTMaterialGen.get(GTBlocks.tileBatteryLV), " W ", "IRI", "IMI", 'W', Ic2Items.copperCable, 'I', RecipeHelper.tin, 'M', GTValues.MACHINE_BASIC, 'R', "blockRedstone");
		recipes.addRecipe(GTMaterialGen.get(GTBlocks.tileDragonEggEnergySiphon), "CTC", "ISI", "COC", 'C', GTItems.circuitEnergy, 'T', Ic2Items.teleporter, 'I', Ic2Items.iridiumPlate, 'O', GTItems.orbEnergy, 'S', GTBlocks.tileSupercondensator);
		
        GTCExpansion.logger.info("Tweaking GregTech Classic Recipes: Items");
        
    	GTRecipeCraftingHandler.overrideGTRecipe(GTMod.MODID, "shaped_item.gtclassic.destructo_pack_-1797414029", GTMaterialGen.get(GTItems.destructoPack), "CAC", "ABA", "CAC", 'C', GTMaterialGen.getIc2(Ic2Items.advancedCircuit), 'A', RecipeHelper.aluminium, 'B', Items.LAVA_BUCKET);
        recipes.addRecipe(GTMaterialGen.get(GTItems.rockCutter), "DR ", "DT ", "DCB", new EnchantmentModifier(GTMaterialGen.get(GTItems.rockCutter), Enchantments.SILK_TOUCH).setUsesInput(), 'R', rodTiW, 'T', plate, 'B', Ic2Items.battery, 'C', "circuitBasic", 'D', "dustDiamond");
        recipes.addRecipe(GTMaterialGen.get(GTItems.jackHammer), "TJT", " D ", 'T', "rodTungstensteel", 'J', GTCXItems.steelJackhammer, 'C', "circuitBasic", 'D', "dustDiamond");
        recipes.addRecipe(GTMaterialGen.get(GTItems.lithiumBattery), " C ", "ALA", "ALA", 'C', Ic2Items.goldCable, 'A', RecipeHelper.aluminium, 'L', "dustLithium");
        recipes.addRecipe(GTMaterialGen.get(GTItems.lithiumBatpack), "BCB", "BAB", "B B", 'B', GTItems.lithiumBattery, 'C', "circuitAdvanced", 'A', RecipeHelper.aluminium);
        recipes.addRecipe(GTMaterialGen.get(GTItems.portableScanner), "AEA", "CcC", "ABA", 'A', RecipeHelper.aluminium, 'E', Ic2Items.euReader, 'C', "circuitAdvanced", 'c', Ic2Items.cropAnalyzer, 'B', GTItems.lithiumBattery);
        recipes.addRecipe(GTMaterialGen.get(GTItems.lithiumBatpack), "BCB", " A ", 'B', GTCXItems.largeLithiumBattery, 'C', "circuitAdvanced", 'A', RecipeHelper.aluminium);
        if (GTConfig.general.removeIC2Plasmafier) {
            recipes.overrideRecipe("shaped_tile.blockPlasmafier_679353211", GTMaterialGen.get(GTBlocks.tileFusionReactor, 1), "ESE", "LCL", "ESE", 'E', "circuitMaster", 'S', GTBlocks.tileSupercondensator, 'L',
                    "batteryUltimate", 'C', GTBlocks.tileComputer);
        } else {
            recipes.addRecipe(GTMaterialGen.get(GTBlocks.tileFusionReactor, 1), "ESE", "LCL", "ESE", 'E',
                    "circuitMaster", 'S', "craftingSuperconductor", 'L', "batteryUltimate", 'C',
                    GTBlocks.tileComputer);
        }
        
		recipes.addRecipe(GTMaterialGen.get(GTItems.superConductor, 4), "CCC", "WPW", "EEE", 'C', GTValues.INPUT_COOLANT_SUPERCONDUCTOTR, 'E', GTValues.CIRCUIT_MASTER, 'W', RecipeHelper.tungsten, 'P', GTValues.PLATE_IRIDIUM_ALLOY);
		recipes.addRecipe(GTMaterialGen.get(GTItems.magnifyingGlass), " P", "S ", 'P', "paneGlass", 'S', rodIron);
		recipes.addRecipe(GTMaterialGen.get(GTItems.cloakingDevice, 1), "IPI", "POP", "IPI", 'I', RecipeHelper.chrome, 'P', GTValues.PLATE_IRIDIUM_ALLOY, 'O', GTValues.BATTERY_ULTIMATE);
		recipes.addRecipe(GTMaterialGen.get(GTItems.forceField, 1), "IPI", "POP", "IPI", 'I', RecipeHelper.chrome, 'P', GTValues.PLATE_IRIDIUM_ALLOY, 'O', GTItems.cloakingDevice);
		recipes.addRecipe(GTMaterialGen.get(GTItems.electroMagnet, 1), "M M", "WMW", "IBI", 'M', Ic2Items.magnet, 'B', Ic2Items.battery, 'I', RecipeHelper.rodSteels, 'W', Ic2Items.copperCable);
		recipes.addRecipe(GTMaterialGen.get(GTItems.teslaStaff, 1), " SL", " PS", "P  ", 'L', GTValues.BATTERY_ULTIMATE, 'S', GTValues.CRAFTING_SUPERCONDUCTOR, 'P', GTValues.PLATE_IRIDIUM_ALLOY);
		recipes.addRecipe(GTMaterialGen.get(GTItems.springBoots, 1), "IBI", "I I", 'B', Ic2Items.compositeBoots.copy(), 'I', RecipeHelper.materialMachine);
		
		
    	GTCExpansion.logger.info("Loading GregTech Classic Expansion Recipes: Blocks");
        String invar = "plateInvar";
        ItemStack pipe = new ItemStack(Items.BUCKET, 1);
        IRecipeInput materialStainlessTitatium = new RecipeInputCombined(1, GTCXHelperStack.input(RecipeHelper.stainlessSteel), GTCXHelperStack.input(RecipeHelper.titanium));
        IRecipeInput rodAluiron = new RecipeInputCombined(1, GTCXHelperStack.input("rodAluminium"), GTCXHelperStack.input("rodAluminum"),  GTCXHelperStack.input("rodRefinedIron"));
        
    	recipes.addRecipe(GTMaterialGen.get(GTCXBlocks.electrolyzer), "IEI", "AeA", "IEI", 'I', RecipeHelper.steels, 'E', Ic2Items.extractor.copy(), 'A', "circuitAdvanced", 'e', Ic2Items.electrolyzer.copy());
        recipes.addRecipe(GTMaterialGen.get(GTBlocks.tileComputer), "CMO", "MAM", "OMC", 'C', "circuitMaster", 'M', GTCXItems.computerMonitor, 'O', "circuitUltimate", 'A', "machineBlockAdvanced");
        recipes.addRecipe(GTMaterialGen.get(GTCXBlocks.assemblingMachine), "CPC", "SMS", "CSC", 'C', "circuitBasic", 'P', Blocks.PISTON, 'S', RecipeHelper.steels, 'M', GTCXItems.conveyorModule);
        recipes.addRecipe(GTMaterialGen.get(GTCXBlocks.chemicalReactor), "PMP", "CcC", "PEP", 'P', RecipeHelper.materialInvarAluminium, 'M', Ic2Items.magnetizer, 'C', "circuitAdvanced", 'c', Ic2Items.compressor, 'E', Ic2Items.extractor);
        recipes.addRecipe(GTMaterialGen.get(GTCXBlocks.distillationTower), "CEC", "PAP", "eEe", 'C', GTBlocks.tileCentrifuge, 'E', "circuitMaster", 'P', Ic2Items.pump.copy(), 'A', "machineBlockHighlyAdvanced", 'e', GTCXBlocks.electrolyzer);
        recipes.addRecipe(GTMaterialGen.get(GTCXBlocks.implosionCompressor), "AMA", "cCc", "AMA", 'A', Ic2Items.advancedAlloy.copy(), 'M', "machineBlockAdvanced", 'c', "circuitBasic", 'C', Ic2Items.compressor.copy());
        recipes.addRecipe(GTMaterialGen.get(GTCXBlocks.vacuumFreezer), "IPI", "AGA", "IPI", 'I', RecipeHelper.stainlessSteel, 'P', Ic2Items.pump.copy(), 'A', "circuitAdvanced", 'G', RecipeHelper.reinforcedGlass);
        recipes.addRecipe(GTMaterialGen.get(GTCXBlocks.alloySmelter), "IHI", "CFC", "IMI", 'I', invar, 'H', GTCXItems.constantanHeatingCoil, 'C', "circuitBasic", 'F', Ic2Items.electroFurnace.copy(), 'M', GTCXItems.conveyorModule);
        recipes.addRecipe(GTMaterialGen.get(GTCXBlocks.industrialGrinder), "ECP", "GGG", "CMC", 'E', GTCXBlocks.electrolyzer, 'C', "circuitAdvanced", 'P', Ic2Items.pump.copy(), 'G', RecipeHelper.grinder, 'M', "machineBlockAdvanced");
        recipes.addRecipe(GTMaterialGen.get(GTCXBlocks.industrialBlastFurnace), "CcC", "cMc", "FcF", 'C', "circuitBasic", 'c', GTCXItems.constantanHeatingCoil, 'M', "machineBlockAdvanced", 'F', Ic2Items.inductionFurnace);
        recipes.addRecipe(GTMaterialGen.get(GTCXBlocks.plateBender), "PCP", "cMc", "PCP", 'P', Blocks.PISTON, 'C', "circuitBasic", 'c', Ic2Items.compressor, 'M', GTCXItems.conveyorModule);
        recipes.addRecipe(GTMaterialGen.get(GTCXBlocks.wiremill), "PDP", "CMC", "PcP", 'P', RecipeHelper.brass, 'D', "gemDiamond", 'C', "circuitBasic", 'M', "machineBlockBasic", 'c', GTCXItems.conveyorModule);
        recipes.addRecipe(GTMaterialGen.get(GTCXBlocks.lathe), "PCP", "GMG", "PmP", 'P', RecipeHelper.materialSteels, 'C', "circuitAdvanced", 'G', "gearSteel", 'M', GTCXItems.conveyorModule, 'm', "machineBlockBasic");
        recipes.addRecipe(GTMaterialGen.get(GTCXBlocks.microwave), "AAA", "L M", "AAA", 'A', RecipeHelper.aluminium, 'L', RecipeHelper.lead, 'M', Ic2Items.magnetizer);
        recipes.addRecipe(GTMaterialGen.get(GTCXBlocks.fluidCaster), "IcI", "PMP", "ICI", 'I', materialStainlessTitatium, 'c', GTCXItems.mold, 'P', pipe, 'M', "machineBlockVeryAdvanced", 'C', "circuitElite");
        recipes.addRecipe(GTMaterialGen.get(GTCXBlocks.fluidSmelter), "IcI", "PMP", "BCB", 'I', materialStainlessTitatium, 'c', GTCXBlocks.industrialBlastFurnace, 'P', pipe, 'M', "machineBlockVeryAdvanced", 'C', "circuitElite", 'B', Blocks.BRICK_BLOCK, 'c', GTCXItems.constantanHeatingCoil);
        recipes.addRecipe(GTMaterialGen.get(GTCXBlocks.primitiveBlastFurnace), "PBP", "BWB", "PBP", 'B', Blocks.BRICK_BLOCK, 'P', "plateBronze", 'W', "craftingToolWrench");
        recipes.addRecipe(GTMaterialGen.get(GTCXBlocks.alloyFurnace), "BBB", "FWF", "CCC", 'C', Blocks.BRICK_BLOCK, 'F', Blocks.FURNACE, 'B', "plateBronze", 'W', "craftingToolWrench");
        recipes.addRecipe(GTMaterialGen.get(GTCXBlocks.casingStandard, 4), "III", "CBC", "III", 'I', RecipeHelper.materialMachine, 'C', "circuitBasic", 'B', "machineBlockCheap");
        recipes.addRecipe(GTMaterialGen.get(GTCXBlocks.casingReinforced, 4), "III", "CMC", "III", 'I', RecipeHelper.steels, 'C', "circuitAdvanced", 'M', "machineBlockAdvanced");
        recipes.addRecipe(GTMaterialGen.get(GTCXBlocks.casingAdvanced, 4), "III", "CBC", "III", 'I', RecipeHelper.chrome, 'C', GTItems.circuitData, 'B', "machineBlockElite");
        recipes.addRecipe(GTMaterialGen.get(GTCXBlocks.fireBrickBlock, 2), "PPP", "BHB", "PPP", 'P', "plateBronze", 'B', Blocks.BRICK_BLOCK, 'H', "craftingToolForgeHammer");
        recipes.addRecipe(GTMaterialGen.get(GTCXBlocks.dieselGenerator), "PPP", "P P", "CGC", 'P', RecipeHelper.materialMachine, 'C', "circuitBasic", 'G', Ic2Items.generator);
        recipes.addRecipe(GTMaterialGen.get(GTCXBlocks.gasTurbine), "PCP", "WGW", "PCP", 'P', RecipeHelper.materialInvarAluminium, 'C', "circuitAdvanced", 'W', Ic2Items.windMill, 'G', RecipeHelper.reinforcedGlass);
        recipes.addRecipe(GTMaterialGen.get(GTCXBlocks.locker), "RLR", "LCL", "PMP", GTCXRecipe.colorTransfer(GTMaterialGen.get(GTBlocks.tileCabinet)), 'R', rodAluiron, 'L', Items.LEATHER, 'C', GTBlocks.tileCabinet, 'P', RecipeHelper.materialMachine, 'M', "machineBlockCheap");
        recipes.addRecipe(GTMaterialGen.get(GTCXBlocks.electricLocker), "SLS", "SlS", "SCS", GTCXRecipe.colorTransfer(GTMaterialGen.get(GTCXBlocks.locker)), 'S', RecipeHelper.materialSteels, 'L', Ic2Items.lapotronCrystal, 'l', GTCXBlocks.locker, 'C', "circuitAdvanced");
        recipes.addRecipe(GTMaterialGen.get(GTCXBlocks.advancedWorktable), "EOE", "EWE", "ECE", GTCXRecipe.colorTransfer(GTMaterialGen.get(GTBlocks.tileWorktable)), 'E', RecipeHelper.electrum, 'O', RecipeHelper.tier2Energy, 'W', GTBlocks.tileWorktable, 'C', "circuitAdvanced");
        recipes.addRecipe(GTMaterialGen.get(GTCXBlocks.dustBin), "IHI", "IWI", "IHI", GTCXRecipe.colorTransfer(GTMaterialGen.get(GTBlocks.tileWorktable)), 'I', RecipeHelper.materialMachine, 'H', Blocks.HOPPER, 'W', GTBlocks.tileWorktable);
        recipes.addRecipe(GTMaterialGen.get(GTCXBlocks.stoneCompressor), "BGB", "PWP", "BMB", 'B', "plateBronze", 'G', "gearBronze", 'P', RecipeHelper.anyPiston, 'W', "craftingToolWrench", 'M', "machineBlockCheap");
        recipes.addRecipe(GTMaterialGen.get(GTCXBlocks.stoneExtractor), "BBB", "PWP", "BMB", 'B', "plateBronze", 'P', RecipeHelper.anyPiston, 'W', "craftingToolWrench", 'M', "machineBlockCheap");
        
    	GTCExpansion.logger.info("Loading GregTech Classic Expansion Recipes: Items");
        String stick = "stickWood";
        FluidStack water = new FluidStack(FluidRegistry.WATER, 1000);
        IRecipeInput ashes = new RecipeInputCombined(1, GTCXHelperStack.input("dustAshes"), GTCXHelperStack.input("dustAsh"));
        IRecipeInput dustAl = new RecipeInputCombined(1, new RecipeInputOreDict("dustAluminum"), new RecipeInputOreDict("dustAluminium"));
        IRecipeInput ingotElectric = new RecipeInputCombined(1, GTCXHelperStack.input(RecipeHelper.ingotRefinedIron), GTCXHelperStack.input("itemSilicon"), GTCXHelperStack.input("ingotAluminium"), GTCXHelperStack.input("ingotSilver"), GTCXHelperStack.input("ingotElectrum"), GTCXHelperStack.input("ingotPlatinum"));
        IRecipeInput ingotSilver = new RecipeInputCombined(1, GTCXHelperStack.input("ingotSilver"), GTCXHelperStack.input("ingotElectrum"));
        IRecipeInput circuitBasicX2 = GTCXHelperStack.input("circuitBasic", 2);
        
    	recipes.addRecipe(GTMaterialGen.get(GTCXItems.computerMonitor), "IGI", "RPB", "IgI", 'I', RecipeHelper.aluminium, 'G', "dyeGreen", 'R', "dyeRed", 'P', "paneGlass", 'B', "dyeBlue", 'g', "dustGlowstone");
    	recipes.addRecipe(GTMaterialGen.get(GTCXItems.conveyorModule), "GGG", "AAA", "CBC", 'G', "blockGlass", 'A', RecipeHelper.materialMachine, 'C', "circuitBasic", 'B', Ic2Items.battery.copy());
        recipes.addRecipe(GTMaterialGen.get(GTCXItems.diamondGrinder, 2), "DSD", "SdS", "DSD", 'D', "dustDiamond", 'S', RecipeHelper.steels, 'd', "gemDiamond");
        recipes.addRecipe(GTMaterialGen.get(GTCXItems.wolframiumGrinder, 2), "TST", "SBS", "TST", 'T', RecipeHelper.tungsten, 'S', RecipeHelper.steels, 'B', "blockSteel");
//        recipes.addRecipe(GTMaterialGen.get(GTCXItems.constantanHeatingCoil), "RRR", "R R", "RRR", 'R', "rodConstantan");
//        recipes.addRecipe(GTMaterialGen.get(GTCXItems.kanthalHeatingCoil), " R ", "R R", "RRR", 'R', "rodKanthal");
//        recipes.addRecipe(GTMaterialGen.get(GTCXItems.nichromeHeatingCoil), "RRR", "RIR", " R ", 'R', "rodNichrome", 'I', "ingotNichrome");
        recipes.addRecipe(GTMaterialGen.get(GTCXItems.diamondChainsaw), " D ", "DdD", "TCT", 'D', "dustDiamond", 'd', Ic2Items.chainSaw, 'T', RecipeHelper.titanium, 'C', "circuitAdvanced");
        recipes.addRecipe(GTMaterialGen.get(GTCXItems.steelJackhammer), "SBS", " C ", " s ", 'S', "rodStainlessSteel", 'B', Ic2Items.battery, 'C', "circuitAdvanced", 's', "ingotSteel");
        recipes.addRecipe(GTMaterialGen.get(GTCXItems.bronzeJackhammer), "RBR", " C ", " b ", 'R', "rodBronze", 'B', Ic2Items.battery, 'C', "circuitBasic", 'b', "ingotBronze");
        recipes.addRecipe(GTMaterialGen.get(GTCXItems.batteryHull), "C", "B", "B", 'C', Ic2Items.insulatedCopperCable, 'B', "plateBatteryAlloy");
        recipes.addRecipe(GTMaterialGen.get(GTCXItems.largeBatteryHull), "C C", "BBB", "BBB", 'C', Ic2Items.insulatedCopperCable, 'B', "plateBatteryAlloy");
        recipes.addRecipe(GTMaterialGen.get(GTCXItems.acidBattery), " C ", "LAL", "LAL", 'C', Ic2Items.copperCable, 'L', RecipeHelper.lead, 'A', GTMaterialGen.getTube(GTCXMaterial.SulfuricAcid, 1));
        recipes.addRecipe(GTMaterialGen.get(GTCXItems.mercuryBattery), " C ", "LAL", "LAL", 'C', Ic2Items.copperCable, 'L', RecipeHelper.lead, 'A', GTMaterialGen.getTube(GTMaterial.Mercury, 1));
        recipes.addRecipe(GTMaterialGen.get(GTCXItems.sodiumBattery), " C ", "LAL", "LAL", 'C', Ic2Items.goldCable, 'L', RecipeHelper.aluminium, 'A', GTMaterialGen.getTube(GTMaterial.Sodium, 1));
        recipes.addRecipe(GTMaterialGen.get(GTCXItems.mold), "HF", "SS", "SS", 'H', "craftingToolForgeHammer", 'F', "craftingToolFile", 'S', RecipeHelper.steel);
        recipes.addRecipe(GTMaterialGen.get(GTCXItems.moldPlate), "WM", 'W', "craftingToolWireCutter", 'M', GTCXItems.mold);
        recipes.addRecipe(GTMaterialGen.get(GTCXItems.moldRod), "M ", " W", 'W', "craftingToolWireCutter", 'M', GTCXItems.mold);
        recipes.addRecipe(GTMaterialGen.get(GTCXItems.moldCell), "W", "M", 'W', "craftingToolWireCutter", 'M', GTCXItems.mold);
        recipes.addRecipe(GTMaterialGen.get(GTCXItems.moldIngot), " W", "M ", 'W', "craftingToolWireCutter", 'M', GTCXItems.mold);
        recipes.addRecipe(GTMaterialGen.get(GTCXItems.moldWire), "M", "W", 'W', "craftingToolWireCutter", 'M', GTCXItems.mold);
        recipes.addRecipe(GTMaterialGen.get(GTCXItems.moldCasing), "W ", " M", 'W', "craftingToolWireCutter", 'M', GTCXItems.mold);
        recipes.addRecipe(GTMaterialGen.get(GTCXItems.moldSmallPipe), "M  ", "  W", 'W', "craftingToolWireCutter", 'M', GTCXItems.mold);
        recipes.addRecipe(GTMaterialGen.get(GTCXItems.moldMediumPipe), "M ", "  ", " W", 'W', "craftingToolWireCutter", 'M', GTCXItems.mold);
        recipes.addRecipe(GTMaterialGen.get(GTCXItems.moldLargePipe), "M  ", "   ", "  W", 'W', "craftingToolWireCutter", 'M', GTCXItems.mold);
        recipes.addRecipe(GTMaterialGen.get(GTCXItems.moldBlock), "M W", 'W', "craftingToolWireCutter", 'M', GTCXItems.mold);
        recipes.addRecipe(GTMaterialGen.get(GTCXItems.moldGear), "W", " ", "M", 'W', "craftingToolWireCutter", 'M', GTCXItems.mold);
        recipes.addRecipe(GTCXToolGen.getPickaxe(GTMaterial.Flint), "FFF", " S ", " S ", new EnchantmentModifier(GTCXToolGen.getPickaxe(GTMaterial.Flint), Enchantments.FIRE_ASPECT).setUsesInput(), 'F', Items.FLINT, 'S', stick);
        recipes.addRecipe(GTCXToolGen.getAxe(GTMaterial.Flint), "FF", "FS", " S", new EnchantmentModifier(GTCXToolGen.getAxe(GTMaterial.Flint), Enchantments.FIRE_ASPECT).setUsesInput(), 'F', Items.FLINT, 'S', stick);
        recipes.addRecipe(GTCXToolGen.getShovel(GTMaterial.Flint), "F", "S", "S", new EnchantmentModifier(GTCXToolGen.getShovel(GTMaterial.Flint), Enchantments.FIRE_ASPECT).setUsesInput(), 'F', Items.FLINT, 'S', stick);
        recipes.addRecipe(GTCXToolGen.getSword(GTMaterial.Flint), "F", "F", "S", new EnchantmentModifier(GTCXToolGen.getSword(GTMaterial.Flint), Enchantments.FIRE_ASPECT).setUsesInput(), 'F', Items.FLINT, 'S', stick);
        recipes.addShapelessRecipe(GTMaterialGen.getIc2(Ic2Items.fertilizer, 3), Ic2Items.fertilizer, "dustSulfur", GTMaterialGen.getTube(GTMaterial.Calcium, 1));
        recipes.addShapelessRecipe(GTMaterialGen.getIc2(Ic2Items.fertilizer, 2), Ic2Items.fertilizer, "dustAshes", "dustAshes", "dustAshes");
        recipes.addShapelessRecipe(GTMaterialGen.getIc2(Ic2Items.fertilizer, 2), Ic2Items.fertilizer, "dustDarkAshes");
        recipes.addShapelessRecipe(GTMaterialGen.get(GTCXItems.fireClayBall, 2), Items.CLAY_BALL, "sand", "dustFlint", water);
        recipes.addShapelessRecipe(new ItemStack(Items.IRON_INGOT, 1), "ingotRefinedIron", ashes);
        recipes.addShapelessRecipe(GTMaterialGen.get(GTCXItems.magicDye), "dyeCyan", "dyeMagenta", "dyeYellow", "dyeBlack");
        recipes.addShapelessRecipe(GTMaterialGen.getDust(GTCXMaterial.StainlessSteel, 9), "dustIron", "dustIron", "dustIron", "dustIron", "dustIron", "dustIron", "dustManganese", "dustNickel", "dustChrome");
        recipes.addShapelessRecipe(GTMaterialGen.getDust(GTCXMaterial.Kanthal, 3), "dustIron", dustAl, "dustChrome");
        recipes.addShapelessRecipe(GTMaterialGen.getIc2(Ic2Items.bronzeDust, 3), "dustCopper", "dustCopper", "dustCopper", "dustTin");
        
        GameRegistry.addSmelting(GTCXBlocks.oreSheldonite, GTMaterialGen.getIngot(GTMaterial.Platinum, 1), 1.0F);
        GameRegistry.addSmelting(GTCXBlocks.oreCassiterite, GTMaterialGen.getIc2(Ic2Items.tinIngot, 2), 0.5F);
        GameRegistry.addSmelting(GTCXBlocks.oreTetrahedrite, Ic2Items.copperIngot, 0.5F);
        GameRegistry.addSmelting(GTMaterialGen.getDust(GTCXMaterial.Tetrahedrite, 1), GTCXMaterialGen.getNugget(GTCXMaterial.Copper, 6), 0.5F);
        GameRegistry.addSmelting(Ic2Items.stoneMacerator, GTMaterialGen.getIc2(Ic2Items.bronzeIngot, 12), 1.0F);
        GameRegistry.addSmelting(GTCXBlocks.stoneExtractor, GTMaterialGen.getIc2(Ic2Items.bronzeIngot, 5), 1.0F);
        GameRegistry.addSmelting(GTCXBlocks.stoneCompressor, GTMaterialGen.getIc2(Ic2Items.bronzeIngot, 8), 1.0F);
        GameRegistry.addSmelting(GTMaterialGen.getDust(GTCXMaterial.Rubber, 1), GTMaterialGen.getIc2(Ic2Items.rubber, 1), 0.5F);
        
        GTCExpansion.logger.info("Tweaking IC2 UU-Recipes");
    	if (GTConfig.general.gregtechUURecipes) {
            if (!GTCXConfiguration.general.removeCraftingUURecipes) {
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
        if (GTCXConfiguration.general.removeCraftingUURecipes) {
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
        
        
        GTCExpansion.logger.info("Tweaking IC2 Regular Recipes");
        TileEntityMacerator.addRecipe("oreRedstone", 1, GTMaterialGen.get(Items.REDSTONE, 8));
        GTRecipe.maceratorUtil("oreSodalite", 1, GTMaterialGen.getDust(GTMaterial.Sodalite, 12));
        TileEntityExtractor.addRecipe(Ic2Items.stickyResin, GTMaterialGen.getDust(GTCXMaterial.Rubber, 3));
        TileEntityExtractor.addRecipe("oreOlivine", 1, GTMaterialGen.getGem(GTCXMaterial.Olivine, 3));
        
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
		wrench = new RecipeInputItemStack(Ic2Items.wrench);
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
        recipes.addRecipe(GTMaterialGen.getIc2(Ic2Items.mixedMetalIngot, 3), "TTT", "MMM", "BBB", 'T', RecipeHelper.materialRefinedIron, 'M', RecipeHelper.materialBrassBronze, 'B', RecipeHelper.materialMixedMetal1);
        recipes.addRecipe(GTMaterialGen.getIc2(Ic2Items.mixedMetalIngot, 6), "TTT", "MMM", "BBB", 'T', RecipeHelper.materialMixedMetal2, 'M', RecipeHelper.materialBrassBronze, 'B', RecipeHelper.materialMixedMetal1);
        recipes.addRecipe(GTMaterialGen.getIc2(Ic2Items.mixedMetalIngot, 8), "TTT", "MMM", "BBB", 'T', RecipeHelper.tungstenSteel, 'M', RecipeHelper.materialBrassBronze, 'B', RecipeHelper.materialMixedMetal1);
        recipes.addRecipe(Ic2Items.reactorVent, "PBP", "B B", "PBP", 'P', RecipeHelper.aluminium, 'B', Blocks.IRON_BARS);
        
        if (GTConfig.modcompat.compatTwilightForest && Loader.isModLoaded(GTValues.MOD_ID_TFOREST)) {
            GTCExpansion.logger.info("Tweaking TF Recipes");
            GTCXTileMultiPrimitiveBlastFurnace.addRecipe(new IRecipeInput[] { metal("Iron", 1),
                    input(GTMaterialGen.getModItem(GTValues.MOD_ID_TFOREST, "liveroot")),
                    input("nuggetGold", 1) }, 400, GTMaterialGen.getModItem(GTValues.MOD_ID_TFOREST, "ironwood_ingot", 2));
			String[] twilightPlanksType = { "wood/twilight_oak_", "wood/canopy_", "wood/mangrove_", "wood/darkwood_", "wood/time_", "wood/trans_", "wood/mine_", "wood/sort_" }; 
			if (GTCXConfiguration.general.planksNeedSaw) {
				for (int i = 0; i < twilightPlanksType.length; i++) {
	    			((ForgeRegistry)ForgeRegistries.RECIPES).remove(new ResourceLocation("twilightforest", twilightPlanksType[i] + "planks"));
	    		}	
			}
        }
        
        GTCExpansion.logger.info("Tweaking EIO Recipes");
        if (GTConfig.modcompat.compatEnderIO && Loader.isModLoaded(GTValues.MOD_ID_ENDERIO)) {
            // Dark steel upgrade
            GTCXTileMultiIndustrialBlastFurnace.addRecipe(new IRecipeInput[] {
                    input(GTMaterialGen.getModItem(GTValues.MOD_ID_ENDERIO, "block_dark_iron_bars", 1)), input("itemClay", 1),
                    input("string", 4) }, 500, 120000, GTMaterialGen.getModItem(GTValues.MOD_ID_ENDERIO, "item_dark_steel_upgrade"));
            // Electric Steel
            GTCXTileMultiIndustrialBlastFurnace.addRecipe(new IRecipeInput[] { metal("Iron", 1), input("dustCoal", 1),
                    input("itemSilicon", 1) }, 500, 40000, GTMaterialGen.getModMetaItem(GTValues.MOD_ID_ENDERIO, "item_alloy_ingot", 0, 1));
            // Energenic Alloy
            GTCXTileMultiIndustrialBlastFurnace.addRecipe(new IRecipeInput[] { input("dustRedstone", 1), metal("Gold", 1),
                    input("dustGlowstone", 1) }, 500, 40000, GTMaterialGen.getModMetaItem(GTValues.MOD_ID_ENDERIO, "item_alloy_ingot", 1, 1));
            // Vibrant Alloy
            GTCXTileMultiIndustrialBlastFurnace.addRecipe(new IRecipeInput[] { input("ingotEnergeticAlloy", 1),
                    input("enderpearl", 1) }, 500, 40000, GTMaterialGen.getModMetaItem(GTValues.MOD_ID_ENDERIO, "item_alloy_ingot", 2, 1));
            // Redstone Alloy
            GTCXTileMultiIndustrialBlastFurnace.addRecipe(new IRecipeInput[] { input("dustRedstone", 1),
                    input("itemSilicon", 1) }, 500, 40000, GTMaterialGen.getModMetaItem(GTValues.MOD_ID_ENDERIO, "item_alloy_ingot", 3, 1));
            // Conductive Iron
            GTCXTileMultiIndustrialBlastFurnace.addRecipe(new IRecipeInput[] { input("dustRedstone", 1),
                    metal("Iron", 1) }, 500, 40000, GTMaterialGen.getModMetaItem(GTValues.MOD_ID_ENDERIO, "item_alloy_ingot", 4, 1));
            // Pulsating Alloy
            GTCXTileMultiIndustrialBlastFurnace.addRecipe(new IRecipeInput[] { metal("Iron", 1),
                    input("enderpearl", 1) }, 500, 40000, GTMaterialGen.getModMetaItem(GTValues.MOD_ID_ENDERIO, "item_alloy_ingot", 5, 1));
            // Dark Steel
            GTCXTileMultiIndustrialBlastFurnace.addRecipe(new IRecipeInput[] { metal("Steel", 1),
                    input("dustObsidian", 1) }, 500, 80000, GTMaterialGen.getModMetaItem(GTValues.MOD_ID_ENDERIO, "item_alloy_ingot", 6, 1));
            // End Steel
            GTCXTileMultiIndustrialBlastFurnace.addRecipe(new IRecipeInput[] { input("endstone", 1), input("ingotDarkSteel", 1),
                    input("obsidian", 1) }, 500, 80000, GTMaterialGen.getModMetaItem(GTValues.MOD_ID_ENDERIO, "item_alloy_ingot", 8, 1));
            GTCXTileMultiIndustrialBlastFurnace.addRecipe(new IRecipeInput[] { input(GTMaterialGen.get(Blocks.SOUL_SAND, 1)),
                    metal("Gold", 1) }, 500, 40000, GTMaterialGen.getModMetaItem(GTValues.MOD_ID_ENDERIO, "item_alloy_ingot", 7, 1));
            // Fused Quartz - Custom Recipe!
            GTCXTileMultiIndustrialBlastFurnace.addRecipe(new IRecipeInput[] { input("dustNetherQuartz", 2),
                    input("blockGlass", 1) }, 500, 10000, GTMaterialGen.getModItem(GTValues.MOD_ID_ENDERIO, "block_fused_quartz", 1));
            // Enlightened Fused Quartz
            GTCXTileMultiIndustrialBlastFurnace.addRecipe(new IRecipeInput[] { input("gemQuartz", 4),
                    input("dustGlowstone", 4) }, 500, 20000, GTMaterialGen.getModItem(GTValues.MOD_ID_ENDERIO, "block_enlightened_fused_quartz", 1));
            GTCXTileMultiIndustrialBlastFurnace.addRecipe(new IRecipeInput[] { input("blockQuartz", 4),
                    input("glowstone", 4) }, 500, 20000, GTMaterialGen.getModItem(GTValues.MOD_ID_ENDERIO, "block_enlightened_fused_quartz", 1));
            // Enlightned Clear Glass
            GTCXTileMultiIndustrialBlastFurnace.addRecipe(new IRecipeInput[] { input("blockGlass", 1),
                    input("dustGlowstone", 4) }, 500, 20000, GTMaterialGen.getModItem(GTValues.MOD_ID_ENDERIO, "block_enlightened_fused_glass", 1));
            GTCXTileMultiIndustrialBlastFurnace.addRecipe(new IRecipeInput[] { input("blockGlass", 1),
                    input("glowstone", 1) }, 500, 20000, GTMaterialGen.getModItem(GTValues.MOD_ID_ENDERIO, "block_enlightened_fused_glass", 1));
            // Dark Fused Quartz
            GTCXTileMultiIndustrialBlastFurnace.addRecipe(new IRecipeInput[] { input("dyeBlack", 1),
                    input("gemQuartz", 4) }, 500, 20000, GTMaterialGen.getModItem(GTValues.MOD_ID_ENDERIO, "block_dark_fused_quartz", 1));
            GTCXTileMultiIndustrialBlastFurnace.addRecipe(new IRecipeInput[] { input("dyeBlack", 1),
                    input("blockQuartz", 1) }, 500, 20000, GTMaterialGen.getModItem(GTValues.MOD_ID_ENDERIO, "block_dark_fused_quartz", 1));
            GTCXTileMultiIndustrialBlastFurnace.addRecipe(new IRecipeInput[] { input("dyeBlack", 1),
                    input("blockGlassHardened", 1) }, 500, 10000, GTMaterialGen.getModItem(GTValues.MOD_ID_ENDERIO, "block_dark_fused_quartz", 1));
            // Dyes
            //doEnderIOBlastFurnaceDyeThings("Green", 48);
            //doEnderIOBlastFurnaceDyeThings("Brown", 49);
            GTCXTileMultiIndustrialBlastFurnace.addRecipe(new IRecipeInput[] { input("dustCoal", 6),
                    input("slimeball", 1) }, 500, 8000, GTMaterialGen.getModMetaItem(GTValues.MOD_ID_ENDERIO, "item_material", 50, 2));
            GTCXTileMultiIndustrialBlastFurnace.addRecipe(new IRecipeInput[] { input("dustCoal", 3),
                    input("egg", 1) }, 500, 6000, GTMaterialGen.getModMetaItem(GTValues.MOD_ID_ENDERIO, "item_material", 50, 1));
            GTCXTileMultiIndustrialBlastFurnace.addRecipe(new IRecipeInput[] { input("dustCharcoal", 6),
                    input("slimeball", 1) }, 500, 8000, GTMaterialGen.getModMetaItem(GTValues.MOD_ID_ENDERIO, "item_material", 50, 2));
            GTCXTileMultiIndustrialBlastFurnace.addRecipe(new IRecipeInput[] { input("dustCharcoal", 3),
                    input("egg", 1) }, 500, 6000, GTMaterialGen.getModMetaItem(GTValues.MOD_ID_ENDERIO, "item_material", 50, 1));
            GTCXTileMultiIndustrialBlastFurnace.addRecipe(new IRecipeInput[] { input(GTMaterialGen.get(Items.BEETROOT, 1)),
                    input("itemClay", 3), input("egg", 6) }, 500, 60000, new ItemStack(Items.DYE, 12, 1));
            // Machine Chassis
            GTCXTileMultiIndustrialBlastFurnace.addRecipe(new IRecipeInput[] { input("itemSimpleMachineChassi", 1),
                    input("dyeMachine", 1) }, 500, 14400, GTMaterialGen.getModMetaItem(GTValues.MOD_ID_ENDERIO, "item_material", 1, 1));
            GTCXTileMultiIndustrialBlastFurnace.addRecipe(new IRecipeInput[] { input("itemEndSteelMachineChassi", 1),
                    input("dyeEnhancedMachine", 1) }, 500, 14400, GTMaterialGen.getModMetaItem(GTValues.MOD_ID_ENDERIO, "item_material", 54, 1));
            GTCXTileMultiIndustrialBlastFurnace.addRecipe(new IRecipeInput[] { input("itemSimpleMachineChassi", 1),
                    input("dyeSoulMachine", 1) }, 500, 14400, GTMaterialGen.getModMetaItem(GTValues.MOD_ID_ENDERIO, "item_material", 53, 1));
            // Other Stuff
            GTCXTileMultiIndustrialBlastFurnace.addRecipe(new IRecipeInput[] { input("dustLapis", 1), input("blockWool", 1),
                    input("dustTin", 1) }, 500, 20000, GTMaterialGen.getModItem(GTValues.MOD_ID_ENDERIO, "block_industrial_insulation", 1));
            GTCXTileMultiIndustrialBlastFurnace.addRecipe(new IRecipeInput[] { input("ingotBrickNether", 1),
                    input("cropNetherWart", 4),
                    input("itemClay", 6) }, 500, 80000, GTMaterialGen.getModMetaItem(GTValues.MOD_ID_ENDERIO, "item_material", 72, 1));
            GTCXTileMultiIndustrialBlastFurnace.addRecipe(new IRecipeInput[] { input("dustBedrock", 1),
                    input("dustCoal", 1) }, 500, 20000, GTMaterialGen.getModMetaItem(GTValues.MOD_ID_ENDERIO, "item_material", 75, 1));
            GTCXTileMultiIndustrialBlastFurnace.addRecipe(new IRecipeInput[] { input("dustBedrock", 1),
                    input("dustCharcoal", 1) }, 500, 20000, GTMaterialGen.getModMetaItem(GTValues.MOD_ID_ENDERIO, "item_material", 75, 1));
            GTCXTileMultiIndustrialBlastFurnace.addRecipe(new IRecipeInput[] { input("dustGlowstone", 1),
                    input("itemClay", 1) }, 500, 20000, GTMaterialGen.getModMetaItem(GTValues.MOD_ID_ENDERIO, "item_material", 76, 2));
        }

        GTCExpansion.logger.info("Tweaking IC2 Extras Recipes");
        if ((!Loader.isModLoaded(GTValues.MOD_ID_IC2_EXTRAS) || !GTConfig.modcompat.compatIc2Extras)) {
            TileEntityCompressor.addRecipe("plateCopper", 8, Ic2Items.denseCopperPlate);
            GTRecipe.maceratorUtil("orePyrite", 1, GTMaterialGen.getDust(GTMaterial.Pyrite, 5));
            GTRecipe.maceratorUtil("oreCinnabar", 1, GTMaterialGen.getDust(GTCXMaterial.Cinnabar, 3));
            GTRecipe.maceratorUtil("oreSphalerite", 1, GTMaterialGen.getDust(GTCXMaterial.Sphalerite, 4));
            GTRecipe.maceratorUtil("oreTungstate", 1, GTMaterialGen.getDust(GTMaterial.Tungsten, 2));
        }
        if (GTConfig.modcompat.compatIc2Extras && Loader.isModLoaded(GTValues.MOD_ID_IC2_EXTRAS)) {
            GTRecipeCraftingHandler.removeRecipe(GTValues.MOD_ID_IC2_EXTRAS, "shapeless_item.itemdustbronze_-1753288283");
            ClassicRecipes.macerator.removeRecipe(input("oreBauxite", 1));
            ClassicRecipes.macerator.removeRecipe(input("oreIridium", 1));
            //String machineBlock = "machineBlockBasic";
            int recipeIdM = IC2.config.getFlag("SteelRecipes") ? 42294514 : -997650306;
            GTRecipeCraftingHandler.overrideGTRecipe(GTValues.MOD_ID_IC2_EXTRAS, "shaped_tile.orewashingplant_" + recipeIdM, GTMaterialGen.getModItem(GTValues.MOD_ID_IC2_EXTRAS, "orewashingplant"), "PPP", "BMB", "cCc", 'P', RecipeHelper.materialMachine, 'B', Items.BUCKET, 'M', machineBlock, 'c', Ic2Items.carbonMesh, 'C', circuit);
            GTRecipeCraftingHandler.overrideGTRecipe(GTValues.MOD_ID_IC2_EXTRAS, "shaped_tile.roller_-2064391190", GTMaterialGen.getModItem(GTValues.MOD_ID_IC2_EXTRAS, "roller"), "CPC", "PMP", "cPc", 'C', circuit, 'P', Blocks.PISTON, 'M', machineBlock, 'c', GTMaterialGen.getModItem(GTValues.MOD_ID_IC2_EXTRAS, "coil"));
            IRecipeInput casing = new RecipeInputCombined(1, new RecipeInputOreDict("casingSteel"), new RecipeInputOreDict("casingRefinedIron"), new RecipeInputOreDict("casingBronze"));
            GTRecipeCraftingHandler.overrideGTRecipe(GTValues.MOD_ID_IC2_EXTRAS, "shaped_tile.extruder_704871140", GTMaterialGen.getModItem(GTValues.MOD_ID_IC2_EXTRAS, "extruder"), "SCS", "cMc", "SCS", 'C', circuit, 'S', casing, 'M', machineBlock, 'c', GTMaterialGen.getModItem(GTValues.MOD_ID_IC2_EXTRAS, "coil"));
        }
		if (Loader.isModLoaded(GTValues.MOD_ID_FORESTRY)) {
			GTCExpansion.logger.info("Tweaking Forestry Recipes");
			if (GTCXConfiguration.general.planksNeedSaw) {
				String[] forestryPlanksType = { "_larch", "_teak", "_acacia", "_lime", "_chestnut", "_wenge", "_baobab", "_sequoia", "_kapok", "_ebony", "_mahogany", "_balsa", "_willow", "_walnut", "_greenheart", "_cherry", "_mahoe", "_poplar", "_palm", "_papaya", "_pine", "_plum", "_maple", "_citrus", "_giganteum", "_ipe", "_padauk", "_cocobolo", "_zebrawood", "_oak", "_spruce", "_birch", "_jungle", "_acacia", "_dark_oak" };
	    		for (int i = 0; i < forestryPlanksType.length; i++) {
	    			((ForgeRegistry)ForgeRegistries.RECIPES).remove(new ResourceLocation("forestry", "planks" + forestryPlanksType[i]));
	    			((ForgeRegistry)ForgeRegistries.RECIPES).remove(new ResourceLocation("forestry", "fireproof_" + "planks" + forestryPlanksType[i]));
	    		}
			}
    		((ForgeRegistry)ForgeRegistries.RECIPES).remove(new ResourceLocation("forestry", "gear_bronze"));
    		((ForgeRegistry)ForgeRegistries.RECIPES).remove(new ResourceLocation("forestry", "gear_copper"));
    		((ForgeRegistry)ForgeRegistries.RECIPES).remove(new ResourceLocation("forestry", "gear_tin"));
		}
		
		if (GTCXConfiguration.general.planksNeedSaw) {
			GTCExpansion.logger.info("Tweaking Vanilla Recipes");
	    	String[] vanillaPlanksType = { "oak_", "spruce_", "birch_", "jungle_", "acacia_", "dark_oak_" };
			for (int i = 0; i < vanillaPlanksType.length; i++) {
				((ForgeRegistry)ForgeRegistries.RECIPES).remove(new ResourceLocation("minecraft", vanillaPlanksType[i] + "planks"));	
			}
		}
		
        ((ForgeRegistry)ForgeRegistries.RECIPES).remove(new ResourceLocation("minecraft", "iron_bars"));
        ((ForgeRegistry)ForgeRegistries.RECIPES).remove(new ResourceLocation("minecraft", "hopper"));
        ((ForgeRegistry)ForgeRegistries.RECIPES).remove(new ResourceLocation("minecraft", "stick"));
        ((ForgeRegistry)ForgeRegistries.RECIPES).remove(new ResourceLocation("minecraft", "bucket"));
        ((ForgeRegistry)ForgeRegistries.RECIPES).remove(new ResourceLocation("minecraft", "minecart"));
        ((ForgeRegistry)ForgeRegistries.RECIPES).remove(new ResourceLocation("minecraft", "flint_and_steel"));
        ((ForgeRegistry)ForgeRegistries.RECIPES).remove(new ResourceLocation("minecraft", "light_weighted_pressure_plate"));
        ((ForgeRegistry)ForgeRegistries.RECIPES).remove(new ResourceLocation("minecraft", "heavy_weighted_pressure_plate"));
        ((ForgeRegistry)ForgeRegistries.RECIPES).remove(new ResourceLocation("quark", "hopper"));
		
        recipes.addRecipe(GTMaterialGen.get(Blocks.IRON_BARS, 8), "RRR", "RRR", " W ", 'R', "rodIron", 'W', "craftingToolWrench");
        recipes.addRecipe(GTMaterialGen.get(Items.BUCKET), "PHP", " P ", 'P', "plateIron", 'H', "craftingToolForgeHammer");
        recipes.addRecipe(GTMaterialGen.get(Items.MINECART), "PHP", "PPP", 'P', "plateIron", 'H', "craftingToolForgeHammer");
        recipes.addRecipe(GTMaterialGen.get(Blocks.LIGHT_WEIGHTED_PRESSURE_PLATE), "PPH", 'P', "plateGold", 'H', "craftingToolForgeHammer");
        recipes.addRecipe(GTMaterialGen.get(Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE), "PPH", 'P', "plateIron", 'H', "craftingToolForgeHammer");
        recipes.addRecipe(GTMaterialGen.get(Items.FLINT_AND_STEEL), "N ", " F", 'N', "nuggetSteel", 'F', Items.FLINT);
        
        String nickel = "plateNickel";
        String silver = "plateSilver";
        String iron = "plateIron";
        IRecipeInput material = new RecipeInputCombined(1, GTCXHelperStack.input(RecipeHelper.bronze), RecipeHelper.aluminium, GTCXHelperStack.input(RecipeHelper.electrum), GTCXHelperStack.input(RecipeHelper.platinum), GTCXHelperStack.input(nickel),  GTCXHelperStack.input(RecipeHelper.refinedIron), GTCXHelperStack.input(silver), GTCXHelperStack.input(iron));
        int recipeID = IC2.config.getFlag("SteelRecipes") ? -305222786 : -156474894;
        GTRecipeCraftingHandler.overrideGTRecipe("gtclassic", "shaped_tile.hopper_" + recipeID, GTMaterialGen.get(Blocks.HOPPER), "IWI", "ICI", " I ", 'I', material, 'W', "craftingToolWrench", 'C', "chestWood");
        
        recipes.addShapelessRecipe(GTMaterialGen.get(Items.GUNPOWDER, 3), "dustCoal", "dustSulfur", "dustSaltpeter", "dustSaltpeter");
        recipes.addShapelessRecipe(GTMaterialGen.get(Items.GUNPOWDER, 2), "dustCharcoal", "dustSulfur", "dustSaltpeter", "dustSaltpeter");
        
		if (Loader.isModLoaded("gravisuit") && GTCXConfiguration.modcompat.compatGravisuit) {
			GTCExpansion.logger.info("Tweaking GraviSuit Recipes");
            GTRecipeCraftingHandler.overrideGTRecipe("gravisuit", "shaped_item.advanceddiamondchainsaw_-416372460", GTMaterialGen.getModItem("gravisuit", "advancedchainsaw"), " SS", "SCS", "BS ", 'S', RecipeHelper.tungstenSteel, 'C', GTCXItems.diamondChainsaw, 'B', GTItems.lithiumBattery);
            GTRecipeCraftingHandler.overrideGTRecipe("gravisuit", "shaped_item.advanceddrill_1408250051", GTMaterialGen.getModItem("gravisuit", "advanceddrill"), " S ", "SDS", "SBS", 'S', RecipeHelper.tungstenSteel, 'D', Ic2Items.diamondDrill, 'B', GTItems.lithiumBattery);
		}
    }
}
