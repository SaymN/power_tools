package ch.saymn.power_tools.data;

import ch.saymn.power_tools.power_tools;
import ch.saymn.power_tools.data.provider.ModBlockTagsProvider;
import ch.saymn.power_tools.data.provider.ModItemTagsProvider;
import ch.saymn.power_tools.data.provider.ModRecipeProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@EventBusSubscriber(modid = power_tools.MODID, bus = Bus.MOD)
public class ModDataGenerator {
	
	@SubscribeEvent
	public static void data(GatherDataEvent event) {
		final DataGenerator generator = event.getGenerator();
		if (event.includeServer()) {
			generator.addProvider(new ModBlockTagsProvider(generator));
			generator.addProvider(new ModItemTagsProvider(generator));
			generator.addProvider(new ModRecipeProvider(generator));
		}
	}

}
