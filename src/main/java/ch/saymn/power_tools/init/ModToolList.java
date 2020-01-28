package ch.saymn.power_tools.init;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;

public enum ModToolList implements IItemTier
{
	bornite_pickaxe(10.0f, 10.0f, 2000, 3, 25, ModItems.bornite_ingot),
	bornite_shovel(10.0f, 10.0f, 2000, 3, 25, ModItems.bornite_ingot),
	bornite_axe(10.0f, 10.0f, 2000, 3, 25, ModItems.bornite_ingot),
	bornite_hoe(10.0f, 10.0f, 2000, 3, 25, ModItems.bornite_ingot),	
	bornite_sword(10.0f, 10.0f, 2000, 3, 25, ModItems.bornite_ingot);
	
	private float attackDamage, efficency;
	private int durability, harvestLevel, enchantability;
	private Item repairMaterial;
	
	private ModToolList(float attackDamage, float efficency, int durability, int harvestLevel, int enchantability, Item repairMaterial)
	{
		this.attackDamage = attackDamage;
		this.efficency = efficency;
		this.durability = durability;
		this.harvestLevel = harvestLevel;
		this.enchantability = enchantability;
		this.repairMaterial = repairMaterial;
	}

	@Override
	public int getMaxUses() {
		// TODO Auto-generated method stub
		return this.durability;
	}

	@Override
	public float getEfficiency() {
		// TODO Auto-generated method stub
		return this.efficency;
	}

	@Override
	public float getAttackDamage() {
		// TODO Auto-generated method stub
		return this.attackDamage;
	}

	@Override
	public int getHarvestLevel() {
		// TODO Auto-generated method stub
		return this.harvestLevel;
	}

	@Override
	public int getEnchantability() {
		// TODO Auto-generated method stub
		return this.enchantability;
	}

	@Override
	public Ingredient getRepairMaterial() {
		// TODO Auto-generated method stub
		return Ingredient.fromItems(this.repairMaterial);
	}

}
