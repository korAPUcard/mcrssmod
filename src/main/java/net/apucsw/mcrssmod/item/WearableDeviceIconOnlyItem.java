
package net.apucsw.mcrssmod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.block.BlockState;

import net.apucsw.mcrssmod.McrssmodModElements;

import java.util.List;

@McrssmodModElements.ModElement.Tag
public class WearableDeviceIconOnlyItem extends McrssmodModElements.ModElement {
	@ObjectHolder("mcrssmod:wearable_device_icon_only")
	public static final Item block = null;

	public WearableDeviceIconOnlyItem(McrssmodModElements instance) {
		super(instance, 4);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(null).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("wearable_device_icon_only");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 0F;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("\u00A7cNo obtainable Item"));
			list.add(new StringTextComponent("\u00A7cATTENSION: Icon Only Item, Non functionalable"));
		}
	}
}
