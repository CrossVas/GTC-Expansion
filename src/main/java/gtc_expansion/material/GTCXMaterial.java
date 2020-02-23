package gtc_expansion.material;

import gtc_expansion.GTCExpansion;
import gtclassic.api.material.GTMaterial;
import gtclassic.api.material.GTMaterialFlag;
import gtclassic.api.material.GTMaterialGen;

public class GTCXMaterial {
    static String modid = GTCExpansion.MODID;
    static String tex = modid + "_materials";


    public static final boolean pipes = false;

    static GTMaterialFlag particle = new GTMaterialFlag("_particle", tex,15, false, modid);
    static GTMaterialFlag fluid = GTMaterialFlag.FLUID;
    public static GTMaterialFlag molten = new GTMaterialFlag("molten", tex, 14, true, modid);
    static GTMaterialFlag gas = GTMaterialFlag.GAS;
    public static GTMaterialFlag smalldust = new GTMaterialFlag("_dustsmall", tex, 1, false, modid);
    public static GTMaterialFlag tinydust = new GTMaterialFlag("_dusttiny", tex, 13, false, modid);
    public static GTMaterialFlag crushedore = new GTMaterialFlag("_crushedore", tex, 10, true, modid);
    public static GTMaterialFlag crushedorePurified = new GTMaterialFlag("_crushedorepurified", tex, 12, false, modid);
    static GTMaterialFlag dust = GTMaterialFlag.DUST;
    static GTMaterialFlag gemRubyShape = GTMaterialFlag.RUBY;
    static GTMaterialFlag gemSapphireShape = GTMaterialFlag.SAPPHIRE;
    public static GTMaterialFlag gemGarnetShape = new GTMaterialFlag("_gem", tex, 0, false, modid);
    //public static GTMaterialFlag pipeFluid = GTMaterialFlag.PIPEFLUID;
    //public static GTMaterialFlag pipeItem = GTMaterialFlag.PIPEITEM;
    public static GTMaterialFlag pipeFluid = new GTMaterialFlag("_pipefluid", 0, false);
    public static GTMaterialFlag pipeItem = new GTMaterialFlag("_pipeitem", 0, false);
    static GTMaterialFlag ingot = GTMaterialFlag.INGOT;
    public static GTMaterialFlag hotIngot = GTMaterialFlag.INGOTHOT;
    public static GTMaterialFlag nugget = new GTMaterialFlag("_nugget", tex, 4, false, modid);
    public static GTMaterialFlag plate = new GTMaterialFlag("_plate", tex, 5, false, modid);
    public static GTMaterialFlag gear = new GTMaterialFlag("_gear", tex, 6, false, modid);
    public static GTMaterialFlag stick = new GTMaterialFlag("_stick", tex, 7, false, modid);
    public static GTMaterialFlag hull = new GTMaterialFlag("_hull", tex, 8, true, modid);
    static GTMaterialFlag blockMetal = GTMaterialFlag.BLOCKMETAL;
    public static GTMaterialFlag blockGem = GTMaterialFlag.BLOCKGEM;
    static GTMaterialFlag[] dustAll = { smalldust, dust };
    static GTMaterialFlag[] crushedAll = { dust, smalldust, crushedore, crushedorePurified };
    static GTMaterialFlag[] gemAll1 = { smalldust, dust, gemRubyShape, blockGem };
    static GTMaterialFlag[] gemAll2 = { smalldust, dust, gemSapphireShape, blockGem };
    static GTMaterialFlag[] gemAll3 = { smalldust, dust, gemGarnetShape, blockGem };
    static GTMaterialFlag[] metalFull = { molten, smalldust, dust, nugget, ingot, plate, stick, gear, blockMetal };
    static GTMaterialFlag[] metalFullWHull = { molten, smalldust, dust, nugget, ingot, plate, stick, gear, blockMetal, hull };
    static GTMaterialFlag[] metalFullHot = { molten, smalldust, dust, nugget, ingot, hotIngot, plate, stick, gear, blockMetal };
    static GTMaterialFlag[] metalBase = { molten, smalldust, dust, nugget, ingot, plate, stick };
    public static final GTMaterial Almandine = new GTMaterial("Almandine", 255, 0, 0, dustAll);
    public static final GTMaterial Andradite = new GTMaterial("Andradite", 150, 120, 0, dustAll);
    public static final GTMaterial Antimony = new GTMaterial(51,"Antimony", 1, 220, 220, 240, molten, smalldust, dust, tinydust, nugget, ingot, plate, stick, gear, blockMetal);
    public static final GTMaterial Ashes = new GTMaterial("Ashes", 192, 192, 192, dustAll);
    public static final GTMaterial BatteryAlloy = new GTMaterial("BatteryAlloy", 95, 77, 126, dust, ingot, smalldust, nugget, plate);
    public static final GTMaterial BioFuel = new GTMaterial("BioFuel", 153, 204, 0, fluid);
    public static final GTMaterial Brass = new GTMaterial("Brass", 1, 255, 180, 0, molten, smalldust, dust, nugget, ingot, plate, stick, gear, blockMetal, hull , pipeItem);
    public static final GTMaterial Bronze = new GTMaterial("Bronze", 1, 255, 128, 0, pipeFluid, molten, smalldust, nugget, plate, stick, gear, hull);
    public static final GTMaterial Charcoal = new GTMaterial("Charcoal", 100, 70, 70, smalldust);
    public static final GTMaterial Chromite = new GTMaterial("Chromite", 35, 20, 15, crushedAll);
    public static final GTMaterial Cinnabar = new GTMaterial("Cinnabar", 150, 0, 0, crushedAll);
    public static final GTMaterial Clay = new GTMaterial("Clay", 200, 200, 220, smalldust);
    public static final GTMaterial Coal = new GTMaterial("Coal", 70, 70, 70, smalldust);
    public static final GTMaterial CoalFuel = new GTMaterial("CoalFuel", 0, 0, 0, fluid);
    public static final GTMaterial Constantan = new GTMaterial("Constantan", 2, 227, 150, 128, pipeItem, dust, ingot, blockMetal, molten, smalldust, nugget, plate, stick, gear);
    public static final GTMaterial Copper = new GTMaterial(29,"Copper", 180, 113, 61, molten, smalldust, nugget, plate, stick, gear);
    public static final GTMaterial DarkAshes = new GTMaterial("DarkAshes", 50, 50, 50, dustAll);
    public static final GTMaterial Diamond = new GTMaterial("Diamond", 51, 235, 203, dustAll);
    public static final GTMaterial Diesel = new GTMaterial("Diesel", 255, 255, 0, fluid);
    public static final GTMaterial Endstone = new GTMaterial("Endstone", 250, 250, 198, dustAll);
    public static final GTMaterial Galena = new GTMaterial("Galena", 100, 60, 100, smalldust, dust, crushedore, crushedorePurified);
    public static final GTMaterial GarnetRed = new GTMaterial("RedGarnet", 200, 80, 80, gemAll3);
    public static final GTMaterial GarnetYellow = new GTMaterial("YellowGarnet", 200, 200, 80, dust, smalldust, gemGarnetShape, blockGem, tinydust);
    public static final GTMaterial Gasoline = new GTMaterial("Gasoline", 132, 114, 62, fluid);
    public static final GTMaterial Glowstone = new GTMaterial("Glowstone", 255, 255, 0, smalldust);
    public static final GTMaterial Glyceryl = new GTMaterial("Glyceryl",52, 157, 157, fluid);
    public static final GTMaterial Gold = new GTMaterial(79,"Gold", 1, 255, 255, 30, molten, smalldust, plate, stick, gear);
    public static final GTMaterial Granite = new GTMaterial("Granite", 165, 89, 39, dustAll);
    public static final GTMaterial Grossular = new GTMaterial("Grossular", 200, 100, 0, dust, smalldust, tinydust);
    public static final GTMaterial Gunpowder = new GTMaterial("Gunpowder", 128, 128, 128, smalldust);
    public static final GTMaterial Iron = new GTMaterial(26,"Iron", 1, 184, 184, 184, molten, smalldust, plate, stick, gear);
    public static final GTMaterial Kanthal = new GTMaterial("Kanthal", 219, 191, 111, false, dust, smalldust, nugget, ingot, plate, hotIngot);
    public static final GTMaterial Lead = new GTMaterial(82,"Lead", 140, 100, 140, molten, smalldust, dust, nugget, ingot, plate, stick, gear, blockMetal);
    public static final GTMaterial Magnalium = new GTMaterial("Magnalium", 2, 200, 190, 255, metalBase);
    public static final GTMaterial Magnesium = new GTMaterial(12,"Magnesium", 255, 200, 200, dustAll);
    public static final GTMaterial Manganese = new GTMaterial(25,"Manganese", 2, 250, 235, 250, molten, smalldust, dust, tinydust, nugget, ingot, plate, blockMetal);
    public static final GTMaterial Marble = new GTMaterial("Marble", 200, 200, 200, dustAll);
    public static final GTMaterial Naphtha = new GTMaterial("Naphtha", 255, 255, 100, fluid);
    public static final GTMaterial Netherrack = new GTMaterial("Netherrack", 200, 0, 0, smalldust);
    public static final GTMaterial Nichrome = new GTMaterial(-1,"Nichrome", 3, 205, 206, 246, false, molten, smalldust, dust, nugget, ingot, plate, stick, hotIngot);
    public static final GTMaterial NitricAcid = new GTMaterial("NitricAcid", 187, 165, 35, fluid);
    public static final GTMaterial NitroCarbon = new GTMaterial("NitroCarbon", 31, 94, 94, fluid);
    public static final GTMaterial NitroCoalFuel = new GTMaterial("NitroCoalFuel", 0, 43, 43, fluid);
    public static final GTMaterial NitroDiesel = new GTMaterial("NitroDiesel", 191, 255, 100, fluid);
    public static final GTMaterial NitrogenDioxide = new GTMaterial("NitrogenDioxide", 109, 185, 185, fluid);
    public static final GTMaterial Obsidian = new GTMaterial("Obsidian", 80, 50, 100, smalldust);
    public static final GTMaterial OilCrude = new GTMaterial("Crude_Oil", 0, 0, 0, fluid);
    public static final GTMaterial Olivine = new GTMaterial("Olivine", 150, 255, 150, gemAll1);
    public static final GTMaterial Osmium = new GTMaterial(76,"Osmium", 5, 50, 50, 255, false, molten, smalldust, dust, nugget, ingot, hotIngot, plate, stick, gear, blockMetal, tinydust);
    public static final GTMaterial Propane = new GTMaterial("Propane", 81, 27, 27, gas);
    public static final GTMaterial Pyrope = new GTMaterial("Pyrope", 120, 50, 100, dustAll);
    public static final GTMaterial RedAlloy = new GTMaterial("RedAlloy", 1, 200, 0, 0, molten, smalldust, dust, ingot, plate, nugget, stick);
    public static final GTMaterial RedRock = new GTMaterial("RedRock", 255, 80, 50, dustAll);
    public static final GTMaterial Redstone = new GTMaterial("Redstone", 200, 0, 0, smalldust, tinydust);
    public static final GTMaterial RefinedIron = new GTMaterial("RefinedIron", 1, 220, 235, 235, stick, plate, gear, hull, molten);
    public static final GTMaterial Rubber = new GTMaterial("Rubber", 127, 82, 0, dust);
    public static final GTMaterial Saltpeter = new GTMaterial("Saltpeter", 230, 230, 230, dustAll);
    public static final GTMaterial Silver = new GTMaterial("Silver", 215, 225, 230, molten, smalldust, nugget, plate, stick, gear);
    public static final GTMaterial Slag = new GTMaterial("Slag", 64, 48, 0, dustAll);
    public static final GTMaterial SodiumPersulfate = new GTMaterial("SodiumPersulfate", 0, 102, 70, fluid);
    public static final GTMaterial SodiumSulfide = new GTMaterial("SodiumSulfide", 161, 168, 73, fluid);
    public static final GTMaterial Spessartine = new GTMaterial("Spessartine", 255, 100, 100, dustAll);
    public static final GTMaterial Sphalerite = new GTMaterial("Sphalerite", 200, 140, 40, crushedAll);
    public static final GTMaterial StainlessSteel = new GTMaterial(-1, "StainlessSteel", 3, 200, 200, 220, false, molten, smalldust, dust, nugget, ingot, plate, stick, gear, blockMetal, hull, pipeFluid);
    public static final GTMaterial Steel = new GTMaterial(-1, "Steel", 2, 128, 128, 128, false, molten, smalldust, dust, nugget, ingot, plate, stick, gear, blockMetal, hull, pipeFluid);
    public static final GTMaterial Stone = new GTMaterial("Stone", 196, 196, 196, dustAll);
    public static final GTMaterial SulfuricAcid = new GTMaterial("SulfuricAcid", 255, 106, 0, fluid);
    public static final GTMaterial Tetrahedrite = new GTMaterial("Tetrahedrite", 200, 32, 0 , smalldust, dust, crushedore, crushedorePurified);
    public static final GTMaterial Tin = new GTMaterial("Tin", 220, 220, 220, molten, smalldust, nugget, plate, stick, gear);
    public static final GTMaterial TungstenSteel = new GTMaterial(-1, "Tungstensteel", 4, 100, 100, 160, false, molten, smalldust, dust, nugget, ingot, hotIngot, plate, stick, gear, blockMetal, hull, pipeFluid);
    public static final GTMaterial Uvarovite = new GTMaterial("Uvarovite", 180, 255, 180, dustAll);
    public static final GTMaterial Zinc = new GTMaterial(30,"Zinc", 1, 250, 240, 240, molten, smalldust, dust, nugget, ingot, plate, stick, gear, blockMetal, tinydust);

    public static void initMaterials(){
        GTMaterial.Aluminium.addFlags(metalFullWHull).setSmeltable(false);
        GTMaterial.Bauxite.addFlags(smalldust, crushedore, crushedorePurified);
        GTMaterial.Basalt.addFlags(smalldust);
        //GTMaterial.Bronze.addFlags(molten, smalldust, nugget, plate, stick, gear, hull);
        GTMaterial.Calcite.addFlags(smalldust);
        GTMaterial.Carbon.addFlags(smalldust);
        GTMaterial.Chrome.addFlags(metalFull).addFlags(tinydust).setSmeltable(false);
        //GTMaterial.Constantan.addFlags(molten, smalldust, nugget, plate, stick);
        GTMaterial.Electrum.addFlags(metalFull);
        GTMaterial.Emerald.addFlags(smalldust);
        GTMaterial.EnderEye.addFlags(smalldust);
        GTMaterial.EnderPearl.addFlags(smalldust);
        GTMaterial.Flint.addFlags(smalldust);
        GTMaterial.Invar.addFlags(metalFull);
        GTMaterial.Iridium.addFlags(molten, smalldust, nugget, hotIngot, gear, stick, tinydust, crushedore, crushedorePurified).setSmeltable(false);
        GTMaterial.Lazurite.addFlags(smalldust);
        GTMaterial.Lithium.addFlags(smalldust);
        GTMaterial.Nickel.addFlags(molten, smalldust, nugget, plate, stick, gear, tinydust);
        GTMaterial.Phosphorus.addFlags(smalldust, tinydust);
        GTMaterial.Platinum.addFlags(molten, smalldust, nugget, plate, stick, gear, tinydust, crushedore, crushedorePurified);
        GTMaterial.Plutonium.addFlags(smalldust, nugget, plate, molten);
        GTMaterial.Pyrite.addFlags(crushedAll);
        GTMaterial.Ruby.addFlags(smalldust);
        GTMaterial.Sapphire.addFlags(smalldust);
        GTMaterial.Silicon.addFlags(fluid, smalldust, nugget, plate);
        GTMaterial.Sodalite.addFlags(smalldust);
        GTMaterial.Sulfur.addFlags(smalldust, tinydust);
        GTMaterial.Technetium.addFlags(smalldust, plate, stick, gear, nugget, molten);
        GTMaterial.Thorium.addFlags(smalldust, nugget, molten).setSmeltable(false);
        GTMaterial.Titanium.addFlags(molten, smalldust, tinydust, nugget, plate, stick, gear, hull).setSmeltable(false);
        GTMaterial.Tungsten.addFlags(molten, smalldust, nugget, hotIngot, plate, stick, gear, crushedore, crushedorePurified).setSmeltable(false);
        GTMaterial.Uranium.addFlags(smalldust, molten);
        GTMaterial.Wood.addFlags(smalldust);

        GTMaterialGen.addItemFlag(smalldust);
        GTMaterialGen.addItemFlag(tinydust);
        GTMaterialGen.addItemFlag(crushedore);
        GTMaterialGen.addItemFlag(crushedorePurified);
        GTMaterialGen.addItemFlag(gemGarnetShape);
        GTMaterialGen.addItemFlag(nugget);
        GTMaterialGen.addItemFlag(plate);
        GTMaterialGen.addItemFlag(gear);
        GTMaterialGen.addItemFlag(stick);
        GTMaterialGen.addItemFlag(hull);
        GTMaterialGen.addFluidFlag(molten);
    }

}
