package net.mcreator.minecraftcursed.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.UseHoeEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;

import net.mcreator.minecraftcursed.MinecraftCursedModElements;

import java.util.Map;
import java.util.HashMap;

@MinecraftCursedModElements.ModElement.Tag
public class CurseOfHoesUsedProcedure extends MinecraftCursedModElements.ModElement {
	public CurseOfHoesUsedProcedure(MinecraftCursedModElements instance) {
		super(instance, 2);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		ItemStack HoeInHand = ItemStack.EMPTY;
	}

	@SubscribeEvent
	public void onUseHoe(UseHoeEvent event) {
		PlayerEntity entity = event.getPlayer();
		double i = event.getContext().getPos().getX();
		double j = event.getContext().getPos().getY();
		double k = event.getContext().getPos().getZ();
		World world = entity.world;
		Map<String, Object> dependencies = new HashMap<>();
		dependencies.put("x", i);
		dependencies.put("y", j);
		dependencies.put("z", k);
		dependencies.put("world", world);
		dependencies.put("entity", entity);
		dependencies.put("event", event);
		this.executeProcedure(dependencies);
	}
}
