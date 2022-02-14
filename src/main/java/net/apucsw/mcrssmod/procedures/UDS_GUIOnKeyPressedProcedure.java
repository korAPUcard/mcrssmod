package net.apucsw.mcrssmod.procedures;

import net.minecraftforge.fml.network.NetworkHooks;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.network.PacketBuffer;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.apucsw.mcrssmod.gui.UserDataStatusGui;
import net.apucsw.mcrssmod.McrssmodModVariables;
import net.apucsw.mcrssmod.McrssmodMod;

import java.util.Map;

import io.netty.buffer.Unpooled;

public class UDS_GUIOnKeyPressedProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				McrssmodMod.LOGGER.warn("Failed to load dependency world for procedure UDS_GUIOnKeyPressed!");
			return false;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				McrssmodMod.LOGGER.warn("Failed to load dependency entity for procedure UDS_GUIOnKeyPressed!");
			return false;
		}
		IWorld world = (IWorld) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");
		{
			Entity _ent = entity;
			if (_ent instanceof ServerPlayerEntity) {
				BlockPos _bpos = new BlockPos((int) 0, (int) 0, (int) 0);
				NetworkHooks.openGui((ServerPlayerEntity) _ent, new INamedContainerProvider() {
					@Override
					public ITextComponent getDisplayName() {
						return new StringTextComponent("UserDataStatus");
					}

					@Override
					public Container createMenu(int id, PlayerInventory inventory, PlayerEntity player) {
						return new UserDataStatusGui.GuiContainerMod(id, inventory, new PacketBuffer(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		}
		{
			boolean _setval = (true);
			entity.getCapability(McrssmodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.isKeyHolding = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		return (entity.getCapability(McrssmodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new McrssmodModVariables.PlayerVariables())).isKeyHolding;
	}
}
