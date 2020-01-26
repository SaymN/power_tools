package ch.saymn.power_tools.data.provider;

import ch.saymn.power_tools.init.ModBlocks;
import ch.saymn.power_tools.init.ModItems;
import ch.saymn.power_tools.init.ModTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;

public class ModItemTagsProvider extends ItemTagsProvider{

	public ModItemTagsProvider(DataGenerator generator) {
		super(generator);
	}
	
	@Override
	protected void registerTags() {
		getBuilder(ModTags.Items.TUTORIAL)
		.add(ModItems.bornite_ingot)
		.add(ModBlocks.bornite_ore.asItem())
		.add(ModBlocks.bornite_block.asItem())
		.add(ModBlocks.bornite_stairs.asItem())
		.add(ModBlocks.bornite_slab.asItem());
	}

}
