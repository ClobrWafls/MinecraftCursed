package net.mcreator.minecraftcursed.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.EnchantmentHelper;

import net.mcreator.minecraftcursed.enchantment.CurseOfSoberingEnchantment;
import net.mcreator.minecraftcursed.MinecraftCursedModElements;
import net.mcreator.minecraftcursed.MinecraftCursedMod;

import java.util.Map;
import java.util.HashMap;

@MinecraftCursedModElements.ModElement.Tag
public class SoberPlayerProcedure extends MinecraftCursedModElements.ModElement {
	public SoberPlayerProcedure(MinecraftCursedModElements instance) {
		super(instance, 2);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MinecraftCursedMod.LOGGER.warn("Failed to load dependency entity for procedure SoberPlayer!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double enchantLevel = 0;
		enchantLevel = (double) (EnchantmentHelper.getEnchantmentLevel(CurseOfSoberingEnchantment.enchantment,
				((entity instanceof LivingEntity)
						? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 3))
						: ItemStack.EMPTY)));
		if (((enchantLevel) > 0)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).clearActivePotions();
		}
	}

	@SubscribeEvent
	public void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			Entity entity = event.getEntity();
			Entity sourceentity = event.getSource().getTrueSource();
			Entity imediatesourceentity = event.getSource().getImmediateSource();
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
			double amount = event.getAmount();
			World world = entity.world;
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("amount", amount);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("sourceentity", sourceentity);
			dependencies.put("imediatesourceentity", imediatesourceentity);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}
}
