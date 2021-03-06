package gtc_expansion.item.tools;

import gtc_expansion.GTCExpansion;
import gtc_expansion.material.GTCXMaterial;
import gtc_expansion.util.GTCXHelperStack;
import gtclassic.GTMod;
import gtclassic.api.material.GTMaterial;
import ic2.core.IC2;
import ic2.core.item.tool.ItemToolWrench;
import ic2.core.platform.registry.Ic2Sounds;
import ic2.core.platform.textures.Ic2Icons;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Arrays;
import java.util.List;

public class GTCXItemToolWrench extends ItemToolWrench {

    GTMaterial material;

    public GTCXItemToolWrench(GTMaterial mat, ToolMaterial tmat) {
        this.maxStackSize = 1;
        this.material = mat;
        this.setMaxDamage(tmat.getMaxUses());
        setRegistryName(this.material.getName() + "_wrench");
        setUnlocalizedName(GTCExpansion.MODID + "." + this.material.getName() + "_wrench");
        setCreativeTab(GTMod.creativeTabGT);
    }

    @Override
    public boolean hasContainerItem(ItemStack itemStack) {
        return true;
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
        ItemStack copy = itemStack.copy();
        if (!IC2.platform.isSimulating()) {
        	IC2.audioManager.playOnce(Minecraft.getMinecraft().player, Ic2Sounds.wrenchUse);
        }
        GTCXHelperStack.damageItem(copy, 8);
        return copy;
    }

    @Override
    public List<Integer> getValidVariants() {
        return Arrays.asList(0);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public TextureAtlasSprite getTexture(int i) {
    	String tex = GTCExpansion.MODID + "_tools_crafting";
    	if (this.material.equals(GTCXMaterial.Bronze)) {
            return Ic2Icons.getTextures(tex)[13];
    	} else if (this.material.equals(GTCXMaterial.Steel)) {
            return Ic2Icons.getTextures(tex)[14];
    	} else if (this.material.equals(GTCXMaterial.TungstenSteel)) {
            return Ic2Icons.getTextures(tex)[15];
    	}
        return Ic2Icons.getTextures(tex)[12];
    }

    @Override
    public boolean isWrench(ItemStack var1) {
        return true;
    }

    @Override
    public boolean canOverrideLossChance(ItemStack stack) {
        return true;
    }
    
    @Override
    public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
    	int max = this.getMaxDamage();
    	int curr = max - this.getDamage(stack);
    	String durString = String.valueOf(curr + " / " + max);
    	tooltip.add(durString);
    	tooltip.add("To dismantle and rotate Blocks of most Mods");
    	tooltip.add("Rotation of target depends on where exactly you click");
    }
}
