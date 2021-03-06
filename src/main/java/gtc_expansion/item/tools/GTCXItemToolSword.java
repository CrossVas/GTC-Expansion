package gtc_expansion.item.tools;

import gtc_expansion.GTCExpansion;
import gtc_expansion.material.GTCXMaterial;
import gtclassic.GTMod;
import gtclassic.api.material.GTMaterial;
import ic2.core.platform.textures.Ic2Icons;
import ic2.core.platform.textures.obj.ICustomItemCameraTransform;
import ic2.core.platform.textures.obj.IStaticTexturedItem;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Arrays;
import java.util.List;

public class GTCXItemToolSword extends ItemSword
        implements IStaticTexturedItem, ICustomItemCameraTransform {

    GTMaterial material;

    public GTCXItemToolSword(GTMaterial mat, ToolMaterial tmat) {
        super(tmat);
        this.material = mat;
        setRegistryName(this.material.getName() + "_sword");
        setUnlocalizedName(GTCExpansion.MODID + "." + this.material.getName() + "_sword");
        setCreativeTab(GTMod.creativeTabGT);
    }


    @Override
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack) {
        return this.material != GTMaterial.Flint && super.hasEffect(stack);
    }

    @Override
    public List<Integer> getValidVariants() {
        return Arrays.asList(0);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public TextureAtlasSprite getTexture(int i) {
    	String tex = GTCExpansion.MODID + "_tools_vanilla";
    	if (this.material.equals(GTCXMaterial.Steel)) {
            return Ic2Icons.getTextures(tex)[10];
    	} else if (this.material.equals(GTCXMaterial.TungstenSteel)) {
            return Ic2Icons.getTextures(tex)[11];
    	}
        return Ic2Icons.getTextures(tex)[9];
    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
        if (!isInCreativeTab(tab)) {
            return;
        }
        ItemStack stack = new ItemStack(this);
        if (this.material.equals(GTMaterial.Flint)){
            stack.addEnchantment(Enchantments.FIRE_ASPECT, 1);
        }
        items.add(stack);
    }

    public ResourceLocation getCustomTransform(int meta) {
        return new ResourceLocation("minecraft:models/item/handheld");
    }

    @Override
    public boolean hasCustomTransform(int var1) {
        return true;
    }
}
