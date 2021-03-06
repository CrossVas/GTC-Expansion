package gtc_expansion.block;

import java.util.ArrayList;
import java.util.List;

import gtc_expansion.GTCExpansion;
import gtc_expansion.GTCXBlocks;
import gtclassic.GTMod;
import gtclassic.api.block.GTBlockBaseMachine;
import ic2.core.block.base.tile.TileEntityBlock;
import ic2.core.platform.lang.components.base.LocaleComp;
import ic2.core.platform.textures.Ic2Icons;
import ic2.core.util.helpers.BlockStateContainerIC2;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GTCXBlockCasing extends GTBlockBaseMachine {
    public static PropertyInteger rotor = PropertyInteger.create("rotor", 0, 8);
    int index;
    public GTCXBlockCasing(String name, LocaleComp comp, int index, float resistance) {
        super(Material.IRON, comp, 0);
        setRegistryName(name.toLowerCase());
        this.setCreativeTab(GTMod.creativeTabGT);
        this.setSoundType(SoundType.METAL);
        this.setResistance(resistance);
        this.setHardness(3.0F);
        this.setHarvestLevel("pickaxe", 2);
        this.index = index;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public TextureAtlasSprite getTextureFromState(IBlockState state, EnumFacing enumFacing) {
        if (this == GTCXBlocks.casingStandard){
            EnumFacing facing = state.getValue(allFacings);
            if (state.getValue(rotor) > 0){
               return  getTextureFromRotor(state.getValue(active), state.getValue(rotor), facing, enumFacing);
            }
        }
        return Ic2Icons.getTextures(GTCExpansion.MODID + "_blocks")[this.index];
    }
    
    @Override
    public TextureAtlasSprite getParticleTexture(IBlockState state) {
    	return Ic2Icons.getTextures(GTCExpansion.MODID + "_blocks")[this.index];
    }

    @Override
    public TileEntityBlock createNewTileEntity(World world, int i) {
        return new TileEntityBlock();
    }

    @Override
    public TextureAtlasSprite[] getIconSheet(int i) {
        return new TextureAtlasSprite[0];
    }

    public TextureAtlasSprite getTextureFromRotor(boolean active, int rotor, EnumFacing facingBlock, EnumFacing facingTexture){
        String activeTexture = active ? "active_" : "";
        if (facingBlock != facingTexture){
            return Ic2Icons.getTextures(GTCExpansion.MODID + "_blocks")[this.index];
        }
        String location = getLocation(rotor);
        return Ic2Icons.getTextures("steam_turbine_front_" + activeTexture + location)[0];
    }
    
    public String getLocation(int rotor) {
        switch (rotor) {
        	case 1: return  "top_left";
        	case 2: return  "top";
        	case 3: return  "top_right";
        	case 4: return  "left";
        	case 5: return  "right";
        	case 6: return  "bottom_left";
        	case 7: return  "bottom";
        	case 8: return  "bottom_right";
        	default: return "";
        }
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainerIC2(this, rotor, allFacings, active);
    }

    @Override
    public IBlockState getDefaultBlockState() {
        IBlockState state = this.getDefaultState().withProperty(rotor, 0).withProperty(active, false).withProperty(allFacings, EnumFacing.NORTH);
        return state;
    }

    @Override
    public List<IBlockState> getValidStateList() {
        IBlockState def = this.getDefaultState();
        List<IBlockState> states = new ArrayList<>();
        EnumFacing[] facings = EnumFacing.VALUES;
        int facingsLength = facings.length;

        for(int i = 0; i < facingsLength; ++i) {
            for (int j = 0; j < 9; j++){
                EnumFacing side = facings[i];
                states.add(def.withProperty(allFacings, side).withProperty(active, false).withProperty(rotor, j));
                states.add(def.withProperty(allFacings, side).withProperty(active, true).withProperty(rotor, j));
            }
        }

        return states;
    }

    @Override
    public boolean hasFacing() {
        return this == GTCXBlocks.casingStandard;
    }

    @Override
    public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(I18n.format("tooltip.gtclassic.nomobs"));
    }
    
    @Override
    public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
        List<ItemStack> list = new ArrayList();
        list.add(new ItemStack(this));
        return list;
    }
}
