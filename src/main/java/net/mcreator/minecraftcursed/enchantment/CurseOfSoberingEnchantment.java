
package net.mcreator.minecraftcursed.enchantment;

@MinecraftCursedModElements.ModElement.Tag
public class CurseOfSoberingEnchantment extends MinecraftCursedModElements.ModElement {

	@ObjectHolder("minecraft_cursed:curse_of_sobering")
	public static final Enchantment enchantment = null;

	public CurseOfSoberingEnchantment(MinecraftCursedModElements instance) {
		super(instance, 1);
	}

	@Override
	public void initElements() {
		elements.enchantments.add(() -> new CustomEnchantment(EquipmentSlotType.MAINHAND).setRegistryName("curse_of_sobering"));
	}

	public static class CustomEnchantment extends Enchantment {

		public CustomEnchantment(EquipmentSlotType... slots) {
			super(Enchantment.Rarity.RARE, EnchantmentType.ARMOR_HEAD, slots);
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
		public boolean isTreasureEnchantment() {
			return true;
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
