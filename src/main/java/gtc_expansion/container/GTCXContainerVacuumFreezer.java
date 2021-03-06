package gtc_expansion.container;

import gtc_expansion.tile.multi.GTCXTileMultiVacuumFreezer;
import gtclassic.api.gui.GTGuiCompMachinePower;
import gtclassic.api.gui.GTGuiCompMultiTileStatus;
import gtclassic.api.gui.GTSlotUpgrade;
import ic2.core.inventory.container.ContainerTileComponent;
import ic2.core.inventory.gui.GuiIC2;
import ic2.core.inventory.gui.components.base.MachineProgressComp;
import ic2.core.inventory.slots.SlotCustom;
import ic2.core.inventory.slots.SlotDischarge;
import ic2.core.inventory.slots.SlotOutput;
import ic2.core.util.math.Box2D;
import ic2.core.util.math.Vec2i;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GTCXContainerVacuumFreezer extends ContainerTileComponent<GTCXTileMultiVacuumFreezer> {
    public static final Box2D machineProgressBox = new Box2D(78, 28, 20, 11);
    public static final Vec2i machineProgressPos = new Vec2i(176, 0);
    public GTCXContainerVacuumFreezer(InventoryPlayer player, GTCXTileMultiVacuumFreezer tile) {
        super(tile);
        this.addSlotToContainer(new SlotCustom(tile, 0, 53, 25, tile.filter));// main slot
        this.addSlotToContainer(new SlotDischarge(tile, Integer.MAX_VALUE, 2, 80, 63)); // battery
        this.addSlotToContainer(new SlotOutput(player.player, tile, 1, 107, 25)); // output
        this.addPlayerInventory(player);
        for (int i = 0; i < 2; ++i) {
            this.addSlotToContainer(new GTSlotUpgrade(tile, 3 + i, 152, 25 + i * 18));
        }
        this.addComponent(new GTGuiCompMachinePower(tile));
        this.addComponent(new GTGuiCompMultiTileStatus(tile, new Box2D(12, 6, 12, 48)));
        this.addComponent(new MachineProgressComp(tile, machineProgressBox, machineProgressPos));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void onGuiLoaded(GuiIC2 gui) {
        gui.dissableInvName();
    }

    @Override
    public ResourceLocation getTexture() {
        return this.getGuiHolder().getGuiTexture();
    }

    @Override
    public int guiInventorySize() {
        return this.getGuiHolder().getSlotCount();
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return this.getGuiHolder().canInteractWith(playerIn);
    }
}
