package gtc_expansion.item.tools;

import java.util.Arrays;
import java.util.List;

import gtc_expansion.GTCExpansion;
import gtc_expansion.material.GTCXMaterial;
import gtc_expansion.util.GTCXHelperStack;
import gtclassic.GTMod;
import gtclassic.api.material.GTMaterial;
import ic2.core.platform.textures.Ic2Icons;
import ic2.core.platform.textures.obj.ICustomItemCameraTransform;
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
		implements IStaticTexturedItem, ICustomItemCameraTransform {

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
    @SideOnly(Side.CLIENT)
    public TextureAtlasSprite getTexture(int i) {
    	String tex = GTCExpansion.MODID + "_tools_crafting";
    	if (this.material.equals(GTCXMaterial.Bronze)) {
            return Ic2Icons.getTextures(tex)[9];
    	} else if (this.material.equals(GTCXMaterial.Steel)) {
            return Ic2Icons.getTextures(tex)[10];
    	} else if (this.material.equals(GTCXMaterial.TungstenSteel)) {
            return Ic2Icons.getTextures(tex)[11];
    	}
        return Ic2Icons.getTextures(tex)[8];
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
