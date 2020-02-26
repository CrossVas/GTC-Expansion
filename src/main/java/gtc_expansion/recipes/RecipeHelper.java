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
    static IRecipeInput materialBrassBronze = GTCXConfiguration.general.usePlates ? plateBrassBronze : ingotBrassBronze;
    static IRecipeInput ingotTinZinc = new RecipeInputCombined(1, GTCXHelperStack.input("ingotZinc"), GTCXHelperStack.input("ingotTin"));
    static IRecipeInput plateTinZinc = new RecipeInputCombined(1, GTCXHelperStack.input("plateZinc"), GTCXHelperStack.input("plateTin"));
    static IRecipeInput materialTinZinc = GTCXConfiguration.general.usePlates ? plateTinZinc : ingotTinZinc;
    static IRecipeInput ingotInvarAluminium = new RecipeInputCombined(1, GTCXHelperStack.input("ingotInvar"), GTCXHelperStack.input("ingotAluminium"));
    static IRecipeInput plateInvarAluminium = new RecipeInputCombined(1, GTCXHelperStack.input("plateInvar"), GTCXHelperStack.input("plateAluminium"));
    static IRecipeInput materialInvarAluminium = GTCXConfiguration.general.usePlates ? plateInvarAluminium : ingotInvarAluminium;
    static IRecipeInput ingotMixedMetal1 = new RecipeInputCombined(1, GTCXHelperStack.input("ingotAluminium"), GTCXHelperStack.input("ingotSilver"), GTCXHelperStack.input("ingotElectrum"));
    static IRecipeInput plateMixedMetal1 = new RecipeInputCombined(1, GTCXHelperStack.input("plateAluminium"), GTCXHelperStack.input("plateSilver"), GTCXHelperStack.input("plateElectrum"));
    static IRecipeInput materialMixedMetal1 = GTCXConfiguration.general.usePlates ? plateMixedMetal1 : ingotMixedMetal1;
    static IRecipeInput ingotMixedMetal2 = new RecipeInputCombined(1, GTCXHelperStack.input("ingotTungsten"), GTCXHelperStack.input("ingotTitanium"));
    static IRecipeInput plateMixedMetal2 = new RecipeInputCombined(1, GTCXHelperStack.input("plateTungsten"), GTCXHelperStack.input("plateTitanium"));
    static IRecipeInput materialMixedMetal2 = GTCXConfiguration.general.usePlates ? plateMixedMetal2 : ingotMixedMetal2;
    static String materialRefinedIron = GTCXConfiguration.general.usePlates ? GTCXHelperStack.getRefinedIronPlate() : ingotRefinedIron;
    public static IRecipeInput materialMachine = GTCXConfiguration.general.usePlates ? plateMachine : ingotMachine;
    static IRecipeInput materialSteels = GTCXConfiguration.general.usePlates ? plateSteels : ingotSteels;
    static IRecipeInput materialSteelsAluminium = GTCXConfiguration.general.usePlates ? plateSteelsAluminium : ingotSteelsAluminium;
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
    static IRecipeInput materialDigital = GTCXConfiguration.general.usePlates ? plateDigital : ingotDigital;

    static String steel = GTCXConfiguration.general.usePlates ? "plateSteel" : "ingotSteel";
    static String stainlessSteel = GTCXConfiguration.general.usePlates ? "plateStainlessSteel" : "ingotStainlessSteel";
    static String tungsten = GTCXConfiguration.general.usePlates ? "plateTungsten" : "ingotTungsten";
    static String tungstenSteel = GTCXConfiguration.general.usePlates ? "plateTungstensteel" : "ingotTungstensteel";
    static IRecipeInput aluminium = GTCXConfiguration.general.usePlates ? new RecipeInputCombined(1, GTCXHelperStack.input("plateAluminium"), GTCXHelperStack.input("plateAluminum")) : new RecipeInputCombined(1, GTCXHelperStack.input("ingotAluminium"), GTCXHelperStack.input("ingotAluminum")) ;
    static String titanium = GTCXConfiguration.general.usePlates ? "plateTitanium" : "ingotTitanium";
    static String platinum = GTCXConfiguration.general.usePlates ? "platePlatinum" : "ingotPlatinum";
    static String electrum = GTCXConfiguration.general.usePlates ? "plateElectrum" : "ingotElectrum";
    static String chrome = GTCXConfiguration.general.usePlates ? "plateChrome" : "ingotChrome";
    static String tin = GTCXConfiguration.general.usePlates ? "plateTin" : "ingotTin";
    static String copper = GTCXConfiguration.general.usePlates ? "plateCopper" : "ingotCopper";
    static String bronze = GTCXConfiguration.general.usePlates ? "plateBronze" : "ingotBronze";
    static String brass = GTCXConfiguration.general.usePlates ? "plateBrass" : "ingotBrass";
    static String refinedIron = GTCXConfiguration.general.usePlates ? "plateRefinedIron" : "ingotRefinedIron";
    static String lead = GTCXConfiguration.general.usePlates ? "plateLead" : "ingotLead";

}
