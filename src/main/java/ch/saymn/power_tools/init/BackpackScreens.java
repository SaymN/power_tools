package ch.saymn.power_tools.init;

import ch.saymn.power_tools.power_tools;
import ch.saymn.power_tools.screen.BackpackScreen;
import net.minecraft.client.gui.ScreenManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(modid = power_tools.MODID, bus = Bus.MOD, value = Dist.CLIENT)
public class BackpackScreens {
	
	@SubscribeEvent
	public static void register(FMLClientSetupEvent event) {
		ScreenManager.registerFactory(BackpackContainerTypes.BACKPACK, BackpackScreen::new);
	}
}