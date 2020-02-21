package gtc_expansion.recipes;

import gtc_expansion.GTCXBlocks;
import gtc_expansion.GTCXConfiguration;
import gtc_expansion.GTCXItems;
import gtc_expansion.item.tools.GTCXToolGen;
import gtc_expansion.material.GTCXMaterial;
import gtc_expansion.tile.GTCXTileAlloySmelter;
import gtc_expansion.tile.GTCXTileAssemblingMachine;
import gtc_expansion.tile.GTCXTileChemicalReactor;
import gtc_expansion.tile.GTCXTileDieselGenerator;
import gtc_expansion.tile.GTCXTileElectrolyzer;
import gtc_expansion.tile.GTCXTileFluidCaster;
import gtc_expansion.tile.GTCXTileFluidSmelter;
import gtc_expansion.tile.GTCXTileGasTurbine;
import gtc_expansion.tile.GTCXTileMicrowave;
import gtc_expansion.tile.GTCXTilePlateBender;
import gtc_expansion.tile.GTCXTileWiremill;
import gtc_expansion.tile.multi.GTCXTileMultiDistillationTower;
import gtc_expansion.tile.multi.GTCXTileMultiImplosionCompressor;
import gtc_expansion.tile.multi.GTCXTileMultiIndustrialBlastFurnace;
import gtc_expansion.tile.multi.GTCXTileMultiIndustrialGrinder;
import gtc_expansion.tile.multi.GTCXTileMultiPrimitiveBlastFurnace;
import gtc_expansion.tile.multi.GTCXTileMultiVacuumFreezer;
import gtc_expansion.util.GTCXHelperStack;
import gtclassic.api.helpers.GTValues;
import gtclassic.api.material.GTMaterial;
import gtclassic.api.material.GTMaterialGen;
import gtclassic.api.recipe.GTRecipeCraftingHandler;
import gtclassic.common.GTBlocks;
import gtclassic.common.GTConfig;
import gtclassic.common.GTItems;
import ic2.api.classic.recipe.ClassicRecipes;
import ic2.api.classic.recipe.crafting.ICraftingRecipeList;
import ic2.api.recipe.IRecipeInput;
import ic2.core.item.recipe.entry.RecipeInputCombined;
import ic2.core.item.recipe.entry.RecipeInputOreDict;
import ic2.core.item.recipe.upgrades.EnchantmentModifier;
import ic2.core.platform.registry.Ic2Items;
import ic2.core.util.misc.StackUtil;
import net.minecraft.init.Blocks;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.Loader;

public class GTCXRecipe {
    static GTCXRecipe instance = new GTCXRecipe();
    static ICraftingRecipeList recipes = ClassicRecipes.advCrafting;

    static ICraftingRecipeList.IRecipeModifier colorTransfer(ItemStack input){
        return new ICraftingRecipeList.IRecipeModifier() {

            String id = "color";
            boolean tag = false;
            int color;

            @Override
            public void clear() {
                tag = false;
            }

            @Override
            public boolean isStackValid(ItemStack provided) {
                if (StackUtil.isStackEqual(input, provided)){
                    NBTTagCompound nbt = StackUtil.getNbtData(provided);
                    if (nbt.hasKey(id)){
                        color = nbt.getInteger(id);
                        tag = true;
                    }
                }

                return true;
            }

            @Override
            public ItemStack getOutput(ItemStack output, boolean forDisplay) {
                if (forDisplay) {
                    StackUtil.addToolTip(output, "Color gets transfered");
                } else {
                    if (tag){
                        NBTTagCompound nbt = StackUtil.getOrCreateNbtData(output);
                        nbt.setInteger(id, color);
                    }
                }

                return output;
            }

            @Override
            public boolean isOutput(ItemStack possibleOutput) {
                return false;
            }
        };
    }
    
    public static void init(){
        GTCXRecipeRemove.init();
        GTCXRecipeProcessing.init();
        GTCXTileElectrolyzer.init();
        GTCXTileMultiVacuumFreezer.init();
        GTCXTileMultiIndustrialGrinder.init();
        GTCXTileMultiImplosionCompressor.init();
        GTCXTileMultiIndustrialBlastFurnace.init();
        GTCXTileMultiDistillationTower.init();
        GTCXTileAlloySmelter.init();
        GTCXTileAssemblingMachine.init();
        GTCXTileChemicalReactor.init();
        GTCXTileMultiPrimitiveBlastFurnace.init();
        GTCXTileFluidCaster.init();
        GTCXTileFluidSmelter.init();
        GTCXTilePlateBender.init();
        GTCXTileWiremill.init();
        GTCXTileDieselGenerator.init();
        GTCXTileGasTurbine.init();
        GTCXRecipeMods.init();
        initOverrideGTClassic();
        initShapedItemRecipes();
        initShapedBlockRecipes();
        initRemainingToolRecipes();
        initShapelessRecipes();
        GTCXRecipeIterators.init();
    }

    public static void postInit(){
    	GTCXRecipeProcessing.removals();
        if (GTCXConfiguration.general.planksNeedSaw) {
            GTCXRecipeIterators.createOreDictPlanksRecipe();
            GTCXRecipeIterators.createOreDictPlanksRecipeX2();
            GTCXRecipeIterators.createStickRecipe();
            GTCXRecipeIterators.createStickRecipeX2();
        }
        GTCXIC2ClassicRecipes.initIC2Recipes();
        if (GTCXConfiguration.general.enableCraftingTools){
            GTCXVanillaRecipes.initVanillaRecipes();
        }
    	GTCXOverrideRecipes.initGTCXOverride();
        GTCXRecipeIterators.initAutoOredictMachineRecipes();
        GTCXTileMicrowave.init();
    }

    public static void initShapedItemRecipes(){
        recipes.addRecipe(GTMaterialGen.get(GTCXItems.computerMonitor), "IGI", "RPB", "IgI", 'I', RecipeHelper.aluminium, 'G', "dyeGreen", 'R', "dyeRed", 'P', "paneGlass", 'B', "dyeBlue", 'g', "dustGlowstone");
        recipes.addRecipe(GTMaterialGen.get(GTCXItems.conveyorModule), "GGG", "AAA", "CBC", 'G', "blockGlass", 'A', RecipeHelper.materialMachine, 'C', "circuitBasic", 'B', Ic2Items.battery.copy());
        recipes.addRecipe(GTMaterialGen.get(GTCXItems.diamondGrinder, 2), "DSD", "SdS", "DSD", 'D', "dustDiamond", 'S', RecipeHelper.steel, 'd', "gemDiamond");
        recipes.addRecipe(GTMaterialGen.get(GTCXItems.wolframiumGrinder, 2), "TST", "SBS", "TST", 'T', RecipeHelper.tungsten, 'S', RecipeHelper.steel, 'B', "blockSteel");
//        recipes.addRecipe(GTMaterialGen.get(GTCXItems.constantanHeatingCoil), "RRR", "R R", "RRR", 'R', "rodConstantan");
//        recipes.addRecipe(GTMaterialGen.get(GTCXItems.kanthalHeatingCoil), " R ", "R R", "RRR", 'R', "rodKanthal");
//        recipes.addRecipe(GTMaterialGen.get(GTCXItems.nichromeHeatingCoil), "RRR", "RIR", " R ", 'R', "rodNichrome", 'I', "ingotNichrome");
        recipes.addRecipe(GTMaterialGen.get(GTCXItems.diamondChainsaw), " D ", "DdD", "TCT", 'D', "dustDiamond", 'd', Ic2Items.chainSaw, 'T', RecipeHelper.titanium, 'C', "circuitAdvanced");
        recipes.addRecipe(GTMaterialGen.get(GTCXItems.steelJackhammer), "SBS", " C ", " s ", 'S', RecipeHelper.rodSteels, 'B', Ic2Items.battery, 'C', "circuitAdvanced", 's', RecipeHelper.ingotSteels);
        if (GTCXConfiguration.general.unfiredBricks){
            recipes.addRecipe(GTMaterialGen.get(GTCXItems.unfiredBrick, 2), "C", "C", 'C', Items.CLAY_BALL);
            recipes.addRecipe(GTMaterialGen.get(GTCXItems.unfiredFireBrick, 2), "C", "C", 'C', GTCXItems.fireClayBall);
        }
        recipes.addRecipe(GTMaterialGen.get(GTItems.lithiumBatpack), "BCB", " A ", 'B', GTCXItems.largeLithiumBattery, 'C', "circuitAdvanced", 'A', RecipeHelper.aluminium);
        recipes.addRecipe(GTMaterialGen.get(GTCXItems.batteryHull), "C", "B", "B", 'C', Ic2Items.copperCable, 'B', "plateBatteryAlloy");
        recipes.addRecipe(GTMaterialGen.get(GTCXItems.largeBatteryHull), "C C", "BBB", "BBB", 'C', Ic2Items.goldCable, 'B', "plateBatteryAlloy");
        recipes.addRecipe(GTMaterialGen.get(GTCXItems.acidBattery), " C ", "LAL", "LAL", 'C', Ic2Items.copperCable, 'L', RecipeHelper.lead, 'A', GTMaterialGen.getTube(GTCXMaterial.SulfuricAcid, 1));
        recipes.addRecipe(GTMaterialGen.get(GTCXItems.mercuryBattery), " C ", "LAL", "LAL", 'C', Ic2Items.copperCable, 'L', RecipeHelper.lead, 'A', GTMaterialGen.getTube(GTMaterial.Mercury, 1));
        recipes.addRecipe(GTMaterialGen.get(GTCXItems.sodiumBattery), " C ", "LAL", "LAL", 'C', Ic2Items.goldCable, 'L', RecipeHelper.aluminium, 'A', GTMaterialGen.getTube(GTMaterial.Sodium, 1));
        if (GTCXConfiguration.general.enableCraftingTools){
            recipes.addRecipe(GTMaterialGen.get(GTCXItems.mold), "HF", "SS", "SS", 'H', "craftingToolForgeHammer", 'F', "craftingToolFile", 'S', RecipeHelper.steel);
        } else {
            recipes.addRecipe(GTMaterialGen.get(GTCXItems.mold), "SS", "SS", 'S', RecipeHelper.steel);
        }
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
    }

    public static void initRemainingToolRecipes(){
        String stick = "stickWood";
        recipes.addRecipe(GTCXToolGen.getPickaxe(GTMaterial.Flint), "FFF", " S ", " S ", new EnchantmentModifier(GTCXToolGen.getPickaxe(GTMaterial.Flint), Enchantments.FIRE_ASPECT).setUsesInput(), 'F',
                Items.FLINT, 'S', stick);
        recipes.addRecipe(GTCXToolGen.getAxe(GTMaterial.Flint), "FF", "FS", " S", new EnchantmentModifier(GTCXToolGen.getAxe(GTMaterial.Flint), Enchantments.FIRE_ASPECT).setUsesInput(), 'F',
                Items.FLINT, 'S', stick);
        recipes.addRecipe(GTCXToolGen.getShovel(GTMaterial.Flint), "F", "S", "S", new EnchantmentModifier(GTCXToolGen.getShovel(GTMaterial.Flint), Enchantments.FIRE_ASPECT).setUsesInput(), 'F',
                Items.FLINT, 'S', stick);
        recipes.addRecipe(GTCXToolGen.getSword(GTMaterial.Flint), "F", "F", "S", new EnchantmentModifier(GTCXToolGen.getSword(GTMaterial.Flint), Enchantments.FIRE_ASPECT).setUsesInput(), 'F',
                Items.FLINT, 'S', stick);
        if (GTCXConfiguration.general.enableCraftingTools){
            recipes.addRecipe(GTCXToolGen.getFile(GTCXMaterial.Bronze), "P", "P", "S", 'P', "plateBronze", 'S', stick);
            recipes.overrideRecipe("shaped_item.itemtoolwrench_-354759652", GTCXToolGen.getWrench(GTCXMaterial.Bronze), "I I", "III", " I ", 'I', "ingotBronze");
            recipes.addRecipe(GTCXToolGen.getFile(GTCXMaterial.Iron), "P", "P", "S", 'P', "plateIron", 'S', stick);
            recipes.addRecipe(GTCXToolGen.getWrench(GTCXMaterial.Iron), "I I", "III", " I ", 'I', "ingotIron");
        }
        recipes.addRecipe(GTCXToolGen.getHammer(GTCXMaterial.Bronze), "PPP", "PPP", " S ", 'P', "ingotBronze", 'S', stick);
        recipes.addRecipe(GTCXToolGen.getHammer(GTCXMaterial.Iron), "PPP", "PPP", " S ", 'P', "ingotIron", 'S', stick);
    }

    public static void initOVerrideVanillaRecipes(){
        String stick = "stickWood";
        recipes.addRecipe(GTCXToolGen.getPickaxe(GTMaterial.Flint), "FFF", " S ", " S ", new EnchantmentModifier(GTCXToolGen.getPickaxe(GTMaterial.Flint), Enchantments.FIRE_ASPECT).setUsesInput(), 'F',
                Items.FLINT, 'S', stick);
        recipes.addRecipe(GTCXToolGen.getAxe(GTMaterial.Flint), "FF", "FS", " S", new EnchantmentModifier(GTCXToolGen.getAxe(GTMaterial.Flint), Enchantments.FIRE_ASPECT).setUsesInput(), 'F',
                Items.FLINT, 'S', stick);
        recipes.addRecipe(GTCXToolGen.getShovel(GTMaterial.Flint), "F", "S", "S", new EnchantmentModifier(GTCXToolGen.getShovel(GTMaterial.Flint), Enchantments.FIRE_ASPECT).setUsesInput(), 'F',
                Items.FLINT, 'S', stick);
        recipes.addRecipe(GTCXToolGen.getSword(GTMaterial.Flint), "F", "F", "S", new EnchantmentModifier(GTCXToolGen.getSword(GTMaterial.Flint), Enchantments.FIRE_ASPECT).setUsesInput(), 'F',
                Items.FLINT, 'S', stick);
        if (GTCXConfiguration.general.enableCraftingTools) {
            recipes.overrideRecipe("shaped_item.itemtoolwrench_-354759652", GTCXToolGen.getWrench(GTCXMaterial.Bronze), "I I", "III", " I ", 'I', "ingotBronze");
        }
    }

    public static void initShapedBlockRecipes(){
        String invar = GTCXConfiguration.general.usePlates ? "plateInvar" : "ingotInvar";
        recipes.addRecipe(GTMaterialGen.get(GTCXBlocks.assemblingMachine), "CPC", "SMS", "CSC", 'C', "circuitBasic", 'P', Blocks.PISTON, 'S', RecipeHelper.materialSteelsAluminium, 'M', GTCXItems.conveyorModule);
        recipes.addRecipe(GTMaterialGen.get(GTCXBlocks.chemicalReactor), "PMP", "CcC", "PEP", 'P', RecipeHelper.materialInvarAluminium, 'M', Ic2Items.magnetizer, 'C', "circuitAdvanced", 'c', Ic2Items.compressor, 'E', Ic2Items.extractor);
        recipes.addRecipe(GTMaterialGen.get(GTCXBlocks.distillationTower), "CEC", "PAP", "eEe", 'C', GTBlocks.tileCentrifuge, 'E', "circuitMaster", 'P', Ic2Items.pump.copy(), 'A', "machineBlockHighlyAdvanced", 'e', GTCXBlocks.electrolyzer);
        recipes.addRecipe(GTMaterialGen.get(GTCXBlocks.implosionCompressor), "AMA", "cCc", "AMA", 'A', Ic2Items.advancedAlloy.copy(), 'M', "machineBlockAdvanced", 'c', "circuitBasic", 'C', Ic2Items.compressor.copy());
        recipes.addRecipe(GTMaterialGen.get(GTCXBlocks.electrolyzer), "IEI", "AeA", "IEI", 'I', RecipeHelper.materialSteelsAluminium, 'E', Ic2Items.extractor.copy(), 'A', "circuitAdvanced", 'e', Ic2Items.electrolyzer.copy());
        recipes.addRecipe(GTMaterialGen.get(GTCXBlocks.vacuumFreezer), "IPI", "AGA", "IPI", 'I', RecipeHelper.stainlessSteel, 'P', Ic2Items.pump.copy(), 'A', "circuitAdvanced", 'G', RecipeHelper.reinforcedGlass);
        recipes.addRecipe(GTMaterialGen.get(GTCXBlocks.alloySmelter), "IHI", "CFC", "IMI", 'I', invar, 'H', GTCXItems.constantanHeatingCoil, 'C', "circuitBasic", 'F', Ic2Items.electroFurnace.copy(), 'M', GTCXItems.conveyorModule);
        recipes.addRecipe(GTMaterialGen.get(GTCXBlocks.industrialGrinder), "ECP", "GGG", "CMC", 'E', GTCXBlocks.electrolyzer, 'C', "circuitAdvanced", 'P', Ic2Items.pump.copy(), 'G', RecipeHelper.grinder, 'M', "machineBlockAdvanced");
        recipes.addRecipe(GTMaterialGen.get(GTCXBlocks.industrialBlastFurnace), "CcC", "cMc", "FcF", 'C', "circuitBasic", 'c', GTCXItems.constantanHeatingCoil, 'M', "machineBlockAdvanced", 'F', Ic2Items.inductionFurnace);
        recipes.addRecipe(GTMaterialGen.get(GTCXBlocks.plateBender), "PCP", "cMc", "PCP", 'P', Blocks.PISTON, 'C', "circuitBasic", 'c', Ic2Items.compressor, 'M', GTCXItems.conveyorModule);
        recipes.addRecipe(GTMaterialGen.get(GTCXBlocks.wiremill), "PDP", "CMC", "PcP", 'P', RecipeHelper.brass, 'D', "gemDiamond", 'C', "circuitBasic", 'M', "machineBlockBasic", 'c', GTCXItems.conveyorModule);
        recipes.addRecipe(GTMaterialGen.get(GTCXBlocks.lathe), "PCP", "GMG", "PmP", 'P', RecipeHelper.materialSteels, 'C', "circuitAdvanced", 'G', "gearSteel", 'M', GTCXItems.conveyorModule, 'm', "machineBlockBasic");
        recipes.addRecipe(GTMaterialGen.get(GTCXBlocks.microwave), "AAA", "L M", "AAA", 'A', RecipeHelper.aluminium, 'L', RecipeHelper.lead, 'M', Ic2Items.magnetizer);
        IRecipeInput materialStainlessTitatium = new RecipeInputCombined(1, GTCXHelperStack.input(RecipeHelper.stainlessSteel), GTCXHelperStack.input(RecipeHelper.titanium));
        //IRecipeInput pipe = new RecipeInputCombined(1, new RecipeInputItemStack(GTMaterialGen.getFluidPipe(GTMaterial.Titanium, 1)), new RecipeInputItemStack(GTMaterialGen.getFluidPipe(GTCXMaterial.StainlessSteel, 1)));
        ItemStack pipe = new ItemStack(Items.BUCKET, 1);
        recipes.addRecipe(GTMaterialGen.get(GTCXBlocks.fluidCaster), "IcI", "PMP", "ICI", 'I', materialStainlessTitatium, 'c', GTCXItems.mold, 'P', pipe, 'M', "machineBlockVeryAdvanced", 'C', "circuitElite");
        recipes.addRecipe(GTMaterialGen.get(GTCXBlocks.fluidSmelter), "IbI", "PMP", "BCB", 'I', materialStainlessTitatium, 'c', GTCXBlocks.industrialBlastFurnace, 'P', pipe, 'M', "machineBlockVeryAdvanced", 'C', "circuitElite", 'B', Blocks.BRICK_BLOCK);
        recipes.addRecipe(GTMaterialGen.get(GTCXBlocks.primitiveBlastFurnace), "PBP", "BWB", "PBP", 'B', Blocks.BRICK_BLOCK, 'P', "plateBronze", 'W', "craftingToolWrench");
        recipes.addRecipe(GTMaterialGen.get(GTCXBlocks.alloyFurnace), "CCC", "FHF", "CCC", 'C', Blocks.BRICK_BLOCK, 'F', Blocks.FURNACE, 'H', Blocks.HOPPER);
        recipes.addRecipe(GTMaterialGen.get(GTCXBlocks.casingStandard, 4), "III", "CBC", "III", 'I', RecipeHelper.refinedIron, 'C', "circuitBasic", 'B', "machineBlockCheap");
        recipes.addRecipe(GTMaterialGen.get(GTCXBlocks.casingReinforced, 4), "III", "CMC", "III", 'I', RecipeHelper.materialSteelsAluminium, 'C', "circuitAdvanced", 'M', "machineBlockAdvanced");
        recipes.addRecipe(GTMaterialGen.get(GTCXBlocks.casingAdvanced, 4), "III", "CBC", "III", 'I', RecipeHelper.chrome, 'C', "circuitData", 'B', "machineBlockElite");
        recipes.addRecipe(GTMaterialGen.get(GTCXBlocks.fireBrickBlock, 2), "PPP", "BHB", "PPP", 'P', "plateBronze", 'B', Blocks.BRICK_BLOCK, 'H', "craftingToolForgeHammer");
        recipes.addRecipe(GTMaterialGen.get(GTCXBlocks.dieselGenerator), "PPP", "P P", "CGC", 'P', RecipeHelper.materialMachine, 'C', "circuitBasic", 'G', Ic2Items.generator);
        recipes.addRecipe(GTMaterialGen.get(GTCXBlocks.gasTurbine), "PCP", "WGW", "PCP", 'P', RecipeHelper.materialInvarAluminium, 'C', "circuitAdvanced", 'W', Ic2Items.windMill, 'G', RecipeHelper.reinforcedGlass);
        IRecipeInput aluiron = new RecipeInputCombined(1, GTCXHelperStack.input(RecipeHelper.refinedIron), RecipeHelper.aluminium);
        IRecipeInput rodAluiron = new RecipeInputCombined(1, GTCXHelperStack.input("rodAluminium"), GTCXHelperStack.input("rodAluminum"),  GTCXHelperStack.input("rodRefinedIron"));
        recipes.addRecipe(GTMaterialGen.get(GTCXBlocks.locker), "RLR", "LCL", "PMP", colorTransfer(GTMaterialGen.get(GTBlocks.tileCabinet)), 'R', rodAluiron, 'L', Items.LEATHER, 'C', GTBlocks.tileCabinet, 'P', aluiron, 'M', "machineBlockCheap");
        recipes.addRecipe(GTMaterialGen.get(GTCXBlocks.electricLocker), "SLS", "SlS", "SCS", colorTransfer(GTMaterialGen.get(GTCXBlocks.locker)), 'S', RecipeHelper.materialSteels, 'L', Ic2Items.lapotronCrystal, 'l', GTCXBlocks.locker, 'C', "circuitAdvanced");
        recipes.addRecipe(GTMaterialGen.get(GTCXBlocks.advancedWorktable), "EOE", "EWE", "ECE", colorTransfer(GTMaterialGen.get(GTBlocks.tileWorktable)), 'E', RecipeHelper.electrum, 'O', RecipeHelper.tier2Energy, 'W', GTBlocks.tileWorktable, 'C', "circuitAdvanced");
        recipes.addRecipe(GTMaterialGen.get(GTCXBlocks.dustBin), "IHI", "IWI", "IHI", colorTransfer(GTMaterialGen.get(GTBlocks.tileWorktable)), 'I', RecipeHelper.materialRefinedIron, 'H', Blocks.HOPPER, 'W', GTBlocks.tileWorktable);
    }

    public static void initShapelessRecipes(){
        FluidStack water = new FluidStack(FluidRegistry.WATER, 1000);
        recipes.addShapelessRecipe(GTMaterialGen.getIc2(Ic2Items.fertilizer, 3), Ic2Items.fertilizer, "dustSulfur", GTMaterialGen.getTube(GTMaterial.Calcium, 1));
        recipes.addShapelessRecipe(GTMaterialGen.getIc2(Ic2Items.fertilizer, 2), Ic2Items.fertilizer, "dustAshes", "dustAshes", "dustAshes");
        recipes.addShapelessRecipe(GTMaterialGen.getIc2(Ic2Items.fertilizer, 2), Ic2Items.fertilizer, "dustDarkAshes");
        recipes.addShapelessRecipe(GTMaterialGen.get(GTCXItems.fireClayBall, 2), Items.CLAY_BALL, "sand", "dustFlint", water);
        IRecipeInput ashes = new RecipeInputCombined(1, GTCXHelperStack.input("dustAshes"), GTCXHelperStack.input("dustAsh"));
        recipes.addShapelessRecipe(new ItemStack(Items.IRON_INGOT, 1), "ingotRefinedIron", ashes);
        recipes.addShapelessRecipe(GTMaterialGen.get(GTCXItems.magicDye), "dyeCyan", "dyeMagenta", "dyeYellow", "dyeBlack");
    }

    public static void initOverrideGTClassic(){
//        if (GTConfig.removeIC2Plasmafier){
//            recipes.overrideRecipe("shaped_tile.blockPlasmafier_679353211", GTMaterialGen.get(GEBlocks.fusionReactor, 1), "ESE", "LCL", "ESE", 'E', "circuitMaster", 'S', GTBlocks.tileSupercondensator, 'L',
//                    "batteryUltimate", 'C', GTBlocks.tileComputer);
//        } else {
//            instance.overrideGTRecipe("shaped_tile.gtclassic.fusionreactor_1659066354",GTMaterialGen.get(GEBlocks.fusionReactor, 1), "ESE", "LCL", "ESE", 'E', "circuitMaster", 'S', GTBlocks.tileSupercondensator, 'L',
//                    "batteryUltimate", 'C', GTBlocks.tileComputer);
//        }
        recipes.addRecipe(GTMaterialGen.get(GTBlocks.dataCable, 6), "RRR", "CIC", "RRR", 'I', "plateSilicon", 'C', "circuitData", 'R', "itemRubber");
        recipes.addRecipe(GTMaterialGen.get(GTBlocks.tileDigitizerItem, 4), "CPC", "PMP", "CPC", 'P', GTCXItems.pumpModule, 'C', "circuitData", 'M', "machineBlockAdvanced");
        recipes.addRecipe(GTMaterialGen.get(GTBlocks.tileDigitizerFluid, 4), "CPC", "PMP", "CPC", 'P', GTCXItems.conveyorModule, 'C', "circuitData", 'M', "machineBlockAdvanced");
        recipes.addRecipe(GTMaterialGen.get(GTBlocks.tileReconstructorItem, 4),"PIP", "CMC", "PIP", 'P', GTCXItems.pumpModule, 'C', "circuitData", 'M', "machineBlockAdvanced",'I' , RecipeHelper.plateDigital);
        recipes.addRecipe(GTMaterialGen.get(GTBlocks.tileReconstructorFluid, 4),"PIP", "CMC", "PIP", 'P', GTCXItems.conveyorModule, 'C', "circuitData", 'M', "machineBlockAdvanced",'I' , RecipeHelper.plateDigital);
        recipes.addRecipe(GTMaterialGen.get(GTBlocks.tileQuantumChest), "DCD", "HTH", "DdD", 'D', GTItems.orbData, 'C', GTCXItems.computerMonitor, 'H', "machineBlockElite", 'T', Ic2Items.teleporter, 'd', GTBlocks.tileDigitalChest);
        recipes.addRecipe(GTMaterialGen.get(GTBlocks.tileDigitalChest), "III", "SDS", "ICI", 'I', RecipeHelper.materialDigital, 'S', Items.SHULKER_SHELL, 'D', GTItems.orbData, 'C', GTBlocks.tileComputer);
        recipes.addRecipe( GTMaterialGen.get(GTBlocks.tileQuantumTank), "IBI", "CQC", "IBI", 'I', RecipeHelper.materialDigital, 'B', Items.BUCKET, 'C', "circuitMaster", 'Q', GTBlocks.tileQuantumChest);
        recipes.addRecipe( GTMaterialGen.get(GTBlocks.tileComputer), "CMO", "MAM", "OMC", 'C', "circuitMaster", 'M', GTCXItems.computerMonitor, 'O', "circuitUltimate", 'A', "machineBlockAdvanced");
        recipes.addRecipe( GTMaterialGen.get(GTBlocks.casingFusion), "CSC", "NMN", "CRC", 'C', "circuitMaster", 'S', "craftingSuperconductor", 'N', GTCXItems.nichromeHeatingCoil, 'M',
                "machineBlockElite", 'R', Ic2Items.reactorReflectorIridium);
        IRecipeInput rod = new RecipeInputCombined(1, GTCXHelperStack.input("rodTitanium", 1), GTCXHelperStack.input("rodTungstensteel", 1));
        IRecipeInput plate = new RecipeInputCombined(1, GTCXHelperStack.input(RecipeHelper.titanium, 1), GTCXHelperStack.input(RecipeHelper.tungstenSteel, 1));
        recipes.addRecipe(GTMaterialGen.get(GTItems.rockCutter), "DR ", "DT ", "DCB", new EnchantmentModifier(GTMaterialGen.get(GTItems.rockCutter), Enchantments.SILK_TOUCH).setUsesInput(), 'R', rod, 'T', plate, 'B', Ic2Items.battery, 'C', "circuitBasic", 'D', "dustDiamond");
        recipes.addRecipe(GTMaterialGen.get(GTItems.jackHammer), "TJT", " D ", 'T', "rodTungstensteel", 'J', GTCXItems.steelJackhammer, 'C', "circuitBasic", 'D', "dustDiamond");
        recipes.addRecipe(GTMaterialGen.get(GTItems.lithiumBattery), " C ", "ALA", "ALA", 'C', Ic2Items.goldCable, 'A', RecipeHelper.aluminium, 'L', "dustLithium");
        recipes.addRecipe(GTMaterialGen.get(GTItems.lithiumBatpack), "BCB", "BAB", "B B", 'B', GTItems.lithiumBattery, 'C', "circuitAdvanced", 'A', RecipeHelper.aluminium);
        recipes.addRecipe(GTMaterialGen.get(GTItems.portableScanner), "AEA", "CcC", "ABA", 'A', RecipeHelper.aluminium, 'E', Ic2Items.euReader, 'C', "circuitAdvanced", 'c', Ic2Items.cropAnalyzer, 'B', GTItems.lithiumBattery);
        recipes.addRecipe(GTMaterialGen.get(GTBlocks.casingHighlyAdvanced), "CTC", "TMT", "CTC", 'C', RecipeHelper.chrome, 'T', RecipeHelper.titanium, 'M', "machineBlockAdvanced");
        recipes.addRecipe(GTMaterialGen.get(GTBlocks.casingHighlyAdvanced), "TCT", "CMC", "TCT", 'C', RecipeHelper.chrome, 'T', RecipeHelper.titanium, 'M', "machineBlockAdvanced");
        recipes.addRecipe(GTMaterialGen.getIc2(Ic2Items.mixedMetalIngot, 3), "TTT", "MMM", "BBB", 'T', RecipeHelper.materialRefinedIron, 'M', RecipeHelper.materialBrassBronze, 'B', RecipeHelper.materialMixedMetal1);
        recipes.addRecipe(GTMaterialGen.getIc2(Ic2Items.mixedMetalIngot, 6), "TTT", "MMM", "BBB", 'T', RecipeHelper.materialMixedMetal2, 'M', RecipeHelper.materialBrassBronze, 'B', RecipeHelper.materialMixedMetal1);
        recipes.addRecipe(GTMaterialGen.getIc2(Ic2Items.mixedMetalIngot, 8), "TTT", "MMM", "BBB", 'T', RecipeHelper.tungstenSteel, 'M', RecipeHelper.materialBrassBronze, 'B', RecipeHelper.materialMixedMetal1);
        recipes.addRecipe(Ic2Items.reactorVent, "PBP", "B B", "PBP", 'P', RecipeHelper.aluminium, 'B', Blocks.IRON_BARS);
        recipes.addRecipe(GTMaterialGen.get(GTBlocks.tileTranslocator), "EWE", "CBC", "EME", 'E', RecipeHelper.electrum, 'W', Ic2Items.insulatedCopperCable, 'C', "circuitBasic", 'B', "machineBlockCheap", 'M', GTCXItems.conveyorModule);
        recipes.addRecipe(GTMaterialGen.get(GTBlocks.tileBufferLarge), "EWE", "CBC", "EcE", 'E', RecipeHelper.electrum, 'W', Ic2Items.insulatedCopperCable, 'C', "circuitAdvanced", 'B', "machineBlockCheap", 'c', "chestWood");
        recipes.addRecipe(GTMaterialGen.get(GTBlocks.tileBufferFluid), "EWE", "CBC", "EbE", 'E', RecipeHelper.electrum, 'W', Ic2Items.insulatedCopperCable, 'C', "circuitAdvanced", 'B', "machineBlockCheap", 'b', Items.BUCKET);
        IRecipeInput aluiron = new RecipeInputCombined(1, GTCXHelperStack.input(RecipeHelper.refinedIron), RecipeHelper.aluminium);
        recipes.addRecipe(GTMaterialGen.get(GTBlocks.tileCabinet), "III", "CIC", "III", 'I', aluiron, 'C', "chestWood");
        IRecipeInput wrench = GTCXConfiguration.general.enableCraftingTools ? new RecipeInputCombined(1, GTCXHelperStack.input("craftingToolMonkeyWrench"), GTCXHelperStack.input("craftingToolWrench")) : new RecipeInputOreDict("rodRefinedIron");
        rod = GTCXConfiguration.general.enableCraftingTools ? new RecipeInputOreDict("rodRefinedIron") : null;
        recipes.addRecipe(GTMaterialGen.get(GTBlocks.tileDrum), "PWP", "PMP", "PRP", 'P', RecipeHelper.refinedIron, 'W', wrench, 'M', rod, 'R', "rodRefinedIron");
        recipes.addRecipe(GTMaterialGen.get(GTBlocks.tileWorktable), "ICI", "III", "IcI", 'I', aluiron, 'C', "workbench", 'c', "chestWood");
        recipes.addRecipe(GTMaterialGen.get(GTBlocks.tileAutocrafter), "EBE", "CcC", "EME", 'E', RecipeHelper.electrum, 'B', Ic2Items.battery, 'C', "circuitAdvanced", 'c', "workbench", 'M', "machineBlockAdvanced");
        recipes.addRecipe(GTMaterialGen.get(GTBlocks.tileTranslocatorFluid), "EWE", "CBC", "EME", 'E', RecipeHelper.electrum, 'W', Ic2Items.insulatedCopperCable, 'C', "circuitBasic", 'B', "machineBlockCheap", 'M', Ic2Items.basicFluidImportUpgrade);
        ItemStack top = GTConfig.modcompat.compatTwilightForest && Loader.isModLoaded(GTValues.MOD_ID_TFOREST)
                ? GTMaterialGen.getModItem(GTValues.MOD_ID_TFOREST, "uncrafting_table")
                : GTMaterialGen.getIc2(Ic2Items.extractor);
        recipes.addRecipe(GTMaterialGen.get(GTBlocks.tileDisassembler, 1), "RAR", "ECE", "RWR", 'A', top,
                'W', GTCXBlocks.assemblingMachine, 'R', RecipeHelper.materialRefinedIron, 'E', Ic2Items.insulatedCopperCable.copy(), 'C', "circuitAdvanced" );
        /** Fusion Computer **/ //since I'll be adding my own fusion in the future
        if (GTConfig.general.removeIC2Plasmafier) {
            recipes.overrideRecipe("shaped_tile.blockPlasmafier_679353211", GTMaterialGen.get(GTBlocks.tileFusionReactor, 1), "ESE", "LCL", "ESE", 'E', "circuitMaster", 'S', GTBlocks.tileSupercondensator, 'L',
                    "batteryUltimate", 'C', GTBlocks.tileComputer);
        } else {
            recipes.addRecipe(GTMaterialGen.get(GTBlocks.tileFusionReactor, 1), "ESE", "LCL", "ESE", 'E',
                    "circuitMaster", 'S', "craftingSuperconductor", 'L', "batteryUltimate", 'C',
                    GTBlocks.tileComputer);
        }
        recipes.addRecipe(GTMaterialGen.get(GTBlocks.tileCentrifuge), "RCR", "MEM", "RCR", 'R', "plateStainlessSteel", 'C', "circuitAdvanced", 'M', "machineBlockAdvanced", 'E', Ic2Items.extractor);
    }

    public void overrideGTRecipe(String recipeId, ItemStack output, Object... input) {
        GTRecipeCraftingHandler.overrideGTRecipe("gtclassic", recipeId, output, input);
    }

    public void overrideShapelessGTRecipe(String recipeId, ItemStack output, Object... input){
        GTRecipeCraftingHandler.overrideShapelessGTRecipe("gtclassic", recipeId, output, input);
    }

    public void removeGTRecipe(String recipeId){
        GTRecipeCraftingHandler.removeRecipe("gtclassic", recipeId);
    }
}
