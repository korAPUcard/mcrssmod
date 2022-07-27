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
package net.apucsw.mcrssmod.util;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.Difficulty;
import net.minecraft.world.GameRules;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.apucsw.mcrssmod.item.Drink;
import net.apucsw.mcrssmod.util.RSSDamageSource;

public class WaterStats {
	private int waterLevel = 20;
	private float waterSaturationLevel = 5.0F;
	private float waterExhaustionLevel;
	private int waterTimer;
	private int prevWaterLevel = 20;

	public WaterStats() {
	}

	public void addStats(int waterLevelIn, float waterSaturationModifier) {
		this.waterLevel = Math.min(waterLevelIn + this.waterLevel, 20);
		this.waterSaturationLevel = Math.min(this.waterSaturationLevel + (float)waterLevelIn * waterSaturationModifier * 2.0F, (float)this.waterLevel);
	}
	/*			// FIXME: Syntax error has been occurred in this part. Can't solve the problem about 'isDrink()' and 'getDrink()'.
	public void consume(Item maybeDrink, ItemStack stack) {
		if (maybeDrink.isDrink()) {
			Drink drink = maybeDrink.getDrink();
			this.addStats(drink.getHealing(), drink.getSaturation());
		}
	}
	*/
	public void consume(Item maybeFood, ItemStack stack) {
		if (maybeFood.isFood()) {
			Food food = maybeFood.getFood();
			this.addStats(food.getHealing(), food.getSaturation());
		}
	}

	public void tick(PlayerEntity player) {
		Difficulty difficulty = player.world.getDifficulty();
		this.prevWaterLevel = this.waterLevel;
		if (this.waterExhaustionLevel > 4.0F) {
			this.waterExhaustionLevel -= 4.0F;
			if (this.waterSaturationLevel > 0.0F) {
				this.waterSaturationLevel = Math.max(this.waterSaturationLevel - 1.0F, 0.0F);
			} else if (difficulty != Difficulty.PEACEFUL) {
				this.waterLevel = Math.max(this.waterLevel - 1, 0);
			}
		}

		boolean flag = player.world.getGameRules().getBoolean(GameRules.NATURAL_REGENERATION);
		if (flag && this.waterSaturationLevel > 0.0F && player.shouldHeal() && this.waterLevel >= 20) {
			++this.waterTimer;
			if (this.waterTimer >= 10) {
				float f = Math.min(this.waterSaturationLevel, 6.0F);
				player.heal(f / 6.0F);
				this.addExhaustion(f);
				this.waterTimer = 0;
			}
		} else if (flag && this.waterLevel >= 18 && player.shouldHeal()) {
			++this.waterTimer;
			if (this.waterTimer >= 80) {
				player.heal(1.0F);
				this.addExhaustion(6.0F);
				this.waterTimer = 0;
			}
		} else if (this.waterLevel <= 0) {
			++this.waterTimer;
			if (this.waterTimer >= 80) {
				if (player.getHealth() > 10.0F || difficulty == Difficulty.HARD || player.getHealth() > 1.0F && difficulty == Difficulty.NORMAL) {
					player.attackEntityFrom(RSSDamageSource.THIRSTY, 1.0F);
				}

				this.waterTimer = 0;
			}
		} else {
			this.waterTimer = 0;
		}
	}

	public void read(CompoundNBT compound) {
		if (compound.contains("waterLevel", 99)) {
			this.waterLevel = compound.getInt("waterLevel");
			this.waterTimer = compound.getInt("waterTickTimer");
			this.waterSaturationLevel = compound.getFloat("waterSaturationLevel");
			this.waterExhaustionLevel = compound.getFloat("waterExhaustionLevel");
		}
	}

	public void write(CompoundNBT compound) {
		compound.putInt("waterLevel", this.waterLevel);
		compound.putInt("waterTickTimer", this.waterTimer);
		compound.putFloat("waterSaturationLevel", this.waterSaturationLevel);
		compound.putFloat("waterExhaustionLevel", this.waterExhaustionLevel);
	}

	public int getWaterLevel() {
		return this.waterLevel;
	}

	public boolean needWater() {
		return this.waterLevel < 20;
	}

	public void addExhaustion(float exhaustion) {
		this.waterExhaustionLevel = Math.min(this.waterExhaustionLevel + exhaustion, 40.0F);
	}

	public float getSaturationLevel() {
		return this.waterSaturationLevel;
	}

	public void setWaterLevel(int waterLevelIn) {
		this.waterLevel = waterLevelIn;
	}

	@OnlyIn(Dist.CLIENT)
	public void setWaterSaturationLevel(float waterSaturationLevelIn) {
		this.waterSaturationLevel = waterSaturationLevelIn;
	}
}
