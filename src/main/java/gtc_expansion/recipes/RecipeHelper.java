package gtc_expansion.recipes;

import gtc_expansion.GTCXItems;
import gtc_expansion.util.GTCXHelperStack;
import gtclassic.api.material.GTMaterialGen;
import gtclassic.common.GTItems;
import ic2.api.recipe.IRecipeInput;
import ic2.core.item.recipe.entry.RecipeInputCombined;
import ic2.core.item.recipe.entry.RecipeInputItemStack;
import ic2.core.item.recipe.entry.RecipeInputOreDict;
import ic2.core.platform.registry.Ic2Items;
import net.minecraft.init.Blocks;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

public class RecipeHelper {
	
	/** Plates **/
	
	public static String plateAluminium = "plateAluminium";
	public static String plateAluminum = "plateAluminum";
	public static String plateBatteryAlloy = "plateBatteryAlloy";
    public static String plateBrass = "plateBrass";
    public static String plateBronze = "plateBronze";
    public static String plateChrome = "plateChrome";
    public static String plateCopper = "plateCopper";
    public static String plateElectrum = "plateElectrum";
    public static String plateGold = "plateGold";
    public static String plateInvar = "plateInvar";
    public static String plateIridium = "plateIridium";
    public static String plateIron = "plateIron";
    public static String plateLead = "plateLead";
    public static String plateNickel = "plateNickel";
    public static String platePlatinum = "platePlatinum";
    public static String plateRedAlloy = "plateRedAlloy";
    public static String plateRefinedIron = "plateRefinedIron";
    public static String plateSilicon = "plateSilicon";
    public static String plateSilver = "plateSilver";
    public static String plateStainlessSteel = "plateStainlessSteel";
	public static String plateSteel = "plateSteel";
    public static String plateTechnetium = "plateTechnetium";
    public static String plateTin = "plateTin";
    public static String plateTitanium = "plateTitanium";
    public static String plateTungsten = "plateTungsten";
    public static String plateTungstenSteel = "plateTungstensteel";
    public static String plateZinc = "plateZinc";
    
    public static String stick = "stickWood";

    public static IRecipeInput plateAlums = new RecipeInputCombined(1, GTCXHelperStack.input(plateAluminium), GTCXHelperStack.input(plateAluminum));
    public static IRecipeInput plateBasicMachineBlock = new RecipeInputCombined(1, GTCXHelperStack.input(plateRefinedIron), plateAlums);
    public static IRecipeInput plateBrassBronze = new RecipeInputCombined(1, GTCXHelperStack.input(plateBronze), GTCXHelperStack.input(plateBrass));
    public static IRecipeInput plateInvarAluminium = new RecipeInputCombined(1, GTCXHelperStack.input(plateInvar), plateAlums);
    public static IRecipeInput plateSteels = new RecipeInputCombined(1, GTCXHelperStack.input(plateSteel), GTCXHelperStack.input(plateStainlessSteel));
    public static IRecipeInput plateTinZinc = new RecipeInputCombined(1, GTCXHelperStack.input(plateZinc), GTCXHelperStack.input(plateTin));
    public static IRecipeInput plateDigital = new RecipeInputCombined(1, GTCXHelperStack.input(plateChrome), GTCXHelperStack.input(plateTitanium), GTCXHelperStack.input(platePlatinum));
    public static IRecipeInput plateElectric = new RecipeInputCombined(1, GTCXHelperStack.input(plateRefinedIron), GTCXHelperStack.input(plateSilicon), plateAlums, GTCXHelperStack.input("plateSilver"), GTCXHelperStack.input(plateElectrum), GTCXHelperStack.input(platePlatinum));
    public static IRecipeInput plateAluminiumSilverElectrum = new RecipeInputCombined(1, plateAlums, GTCXHelperStack.input(plateSilver), GTCXHelperStack.input(plateElectrum));
    public static IRecipeInput plateTitanTungsten = new RecipeInputCombined(1, GTCXHelperStack.input(plateTungsten), GTCXHelperStack.input(plateTitanium));
    public static IRecipeInput rodSteels = new RecipeInputCombined(1, GTCXHelperStack.input("rodSteel"), GTCXHelperStack.input("rodStainlessSteel"));
    public static IRecipeInput anyPiston = new RecipeInputCombined(1, new RecipeInputItemStack(GTMaterialGen.get(Blocks.STICKY_PISTON)), new RecipeInputItemStack(GTMaterialGen.get(Blocks.PISTON)));
    public static IRecipeInput anyLapis = new RecipeInputCombined(1, GTCXHelperStack.input("gemLapis"), GTCXHelperStack.input("dustLazurite"), GTCXHelperStack.input("dustSodalite"));
    public static IRecipeInput reinforcedGlass = new RecipeInputCombined(1, new RecipeInputItemStack(Ic2Items.reinforcedGlass), new RecipeInputItemStack(Ic2Items.reinforcedGlassClear));
    public static IRecipeInput grinder = new RecipeInputCombined(1, new RecipeInputItemStack(GTMaterialGen.get(GTCXItems.diamondGrinder)), new RecipeInputItemStack(GTMaterialGen.get(GTCXItems.wolframiumGrinder)));
    public static IRecipeInput tier2Energy = new RecipeInputCombined(1, new RecipeInputItemStack(Ic2Items.energyCrystal), new RecipeInputItemStack(GTMaterialGen.get(GTItems.lithiumBattery)));

    public static FluidStack water = new FluidStack(FluidRegistry.WATER, 1000);
    public static IRecipeInput ashes = new RecipeInputCombined(1, GTCXHelperStack.input("dustAshes"), GTCXHelperStack.input("dustAsh"));
    public static IRecipeInput dustAluminium = new RecipeInputCombined(1, new RecipeInputOreDict("dustAluminum"), new RecipeInputOreDict("dustAluminium"));
    public static IRecipeInput plateElectricCircuit = new RecipeInputCombined(1, GTCXHelperStack.input(plateRefinedIron), GTCXHelperStack.input(plateSilicon), plateAluminiumSilverElectrum, GTCXHelperStack.input(platePlatinum));
    public static IRecipeInput plateSilverElectrum = new RecipeInputCombined(1, GTCXHelperStack.input(plateSilver), GTCXHelperStack.input(plateElectrum));
    public static IRecipeInput circuitBasicX2 = GTCXHelperStack.input("circuitBasic", 2);
}
