package gtc_expansion.tile.multi;

import gtc_expansion.GTCExpansion;
import gtc_expansion.GTCXBlocks;
import gtc_expansion.block.GTCXBlockCasing;
import gtc_expansion.container.GTCXContainerLargeSteamTurbine;
import gtc_expansion.tile.hatch.GTCXTileEnergyOutputHatch;
import gtc_expansion.tile.hatch.GTCXTileItemFluidHatches;
import gtclassic.api.helpers.int3;
import gtclassic.api.interfaces.IGTMultiTileStatus;
import ic2.core.block.base.tile.TileEntityBlock;
import ic2.core.block.base.tile.TileEntityMachine;
import ic2.core.inventory.base.IHasGui;
import ic2.core.inventory.container.ContainerIC2;
import ic2.core.inventory.gui.GuiComponentContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;

public class GTCXTileMultiLargeSteamTurbine extends TileEntityMachine implements ITickable, IHasGui, IGTMultiTileStatus {
    public boolean lastState;
    public boolean firstCheck = true;
    private BlockPos input1;
    private BlockPos input2;
    private BlockPos dynamo;
    public static final IBlockState standardCasingState = GTCXBlocks.casingStandard.getDefaultState();
    public static final IBlockState inputHatchState = GTCXBlocks.inputHatch.getDefaultState();
    public static final IBlockState dynamoHatchState = GTCXBlocks.dynamoHatch.getDefaultState();

    public GTCXTileMultiLargeSteamTurbine() {
        super(1);
        this.addGuiFields("lastState");
        input1 = this.getPos();
        input2 = this.getPos();
        dynamo = this.getPos();
    }


    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        this.lastState = nbt.getBoolean("lastState");
        this.input1 = readBlockPosFromNBT(nbt, "input1");
        this.input2 = readBlockPosFromNBT(nbt, "input2");
        this.dynamo = readBlockPosFromNBT(nbt, "dynamo");
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        nbt.setBoolean("lastState", this.lastState);
        writeBlockPosToNBT(nbt, "input1", input1);
        writeBlockPosToNBT(nbt, "input2", input2);
        writeBlockPosToNBT(nbt, "dynamo", dynamo);
        return nbt;
    }

    public void writeBlockPosToNBT(NBTTagCompound nbt, String id, BlockPos pos){
        NBTTagCompound compound = new NBTTagCompound();
        compound.setInteger("X", pos.getX());
        compound.setInteger("Y", pos.getY());
        compound.setInteger("Z", pos.getZ());
        nbt.setTag(id, compound);
    }

    public BlockPos readBlockPosFromNBT(NBTTagCompound nbt, String id){
        NBTTagCompound compound = nbt.getCompoundTag(id);
        int x = compound.getInteger("X");
        int y = compound.getInteger("Y");
        int z = compound.getInteger("Z");
        return new BlockPos(x, y, z);
    }

    public boolean canWork() {
        if (this.world.getTotalWorldTime() % 256L == 0L || this.firstCheck) {
            this.lastState = this.checkStructure();
            this.firstCheck = false;
            this.getNetwork().updateTileGuiField(this, "lastState");
        }
        return this.lastState;
    }

    int ticker = 0;
    @Override
    public void update() {
        if (ticker < 80){
            ticker++;
        }
        boolean canWork = canWork() && world.getTileEntity(input1) instanceof GTCXTileItemFluidHatches.GTCXTileInputHatch && world.getTileEntity(dynamo) instanceof GTCXTileEnergyOutputHatch.GTCXTileDynamoHatch;

    }

    @Override
    public ContainerIC2 getGuiContainer(EntityPlayer entityPlayer) {
        return new GTCXContainerLargeSteamTurbine(entityPlayer.inventory, this);
    }

    @Override
    public Class<? extends GuiScreen> getGuiClass(EntityPlayer entityPlayer) {
        return GuiComponentContainer.class;
    }

    @Override
    public void onGuiClosed(EntityPlayer entityPlayer) {

    }

    @Override
    public boolean canInteractWith(EntityPlayer entityPlayer) {
        return !this.isInvalid();
    }

    @Override
    public boolean hasGui(EntityPlayer entityPlayer) {
        return true;
    }

    @Override
    public boolean getStructureValid() {
        return lastState;
    }

    int inputs = 0;
    int outputs = 0;
    public boolean checkStructure() {
        if (!this.world.isAreaLoaded(this.pos, 3)){
            return false;
        }
        inputs = 0;
        outputs = 0;
        int3 dir = new int3(getPos(), getFacing());
        if (!isStandardCasingWithSpecial(dir.up(1), 2)){
            return false;
        }
        if (!isStandardCasingWithSpecial(dir.right(1), 3)){
            return false;
        }
        if (!isStandardCasingWithSpecial(dir.down(1), 5)){
            return false;
        }
        if (!isStandardCasingWithSpecial(dir.down(1), 8)){
            return false;
        }
        if (!isStandardCasingWithSpecial(dir.left(1), 7)){
            return false;
        }
        if (!isStandardCasingWithSpecial(dir.left(1), 6)){
            return false;
        }
        if (!isStandardCasingWithSpecial(dir.up(1), 4)){
            return false;
        }
        if (!isStandardCasingWithSpecial(dir.up(1), 1)){
            return false;
        }

//        if (inputs < 1){
//            return false;
//        }
        GTCExpansion.logger.info("structure valid");
        return true;
    }

    public boolean isStandardCasing(int3 pos) {
        return world.getBlockState(pos.asBlockPos()) == standardCasingState;
    }

    public boolean isStandardCasingWithSpecial(int3 pos, int position) {
        IBlockState state = world.getBlockState(pos.asBlockPos());
        if (state == standardCasingState){
        	state = state.withProperty(GTCXBlockCasing.rotor, position);
            world.setBlockState(pos.asBlockPos(), state);
            if (world.getTileEntity(pos.asBlockPos()) instanceof TileEntityBlock){
                ((TileEntityBlock) world.getTileEntity(pos.asBlockPos())).setFacing(this.getFacing());
            }
            return true;
        }
        return false;
    }

    public boolean isInputHatch(int3 pos) {
        if (world.getBlockState(pos.asBlockPos()) == inputHatchState){
            if (world.getBlockState(input1) != inputHatchState){
                input1 = pos.asBlockPos();
            } else if (world.getBlockState(input2) != inputHatchState){
                input2 = pos.asBlockPos();
            }
            inputs++;
            return true;
        }
        return world.getBlockState(pos.asBlockPos()) == standardCasingState;
    }
    public boolean isDynamoHatch(int3 pos) {
        if (world.getBlockState(pos.asBlockPos()) == dynamoHatchState){
            dynamo = pos.asBlockPos();
            return true;
        }
        return false;
    }

}
