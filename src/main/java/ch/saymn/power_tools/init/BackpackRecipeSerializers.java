package ch.saymn.power_tools.init;

import info.u_team.u_team_core.util.registry.BaseRegistryUtil;
import ch.saymn.power_tools.power_tools;
import ch.saymn.power_tools.recipe.BackpackCraftingRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(modid = power_tools.MODID, bus = Bus.MOD)
public class BackpackRecipeSerializers {
	
	public static final IRecipeSerializer<BackpackCraftingRecipe> BACKPACK = new BackpackCraftingRecipe.Serializer("crafting_backpack");
	
	@SubscribeEvent
	public static void register(Register<IRecipeSerializer<?>> event) {
		BaseRegistryUtil.getAllGenericRegistryEntriesAndApplyNames(power_tools.MODID, IRecipeSerializer.class).forEach(event.getRegistry()::register);
	}
	
}