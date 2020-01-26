package ch.saymn.power_tools.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class bornite_ore extends Block{

	public bornite_ore() {
		super(Properties
				.create(Material.ROCK)
				.harvestTool(ToolType.PICKAXE)
				.hardnessAndResistance(5)
				.harvestLevel(2)
				.sound(SoundType.STONE)
			);
		
	}
}
