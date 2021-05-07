
package net.mcreator.minecraftcursed.enchantment;

@MinecraftCursedModElements.ModElement.Tag
public class CurseOfHoesEnchantment extends MinecraftCursedModElements.ModElement {

	@ObjectHolder("minecraft_cursed:curse_of_hoes")
	public static final Enchantment enchantment = null;

	public CurseOfHoesEnchantment(MinecraftCursedModElements instance) {
		super(instance, 1);
	}

	@Override
	public void initElements() {
		elements.enchantments.add(() -> new CustomEnchantment(EquipmentSlotType.MAINHAND).setRegistryName("curse_of_hoes"));
	}

	public static class CustomEnchantment extends Enchantment {

		public CustomEnchantment(EquipmentSlotType... slots) {
			super(Enchantment.Rarity.COMMON, EnchantmentType.BREAKABLE, slots);
		}

		@Override
		public int getMinLevel() {
			return 1;
		}

		@Override
		public int getMaxLevel() {
			return 1;
		}

		@Override
		public boolean canApplyAtEnchantingTable(ItemStack stack) {
			if (stack.getItem() == new ItemStack(Items.WOODEN_HOE, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(Items.STONE_HOE, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(Items.IRON_HOE, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(Items.GOLDEN_HOE, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(Items.DIAMOND_HOE, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(Items.NETHERITE_HOE, (int) (1)).getItem())
				return true;
			return false;
		}

		@Override
		public boolean isTreasureEnchantment() {
			return false;
		}

		@Override
		public boolean isCurse() {
			return true;
		}

		@Override
		public boolean isAllowedOnBooks() {
			return true;
		}

	}

}
