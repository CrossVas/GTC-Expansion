package gtc_expansion.util;

import java.util.Random;

import net.minecraft.item.ItemStack;

public class GTCXHelperStack {
	
	/** damages craftingTools on crafting **/
	public static boolean damageItem(ItemStack stack, int damageInt) {
		if (stack.isItemStackDamageable()) {
			if (stack.attemptDamageItem(damageInt, new Random(), null)) {
				stack.shrink(1);
			}
			return true;
		}
		return false;
	}
}
