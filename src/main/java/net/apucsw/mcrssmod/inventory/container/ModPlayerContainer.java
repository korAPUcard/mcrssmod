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
package net.apucsw.mcrssmod.inventory.container;


import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.PlayerContainer;
import net.minecraft.util.ResourceLocation;

public class ModPlayerContainer extends PlayerContainer {
	public static final ResourceLocation EMPTY_WEARABLE_DEVICE_SLOT = new ResourceLocation("item/empty_wearable_device_slot.png");

	public ModPlayerContainer(PlayerInventory playerInventory, boolean localWorld, PlayerEntity playerIn) {
		super(playerInventory, localWorld, playerIn);
	}
}
