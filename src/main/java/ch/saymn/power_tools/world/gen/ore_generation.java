package ch.saymn.power_tools.world.gen;

import ch.saymn.power_tools.config.oregen_config;
import ch.saymn.power_tools.init.ModBlocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig.FillerBlockType;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class ore_generation {
	
	public static void setupOreGeneration()
	{
		if(oregen_config.generate_overworld.get())
		{
			for(Biome biome : ForgeRegistries.BIOMES)
			{				
				biome.addFeature(Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(FillerBlockType.NATURAL_STONE, ModBlocks.bornite_ore.getDefaultState(), oregen_config.chance.get()), Placement.COUNT_RANGE, new CountRangeConfig(10, 20, 0, 100)));
			}
		}
	}
}
