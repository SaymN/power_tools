package ch.saymn.power_tools.init;

import ch.saymn.power_tools.power_tools;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;

public class ModTags {
	
	public static class Items {
		
		public static final Tag<Item> TUTORIAL = makeTag(power_tools.MODID, "tutorial");
		
		private static Tag<Item> makeTag(String modid, String name) {
			return new ItemTags.Wrapper(new ResourceLocation(modid, name));
		}
	}
	
	public static class Blocks {
		
		public static final Tag<Block> TUTORIAL = makeTag(power_tools.MODID, "tutorial");
		
		private static Tag<Block> makeTag(String modid, String name) {
			return new BlockTags.Wrapper(new ResourceLocation(modid, name));
		}
	}

}
