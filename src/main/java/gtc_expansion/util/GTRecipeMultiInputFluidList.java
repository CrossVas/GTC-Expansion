package gtc_expansion.util;

import gtclassic.util.recipe.GTRecipeMultiInputList;
import ic2.api.classic.recipe.machine.MachineOutput;
import ic2.api.recipe.IRecipeInput;
import net.minecraftforge.fluids.FluidStack;

import java.util.List;

public class GTRecipeMultiInputFluidList extends GTRecipeMultiInputList {
    public GTRecipeMultiInputFluidList(String category, int energy) {
        super(category, energy);
    }

    public GTRecipeMultiInputFluidList(String category) {
        super(category);
    }

    public static class MultiRecipe2 extends MultiRecipe{
        FluidStack inputFluid;
        public MultiRecipe2(List<IRecipeInput> inputs, FluidStack inputFluid, MachineOutput outputs, String id, int eu) {
            super(inputs, outputs, id, eu);
            this.inputFluid = inputFluid;
        }

        public FluidStack getFluidStack() {
            return inputFluid;
        }
    }
}
