
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.apucsw.mcrssmod.init;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class McrssmodModTabs {
	public static CreativeModeTab TAB_RSS_TAB;

	public static void load() {
		TAB_RSS_TAB = new CreativeModeTab("tabrss_tab") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(Items.POTION);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
}
