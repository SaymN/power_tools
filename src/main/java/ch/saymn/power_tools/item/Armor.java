package ch.saymn.power_tools.item;

import ch.saymn.power_tools.power_tools;
import ch.saymn.power_tools.init.ModItemGroup;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;

public class Armor extends ArmorItem {
    public Armor(ArmorTypes type, EquipmentSlotType slot, String typeName) {
        super(type.getType(), slot, new Item.Properties().group(ModItemGroup.POWER_TOOLS));
        this.setRegistryName(power_tools.MODID, type.getName() + "_" + typeName);
    }
}