package ch.saymn.power_tools.init;

import info.u_team.u_team_core.containertype.UContainerType;
import info.u_team.u_team_core.util.registry.BaseRegistryUtil;
import ch.saymn.power_tools.power_tools;
import ch.saymn.power_tools.container.*;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(modid = power_tools.MODID, bus = Bus.MOD)
public class BackpackContainerTypes {
	
	public static final ContainerType<BackpackContainer> BACKPACK = new UContainerType<>("backpack", BackpackContainer::createClientContainer);
	
	@SubscribeEvent
	public static void register(Register<ContainerType<?>> event) {
		BaseRegistryUtil.getAllGenericRegistryEntriesAndApplyNames(power_tools.MODID, ContainerType.class).forEach(event.getRegistry()::register);
	}
}