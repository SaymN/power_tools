package ch.saymn.power_tools.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class bornite_block extends Block{

	public bornite_block() {
		super(Properties
				.create(Material.IRON)
				.harvestTool(ToolType.PICKAXE)
				.hardnessAndResistance(5)
				.harvestLevel(2)
			);
	}

}
