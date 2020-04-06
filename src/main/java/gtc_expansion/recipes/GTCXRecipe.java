package gtc_expansion.recipes;

import gtc_expansion.GTCXConfiguration;
import gtc_expansion.material.GTCXMaterialGen;
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
import gtc_expansion.tile.GTCXTileStoneCompressor;
import gtc_expansion.tile.GTCXTileStoneExtractor;
import gtc_expansion.tile.GTCXTileWiremill;
import gtc_expansion.tile.multi.GTCXTileMultiDistillationTower;
import gtc_expansion.tile.multi.GTCXTileMultiImplosionCompressor;
import gtc_expansion.tile.multi.GTCXTileMultiIndustrialBlastFurnace;
import gtc_expansion.tile.multi.GTCXTileMultiIndustrialGrinder;
import gtc_expansion.tile.multi.GTCXTileMultiPrimitiveBlastFurnace;
import gtc_expansion.tile.multi.GTCXTileMultiVacuumFreezer;
import gtc_expansion.util.GTCXIc2cECompat;
import gtclassic.api.helpers.GTValues;
import gtclassic.api.material.GTMaterial;
import gtclassic.api.material.GTMaterialGen;
import gtclassic.api.recipe.GTRecipeCraftingHandler;
import gtclassic.api.recipe.GTRecipeMachineHandler;
import gtclassic.common.tile.GTTileCentrifuge;
import ic2.api.classic.recipe.ClassicRecipes;
import ic2.api.classic.recipe.RecipeModifierHelpers;
import ic2.api.classic.recipe.crafting.ICraftingRecipeList;
import ic2.core.block.machine.low.TileEntityMacerator;
import ic2.core.util.misc.StackUtil;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

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
        GTCXRecipeIterators.init();
    }

    public static void postInit() {
        if (GTCXConfiguration.general.planksNeedSaw) {
            GTCXRecipeIterators.createOreDictPlanksRecipe();
            GTCXRecipeIterators.createStickRecipe();
        }

        GTCXRecipeIterators.initAutoOredictMachineRecipes();
        GTCXTileMicrowave.init();
        GTCXTileStoneCompressor.initRecipes();
        GTCXTileStoneExtractor.initRecipes();
        GTCX_CraftingRecipeLoader.init();
        GTCX_MachineRecipeLoader.init();
    }
    
    public static void overrideGTRecipe(String recipeId, ItemStack output, Object... input) {
        GTRecipeCraftingHandler.overrideGTRecipe("gtclassic", recipeId, output, input);
    }

    public static void overrideShapelessGTRecipe(String recipeId, ItemStack output, Object... input){
        GTRecipeCraftingHandler.overrideShapelessGTRecipe("gtclassic", recipeId, output, input);
    }

    public static void removeGTRecipe(String recipeId){
        GTRecipeCraftingHandler.removeRecipe("gtclassic", recipeId);
    }
    
    public static void addCrushedOreRecipes(GTMaterial main, ItemStack outputWashSide, ItemStack outputThermalSide){
        GTCXIc2cECompat.addOreWashingMachineRecipe("crushed" + main.getDisplayName(), 1, GTCXMaterialGen.getPurifiedCrushedOre(main, 1), outputWashSide, GTMaterialGen.getModItem(GTValues.MOD_ID_IC2_EXTRAS, "stonedust"));
        GTCXIc2cECompat.addThermalCentrifugeRecipe("crushedPurified" + main.getDisplayName(), 1, 400, GTMaterialGen.getDust(main, 1), outputThermalSide);
        GTCXIc2cECompat.addThermalCentrifugeRecipe("crushed" + main.getDisplayName(), 1, 600, GTMaterialGen.getDust(main, 1), outputThermalSide, GTMaterialGen.getModItem(GTValues.MOD_ID_IC2_EXTRAS, "stonedust"));
        TileEntityMacerator.addRecipe("crushed" + main.getDisplayName(), 1, GTMaterialGen.getDust(main, 1));
        TileEntityMacerator.addRecipe("crushedPurified" + main.getDisplayName(), 1, GTMaterialGen.getDust(main, 1));
    }
    
    public static RecipeModifierHelpers.IRecipeModifier[] totalCentrifugeEu(int amount) {
        return GTTileCentrifuge.totalEu(amount);
    }
    
    public static void removeCentrifugeRecipe(String id) {
        GTRecipeMachineHandler.removeRecipe(GTTileCentrifuge.RECIPE_LIST, id);
    }
    
}
