package ch.saymn.power_tools.item;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;

public class ModBlockItem extends BlockItem{

	public ModBlockItem(Block block, ItemGroup tab1, ItemGroup tab2) {
		super(block, new Properties().group(tab1).group(tab2));
		setRegistryName(block.getRegistryName());
	}

}
