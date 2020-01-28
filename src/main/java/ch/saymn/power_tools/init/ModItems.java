package ch.saymn.power_tools.init;

import ch.saymn.power_tools.power_tools;
import ch.saymn.power_tools.item.*;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.IForgeRegistry;

@EventBusSubscriber(modid = power_tools.MODID, bus = Bus.MOD)
public class ModItems {
	
	public static final bornite_ingot bornite_ingot = new bornite_ingot();
	public static final bornite_dust bornite_dust = new bornite_dust();
	public static final bornite_nugget bornite_nugget = new bornite_nugget();
	
	public static final bornite_pickaxe bornite_pickaxe = new bornite_pickaxe(ModToolList.bornite_pickaxe, -5, 0.0f, new Item.Properties().group(ModItemGroup.POWER_TOOLS));
	public static final bornite_shovel bornite_shovel = new bornite_shovel(ModToolList.bornite_shovel, -5, 0.0f, new Item.Properties().group(ModItemGroup.POWER_TOOLS));
	public static final bornite_axe bornite_axe = new bornite_axe(ModToolList.bornite_axe, -5, 0.0f, new Item.Properties().group(ModItemGroup.POWER_TOOLS));
	public static final bornite_hoe bornite_hoe = new bornite_hoe(ModToolList.bornite_hoe, -5, new Item.Properties().group(ModItemGroup.POWER_TOOLS));
	public static final bornite_sword bornite_sword = new bornite_sword(ModToolList.bornite_sword, -5, 0.0f, new Item.Properties().group(ModItemGroup.POWER_TOOLS));

	@SubscribeEvent
	public static void register(Register<Item> event) {
		final IForgeRegistry<Item> registry = event.getRegistry();
		
		registry.register(bornite_ingot.setRegistryName(power_tools.MODID, "bornite_ingot"));
		registry.register(bornite_dust.setRegistryName(power_tools.MODID, "bornite_dust"));
		registry.register(bornite_nugget.setRegistryName(power_tools.MODID, "bornite_nugget"));
		registry.register(bornite_pickaxe.setRegistryName(power_tools.MODID, "bornite_pickaxe"));
		registry.register(bornite_shovel.setRegistryName(power_tools.MODID, "bornite_shovel"));
		registry.register(bornite_axe.setRegistryName(power_tools.MODID, "bornite_axe"));
		registry.register(bornite_hoe.setRegistryName(power_tools.MODID, "bornite_hoe"));
		registry.register(bornite_sword.setRegistryName(power_tools.MODID, "bornite_sword"));
		
		EquipmentSlotType[] slotTypes = new EquipmentSlotType[]{EquipmentSlotType.HEAD, EquipmentSlotType.CHEST, EquipmentSlotType.LEGS, EquipmentSlotType.FEET};
        String[] names = new String[]{"helmet", "chestplate", "leggings", "boots"};

        for (ArmorTypes type : ArmorTypes.values()) {
            for (int i = 0; i < slotTypes.length; i++) {
                event.getRegistry().register(new Armor(type, slotTypes[i], names[i]));
            }
        }
	}

}
