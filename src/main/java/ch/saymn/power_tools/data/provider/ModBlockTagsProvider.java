package ch.saymn.power_tools.data.provider;

import ch.saymn.power_tools.init.ModBlocks;
import ch.saymn.power_tools.init.ModTags;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;

public class ModBlockTagsProvider extends BlockTagsProvider{

	public ModBlockTagsProvider(DataGenerator generator) {
		super(generator);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void registerTags() {
		getBuilder(ModTags.Blocks.TUTORIAL)
		.add(ModBlocks.bornite_block)
		.add(ModBlocks.bornite_slab)
		.add(ModBlocks.bornite_stairs)
		.add(ModBlocks.bornite_ore);
	}

}
