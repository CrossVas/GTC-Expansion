package gtc_expansion.item.tools;

import java.awt.Color;
import java.util.Arrays;
import java.util.List;

import gtc_expansion.GTCExpansion;
import gtc_expansion.GTCXConfiguration;
import gtc_expansion.util.GTCXHelperStack;
import gtclassic.GTMod;
import gtclassic.api.interfaces.IGTColorItem;
import gtclassic.api.material.GTMaterial;
import ic2.core.platform.textures.Ic2Icons;
import ic2.core.platform.textures.obj.ICustomItemCameraTransform;
import ic2.core.platform.textures.obj.ILayeredItemModel;
import ic2.core.platform.textures.obj.IStaticTexturedItem;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GTCXItemToolSaw extends Item 
		implements IStaticTexturedItem, IGTColorItem, ILayeredItemModel, ICustomItemCameraTransform {

    GTMaterial material;
	
    public GTCXItemToolSaw(GTMaterial mat, ToolMaterial tmat) {
	this.maxStackSize = 1;
	this.material = mat;
	this.setMaxDamage(tmat.getMaxUses());
        this.setNoRepair();
        setRegistryName(this.material.getName() + "_saw");
        setUnlocalizedName(GTCExpansion.MODID + "." + this.material.getName() + "_saw");
        setCreativeTab(GTMod.creativeTabGT);
	}
	
    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
        ItemStack copy = itemStack.copy();
        GTCXHelperStack.damageItem(copy, 1);	
        return copy;
    }
    
    @Override
    @Deprecated
    public boolean hasContainerItem() {
        return true;
    }

	@Override
    public ResourceLocation getCustomTransform(int meta) {
        return new ResourceLocation("minecraft:models/item/handheld");
    }

	@Override
    public boolean hasCustomTransform(int var1) {
        return true;
    }

	@Override
    public int getLayers(ItemStack var1) {
        return 2;
    }

	@Override
    public TextureAtlasSprite getTexture(int var1, ItemStack var2) {
        return Ic2Icons.getTextures(GTCExpansion.MODID + "_materials")[32 + var1];
    }

	@Override
	public boolean isLayered(ItemStack arg0) {
		return true;
	}

    @Override
    public Color getColor(ItemStack stack, int index) {
    	if (index == 0) {
    		if (this.material.equals(GTCXMaterial.Bronze) || this.material.equals(GTCXMaterial.Iron)) {
    			return GTMaterial.Wood.getColor();
    		} 
    		if (this.material.equals(GTCXMaterial.Steel)) {
    			return GTCXMaterial.RefinedIron.getColor();
    		} 
    		if (this.material.equals(GTCXMaterial.TungstenSteel)) {
    			return GTCXMaterial.Steel.getColor();
    		}
    	}
	return this.material.getColor();
    }

	@Override
    @SideOnly(Side.CLIENT)
    public TextureAtlasSprite getTexture(int i) {
        return Ic2Icons.getTextures(GTCExpansion.MODID + "_materials")[32];
    }

	@Override
    public List<Integer> getValidVariants() {
        return Arrays.asList(0);
    }

    @Override
    public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
    	int max = this.getMaxDamage();
    	int curr = max - this.getDamage(stack);
    	String durString = String.valueOf(curr + " / " + max);
    	tooltip.add(durString);
    	tooltip.add("For sawing Logs into Planks");
    }
}
