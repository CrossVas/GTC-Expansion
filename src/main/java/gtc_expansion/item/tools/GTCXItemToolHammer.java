package gtc_expansion.item.tools;

import gtc_expansion.GTCExpansion;
import gtc_expansion.material.GTCXMaterial;
import gtc_expansion.util.GTCXHelperStack;
import gtclassic.GTMod;
import gtclassic.api.material.GTMaterial;
import ic2.core.IC2;
import ic2.core.platform.textures.Ic2Icons;
import ic2.core.platform.textures.obj.ICustomItemCameraTransform;
import ic2.core.platform.textures.obj.IStaticTexturedItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Arrays;
import java.util.List;

public class GTCXItemToolHammer extends ItemPickaxe
        implements IStaticTexturedItem, ICustomItemCameraTransform {

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
        if (!IC2.platform.isSimulating()) {
        	IC2.audioManager.playOnce(Minecraft.getMinecraft().player, new ResourceLocation("block.anvil.use"));
        }
        GTCXHelperStack.damageItem(copy, 4);	
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
    	String tex = GTCExpansion.MODID + "_tools_crafting";
    	if (this.material.equals(GTCXMaterial.Bronze)) {
            return Ic2Icons.getTextures(tex)[5];
    	} else if (this.material.equals(GTCXMaterial.Steel)) {
            return Ic2Icons.getTextures(tex)[6];
    	} else if (this.material.equals(GTCXMaterial.TungstenSteel)) {
            return Ic2Icons.getTextures(tex)[7];
    	}
        return Ic2Icons.getTextures(tex)[4];
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
