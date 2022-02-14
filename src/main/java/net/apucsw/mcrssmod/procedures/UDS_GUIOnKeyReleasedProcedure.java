package net.apucsw.mcrssmod.procedures;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.apucsw.mcrssmod.McrssmodModVariables;
import net.apucsw.mcrssmod.McrssmodMod;

import java.util.Map;

public class UDS_GUIOnKeyReleasedProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				McrssmodMod.LOGGER.warn("Failed to load dependency entity for procedure UDS_GUIOnKeyReleased!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).closeScreen();
		{
			boolean _setval = (false);
			entity.getCapability(McrssmodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.isKeyHolding = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		return (entity.getCapability(McrssmodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new McrssmodModVariables.PlayerVariables())).isKeyHolding;
	}
}
