package net.mcreator.minecraftcursed.procedures;

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
