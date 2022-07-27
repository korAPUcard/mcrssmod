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

import net.minecraft.util.DamageSource;

public class RSSDamageSource extends DamageSource {
	public static final DamageSource THIRSTY = (new DamageSource("thirsty")).setDamageBypassesArmor().setDamageIsAbsolute();
	public static final DamageSource SUFFOCATION = (new DamageSource("suffocation")).setDamageBypassesArmor();
	public static final DamageSource INFECTION = (new DamageSource("infection")).setDamageBypassesArmor();
	public static final DamageSource ILLNESS = (new DamageSource("illness")).setDamageBypassesArmor();
	public static final DamageSource BODY_TOXIN = (new DamageSource("body_toxin")).setDamageBypassesArmor();
	public static final DamageSource BLOOD_TOXIN = (new DamageSource("blood_toxin")).setDamageBypassesArmor();


	public RSSDamageSource(String damageTypeIn) {
		super(damageTypeIn);
	}
}
