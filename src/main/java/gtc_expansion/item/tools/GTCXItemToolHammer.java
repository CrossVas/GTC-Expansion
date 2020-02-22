package gtc_expansion.item.tools;

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
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class GTCXItemToolHammer extends ItemPickaxe
        implements IStaticTexturedItem, IGTColorItem, ILayeredItemModel, ICustomItemCameraTransform {

    GTMaterial material;

    public GTCXItemToolHammer(GTMaterial mat, ToolMaterial tmat) {
        super(tmat);
        this.material = mat;
        this.efficiency /= 2;
        this.setHarvestLevel("pickaxe", tmat.getHarvestLevel());
        this.setNoRepair();
        setRegistryName(this.material.getName() + "_hammer");
        setUnlocalizedName(GTCExpansion.MODID + "." + this.material.getName() + "_hammer");
        setCreativeTab(GTMod.creativeTabGT);
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
        ItemStack copy = itemStack.copy();
        if (GTCXConfiguration.general.harderPlates) {
            GTCXHelperStack.damageItem(copy, 4);	
        } else {
            GTCXHelperStack.damageItem(copy, 2);
        }
        return copy;
    }

    @Override
    @Deprecated
    public boolean hasContainerItem() {
        return true;
    }

    @Override
    public List<Integer> getValidVariants() {
        return Arrays.asList(0);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public TextureAtlasSprite getTexture(int i) {
        return Ic2Icons.getTextures(GTCExpansion.MODID + "_materials")[16];
    }

    @Override
    public Color getColor(ItemStack stack, int index) {
    	if (index == 0) {
    		if ((this.material == GTCXMaterial.Bronze) || (this.material == GTCXMaterial.Iron)) {
    			return GTMaterial.Wood.getColor();
    		} 
    		if (this.material == GTCXMaterial.Steel) {
    			return GTCXMaterial.RefinedIron.getColor();
    		} 
    		if (this.material == GTCXMaterial.TungstenSteel) {
    			return GTCXMaterial.Steel.getColor();
    		}
    	}
	return this.material.getColor();
    }

    @Override
    public boolean isLayered(ItemStack var1) {
        return true;
    }

    @Override
    public int getLayers(ItemStack var1) {
        return 2;
    }

    @Override
    public TextureAtlasSprite getTexture(int var1, ItemStack var2) {
        return Ic2Icons.getTextures(GTCExpansion.MODID + "_materials")[16 + var1];
    }

    public GTMaterial getMaterial() {
        return this.material;
    }

    public ResourceLocation getCustomTransform(int meta) {
        return new ResourceLocation("minecraft:models/item/handheld");
    }

    @Override
    public boolean hasCustomTransform(int var1) {
        return true;
    }
    
    @Override
    public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
    	int max = this.getMaxDamage();
    	int curr = max - this.getDamage(stack);
    	String durString = String.valueOf(curr + " / " + max);
    	tooltip.add(durString);
    	tooltip.add("Used to craft Plates from Ingots");
    }
}
