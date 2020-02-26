package gtc_expansion.recipes;

import gtc_expansion.GTCXConfiguration;
import gtc_expansion.GTCXItems;
import gtc_expansion.util.GTCXHelperStack;
import gtclassic.api.material.GTMaterialGen;
import gtclassic.api.tile.GTTileBaseMachine;
import gtclassic.common.GTItems;
import ic2.api.recipe.IRecipeInput;
import ic2.core.IC2;
import ic2.core.item.recipe.entry.RecipeInputCombined;
import ic2.core.item.recipe.entry.RecipeInputItemStack;
import ic2.core.platform.registry.Ic2Items;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class RecipeHelper {
	
	/** Ingredients **/
	
    static String ingotRefinedIron = IC2.getRefinedIron();
    static IRecipeInput ingotMachine = new RecipeInputCombined(1, GTCXHelperStack.input(ingotRefinedIron), GTCXHelperStack.input("ingotAluminium"), GTCXHelperStack.input("ingotAluminum"));
    public static IRecipeInput plateMachine = new RecipeInputCombined(1, GTCXHelperStack.input(GTCXHelperStack.getRefinedIronPlate()), GTCXHelperStack.input("plateAluminium"), GTCXHelperStack.input("plateAluminum"));
    static IRecipeInput ingotSteels = new RecipeInputCombined(1, GTCXHelperStack.input("ingotSteel"), GTCXHelperStack.input("ingotStainlessSteel"));
    public static IRecipeInput plateSteels = new RecipeInputCombined(1, GTCXHelperStack.input("plateSteel"), GTCXHelperStack.input("plateStainlessSteel"));
    static IRecipeInput rodSteels = new RecipeInputCombined(1, GTCXHelperStack.input("rodSteel"), GTCXHelperStack.input("rodStainlessSteel"));
    static IRecipeInput ingotSteelsAluminium = new RecipeInputCombined(1, GTCXHelperStack.input("ingotSteel"), GTCXHelperStack.input("ingotStainlessSteel"), GTCXHelperStack.input("ingotAluminium"), GTCXHelperStack.input("ingotAluminum"));
    public static IRecipeInput plateSteelsAluminium = new RecipeInputCombined(1, GTCXHelperStack.input("plateSteel"), GTCXHelperStack.input("plateStainlessSteel"), GTCXHelperStack.input("plateAluminium"), GTCXHelperStack.input("plateAluminum"));
    static IRecipeInput ingotBrassBronze = new RecipeInputCombined(1, GTCXHelperStack.input("ingotBronze"), GTCXHelperStack.input("ingotBrass"));
    static IRecipeInput plateBrassBronze = new RecipeInputCombined(1, GTCXHelperStack.input("plateBronze"), GTCXHelperStack.input("plateBrass"));
    static IRecipeInput materialBrassBronze = plateBrassBronze;
    static IRecipeInput ingotTinZinc = new RecipeInputCombined(1, GTCXHelperStack.input("ingotZinc"), GTCXHelperStack.input("ingotTin"));
    static IRecipeInput plateTinZinc = new RecipeInputCombined(1, GTCXHelperStack.input("plateZinc"), GTCXHelperStack.input("plateTin"));
    static IRecipeInput materialTinZinc = plateTinZinc;
    static IRecipeInput ingotInvarAluminium = new RecipeInputCombined(1, GTCXHelperStack.input("ingotInvar"), GTCXHelperStack.input("ingotAluminium"));
    static IRecipeInput plateInvarAluminium = new RecipeInputCombined(1, GTCXHelperStack.input("plateInvar"), GTCXHelperStack.input("plateAluminium"));
    static IRecipeInput materialInvarAluminium = plateInvarAluminium;
    static IRecipeInput ingotMixedMetal1 = new RecipeInputCombined(1, GTCXHelperStack.input("ingotAluminium"), GTCXHelperStack.input("ingotSilver"), GTCXHelperStack.input("ingotElectrum"));
    static IRecipeInput plateMixedMetal1 = new RecipeInputCombined(1, GTCXHelperStack.input("plateAluminium"), GTCXHelperStack.input("plateSilver"), GTCXHelperStack.input("plateElectrum"));
    static IRecipeInput materialMixedMetal1 = plateMixedMetal1;
    static IRecipeInput ingotMixedMetal2 = new RecipeInputCombined(1, GTCXHelperStack.input("ingotTungsten"), GTCXHelperStack.input("ingotTitanium"));
    static IRecipeInput plateMixedMetal2 = new RecipeInputCombined(1, GTCXHelperStack.input("plateTungsten"), GTCXHelperStack.input("plateTitanium"));
    static IRecipeInput materialMixedMetal2 = plateMixedMetal2;
    static String materialRefinedIron = GTCXHelperStack.getRefinedIronPlate();
    public static IRecipeInput materialMachine = plateMachine;
    static IRecipeInput materialSteels = plateSteels;
    static IRecipeInput materialSteelsAluminium = plateSteelsAluminium;
    static IRecipeInput anyPiston = new RecipeInputCombined(1, new RecipeInputItemStack(GTMaterialGen.get(Blocks.STICKY_PISTON)), new RecipeInputItemStack(GTMaterialGen.get(Blocks.PISTON)));

    static IRecipeInput plateElectric = new RecipeInputCombined(1, GTCXHelperStack.input(GTCXHelperStack.getRefinedIronPlate()), GTCXHelperStack.input("plateSilicon"),
    		GTCXHelperStack.input("plateAluminium"), GTCXHelperStack.input("plateSilver"),
    		GTCXHelperStack.input("plateElectrum"), GTCXHelperStack.input("platePlatinum"));
    public static IRecipeInput anyLapis = new RecipeInputCombined(1, GTCXHelperStack.input("gemLapis"),
    		GTCXHelperStack.input("dustLazurite"), GTCXHelperStack.input("dustSodalite"));
    static IRecipeInput reinforcedGlass = new RecipeInputCombined(1, new RecipeInputItemStack(Ic2Items.reinforcedGlass), new RecipeInputItemStack(Ic2Items.reinforcedGlassClear));
    static IRecipeInput grinder = new RecipeInputCombined(1, new RecipeInputItemStack(GTMaterialGen.get(GTCXItems.diamondGrinder)), new RecipeInputItemStack(GTMaterialGen.get(GTCXItems.wolframiumGrinder)));
    static IRecipeInput tier2Energy = new RecipeInputCombined(1, new RecipeInputItemStack(Ic2Items.energyCrystal), new RecipeInputItemStack(GTMaterialGen.get(GTItems.lithiumBattery)));
    static IRecipeInput ingotDigital = new RecipeInputCombined(1, GTCXHelperStack.input("ingotChrome"), GTCXHelperStack.input("ingotTitanium"), GTCXHelperStack.input("ingotPlatinum"));
    static IRecipeInput plateDigital = new RecipeInputCombined(1, GTCXHelperStack.input("plateChrome"), GTCXHelperStack.input("plateTitanium"), GTCXHelperStack.input("platePlatinum"));
    static IRecipeInput materialDigital = plateDigital;

    static String steel = "plateSteel";
    static String stainlessSteel = "plateStainlessSteel";
    static String tungsten = "plateTungsten";
    static String tungstenSteel = "plateTungstensteel";
    static IRecipeInput aluminium = new RecipeInputCombined(1, GTCXHelperStack.input("plateAluminium"), GTCXHelperStack.input("plateAluminum")) ;
    static String titanium = "plateTitanium";
    static String platinum = "platePlatinum";
    static String electrum = "plateElectrum";
    static String chrome = "plateChrome";
    static String tin = "plateTin";
    static String copper = "plateCopper";
    static String bronze = "plateBronze";
    static String brass = "plateBrass";
    static String refinedIron = "plateRefinedIron";
    static String lead = "plateLead";

}
