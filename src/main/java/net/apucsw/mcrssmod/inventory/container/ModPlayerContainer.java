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


import com.mojang.datafixers.util.Pair;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.PlayerContainer;
import net.minecraft.inventory.container.Slot;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ModPlayerContainer extends PlayerContainer {
	public static final ResourceLocation EMPTY_WEARABLE_DEVICE_SLOT = new ResourceLocation("item/empty_wearable_device_slot.png");

	//public final boolean isLocalWorld;
	private final PlayerEntity player;

	public ModPlayerContainer(PlayerInventory playerInventory, boolean localWorld, PlayerEntity playerIn) {
		super(playerInventory, localWorld, playerIn);
		//super((ContainerType)null, 0);
		//this.isLocalWorld = localWorld;
		this.player = playerIn;

		int i1;
		int j1;
	}
	/*
	this.addSlot(new Slot(playerInventory, 40, 77, 8) {
		super();
		@OnlyIn(Dist.CLIENT)
		public Pair<ResourceLocation, ResourceLocation> getBackground() {
			return Pair.of(PlayerContainer.LOCATION_BLOCKS_TEXTURE, ModPlayerContainer.EMPTY_WEARABLE_DEVICE_SLOT);
		}
	});
	 */
}
