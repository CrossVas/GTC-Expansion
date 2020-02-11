package gtc_expansion.recipes;

import gtc_expansion.GTCXConfiguration;
import gtclassic.api.helpers.GTHelperStack;
import gtclassic.api.helpers.GTValues;
import gtclassic.api.material.GTMaterial;
import gtclassic.api.material.GTMaterialGen;
import gtclassic.api.recipe.GTRecipeMachineHandler;
import gtclassic.api.tile.GTTileBaseMachine;
import gtclassic.common.GTConfig;
import gtclassic.common.tile.GTTileCentrifuge;
import ic2.api.classic.recipe.ClassicRecipes;
import ic2.core.platform.registry.Ic2Items;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Loader;

public class GTCXRecipeRemove {

    public static void init(){
        initCentrifugeRemoval();
        initIc2Removals();
        if (GTCXConfiguration.general.unfiredBricks){
            GTHelperStack.removeSmelting(new ItemStack(Items.BRICK));
        }
        removeFurnaceRecipes();
    }

    public static void initIc2Removals(){
        ClassicRecipes.compressor.removeRecipe(GTTileBaseMachine.input("dustRuby", 1));
        ClassicRecipes.compressor.removeRecipe(GTTileBaseMachine.input("dustSapphire", 1));
        ClassicRecipes.compressor.removeRecipe(GTTileBaseMachine.input("dustGreenSapphire", 1));
        ClassicRecipes.compressor.removeRecipe(GTTileBaseMachine.input("dustOlivine", 1));
        ClassicRecipes.compressor.removeRecipe(GTTileBaseMachine.input("dustRedGarnet", 1));
        ClassicRecipes.compressor.removeRecipe(GTTileBaseMachine.input("dustYellowGarnet", 1));
        ClassicRecipes.compressor.removeRecipe(GTTileBaseMachine.input("dustCarbon", 8));
        ClassicRecipes.compressor.removeRecipe(GTTileBaseMachine.input(Ic2Items.coalChunk));

        ClassicRecipes.macerator.removeRecipe(GTTileBaseMachine.input("oreRedstone", 1));
        if (GTCXConfiguration.general.usePlates && (!Loader.isModLoaded(GTValues.MOD_ID_IC2_EXTRAS) || !GTConfig.modcompat.compatIc2Extras)){
            ClassicRecipes.compressor.removeRecipe(GTTileBaseMachine.input("ingotCopper", 8));
        }

        ClassicRecipes.fluidGenerator.getBurnMap().remove(GTMaterialGen.getFluid(GTMaterial.Methane));
        ClassicRecipes.fluidGenerator.getBurnMap().remove(GTMaterialGen.getFluid(GTMaterial.Hydrogen));
    }

    public static void initCentrifugeRemoval(){
        GTTileCentrifuge.RECIPE_LIST.startMassChange();
        removeCentrifugeRecipe("item.gtclassic.test_tube_1");
        removeCentrifugeRecipe("item.itemCellEmpty");
        removeCentrifugeRecipe("item.itemCellEmpty_1");
        removeCentrifugeRecipe("item.gtclassic.dustCarbon");
        removeCentrifugeRecipe("item.gtclassic.dustAluminium");
        removeCentrifugeRecipe("item.gtclassic.dustAluminium_1");
        removeCentrifugeRecipe("item.itemDustIron");
        removeCentrifugeRecipe("item.itemDustIron_1");
        removeCentrifugeRecipe("item.gtclassic.test_tube_8");
        removeCentrifugeRecipe("item.gtclassic.test_tube_9");
        removeCentrifugeRecipe("item.gtclassic.test_tube_10");
        removeCentrifugeRecipe("item.gtclassic.test_tube_11");
        removeCentrifugeRecipe("item.gtclassic.test_tube_12");
        removeCentrifugeRecipe("item.gtclassic.test_tube_13");
        removeCentrifugeRecipe("item.itemDustCoal");
        removeCentrifugeRecipe("item.gtclassic.dustSilicon");
        removeCentrifugeRecipe("item.gtclassic.dustSilicon_1");
        removeCentrifugeRecipe("item.gtclassic.dustSilicon_2");
        removeCentrifugeRecipe("item.gtclassic.dustSilicon_3");
        removeCentrifugeRecipe("item.gtclassic.dustLithium");
        GTTileCentrifuge.RECIPE_LIST.finishMassChange();
    }

    public static void removeFurnaceRecipes(){
        if (GTCXConfiguration.general.removeVanillaCharcoalRecipe) {
            GTHelperStack.removeSmelting(new ItemStack(Items.COAL, 1, 1));

        }
    }
    
    public static void removeModRecipes() {
    	String[] vanillaPlanksType = { "oak_", "spruce_", "birch_", "jungle_", "acacia_", "dark_oak_" };
    	String[] forestryPlanksType = { "_larch", "_teak", "_acacia", "_lime", "_chestnut", "_wenge", "_baobab", "_sequoia", "_kapok", "_ebony", "_mahogany", "_balsa", "_willow", "_walnut", "_greenheart", "_cherry", "_mahoe", "_poplar", "_palm", "_papaya", "_pine", "_plum", "_maple", "_citrus", "_giganteum", "_ipe", "_padauk", "_cocobolo", "_zebrawood", "_oak", "_spruce", "_birch", "_jungle", "_acacia", "_dark_oak" };
    	String[] twilightPlanksType = { "wood/twilight_oak_", "wood/canopy_", "wood/mangrove_", "wood/darkwood_", "wood/time_", "wood/trans_", "wood/mine_", "wood/sort_" }; 
    	String orePlank = "planks";
    	String fireProof = "fireproof_";
    		for (int i = 0; i < vanillaPlanksType.length; i++) {
    	    	GTCXHelperStack.removeModRecipe("minecraft", vanillaPlanksType[i] + orePlank);	
    		}
    		for (int i = 0; i < forestryPlanksType.length; i++) {
    			GTCXHelperStack.removeModRecipe("forestry", orePlank + forestryPlanksType[i]);
    		}
    		for (int i = 0; i < forestryPlanksType.length; i++) {
    			GTCXHelperStack.removeModRecipe("forestry", fireProof + orePlank + forestryPlanksType[i]);
    		}
    		for (int i = 0; i < twilightPlanksType.length; i++) {
    			GTCXHelperStack.removeModRecipe("twilightforest", twilightPlanksType[i] + orePlank);
    		}
    		GTCXHelperStack.removeModRecipe("minecraft", "stick");
    }

    public static void removeCentrifugeRecipe(String id){
        GTRecipeMachineHandler.removeRecipe(GTTileCentrifuge.RECIPE_LIST, id);
    }
}
