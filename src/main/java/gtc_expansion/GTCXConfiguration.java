package gtc_expansion;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.Comment;
import net.minecraftforge.common.config.Config.RangeInt;

@Config(modid = GTCExpansion.MODID, name = "ic2/gtc_expansion", category = "")
public class GTCXConfiguration {
    @Comment("World generation configuration")
    @Config.RequiresMcRestart
    public static Generation generation = new Generation();

    public static class Generation{
        @Comment("Generate Pyrite ore in the nether")
        public boolean pyriteGenerate = true;
        @Comment("Max size of Pyrite veins")
        @RangeInt(min = 1, max = 64)
        public int pyriteSize = 32;
        @Comment("Chance of Pyrite veins to spawn")
        @RangeInt(min = 1, max = 32)
        public int pyriteWeight = 6;
        @Comment("Generate Cinnabar ore in the nether")
        public boolean cinnabarGenerate = true;
        @Comment("Max size of Cinnabar veins")
        @RangeInt(min = 1, max = 32)
        public int cinnabarSize = 16;
        @Comment("Chance of Cinnabar veins to spawn")
        @RangeInt(min = 1, max = 32)
        public int cinnabarWeight = 4;
        @Comment("Generate Sphalerite ore in the nether")
        public boolean sphaleriteGenerate = true;
        @Comment("Max size of Sphalerite veins")
        @RangeInt(min = 1, max = 64)
        public int sphaleriteSize = 32;
        @Comment("Chance of Sphalerite veins to spawn")
        @RangeInt(min = 1, max = 32)
        public int sphaleriteWeight = 6;
        @Comment("Generate Galena ore in the overworld")
        public boolean galenaGenerate = true;
        @Comment("Max size of Galena veins")
        @RangeInt(min = 1, max = 16)
        public int galenaSize = 10;
        @Comment("Chance of Galena veins to spawn")
        @RangeInt(min = 1, max = 16)
        public int galenaWeight = 6;
        @Comment("Generate Cassiterite ore in the overworld")
        public boolean cassiteriteGenerate = true;
        @Comment("Max size of Cassiterite veins")
        @RangeInt(min = 1, max = 16)
        public int cassiteriteSize = 32;
        @Comment("Chance of Cassiterite veins to spawn")
        @RangeInt(min = 1, max = 16)
        public int cassiteriteWeight = 1;
        @Comment("Generate Tetrahedrite ore in the overworld")
        public boolean tetrahedriteGenerate = true;
        @Comment("Max size of Tetrahedrite veins")
        @RangeInt(min = 1, max = 16)
        public int tetrahedriteSize = 6;
        @Comment("Chance of Tetrahedrite veins to spawn")
        @RangeInt(min = 1, max = 16)
        public int tetrahedriteWeight = 5;
        @Comment("Generate Tungstate ore in the end")
        public boolean tungstateGenerate = true;
        @Comment("Max size of Tungstate veins")
        @RangeInt(min = 1, max = 32)
        public int tungstateSize = 16;
        @Comment("Chance of Tungstate veins to spawn")
        @RangeInt(min = 1, max = 32)
        public int tungstateWeight = 2;
        @Comment("Generate Sheldonite ore in the end")
        public boolean sheldoniteGenerate = true;
        @Comment("Max size of Sheldonite veins")
        @RangeInt(min = 1, max = 32)
        public int sheldoniteSize = 5;
        @Comment("Chance of Sheldonite veins to spawn")
        @RangeInt(min = 1, max = 32)
        public int sheldoniteWeight = 2;
        @Comment("Generate Olivine ore in the end")
        public boolean olivineGenerate = true;
        @Comment("Max size of Olivine veins")
        @RangeInt(min = 1, max = 32)
        public int olivineSize = 8;
        @Comment("Chance of Olivine veins to spawn")
        @RangeInt(min = 1, max = 32)
        public int olivineWeight = 5;
        @Comment("Generate Sodalite ore in the end")
        public boolean sodaliteGenerate = true;
        @Comment("Max size of Sodalite veins")
        @RangeInt(min = 1, max = 32)
        public int sodaliteSize = 16;
        @Comment("Chance of Sodalite veins to spawn")
        @RangeInt(min = 1, max = 32)
        public int sodaliteWeight = 6;
        @Comment("Generate Chromite ore in the end")
        public boolean chromiteGenerate = true;
        @Comment("Max size of Chromite veins")
        @RangeInt(min = 1, max = 32)
        public int chromiteSize = 5;
        @Comment("Chance of Chromite veins to spawn")
        @RangeInt(min = 1, max = 32)
        public int chromiteWeight = 2;
    }

    @Comment("General configuration")
    @Config.RequiresMcRestart
    public static General general = new General();

    public static class General{
        @Comment("Enables removing of vanilla smelting of end game metals from all loaded mods")
        public boolean ingotsRequireBlastFurnace = true;
        @Comment("Removes all ic2 and gt crafting uu recipes and forces uu through the uu assembler.")
        public boolean removeCraftingUURecipes = false;
        @Comment("Removes vaniila log to charcoal furnace recipes. Will remove all furnace recipes that output charcoal.")
        public boolean removeVanillaCharcoalRecipe = false;
        @Comment("Makes regular and advanced circuits take plates in place of refined iron ingot and red alloy in place of redstone and also uninsulated copper cables.")
        public boolean harderCircuits = true;
        @Comment({
                "Enables plutonium, uranium, and custom added items giving radiation.",
                "Note: if ic2c extras is loaded, this will have no effect, as all items in this system will be added to ic2c extra's instead."
        })
        public boolean enableRadiation = true;
        @Comment("Removes log to planks and planks to sticks regular recipe. Will remove all vanilla (and modded) recipes that output planks from logs and sticks from planks.")
        public boolean planksNeedSaw = true;
    }
}
