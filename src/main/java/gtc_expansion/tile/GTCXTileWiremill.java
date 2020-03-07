package gtc_expansion.tile;

import gtc_expansion.GTCExpansion;
import gtc_expansion.GTCXItems;
import gtc_expansion.GTCXMachineGui;
import gtc_expansion.container.GTCXContainerWiremill;
import gtc_expansion.recipes.GTCXRecipeLists;
import gtc_expansion.util.GTCXLang;
import gtclassic.api.material.GTMaterialGen;
import gtclassic.api.recipe.GTRecipeMultiInputList;
import gtclassic.api.tile.GTTileBaseMachine;
import ic2.api.classic.item.IMachineUpgradeItem;
import ic2.api.classic.recipe.RecipeModifierHelpers;
import ic2.api.classic.recipe.machine.MachineOutput;
import ic2.api.recipe.IRecipeInput;
import ic2.core.IC2;
import ic2.core.RotationList;
import ic2.core.inventory.container.ContainerIC2;
import ic2.core.inventory.filters.ArrayFilter;
import ic2.core.inventory.filters.BasicItemFilter;
import ic2.core.inventory.filters.CommonFilters;
import ic2.core.inventory.filters.IFilter;
import ic2.core.inventory.filters.MachineFilter;
import ic2.core.inventory.management.AccessRule;
import ic2.core.inventory.management.InventoryHandler;
import ic2.core.inventory.management.SlotType;
import ic2.core.item.recipe.entry.RecipeInputOreDict;
import ic2.core.platform.lang.components.base.LocaleComp;
import ic2.core.platform.registry.Ic2Items;
import ic2.core.platform.registry.Ic2Sounds;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class GTCXTileWiremill extends GTTileBaseMachine {

    public static final ResourceLocation GUI_LOCATION = new ResourceLocation(GTCExpansion.MODID, "textures/gui/wiremill.png");
    public static final int slotInput = 0;
    public static final int slotOutput = 1;
    public static final int slotFuel = 2;
    protected static final int[] slotInputs = { slotInput };
    public IFilter filter = new MachineFilter(this);
    private static int defaultEu;

    public GTCXTileWiremill() {
        super(3, 4, defaultEu, 100, 32);
        setFuelSlot(slotFuel);
        maxEnergy = 10000;
    }
    
    public static int setUsageEuPerTick(int value) {
    	return defaultEu = value;
    }
   
    public static int getUsagePerTick() {
    	return defaultEu;
    }

    @Override
    protected void addSlots(InventoryHandler handler) {
        handler.registerDefaultSideAccess(AccessRule.Both, RotationList.ALL);
        handler.registerDefaultSlotAccess(AccessRule.Both, slotFuel);
        handler.registerDefaultSlotAccess(AccessRule.Import, slotInputs);
        handler.registerDefaultSlotAccess(AccessRule.Export, slotOutput);
        handler.registerDefaultSlotsForSide(RotationList.UP, slotInputs);
        handler.registerDefaultSlotsForSide(RotationList.HORIZONTAL, slotInputs);
        handler.registerDefaultSlotsForSide(RotationList.UP.invert(), slotOutput);
        handler.registerInputFilter(new ArrayFilter(CommonFilters.DischargeEU, new BasicItemFilter(Items.REDSTONE), new BasicItemFilter(Ic2Items.suBattery)), slotFuel);
        handler.registerInputFilter(filter, slotInputs);
        handler.registerOutputFilter(CommonFilters.NotDischargeEU, slotFuel);
        handler.registerSlotType(SlotType.Fuel, slotFuel);
        handler.registerSlotType(SlotType.Input, slotInputs);
        handler.registerSlotType(SlotType.Output, slotOutput);
    }

    @Override
    public LocaleComp getBlockName() {
        return GTCXLang.WIREMILL;
    }

    @Override
    public Set<IMachineUpgradeItem.UpgradeType> getSupportedTypes() {
        return new LinkedHashSet<>(Arrays.asList(IMachineUpgradeItem.UpgradeType.values()));
    }

    @Override
    public ContainerIC2 getGuiContainer(EntityPlayer player) {
        return new GTCXContainerWiremill(player.inventory, this);
    }

    @Override
    public Class<? extends GuiScreen> getGuiClass(EntityPlayer player) {
        return GTCXMachineGui.GTCXWiremillGui.class;
    }

    @Override
    public int[] getInputSlots() {
        return slotInputs;
    }

    @Override
    public IFilter[] getInputFilters(int[] slots) {
        return new IFilter[] { filter };
    }

    @Override
    public boolean isRecipeSlot(int slot) {
        return slot != slotFuel;
    }

    @Override
    public int[] getOutputSlots() {
        return new int[]{slotOutput};
    }

    @Override
    public GTRecipeMultiInputList getRecipeList() {
        return GTCXRecipeLists.WIREMILL_RECIPE_LIST;
    }

    public ResourceLocation getGuiTexture() {
        return GUI_LOCATION;
    }

    @Override
    public boolean hasGui(EntityPlayer player) {
        return true;
    }

    @Override
    public ResourceLocation getStartSoundFile() {
        return Ic2Sounds.extractorOp;
    }

    //TODO Change EU usage per recipe
    public static void init() {
        addRecipe(input("ingotCopper", 1), setUsageEuPerTick(2), 200, GTMaterialGen.getIc2(Ic2Items.copperCable, 3));
        addRecipe(input("ingotTin", 1), setUsageEuPerTick(2), 300, GTMaterialGen.getIc2(Ic2Items.tinCable, 4));
        addRecipe(input(IC2.getRefinedIron(), 1), setUsageEuPerTick(2), 400, GTMaterialGen.getIc2(Ic2Items.ironCable, 6));
        addRecipe(input("ingotGold", 1), setUsageEuPerTick(2), 400, GTMaterialGen.getIc2(Ic2Items.goldCable, 6));
        addRecipe(input("ingotBronze", 1), setUsageEuPerTick(2), 400, GTMaterialGen.getIc2(Ic2Items.bronzeCable, 3));
        addRecipe(input("ingotKanthal", 4), setUsageEuPerTick(2), 900, GTMaterialGen.get(GTCXItems.kanthalHeatingCoil));
        addRecipe(input("ingotConstantan", 3), setUsageEuPerTick(2), 600, GTMaterialGen.get(GTCXItems.constantanHeatingCoil));
        addRecipe(input("ingotNichrome", 4), setUsageEuPerTick(2), 1200, GTMaterialGen.get(GTCXItems.nichromeHeatingCoil));
        addRecipe(input("dustCoal", 4), setUsageEuPerTick(2), 800, Ic2Items.carbonFiber);
        addRecipe(input("dustCharcoal", 8), setUsageEuPerTick(2), 800, Ic2Items.carbonFiber);
        addRecipe(input("dustCarbon", 8), setUsageEuPerTick(2), 800, Ic2Items.carbonFiber);
    }

    public static RecipeModifierHelpers.IRecipeModifier[] totalEu(int total) {
        return new RecipeModifierHelpers.IRecipeModifier[] { RecipeModifierHelpers.ModifierType.RECIPE_LENGTH.create((total / getUsagePerTick()) - 100) };
    }

    public static void addRecipe(ItemStack input, int euPerTick, int euTotal, RecipeModifierHelpers.IRecipeModifier[] modifiers, ItemStack output) {
        addRecipe(new IRecipeInput[]{input(input)}, euPerTick, totalEu(euTotal), output);
    }
    
    public static void addRecipe(String input1, int amount1, int euPerTick, int totalEu, ItemStack output) {
        addRecipe(new IRecipeInput[]{new RecipeInputOreDict(input1, amount1)}, euPerTick, totalEu(totalEu), output);
    }

    /** Common Method **/
    
    public static void addRecipe(IRecipeInput input, int euPerTick, int totalEu, ItemStack output) {
        addRecipe(new IRecipeInput[]{input}, euPerTick, totalEu(totalEu), output);
    }

    public static void addRecipe(IRecipeInput[] inputs, int euPerTick, RecipeModifierHelpers.IRecipeModifier[] modifiers, ItemStack... outputs) {
        List<IRecipeInput> inlist = new ArrayList<>();
        List<ItemStack> outlist = new ArrayList<>();
        for (IRecipeInput input : inputs) {
            inlist.add(input);
        }
        NBTTagCompound mods = new NBTTagCompound();
        for (RecipeModifierHelpers.IRecipeModifier modifier : modifiers) {
            modifier.apply(mods);
        }
        for (ItemStack output : outputs) {
            outlist.add(output);
        }
        addRecipe(inlist, euPerTick, new MachineOutput(mods, outlist));
    }

    static void addRecipe(List<IRecipeInput> input, int euPerTick, MachineOutput output) {
        GTCXRecipeLists.WIREMILL_RECIPE_LIST.addRecipe(input, output, output.getAllOutputs().get(0).getUnlocalizedName(), euPerTick);
    }
}
