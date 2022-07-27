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

import com.google.common.collect.Lists;
import com.mojang.datafixers.util.Pair;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import net.minecraft.potion.EffectInstance;

public class Drink {
	private final int value;
	private final float saturation;
	private final boolean drinkableWater;
	private final boolean canDrinkWhenFull;
	private final boolean fastToDrink;
	private final List<Pair<Supplier<EffectInstance>, Float>> effects;

	private Drink(Drink.Builder builder) {
		this.value = builder.value;
		this.saturation = builder.saturation;
		this.drinkableWater = builder.drinkableWater;
		this.canDrinkWhenFull = builder.alwaysDrinkable;
		this.fastToDrink = builder.fastToDrink;
		this.effects = builder.effects;
	}

	/** @deprecated */
	@Deprecated
	private Drink(int healing, float saturationIn, boolean isDrinkableWater, boolean alwaysDrinkable, boolean fastDrinkable, List<Pair<EffectInstance, Float>> effectsIn) {
		this.value = healing;
		this.saturation = saturationIn;
		this.drinkableWater = isDrinkableWater;
		this.canDrinkWhenFull = alwaysDrinkable;
		this.fastToDrink = fastDrinkable;
		this.effects = effectsIn.stream().map(pair -> Pair.<java.util.function.Supplier<EffectInstance>, Float>of(pair::getFirst, pair.getSecond())).collect(java.util.stream.Collectors.toList());
		/*
		this.effects = (List)effectsIn.stream().map((pair) -> {
			return Pair.of(pair::getFirst, pair.getSecond());
		}).collect(Collectors.toList());		// FIXME: Syntax error has been occurred in 'pair::getFirst' part. "Object is not a function interface."
		*/
	}

	public int getHealing() {
		return this.value;
	}

	public float getSaturation() {
		return this.saturation;
	}

	public boolean isDrinkableWater() {
		return this.drinkableWater;
	}

	public boolean canDrinkWhenFull() {
		return this.canDrinkWhenFull;
	}

	public boolean isFastDrinking() {
		return this.fastToDrink;
	}

	public List<Pair<EffectInstance, Float>> getEffects() {
		return (List)this.effects.stream().map((pair) -> {
			return Pair.of(pair.getFirst() != null ? (EffectInstance)((Supplier)pair.getFirst()).get() : null, pair.getSecond());
		}).collect(Collectors.toList());
	}

	public static class Builder {
		private int value;
		private float saturation;
		private boolean drinkableWater;
		private boolean alwaysDrinkable;
		private boolean fastToDrink;
		private final List<Pair<Supplier<EffectInstance>, Float>> effects = Lists.newArrayList();

		public Builder() {
		}

		public Drink.Builder thirsty(int thirstyIn) {
			this.value = thirstyIn;
			return this;
		}

		public Drink.Builder saturation(float saturationIn) {
			this.saturation = saturationIn;
			return this;
		}

		public Drink.Builder drinkableWater() {
			this.drinkableWater = true;
			return this;
		}

		public Drink.Builder setAlwaysDrinkable() {
			this.alwaysDrinkable = true;
			return this;
		}

		public Drink.Builder fastToDrink() {
			this.fastToDrink = true;
			return this;
		}

		public Drink.Builder effect(Supplier<EffectInstance> effectIn, float probability) {
			this.effects.add(Pair.of(effectIn, probability));
			return this;
		}

		/** @deprecated */
		@Deprecated
		public Drink.Builder effect(EffectInstance effectIn, float probability) {
			this.effects.add(Pair.of(() -> {
				return effectIn;
			}, probability));
			return this;
		}

		public Drink build() {
			return new Drink(this);
		}
	}
}
