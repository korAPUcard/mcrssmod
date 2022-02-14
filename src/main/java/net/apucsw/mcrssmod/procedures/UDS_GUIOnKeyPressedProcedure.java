package net.apucsw.mcrssmod.procedures;

import net.minecraft.entity.Entity;

import net.apucsw.mcrssmod.McrssmodModVariables;
import net.apucsw.mcrssmod.McrssmodMod;

import java.util.Map;

public class UDS_GUIOnKeyPressedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				McrssmodMod.LOGGER.warn("Failed to load dependency entity for procedure UDS_GUIOnKeyPressed!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		{
			boolean _setval = (true);
			entity.getCapability(McrssmodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.isKeyHolding = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
