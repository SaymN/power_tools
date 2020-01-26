package ch.saymn.power_tools.init;

import ch.saymn.power_tools.power_tools;
import ch.saymn.power_tools.block.bornite_block;
import ch.saymn.power_tools.block.bornite_ore;
import ch.saymn.power_tools.block.bornite_slab;
import ch.saymn.power_tools.block.bornite_stairs;
import ch.saymn.power_tools.item.ModBlockItem;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.IForgeRegistry;

@EventBusSubscriber(modid = power_tools.MODID, bus = Bus.MOD)
public class ModBlocks {
	
	public static final bornite_ore bornite_ore = new bornite_ore();
	public static final bornite_block bornite_block = new bornite_block();
	public static final bornite_slab bornite_slab = new bornite_slab();
	public static final bornite_stairs bornite_stairs = new bornite_stairs(ModBlocks.bornite_block.getDefaultState(), Block.Properties.from(ModBlocks.bornite_block));

	
	@SubscribeEvent
	public static void register(Register<Block> event) {
		final IForgeRegistry<Block> registry = event.getRegistry();
		
		registry.register(bornite_ore.setRegistryName(power_tools.MODID, "bornite_ore"));
		registry.register(bornite_block.setRegistryName(power_tools.MODID, "bornite_block"));
		registry.register(bornite_slab.setRegistryName(power_tools.MODID, "bornite_slab"));
		registry.register(bornite_stairs.setRegistryName(power_tools.MODID, "bornite_stairs"));

	}
	
	@SubscribeEvent
	public static void registerBlockItem(Register<Item> event) {
		final IForgeRegistry<Item> registry = event.getRegistry();

		registry.register(new ModBlockItem(bornite_ore, ItemGroup.BUILDING_BLOCKS, ModItemGroup.POWER_TOOLS));
		registry.register(new ModBlockItem(bornite_block, ItemGroup.BUILDING_BLOCKS, ModItemGroup.POWER_TOOLS));
		registry.register(new ModBlockItem(bornite_slab, ItemGroup.BUILDING_BLOCKS, ModItemGroup.POWER_TOOLS));
		registry.register(new ModBlockItem(bornite_stairs, ItemGroup.BUILDING_BLOCKS, ModItemGroup.POWER_TOOLS));
	}

}
