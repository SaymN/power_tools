package ch.saymn.power_tools.block;

import net.minecraft.block.SlabBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class bornite_slab extends SlabBlock {

	public bornite_slab() {
		super(Properties
				.create(Material.IRON)
				.harvestTool(ToolType.PICKAXE)
				.hardnessAndResistance(5)
				.harvestLevel(2)
				.sound(SoundType.METAL)
			);
	}

}
