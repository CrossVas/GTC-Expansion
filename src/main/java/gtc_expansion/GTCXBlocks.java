package gtc_expansion;

import gtc_expansion.block.GTCXBlockCasing;
import gtc_expansion.block.GTCXBlockMisc;
import gtc_expansion.block.GTCXBlockOre;
import gtc_expansion.block.GTCXBlockOreBedrock;
import gtc_expansion.block.GTCXBlockStorage;
import gtc_expansion.block.GTCXBlockTile;
import gtc_expansion.item.itemblock.GTCXColorItemBlock;
import gtc_expansion.item.itemblock.GTCXItemBlock;
import gtc_expansion.tile.GTCXTileAdvancedWorktable;
import gtc_expansion.tile.GTCXTileAlloyFurnace;
import gtc_expansion.tile.GTCXTileAlloySmelter;
import gtc_expansion.tile.GTCXTileAssemblingMachine;
import gtc_expansion.tile.GTCXTileChemicalReactor;
import gtc_expansion.tile.GTCXTileDieselGenerator;
import gtc_expansion.tile.GTCXTileDustbin;
import gtc_expansion.tile.GTCXTileElectricLocker;
import gtc_expansion.tile.GTCXTileElectrolyzer;
import gtc_expansion.tile.GTCXTileFluidCaster;
import gtc_expansion.tile.GTCXTileFluidSmelter;
import gtc_expansion.tile.GTCXTileGasTurbine;
import gtc_expansion.tile.GTCXTileLathe;
import gtc_expansion.tile.GTCXTileLocker;
import gtc_expansion.tile.GTCXTileMicrowave;
import gtc_expansion.tile.GTCXTilePlateBender;
import gtc_expansion.tile.GTCXTileStoneCompressor;
import gtc_expansion.tile.GTCXTileStoneExtractor;
import gtc_expansion.tile.GTCXTileWiremill;
import gtc_expansion.tile.hatch.GTCXTileEnergyOutputHatch;
import gtc_expansion.tile.hatch.GTCXTileItemFluidHatches;
import gtc_expansion.tile.multi.GTCXTileMultiDistillationTower;
import gtc_expansion.tile.multi.GTCXTileMultiImplosionCompressor;
import gtc_expansion.tile.multi.GTCXTileMultiIndustrialBlastFurnace;
import gtc_expansion.tile.multi.GTCXTileMultiIndustrialGrinder;
import gtc_expansion.tile.multi.GTCXTileMultiLargeSteamTurbine;
import gtc_expansion.tile.multi.GTCXTileMultiPrimitiveBlastFurnace;
import gtc_expansion.tile.multi.GTCXTileMultiThermalBoiler;
import gtc_expansion.tile.multi.GTCXTileMultiVacuumFreezer;
import gtc_expansion.util.GTCXLang;
import gtclassic.GTMod;
import gtclassic.api.interfaces.IGTColorBlock;
import gtclassic.api.interfaces.IGTItemBlock;
import ic2.core.IC2;
import ic2.core.item.block.ItemBlockRare;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.ArrayList;
import java.util.List;

public class GTCXBlocks {
    private GTCXBlocks() {
        throw new IllegalStateException("Utility class");
    }

    static final List<Block> toRegister = new ArrayList();
    public static final GTCXBlockTile electrolyzer = registerBlock(new GTCXBlockTile("industrialelectrolyzer", GTCXLang.INDUSTRIAL_ELECTROLYZER, 1));
    public static final GTCXBlockTile alloySmelter = registerBlock(new GTCXBlockTile("alloysmelter", GTCXLang.ALLOY_SMELTER));
    public static final GTCXBlockTile assemblingMachine = registerBlock(new GTCXBlockTile("assemblingmachine", GTCXLang.ASSEMBLING_MACHINE));
    public static final GTCXBlockTile chemicalReactor = registerBlock(new GTCXBlockTile("chemicalreactor", GTCXLang.CHEMICAL_REACTOR));
    public static final GTCXBlockTile industrialGrinder = registerBlock(new GTCXBlockTile("industrialgrinder", GTCXLang.INDUSTRIAL_GRINDER));
    public static final GTCXBlockTile implosionCompressor = registerBlock(new GTCXBlockTile("implosioncompressor", GTCXLang.IMPLOSION_COMPRESSOR));
    public static final GTCXBlockTile industrialBlastFurnace = registerBlock(new GTCXBlockTile("industrialblastfurnace", GTCXLang.INDUSTRIAL_BLAST_FURNACE, 3));
    public static final GTCXBlockTile vacuumFreezer = registerBlock(new GTCXBlockTile("vacuumfreezer", GTCXLang.VACUUM_FREEZER));
    public static final GTCXBlockTile distillationTower = registerBlock(new GTCXBlockTile("distillationtower", GTCXLang.DISTILLATION_TOWER));
    public static final GTCXBlockTile alloyFurnace = registerBlock(new GTCXBlockTile("alloyfurnace", GTCXLang.ALLOY_FURNACE, Material.ROCK));
    public static final GTCXBlockTile primitiveBlastFurnace = registerBlock(new GTCXBlockTile("primitiveblastfurnace", GTCXLang.PRIMITIVE_BLAST_FURNACE, Material.ROCK, 3));
    public static final GTCXBlockTile fluidCaster = registerBlock(new GTCXBlockTile("fluidcaster", GTCXLang.FLUID_CASTER));
    public static final GTCXBlockTile fluidSmelter = registerBlock(new GTCXBlockTile("fluidsmelter", GTCXLang.FLUID_SMELTER));
    public static final GTCXBlockTile plateBender = registerBlock(new GTCXBlockTile("platebender", GTCXLang.PLATE_BENDER));
    public static final GTCXBlockTile lathe = registerBlock(new GTCXBlockTile("lathe", GTCXLang.LATHE));
    public static final GTCXBlockTile wiremill = registerBlock(new GTCXBlockTile("wiremill", GTCXLang.WIREMILL));
    public static final GTCXBlockTile microwave = registerBlock(new GTCXBlockTile("microwave", GTCXLang.MICROWAVE));
    public static final GTCXBlockTile dieselGenerator = registerBlock(new GTCXBlockTile("dieselgenerator", GTCXLang.DIESEL_GENERATOR));
    public static final GTCXBlockTile gasTurbine = registerBlock(new GTCXBlockTile("gasturbine", GTCXLang.GAS_TURBINE));
    public static final GTCXBlockTile stoneCompressor = registerBlock(new GTCXBlockTile("stonecompressor", GTCXLang.COMPRESSOR));
    public static final GTCXBlockTile stoneExtractor = registerBlock(new GTCXBlockTile("stoneextractor", GTCXLang.EXTRACTOR));
    //public static final GEBlockTile fusionReactor = registerBlock(new GEBlockTile("fusionreactor", GTLang.FUSION_REACTOR, 5));
    public static final GTCXBlockTile thermalBoiler = registerBlock(new GTCXBlockTile("thermalboiler", GTCXLang.THERMAL_BOILER));
    public static final GTCXBlockTile largeSteamTurbine = registerBlock(new GTCXBlockTile("largesteamturbine", GTCXLang.LARGE_STEAM_TURBINE));
    
    public static final GTCXBlockStorage locker = registerBlock(new GTCXBlockStorage("locker", GTCXLang.LOCKER,1));
    public static final GTCXBlockStorage electricLocker = registerBlock(new GTCXBlockStorage("electriclocker", GTCXLang.ELECTRIC_LOCKER, 1));
    public static final GTCXBlockStorage advancedWorktable = registerBlock(new GTCXBlockStorage("advancedworktable", GTCXLang.ADVANCED_WORKTABLE, 1));
    public static final GTCXBlockStorage dustBin = registerBlock(new GTCXBlockStorage("dustbin", GTCXLang.DUSTBIN, 1));

    public static final GTCXBlockCasing casingStandard = registerBlock(new GTCXBlockCasing("standard", GTCXLang.CASING_STANDARD, 2,75F));
    public static final GTCXBlockCasing casingReinforced = registerBlock(new GTCXBlockCasing("reinforced", GTCXLang.CASING_REINFORCED, 4, 150.0F));
    public static final GTCXBlockCasing casingAdvanced = registerBlock(new GTCXBlockCasing("advanced", GTCXLang.CASING_ADVANCED, 1, 200F));
    
    public static final GTCXBlockTile inputHatch = registerBlock(new GTCXBlockTile("inputhatch", GTCXLang.INPUT_HATCH));
    public static final GTCXBlockTile outputHatch = registerBlock(new GTCXBlockTile("outputhatch", GTCXLang.OUTPUT_HATCH));
    public static final GTCXBlockTile dynamoHatch = registerBlock(new GTCXBlockTile("dynamohatch", GTCXLang.DYNAMO_HATCH));
    public static final GTCXBlockTile fusionMaterialInjector = registerBlock(new GTCXBlockTile("fusionmaterialinjector", GTCXLang.FUSION_MATERIAL_INJECTOR));
    public static final GTCXBlockTile fusionMaterialExtractor = registerBlock(new GTCXBlockTile("fusionmaterialextractor", GTCXLang.FUSION_MATERIAL_EXTRACTOR));

    public static final GTCXBlockMisc fireBrickBlock = registerBlock(new GTCXBlockMisc("fire_brick_block", "pickaxe", 3, 2.0F, 10.0F, 1, Material.ROCK, SoundType.STONE));
    public static final GTCXBlockMisc iridiumTungstensteelBlock = registerBlock(new GTCXBlockMisc("iridium_tungstensteel_block", "pickaxe", 5, 50.0F, 2000.0F, 3, Material.IRON, SoundType.METAL));

    public static final GTCXBlockOre orePyrite = registerBlock(new GTCXBlockOre("pyrite", 16, 2.0F, 1));
    public static final GTCXBlockOre oreCinnabar = registerBlock(new GTCXBlockOre("cinnabar", 17, 3.0F, 2));
    public static final GTCXBlockOre oreSphalerite = registerBlock(new GTCXBlockOre("sphalerite", 18, 2.0F, 1));
    public static final GTCXBlockOre oreTungstate = registerBlock(new GTCXBlockOre("tungstate", 19, 4.0F, 2));
    public static final GTCXBlockOre oreSheldonite = registerBlock(new GTCXBlockOre("sheldonite", GTMod.MODID + "_ores", 12, 3.5F, 3));
    public static final GTCXBlockOre oreOlivine = registerBlock(new GTCXBlockOre("olivine", 20, 3.0F, 3));
    public static final GTCXBlockOre oreSodalite = registerBlock(new GTCXBlockOre("sodalite", 21, 3.0F, 2));
    public static final GTCXBlockOre oreChromite = registerBlock(new GTCXBlockOre("chromite", 25, 3.5F, 3));
    public static final GTCXBlockOre oreOlivineOverworld = registerBlock(new GTCXBlockOre("olivine_overworld", 20, 3.0F, 3));
    public static final GTCXBlockOre oreCassiterite = registerBlock(new GTCXBlockOre("cassiterite", 22, 3.0F, 1));
    public static final GTCXBlockOre oreTetrahedrite = registerBlock(new GTCXBlockOre("tetrahedrite", 23, 3.0F, 1));
    public static final GTCXBlockOre oreGalena = registerBlock(new GTCXBlockOre("galena", 24, 4.0F, 2));

    public static final GTCXBlockOreBedrock oreBedrockPyrite = registerBlock(new GTCXBlockOreBedrock("pyrite", 16));
    public static final GTCXBlockOreBedrock oreBedrockCinnabar = registerBlock(new GTCXBlockOreBedrock("cinnabar", 17));
    public static final GTCXBlockOreBedrock oreBedrockSphalerite = registerBlock(new GTCXBlockOreBedrock("sphalerite", 18));
    public static final GTCXBlockOreBedrock oreBedrockTungstate = registerBlock(new GTCXBlockOreBedrock("tungstate", 19));
    public static final GTCXBlockOreBedrock oreBedrockOlivine = registerBlock(new GTCXBlockOreBedrock("olivine", 20));
    public static final GTCXBlockOreBedrock oreBedrockSodalite = registerBlock(new GTCXBlockOreBedrock("sodalite", 21));
    public static final GTCXBlockOreBedrock oreBedrockCassiterite = registerBlock(new GTCXBlockOreBedrock("cassiterite", 22));
    public static final GTCXBlockOreBedrock oreBedrockTetrahedrite = registerBlock(new GTCXBlockOreBedrock("tetrahedrite", 23));
    public static final GTCXBlockOreBedrock oreBedrockGalena = registerBlock(new GTCXBlockOreBedrock("galena", 24));


    protected static final String[] textureTileBasic = new String[]{ "thermal_boiler_front", "thermal_boiler_front_active","dynamo_hatch_front", "advanced_worktable_bottom", "advanced_worktable_side", "advanced_worktable_top", "advanced_worktable_top_active", "alloy_furnace_front", "alloy_furnace_front_active", "alloy_smelter_front", "alloy_smelter_front_active", "assembling_machine_top", "chemical_reactor_side", "chemical_reactor_side_active", "diesel_generator_top", "diesel_generator_top_active", "distillation_tower_side", "dustbin_bottom", "dustbin_front", "dustbin_top", "electric_locker_front", "electrolyzer_side", "electrolyzer_side_active", "fluid_caster_front", "fluid_caster_front_active", "fluid_smelter_front", "fluid_smelter_front_active", "gas_turbine_top", "gas_turbine_top_active", "implosion_compressor_side_1", "implosion_compressor_side_2", "industrial_blast_furnace_side", "industrial_front", "industrial_front_active", "industrial_grinder_side", "industrial_side", "lathe_front", "lathe_front_active", "locker_front", "machine_back", "microwave_front", "microwave_front_active", "plate_bender_front", "plate_bender_front_active", "primitive_blast_furnace_front", "primitive_blast_furnace_front_active", "vacuum_freezer_side", "wiremill_top", "wiremill_top_active", "stone_compressor_front", "stone_compressor_front_active", "stone_machine_top", "stone_machine_bottom", "stone_extractor_front", "stone_extractor_front_active", "stone_machine_side"};
    public static void registerBlocks() {
        for(Block block : toRegister){
            createBlock(block);
        }
    }

    static <T extends Block> T registerBlock(T block) {
        toRegister.add(block);
        return block;
    }

    public static void createBlock(Block block) {
        IC2.getInstance().createBlock(block, getItemBlock(block));
    }

    static Class<? extends ItemBlockRare> getItemBlock(Block block) {
        if (block instanceof IGTItemBlock) {
            return ((IGTItemBlock)block).getCustomItemBlock();
        } else {
            return block instanceof IGTColorBlock ? GTCXColorItemBlock.class : GTCXItemBlock.class;
        }
    }

    public static void registerTiles() {
        registerUtil(GTCXTileElectrolyzer.class, "IndustrialElectrolyzer");
        registerUtil(GTCXTileAlloySmelter.class, "AlloySmelter");
        registerUtil(GTCXTileMultiIndustrialGrinder.class, "IndustrialGrinder");
        registerUtil(GTCXTileMultiImplosionCompressor.class, "ImplosionCompressor");
        registerUtil(GTCXTileMultiVacuumFreezer.class, "VacuumFreezer");
        registerUtil(GTCXTileAlloyFurnace.class, "AlloyFurnace");
        registerUtil(GTCXTileAssemblingMachine.class, "AssemblingMachine");
        registerUtil(GTCXTileChemicalReactor.class, "ChemicalReactor");
        registerUtil(GTCXTileMultiDistillationTower.class, "DistillationTower");
        registerUtil(GTCXTileMultiPrimitiveBlastFurnace.class, "PrimitiveBlastFurnace");
        registerUtil(GTCXTileMultiIndustrialBlastFurnace.class, "IndustrialBlastFurnace");
        registerUtil(GTCXTileFluidCaster.class, "FluidCaster");
        registerUtil(GTCXTileFluidSmelter.class, "FluidSmelter");
        registerUtil(GTCXTilePlateBender.class, "PlateBender");
        registerUtil(GTCXTileLathe.class, "Lathe");
        registerUtil(GTCXTileWiremill.class, "Wiremill");
        registerUtil(GTCXTileMicrowave.class, "Microwave");
        registerUtil(GTCXTileDieselGenerator.class, "DieselGenerator");
        registerUtil(GTCXTileGasTurbine.class, "GasTurbine");
        registerUtil(GTCXTileMultiThermalBoiler.class, "ThermalBoiler");
        registerUtil(GTCXTileMultiLargeSteamTurbine.class, "LargeSteamTurbine");
        registerUtil(GTCXTileLocker.class, "Locker");
        registerUtil(GTCXTileElectricLocker.class, "ElectricLocker");
        registerUtil(GTCXTileAdvancedWorktable.class, "AdvancedWorktable");
        registerUtil(GTCXTileDustbin.class, "Dustbin");
        registerUtil(GTCXTileStoneCompressor.class, "StoneCompressor");
        registerUtil(GTCXTileStoneExtractor.class, "StoneExtractor");
        registerUtil(GTCXTileItemFluidHatches.GTCXTileInputHatch.class, "InputHatch");
        registerUtil(GTCXTileItemFluidHatches.GTCXTileOutputHatch.class, "OutputHatch");
        registerUtil(GTCXTileEnergyOutputHatch.GTCXTileDynamoHatch.class, "DynamoHatch");
        registerUtil(GTCXTileItemFluidHatches.GTCXTileFusionMaterialInjector.class, "FusionMaterialInjector");
        registerUtil(GTCXTileItemFluidHatches.GTCXTileFusionMaterialExtractor.class, "FusionMaterialExtractor");
        //registerUtil(GETileMultiFusionReactor.class, "BigFusionReactor");
    }

    public static void registerUtil(Class tile, String name) {
        GameRegistry.registerTileEntity(tile, new ResourceLocation("gtclassic", "tileEntity" + name));
    }
}
