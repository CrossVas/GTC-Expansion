package gtc_expansion.tile;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import gtc_expansion.GTCExpansion;
import gtc_expansion.GTCXBlocks;
import gtc_expansion.GTCXMachineGui;
import gtc_expansion.container.GTCXContainerAlloyFurnace;
import gtc_expansion.container.GTCXContainerCompressor;
import gtc_expansion.recipes.GTCXRecipeLists;
import gtc_expansion.util.GTCXLang;
import gtclassic.api.interfaces.IGTDisplayTickTile;
import gtclassic.api.interfaces.IGTItemContainerTile;
import gtclassic.api.material.GTMaterialGen;
import gtclassic.api.recipe.GTRecipeMachineHandler;
import gtclassic.api.recipe.GTRecipeMultiInputList;
import gtclassic.api.tile.GTTileBaseFuelMachine;
import gtclassic.common.block.GTBlockMortar;
import gtclassic.common.util.GTIFilters;
import ic2.api.classic.recipe.ClassicRecipes;
import ic2.api.classic.recipe.machine.IMachineRecipeList;
import ic2.api.classic.recipe.machine.MachineOutput;
import ic2.api.classic.recipe.machine.IMachineRecipeList.RecipeEntry;
import ic2.api.classic.tile.IRecipeMachine;
import ic2.api.classic.tile.MachineType;
import ic2.api.recipe.IRecipeInput;
import ic2.core.RotationList;
import ic2.core.block.base.tile.TileEntityBlock;
import ic2.core.inventory.container.ContainerIC2;
import ic2.core.inventory.filters.CommonFilters;
import ic2.core.inventory.filters.IFilter;
import ic2.core.inventory.management.AccessRule;
import ic2.core.inventory.management.InventoryHandler;
import ic2.core.inventory.management.SlotType;
import ic2.core.platform.lang.components.base.LocaleComp;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GTCXTileStoneCompressor extends GTTileBaseFuelMachine implements IGTItemContainerTile, IGTDisplayTickTile {
    public static final ResourceLocation GUI_LOCATION = new ResourceLocation(GTCExpansion.MODID, "textures/gui/stonecompressor.png");
    protected static final int[] slotInputs = { 0, 1 };
    public static final int slotOutput = 2;
    public static final int slotFuel = 3;
    public IFilter filter = new GTIFilters.FuelMachineFilter(this);
    
	public GTCXTileStoneCompressor() {
		super(4, 400, 1);
	}

    @Override
    protected void addSlots(InventoryHandler handler) {
        handler.registerDefaultSideAccess(AccessRule.Both, RotationList.ALL);
        handler.registerDefaultSlotAccess(AccessRule.Both, getFuelSlot());
        handler.registerDefaultSlotAccess(AccessRule.Import, getInputSlots());
        handler.registerDefaultSlotAccess(AccessRule.Export, getOutputSlots());
        handler.registerDefaultSlotsForSide(RotationList.UP.invert(), getFuelSlot());
        handler.registerDefaultSlotsForSide(RotationList.UP.invert(), getOutputSlots());
        handler.registerDefaultSlotsForSide(RotationList.DOWN.invert(), getInputSlots());
        handler.registerInputFilter(CommonFilters.IronFurnaceFuelWithLava, getFuelSlot());
        handler.registerOutputFilter(CommonFilters.NotIronFurnaceFuelWithLava, getFuelSlot());
        handler.registerInputFilter(filter, getInputSlots());
        handler.registerSlotType(SlotType.Fuel, getFuelSlot());
        handler.registerSlotType(SlotType.Input, getInputSlots());
        handler.registerSlotType(SlotType.Output, getOutputSlots());
    }
    
    @Override
    public boolean hasGui(EntityPlayer entityPlayer) {
    	return true;
    }
    
    @Override
    public LocaleComp getBlockName() {
        return GTCXLang.COMPRESSOR;
    }
	
    @Override
    public int getFuelSlot() {
    	return slotFuel;
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
        return GTCXRecipeLists.COMPRESSOR_RECIPE_LIST;
    }

    @Override
    public ContainerIC2 getGuiContainer(EntityPlayer player) {
        return new GTCXContainerCompressor(player.inventory, this);
    }
    
    public ResourceLocation getGuiTexture() {
        return GUI_LOCATION;
    }
    
    @Override
    public Class<? extends GuiScreen> getGuiClass(EntityPlayer entityPlayer) {
        return GTCXMachineGui.GTCXStoneCompressorGui.class;
    }
    
    @Override
    public List<ItemStack> getDrops() {
        List<ItemStack> list = new ArrayList<ItemStack>();
        ItemStack machine = GTMaterialGen.get(GTCXBlocks.stoneCompressor);
        list.add(machine);
        list.addAll(getInventoryDrops());
        return list;
    }
    
    @Override
    public List<ItemStack> getInventoryDrops() {
        List<ItemStack> list = new ArrayList<>();
        for(int i = 0; i < this.inventory.size(); ++i) {
            ItemStack stack = this.inventory.get(i);
            if (!stack.isEmpty()) {
                list.add(stack);
            }
        }
        return list;
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void randomTickDisplay(IBlockState iBlockState, World world, BlockPos blockPos, Random random) {
        if (this.isActive){
            float f;
            float f3;
            float f4;
            float f5;
            TileEntity te = world.getTileEntity(pos);
            int facing = te instanceof TileEntityBlock ? ((TileEntityBlock)te).getFacing().getIndex() : 0;
            f = (float)pos.getX() + 0.5F;
            float f2 = (float)pos.getY() + 0.0F + world.rand.nextFloat() * 6.0F / 16.0F;
            f3 = (float)pos.getZ() + 0.5F;
            f4 = 0.52F;
            f5 = world.rand.nextFloat() * 0.6F - 0.3F;
            double x = 0.0D;
            double y = 0.0D;
            double z = 0.0D;
            boolean spawn = false;
            if (facing == 2) {
                x = f + f5;
                y = f2;
                z = f3 - f4;
                spawn = true;
            } else if (facing == 3) {
                x = f + f5;
                y = f2;
                z = f3 + f4;
                spawn = true;
            } else if (facing == 4) {
                x = f - f4;
                y = f2;
                z = f3 + f5;
                spawn = true;
            } else if (facing == 5) {
                x = f + f4;
                y = f2;
                z = f3 + f5;
                spawn = true;
            }

            if (spawn) {
                world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, x, y, z, 0.0D, 0.0D, 0.0D);
                world.spawnParticle(EnumParticleTypes.FLAME, x, y, z, 0.0D, 0.0D, 0.0D);
            }
        }
    }
   
    public static void initRecipes() {
    	GTRecipeMachineHandler.convertIC2toGTC(ClassicRecipes.compressor.getRecipeMap(), GTCXRecipeLists.COMPRESSOR_RECIPE_LIST);
    }
}
