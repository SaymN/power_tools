package ch.saymn.power_tools.init;

import info.u_team.u_team_core.util.registry.BaseRegistryUtil;
import ch.saymn.power_tools.power_tools;
import ch.saymn.power_tools.item.*;
import ch.saymn.power_tools.type.Backpack;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(modid = power_tools.MODID, bus = Bus.MOD)
public class BackpackItems {
	
	public static final backpack_item SMALL_BACKPACK = new backpack_item(Backpack.SMALL);
	public static final backpack_item MEDIUM_BACKPACK = new backpack_item(Backpack.MEDIUM);
	public static final backpack_item LARGE_BACKPACK = new backpack_item(Backpack.LARGE);
	
//	@SubscribeEvent
//	public static void register(Register<Item> event) {
//		BaseRegistryUtil.getAllRegistryEntriesAndApplyNames(power_tools.MODID, Item.class).forEach(event.getRegistry()::register);
//	}
	
}