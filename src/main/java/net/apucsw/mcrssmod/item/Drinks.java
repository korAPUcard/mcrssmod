/**
 * The code of this mod element is always locked.
 *
 * You can register new events in this class too.
 *
 * If you want to make a plain independent class, create it using
 * Project Browser -> New... and make sure to make the class
 * outside net.apucsw.mcrssmod as this package is managed by MCreator.
 *
 * If you change workspace package, modid or prefix, you will need
 * to manually adapt this file to these changes or remake it.
 *
 * This class will be added in the mod root package.
*/
package net.apucsw.mcrssmod.item;

import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

import net.apucsw.mcrssmod.item.Drink.Builder;

public class Drinks {
	public static final Drink BOTTLE_OF_DIRTY_WATER = (new Builder()).thirsty(3).saturation(0.1F).effect(new EffectInstance(Effects.POISON, 600, 0), 0.3F).build();
	public static final Drink BOTTLE_OF_DRINKABLE_WATER = (new Builder()).thirsty(4).saturation(0.3F).drinkableWater().build();

	public Drinks() {
	}
}
